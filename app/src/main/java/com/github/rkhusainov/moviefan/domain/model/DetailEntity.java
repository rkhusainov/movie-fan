package com.github.rkhusainov.moviefan.domain.model;

import com.github.rkhusainov.moviefan.data.model.detail.Genre;
import com.github.rkhusainov.moviefan.data.model.detail.ProductionCompany;
import com.github.rkhusainov.moviefan.data.model.detail.ProductionCountry;
import com.github.rkhusainov.moviefan.data.model.detail.SpokenLanguage;

import java.util.List;

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
}
