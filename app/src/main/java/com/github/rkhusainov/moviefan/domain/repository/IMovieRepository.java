package com.github.rkhusainov.moviefan.domain.repository;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

import java.util.List;

import io.reactivex.Single;

/**
 * Репозиторий с методами для получения данных
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public interface IMovieRepository {

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
