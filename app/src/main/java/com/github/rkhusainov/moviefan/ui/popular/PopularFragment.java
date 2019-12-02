package com.github.rkhusainov.moviefan.ui.popular;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.databinding.PopularBinding;
import com.github.rkhusainov.moviefan.ui.detail.DetailFragment;
import com.github.rkhusainov.moviefan.utils.PopularMovieFactory;

public class PopularFragment extends Fragment {

    public static final int POPULAR = 1;

    private PopularViewModel mPopularViewModel;

    public static PopularFragment newInstance() {
        return new PopularFragment();
    }

    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onClick(int movie_id) {
            if (getFragmentManager() != null) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, DetailFragment.newInstance(movie_id))
                        .addToBackStack(null)
                        .commit();
            }
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        PopularMovieFactory factory = new PopularMovieFactory(mOnItemClickListener, POPULAR);
        mPopularViewModel = new ViewModelProvider(this, factory).get(PopularViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        PopularBinding binding = PopularBinding.inflate(inflater, container, false);
        binding.setPopular(mPopularViewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}