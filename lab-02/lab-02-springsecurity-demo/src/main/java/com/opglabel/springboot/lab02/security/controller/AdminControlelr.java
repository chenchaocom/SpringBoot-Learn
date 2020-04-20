package com.opglabel.springboot.lab02.security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminControlelr {

    @GetMapping("/demo")
    public String demo(){
        return "hello world";
    }
}
