package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;

public abstract class PopularMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;
    private String mVoteTextView;

    public PopularMovieListItemAbsViewModel(Movie movie) {
        mId = movie.getId();
        mTitleTextView = movie.getTitle();
        mVoteTextView = String.valueOf(movie.getVoteAverage());
    }

    public int getId() {
        return mId;
    }

    public String getTitleTextView() {
        return mTitleTextView;
    }

    public String getVoteTextView() {
        return mVoteTextView;
    }
}
