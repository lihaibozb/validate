package com.zyxfcfc.validate.pattern.status;

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
public class A {

    public B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A()
    {
        System.out.println(this.getB());
        System.out.println(this.hashCode());

        b = new B(this);
        System.out.println("Creating A");
        log.info("2 B中A的值为null? {}", b.getA()==null?"yes":"no");
    }

    public static void main(String[] args)
    {
        A a = new A();
        log.info("3 A引用中B的值是null? {}", a.getB()==null?"yes":"no");
        log.info("4 B中A的值为null? {}", a.getB().getA()==null?"yes":"no");
        System.out.println(a.hashCode());
    }

}
