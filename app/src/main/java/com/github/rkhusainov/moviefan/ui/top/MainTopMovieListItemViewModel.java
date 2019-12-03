package com.github.rkhusainov.moviefan.ui.top;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;

public class MainTopMovieListItemViewModel extends TopMovieListItemAbsViewModel {

    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String CARD_IMAGE_SIZE = "w342/";

    private String mImageUrl;

    public MainTopMovieListItemViewModel(Movie movie) {
        super(movie);

        mImageUrl = IMAGE_BASE_URL + CARD_IMAGE_SIZE + movie.getPosterPath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
