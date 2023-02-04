package com.example.aoptest.mapper;

import com.example.aoptest.entity.TdmsProcedureInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.aoptest.entity.dto.ProcedureInfoAndCate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ejchen
 * @since 2022-11-05
 */
@Mapper
public interface TdmsProcedureInfoMapper extends BaseMapper<TdmsProcedureInfo> {

    public List<ProcedureInfoAndCate> getProcedureInfoAndCateByProjectId(Integer projectId);


}
