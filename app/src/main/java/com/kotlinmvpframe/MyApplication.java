package com.kotlinmvpframe;

import android.app.Application;


public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized MyApplication getInstance() {
        if (instance == null)
            instance = new MyApplication();
        return instance;
    }
}
