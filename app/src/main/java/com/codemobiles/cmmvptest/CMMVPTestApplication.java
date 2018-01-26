package com.codemobiles.cmmvptest;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;


public class CMMVPTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());

        Crashlytics.setUserIdentifier("Dev1");
        Crashlytics.setUserName("DevAndroid");
        Crashlytics.setUserEmail("DevAndroid@gmail.com");
    }
}
