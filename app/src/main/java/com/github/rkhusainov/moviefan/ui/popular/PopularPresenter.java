package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.common.BasePresenter;
import com.github.rkhusainov.moviefan.data.model.movie.MovieResponse;
import com.github.rkhusainov.moviefan.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.github.rkhusainov.moviefan.BuildConfig.LANGUAGE;
import static com.github.rkhusainov.moviefan.BuildConfig.REGION;

public class PopularPresenter extends BasePresenter {

    private IPopularView mMoviesView;

    public PopularPresenter(IPopularView moviesView) {
        mMoviesView = moviesView;
    }


}
