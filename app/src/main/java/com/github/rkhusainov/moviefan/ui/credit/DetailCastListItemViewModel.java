package com.github.rkhusainov.moviefan.ui.credit;

import com.github.rkhusainov.moviefan.data.model.credit.Cast;
import com.github.rkhusainov.moviefan.Constants;

public class DetailCastListItemViewModel extends CastListItemAbsViewModel{

    private String mImageUrl;

    public DetailCastListItemViewModel(Cast cast) {
        super(cast);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + cast.getProfilePath();
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
