package com.example.aoptest.controller;

import com.example.aoptest.proxy.IndexPermission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/index")
    @IndexPermission
    public String index(){
        return "indexController index";
    }
}
