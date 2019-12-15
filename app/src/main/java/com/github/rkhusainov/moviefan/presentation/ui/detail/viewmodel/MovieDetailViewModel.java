package com.github.rkhusainov.moviefan.presentation.ui.detail.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;

import org.jetbrains.annotations.NotNull;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ViewModel для детальной информации о фильме
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class MovieDetailViewModel extends ViewModel {

    private CompositeDisposable mCompositeDisposable;
    private IMovieInteractor mMovieInteractor;

    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<DetailEntity> mDetailLiveData = new MutableLiveData<>();

    /**
     * Конструктор для ViewModel
     *
     * @param movieId    ид фильма
     * @param interactor экземпляр интерфейса интерактора
     */
    public MovieDetailViewModel(int movieId, @NotNull IMovieInteractor interactor) {

        mCompositeDisposable = new CompositeDisposable();
        mMovieInteractor = interactor;
        loadDetail(movieId);
    }

    /**
     * Получение данных и обновление списка
     */
    public void loadDetail(int movieId) {
        mCompositeDisposable.add(mMovieInteractor.getDetail(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mIsLoading.postValue(true))
                .doFinally(() -> mIsLoading.postValue(false))
                .subscribe(
                        detailEntity -> mDetailLiveData.setValue(detailEntity),
                        throwable -> mIsErrorVisible.postValue(true)));
    }

    /**
     * Getter для детальной информации о фильме
     */
    public MutableLiveData<DetailEntity> getDetailLiveData() {
        return mDetailLiveData;
    }

    /**
     * Getter для состояния загрузки данных
     */
    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    /**
     * Getter для состояния видимости ошибки
     */
    public MutableLiveData<Boolean> getIsErrorVisible() {
        return mIsErrorVisible;
    }
}
