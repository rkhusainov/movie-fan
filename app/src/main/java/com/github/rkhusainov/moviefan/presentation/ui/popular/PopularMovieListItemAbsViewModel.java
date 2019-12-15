package com.github.rkhusainov.moviefan.presentation.ui.popular;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

/**
 * Абстрактная ViewModel для элемента списка популярных фильмов
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public abstract class PopularMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;
    private String mVoteTextView;

    /**
     * Конструктор для ViewModel
     *
     * @param movie данные текущего фильма
     */
    public PopularMovieListItemAbsViewModel(MovieEntity movie) {
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
