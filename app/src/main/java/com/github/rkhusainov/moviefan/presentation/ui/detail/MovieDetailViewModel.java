package com.github.rkhusainov.moviefan.presentation.ui.detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailViewModel extends ViewModel {

    private CompositeDisposable mCompositeDisposable;
    private IMovieInteractor mMovieInteractor;

    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<DetailEntity> mDetailLiveData = new MutableLiveData<>();


    public MovieDetailViewModel(int movieId, IMovieInteractor interactor) {

        mCompositeDisposable = new CompositeDisposable();
        mMovieInteractor = interactor;
        loadDetail(movieId);
    }

    public void loadDetail(int movieId) {
        mCompositeDisposable.add(mMovieInteractor.getDetail(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mIsLoading.postValue(true);
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        mIsLoading.postValue(false);
                    }
                })
                .subscribe(new Consumer<DetailEntity>() {
                    @Override
                    public void accept(DetailEntity detailEntity) throws Exception {
                        mDetailLiveData.setValue(detailEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsErrorVisible.postValue(true);
                    }
                }));
    }


    public MutableLiveData<DetailEntity> getDetailLiveData() {
        return mDetailLiveData;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    public MutableLiveData<Boolean> getIsErrorVisible() {
        return mIsErrorVisible;
    }
}
