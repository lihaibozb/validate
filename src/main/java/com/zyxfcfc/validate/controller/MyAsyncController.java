package com.zyxfcfc.validate.controller;

import com.zyxfcfc.validate.util.ThreadPoolEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/5 11:07 AM
 */
@RestController
@Slf4j
public class MyAsyncController {

    /**
     * @param
     * @return
     * @apiNote ABC3个无耦合关系的接口串行改并行
     */
    @GetMapping("/async")
    public String async() throws ExecutionException, InterruptedException {
        log.info("模拟接口异步调用=============================");
        ExecutorService executor = ThreadPoolEnum.EXECUTOR.getInstance();

        //jdk1.8  Supplier
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                    log.info("{} Supplier started!", Thread.currentThread().getName());
                    try {
                        //模拟耗时操作
                        TimeUnit.MICROSECONDS.sleep(3000);
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                        return "error";
                    }
                    log.info("{} Supplier ended!", Thread.currentThread().getName());
                    return "Supplier execute success!!";
                }
                , executor);

        //如果需要阻塞
        CompletableFuture.allOf(future).join();
        String result = future.get();

        log.info("{} {} 阻塞获取结果完成!", Thread.currentThread().getName(), result);

        return result;
    }
}
