package com.example.aoptest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2022/9/2 21:52
 */
@Data
@TableName("T_OWNERS")
public class Owner {
    private Integer ID;
    private String name;
    private Integer addressid;
    private String housenumber;
    private String watermeter;
    private Date adddate;
    private Integer ownertypeid;
}
