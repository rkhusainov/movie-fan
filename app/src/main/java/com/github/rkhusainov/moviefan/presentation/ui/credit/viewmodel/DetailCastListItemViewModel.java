package com.github.rkhusainov.moviefan.presentation.ui.credit.viewmodel;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.ui.credit.viewmodel.base.CastListItemAbsViewModel;

/**
 * ViewModel для элемента списка актёров на экране с детальной информацией о фильме
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class DetailCastListItemViewModel extends CastListItemAbsViewModel {

    private String mImageUrl;

    /**
     * Конструктор для ViewModel
     *
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
