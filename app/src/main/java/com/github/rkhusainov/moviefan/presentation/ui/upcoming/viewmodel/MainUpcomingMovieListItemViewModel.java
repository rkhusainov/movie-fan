package com.github.rkhusainov.moviefan.presentation.ui.upcoming.viewmodel;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.viewmodel.base.UpcomingMovieListItemAbsViewModel;
import com.github.rkhusainov.moviefan.presentation.utils.DateUtils;

/**
 * ViewModel для элемента списка фильмов на главном экране, которые скоро покажут в кинотеатрах
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class MainUpcomingMovieListItemViewModel extends UpcomingMovieListItemAbsViewModel {

    private String mImageUrl;
    private String mYearTextView;

    /**
     * Конструктор для ViewModel
     *
     * @param movie данные текущего фильма
     */
    public MainUpcomingMovieListItemViewModel(@NonNull MovieEntity movie) {
        super(movie);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + movie.getPosterPath();
        mYearTextView = DateUtils.shortReleaseDateFormat(movie.getReleaseDate());
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
}
