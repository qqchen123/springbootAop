package com.example.aoptest.service.impl;

import com.alibaba.excel.EasyExcel;
import com.example.aoptest.entity.Address;
import com.example.aoptest.listener.ImportExcelListener;
import com.example.aoptest.mapper.AddressMapper;
import com.example.aoptest.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ejchen
 * @since 2022-09-03
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void importExcel(MultipartFile file) throws IOException {
        EasyExcel.read(
                file.getInputStream(),
                Address.class,
                new ImportExcelListener(addressMapper)
        ).sheet().headRowNumber(1).doRead();
    }
}
