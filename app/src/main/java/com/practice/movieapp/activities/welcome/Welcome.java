package com.practice.movieapp.activities.welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;
import com.practice.movieapp.R;
import com.practice.movieapp.activities.details.MovieDetail;
import com.practice.movieapp.data.model.Result;
import com.practice.movieapp.recyclerviews.PopularMovieRecyclerAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public class Welcome extends AppCompatActivity implements WelcomeContract.View, SwipeRefreshLayout.OnRefreshListener,
        PopularMovieRecyclerAdapter.OnMovieItemClicked {
    @Inject
    WelcomeContract.Presenter presenter;
    @BindView(R.id.welcome_activity_recycler_view_id)
    RecyclerView popularMovieRecyclerView;
    @BindView(R.id.welcome_activity_progress_bar_id)
    ProgressBar progressBar;
    @BindView(R.id.welcome_swipe_refresh_layout_id)
    SwipeRefreshLayout swipeRefreshLayout;
    private Unbinder unbinder;
    private PopularMovieRecyclerAdapter popularMovieRecyclerAdapter;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity_layout);
        this.view = findViewById(R.id.welcome_activity_main_container_id);
        this.presenter.attachViewModel(this);
        this.unbinder = ButterKnife.bind(this);
        this.popularMovieRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        this.popularMovieRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.popularMovieRecyclerAdapter = new PopularMovieRecyclerAdapter(this, this);
        this.popularMovieRecyclerView.setAdapter(popularMovieRecyclerAdapter);
        this.swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        this.swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.presenter.subscribe();
        this.presenter.initMovieData(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.unsubscribe();
        this.unbinder.unbind();
    }

    @Override
    public void showLoading(Boolean aBoolean) {
        if(aBoolean){
            this.progressBar.setVisibility(View.VISIBLE);
            this.swipeRefreshLayout.setRefreshing(true);
        }else{
            this.progressBar.setVisibility(View.GONE);
            this.swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showError(Boolean aBoolean) {
        if(aBoolean){
            Snackbar.make(this.view, "Server Error", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void processMovieList(List<Result> resultList) {
        this.popularMovieRecyclerAdapter.setPopularMovieList(resultList);
    }

    @Override
    public void onRefresh() {
        this.presenter.refreshData();
    }

    @Override
    public void onMovieItemClicked(Result result) {
        if(result != null){
            Intent intent = new Intent(this, MovieDetail.class);
            intent.putExtra("movie", result);
            startActivity(intent);
        }
    }
}
