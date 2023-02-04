package com.example.aoptest.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2022/11/5 17:19
 */

@Data
public class ProcedureInfoVo {
    private String CateName;

    private List<List<ProcedureInfoAndCate>> pIRowList;
}
