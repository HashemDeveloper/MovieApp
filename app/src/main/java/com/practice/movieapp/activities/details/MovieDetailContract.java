package com.practice.movieapp.activities.details;

import com.practice.movieapp.base.IBaseActivity;
import com.practice.movieapp.base.IBasePresenter;

public interface MovieDetailContract {

    interface View extends IBaseActivity{

        void showImage(String imagePath);

        void processMovieDetails(String movieTitle, String rating, String plotSynopsis, String releaseDate);
    }
    interface Presenter extends IBasePresenter{

        void processImagePath(String imagePath);

        void processMovieDetails(String movieTitle, String rating, String plotSynopsis, String releaseDate);
    }
}
