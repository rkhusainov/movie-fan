package com.github.rkhusainov.moviefan.ui.today;

import com.github.rkhusainov.moviefan.common.IBaseView;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;

import java.util.List;

public interface ITodayView extends IBaseView {
    void showTodayMovies(List<Movie> movies);
}
