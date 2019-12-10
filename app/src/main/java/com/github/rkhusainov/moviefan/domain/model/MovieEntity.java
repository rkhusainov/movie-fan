package com.github.rkhusainov.moviefan.domain.model;

import java.util.List;

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
}
