package com.github.rkhusainov.moviefan.ui.upcoming;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.utils.DateUtils;

public class UpcomingMovieListItemViewModel extends UpcomingMovieListItemAbsViewModel {

    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String LIST_IMAGE_SIZE = "w154/";

    private String mImageUrl;
    private String mYearTextView;
    private String mVoteTextView;


    public UpcomingMovieListItemViewModel(Movie movie) {
        super(movie);

        mImageUrl = IMAGE_BASE_URL + LIST_IMAGE_SIZE + movie.getPosterPath();
        mYearTextView = DateUtils.shortReleaseDateFormat(movie.getReleaseDate());
        mVoteTextView = String.valueOf(movie.getVoteAverage());
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getYearTextView() {
        return mYearTextView;
    }

    public String getVoteTextView() {
        return mVoteTextView;
    }
}
