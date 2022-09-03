package com.example.aoptest.service.impl;

import com.example.aoptest.entity.Area;
import com.example.aoptest.mapper.AreaMapper;
import com.example.aoptest.service.IAreaService;
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
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService {

}
