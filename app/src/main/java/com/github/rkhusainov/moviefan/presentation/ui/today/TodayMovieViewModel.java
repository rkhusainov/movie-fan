package com.github.rkhusainov.moviefan.presentation.ui.today;

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
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TodayMovieViewModel extends ViewModel {

    private final CompositeDisposable mCompositeDisposable;
    private IMovieInteractor mMovieInteractor;

    private MutableLiveData<OnItemClickListener> mLiveDataOnItemClickListener = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<List<MovieEntity>> mMovies = new MutableLiveData<>();

    /**
     * @param interactor экземпляр интерфейса интерактора
     */
    public TodayMovieViewModel(@NonNull IMovieInteractor interactor) {
        mCompositeDisposable = new CompositeDisposable();
        mMovieInteractor = interactor;
        loadMovies();
        mMovies.setValue(new ArrayList<>());
    }

    /**
     * Получение данных и обновление списка
     */
    public void loadMovies() {
        mCompositeDisposable.add(mMovieInteractor.getTodayMovies()
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
                .subscribe(new Consumer<List<MovieEntity>>() {
                    @Override
                    public void accept(List<MovieEntity> movieEntities) throws Exception {
                        mIsErrorVisible.postValue(false);
                        mMovies.postValue(movieEntities);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsErrorVisible.postValue(true);
                    }
                }));
    }

    /**
     * Getter для переменной LiveDataOnItemClickListener'a
     */
    public MutableLiveData<OnItemClickListener> getLiveDataOnItemClickListener() {
        return mLiveDataOnItemClickListener;
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
