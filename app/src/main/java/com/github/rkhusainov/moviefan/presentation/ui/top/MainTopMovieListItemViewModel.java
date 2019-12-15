package com.github.rkhusainov.moviefan.presentation.ui.top;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

/**
 * ViewModel для элемента списка топ фильмов на главном экране
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class MainTopMovieListItemViewModel extends TopMovieListItemAbsViewModel {

    private String mImageUrl;

    /**
     * Конструктор для ViewModel
     *
     * @param movie данные текущего фильма
     */
    public MainTopMovieListItemViewModel(@NonNull MovieEntity movie) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
    }

    /**
     * Getter для строки с url постера фильма
     */
    @NonNull
    public String getImageUrl() {
        return mImageUrl;
    }
}
