package com.opglabel.springcloud.labx04.controller;

import com.opglabel.springcloud.labx04.dto.UserAddDTO;
import com.opglabel.springcloud.labx04.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName("姓名"+id);
        userDTO.setGender(id % 2 + 1);
        System.out.println("查询成功");
        return userDTO;
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return (int) (System.currentTimeMillis() / 1000); // 嘿嘿，随便返回一个 id
    }

}
