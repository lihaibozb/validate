package com.zyxfcfc.validate.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BooleanSupplier;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/5 3:59 PM
 */
@Slf4j
public class Lambda02 {

    /**
     * @apiNote 无参lambda
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        BooleanSupplier booleanSupplier = () -> true;
        log.info(String.valueOf(booleanSupplier.getAsBoolean()));
    }

}