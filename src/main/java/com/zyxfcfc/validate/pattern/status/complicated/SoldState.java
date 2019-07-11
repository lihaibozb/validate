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
public class SoldState implements State {

    private VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        log.info("正在出货，请勿投币");
    }

    @Override
    public void backMoney() {
        log.info("正在出货，没有可退的钱");
    }

    @Override
    public void trunCrank() {
        log.info("正在出货，请勿重复转动手柄");
    }

    @Override
    public void dispendse() {
        vendingMachine.dispendse();
        if (vendingMachine.getCount() > 0) {
            vendingMachine.setState(vendingMachine.getNoMoneyState());
        } else {
            log.info("商品已售罄");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        }
    }
}
