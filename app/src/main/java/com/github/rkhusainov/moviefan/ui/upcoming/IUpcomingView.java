package com.github.rkhusainov.moviefan.ui.upcoming;

import com.github.rkhusainov.moviefan.common.IBaseView;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;

import java.util.List;

public interface IUpcomingView extends IBaseView {
    void showUpcomingMovies(List<Movie> movies);
}
