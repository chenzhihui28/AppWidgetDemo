package com.chenzhihui.appwidgetdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by chenzhihui on 16/9/20.
 */

public class CustomApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }

}
