package com.example.akhpatil.myapplication.app.core_di;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by akhpatil on 3/13/2018.
 */
@Module(includes = {NetworkModule.class, GsonModule.class})
public class RetrofitModule {

    @AppScope
    @Provides
    public Retrofit getRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://test/")
                .client(client)
                .build();
    }

}
