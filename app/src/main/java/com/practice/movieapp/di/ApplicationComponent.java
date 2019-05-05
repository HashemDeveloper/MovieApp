package com.practice.movieapp.di;

import com.practice.movieapp.MovieApp;
import com.practice.movieapp.di.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        AndroidInjectionModule.class,
        ServiceModule.class,
        ActivityModule.class
})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder bindApplication(MovieApp app);
        ApplicationComponent build();
    }
    void inject(MovieApp app);
}
