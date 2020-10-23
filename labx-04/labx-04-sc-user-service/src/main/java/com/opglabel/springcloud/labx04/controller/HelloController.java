package com.opglabel.springcloud.labx04.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    public String say(){
        System.out.println("master修改1212");
        System.out.println("master修改1213");
        return "SUCCESS";
    }


    public static void main(String[] args) throws InterruptedException {

        Map<String,String> map = new HashMap<String, String>();

        for(int i = 0;i<40000;i++){
            map.put("1001"+i,"Umai:PROG/4336301@BESTV.SMG.SMG");
        }
        System.out.println("aa");
        Thread.sleep(10000L);

    }
}
