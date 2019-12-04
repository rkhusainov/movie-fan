package com.github.rkhusainov.moviefan.ui.detail;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.databinding.DetailBinding;
import com.github.rkhusainov.moviefan.ui.credit.CastFragment;
import com.github.rkhusainov.moviefan.ui.credit.CastViewModel;
import com.github.rkhusainov.moviefan.utils.CastFactory;
import com.github.rkhusainov.moviefan.utils.DetailFactory;

import static android.content.ContentValues.TAG;

public class DetailFragment extends Fragment {

    public static final String MOVIE_KEY = "MOVIE_KEY";
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";

    private int mMovieId;

    private DetailViewModel mDetailViewModel;
    private CastViewModel mCastViewModel;

    public static DetailFragment newInstance(int move_id) {

        Bundle args = new Bundle();
        args.putInt(MOVIE_KEY, move_id);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mMovieId = getArguments().getInt(MOVIE_KEY);

        DetailFactory detailFactory = new DetailFactory(mMovieId, getActivity().getApplication());
        mDetailViewModel = new ViewModelProvider(this, detailFactory).get(DetailViewModel.class);

        CastFactory castFactory = new CastFactory(Constants.DETAIL, mMovieId);
        mCastViewModel = new ViewModelProvider(this, castFactory).get(CastViewModel.class);
        Log.d(TAG, "onAttach: " + "ViewModel Init");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: " + "BINDING");
        DetailBinding binding = DetailBinding.inflate(inflater, container, false);
        binding.setDetail(mDetailViewModel);
        binding.setCast(mCastViewModel);
        binding.setHandler(this);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
        return binding.getRoot();
    }

    public void openAllCast() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, CastFragment.newInstance(mMovieId))
                .addToBackStack(null)
                .commit();
    }
}
