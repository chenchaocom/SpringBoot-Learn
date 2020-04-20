package cn.iocoder.springboot.lab15.springdataelasticsearch.repository;

import com.opglabel.springboot.lab01.elasticsearch.Application;
import com.opglabel.springboot.lab01.elasticsearch.bo.ProductConditionBO;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductRepositoryTest04 {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public void test(){

        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder().withIndices("product");

        //查询条件
        builder.withQuery(QueryBuilders.multiMatchQuery("芋道",
                "name","sellPoint","categoryName"));

        //设置聚合
        builder.addAggregation(AggregationBuilders.terms("cids").field("cid"));

        //执行查询
        ProductConditionBO productConditionBO = elasticsearchTemplate.query(builder.build(), response -> {
            ProductConditionBO result = new ProductConditionBO();


            Aggregation categoryAggregation = response.getAggregations().get("cids");
            if(categoryAggregation != null){
                result.setCategories(new ArrayList<>());
                for (LongTerms.Bucket bucket : ((LongTerms)categoryAggregation).getBuckets()) {
                    ProductConditionBO.Category category = new ProductConditionBO.Category();
                    category.setId(bucket.getKeyAsNumber().intValue());
                    result.getCategories().add(category);
                }
            }
            return result;
        });
        // 后续遍历 condition.categories 数组，查询商品分类，设置商品分类名。



    }

}
