package com.zyxfcfc.validate.pattern.status.complicated;

import lombok.extern.slf4j.Slf4j;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 4:57 PM
 */
@Slf4j
public class WinnerState implements State {

    private VendingMachine vendingMachine;

    public WinnerState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        log.info("非法状态");
    }

    @Override
    public void backMoney() {
        log.info("非法状态");
    }

    @Override
    public void trunCrank() {
        log.info("非法状态");
    }

    @Override
    public void dispendse() {
        log.info("你中奖了，恭喜你，将得到2件商品");
        vendingMachine.dispendse();

        if (vendingMachine.getCount() == 0) {
            log.info("商品已经售罄");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        } else {
            vendingMachine.dispendse();
            if (vendingMachine.getCount() > 0) {
                vendingMachine.setState(vendingMachine.getNoMoneyState());
            } else {
                log.info("商品已经售罄");
                vendingMachine.setState(vendingMachine.getSoldOutState());
            }

        }
    }
}
