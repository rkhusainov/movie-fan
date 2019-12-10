package com.github.rkhusainov.moviefan.domain.interactor;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

import java.util.List;

import io.reactivex.Single;

public interface IMovieInteractor {
    Single<List<MovieEntity>> getPopularMovies();

    Single<List<MovieEntity>> getTodayMovies();

    Single<List<MovieEntity>> getTopMovies();

    Single<List<MovieEntity>> getUpcomingMovies();

    Single<DetailEntity> getDetail(int movie_id);

    Single<List<CastEntity>> getCasts(int movie_id);
}
