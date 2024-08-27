package com.cxh.interview.model.dto;

import lombok.Data;
import lombok.NonNull;


@Data
public class WorkOrderUpdateDTO {

    @NonNull
    private Integer id;

    private Integer orderType;

    private String title;

    private String content;

}
