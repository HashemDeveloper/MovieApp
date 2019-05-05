package com.practice.movieapp.recyclerviews.diffutils;

import com.practice.movieapp.base.BaseDiffUtil;
import com.practice.movieapp.data.model.Result;

import java.util.List;

public class PopularMovieDiffUtil extends BaseDiffUtil<PopularMovieDiffUtil> {

    private List<Result> oldMovieList;
    private List<Result> newMovieList;

    public PopularMovieDiffUtil(List<Result> oldMovieList, List<Result> newMovieList) {
        super(oldMovieList, newMovieList);
        this.oldMovieList = oldMovieList;
        this.newMovieList = newMovieList;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return this.oldMovieList.get(oldItemPosition).getId().equals(this.newMovieList.get(newItemPosition).getId());
    }
}
