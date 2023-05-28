package com.example.aoptest.controller;

import com.example.aoptest.entity.Address;
import com.example.aoptest.mapper.AddressMapper;
import com.example.aoptest.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

//    @Autowired
//    private AddressMapper addressMapper;

    @Autowired
    private IAddressService addressService;

//    @GetMapping("/getAddress")
//    public String getAddress(){
//        List<Address> addresses = addressMapper.selectList(null);
//        addresses.forEach(System.out::println);
//        return "address";
//    }


    @PostMapping("/excel/import")
    public String importExcel(@RequestParam(name = "file")MultipartFile file) throws IOException {
        addressService.importExcel(file);
        return "success";
    }
}
