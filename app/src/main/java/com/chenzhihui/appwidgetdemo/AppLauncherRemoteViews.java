package com.chenzhihui.appwidgetdemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


public class AppLauncherRemoteViews extends RemoteViews {


	private Context mContext;

	private AppWidgetManager mAppWidgetManager;


	public AppLauncherRemoteViews(Context context) {
		super(context.getPackageName(), R.layout.layout_widget);
		init(context);
	}

	private void init(Context context) {
		this.mContext = context;
		this.mAppWidgetManager = AppWidgetManager.getInstance(mContext);

	}

	private Class<? extends AppWidgetProvider> getAppWidgetProvider() {
		return CustomAppWidgetProvider.class;
	}

	private Intent getProviderIntent() {
		return new Intent(mContext, getAppWidgetProvider());
	}

	public int[] getAppWidgetIds() {
		ComponentName provider = new ComponentName(mContext, getAppWidgetProvider());
		return mAppWidgetManager.getAppWidgetIds(provider);
	}





	public void setOnButtonClickPendingIntent() {
		Intent intent1 = getProviderIntent();
		intent1.setAction(CustomAppWidgetProvider.ACTION_BUTTON_CLICK_1);
		PendingIntent click1PendingIntent = PendingIntent.getBroadcast(mContext, 0, intent1, 0);
		setOnClickPendingIntent(R.id.img1, click1PendingIntent);

		Intent intent2 = getProviderIntent();
		intent2.setAction(CustomAppWidgetProvider.ACTION_BUTTON_CLICK_2);
		PendingIntent click2PendingIntent = PendingIntent.getBroadcast(mContext, 0, intent2, 0);
		setOnClickPendingIntent(R.id.img2, click2PendingIntent);

		Intent intent3 = getProviderIntent();
		intent3.setAction(CustomAppWidgetProvider.ACTION_BUTTON_CLICK_3);
		PendingIntent click3PendingIntent = PendingIntent.getBroadcast(mContext, 0, intent3, 0);
		setOnClickPendingIntent(R.id.img3, click3PendingIntent);

		Intent intent4 = getProviderIntent();
		intent4.setAction(CustomAppWidgetProvider.ACTION_BUTTON_CLICK_4);
		PendingIntent click4PendingIntent = PendingIntent.getBroadcast(mContext, 0, intent4, 0);
		setOnClickPendingIntent(R.id.img4, click4PendingIntent);


		Intent intent5 = getProviderIntent();
		intent5.setAction(CustomAppWidgetProvider.ACTION_BUTTON_CLICK_5);
		PendingIntent click5PendingIntent = PendingIntent.getBroadcast(mContext, 0, intent5, 0);
		setOnClickPendingIntent(R.id.img5, click5PendingIntent);




	}
	





}
