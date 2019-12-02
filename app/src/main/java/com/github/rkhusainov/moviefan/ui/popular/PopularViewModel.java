package com.github.rkhusainov.moviefan.ui.popular;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.data.model.movie.MovieResponse;
import com.github.rkhusainov.moviefan.utils.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.github.rkhusainov.moviefan.BuildConfig.LANGUAGE;
import static com.github.rkhusainov.moviefan.BuildConfig.REGION;

public class PopularViewModel extends ViewModel {

    private final CompositeDisposable mCompositeDisposable;
    private OnItemClickListener mOnItemClickListener;

    private MutableLiveData<Integer> mViewType = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();
    private MutableLiveData<List<Movie>> mMovies = new MutableLiveData<>();

    public PopularViewModel(OnItemClickListener onItemClickListener, int viewType) {
        mOnItemClickListener = onItemClickListener;
        mCompositeDisposable = new CompositeDisposable();
        loadMovies();
        mMovies.setValue(new ArrayList<>());
        mViewType.postValue(viewType);
    }

    public void loadMovies() {
        mCompositeDisposable.add(ApiUtils.getApi().getPopularMovies(LANGUAGE, REGION)
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
                .subscribe(new Consumer<MovieResponse>() {
                    @Override
                    public void accept(MovieResponse movieResponse) throws Exception {
                        mIsErrorVisible.postValue(false);
                        mMovies.postValue(movieResponse.getResults());
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

    public MutableLiveData<List<Movie>> getMovies() {
        return mMovies;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        mCompositeDisposable.clear();
    }
}