package com.github.rkhusainov.moviefan.ui.upcoming;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;

public class UpcomingMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;

    public UpcomingMovieListItemAbsViewModel(Movie movie) {
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
