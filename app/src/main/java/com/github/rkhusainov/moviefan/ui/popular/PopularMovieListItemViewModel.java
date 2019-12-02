package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.utils.DateUtils;

public class PopularMovieListItemViewModel extends PopularMovieListItemAbsViewModel {

    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String LIST_IMAGE_SIZE = "w154/";

    private String mImageUrl;
    private String mYearTextView;
    private String mNumberTextView;

    public PopularMovieListItemViewModel(Movie movie, String number) {
        super(movie);

        mImageUrl = IMAGE_BASE_URL + LIST_IMAGE_SIZE + movie.getPosterPath();
        mYearTextView = DateUtils.yearFormat(movie.getReleaseDate());
        mNumberTextView = number;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getYearTextView() {
        return mYearTextView;
    }

    public String getNumberTextView() {
        return mNumberTextView;
    }
}
