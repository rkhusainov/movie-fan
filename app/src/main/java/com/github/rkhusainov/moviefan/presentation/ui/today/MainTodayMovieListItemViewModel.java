package com.github.rkhusainov.moviefan.presentation.ui.today;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

public class MainTodayMovieListItemViewModel {

    private int mId;
    private String mImageUrl;
    private String mTitleTextView;
    private String mVoteTextView;

    /**
     * @param movie данные текущего фильма
     */
    public MainTodayMovieListItemViewModel(@NonNull MovieEntity movie) {
        mId = movie.getId();
        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
        mTitleTextView = movie.getTitle();
        mVoteTextView = String.valueOf(movie.getVoteAverage());
    }

    /**
     * Getter для ид фильма
     */
    public int getId() {
        return mId;
    }

    /**
     * Getter для строки с url постера фильма
     */
    @NonNull
    public String getImageUrl() {
        return mImageUrl;
    }

    /**
     * Getter для строки с наименованием фильма
     */
    @NonNull
    public String getTitleTextView() {
        return mTitleTextView;
    }

    /**
     * Getter для строки с рейтингом фильма
     */
    @NonNull
    public String getVoteTextView() {
        return mVoteTextView;
    }
}
