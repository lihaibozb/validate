package com.zyxfcfc.validate.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/5 5:30 PM
 */
public class Lambda05 {

    public static void main(String[] args) {
        // Using  a  lambda  expression
        Function<Integer, String> func1  = x -> Integer.toBinaryString(x);
        System.out.println(func1.apply(10));

        // Using  a  method  reference
        Function<Integer, String> func2  = Integer::toBinaryString;
        System.out.println(func2.apply(10));

        // Uses a lambda expression
        BiFunction<Integer, Integer, Integer> bfunc1 = (x, y) -> Integer.sum(x, y);
        System.out.println(bfunc1.apply(2, 3));

        // Uses a method reference
        BiFunction<Integer, Integer, Integer> bfunc2 = Integer::sum;
        System.out.println(bfunc2.apply(2, 3));
    }

}
