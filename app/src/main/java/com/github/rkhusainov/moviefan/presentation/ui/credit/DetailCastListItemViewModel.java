package com.github.rkhusainov.moviefan.presentation.ui.credit;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

public class DetailCastListItemViewModel extends CastListItemAbsViewModel {

    private String mImageUrl;

    /**
     * @param cast данные текущего актёра
     */
    public DetailCastListItemViewModel(@NonNull CastEntity cast) {
        super(cast);

        mImageUrl = Constants.IMAGE_BASE_URL + Constants.CARD_IMAGE_SIZE + cast.getProfilePath();
    }

    /**
     * Getter для строки с url фотографии актёра"
     */
    @NonNull
    public String getImageUrl() {
        return mImageUrl;
    }
}
