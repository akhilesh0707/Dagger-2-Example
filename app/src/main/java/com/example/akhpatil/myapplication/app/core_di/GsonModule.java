package com.example.akhpatil.myapplication.app.core_di;

import com.fatboyindustrial.gsonjodatime.DateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import dagger.Module;
import dagger.Provides;

/**
 * Created by akhpatil on 3/13/2018.
 */

@Module
public class GsonModule {

    @AppScope
    @Provides
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        Gson gson = gsonBuilder.create();
        return gson;
    }

}
