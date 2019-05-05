package com.practice.movieapp.activities.welcome;

import com.practice.movieapp.di.scopes.ActivityScopes;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WelcomeModule {

    @Binds
    @ActivityScopes
    abstract WelcomeContract.View bindViewWith(Welcome welcome);

    @Binds
    @ActivityScopes
    abstract WelcomeContract.Presenter bindPresenterWith(WelcomePresenter presenter);
}
