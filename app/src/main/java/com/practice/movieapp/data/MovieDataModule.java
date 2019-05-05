package com.practice.movieapp.data;

import com.practice.movieapp.data.model.MovieDataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class MovieDataModule {
    @Singleton
    @Provides
    static IMovieDataService provideMovieDataService(Retrofit retrofit){
        return retrofit.create(IMovieDataService.class);
    }
}
