package com.zyxfcfc.validate.util.annotation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import java.lang.annotation.RetentionPolicy;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/9 2:14 PM
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    String value();

}
