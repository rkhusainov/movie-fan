package com.github.rkhusainov.moviefan.ui.detail;

import com.github.rkhusainov.moviefan.common.BasePresenter;
import com.github.rkhusainov.moviefan.data.model.Detail;
import com.github.rkhusainov.moviefan.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailPresenter extends BasePresenter {
    private IDetailView mDetailView;

    public DetailPresenter(IDetailView detailView) {
        mDetailView = detailView;
    }

    public void getDetail(int movie_id) {
        mCompositeDisposable.add(ApiUtils.getApi().getDetail(movie_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mDetailView.showProgress();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        mDetailView.hideProgress();
                    }
                })
                .subscribe(new Consumer<Detail>() {
                    @Override
                    public void accept(Detail detail) throws Exception {
                        mDetailView.getDetail(detail);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mDetailView.showError();
                    }
                }));
    }
}
