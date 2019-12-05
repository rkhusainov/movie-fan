package com.github.rkhusainov.moviefan.ui.upcoming;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.utils.DateUtils;

public class MainUpcomingMovieListItemViewModel extends UpcomingMovieListItemAbsViewModel {

    private String mImageUrl;
    private String mYearTextView;

    public MainUpcomingMovieListItemViewModel(Movie movie) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
        mYearTextView = DateUtils.shortReleaseDateFormat(movie.getReleaseDate());
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getYearTextView() {
        return mYearTextView;
    }
}
