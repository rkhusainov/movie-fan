package com.github.rkhusainov.moviefan.presentation.ui.credit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.model.CastEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CastViewModel extends ViewModel {

    private final CompositeDisposable mCompositeDisposable;
    private final IMovieInteractor mMovieInteractor;

    private MutableLiveData<Integer> mViewType = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<List<CastEntity>> mCasts = new MutableLiveData<>();

    public CastViewModel(int viewType, int movieId, IMovieInteractor interactor) {
        mCompositeDisposable = new CompositeDisposable();
        mMovieInteractor = interactor;
        loadCast(movieId);
        mCasts.setValue(new ArrayList<>());
        mViewType.setValue(viewType);
    }

    public void loadCast(int movieId) {
        mCompositeDisposable.add(mMovieInteractor.getCasts(movieId)
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
                .subscribe(new Consumer<List<CastEntity>>() {
                    @Override
                    public void accept(List<CastEntity> castEntities) throws Exception {
                        mCasts.postValue(castEntities);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsErrorVisible.postValue(true);
                    }
                }));
    }

    public MutableLiveData<Integer> getViewType() {
        return mViewType;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    public MutableLiveData<Boolean> getIsErrorVisible() {
        return mIsErrorVisible;
    }

    public MutableLiveData<List<CastEntity>> getCasts() {
        return mCasts;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
    }
}
