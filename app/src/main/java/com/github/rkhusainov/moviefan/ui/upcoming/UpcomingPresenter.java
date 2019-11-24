package com.github.rkhusainov.moviefan.ui.upcoming;

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

public class UpcomingPresenter extends BasePresenter {
    private IUpcomingView mUpcomingView;

    public UpcomingPresenter(IUpcomingView upcomingView) {
        mUpcomingView = upcomingView;
    }

    public void getMovies() {
        mCompositeDisposable.add(ApiUtils.getApi().getUpcomingMovies(LANGUAGE,REGION)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mUpcomingView.showProgress();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        mUpcomingView.hideProgress();
                    }
                })
                .subscribe(new Consumer<MovieResponse>() {
                    @Override
                    public void accept(MovieResponse movieResponse) throws Exception {
                        mUpcomingView.showUpcomingMovies(movieResponse.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mUpcomingView.showError();
                    }
                }));
    }
}
