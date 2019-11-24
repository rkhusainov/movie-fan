package com.github.rkhusainov.moviefan.ui.main;

import com.github.rkhusainov.moviefan.ui.popular.IPopularView;
import com.github.rkhusainov.moviefan.ui.today.ITodayView;
import com.github.rkhusainov.moviefan.ui.top.ITopView;
import com.github.rkhusainov.moviefan.ui.upcoming.IUpcomingView;

public interface IMainView extends IPopularView, ITodayView, ITopView, IUpcomingView {
}
