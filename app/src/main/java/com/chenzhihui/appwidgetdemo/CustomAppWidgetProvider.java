package com.chenzhihui.appwidgetdemo;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chenzhihui on 16/9/20.
 */

public class CustomAppWidgetProvider extends AppWidgetProvider {
    public static String TAG = CustomAppWidgetProvider.class.getSimpleName();
    public static final String ACTION_BUTTON_CLICK_1 = "action_button_click_1";
    public static final String ACTION_BUTTON_CLICK_2 = "action_button_click_2";
    public static final String ACTION_BUTTON_CLICK_3 = "action_button_click_3";
    public static final String ACTION_BUTTON_CLICK_4 = "action_button_click_4";
    public static final String ACTION_BUTTON_CLICK_5 = "action_button_click_5";

    /**
     * 当第1个 widget 的实例被创建时触发。
     */
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.i(TAG, "onEnable");
    }

    /**
     * 接收到任意广播时触发，并且会在上述的方法之前被调用。
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.i(TAG, "onReceive");
        switch (intent.getAction()) {
            case ACTION_BUTTON_CLICK_1:
                startAPP(context,"com.tencent.mm");
                break;
            case ACTION_BUTTON_CLICK_2:
                startAPP(context,"com.hupu.games");
                break;
            case ACTION_BUTTON_CLICK_3:
                startAPP(context,"com.ss.android.article.news");
                break;
            case ACTION_BUTTON_CLICK_4:
                startAPP(context,"com.eg.android.AlipayGphone");
                break;
            case ACTION_BUTTON_CLICK_5:
                startAPP(context,"com.tencent.tmgp.sgame");
                break;

        }
        /**
         *  如果你的Widget要求并不是很特殊，一般情况下，在此接收广播，即可处理相应事务
         */
    }

    /**
     * 当 widget 更新时被执行。每次创建Widget，或者刚开机等情况下，都会被执行。
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        /**
         *  由于Widget本身不支持执行太过耗时的操作，所以，若要实现开机刷新和每次添加的时候刷新数据，开启服务，
         *  让数据在后台下载，等下载完成之后，在进行更新Widget的操作。
         *
         */
        Log.i(TAG, "onUpdate");
        AppLauncherRemoteViews launcherRemoteViews = new AppLauncherRemoteViews(context);
        launcherRemoteViews.setOnButtonClickPendingIntent();

        // 更新所有的widget
        appWidgetManager.updateAppWidget(appWidgetIds, launcherRemoteViews);

    }

    /**
     * 当 widget 被删除时被触发。
     */
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.i(TAG, "onDeleted");
    }

    /**
     * 当最后1个 widget 的实例被删除时触发。
     */
    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(TAG, "onDisabled");
    }

    public void startAPP(Context context,String appPackageName){
        try{
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(appPackageName);
            context.startActivity(intent);
        }catch(Exception e){
            Toast.makeText(context, "没有安装", Toast.LENGTH_LONG).show();
        }
    }


}
