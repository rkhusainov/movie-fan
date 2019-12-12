package com.github.rkhusainov.moviefan.presentation.ui.popular;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

import org.jetbrains.annotations.NotNull;

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
