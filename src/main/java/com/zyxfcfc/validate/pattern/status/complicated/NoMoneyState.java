package com.zyxfcfc.validate.pattern.status.complicated;

import lombok.extern.slf4j.Slf4j;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 4:48 PM
 */
@Slf4j
public class NoMoneyState implements State {

    private VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        log.info("投币成功");
        vendingMachine.setState(vendingMachine.getHasMoneyState());
    }

    @Override
    public void backMoney() {
        log.info("您未投币，想退钱？...");
    }

    @Override
    public void trunCrank() {
        log.info("您未投币，想拿东西么？...");
    }

    @Override
    public void dispendse() {
        throw new IllegalStateException("非法状态");
    }
}
