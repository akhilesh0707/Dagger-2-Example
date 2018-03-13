package com.example.akhpatil.myapplication.main.di;

import com.example.akhpatil.myapplication.main.adapter.AdapterRepo;
import com.example.akhpatil.myapplication.main.MainActivity;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by akhpatil on 3/13/2018.
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public  MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public AdapterRepo getAdapter(Picasso picasso) {
        return new AdapterRepo(mainActivity, picasso);
    }


}
