package com.github.rkhusainov.moviefan.ui.detail;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.data.model.detail.Detail;
import com.github.rkhusainov.moviefan.data.model.detail.Genre;
import com.github.rkhusainov.moviefan.utils.ApiUtils;
import com.github.rkhusainov.moviefan.utils.DateUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class DetailViewModel extends AndroidViewModel {

    private CompositeDisposable mCompositeDisposable;

    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private MutableLiveData<Boolean> mIsErrorVisible = new MutableLiveData();

    private String mPosterUrl;
    private String mMovieTitleTextView;
    private String mMovieOverviewTextView;
    private String mGenres;
    private String mReleaseYearTextView;
    private String mReleaseDateTextView;
    private String mRuntimeTextView;
    private String mVoteTextView;
    private String mVoteCountTextView;

    public DetailViewModel(int movieId, Application application) {
        super(application);

        mCompositeDisposable = new CompositeDisposable();
        loadDetail(movieId);
    }

    public void loadDetail(int movieId) {
        mCompositeDisposable.add(ApiUtils.getApi().getDetail(movieId, Constants.LANGUAGE, Constants.REGION)
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
                .subscribe(new Consumer<Detail>() {
                    @Override
                    public void accept(Detail detail) throws Exception {
                            bind(detail);
                        Log.d(TAG, "accept: Detail "+ detail.getTitle());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsErrorVisible.postValue(true);
                    }
                }));
    }

    private void bind(Detail detail) {
        mPosterUrl = Constants.IMAGE_BASE_URL + Constants.DETAIL_IMAGE_SIZE + detail.getPosterPath();
        mMovieTitleTextView = detail.getTitle();
        mMovieOverviewTextView = detail.getOverview();
        mGenres = getFormatGenres(detail);
        mReleaseYearTextView = DateUtils.yearFormat(detail.getReleaseDate());
        mReleaseDateTextView = DateUtils.longReleaseDateFormat(detail.getReleaseDate());
        mRuntimeTextView = (DateUtils.runtimeFormat(detail.getRuntime() != null ? detail.getRuntime() : 0));
        mVoteTextView = String.valueOf(detail.getVoteAverage());
        mVoteCountTextView = String.valueOf(detail.getVoteCount());
    }

    private String getFormatGenres(Detail detail) {
        StringBuilder builder = new StringBuilder();
        String separator = "";
        List<Genre> genres = detail.getGenres();
        for (Genre genre : genres) {
            builder.append(separator + genre.getName());
            separator = getApplication().getResources().getString(R.string.genres_separator);
        }
        return builder.toString();
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    public MutableLiveData<Boolean> getIsErrorVisible() {
        return mIsErrorVisible;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    public String getMovieTitleTextView() {
        Log.d(TAG, "getMovieTitleTextView: TITLE " + mMovieTitleTextView);
        return mMovieTitleTextView;
    }

    public String getMovieOverviewTextView() {
        return mMovieOverviewTextView;
    }

    public String getGenres() {
        return mGenres;
    }

    public String getReleaseYearTextView() {
        return mReleaseYearTextView;
    }

    public String getReleaseDateTextView() {
        return mReleaseDateTextView;
    }

    public String getRuntimeTextView() {
        return mRuntimeTextView;
    }

    public String getVoteTextView() {
        return mVoteTextView;
    }

    public String getVoteCountTextView() {
        return mVoteCountTextView;
    }
}
