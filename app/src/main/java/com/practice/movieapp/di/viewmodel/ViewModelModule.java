package com.practice.movieapp.di.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.practice.movieapp.activities.details.MovieDetailViewModel;
import com.practice.movieapp.activities.welcome.WelcomeViewModel;
import com.practice.movieapp.di.scopes.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel.class)
    abstract ViewModel provideViewModelForWelcome(WelcomeViewModel welcomeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel.class)
    abstract ViewModel provideViewModelForMovieDetail(MovieDetailViewModel movieDetailViewModel);
}
