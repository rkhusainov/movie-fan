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
import com.github.rkhusainov.moviefan.data.model.Movie;
import com.github.rkhusainov.moviefan.ui.popular.PopularAdapter;
import com.github.rkhusainov.moviefan.ui.popular.PopularFragment;
import com.github.rkhusainov.moviefan.ui.today.TodayFragment;

import java.util.List;

import static com.github.rkhusainov.moviefan.ui.popular.PopularAdapter.MAIN;

public class MainFragment extends Fragment implements IMainView {

    private Button mPopularBtn;
    private Button mTodayBtn;
    private RecyclerView mPopularRecyclerView;
    private PopularAdapter mPopularAdapter = new PopularAdapter(MAIN);
    private MainPresenter mPresenter;
    private View mMainLayout;
    private View mErrorView;

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
        mMainLayout = view.findViewById(R.id.main_layout);
        mErrorView = view.findViewById(R.id.errorView);
        mPresenter = new MainPresenter(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPopularRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mPopularRecyclerView.setAdapter(mPopularAdapter);
        mPresenter.onRefresh();

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

    @Override
    public void showPopularMovies(List<Movie> movies) {
        mErrorView.setVisibility(View.GONE);
        mPopularAdapter.addData(movies);
    }

    @Override
    public void onRefreshData() {
        mPresenter.getPopularMovies();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {
        mErrorView.setVisibility(View.VISIBLE);
        mMainLayout.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.handleDetach();
    }
}
