package com.cxh.interview.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class BusinessException extends RuntimeException {
    private Integer code;
    private String errMsg;
    private String serverName;

    public BusinessException(Integer code, String errMsg) {
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
        log.error("发生业务异常 code:{} msg:{}", this.code, this.errMsg);
    }
}
