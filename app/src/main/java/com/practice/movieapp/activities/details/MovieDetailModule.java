package com.practice.movieapp.activities.details;

import com.practice.movieapp.di.scopes.ActivityScopes;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MovieDetailModule {

    @Binds
    @ActivityScopes
    abstract MovieDetailContract.View bindViewWith(MovieDetail movieDetail);

    @Binds
    @ActivityScopes
    abstract MovieDetailContract.Presenter bindPresenterWith(MovieDetailPresenter presenter);
}
