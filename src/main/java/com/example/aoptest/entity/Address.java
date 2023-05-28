package com.example.aoptest.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
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

    @ExcelIgnore
    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal id;

    @ColumnWidth(30)
    @ExcelProperty("地址名称")
    @TableField("NAME")
    private String name;

    @ColumnWidth(20)
    @ExcelProperty("地区id")
    @TableField("AREAID")
    private BigDecimal areaid;

    @ColumnWidth(20)
    @ExcelProperty("管理者id")
    @TableField("OPERATORID")
    private BigDecimal operatorid;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
