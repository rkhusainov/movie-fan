package com.github.rkhusainov.moviefan.data.api;

import com.github.rkhusainov.moviefan.data.model.MovieResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MoviefanApi {
    @GET("3/movie/popular")
    Single<MovieResponse> getResponse();
}
