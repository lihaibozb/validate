package com.zyxfcfc.validate.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/5 4:18 PM
 */
@Slf4j
public class Lambda03 {

    /**
     * @apiNote 推断lambda表达式类型的过程称为目标类型。
     * 编译器使用以下规则来确定lambda表达式是否可分配给其目标类型：
     * 1.它必须是一个函数接口。
     * 2.lambda表达式的参数必须与函数接口中的抽象方法匹配。
     * 3.lambda表达式的返回类型与函数接口中抽象方法的返回类型兼容。
     * 4.从lambda表达式抛出的检查异常必须与函数接口中抽象方法的已声明的throws子句兼容。
     * @param 
     * @return 
     */
    public static void main(String[] args) {
        Precesser precesser = str -> str.length();
        Precesser2 precesser2 = str -> str.length();
        String s = "Java Lambda03";
        log.info(String.valueOf(precesser.getStringLength(s)));
        log.info(String.valueOf(precesser2.noName(s)));
    }

}

interface Precesser{
    int getStringLength(String str);
}
interface Precesser2{
    int noName(String str);
}
