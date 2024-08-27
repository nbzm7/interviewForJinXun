package com.cxh.interview.model.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QueryTotalNumberOfOrderAndOverdueRateEveryDayVO {

    private LocalDate time;
    private Integer totalOrders;
    private Integer overdueRate;
}
