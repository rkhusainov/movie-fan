package com.github.rkhusainov.moviefan.presentation.ui.popular;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

public abstract class PopularMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;
    private String mVoteTextView;

    public PopularMovieListItemAbsViewModel(MovieEntity movie) {
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
