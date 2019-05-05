package com.practice.movieapp.activities.welcome;

import com.practice.movieapp.di.scopes.ActivityScopes;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScopes
@Subcomponent(modules = {
        WelcomeModule.class
})
public interface WelcomeComponent extends AndroidInjector<Welcome>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Welcome>{

    }
}
