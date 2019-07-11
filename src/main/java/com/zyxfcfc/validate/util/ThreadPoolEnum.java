package com.zyxfcfc.validate.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/5 11:27 AM
 */
public enum ThreadPoolEnum {
    /**
     * 线程池单例枚举类
     */
    EXECUTOR;

    private ExecutorService executorService;

    ThreadPoolEnum() {
        //最大堆积500个待处理任务，如果超过则在主线程中创建
        executorService = new ThreadPoolExecutor(2, 5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(200),
                new ThreadFactoryBuilder().setNameFormat("controller-pool-%d").build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public ExecutorService getInstance() {
        return executorService;
    }

}
