package com.bluesky.concurrency.examples.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i <= 10; i++) {
                log.info("test1:{} {}", j, i);
            }
        }
    }

    public synchronized void test2(int j) {
        for (int i = 0; i <= 10; i++) {
            log.info("test2:{} {}", j, i);
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
        executorService.shutdown();
    }
}
