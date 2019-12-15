package com.github.rkhusainov.moviefan.presentation.ui.credit.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.model.CastEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ViewModel для списка актёров
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class CastViewModel extends ViewModel {

    private final CompositeDisposable mCompositeDisposable;
    private final IMovieInteractor mMovieInteractor;

    private MutableLiveData<Integer> mViewType = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<List<CastEntity>> mCasts = new MutableLiveData<>();

    /**
     * Конструктор для ViewModel
     *
     * @param viewType   тип ViewHolder'а
     * @param movieId    ид фильма
     * @param interactor экземпляр интерфейса интерактора
     */
    public CastViewModel(int viewType, int movieId, @NonNull IMovieInteractor interactor) {
        mCompositeDisposable = new CompositeDisposable();
        mMovieInteractor = interactor;
        loadCast(movieId);
        mCasts.setValue(new ArrayList<>());
        mViewType.setValue(viewType);
    }

    /**
     * Получение данных и обновление списка
     */
    public void loadCast(int movieId) {
        mCompositeDisposable.add(mMovieInteractor.getCasts(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mIsLoading.postValue(true))
                .doFinally(() -> mIsLoading.postValue(false))
                .subscribe(
                        castEntities -> mCasts.postValue(castEntities),
                        throwable -> mIsErrorVisible.postValue(true)));
    }

    /**
     * Getter для строки тип ViewHolder'а"
     */
    @NonNull
    public MutableLiveData<Integer> getViewType() {
        return mViewType;
    }

    /**
     * Getter для состояния загрузки данных
     */
    @NonNull
    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    /**
     * Getter для состояния видимости ошибки
     */
    @NonNull
    public MutableLiveData<Boolean> getIsErrorVisible() {
        return mIsErrorVisible;
    }

    /**
     * Getter для списка актёров
     */
    @NonNull
    public MutableLiveData<List<CastEntity>> getCasts() {
        return mCasts;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
    }
}
