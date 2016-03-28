package com.kylin.recyclerviewdemo;

/**
 * Package com.kylin.recyclerviewdemo
 * 创建人：wxianing
 * 作 用：
 * 时 间：2016/3/21
 * 修改人：
 */
public class Singleton {
    public Singleton() {
    }

    private static final Singleton instance = new Singleton();

    private static Singleton getInstance() {
        return instance;
    }
}
