package com.opglabel.springboot.lab47;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "yunai.server")
public class YunaiServerProperties {
    private static final Integer DEFAULT_PORT = 8080;

    private Integer port = DEFAULT_PORT;

    public YunaiServerProperties setPort(Integer port) {
        this.port = port;
        return this;
    }

    public Integer getPort() {
        return port;
    }
}
