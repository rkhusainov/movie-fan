package com.github.rkhusainov.moviefan.presentation.ui.upcoming;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

public class UpcomingMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;

    public UpcomingMovieListItemAbsViewModel(MovieEntity movie) {
        mId = movie.getId();
        mTitleTextView = movie.getTitle();
    }

    public int getId() {
        return mId;
    }

    public String getTitleTextView() {
        return mTitleTextView;
    }
}
