package com.zyxfcfc.validate.pattern.status.complicated;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 4:55 PM
 */
@Slf4j
public class HasMoneyState implements State {

    private final Random random = new Random();
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        log.info("您已经投过币了，无需再投....");
    }

    @Override
    public void backMoney() {
        log.info("退币成功");
        vendingMachine.setState(vendingMachine.getNoMoneyState());
    }

    @Override
    public void trunCrank() {
        log.info("您转动了手柄");
        int winner = random.nextInt(10);
        if (winner == 0 && vendingMachine.getCount() > 0) {
            vendingMachine.setState(vendingMachine.getWinnerState());
        } else {
            vendingMachine.setState(vendingMachine.getSoldState());
        }
        vendingMachine.getCurrentState().dispendse();
    }

    @Override
    public void dispendse() {
        throw new IllegalStateException("非法状态");
    }

}
