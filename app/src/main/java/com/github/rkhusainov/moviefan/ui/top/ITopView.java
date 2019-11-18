package com.github.rkhusainov.moviefan.ui.top;

import com.github.rkhusainov.moviefan.common.IBaseView;
import com.github.rkhusainov.moviefan.data.model.Movie;

import java.util.List;

public interface ITopView extends IBaseView {
    void showTopMovies(List<Movie> movies);
}
