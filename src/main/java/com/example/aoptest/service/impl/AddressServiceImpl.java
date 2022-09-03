package com.example.aoptest.service.impl;

import com.example.aoptest.entity.Address;
import com.example.aoptest.mapper.AddressMapper;
import com.example.aoptest.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
