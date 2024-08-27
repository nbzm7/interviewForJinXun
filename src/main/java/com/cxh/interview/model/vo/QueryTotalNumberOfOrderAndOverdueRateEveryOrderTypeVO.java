package com.cxh.interview.model.vo;

import lombok.Data;

@Data
public class QueryTotalNumberOfOrderAndOverdueRateEveryOrderTypeVO {

    private Integer orderType;
    private Integer totalOrders;
    private Double overdueRate;
}
