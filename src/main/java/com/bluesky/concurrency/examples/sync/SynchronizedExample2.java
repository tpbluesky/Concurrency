package com.bluesky.concurrency.examples.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {

    public void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i <= 10; i++) {
                log.info("test1:{} {}", j, i);
            }
        }
    }

    public static synchronized void test2(int j) {
        for (int i = 0; i <= 10; i++) {
            log.info("test2:{} {}", j, i);
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
        executorService.shutdown();
    }
}
