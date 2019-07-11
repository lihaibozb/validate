package com.zyxfcfc.validate.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/4 10:40 AM
 */
@Slf4j
public enum Singleton03 {

    /**
     *
     */
    INSTANCE;

    private final String param;

    private Singleton03() {
        param = "123";
    }

    private String getInstance() {
        return param;
    }

    public static void main(String[] args) {
        log.info(Singleton03.INSTANCE.getInstance());
    }
}
