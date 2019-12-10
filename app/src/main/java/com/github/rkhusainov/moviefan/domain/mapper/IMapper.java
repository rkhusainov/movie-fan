package com.github.rkhusainov.moviefan.domain.mapper;

import androidx.annotation.NonNull;

public interface IMapper<From, To> {
    @NonNull
    To convert(@NonNull From from);
}
