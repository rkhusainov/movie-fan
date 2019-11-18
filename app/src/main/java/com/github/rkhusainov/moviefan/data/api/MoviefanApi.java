package com.github.rkhusainov.moviefan.data.api;

import com.github.rkhusainov.moviefan.data.model.Detail;
import com.github.rkhusainov.moviefan.data.model.MovieResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MoviefanApi {
    @GET("3/movie/popular")
    Single<MovieResponse> getPopularMovies();

    @GET("3/movie/now_playing")
    Single<MovieResponse> getTodayMovies();

    @GET("3/movie/top_rated")
    Single<MovieResponse> getTopMovies();

    @GET("3/movie/{movie_id}")
    Single<Detail> getDetail(@Path("movie_id") int id);
}
