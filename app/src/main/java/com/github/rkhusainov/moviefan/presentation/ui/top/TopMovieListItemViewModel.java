package com.github.rkhusainov.moviefan.presentation.ui.top;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.utils.DateUtils;

public class TopMovieListItemViewModel extends TopMovieListItemAbsViewModel {

    private String mImageUrl;
    private String mYearTextView;
    private String mNumberTextView;

    /**
     * @param movie  данные текущего фильма
     * @param number порядковый номер фильма
     */
    public TopMovieListItemViewModel(@NonNull MovieEntity movie, String number) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.LIST_IMAGE_SIZE + movie.getPosterPath();
        mYearTextView = DateUtils.yearFormat(movie.getReleaseDate());
        mNumberTextView = number;
    }

    /**
     * Getter для строки с url постера фильма
     */
    @NonNull
    public String getImageUrl() {
        return mImageUrl;
    }

    /**
     * Getter для строки с годом выхода фильма
     */
    @NonNull
    public String getYearTextView() {
        return mYearTextView;
    }

    /**
     * Getter для строки с порядковым номером фильма
     */
    @NonNull
    public String getNumberTextView() {
        return mNumberTextView;
    }
}
