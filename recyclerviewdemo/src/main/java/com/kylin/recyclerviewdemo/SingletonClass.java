package com.kylin.recyclerviewdemo;

/**
 * Package com.kylin.recyclerviewdemo
 * 创建人：wxianing
 * 作 用：
 * 时 间：2016/3/21
 * 修改人：
 */
public class SingletonClass {
    private static SingletonClass instance = null;

    public SingletonClass() {
    }

    //懒汉式单例
//        public static synchronized SingletonClass getInstance(){
//        if (instance==null){
//            instance = new SingletonClass();
//        }
//        return instance;
//    }
    //双重锁试单例
    public static synchronized SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
