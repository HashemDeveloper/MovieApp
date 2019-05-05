package com.practice.movieapp.activities.details;

import androidx.annotation.NonNull;

import javax.inject.Inject;

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    @NonNull
    private MovieDetailContract.View view;

    @Inject
    public MovieDetailPresenter(@NonNull MovieDetailContract.View view){
        this.view = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void processImagePath(String imagePath) {
        this.view.showImage(imagePath);
    }

    @Override
    public void processMovieDetails(String movieTitle, String rating, String plotSynopsis, String releaseDate) {
        this.view.processMovieDetails(movieTitle, rating, plotSynopsis, releaseDate);
    }
}
