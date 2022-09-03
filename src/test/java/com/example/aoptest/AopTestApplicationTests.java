package com.example.aoptest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.aoptest.entity.Owner;
import com.example.aoptest.mapper.OwnerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AopTestApplicationTests {

    @Autowired
    private OwnerMapper ownerMapper;
    @Test
    void contextLoads() {
        LambdaQueryWrapper<Owner> lqw = new LambdaQueryWrapper<>();
//        lqw.lt(Owner::getID,10).gt(Owner::getID,5);
        lqw.gt(Owner::getID,10).or().lt(Owner::getID,5);
        List<Owner> ownerList = ownerMapper.selectList(lqw);
        ownerList.forEach(System.out::println);

    }

}
