package com.test.jpa.business.controller;

import com.alibaba.fastjson.JSON;
import com.test.jpa.bean.User;
import com.test.jpa.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by fengrongze on 2017/11/21.
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    public String sayHello(){

        User su = new User();
        su.setName("zgongf");
        su.setEmail("zgongf@163.com");
        try{
            userService.save(su);
        }catch (Exception e){
            e.printStackTrace();
        }





        Iterable<User> users=userService.queryAllUser();
        users.forEach(v->{
            System.out.println(JSON.toJSONString(v));
        });

        System.out.println(">>>命名法查询某个人----------------------------");
        User user = userService.queryUserByName("frz");
        System.out.println(JSON.toJSONString(user));


        System.out.println(">>>自定义query查询某个人----------------------------");

         user = userService.queryUserByUserName("frz");
        System.out.println(JSON.toJSONString(user));


        return "Hello word";
    }
}
