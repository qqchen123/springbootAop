package com.example.aoptest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author ejchen
 * @since 2022-09-03
 */
@Getter
@Setter
@TableName("T_ADDRESS")
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal id;

    @TableField("NAME")
    private String name;

    @TableField("AREAID")
    private BigDecimal areaid;

    @TableField("OPERATORID")
    private BigDecimal operatorid;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
