package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;

public abstract class PopularMovieListItemAbsViewModel {

    private int mMovieId;
    private String mTitleTextView;
    private String mVoteTextView;

    public PopularMovieListItemAbsViewModel(Movie movie) {
        mMovieId = movie.getId();
        mTitleTextView = movie.getTitle();
        mVoteTextView = String.valueOf(movie.getVoteAverage());
    }

    public int getMovieId() {
        return mMovieId;
    }

    public String getTitleTextView() {
        return mTitleTextView;
    }

    public String getVoteTextView() {
        return mVoteTextView;
    }
}
