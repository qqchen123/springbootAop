package com.example.aoptest.service.impl;

import com.example.aoptest.entity.TdmsProcedureInfo;
import com.example.aoptest.mapper.TdmsProcedureInfoMapper;
import com.example.aoptest.service.ITdmsProcedureInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ejchen
 * @since 2022-11-05
 */
@Service
public class TdmsProcedureInfoServiceImpl extends ServiceImpl<TdmsProcedureInfoMapper, TdmsProcedureInfo> implements ITdmsProcedureInfoService {

}
