package com.bluesky.concurrency.examples.singleton;

import com.bluesky.concurrency.annotations.NotThreadSafe;
import com.bluesky.concurrency.annotations.ThreadSafe;

/***
 * 懒汉模式 => 双重同步锁
 * CPU指令重排导致线程不安全
 */
@ThreadSafe
public class SingletonExample5 {
    private SingletonExample5() {

    }

    // 1. memory = allocate() 分配对象的内存空间
    // 2. ctorInstance() 初始化对象
    // 3. instance = memory 设置instance指向刚分配的内存

    //JVM和CPU优化，发生指令重排

    // 1. memory = allocate() 分配对象的内存空间
    // 2. instance = memory 设置instance指向刚分配的内存
    // 3. ctorInstance() 初始化对象

    // volatile禁止指令重排
    private static volatile SingletonExample5 instance = null;

    public static SingletonExample5 getInstance() {
        if (instance == null) { //线程A运行到此处
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5(); //现场B运行到指令重排后的第2步

                }
            }
        }
        return instance;
    }
}
