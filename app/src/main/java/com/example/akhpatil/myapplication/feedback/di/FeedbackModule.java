package com.example.akhpatil.myapplication.feedback.di;

import android.content.Context;

import com.example.akhpatil.myapplication.app.core_di.ActivityModule;
import com.example.akhpatil.myapplication.app.core_di.ApplicationContext;
import com.example.akhpatil.myapplication.feedback.FeedbackActivity;
import com.example.akhpatil.myapplication.feedback.adapter.FeedbackAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by akhpatil on 3/14/2018.
 */
@Module
public class FeedbackModule {

    private FeedbackActivity feedbackActivity;

    public FeedbackModule(FeedbackActivity feedbackActivity) {
        this.feedbackActivity = feedbackActivity;
    }

    @Provides
    @FeedbackScope
    public FeedbackAdapter getAdapter() {
        return new FeedbackAdapter(feedbackActivity);
    }

}
