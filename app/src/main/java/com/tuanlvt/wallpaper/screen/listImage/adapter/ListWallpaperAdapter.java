package com.tuanlvt.wallpaper.screen.listImage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.tuanlvt.wallpaper.R;
import com.tuanlvt.wallpaper.model.ImageResoure;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 06/06/2018.
 * tantuan127@gmail.com
 */
public class ListWallpaperAdapter extends RecyclerView.Adapter<ListWallpaperAdapter.ViewHolder> {

    private Context mContext;
    private List<ImageResoure> mListWallpaper;
    private OnRecyclerViewItemClick mRecyclerViewItemClick;

    public ListWallpaperAdapter(Context context) {
        mContext = context;
        mListWallpaper = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_wallpaper, parent, false);
        return new ViewHolder(view, mListWallpaper, mRecyclerViewItemClick);
    }

    public void onUpdateData(List<ImageResoure> listWallpaper) {
        if (listWallpaper != null) {
            mListWallpaper.clear();
            mListWallpaper.addAll(listWallpaper);
            notifyDataSetChanged();
        }
    }

    public void setRecyclerViewItemClick(OnRecyclerViewItemClick onRecyclerViewItemClick) {
        mRecyclerViewItemClick = onRecyclerViewItemClick;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mListWallpaper.get(position).getImageUrl())
                .override(180, 320)
                .fitCenter()
                .into(holder.mImageWallpaper);
    }

    @Override
    public int getItemCount() {
        return mListWallpaper != null ? mListWallpaper.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageWallpaper;
        private List<ImageResoure> mImageResoures;
        private OnRecyclerViewItemClick mRecyclerViewItemClick;

        ViewHolder(View itemView, List<ImageResoure> list,
                OnRecyclerViewItemClick recyclerViewItemClick) {
            super(itemView);
            mImageResoures = list;
            mRecyclerViewItemClick = recyclerViewItemClick;
            mImageWallpaper = itemView.findViewById(R.id.image_item_wallpaper);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mRecyclerViewItemClick != null) {
                mRecyclerViewItemClick.onItemClick(mImageResoures.get(getPosition()).getImageUrl());
            }
        }
    }

    public interface OnRecyclerViewItemClick {
        void onItemClick(int wallpaperId);
    }
}
