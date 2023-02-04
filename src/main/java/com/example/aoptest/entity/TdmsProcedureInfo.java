package com.example.aoptest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("TDMS_PROCEDURE_INFO")
public class TdmsProcedureInfo extends Model<TdmsProcedureInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 流程id
     */
      @TableId(value = "PROCEDURE_ID", type = IdType.AUTO)
    private BigDecimal procedureId;

    /**
     * 项目
     */
    @TableField("ITEM")
    private String item;

    /**
     * 结果
     */
    @TableField("RESULT")
    private String result;

    /**
     * 报告
     */
    @TableField("REPORT")
    private String report;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 状态
     */
    @TableField("STATUS")
    private String status;

    /**
     * 项目id
     */
    @TableField("PROJECT_ID")
    private BigDecimal projectId;

    /**
     * 分类id
     */
    @TableField("CATE_ID")
    private BigDecimal cateId;

    @TableField("CREATE_TIME")
    private Date createTime;

    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 是否删除（Y/N）
     */
    @TableField("IS_DELETE")
    private String isDelete;


    @Override
    public Serializable pkVal() {
        return this.procedureId;
    }

}
