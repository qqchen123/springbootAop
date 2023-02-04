package com.example.aoptest.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2022/11/5 18:30
 */
@Data
public class ProcedureRowList {
    private String CateName;
    private List<ProcedureColList> procedureColLists;
}
