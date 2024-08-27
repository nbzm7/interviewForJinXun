package com.cxh.interview.model.dto;

import com.cxh.interview.Enum.OrderTypeEnum;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

@Data
public class WorkOrderSaveDTO {

    private Integer orderType;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @AssertTrue(message = "The value must be 0, 1, or 2")
    public boolean isValidOrderType() {
        return OrderTypeEnum.isValid(this.orderType);
    }
}
