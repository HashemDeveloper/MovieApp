package com.practice.movieapp.activities.welcome;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.practice.movieapp.data.model.Result;
import com.practice.movieapp.di.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WelcomePresenter implements WelcomeContract.Presenter {

    @NonNull
    private WelcomeContract.View view;
    @NonNull
    private ViewModelFactory modelFactory;
    private WelcomeViewModel welcomeViewModel;
    @Inject
    Context context;

    @Inject
    public WelcomePresenter(@NonNull WelcomeContract.View view, @NonNull ViewModelFactory modelFactory){
        this.view = view;
        this.modelFactory = modelFactory;
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void attachViewModel(FragmentActivity activity) {
        this.welcomeViewModel = ViewModelProviders.of(activity, this.modelFactory).get(WelcomeViewModel.class);
    }


    @Override
    public void initMovieData(FragmentActivity activity){
        this.welcomeViewModel.getIsLoading().observe(activity, aBoolean -> {
            this.view.showLoading(aBoolean);
        });
        this.welcomeViewModel.getIsError().observe(activity, aBoolean -> {
            this.view.showError(aBoolean);
        });

       this.welcomeViewModel.getListOfMovies().observe(activity, results -> {
           this.view.processMovieList(results);
       });
    }

    @Override
    public void refreshData(){
        this.welcomeViewModel.fetchData();
    }
}
