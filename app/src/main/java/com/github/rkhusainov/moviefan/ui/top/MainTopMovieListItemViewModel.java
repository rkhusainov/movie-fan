package com.github.rkhusainov.moviefan.ui.top;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;

public class MainTopMovieListItemViewModel extends TopMovieListItemAbsViewModel {

    private String mImageUrl;

    public MainTopMovieListItemViewModel(Movie movie) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
