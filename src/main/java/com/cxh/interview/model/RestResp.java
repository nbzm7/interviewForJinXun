package com.cxh.interview.model;

import com.cxh.interview.exception.ErrorCode;
import com.cxh.interview.exception.CommonErrorCode;
import lombok.Data;

@Data
public class RestResp<T> {

    /**
     * 成功代码
     */
    public static final int CODE_SUCCESS = 0;
    /**
     * 失败代码(大于0，默认为1)
     */
    public static final int CODE_FAILURE = 1;

    private Integer code;
    private T data;
    private String message = "ok";
    private Long timestamp;

    public RestResp() {
    }

    public RestResp(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public static RestResp ok(String msg) {
        return new RestResp(CODE_SUCCESS, msg, null);
    }

    public static RestResp success(String data) {
        return new RestResp(CODE_SUCCESS, "操作成功！", data);
    }

    public static <T> RestResp ok(T data) {
        return new RestResp(CODE_SUCCESS, "操作成功！", data);
    }

    public static <T> RestResp ok(String msg, T data) {
        return new RestResp(CODE_SUCCESS, msg, data);
    }

    public static <T> RestResp error(Integer code, String msg) {
        return new RestResp(code, msg, null);
    }

    public static RestResp error(ErrorCode code) {
        return error(code.getCode(), code.getErrorMsg());
    }

    public static RestResp error(CommonErrorCode code) {
        return error(code.getCode(), code.getErrorMsg());
    }

    public static RestResp ok() {
        return ok("操作成功！");
    }

    public static RestResp error() {
        return error(CommonErrorCode.INNER_ERROR);
    }

    public boolean isSuccess() {
        return this.code.equals(CODE_SUCCESS);
    }
}
