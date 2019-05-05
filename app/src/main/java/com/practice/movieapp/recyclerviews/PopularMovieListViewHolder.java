package com.practice.movieapp.recyclerviews;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.practice.movieapp.R;
import com.practice.movieapp.data.model.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopularMovieListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.popular_movie_image_view_id)
    AppCompatImageView movieImageView;
    @BindView(R.id.popular_movie_title_view_id)
    AppCompatTextView popularMovieTitle;
    @BindView(R.id.popular_view_rating_view_id)
    AppCompatTextView popularViewRating;
    private Context context;

    public PopularMovieListViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    public void bindView(Result result){
        if(result != null){
            itemView.setTag(result);
            this.popularMovieTitle.setText(result.getTitle());
            this.popularViewRating.setText(String.valueOf(result.getVoteAverage()));
            String imagePath = "https://image.tmdb.org/t/p/w500/" + result.getPosterPath();
            RequestOptions requestOptions = new RequestOptions();
            Glide.with(context)
                    .load(imagePath)
                    .into(this.movieImageView);
        }
    }

    public AppCompatImageView getMovieImageView() {
        return movieImageView;
    }
}
