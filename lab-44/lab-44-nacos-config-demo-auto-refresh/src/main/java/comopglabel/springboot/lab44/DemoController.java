package comopglabel.springboot.lab44;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @NacosValue(value = "${test}",autoRefreshed = true)
    private String test;
    @GetMapping("/test")
    public String test(){
        return test;
    }


    @Value(value = "${test}")
    private String test1;
    @GetMapping("/test1")
    public String test1(){
        return test1;
    }

    @GetMapping("/logger")
    public void logger(){
        logger.info("[logger] 测试一下");
    }

}
