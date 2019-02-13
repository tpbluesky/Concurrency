package com.bluesky.concurrency.examples.singleton;

import com.bluesky.concurrency.annotations.NotRecommend;
import com.bluesky.concurrency.annotations.ThreadSafe;

/***
 * 懒汉模式
 * 性能下降
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
