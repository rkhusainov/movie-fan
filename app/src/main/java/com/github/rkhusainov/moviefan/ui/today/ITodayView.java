package com.github.rkhusainov.moviefan.ui.today;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;

import java.util.List;

public interface ITodayView {
    void showTodayMovies(List<Movie> movies);
}
