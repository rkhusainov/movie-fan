package com.github.rkhusainov.moviefan.presentation.ui.upcoming;

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

public class UpcomingViewModel extends ViewModel {

    private final CompositeDisposable mCompositeDisposable;
    private OnItemClickListener mOnItemClickListener;
    private IMovieInteractor mMovieInteractor;

    private MutableLiveData<Integer> mViewType = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<List<MovieEntity>> mMovies = new MutableLiveData<>();

    public UpcomingViewModel(OnItemClickListener onItemClickListener, int viewType, IMovieInteractor interactor) {
        mCompositeDisposable = new CompositeDisposable();
        mOnItemClickListener = onItemClickListener;
        mMovieInteractor = interactor;
        loadMovies();
        mMovies.setValue(new ArrayList<>());
        mViewType.postValue(viewType);
    }

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

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
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

    public MutableLiveData<List<MovieEntity>> getMovies() {
        return mMovies;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
    }
}
