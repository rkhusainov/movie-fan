package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;

public class MainPopularMovieListItemViewModel extends PopularMovieListItemAbsViewModel{

    private String mImageUrl;

    public MainPopularMovieListItemViewModel(Movie movie) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
