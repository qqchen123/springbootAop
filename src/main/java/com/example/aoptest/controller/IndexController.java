package com.example.aoptest.controller;

import com.example.aoptest.entity.Owner;
import com.example.aoptest.entity.query.City;
import com.example.aoptest.mapper.OwnerMapper;
import com.example.aoptest.proxy.IndexPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private OwnerMapper ownerMapper;

    @PostMapping("/index")
    @IndexPermission
    public String index(@RequestBody City city){
        System.out.println(city);
        return "indexController index";
    }

    @GetMapping("/owner")
    public String owner(){
        List<Owner> owners = ownerMapper.selectList(null);
        owners.forEach(System.out::println);
        return "owners";
    }

}
