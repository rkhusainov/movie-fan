package com.github.rkhusainov.moviefan.presentation.ui.upcoming.viewmodel;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.viewmodel.base.UpcomingMovieListItemAbsViewModel;
import com.github.rkhusainov.moviefan.presentation.utils.DateUtils;

/**
 * ViewModel для элемента списка фильмов, которые скоро покажут в кинотеатрах
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class UpcomingMovieListItemViewModel extends UpcomingMovieListItemAbsViewModel {

    private String mImageUrl;
    private String mYearTextView;
    private String mVoteTextView;

    /**
     * Конструктор для ViewModel
     *
     * @param movie данные текущего фильма
     */
    public UpcomingMovieListItemViewModel(@NonNull MovieEntity movie) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.LIST_IMAGE_SIZE + movie.getPosterPath();
        mYearTextView = DateUtils.shortReleaseDateFormat(movie.getReleaseDate());
        mVoteTextView = String.valueOf(movie.getVoteAverage());
    }

    /**
     * Getter для строки с url постера фильма
     */
    @NonNull
    public String getImageUrl() {
        return mImageUrl;
    }

    /**
     * Getter для строки с датой выхода фильма
     */
    @NonNull
    public String getYearTextView() {
        return mYearTextView;
    }

    /**
     * Getter для строки с рейтингом фильма
     */
    @NonNull
    public String getVoteTextView() {
        return mVoteTextView;
    }
}
