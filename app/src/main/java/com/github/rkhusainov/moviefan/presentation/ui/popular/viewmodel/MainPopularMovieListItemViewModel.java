package com.github.rkhusainov.moviefan.presentation.ui.popular.viewmodel;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.ui.popular.viewmodel.base.PopularMovieListItemAbsViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * ViewModel для элемента списка популярных фильмов на главном экране
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class MainPopularMovieListItemViewModel extends PopularMovieListItemAbsViewModel {

    private String mImageUrl;

    /**
     * @param movie данные текущего фильма
     */
    public MainPopularMovieListItemViewModel(@NotNull MovieEntity movie) {
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
