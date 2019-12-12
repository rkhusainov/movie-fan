package com.github.rkhusainov.moviefan.data.api;

import com.github.rkhusainov.moviefan.data.model.credit.Credit;
import com.github.rkhusainov.moviefan.data.model.detail.Detail;
import com.github.rkhusainov.moviefan.data.model.movie.MovieResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Rest запросы к web api
 */
public interface MoviefanApi {
    @GET("3/movie/popular")
    Single<MovieResponse> getPopularMovies(
            @Query("language") String language,
            @Query("region") String region
    );

    @GET("3/movie/now_playing")
    Single<MovieResponse> getTodayMovies(
            @Query("language") String language,
            @Query("region") String region
    );

    @GET("3/movie/top_rated")
    Single<MovieResponse> getTopMovies(
            @Query("language") String language,
            @Query("region") String region
    );

    @GET("3/movie/upcoming")
    Single<MovieResponse> getUpcomingMovies(
            @Query("language") String language,
            @Query("region") String region
    );

    @GET("3/movie/{movie_id}")
    Single<Detail> getDetail(
            @Path("movie_id") int id,
            @Query("language") String language,
            @Query("region") String region);

    @GET("3/movie/{movie_id}/credits")
    Single<Credit> getCredits(@Path("movie_id") int id);
}
