package com.opglabel.springcloud.labx08.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

@RestController
public class FallbackController {

    private static final Logger logger = LoggerFactory.getLogger(FallbackController.class);
    @RequestMapping("/fallback")
    public String fallback(ServerWebExchange serverWebExchange){

        Throwable executionException = serverWebExchange.getAttribute(ServerWebExchangeUtils.HYSTRIX_EXECUTION_EXCEPTION_ATTR);
        logger.error("[fallback][发生异常]"+executionException);
        return "服务降级"+executionException.getMessage();


    }
}
