package com.practice.movieapp.activities.details;

import android.app.Activity;

import com.practice.movieapp.di.scopes.ActivityScopes;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScopes
@Subcomponent(modules = {
        MovieDetailModule.class
})
public interface MovieDetailComponent extends AndroidInjector<MovieDetail> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieDetail>{

    }
}
