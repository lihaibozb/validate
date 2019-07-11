package com.zyxfcfc.validate.controller;

import com.google.common.util.concurrent.*;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FutureListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/5 10:08 AM
 */
@RestController
@Slf4j
public class AsyncController {

    /**
     * @apiNote jdk提供的异步编程 run 和 listener在同一个线程
     * @param
     * @return
     */
    @GetMapping("/jdk8Async")
    public String jdk8Async() throws ExecutionException, InterruptedException {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("guava-pool-%d").build();
        //最大堆积1024个待处理任务，如果超过则丢弃并且抛出异常
        ExecutorService executor = new ThreadPoolExecutor(2, 4, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1024),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());
        //jdk1.8
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                log.info("{} task started!", Thread.currentThread().getName());
                try {
                    //模拟耗时操作
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("{} task started!", Thread.currentThread().getName());
                return "返回结果!";
            }
        }, executor);

        //采用lambada的实现方式
        future.thenAccept(new Consumer(){
            @Override
            public void accept(Object o) {
                //拿到结果后执行
                log.info("{} 异步操作完成1!"+ o, Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("{} 异步操作完成2!" + o, Thread.currentThread().getName());
            }
        });

        //如果需要阻塞
        CompletableFuture.allOf(future);
        log.info("阻塞等待结果中……");
        log.info("{} {} 阻塞获取结果完成!", future.get(), Thread.currentThread().getName());

        return Thread.currentThread().getName() + " main thread is done";
    }

    /**
     * @param
     * @return
     * @apiNote guava提供的异步编程  run 和 listener不在同一个线程
     */
    @GetMapping("/guavaAsync")
    public String guavaAsync() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("guava-pool-%d").build();
        //最大堆积1024个待处理任务，如果超过则丢弃并且抛出异常
        ExecutorService executor = new ThreadPoolExecutor(2, 4, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1024),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());

        // 使用guava提供的MoreExecutors工具类包装原始的线程池
        ListeningExecutorService listeningExecutor = MoreExecutors.listeningDecorator(executor);

        //向线程池中提交一个任务后，将会返回一个可监听的Future，该Future由Guava框架提供
        ListenableFuture<String> lf = listeningExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("{} task started!", Thread.currentThread().getName());
                //模拟耗时操作
                Thread.sleep(3000);
                log.info("{} task finished!", Thread.currentThread().getName());
                return "hello";
            }
        });
        //添加回调，回调由executor中的线程触发，但也可以指定一个新的线程
        Futures.addCallback(lf, new FutureCallback<String>() {

            //耗时任务执行失败后回调该方法
            @Override
            public void onFailure(Throwable t) {
                log.info("{} failure", Thread.currentThread().getName());
            }

            //耗时任务执行成功后回调该方法
            @Override
            public void onSuccess(String s) {
                log.info("{} success", Thread.currentThread().getName());
            }
        }, executor);

        //主线程可以继续做其他的工作
        return Thread.currentThread().getName() + " main thread is done";
    }

    /**
     * @param
     * @return
     * @apiNote netty提供的异步编程 run 和 listener在同一个线程
     */
    @GetMapping("/nettyAsync")
    public String nettyAsync() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("netty-pool-%d").build();
        EventExecutorGroup group = new DefaultEventExecutorGroup(1, threadFactory);
        //向线程池中提交任务，并返回Future，该Future是netty自己实现的future
        //位于io.netty.util.concurrent包下，此处运行时的类型为PromiseTask
        io.netty.util.concurrent.Future<?> f = group.submit(new Runnable() {

            @Override
            public void run() {
                log.info("{} task started!", Thread.currentThread().getName());
                //模拟耗时操作，比如IO操作
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("{} task finished!", Thread.currentThread().getName());
            }
        });
        //增加监听
        f.addListener(new FutureListener() {
            @Override
            public void operationComplete(io.netty.util.concurrent.Future future) throws Exception {
                log.info("{} ok!!!", Thread.currentThread().getName());
            }
        });

        return Thread.currentThread().getName() + " main thread is done";
    }

}
