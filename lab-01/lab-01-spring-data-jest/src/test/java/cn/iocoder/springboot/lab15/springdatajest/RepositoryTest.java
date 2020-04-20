package cn.iocoder.springboot.lab15.springdatajest;

import com.opglabel.springboot.lab01.jest.Application;
import com.opglabel.springboot.lab01.jest.dataobject.ESProductDO;
import com.opglabel.springboot.lab01.jest.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test  // 测试插入一条数据
    public void testInsert(){
        ESProductDO product = new ESProductDO();
        product.setId(1); // 一般 ES 的 ID 编号，使用 DB 数据对应的编号。这里，先写死
        product.setName("芋道源码");
        product.setSellPoint("愿半生编码，如一生老友");
        product.setDescription("我只是一个描述");
        product.setCid(1);
        product.setCategoryName("技术");
        productRepository.save(product);

    }

    // save 方法进行更新必须是全量字段，否则其他字段会被覆盖
    @Test
    public void testUpdate(){
        ESProductDO product = new ESProductDO();
        product.setId(1);
        product.setCid(2);
        product.setCategoryName("技术-Java");
        productRepository.save(product);
    }

    //删除一条记录
    @Test
    public void deleteById(){
        productRepository.deleteById(1);
    }

    // 查询一条记录
    @Test
    public void testSelectById(){
        Optional<ESProductDO> esPropductDO = productRepository.findById(1);
        System.out.println(esPropductDO);
    }


    // 根据数组编号 查询多条记录
    @Test
    public void testSelectByIds(){
        Iterable<ESProductDO> esPropductDOS = productRepository.findAllById(Arrays.asList(1, 2));
        esPropductDOS.forEach(System.out::println);
    }

}
