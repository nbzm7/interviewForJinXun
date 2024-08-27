package com.cxh.interview.exception;

public enum CommonErrorCode implements ErrorCode {

    NO_SESSION(401, "未授权的访问！"),
    INNER_ERROR(500, "系统内部错误"),
    PARAMS_ERROR(600, "请求参数错误");

    private int code;
    private String errorMsg;

    CommonErrorCode(int code, String errorMsg) {
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
