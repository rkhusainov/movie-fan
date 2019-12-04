package com.github.rkhusainov.moviefan.ui.credit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.rkhusainov.moviefan.data.model.credit.Cast;
import com.github.rkhusainov.moviefan.data.model.credit.Credit;
import com.github.rkhusainov.moviefan.utils.ApiUtils;

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

    private MutableLiveData<Integer> mViewType = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<List<Cast>> mCasts = new MutableLiveData<>();

    public CastViewModel(int viewType, int movieId) {
        mCompositeDisposable = new CompositeDisposable();
        loadCast(movieId);
        mCasts.setValue(new ArrayList<>());
        mViewType.setValue(viewType);
    }

    public void loadCast(int movieId) {
        mCompositeDisposable.add(ApiUtils.getApi().getCredits(movieId)
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
                .subscribe(new Consumer<Credit>() {
                    @Override
                    public void accept(Credit credit) throws Exception {
                        mCasts.postValue(credit.getCast());
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

    public MutableLiveData<List<Cast>> getCasts() {
        return mCasts;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        mCompositeDisposable.dispose();
    }
}
