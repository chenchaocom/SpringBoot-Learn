package com.opglabel.springboot.lab01.jest.repository;

import com.opglabel.springboot.lab01.jest.dataobject.ESPropductDO;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.util.StringUtils;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

public interface ProductRepository03 extends ElasticsearchRepository<ESPropductDO,Integer> {

    default Page<ESPropductDO> search(Integer cid, String keyword, Pageable pageable){

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        if(cid != null){
            nativeSearchQueryBuilder.withFilter(QueryBuilders.termQuery("cid",cid));
        }

        //帅选
        if(StringUtils.hasText(keyword)){

            FunctionScoreQueryBuilder.FilterFunctionBuilder[] functionBuilders ={

                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(matchQuery("name",keyword),
                            ScoreFunctionBuilders.weightFactorFunction(10)
                    ),
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(matchQuery("sellPoint",keyword),
                            ScoreFunctionBuilders.weightFactorFunction(3)
                    ),
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(matchQuery("categoryName", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(3))
            };


            FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(functionBuilders).
                    setMinScore(2f)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM);

            nativeSearchQueryBuilder.withQuery(functionScoreQueryBuilder);
        }

        //排序
        if(StringUtils.hasText(keyword)){//关键字使用打分
            nativeSearchQueryBuilder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC));
        } else if(pageable.getSort().isSorted()){
            pageable.getSort().get().forEach(sortField -> {
                nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort(sortField.getProperty()).
                        order(sortField.getDirection().isAscending() ? SortOrder.ASC : SortOrder.DESC)
                );
            });
        }else{
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC));
        }
        //分页
        nativeSearchQueryBuilder.withPageable(PageRequest.of(pageable.getPageNumber(),pageable.getPageSize()));
        //查询
        return search(nativeSearchQueryBuilder.build());

    }

}
