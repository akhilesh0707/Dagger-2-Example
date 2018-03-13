package com.example.akhpatil.myapplication.app.core_di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by akhpatil on 3/12/2018.
 */
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @AppScope
    @Provides
    @ApplicationContext
    public Context context() {
        return context;
    }

}
