package com.github.rkhusainov.moviefan.domain.model;

import java.util.List;
import java.util.Objects;

public class MovieEntity {
    private Integer mId;
    private String mTitle;
    private String mOriginalTitle;
    private Double mPopularity;
    private String mPosterPath;
    private Double mVoteAverage;
    private Integer mVoteCount;
    private String mOverview;
    private String mReleaseDate;
    private Boolean mVideo;
    private Boolean mAdult;
    private String mBackdropPath;
    private String mOriginalLanguage;
    private List<Integer> mGenreIds;

    public MovieEntity(Integer id,
                       String title,
                       String originalTitle,
                       Double popularity,
                       String posterPath,
                       Double voteAverage,
                       Integer voteCount,
                       String overview,
                       String releaseDate,
                       Boolean video,
                       Boolean adult,
                       String backdropPath,
                       String originalLanguage,
                       List<Integer> genreIds) {
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
