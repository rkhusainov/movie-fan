package com.github.rkhusainov.moviefan.ui.credit;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.data.model.credit.Cast;

public class CastListItemViewModel extends CastListItemAbsViewModel {

    private String mImageUrl;

    public CastListItemViewModel(Cast cast) {
        super(cast);
        mImageUrl = Constants.IMAGE_BASE_URL + Constants.LIST_IMAGE_SIZE + cast.getProfilePath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
