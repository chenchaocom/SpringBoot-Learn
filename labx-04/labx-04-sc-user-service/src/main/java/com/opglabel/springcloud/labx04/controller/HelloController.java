package com.opglabel.springcloud.labx04.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public String say(){
        System.out.println("master修改1212");
        System.out.println("master修改1213");
        return "SUCCESS";
    }
}
