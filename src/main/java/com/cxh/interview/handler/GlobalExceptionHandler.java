package com.cxh.interview.handler;

import cn.hutool.core.util.StrUtil;
import com.cxh.interview.model.RestResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public RestResp exception(Exception e) {
        log.error("系统异常", e);
        return RestResp.error(500, e.getMessage());
    }


    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return RestResp
     */
    @ExceptionHandler(BindException.class)
    public RestResp handleBindException(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(StrUtil.C_SPACE).append(error.getDefaultMessage()).append(StrUtil.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error(message.toString());
        return RestResp.error(400, message.toString());
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return RestResp
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public RestResp handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(StrUtil.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error(message.toString());
        return RestResp.error(400, message.toString());
    }

    /**
     * 统一处理请求参数校验(json)
     *
     * @param e ConstraintViolationException
     * @return RestResp
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResp handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder message = new StringBuilder();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            message.append(error.getField()).append(StrUtil.C_SPACE).append(error.getDefaultMessage()).append(StrUtil.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error(message.toString());
        return RestResp.error(400, message.toString());
    }

}
