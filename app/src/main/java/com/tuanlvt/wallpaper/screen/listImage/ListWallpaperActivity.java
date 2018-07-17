package com.tuanlvt.wallpaper.screen.listImage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import com.tuanlvt.wallpaper.R;
import com.tuanlvt.wallpaper.model.ImageResoure;
import com.tuanlvt.wallpaper.screen.imageDetail.WallpaperDetailActivity;
import com.tuanlvt.wallpaper.screen.listImage.adapter.ListWallpaperAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 06/06/2018.
 * tantuan127@gmail.com
 */
public class ListWallpaperActivity extends AppCompatActivity
        implements ListWallpaperAdapter.OnRecyclerViewItemClick {

    private static final String EXTRA_TYPE_WALLPAPER = "EXTRA_TYPE_WALLPAPER";

    private ListWallpaperAdapter mAdapter;
    private ProgressBar mProgressBar;

    public static Intent newInstant(Context context, String titleType) {
        Intent intent = new Intent(context, ListWallpaperActivity.class);
        intent.putExtra(EXTRA_TYPE_WALLPAPER, titleType);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wallpaper);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mProgressBar = findViewById(R.id.progress_bar_list);
        mProgressBar.setVisibility(View.VISIBLE);

        initView();
        initData();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new ListWallpaperAdapter(getApplicationContext());
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setRecyclerViewItemClick(this);
    }

    private void initData() {
        String type = getIntent().getStringExtra(EXTRA_TYPE_WALLPAPER);
        List<ImageResoure> listWallpaper = new ArrayList<>();
        listWallpaper.clear();

        if (Objects.equals(type, TypeWallpaper.TAB_3D)) {
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_a));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_b));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_c));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_d));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_e));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_f));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_g));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_h));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_i));
            listWallpaper.add(new ImageResoure(R.drawable.tree_d_k));
        }
        if (Objects.equals(type, TypeWallpaper.TAB_NATURE)) {
            listWallpaper.add(new ImageResoure(R.drawable.nature_a));
            listWallpaper.add(new ImageResoure(R.drawable.nature_b));
            listWallpaper.add(new ImageResoure(R.drawable.nature_c));
            listWallpaper.add(new ImageResoure(R.drawable.nature_d));
            listWallpaper.add(new ImageResoure(R.drawable.nature_e));
            listWallpaper.add(new ImageResoure(R.drawable.nature_f));
            listWallpaper.add(new ImageResoure(R.drawable.nature_g));
            listWallpaper.add(new ImageResoure(R.drawable.nature_h));
            listWallpaper.add(new ImageResoure(R.drawable.nature_i));
            listWallpaper.add(new ImageResoure(R.drawable.nature_k));
        }
        if (Objects.equals(type, TypeWallpaper.TAB_ABSTRACT)) {
            listWallpaper.add(new ImageResoure(R.drawable.abstract_a));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_b));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_c));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_d));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_e));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_f));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_g));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_h));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_i));
            listWallpaper.add(new ImageResoure(R.drawable.abstract_k));
        }
        if (Objects.equals(type, TypeWallpaper.TAB_ANIMALS)) {
            listWallpaper.add(new ImageResoure(R.drawable.animals_a));
            listWallpaper.add(new ImageResoure(R.drawable.animals_b));
            listWallpaper.add(new ImageResoure(R.drawable.animals_c));
            listWallpaper.add(new ImageResoure(R.drawable.animals_d));
            listWallpaper.add(new ImageResoure(R.drawable.animals_e));
            listWallpaper.add(new ImageResoure(R.drawable.animals_f));
            listWallpaper.add(new ImageResoure(R.drawable.animals_g));
            listWallpaper.add(new ImageResoure(R.drawable.animals_h));
            listWallpaper.add(new ImageResoure(R.drawable.animals_i));
            listWallpaper.add(new ImageResoure(R.drawable.animals_k));
        }
        if (Objects.equals(type, TypeWallpaper.TAB_CARS)) {
            listWallpaper.add(new ImageResoure(R.drawable.cars_a));
            listWallpaper.add(new ImageResoure(R.drawable.cars_b));
            listWallpaper.add(new ImageResoure(R.drawable.cars_c));
            listWallpaper.add(new ImageResoure(R.drawable.cars_d));
            listWallpaper.add(new ImageResoure(R.drawable.cars_e));
            listWallpaper.add(new ImageResoure(R.drawable.cars_f));
            listWallpaper.add(new ImageResoure(R.drawable.cars_g));
            listWallpaper.add(new ImageResoure(R.drawable.cars_h));
            listWallpaper.add(new ImageResoure(R.drawable.cars_i));
            listWallpaper.add(new ImageResoure(R.drawable.cars_k));
        }
        if (Objects.equals(type, TypeWallpaper.TAB_SPORT)) {
            listWallpaper.add(new ImageResoure(R.drawable.sport_a));
            listWallpaper.add(new ImageResoure(R.drawable.sport_b));
            listWallpaper.add(new ImageResoure(R.drawable.sport_c));
            listWallpaper.add(new ImageResoure(R.drawable.sport_d));
            listWallpaper.add(new ImageResoure(R.drawable.sport_e));
            listWallpaper.add(new ImageResoure(R.drawable.sport_f));
            listWallpaper.add(new ImageResoure(R.drawable.sport_g));
            listWallpaper.add(new ImageResoure(R.drawable.sport_h));
            listWallpaper.add(new ImageResoure(R.drawable.sport_i));
            listWallpaper.add(new ImageResoure(R.drawable.sport_k));
        }

        mAdapter.onUpdateData(listWallpaper);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(int wallpaperId) {
        startActivity(new Intent(
                WallpaperDetailActivity.newInstant(getApplicationContext(), wallpaperId)));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return false;
        }
        return true;
    }
}
