package com.github.rkhusainov.moviefan.presentation.ui.upcoming;

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

public class UpcomingMovieViewModel extends ViewModel {

    private final CompositeDisposable mCompositeDisposable;
    private OnItemClickListener mOnItemClickListener;
    private IMovieInteractor mMovieInteractor;

    private MutableLiveData<Integer> mViewType = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<List<MovieEntity>> mMovies = new MutableLiveData<>();

    /**
     * @param onItemClickListener экземпляр OnItemClickListener'a
     * @param viewType            тип ViewHolder'a
     * @param interactor          экземпляр интерфейса интерактора
     */
    public UpcomingMovieViewModel(@NonNull OnItemClickListener onItemClickListener, int viewType, @NonNull IMovieInteractor interactor) {
        mCompositeDisposable = new CompositeDisposable();
        mOnItemClickListener = onItemClickListener;
        mMovieInteractor = interactor;
        loadMovies();
        mMovies.setValue(new ArrayList<>());
        mViewType.postValue(viewType);
    }

    /**
     * Получение данных и обновление списка
     */
    public void loadMovies() {
        mCompositeDisposable.add(mMovieInteractor.getUpcomingMovies()
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
     * Getter для переменной clickListener'a
     */
    @NonNull
    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
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
