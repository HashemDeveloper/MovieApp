package com.practice.movieapp.data;

import com.practice.movieapp.data.model.MovieRes;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMovieDataService {
    @GET("movie/popular")
    Single<MovieRes> getPopularMovie(@Query("api_key") String apiKey);
}
