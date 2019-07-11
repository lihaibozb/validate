package com.zyxfcfc.validate.pattern.status.complicated;

/**
 * description: https://blog.csdn.net/lmj623565791/article/category/2206597
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 5:44 PM
 */
public class Test {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(10);
        machine.insertMoney();
        machine.backMoney();

        System.out.println("----我要中奖----");

        machine.insertMoney();
        machine.trunCrank();
        machine.insertMoney();
        machine.trunCrank();
        machine.insertMoney();
        machine.trunCrank();
        machine.insertMoney();
        machine.trunCrank();
        machine.insertMoney();
        machine.trunCrank();
        machine.insertMoney();
        machine.trunCrank();
        machine.insertMoney();
        machine.trunCrank();

        System.out.println("-------压力测试------");

        machine.insertMoney();
        machine.backMoney();
        machine.backMoney();
        machine.trunCrank();// 无效操作
        machine.trunCrank();// 无效操作
        machine.backMoney();

    }
}
