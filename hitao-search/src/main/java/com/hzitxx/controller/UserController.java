package com.hzitxx.controller;

import com.hzitxx.dao.UserDao;
import com.hzitxx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserDao userDao;

    @GetMapping("/test")
    public String test(){
        User user = new User(1,"张三");
        userDao.save(user);
        return "test";
    }

    @GetMapping("/get")
    public Object get(){
        return userDao.findAll();
    }


}
