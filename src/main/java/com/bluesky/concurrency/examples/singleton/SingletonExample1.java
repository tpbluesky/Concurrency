package com.bluesky.concurrency.examples.singleton;

import com.bluesky.concurrency.annotations.NotThreadSafe;

/***
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonExample1 {
    private SingletonExample1() {

    }

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
