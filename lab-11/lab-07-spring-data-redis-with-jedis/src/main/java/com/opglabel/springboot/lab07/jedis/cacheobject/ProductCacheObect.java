package com.opglabel.springboot.lab07.jedis.cacheobject;

/**
 * 商品缓存对象
 */
public class ProductCacheObect {
    // 产品编号
    private Integer id;

    // 产品名称
    private String name;

    // 产品分类编号
    private Integer cid;

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
