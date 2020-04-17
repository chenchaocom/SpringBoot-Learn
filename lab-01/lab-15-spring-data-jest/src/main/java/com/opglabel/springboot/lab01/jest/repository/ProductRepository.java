package com.opglabel.springboot.lab01.jest.repository;

import com.opglabel.springboot.lab01.jest.dataobject.ESPropductDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ESPropductDO,Integer> {
}
