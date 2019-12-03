package com.github.rkhusainov.moviefan.ui.upcoming;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.databinding.UpcomingBinding;
import com.github.rkhusainov.moviefan.ui.detail.DetailFragment;
import com.github.rkhusainov.moviefan.utils.UpcomingMovieFactory;

public class UpcomingFragment extends Fragment {

    public static final int UPCOMING = 1;
    private UpcomingViewModel mUpcomingViewModel;

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

    public static UpcomingFragment newInstance() {
        return new UpcomingFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        UpcomingMovieFactory factory = new UpcomingMovieFactory(mOnItemClickListener, UPCOMING);
        mUpcomingViewModel = new ViewModelProvider(this, factory).get(UpcomingViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        UpcomingBinding binding = UpcomingBinding.inflate(inflater, container, false);
        binding.setUpcoming(mUpcomingViewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}
