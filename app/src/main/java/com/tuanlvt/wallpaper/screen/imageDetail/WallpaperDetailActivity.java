package com.tuanlvt.wallpaper.screen.imageDetail;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import com.tuanlvt.wallpaper.R;
import java.io.IOException;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 06/06/2018.
 * tantuan127@gmail.com
 */
public class WallpaperDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EXTRA_URL_IMAGE = "EXTRA_URL_IMAGE";

    private int mImageUrl;
    private Button mButtonSelect;
    private ProgressBar mProgressBar;

    public static Intent newInstant(Context context, int imageUrl) {
        Intent intent = new Intent(context, WallpaperDetailActivity.class);
        intent.putExtra(EXTRA_URL_IMAGE, imageUrl);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mProgressBar = findViewById(R.id.progress_bar_detail);
        mProgressBar.setVisibility(View.VISIBLE);

        mImageUrl = getIntent().getIntExtra(EXTRA_URL_IMAGE, 0);
        mButtonSelect = findViewById(R.id.button_select);

        ImageView imageWallpaperDetail = findViewById(R.id.image_wallpaper_detail);
        imageWallpaperDetail.setImageResource(mImageUrl);
        mButtonSelect.setOnClickListener(this);
        mProgressBar.setVisibility(View.GONE);
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

    private void setWallpaperImage() throws IOException {
        WindowManager windowManager =
                (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        int deviceWidth = 0;
        int deviceHeight = 0;
        if (windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            deviceWidth = display.getWidth();
            deviceHeight = display.getHeight();
        }

        final WallpaperManager wallpaperManager =
                WallpaperManager.getInstance(getApplicationContext());
        wallpaperManager.setWallpaperOffsetSteps(1, 1);
        wallpaperManager.suggestDesiredDimensions(deviceWidth, deviceHeight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            showPopup(wallpaperManager);
        } else {

            wallpaperManager.setResource(mImageUrl);
        }
    }

    @Override
    public void onClick(View v) {
        mProgressBar.setVisibility(View.VISIBLE);
        try {
            setWallpaperImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mProgressBar.setVisibility(View.GONE);
    }

    private void showSnackBar() {
        Snackbar.make(mProgressBar, R.string.set_wallpaper, Snackbar.LENGTH_SHORT).show();
    }

    private void showPopup(final WallpaperManager wallpaperManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            PopupMenu popupMenu = new PopupMenu(getBaseContext(), mButtonSelect);
            popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
            popupMenu.setGravity(Gravity.CENTER_HORIZONTAL);
            popupMenu.getGravity();
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            try {
                                wallpaperManager.setResource(mImageUrl,
                                        WallpaperManager.FLAG_SYSTEM);
                                showSnackBar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case R.id.action_lock:
                            try {
                                wallpaperManager.setResource(mImageUrl, WallpaperManager.FLAG_LOCK);
                                showSnackBar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case R.id.action_both:
                            try {
                                wallpaperManager.setResource(mImageUrl,
                                        WallpaperManager.FLAG_SYSTEM);
                                wallpaperManager.setResource(mImageUrl, WallpaperManager.FLAG_LOCK);
                                showSnackBar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                    return true;
                }
            });
            popupMenu.show();
        }
    }
}
