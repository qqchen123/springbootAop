package com.example.aoptest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ejchen
 * @since 2022-11-05
 */
@Getter
@Setter
@TableName("TDMS_PROCEDURE_CATE")
public class TdmsProcedureCate extends Model<TdmsProcedureCate> {

    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
      @TableId(value = "CATE_ID", type = IdType.AUTO)
    private Long cateId;

    /**
     * 分类名称
     */
    @TableField("CATE_NAME")
    private String cateName;

    /**
     * 父分类id
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 是否删除（Y/N）
     */
    @TableField("IS_DELETE")
    private String isDelete;

    @TableField("CREATE_TIME")
    private Date createTime;

    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 数据来源
     */
    @TableField("TABLE_INFO")
    private String tableInfo;


    @Override
    public Serializable pkVal() {
        return this.cateId;
    }

}
