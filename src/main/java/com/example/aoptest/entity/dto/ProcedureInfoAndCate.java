package com.example.aoptest.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2022/11/5 16:27
 */
@Data
public class ProcedureInfoAndCate {
    /**
     * 流程id
     */
    private BigDecimal procedureId;

    /**
     * 项目
     */
    private String item;

    /**
     * 项目id
     */
    private BigDecimal projectId;

    /**
     * 分类id
     */
    private BigDecimal cateId;


    private String cateName;

    private BigDecimal pCateId;

    private String pCateName;
}
