package com.practice.movieapp;

import android.app.Activity;
import android.app.Application;

import com.practice.movieapp.di.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MovieApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder().bindApplication(this).build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
       return this.dispatchingAndroidInjector;
    }
}
