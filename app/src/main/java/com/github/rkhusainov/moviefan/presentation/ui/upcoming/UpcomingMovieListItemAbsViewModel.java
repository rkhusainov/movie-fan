package com.github.rkhusainov.moviefan.presentation.ui.upcoming;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

public class UpcomingMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;

    /**
     * @param movie данные текущего фильма
     */
    public UpcomingMovieListItemAbsViewModel(@NonNull MovieEntity movie) {
        mId = movie.getId();
        mTitleTextView = movie.getTitle();
    }

    /**
     * Getter для ид фильма
     */
    public int getId() {
        return mId;
    }

    /**
     * Getter для строки с наименованием фильма
     */
    @NonNull
    public String getTitleTextView() {
        return mTitleTextView;
    }
}
