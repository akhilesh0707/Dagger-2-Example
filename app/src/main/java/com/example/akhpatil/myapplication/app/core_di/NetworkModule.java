package com.example.akhpatil.myapplication.app.core_di;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by akhpatil on 3/12/2018.
 */

@Module(includes = {ContextModule.class})
public class NetworkModule {

    @AppScope
    @Provides
    public File cacheFile(@ApplicationContext Context context) {
        File cacheFile = new File(context.getCacheDir(), "okhhtp_cache");
        cacheFile.mkdir();
        return cacheFile;
    }

    @AppScope
    @Provides
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); //10 MB cache
    }

    @AppScope
    @Provides
    public HttpLoggingInterceptor interceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @AppScope
    @Provides
    public OkHttpClient client(HttpLoggingInterceptor interceptor, Cache cache) {
        return new OkHttpClient.Builder().addInterceptor(interceptor).cache(cache).build();
    }
}