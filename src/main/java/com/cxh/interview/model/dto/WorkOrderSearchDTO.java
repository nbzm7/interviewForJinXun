package com.cxh.interview.model.dto;

import com.cxh.interview.entity.QueryRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkOrderSearchDTO extends QueryRequest {
    private String orderNo;

    private Integer orderType;

    private String title;

    private Integer handleDeptId;

    private LocalDateTime createTimeStart;
    private LocalDateTime createTimeEnd;

    private LocalDateTime fenpaiTimeStart;
    private LocalDateTime fenpaiTimeEnd;
}
