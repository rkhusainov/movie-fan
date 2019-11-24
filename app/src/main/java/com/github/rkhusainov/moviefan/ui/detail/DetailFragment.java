package com.github.rkhusainov.moviefan.ui.detail;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.data.model.credit.Cast;
import com.github.rkhusainov.moviefan.data.model.detail.Detail;
import com.github.rkhusainov.moviefan.data.model.detail.Genre;
import com.github.rkhusainov.moviefan.ui.credit.CastAdapter;
import com.github.rkhusainov.moviefan.ui.credit.CastFragment;
import com.github.rkhusainov.moviefan.ui.credit.CastPresenter;
import com.github.rkhusainov.moviefan.ui.credit.ICastView;
import com.github.rkhusainov.moviefan.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailFragment extends Fragment implements IDetailView, ICastView {

    public static final String MOVIE_KEY = "MOVIE_KEY";
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String DETAIL_IMAGE_SIZE = "w200/";

    private DetailPresenter mPresenter = new DetailPresenter(this);
    private View mDetailLayout;
    private View mErrorView;
    private ProgressBar mProgressBar;
    private ImageView mPosterImageView;
    private TextView mMovieTitleTextView;
    private TextView mMovieOverviewTextView;
    private TextView mGenresTextView;
    private TextView mReleaseYearTextView;
    private TextView mReleaseDateTextView;
    private TextView mRuntimeTextView;
    private TextView mVoteTextView;
    private TextView mVoteCountTextView;
    private int mMovieId;

    private Button mCastButton;

    private RecyclerView mRecyclerView;
    private CastAdapter mCastAdapter = new CastAdapter(CastAdapter.DETAIL);
    private CastPresenter mCastPresenter;

    public static DetailFragment newInstance(int move_id) {

        Bundle args = new Bundle();
        args.putInt(MOVIE_KEY, move_id);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_detail, container, false);
        mDetailLayout = view.findViewById(R.id.detail_layout);
        mErrorView = view.findViewById(R.id.errorView);
        mProgressBar = view.findViewById(R.id.progress_bar);
        mPosterImageView = view.findViewById(R.id.iv_poster);
        mMovieTitleTextView = view.findViewById(R.id.tv_movie_title);
        mMovieOverviewTextView = view.findViewById(R.id.tv_movie_overview);
        mGenresTextView = view.findViewById(R.id.tv_movie_genre);
        mReleaseYearTextView = view.findViewById(R.id.tv_release_year);
        mReleaseDateTextView = view.findViewById(R.id.tv_release_date);
        mRuntimeTextView = view.findViewById(R.id.tv_movie_runtime);
        mVoteTextView = view.findViewById(R.id.tv_vote);
        mVoteCountTextView = view.findViewById(R.id.tv_vote_count);

        mRecyclerView = view.findViewById(R.id.recycler_cast);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mRecyclerView.setAdapter(mCastAdapter);

        mCastPresenter = new CastPresenter(this);

        mCastButton = view.findViewById(R.id.btn_cast);
        mCastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, CastFragment.newInstance(mMovieId))
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMovieId = getArguments().getInt(MOVIE_KEY);
        mPresenter.getDetail(mMovieId);
        mCastPresenter.getCast(mMovieId);
    }

    @Override
    public void getDetail(Detail detail) {
        bind(detail);
        mDetailLayout.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
    }

    private void bind(Detail detail) {
        Picasso.get()
                .load(IMAGE_BASE_URL + DETAIL_IMAGE_SIZE + detail.getPosterPath())
                .into(mPosterImageView);

        mMovieTitleTextView.setText(detail.getTitle());
        mMovieOverviewTextView.setText((detail.getOverview()));

        String separator = "";
        List<Genre> genres = detail.getGenres();
        for (Genre genre : genres) {
            mGenresTextView.append(separator + genre.getName());
            separator = getResources().getString(R.string.genres_separator);
        }

        mReleaseYearTextView.setText(DateUtils.yearFormat(detail.getReleaseDate()));
        mReleaseDateTextView.setText(DateUtils.longReleaseDateFormat(detail.getReleaseDate()));
        mRuntimeTextView.setText(DateUtils.runtimeFormat(detail.getRuntime() != null ? detail.getRuntime() : 0));
        mVoteTextView.setText(String.valueOf(detail.getVoteAverage()));
        mVoteCountTextView.setText(String.valueOf(detail.getVoteCount()));
    }

    @Override
    public void getCast(List<Cast> casts) {
        mCastAdapter.addData(casts);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        mErrorView.setVisibility(View.VISIBLE);
        mDetailLayout.setVisibility(View.GONE);
    }
}
