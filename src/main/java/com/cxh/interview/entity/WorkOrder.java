package com.cxh.interview.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Data
@TableName("work_order")
@Accessors(chain = true)
public class WorkOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String orderNo;

    private Integer orderType;

    private String title;

    private String content;

    private Integer handleDeptId;

    private LocalDateTime createTime;

    private LocalDateTime fenpaiTime;

    private Integer isOverdue;
}
