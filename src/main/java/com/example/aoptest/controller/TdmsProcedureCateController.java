package com.example.aoptest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ejchen
 * @since 2022-11-05
 */
@RestController
@RequestMapping("/tdms-procedure-cate")
public class TdmsProcedureCateController {

    @GetMapping("/cateList")
    public String cateList(){
        return "123";
    }

}
