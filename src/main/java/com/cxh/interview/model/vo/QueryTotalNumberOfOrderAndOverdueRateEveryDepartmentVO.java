package com.cxh.interview.model.vo;

import lombok.Data;

@Data
public class QueryTotalNumberOfOrderAndOverdueRateEveryDepartmentVO {
    private String departmentName;
    private Integer totalOrders;
    private Double overdueRate;
}
