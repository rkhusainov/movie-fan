package com.github.rkhusainov.moviefan.presentation.ui.top;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

public class TopMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;
    private String mVoteTextView;

    public TopMovieListItemAbsViewModel(MovieEntity movie) {
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
