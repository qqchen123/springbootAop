package com.example.aoptest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.aoptest.entity.TdmsProcedureCate;
import com.example.aoptest.entity.TdmsProcedureInfo;
import com.example.aoptest.entity.dto.ProcedureColList;
import com.example.aoptest.entity.dto.ProcedureInfoAndCate;
import com.example.aoptest.entity.dto.ProcedureInfoVo;
import com.example.aoptest.entity.dto.ProcedureRowList;
import com.example.aoptest.mapper.TdmsProcedureCateMapper;
import com.example.aoptest.mapper.TdmsProcedureInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ejchen
 * @since 2022-11-05
 */
@RestController
@RequestMapping("/tdms-procedure-info")
public class TdmsProcedureInfoController {
    @Autowired
    private TdmsProcedureInfoMapper tdmsProcedureInfoMapper;

    @Autowired
    private TdmsProcedureCateMapper tdmsProcedureCateMapper;

    @GetMapping("/info")
    public List<ProcedureRowList> info() {
        List<ProcedureInfoAndCate> infoAndCateByProjectId = tdmsProcedureInfoMapper.getProcedureInfoAndCateByProjectId(63);
        List<String> pCateNameList = infoAndCateByProjectId.stream().map(res -> res.getPCateName()).distinct().collect(Collectors.toList());
        List<String> cateNameList = infoAndCateByProjectId.stream().map(res -> res.getCateName()).distinct().collect(Collectors.toList());

        List<ProcedureRowList> procedureRowLists = new ArrayList<>();
        cateNameList.forEach(cate->{
            ProcedureRowList procedureRowList = new ProcedureRowList();
            procedureRowList.setCateName(cate);

            List<ProcedureColList> procedureColLists = new ArrayList<>();
            pCateNameList.forEach(pCate->{
                List<ProcedureInfoAndCate> colList = infoAndCateByProjectId.stream().filter(ic -> ic.getCateName().equals(cate) && ic.getPCateName().equals(pCate)).collect(Collectors.toList());
                ProcedureColList procedureColList = new ProcedureColList();
                procedureColList.setCateName(pCate);
                procedureColList.setProcedureInfoAndCateList(colList);
                procedureColLists.add(procedureColList);
            });
            procedureRowList.setProcedureColLists(procedureColLists);
            procedureRowLists.add(procedureRowList);
        });


        return procedureRowLists;
    }
}
