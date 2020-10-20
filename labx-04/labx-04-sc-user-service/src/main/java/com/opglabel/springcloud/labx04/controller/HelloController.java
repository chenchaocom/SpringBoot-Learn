package com.opglabel.springcloud.labx04.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public String say(){
        System.out.println("master");
        return "SUCCESS";
    }
}
