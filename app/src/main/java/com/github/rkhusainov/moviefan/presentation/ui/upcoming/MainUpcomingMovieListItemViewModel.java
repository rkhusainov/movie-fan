package com.github.rkhusainov.moviefan.presentation.ui.upcoming;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.utils.DateUtils;

public class MainUpcomingMovieListItemViewModel extends UpcomingMovieListItemAbsViewModel {

    private String mImageUrl;
    private String mYearTextView;

    public MainUpcomingMovieListItemViewModel(MovieEntity movie) {
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
