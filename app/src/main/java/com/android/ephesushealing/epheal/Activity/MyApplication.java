package com.android.ephesushealing.epheal.Activity;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.support.multidex.MultiDex;

public class MyApplication extends Application {

    public static Typeface mfont;

    @Override
    public void onCreate() {
        super.onCreate();



        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Avenir-Medium.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Avenir-Medium.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Avenir-Heavy.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Avenir-Heavy.ttf");


    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
        MultiDex.install(this);
    }




}
