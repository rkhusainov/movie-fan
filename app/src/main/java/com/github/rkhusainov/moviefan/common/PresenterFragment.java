package com.github.rkhusainov.moviefan.common;

import androidx.fragment.app.Fragment;

public abstract class PresenterFragment<P extends BasePresenter> extends Fragment {
    protected abstract P getPresenter();

    @Override
    public void onDetach() {
        super.onDetach();

        if (getPresenter() != null) {
            getPresenter().disposeAll();
        }
    }
}
