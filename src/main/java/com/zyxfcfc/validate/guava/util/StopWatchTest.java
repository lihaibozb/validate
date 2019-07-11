package com.zyxfcfc.validate.guava.util;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-07-02
 * @Description:
 */
@Slf4j
public class StopWatchTest {

    public static void main(String[] args) throws InterruptedException {
        StopWatchTest stopWatchTest = new StopWatchTest();
        stopWatchTest.process("123123");
    }

    private void process(String orderId) throws InterruptedException {
        log.info("开始处理订单，订单信息为:[{}].", orderId);
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(1);
        log.info("订单号为[{}]的订单处理时间为[{}].", orderId, stopwatch.stop());
    }

}
