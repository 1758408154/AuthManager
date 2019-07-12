package com.changes.controller;

import com.changes.bean.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuJunJie
 * @since 2019/7/1 9:41
 */
@RestController
public class TestEndpoints {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id){
        return "product id:"+id;
    }


    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id){
        return "order id:"+id;
    }

    @PostMapping(value = "/order/getUser")
    public User getUser(@RequestBody User user){
        return user;
    }
}
