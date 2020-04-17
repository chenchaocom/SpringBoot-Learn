package com.opglabel.springboot.lab01.jest.repository;

import com.opglabel.springboot.lab01.jest.dataobject.ESPropductDO;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository02 extends ElasticsearchRepository<ESPropductDO,Integer> {

    ESPropductDO findByName(String name);


    Page<ESPropductDO> findByNameLike(String name);
}
