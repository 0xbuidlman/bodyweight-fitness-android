package io.mazur.fit;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import net.danlew.android.joda.JodaTimeAndroid;

import io.mazur.glacier.Glacier;
import io.fabric.sdk.android.Fabric;

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        Glacier.init(getApplicationContext());
        JodaTimeAndroid.init(getApplicationContext());

        if(!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }

        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
