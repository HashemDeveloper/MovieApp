package com.practice.movieapp.activities.welcome;

import androidx.fragment.app.FragmentActivity;

import com.practice.movieapp.base.IBaseActivity;
import com.practice.movieapp.base.IBasePresenter;
import com.practice.movieapp.data.model.Result;

import java.util.List;

public interface WelcomeContract {
    interface View extends IBaseActivity{

        void showLoading(Boolean aBoolean);

        void showError(Boolean aBoolean);

        void processMovieList(List<Result> resultList);
    }
    interface Presenter extends IBasePresenter{

        void attachViewModel(FragmentActivity activity);
        void initMovieData(FragmentActivity welcome);
        void refreshData();
    }
}
