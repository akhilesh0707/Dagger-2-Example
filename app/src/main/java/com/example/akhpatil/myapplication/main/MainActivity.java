package com.example.akhpatil.myapplication.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.akhpatil.myapplication.R;
import com.example.akhpatil.myapplication.app.MyApplication;
import com.example.akhpatil.myapplication.main.adapter.AdapterRepo;
import com.example.akhpatil.myapplication.main.di.DaggerMainActivityComponent;
import com.example.akhpatil.myapplication.main.di.MainActivityComponent;
import com.example.akhpatil.myapplication.main.di.MainActivityModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView imageView;

    @Inject
    Picasso picasso;

    @Inject
    AdapterRepo adapterRepo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .myAppComponent(MyApplication.get(this).getComponent())
                .build();
        component.inject(this);


        picasso.load("https://i2.wp.com/codingsonata.com/wp-content/uploads/2017/12/7-Android-Libraries.jpg").into(imageView);


    }

}
