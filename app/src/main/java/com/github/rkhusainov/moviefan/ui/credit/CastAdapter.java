package com.github.rkhusainov.moviefan.ui.credit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.data.model.credit.Cast;
import com.github.rkhusainov.moviefan.databinding.CastMovieBinding;
import com.github.rkhusainov.moviefan.databinding.DetailCastMovieBinding;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolderAbs> {

    private List<Cast> mCasts;
    private int mItemViewType;

    public CastAdapter(int itemViewType, List<Cast> casts) {
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

        Cast cast = mCasts.get(position);

        // биндим отличающиеся элементы
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

        void bind(Cast cast) {
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

        void bind(Cast cast) {
            mCastMovieBinding.setCast(new CastListItemViewModel(cast));
            mCastMovieBinding.executePendingBindings();
        }
    }
}
