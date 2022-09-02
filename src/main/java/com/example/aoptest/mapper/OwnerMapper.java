package com.example.aoptest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.aoptest.entity.Owner;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2022/9/2 21:55
 */

@Mapper
public interface OwnerMapper extends BaseMapper<Owner> {
}
