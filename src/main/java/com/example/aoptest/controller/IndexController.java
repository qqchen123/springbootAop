package com.example.aoptest.controller;

import com.example.aoptest.entity.Owner;
import com.example.aoptest.mapper.OwnerMapper;
import com.example.aoptest.proxy.IndexPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private OwnerMapper ownerMapper;

    @GetMapping("/index")
    @IndexPermission
    public String index(){
        return "indexController index";
    }

    @GetMapping("/owner")
    public String owner(){
        List<Owner> owners = ownerMapper.selectList(null);
        owners.forEach(System.out::println);
        return "owners";
    }
}
