package com.github.rkhusainov.moviefan.presentation.ui.top.viewmodel.base;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

/**
 * Абстрактная ViewModel для элемента списка топ фильмов
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class TopMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;
    private String mVoteTextView;

    /**
     * Конструктор для ViewModel
     *
     * @param movie данные текущего фильма
     */
    public TopMovieListItemAbsViewModel(@NonNull MovieEntity movie) {
        mId = movie.getId();
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
