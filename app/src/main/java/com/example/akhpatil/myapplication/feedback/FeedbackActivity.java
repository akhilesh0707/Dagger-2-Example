package com.example.akhpatil.myapplication.feedback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.akhpatil.myapplication.R;
import com.example.akhpatil.myapplication.app.MyApplication;
import com.example.akhpatil.myapplication.feedback.adapter.FeedbackAdapter;
import com.example.akhpatil.myapplication.feedback.di.DaggerFeedbackComponent;
import com.example.akhpatil.myapplication.feedback.di.FeedbackComponent;
import com.example.akhpatil.myapplication.feedback.di.FeedbackModule;

import javax.inject.Inject;

public class FeedbackActivity extends AppCompatActivity {

    @Inject
    FeedbackAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        FeedbackComponent component = DaggerFeedbackComponent.builder()
                .feedbackModule(new FeedbackModule(this))
                .myAppComponent(MyApplication.get(this).getComponent())
                .build();
        component.inject(this);
    }
}
