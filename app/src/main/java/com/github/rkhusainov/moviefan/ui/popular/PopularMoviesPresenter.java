package com.github.rkhusainov.moviefan.ui.popular;

import com.github.rkhusainov.moviefan.data.model.MovieResponse;
import com.github.rkhusainov.moviefan.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PopularMoviesPresenter {

    private Disposable mDisposable;
    private IPopularMoviesView mMoviesView;

    public PopularMoviesPresenter(IPopularMoviesView moviesView) {
        mMoviesView = moviesView;
    }

    public void getMovies() {
        mDisposable = ApiUtils.getApi().getResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mMoviesView.showProgress();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        mMoviesView.hideProgress();
                    }
                })
                .subscribe(new Consumer<MovieResponse>() {
                    @Override
                    public void accept(MovieResponse movieResponse) throws Exception {
                        mMoviesView.showPopularMovies(movieResponse.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mMoviesView.showError();
                    }
                });
    }

    public void handleDispose() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
