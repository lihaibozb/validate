package com.zyxfcfc.validate.pattern.status.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 3:45 PM
 */
@Slf4j
public class VendingMachine {

    /**
     * 已投币
     */
    private static final int HAS_MONEY = 0;
    /**
     * 未投币
     */
    private static final int NO_MONEY = 1;
    /**
     * 售出商品
     */
    private static final int SOLD = 2;
    /**
     * 售罄
     */
    private static final int SOLD_OUT = 3;

    private int currentStatus = NO_MONEY;

    private int count = 0;

    public VendingMachine(int count) {
        this.count = count;
        if (count > 0) {
            currentStatus = NO_MONEY;
        }
    }

    /**
     * description: 投入硬币，任何状态用户都可能投币
     *
     * @param 
     * @return 
     */
    public void insertMoney() {
        switch (currentStatus) {
            case NO_MONEY:
                currentStatus = HAS_MONEY;
                log.info("成功投入硬币[{}]", ".");
                break;
            case HAS_MONEY:
                log.info("已有硬币，无需投币.");
                break;
            case SOLD:
                log.info("请稍等...");
                break;
            case SOLD_OUT:
                log.info("商品已经售罄，请勿投币！");
                break;
            default:
                break;
        }
    }

    /**
     * description:  退币，任何状态用户都可能退币
     *
     * @param
     * @return
     */
    public void backMoney() {
        switch (currentStatus) {
            case NO_MONEY:
                log.info("您未投入硬币.");
                break;
            case HAS_MONEY:
                currentStatus = NO_MONEY;
                log.info("退币成功.");
                break;
            case SOLD:
                log.info("您已经买了商品，无法退币.");
                break;
            case SOLD_OUT:
                log.info("您未投币");
                break;
            default:
                break;
        }
    }

    /**
     * description:  转动手柄购买，任何状态用户都可能转动手柄
     *
     * @param
     * @return
     */
    public void trunCrank() {
        switch (currentStatus) {
            case NO_MONEY:
                log.info("请您先投入硬币.");
                break;
            case HAS_MONEY:
                log.info("正在出商品");
                currentStatus = SOLD;
                dispense();
                break;
            case SOLD:
                log.info("连续转动也没有用");
                break;
            case SOLD_OUT:
                log.info("商品已经售罄");
                break;
            default:
                break;
        }
    }

    /**
     * description:  发放商品
     *
     * @param
     * @return
     */
    private void dispense() {
        switch (currentStatus) {
            case NO_MONEY:
            case HAS_MONEY:
            case SOLD_OUT:
                throw new IllegalStateException("非法的状态");
            case SOLD:
                count--;
                log.info("发出商品");
                if (count == 0) {
                    log.info("商品售罄");
                    currentStatus = SOLD_OUT;
                } else {
                    currentStatus = NO_MONEY;
                }
                break;
            default:
                break;
        }
    }


}
