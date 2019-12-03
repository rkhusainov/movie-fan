package com.github.rkhusainov.moviefan.ui.upcoming;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.utils.DateUtils;

public class MainUpcomingMovieListItemViewModel extends UpcomingMovieListItemAbsViewModel {

    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String CARD_IMAGE_SIZE = "w342/";

    private String mImageUrl;
    private String mYearTextView;

    public MainUpcomingMovieListItemViewModel(Movie movie) {
        super(movie);

        mImageUrl = IMAGE_BASE_URL + CARD_IMAGE_SIZE + movie.getPosterPath();
        mYearTextView = DateUtils.shortReleaseDateFormat(movie.getReleaseDate());
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getYearTextView() {
        return mYearTextView;
    }
}
