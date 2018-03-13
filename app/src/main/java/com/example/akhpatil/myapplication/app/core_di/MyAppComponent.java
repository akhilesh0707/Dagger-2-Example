package com.example.akhpatil.myapplication.app.core_di;

import com.squareup.picasso.Picasso;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by akhpatil on 3/12/2018.
 */
@AppScope
@Component(modules = {PicassoModule.class, RetrofitModule.class, ActivityModule.class})
public interface MyAppComponent {
    Picasso getPicasso();

    Retrofit getRetrofit();
}
