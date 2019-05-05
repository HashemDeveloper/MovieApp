package com.practice.movieapp.base;

import androidx.recyclerview.widget.DiffUtil;

import com.practice.movieapp.data.model.MovieRes;
import com.practice.movieapp.data.model.Result;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDiffUtil<T> extends DiffUtil.Callback {

    private final List<Result> oldMovieList;
    private final List<Result> newMovieList;

    public BaseDiffUtil(List<Result> oldMovieList, List<Result> newMovieList){
        this.oldMovieList = oldMovieList;
        this.newMovieList = newMovieList;
    }

    @Override
    public int getOldListSize() {
        return this.oldMovieList.size();
    }

    @Override
    public int getNewListSize() {
        return this.newMovieList.size();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return this.oldMovieList.get(oldItemPosition).equals(this.newMovieList.get(newItemPosition));
    }
}
