package com.zyxfcfc.validate.pattern.singleton;

/**
 * description: 恶汉模式
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/4 10:32 AM
 */
public class Singleton {

    private final static Singleton SINGLETON = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SINGLETON;
    }

}
