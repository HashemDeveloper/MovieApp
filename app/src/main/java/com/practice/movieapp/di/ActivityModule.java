package com.practice.movieapp.di;

import android.app.Activity;

import com.practice.movieapp.activities.details.MovieDetail;
import com.practice.movieapp.activities.details.MovieDetailComponent;
import com.practice.movieapp.activities.welcome.Welcome;
import com.practice.movieapp.activities.welcome.WelcomeComponent;
import com.practice.movieapp.di.scopes.ActivityScopes;
import com.practice.movieapp.di.viewmodel.ViewModelModule;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        WelcomeComponent.class,
        MovieDetailComponent.class
}, includes = {
        ViewModelModule.class
})
public abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(Welcome.class)
    abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorWithWelcomeActivity(WelcomeComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(MovieDetail.class)
    abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorWithMovieDetailActivity(MovieDetailComponent.Builder builder);
}
