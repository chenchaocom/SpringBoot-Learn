package com.opglabel.springboot.lab01.jest.repository;

import com.opglabel.springboot.lab01.jest.dataobject.ESProductDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository02 extends ElasticsearchRepository<ESProductDO,Integer> {

    ESProductDO findByName(String name);


    Page<ESProductDO> findByNameLike(String name, Pageable pageable);
}
