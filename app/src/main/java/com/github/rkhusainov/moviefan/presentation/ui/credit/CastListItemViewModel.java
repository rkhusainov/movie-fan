package com.github.rkhusainov.moviefan.presentation.ui.credit;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

public class CastListItemViewModel extends CastListItemAbsViewModel {

    private String mImageUrl;

    public CastListItemViewModel(CastEntity cast) {
        super(cast);
        mImageUrl = Constants.IMAGE_BASE_URL + Constants.LIST_IMAGE_SIZE + cast.getProfilePath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
