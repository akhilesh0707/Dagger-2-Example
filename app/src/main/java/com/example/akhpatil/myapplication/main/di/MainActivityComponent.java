package com.example.akhpatil.myapplication.main.di;

import com.example.akhpatil.myapplication.app.core_di.MyAppComponent;
import com.example.akhpatil.myapplication.main.MainActivity;
import com.example.akhpatil.myapplication.main.adapter.AdapterRepo;

import dagger.Component;

/**
 * Created by akhpatil on 3/13/2018.
 */
@MainActivityScope
@Component(modules = {MainActivityModule.class}, dependencies = {MyAppComponent.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
