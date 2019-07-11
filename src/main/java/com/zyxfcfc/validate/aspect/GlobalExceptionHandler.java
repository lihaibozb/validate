package com.zyxfcfc.validate.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-06-27
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String myExceptionErrorHandler(Exception e) throws Exception {
        log.error("myExceptionErrorHandler info:{}", e.getMessage());
        return e.getMessage();
    }
}
