package com.github.rkhusainov.moviefan.ui.today;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;

public class MainTodayMovieListItemViewModel {

    private int mId;
    private String mImageUrl;
    private String mTitleTextView;
    private String mVoteTextView;

    public MainTodayMovieListItemViewModel(Movie movie) {
        mId = movie.getId();
        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
        mTitleTextView = movie.getTitle();
        mVoteTextView = String.valueOf(movie.getVoteAverage());
    }

    public int getId() {
        return mId;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getTitleTextView() {
        return mTitleTextView;
    }

    public String getVoteTextView() {
        return mVoteTextView;
    }
}
