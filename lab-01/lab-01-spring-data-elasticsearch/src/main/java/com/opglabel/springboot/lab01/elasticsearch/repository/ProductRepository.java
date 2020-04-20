package com.opglabel.springboot.lab01.elasticsearch.repository;

import com.opglabel.springboot.lab01.elasticsearch.dataobject.ESProductDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ESProductDO,Integer> {
}
