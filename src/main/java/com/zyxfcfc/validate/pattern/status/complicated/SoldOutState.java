package com.zyxfcfc.validate.pattern.status.complicated;

import lombok.extern.slf4j.Slf4j;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 4:56 PM
 */
@Slf4j
public class SoldOutState implements State {

    private VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        log.info("投币失败，商品已售罄");
    }

    @Override
    public void backMoney() {
        log.info("您未投币，想退钱么？...");
    }

    @Override
    public void trunCrank() {
        log.info("商品售罄，转动手柄也木有用");
    }

    @Override
    public void dispendse() {
        throw new IllegalStateException("非法状态");
    }
}
