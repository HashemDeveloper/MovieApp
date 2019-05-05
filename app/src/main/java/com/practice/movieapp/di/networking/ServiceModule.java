package com.practice.movieapp.di.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.movieapp.generated.Stag;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {
        TMDBNetworking.class
})
public abstract class ServiceModule {
    @Singleton
    @Provides
    static Gson provideGson(){
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .registerTypeAdapterFactory(new Stag.Factory())
                .create();
    }

    @Singleton
    @Provides
    static Retrofit provideRetrofit(Gson gson, @Named("base_url") String baseUrl){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .build();
    }
}
