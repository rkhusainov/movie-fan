package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.common.IBaseView;
import com.github.rkhusainov.moviefan.data.model.Movie;

import java.util.List;

public interface IPopularMoviesView extends IBaseView {
    void showPopularMovies(List<Movie> movies);
}
