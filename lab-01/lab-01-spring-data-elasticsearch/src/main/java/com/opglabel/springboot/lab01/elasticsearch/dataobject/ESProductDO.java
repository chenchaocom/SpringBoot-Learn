package com.opglabel.springboot.lab01.elasticsearch.dataobject;

import com.opglabel.springboot.lab01.jest.constant.FieldAnalyzer;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "product", // 索引名字
        type = "product",
        shards = 1,//分片数
        replicas = 1,//每个分区备份数
        refreshInterval ="-1"//刷新时间
)
public class ESProductDO {

    @Id
    private Integer id;

    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD,type = FieldType.Text)
    private String name;

   // 卖点
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD,type = FieldType.Text)
    private String sellPoint;

    // 描述
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD,type = FieldType.Text)
    private String description;

    // 分类id
    private Integer cid;

    // 分类名
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD,type = FieldType.Text)
    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
