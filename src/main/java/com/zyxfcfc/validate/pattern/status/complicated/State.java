package com.zyxfcfc.validate.pattern.status.complicated;

/**
 * description: 状态的接口
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/3 4:45 PM
 */
public interface State {

    /**
     * 放钱
     */
    void insertMoney();

    /**
     * 退钱
     */
    void backMoney();

    /**
     * 转动曲柄
     */
    void trunCrank();

    /**
     * 出商品
     */
    void dispendse();
}
