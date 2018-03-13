package com.example.akhpatil.myapplication.app;

import android.app.Application;
import android.content.Context;

import com.example.akhpatil.myapplication.app.core_di.ContextModule;
import com.example.akhpatil.myapplication.app.core_di.DaggerMyAppComponent;
import com.example.akhpatil.myapplication.app.core_di.MyAppComponent;

import timber.log.Timber;

/**
 * Created by akhpatil on 3/12/2018.
 */

public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();
    private MyAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        component = DaggerMyAppComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public MyAppComponent getComponent() {
        return component;
    }


}
