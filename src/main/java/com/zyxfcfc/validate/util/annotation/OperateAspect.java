package com.zyxfcfc.validate.util.annotation;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/9 2:18 PM
 */
@Aspect
@Component
@Slf4j
public class OperateAspect {

    @Pointcut("@annotation(com.zyxfcfc.validate.util.annotation.MyLog)")
    public void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        MyLog annotation = method.getAnnotation(MyLog.class);
        log.info("打印自定义注解：" + annotation.value() + " 前置日志");
    }
}
