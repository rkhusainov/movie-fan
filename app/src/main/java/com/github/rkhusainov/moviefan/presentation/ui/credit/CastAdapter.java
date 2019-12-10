package com.github.rkhusainov.moviefan.presentation.ui.credit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.databinding.CastMovieBinding;
import com.github.rkhusainov.moviefan.databinding.DetailCastMovieBinding;
import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolderAbs> {

    private List<CastEntity> mCasts;
    private int mItemViewType;

    public CastAdapter(int itemViewType, List<CastEntity> casts) {
        mItemViewType = itemViewType;
        mCasts = casts;
    }

    @NonNull
    @Override
    public CastViewHolderAbs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (mItemViewType == Constants.DETAIL) {
            DetailCastMovieBinding binding = DetailCastMovieBinding.inflate(inflater, parent, false);
            return new DetailCastViewHolder(binding);
        } else {
            CastMovieBinding binding = CastMovieBinding.inflate(inflater, parent, false);
            return new CastViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolderAbs holder, int position) {

        CastEntity cast = mCasts.get(position);

        if (mItemViewType == Constants.DETAIL) {
            ((DetailCastViewHolder) holder).bind(cast);
        } else {
            ((CastViewHolder) holder).bind(cast);
        }
    }

    @Override
    public int getItemCount() {
        return mCasts.size();
    }

    abstract class CastViewHolderAbs extends RecyclerView.ViewHolder {

        public CastViewHolderAbs(@NonNull View itemView) {
            super(itemView);
        }
    }

    class DetailCastViewHolder extends CastViewHolderAbs {

        private DetailCastMovieBinding mDetailCastMovieBinding;

        public DetailCastViewHolder(DetailCastMovieBinding binding) {
            super(binding.getRoot());

            mDetailCastMovieBinding = binding;
        }

        void bind(CastEntity cast) {
            mDetailCastMovieBinding.setCast(new DetailCastListItemViewModel(cast));
            mDetailCastMovieBinding.executePendingBindings();
        }
    }

    class CastViewHolder extends CastViewHolderAbs {

        private CastMovieBinding mCastMovieBinding;

        public CastViewHolder(CastMovieBinding binding) {
            super(binding.getRoot());

            mCastMovieBinding = binding;
        }

        void bind(CastEntity cast) {
            mCastMovieBinding.setCast(new CastListItemViewModel(cast));
            mCastMovieBinding.executePendingBindings();
        }
    }
}
