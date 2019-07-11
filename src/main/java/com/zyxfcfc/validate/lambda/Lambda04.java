package com.zyxfcfc.validate.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/5 4:24 PM
 */
@Slf4j
public class Lambda04 {

    /**
     * @param
     * @return
     * @apiNote lambda 作为参数传递给方法
     * 如果有重载、多个，那个可以通过类型强转，或者入参
     */
    public static void main(String[] args) {
        engine((int x, int y) -> {
            return x + y;
        });
        engine((long x, long y) -> {
            return x - y;
        });
        engine((LongCalculator) (x, y) -> {
            return x % y;
        });
        LongCalculator longCalculator = (x, y) -> {
            return x * y;
        };
        engine(longCalculator);
    }

    private static void engine(Calculator calculator) {
        int x = 2, y = 4;
        int result = calculator.calc(x, y);
        log.info(String.valueOf(result));
    }

    private static void engine(LongCalculator calculator) {
        long x = 2, y = 4;
        long result = calculator.calculate(x, y);
        System.out.println(result);
    }

}

interface Calculator {
    int calc(int x, int y);
}

interface LongCalculator {
    long calculate(long x, long y);
}