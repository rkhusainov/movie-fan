package com.github.rkhusainov.moviefan.presentation.ui.upcoming;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

/**
 * Абстрактная ViewModel для элемента списка фильмов, которые скоро покажут в кинотеатрах
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class UpcomingMovieListItemAbsViewModel {

    private int mId;
    private String mTitleTextView;

    /**
     * Конструктор для ViewModel
     *
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
