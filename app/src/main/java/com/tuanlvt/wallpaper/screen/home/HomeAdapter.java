package com.tuanlvt.wallpaper.screen.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tuanlvt.wallpaper.R;
import com.tuanlvt.wallpaper.model.TypeWallpaperModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 07/06/2018.
 * tantuan127@gmail.com
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context mContext;
    private List<TypeWallpaperModel> mListType;
    private OnRecyclerViewListener mOnRecyclerViewItemClick;

    HomeAdapter(Context context) {
        mContext = context;
        mListType = new ArrayList<>();
    }

    public void upDateData(List<TypeWallpaperModel> listType) {
        if (listType != null) {
            mListType.clear();
            mListType.addAll(listType);
            notifyDataSetChanged();
        }
    }

    public void setOnRecyclerViewItemClick(OnRecyclerViewListener onRecyclerViewItemClick) {
        mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view, mContext, mListType, mOnRecyclerViewItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBindView();
    }

    @Override
    public int getItemCount() {
        return mListType.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context mContext;
        private ImageView mImageType;
        private TextView mTextTitle;
        private List<TypeWallpaperModel> mTypeWallpaperModels;
        private OnRecyclerViewListener mItemClick;

        ViewHolder(View itemView, Context context, List<TypeWallpaperModel> wallpaperList,
                OnRecyclerViewListener itemClick) {
            super(itemView);
            mContext = context;
            mTypeWallpaperModels = wallpaperList;
            mItemClick = itemClick;
            mImageType = itemView.findViewById(R.id.image_item_home);
            mTextTitle = itemView.findViewById(R.id.text_title_type);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mItemClick.onItemClick(mTypeWallpaperModels.get(getAdapterPosition()).getTextTitle());
        }

        private void onBindView() {
            mTextTitle.setText(mTypeWallpaperModels.get(getAdapterPosition()).getTextTitle());
            Glide.with(mContext)
                    .load(mTypeWallpaperModels.get(getAdapterPosition()).getImageTitle())
                    .override(240, 342)
                    .fitCenter()
                    .into(mImageType);
        }
    }

    public interface OnRecyclerViewListener {
        void onItemClick(String typeTitle);
    }
}
