package com.github.rkhusainov.moviefan.ui.detail;

import com.github.rkhusainov.moviefan.common.IBaseView;
import com.github.rkhusainov.moviefan.data.model.detail.Detail;

public interface IDetailView extends IBaseView {
    void getDetail(Detail detail);
}
