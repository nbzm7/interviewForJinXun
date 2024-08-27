package com.cxh.interview.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;


@Data
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("dept_id")
    private Integer deptId;

    private String deptName;
}
