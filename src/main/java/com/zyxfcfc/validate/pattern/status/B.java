package com.zyxfcfc.validate.pattern.status;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 7:49 PM
 */
@Slf4j
public class B {

    public A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B(A a)
    {
        this.a= a;
        System.out.println("Creating B");
        log.info("1 A引用中B的值是null? {}", a.getB()==null?"yes":"no");
    }

}
