package com.github.rkhusainov.moviefan.ui.credit;

import com.github.rkhusainov.moviefan.common.IBaseView;
import com.github.rkhusainov.moviefan.data.model.credit.Cast;

import java.util.List;

public interface ICastView extends IBaseView {
    void getCast(List<Cast> casts);
}
