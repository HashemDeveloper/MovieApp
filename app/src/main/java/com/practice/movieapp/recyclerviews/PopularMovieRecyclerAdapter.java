package com.practice.movieapp.recyclerviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.movieapp.R;
import com.practice.movieapp.data.model.Result;
import com.practice.movieapp.recyclerviews.diffutils.PopularMovieDiffUtil;

import java.util.ArrayList;
import java.util.List;

public class PopularMovieRecyclerAdapter extends RecyclerView.Adapter {
    private OnMovieItemClicked movieClickListener;
    private List<Result> popularMovieList;
    private Context context;

    public PopularMovieRecyclerAdapter(Context context, OnMovieItemClicked movieClickListener){
        this.popularMovieList = new ArrayList<>();
        this.movieClickListener = movieClickListener;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.welcome_popular_movie_list_layout, parent, false);
        final PopularMovieListViewHolder popularMovieListViewHolder = new PopularMovieListViewHolder(view, context);
        popularMovieListViewHolder.getMovieImageView().setOnClickListener(v -> viewMovieDetails(popularMovieListViewHolder.getAdapterPosition()));
        return popularMovieListViewHolder;
    }

    private void viewMovieDetails(int position){
        Result result = this.popularMovieList.get(position);
        this.movieClickListener.onMovieItemClicked(result);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PopularMovieListViewHolder) holder).bindView(this.popularMovieList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.popularMovieList.size();
    }

    public void setPopularMovieList(List<Result> list){
        if(list != null){
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new PopularMovieDiffUtil(this.popularMovieList, list));
            this.popularMovieList.clear();
            this.popularMovieList.addAll(list);
            diffResult.dispatchUpdatesTo(this);
        }else{
            this.popularMovieList.clear();
            notifyDataSetChanged();
        }
    }
    public interface OnMovieItemClicked{
        void onMovieItemClicked(Result result);
    }
}
