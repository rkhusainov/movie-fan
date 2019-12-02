package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;

public class MainPopularMovieListItemViewModel extends PopularMovieListItemAbsViewModel{
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String CARD_IMAGE_SIZE = "w342/";

    private String mImageUrl;

    public MainPopularMovieListItemViewModel(Movie movie) {
        super(movie);

        mImageUrl = IMAGE_BASE_URL + CARD_IMAGE_SIZE + movie.getPosterPath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
