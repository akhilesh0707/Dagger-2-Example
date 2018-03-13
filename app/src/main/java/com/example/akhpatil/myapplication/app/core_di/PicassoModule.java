package com.example.akhpatil.myapplication.app.core_di;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by akhpatil on 3/12/2018.
 */
@Module(includes = {ContextModule.class, NetworkModule.class})
public class PicassoModule {

    @AppScope
    @Provides
    public Picasso getPicasso(@ApplicationContext Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @AppScope
    @Provides
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient client) {
        return new OkHttp3Downloader(client);
    }

}
