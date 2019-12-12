package com.github.rkhusainov.moviefan.domain.interactor;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

import java.util.List;

import io.reactivex.Single;

/**
 * Интерактора, отвечающий за получением данных из репозитория
 */
public interface IMovieInteractor {

    /**
     * Получение популярных фильмов
     *
     * @return возвращает Single список с фильмами
     */
    @NonNull
    Single<List<MovieEntity>> getPopularMovies();

    /**
     * Получение фильмов, которые сегодня показывают в кинотеатрах
     *
     * @return возвращает Single список с фильмами
     */
    @NonNull
    Single<List<MovieEntity>> getTodayMovies();

    /**
     * Получение топ фильмов
     *
     * @return возвращает Single список с фильмами
     */
    @NonNull
    Single<List<MovieEntity>> getTopMovies();

    /**
     * Получение фильмов, которые в скором будущем покажут в кинотеатрах
     *
     * @return возвращает Single список с фильмами
     */
    @NonNull
    Single<List<MovieEntity>> getUpcomingMovies();

    /**
     * Получение детальной информации о фильме
     *
     * @param movie_id ид фильма
     * @return возвращает Single данные с детальной информацией о фильме
     */
    @NonNull
    Single<DetailEntity> getDetail(int movie_id);

    /**
     * Получение актёров, снявшихся в фильме
     *
     * @param movie_id ид фильма
     * @return возвращает Single данные с детальной информацией о фильме
     */
    @NonNull
    Single<List<CastEntity>> getCasts(int movie_id);
}
