package com.zyxfcfc.validate.pattern.status.complicated;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 4:48 PM
 */
@Data
@Slf4j
public class VendingMachine implements State {
    private final NoMoneyState noMoneyState;
    private final HasMoneyState hasMoneyState;
    private final SoldOutState soldOutState;
    private final SoldState soldState;
    private final WinnerState winnerState;

    private int count = 0;
    private State currentState = null;

    public VendingMachine(int count) {
        this.noMoneyState = new NoMoneyState(this);
        this.hasMoneyState = new HasMoneyState(this);
        this.soldOutState = new SoldOutState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);
        if (count > 0) {
            this.count = count;
            this.currentState = noMoneyState;
        }
    }


    public void setState(State state) {
        this.currentState = state;
    }

    @Override
    public void insertMoney() {
        this.currentState.insertMoney();
    }

    @Override
    public void backMoney() {
        this.currentState.backMoney();
    }

    @Override
    public void trunCrank() {
        this.currentState.trunCrank();
        if (currentState == soldState || currentState == winnerState) {
            dispendse();
        }
    }

    @Override
    public void dispendse() {
        log.info("发出一件商品");
        if (count != 0) {
            count--;
        }
    }
}
