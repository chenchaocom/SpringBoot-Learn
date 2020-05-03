package comopglabel.springboot.lab44.autorefresh;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@NacosConfigurationProperties(prefix = "",dataId = "${nacos.config.data-id}",type = ConfigType.PROPERTIES,autoRefreshed = true)
public class TestProperties {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
