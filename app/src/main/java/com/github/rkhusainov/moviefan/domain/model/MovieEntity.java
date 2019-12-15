package com.github.rkhusainov.moviefan.domain.model;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Objects;

/**
 * Domain сущность, содержащая информацию о фильмах
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class MovieEntity {
    @NonNull
    private Integer mId;
    @NonNull
    private String mTitle;
    @NonNull
    private String mOriginalTitle;
    @NonNull
    private Double mPopularity;
    @NonNull
    private String mPosterPath;
    @NonNull
    private Double mVoteAverage;
    @NonNull
    private Integer mVoteCount;
    @NonNull
    private String mOverview;
    @NonNull
    private String mReleaseDate;
    @NonNull
    private Boolean mVideo;
    @NonNull
    private Boolean mAdult;
    @NonNull
    private String mBackdropPath;
    @NonNull
    private String mOriginalLanguage;
    @NonNull
    private List<Integer> mGenreIds;

    public MovieEntity(@NonNull Integer id,
                       @NonNull String title,
                       @NonNull String originalTitle,
                       @NonNull Double popularity,
                       @NonNull String posterPath,
                       @NonNull Double voteAverage,
                       @NonNull Integer voteCount,
                       @NonNull String overview,
                       @NonNull String releaseDate,
                       @NonNull Boolean video,
                       @NonNull Boolean adult,
                       @NonNull String backdropPath,
                       @NonNull String originalLanguage,
                       @NonNull List<Integer> genreIds) {
        mId = id;
        mTitle = title;
        mOriginalTitle = originalTitle;
        mPopularity = popularity;
        mPosterPath = posterPath;
        mVoteAverage = voteAverage;
        mVoteCount = voteCount;
        mOverview = overview;
        mReleaseDate = releaseDate;
        mVideo = video;
        mAdult = adult;
        mBackdropPath = backdropPath;
        mOriginalLanguage = originalLanguage;
        mGenreIds = genreIds;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public Double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(Double popularity) {
        mPopularity = popularity;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(Integer voteCount) {
        mVoteCount = voteCount;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public Boolean getVideo() {
        return mVideo;
    }

    public void setVideo(Boolean video) {
        mVideo = video;
    }

    public Boolean getAdult() {
        return mAdult;
    }

    public void setAdult(Boolean adult) {
        mAdult = adult;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        mOriginalLanguage = originalLanguage;
    }

    public List<Integer> getGenreIds() {
        return mGenreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        mGenreIds = genreIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return Objects.equals(mId, that.mId) &&
                Objects.equals(mTitle, that.mTitle) &&
                Objects.equals(mOriginalTitle, that.mOriginalTitle) &&
                Objects.equals(mPopularity, that.mPopularity) &&
                Objects.equals(mPosterPath, that.mPosterPath) &&
                Objects.equals(mVoteAverage, that.mVoteAverage) &&
                Objects.equals(mVoteCount, that.mVoteCount) &&
                Objects.equals(mOverview, that.mOverview) &&
                Objects.equals(mReleaseDate, that.mReleaseDate) &&
                Objects.equals(mVideo, that.mVideo) &&
                Objects.equals(mAdult, that.mAdult) &&
                Objects.equals(mBackdropPath, that.mBackdropPath) &&
                Objects.equals(mOriginalLanguage, that.mOriginalLanguage) &&
                Objects.equals(mGenreIds, that.mGenreIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mTitle, mOriginalTitle, mPopularity, mPosterPath, mVoteAverage, mVoteCount, mOverview, mReleaseDate, mVideo, mAdult, mBackdropPath, mOriginalLanguage, mGenreIds);
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mOriginalTitle='" + mOriginalTitle + '\'' +
                ", mPopularity=" + mPopularity +
                ", mPosterPath='" + mPosterPath + '\'' +
                ", mVoteAverage=" + mVoteAverage +
                ", mVoteCount=" + mVoteCount +
                ", mOverview='" + mOverview + '\'' +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", mVideo=" + mVideo +
                ", mAdult=" + mAdult +
                ", mBackdropPath='" + mBackdropPath + '\'' +
                ", mOriginalLanguage='" + mOriginalLanguage + '\'' +
                ", mGenreIds=" + mGenreIds +
                '}';
    }
}
