package com.github.rkhusainov.moviefan.presentation.ui.popular;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

public class MainPopularMovieListItemViewModel extends PopularMovieListItemAbsViewModel{

    private String mImageUrl;

    public MainPopularMovieListItemViewModel(MovieEntity movie) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
