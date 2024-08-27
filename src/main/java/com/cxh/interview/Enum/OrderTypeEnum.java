package com.cxh.interview.Enum;

import lombok.Getter;

@Getter
public enum OrderTypeEnum {
    ASSIGN(0),
    DIRECT_REPLY(1),
    INVALID_WORK_ORDER(2);

    private final int value;

    OrderTypeEnum(int value) {
        this.value = value;
    }

    public static boolean isValid(int value) {
        for (OrderTypeEnum status : OrderTypeEnum.values()) {
            if (status.getValue() == value) {
                return true;
            }
        }
        return false;
    }
}
