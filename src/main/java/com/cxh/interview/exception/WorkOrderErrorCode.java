package com.cxh.interview.exception;

public enum WorkOrderErrorCode implements ErrorCode {

    WORK_ORDER_NOT_EXISTS(10000,"工单不存在"),
    INNER_ERROR(500, "系统内部错误:{0}");

    private int code;
    private String errorMsg;

    WorkOrderErrorCode(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

}
