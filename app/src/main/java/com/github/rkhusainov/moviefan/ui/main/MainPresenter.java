package com.github.rkhusainov.moviefan.ui.main;

import com.github.rkhusainov.moviefan.data.model.MovieResponse;
import com.github.rkhusainov.moviefan.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    private Disposable mDisposable;
    private IMainView mMainView;

    public MainPresenter(IMainView mainView) {
        mMainView = mainView;
    }

    public void getPopularMovies() {
        mDisposable = ApiUtils.getApi().getPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mMainView.showProgress();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        mMainView.hideProgress();
                    }
                })
                .subscribe(new Consumer<MovieResponse>() {
                    @Override
                    public void accept(MovieResponse movieResponse) throws Exception {
                        mMainView.showPopularMovies(movieResponse.getResults());
                    }
                });
    }

    public void onRefresh() {
        mMainView.onRefreshData();
    }

    public void handleDetach() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
