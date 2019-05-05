package com.practice.movieapp.activities.details;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.practice.movieapp.R;
import com.practice.movieapp.data.model.Result;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public class MovieDetail extends AppCompatActivity implements MovieDetailContract.View {

    @BindView(R.id.movie_details_title_view_id)
    AppCompatTextView movieTitleView;
    @BindView(R.id.movie_details_movie_rating_view_id)
    AppCompatTextView movieRatingView;
    @BindView(R.id.movie_details_release_date_view_id)
    AppCompatTextView movieReleaseDateView;
    @BindView(R.id.movie_details_plot_synopsis_view_id)
    AppCompatTextView plotSynopsisView;
    @BindView(R.id.movie_details_collapsing_toolbar_layout_id)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.movie_details_image_view_id)
    AppCompatImageView imageView;
    @BindView(R.id.movie_details_toolbar_id)
    Toolbar toolbar;
    private Unbinder unbinder;
    private Result result;
    @Inject
    MovieDetailContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_poster_layout);
        this.unbinder = ButterKnife.bind(this);
        setSupportActionBar(this.toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        if(intent.hasExtra("movie")){
            this.result = intent.getParcelableExtra("movie");
            String imagePath = "https://image.tmdb.org/t/p/w500/" + result.getPosterPath();
            String movieTitle = this.result.getTitle();
            String rating = String.valueOf(this.result.getVoteAverage());
            String plotSynopsis = this.result.getOverview();
            String releaseDate = this.result.getReleaseDate();
            this.presenter.processMovieDetails(movieTitle, rating, plotSynopsis, releaseDate);
            this.presenter.processImagePath(imagePath);
            this.collapsingToolbarLayout.setTitle(result.getTitle());

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.presenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unbinder.unbind();
    }

    @Override
    public void showImage(String imagePath) {
        Glide.with(this).load(imagePath).into(this.imageView);
    }

    @Override
    public void processMovieDetails(String movieTitle, String rating, String plotSynopsis, String releaseDate) {
        this.movieTitleView.setText(movieTitle);
        this.movieRatingView.setText(rating);
        this.movieReleaseDateView.setText(releaseDate);
        this.plotSynopsisView.setText(plotSynopsis);
    }
}
