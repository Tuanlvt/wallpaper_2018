package com.tuanlvt.wallpaper.screen.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import com.tuanlvt.wallpaper.R;
import com.tuanlvt.wallpaper.model.TypeWallpaperModel;
import com.tuanlvt.wallpaper.screen.listImage.ListWallpaperActivity;
import com.tuanlvt.wallpaper.screen.listImage.TypeWallpaper;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeAdapter.OnRecyclerViewListener {

    private HomeAdapter mHomeAdapter;
    private List<TypeWallpaperModel> mTypeWallpaperModels;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(
                    getResources().getDrawable(R.drawable.bg_tool_bar));
        }

        mProgressBar = findViewById(R.id.progress_bar_home);
        mProgressBar.setVisibility(View.VISIBLE);
        initView();
        initData();
    }

    private void initData() {
        mTypeWallpaperModels.clear();
        mTypeWallpaperModels.add(new TypeWallpaperModel(TypeWallpaper.TAB_3D, R.drawable.tree_d_h));
        mTypeWallpaperModels.add(
                new TypeWallpaperModel(TypeWallpaper.TAB_NATURE, R.drawable.nature_g));
        mTypeWallpaperModels.add(
                new TypeWallpaperModel(TypeWallpaper.TAB_ABSTRACT, R.drawable.abstract_a));
        mTypeWallpaperModels.add(new TypeWallpaperModel(TypeWallpaper.TAB_CARS, R.drawable.cars_k));
        mTypeWallpaperModels.add(
                new TypeWallpaperModel(TypeWallpaper.TAB_ANIMALS, R.drawable.animals_e));
        mTypeWallpaperModels.add(
                new TypeWallpaperModel(TypeWallpaper.TAB_SPORT, R.drawable.sport_k));
        mHomeAdapter.upDateData(mTypeWallpaperModels);
        mProgressBar.setVisibility(View.GONE);
    }

    private void initView() {
        mTypeWallpaperModels = new ArrayList<>();
        RecyclerView recyclerViewHome = findViewById(R.id.recycler_view_home);
        mHomeAdapter = new HomeAdapter(getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setLayoutManager(layoutManager);
        recyclerViewHome.setAdapter(mHomeAdapter);
        mHomeAdapter.setOnRecyclerViewItemClick(this);
    }

    @Override
    public void onItemClick(String typeTitle) {
        startActivity(
                new Intent(ListWallpaperActivity.newInstant(getApplicationContext(), typeTitle)));
    }
}
