package com.example.aoptest.controller;

import com.example.aoptest.proxy.IndexPermission;
import com.example.aoptest.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: springbootAop
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2023/2/4 20:53
 */
@Slf4j
@RestController
@RequestMapping("/redist")
public class RedisTController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/index")
    public String myIndex() {
        redisUtil.set("name", "qqchen");
        String myName = (String) redisUtil.get("name");
        System.out.println(myName);
        return myName;
    }
}
