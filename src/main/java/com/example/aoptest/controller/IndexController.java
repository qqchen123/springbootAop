package com.example.aoptest.controller;

import com.example.aoptest.entity.Owner;
import com.example.aoptest.entity.query.City;
import com.example.aoptest.mapper.OwnerMapper;
import com.example.aoptest.proxy.IndexPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private OwnerMapper ownerMapper;

    @PostMapping("/index")
    @IndexPermission
    public String index(@RequestBody City city){
        System.out.println(city);
        log.info(city.toString());
        return "indexController index";
    }

    @GetMapping("/myIndex")
    @IndexPermission
    public String myIndex(){
        log.info("my index");
        log.error("my Index error");
        return "indexController index 1231234444555";
    }

    @GetMapping("/owner")
    public String owner(){
        List<Owner> owners = ownerMapper.selectList(null);
        owners.forEach(System.out::println);
        return "owners";
    }

}
