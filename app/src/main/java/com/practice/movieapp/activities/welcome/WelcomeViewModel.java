package com.practice.movieapp.activities.welcome;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.practice.movieapp.data.model.MovieDataRepository;
import com.practice.movieapp.data.model.Result;
import java.util.List;
import javax.inject.Inject;


public class WelcomeViewModel extends ViewModel {

    @NonNull
    private MovieDataRepository movieDataRepository;

    @Inject
    public WelcomeViewModel(@NonNull MovieDataRepository movieDataRepository) {
        this.movieDataRepository = movieDataRepository;
        this.movieDataRepository.fetchData();
    }

    public void fetchData(){
        this.movieDataRepository.fetchData();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        this.movieDataRepository.clearDisposable();
    }

    LiveData<List<Result>> getListOfMovies(){
        return this.movieDataRepository.getListOfMovieResult();
    }
    LiveData<Boolean> getIsError(){
        return this.movieDataRepository.getIsError();
    }
    LiveData<Boolean> getIsLoading(){
        return this.movieDataRepository.getIsLoading();
    }
}
