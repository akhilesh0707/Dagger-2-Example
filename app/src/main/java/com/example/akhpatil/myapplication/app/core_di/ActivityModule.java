package com.example.akhpatil.myapplication.app.core_di;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by akhpatil on 3/13/2018.
 */
@Module
public class ActivityModule {

    private final Activity context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @AppScope
    @Provides
    @Named("activity-context")
    public Context context() {
        return context;
    }

}
