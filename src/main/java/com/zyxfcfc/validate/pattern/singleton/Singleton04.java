package com.zyxfcfc.validate.pattern.singleton;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/4 10:42 AM
 */
public class Singleton04 {

    private static final class InstanceHolder {
        private static final Singleton04 INSTANCE = new Singleton04();
    }

    public Singleton04 getInstance() {
        return InstanceHolder.INSTANCE;
    }

}
