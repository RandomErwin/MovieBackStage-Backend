package org.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.dto.Result;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/test")
    public Result test(){
        System.out.println(456);
        return new Result();
    }

    @GetMapping("/test")
    public Result tested(){
        System.out.println(123);
        return new Result(200, "success");
    }

    @GetMapping("/createUser")
    public Result createUser(){
        System.out.println(456);
        return new Result();
    }







}
