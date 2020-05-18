package com.opglabel.springcloud.labx05.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        throw e;
    }

    @Component
    @ControllerAdvice(basePackages = "com.opglabel.springcloud.labx05.controller")
    public class GlobalExceptionHandler{

        @ResponseBody
        @ExceptionHandler(BlockException.class)
        public JSONObject blockExceptionHandler(BlockException blockException){
            return new JSONObject().fluentPut("code",1024)
                    .fluentPut("msg","请求被拦截，拦截类型为："+blockException.getClass().getSimpleName());
        }
    }
}
