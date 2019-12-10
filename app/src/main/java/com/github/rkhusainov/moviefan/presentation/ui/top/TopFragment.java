package com.github.rkhusainov.moviefan.presentation.ui.top;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.databinding.TopBinding;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.presentation.ui.detail.DetailFragment;
import com.github.rkhusainov.moviefan.presentation.utils.TopMovieFactory;

public class TopFragment extends Fragment {

    private TopViewModel mTopViewModel;

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

    public static TopFragment newInstance() {
        return new TopFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        TopMovieFactory factory = new TopMovieFactory(mOnItemClickListener, Constants.TOP);
        mTopViewModel = new ViewModelProvider(this, factory).get(TopViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TopBinding binding = TopBinding.inflate(inflater, container, false);
        binding.setTop(mTopViewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}
