package com.github.rkhusainov.moviefan.domain.model;

import com.github.rkhusainov.moviefan.data.model.detail.Genre;
import com.github.rkhusainov.moviefan.data.model.detail.ProductionCompany;
import com.github.rkhusainov.moviefan.data.model.detail.ProductionCountry;
import com.github.rkhusainov.moviefan.data.model.detail.SpokenLanguage;

import java.util.List;
import java.util.Objects;

public class DetailEntity {
    private Integer mId;
    private Boolean mAdult;
    private String mBackdropPath;
    private Object mBelongsToCollection;
    private Integer mBudget;
    private List<Genre> mGenres;
    private String mHomepage;
    private String mImdbId;
    private String mOriginalLanguage;
    private String mOriginalTitle;
    private String mOverview;
    private Double mPopularity;
    private String mPosterPath;
    private List<ProductionCompany> mProductionCompanies = null;
    private List<ProductionCountry> mProductionCountries = null;
    private String mReleaseDate;
    private Integer mRevenue;
    private Integer mRuntime;
    private List<SpokenLanguage> mSpokenLanguages = null;
    private String mStatus;
    private String mTagline;
    private String mTitle;
    private Boolean mVideo;
    private Double mVoteAverage;
    private Integer mVoteCount;

    public DetailEntity(Integer id,
                        Boolean adult,
                        String backdropPath,
                        Object belongsToCollection,
                        Integer budget,
                        List<Genre> genres,
                        String homepage,
                        String imdbId,
                        String originalLanguage,
                        String originalTitle,
                        String overview,
                        Double popularity,
                        String posterPath,
                        String releaseDate,
                        Integer revenue,
                        Integer runtime,
                        String status,
                        String tagline,
                        String title,
                        Boolean video,
                        Double voteAverage,
                        Integer voteCount) {
        mId = id;
        mAdult = adult;
        mBackdropPath = backdropPath;
        mBelongsToCollection = belongsToCollection;
        mBudget = budget;
        mGenres = genres;
        mHomepage = homepage;
        mImdbId = imdbId;
        mOriginalLanguage = originalLanguage;
        mOriginalTitle = originalTitle;
        mOverview = overview;
        mPopularity = popularity;
        mPosterPath = posterPath;
        mReleaseDate = releaseDate;
        mRevenue = revenue;
        mRuntime = runtime;
        mStatus = status;
        mTagline = tagline;
        mTitle = title;
        mVideo = video;
        mVoteAverage = voteAverage;
        mVoteCount = voteCount;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
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

    public Object getBelongsToCollection() {
        return mBelongsToCollection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        mBelongsToCollection = belongsToCollection;
    }

    public Integer getBudget() {
        return mBudget;
    }

    public void setBudget(Integer budget) {
        mBudget = budget;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }

    public String getHomepage() {
        return mHomepage;
    }

    public void setHomepage(String homepage) {
        mHomepage = homepage;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public void setImdbId(String imdbId) {
        mImdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        mOriginalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
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

    public List<ProductionCompany> getProductionCompanies() {
        return mProductionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        mProductionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return mProductionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        mProductionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public Integer getRevenue() {
        return mRevenue;
    }

    public void setRevenue(Integer revenue) {
        mRevenue = revenue;
    }

    public Integer getRuntime() {
        return mRuntime;
    }

    public void setRuntime(Integer runtime) {
        mRuntime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return mSpokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        mSpokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTagline() {
        return mTagline;
    }

    public void setTagline(String tagline) {
        mTagline = tagline;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Boolean getVideo() {
        return mVideo;
    }

    public void setVideo(Boolean video) {
        mVideo = video;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailEntity that = (DetailEntity) o;
        return Objects.equals(mId, that.mId) &&
                Objects.equals(mAdult, that.mAdult) &&
                Objects.equals(mBackdropPath, that.mBackdropPath) &&
                Objects.equals(mBelongsToCollection, that.mBelongsToCollection) &&
                Objects.equals(mBudget, that.mBudget) &&
                Objects.equals(mGenres, that.mGenres) &&
                Objects.equals(mHomepage, that.mHomepage) &&
                Objects.equals(mImdbId, that.mImdbId) &&
                Objects.equals(mOriginalLanguage, that.mOriginalLanguage) &&
                Objects.equals(mOriginalTitle, that.mOriginalTitle) &&
                Objects.equals(mOverview, that.mOverview) &&
                Objects.equals(mPopularity, that.mPopularity) &&
                Objects.equals(mPosterPath, that.mPosterPath) &&
                Objects.equals(mProductionCompanies, that.mProductionCompanies) &&
                Objects.equals(mProductionCountries, that.mProductionCountries) &&
                Objects.equals(mReleaseDate, that.mReleaseDate) &&
                Objects.equals(mRevenue, that.mRevenue) &&
                Objects.equals(mRuntime, that.mRuntime) &&
                Objects.equals(mSpokenLanguages, that.mSpokenLanguages) &&
                Objects.equals(mStatus, that.mStatus) &&
                Objects.equals(mTagline, that.mTagline) &&
                Objects.equals(mTitle, that.mTitle) &&
                Objects.equals(mVideo, that.mVideo) &&
                Objects.equals(mVoteAverage, that.mVoteAverage) &&
                Objects.equals(mVoteCount, that.mVoteCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mId,
                mAdult,
                mBackdropPath,
                mBelongsToCollection,
                mBudget,
                mGenres,
                mHomepage,
                mImdbId,
                mOriginalLanguage,
                mOriginalTitle,
                mOverview,
                mPopularity,
                mPosterPath,
                mProductionCompanies,
                mProductionCountries,
                mReleaseDate,
                mRevenue,
                mRuntime,
                mSpokenLanguages,
                mStatus,
                mTagline,
                mTitle,
                mVideo,
                mVoteAverage,
                mVoteCount);
    }

    @Override
    public String toString() {
        return "DetailEntity{" +
                "mId=" + mId +
                ", mAdult=" + mAdult +
                ", mBackdropPath='" + mBackdropPath + '\'' +
                ", mBelongsToCollection=" + mBelongsToCollection +
                ", mBudget=" + mBudget +
                ", mGenres=" + mGenres +
                ", mHomepage='" + mHomepage + '\'' +
                ", mImdbId='" + mImdbId + '\'' +
                ", mOriginalLanguage='" + mOriginalLanguage + '\'' +
                ", mOriginalTitle='" + mOriginalTitle + '\'' +
                ", mOverview='" + mOverview + '\'' +
                ", mPopularity=" + mPopularity +
                ", mPosterPath='" + mPosterPath + '\'' +
                ", mProductionCompanies=" + mProductionCompanies +
                ", mProductionCountries=" + mProductionCountries +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", mRevenue=" + mRevenue +
                ", mRuntime=" + mRuntime +
                ", mSpokenLanguages=" + mSpokenLanguages +
                ", mStatus='" + mStatus + '\'' +
                ", mTagline='" + mTagline + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mVideo=" + mVideo +
                ", mVoteAverage=" + mVoteAverage +
                ", mVoteCount=" + mVoteCount +
                '}';
    }
}
