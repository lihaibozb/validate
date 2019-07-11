package com.zyxfcfc.validate.pattern.singleton;

import sun.security.jca.GetInstance;

/**
 * description: 懒汉模式
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/4 10:34 AM
 */
public class Singleton02 {

    private static Singleton02 instance;

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        if (instance != null) {
            synchronized (Singleton02.class) {
                if (instance != null) {
                    instance = new Singleton02();
                }
            }
        }
        return instance;
    }

}
