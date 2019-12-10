package com.github.rkhusainov.moviefan.presentation.ui.top;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

public class MainTopMovieListItemViewModel extends TopMovieListItemAbsViewModel {

    private String mImageUrl;

    public MainTopMovieListItemViewModel(MovieEntity movie) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
