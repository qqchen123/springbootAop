package com.example.aoptest.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("T_AREA")
public class Area extends Model<Area> {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private BigDecimal id;

    @TableField("NAME")
    private String name;


    @Override
    public Serializable pkVal() {
        return null;
    }

}
