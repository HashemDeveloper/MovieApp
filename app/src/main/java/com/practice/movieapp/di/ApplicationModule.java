package com.practice.movieapp.di;

import android.content.Context;

import com.practice.movieapp.MovieApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Singleton
    @Provides
    Context provideContext(MovieApp app){
        return app;
    }
}
