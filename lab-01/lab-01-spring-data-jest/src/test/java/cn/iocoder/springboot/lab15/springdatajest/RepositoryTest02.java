package cn.iocoder.springboot.lab15.springdatajest;

import com.opglabel.springboot.lab01.jest.Application;
import com.opglabel.springboot.lab01.jest.dataobject.ESProductDO;
import com.opglabel.springboot.lab01.jest.repository.ProductRepository02;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RepositoryTest02 {

    @Autowired
    private ProductRepository02 productRepository02;


    @Test // 根据名字获取产品
    public void testFindByName(){
        ESProductDO esPropductDO = productRepository02.findByName("芋道源码");
        System.out.println(esPropductDO);
    }

    @Test
    public void testFundByNameLike(){

        if(true){
            testInsert();
        }

        // 创建排序条件
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        //设置分页
        Pageable pageable  = PageRequest.of(0, 10, sort);
        Page<ESProductDO> page = productRepository02.findByNameLike("芋道源码", pageable);
        System.out.println(page.getTotalPages());
        System.out.println(page.getTotalElements());
    }

    private void testInsert() {
        // 循环内不要不断创建对象引用
        ESProductDO product = null;
        for (int i = 0; i < 100; i++) {
            product = new ESProductDO();
            product.setId(i); // 一般 ES 的 ID 编号，使用 DB 数据对应的编号。这里，先写死
            product.setName("芋道源码：" + i);
            product.setSellPoint("愿半生编码，如一生老友");
            product.setDescription("我只是一个描述");
            product.setCid(1);
            product.setCategoryName("技术");
            productRepository02.save(product);
        }
    }
}
