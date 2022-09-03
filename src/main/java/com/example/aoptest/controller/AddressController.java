package com.example.aoptest.controller;

import com.example.aoptest.entity.Address;
import com.example.aoptest.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ejchen
 * @since 2022-09-03
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressMapper addressMapper;

    @GetMapping("/getAddress")
    public String getAddress(){
        List<Address> addresses = addressMapper.selectList(null);
        addresses.forEach(System.out::println);
        return "address";
    }
}
