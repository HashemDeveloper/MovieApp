package com.practice.movieapp.data.model;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.practice.movieapp.R;
import com.practice.movieapp.data.MovieDataRequester;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieDataRepository {

    private CompositeDisposable compositeDisposable;
    private MutableLiveData<List<Result>> listOfMovieResult = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<Boolean> isError = new MutableLiveData<>();

    @Inject
    MovieDataRequester movieDataRequester;
    @Inject
    Context context;

    @Inject
    public MovieDataRepository(){
        this.compositeDisposable = new CompositeDisposable();
    }

    public void fetchData(){
        this.isLoading.setValue(true);
        this.compositeDisposable.add(this.movieDataRequester.getPopularMovie(context.getString(R.string.movie_app_api_key))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<MovieRes>() {
            @Override
            public void onSuccess(MovieRes movieRes) {
                isError.setValue(false);
                isLoading.setValue(false);
                listOfMovieResult.setValue(movieRes.getResults());
            }

            @Override
            public void onError(Throwable e) {
                Log.i("Error: ", e.getMessage());
                isError.setValue(true);
                isLoading.setValue(false);
            }
        }));
    }

    public MutableLiveData<List<Result>> getListOfMovieResult() {
        return listOfMovieResult;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<Boolean> getIsError() {
        return isError;
    }

    public void clearDisposable(){
        if(this.compositeDisposable != null){
            this.compositeDisposable.clear();
        }
    }
}
