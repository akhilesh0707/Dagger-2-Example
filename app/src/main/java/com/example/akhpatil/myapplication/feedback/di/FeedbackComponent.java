package com.example.akhpatil.myapplication.feedback.di;

import com.example.akhpatil.myapplication.app.core_di.MyAppComponent;
import com.example.akhpatil.myapplication.feedback.FeedbackActivity;

import dagger.Component;

/**
 * Created by akhpatil on 3/14/2018.
 */
@FeedbackScope
@Component(modules = {FeedbackModule.class}, dependencies = {MyAppComponent.class})
public interface FeedbackComponent {
    void inject(FeedbackActivity feedbackActivity);
}
