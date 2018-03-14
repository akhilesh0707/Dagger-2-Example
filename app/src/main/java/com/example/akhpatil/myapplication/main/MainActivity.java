package com.example.akhpatil.myapplication.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.akhpatil.myapplication.R;
import com.example.akhpatil.myapplication.app.MyApplication;
import com.example.akhpatil.myapplication.feedback.FeedbackActivity;
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

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FeedbackActivity.class));
            }
        });

        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .myAppComponent(MyApplication.get(this).getComponent())
                .build();
        component.inject(this);

        picasso.load("https://i2.wp.com/codingsonata.com/wp-content/uploads/2017/12/7-Android-Libraries.jpg").into(imageView);


    }

}
