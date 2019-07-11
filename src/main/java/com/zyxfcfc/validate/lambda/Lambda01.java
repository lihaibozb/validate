package com.zyxfcfc.validate.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/5 3:35 PM
 */
@Slf4j
public class Lambda01 {
    public static void main(String[] args) {
        /**
         *  lambda表达式写法
         *  可以写成:
         *  i -> i * 2;
         *  (Integer i) -> i * 2;
         *  (i) -> i * 2;
         */
        MyIntegerCalcultor myIntegerCalcultor = (Integer i) ->
                i * 2;

        log.info(String.valueOf(myIntegerCalcultor.calcul(5)));
    }
}

interface MyIntegerCalcultor {
    Integer calcul(Integer integer);
}
