package com.example.aoptest.service;

import com.example.aoptest.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ejchen
 * @since 2022-09-03
 */
public interface IAddressService extends IService<Address> {

    void importExcel(MultipartFile file) throws IOException;

}
