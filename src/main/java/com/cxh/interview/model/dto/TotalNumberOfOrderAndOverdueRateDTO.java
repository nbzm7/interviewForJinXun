package com.cxh.interview.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TotalNumberOfOrderAndOverdueRateDTO {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
