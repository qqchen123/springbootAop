package com.example.aoptest.mapper;

import com.example.aoptest.entity.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ejchen
 * @since 2022-09-03
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    @Async
    void batchInsertData(List<Address> addressList);

}
