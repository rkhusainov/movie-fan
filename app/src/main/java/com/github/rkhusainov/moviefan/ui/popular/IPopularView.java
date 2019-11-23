package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.common.IBaseView;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;

import java.util.List;

public interface IPopularView extends IBaseView {
    void showPopularMovies(List<Movie> movies);
}
