package cn.iocoder.springboot.lab15.springdatajest;

import com.opglabel.springboot.lab01.jest.Application;
import com.opglabel.springboot.lab01.jest.dataobject.ESProductDO;
import com.opglabel.springboot.lab01.jest.repository.ProductRepository03;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RepositoryTest03 {

    @Autowired
    private ProductRepository03 productRepository03;
    @Test
    public void testSearch(){

        // 查找 cid为1 + 关键词 并按照id升序

        Page<ESProductDO> page = productRepository03.search(1, "技术",
                PageRequest.of(1, 10, Sort.Direction.ASC, "id"));
        System.out.println("总共页数："+page.getTotalPages()+",总共数据量："+page.getTotalElements());

    }
}
