package com.github.rkhusainov.moviefan.presentation.ui.popular.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ViewModel для списка популярных фильмов
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class PopularMovieViewModel extends ViewModel {

    private final CompositeDisposable mCompositeDisposable;
    private IMovieInteractor mMovieInteractor;

    private MutableLiveData<OnItemClickListener> mLiveDataOnItemClickListener = new MutableLiveData<>();
    private MutableLiveData<Integer> mViewType = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<List<MovieEntity>> mMovies = new MutableLiveData<>();

    /**
     * Конструктор для ViewModel
     *
     * @param viewType   тип ViewHolder'a
     * @param interactor экземпляр интерфейса интерактора
     */
    public PopularMovieViewModel(int viewType, @NonNull IMovieInteractor interactor) {
        mCompositeDisposable = new CompositeDisposable();
        mMovieInteractor = interactor;
        loadMovies();
        mMovies.setValue(new ArrayList<>());
        mViewType.postValue(viewType);
    }

    /**
     * Получение данных и обновление списка
     */
    public void loadMovies() {
        mCompositeDisposable.add(mMovieInteractor.getPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mIsLoading.postValue(true))
                .doFinally(() -> mIsLoading.postValue(false))
                .subscribe(movieEntities -> {
                    mIsErrorVisible.postValue(false);
                    mMovies.postValue(movieEntities);
                }, throwable -> mIsErrorVisible.postValue(true)));
    }

    /**
     * Getter для переменной LiveDataOnItemClickListener'a
     */
    public MutableLiveData<OnItemClickListener> getLiveDataOnItemClickListener() {
        return mLiveDataOnItemClickListener;
    }

    /**
     * Getter для строки с типом ViewHolder'a
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
     * Getter для списка фильмов
     */
    @NonNull
    public MutableLiveData<List<MovieEntity>> getMovies() {
        return mMovies;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
    }
}
