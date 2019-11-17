package com.github.rkhusainov.moviefan.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.ui.popular.PopularAdapter;
import com.github.rkhusainov.moviefan.ui.popular.PopularFragment;
import com.github.rkhusainov.moviefan.ui.today.TodayFragment;

public class MainFragment extends Fragment {

    private Button mPopularBtn;
    private Button mTodayBtn;
    private RecyclerView mPopularRecyclerView;
    private PopularAdapter mPopularAdapter = new PopularAdapter();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_main, container, false);
        mPopularBtn = view.findViewById(R.id.btn_popular);
        mTodayBtn = view.findViewById(R.id.btn_today);
        mPopularRecyclerView = view.findViewById(R.id.recycler_popular);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPopularRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mPopularRecyclerView.setAdapter(mPopularAdapter);

        mPopularBtn.setOnClickListener(v -> {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, PopularFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        });

        mTodayBtn.setOnClickListener(v -> {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, TodayFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        });
    }
}
