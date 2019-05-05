package com.practice.movieapp.data;

import androidx.annotation.NonNull;
import com.practice.movieapp.data.model.MovieRes;

import javax.inject.Inject;

import io.reactivex.Single;

public class MovieDataRequester implements IMovieDataService {

    @NonNull
    private IMovieDataService iMovieDataService;

    @Inject
    public MovieDataRequester(@NonNull IMovieDataService iMovieDataService){

        this.iMovieDataService = iMovieDataService;
    }

    @Override
    public Single<MovieRes> getPopularMovie(String apiKey) {
        return this.iMovieDataService.getPopularMovie(apiKey);
    }
}
