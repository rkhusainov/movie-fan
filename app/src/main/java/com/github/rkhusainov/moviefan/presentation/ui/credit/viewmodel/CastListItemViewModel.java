package com.github.rkhusainov.moviefan.presentation.ui.credit.viewmodel;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.ui.credit.viewmodel.base.CastListItemAbsViewModel;

/**
 * ViewModel для элемента списка актёров
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class CastListItemViewModel extends CastListItemAbsViewModel {

    private String mImageUrl;

    /**
     * Консрукторя для ViewModel
     *
     * @param cast данные текущего актёра
     */
    public CastListItemViewModel(@NonNull CastEntity cast) {
        super(cast);
        mImageUrl = Constants.IMAGE_BASE_URL + Constants.LIST_IMAGE_SIZE + cast.getProfilePath();
    }

    /**
     * Getter для строки с url фотографии актёра"
     */
    @NonNull
    public String getImageUrl() {
        return mImageUrl;
    }
}
