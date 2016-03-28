package com.kylin.annotationdemo;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Kylin on 2016/3/18.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
//        x.Ext.setDebug();
    }
}
