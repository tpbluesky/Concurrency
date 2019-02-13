package com.bluesky.concurrency.examples.singleton;

import com.bluesky.concurrency.annotations.Recommend;
import com.bluesky.concurrency.annotations.ThreadSafe;

/***
 * 枚举模式-最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample6 {
    private SingletonExample6() {

    }

    private static SingletonExample6 instance = null;

    public static SingletonExample6 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample6 singleton;

        Singleton() {
            singleton = new SingletonExample6();
        }

        public SingletonExample6 getSingleton() {
            return singleton;
        }
    }
}
