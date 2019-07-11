package com.zyxfcfc.validate.pattern.status.simple;


import lombok.extern.slf4j.Slf4j;

/**
 * description:  https://blog.csdn.net/lmj623565791/article/category/2206597
 *
 * @author lihaibo
 * @date 2019/7/3 3:49 PM
 * @version 1.0.0
 */
@Slf4j
public class TestTra {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(10);
        vendingMachine.insertMoney();
        vendingMachine.backMoney();
        log.info("-------------");

        vendingMachine.insertMoney();
        vendingMachine.trunCrank();

        vendingMachine.insertMoney();
        vendingMachine.insertMoney();
        vendingMachine.trunCrank();
        vendingMachine.trunCrank();
        vendingMachine.backMoney();
        vendingMachine.trunCrank();
    }

}
