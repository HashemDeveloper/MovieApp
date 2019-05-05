package com.practice.movieapp.di.networking;

import com.practice.movieapp.data.MovieDataModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Module(includes = {
        MovieDataModule.class
})
public abstract class TMDBNetworking {

    @Singleton
    @Provides
    static Call.Factory provideCallFactory(){
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Named("base_url")
    static String provideBaseUrl(){
        return "https://api.themoviedb.org/3/";
    }
}
