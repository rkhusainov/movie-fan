package com.github.rkhusainov.moviefan.data.api;

import com.github.rkhusainov.moviefan.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Класс, который добавляет api ключ к запросам к web api
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class ApiKeyInterceptor implements Interceptor {

    public static final String API_KEY_NAME = "api_key";

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl httpUrl = request
                .url()
                .newBuilder()
                .addQueryParameter(API_KEY_NAME, BuildConfig.API_KEY)
                .build();
        request = request.newBuilder().url(httpUrl).build();
        return chain.proceed(request);
    }
}
