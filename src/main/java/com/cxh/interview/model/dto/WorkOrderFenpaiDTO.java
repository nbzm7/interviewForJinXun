package com.cxh.interview.model.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
public class WorkOrderFenpaiDTO {

    @NonNull
    private Integer orderId;

    @NonNull
    private Integer handleDeptId;

    @NotEmpty
    private String handleDeptName;

}
