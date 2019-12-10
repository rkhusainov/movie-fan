package com.github.rkhusainov.moviefan.presentation.ui.credit;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

public class DetailCastListItemViewModel extends CastListItemAbsViewModel{

    private String mImageUrl;

    public DetailCastListItemViewModel(CastEntity cast) {
        super(cast);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + cast.getProfilePath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
