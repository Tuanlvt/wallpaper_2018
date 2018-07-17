package com.tuanlvt.wallpaper.model;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 07/06/2018.
 * tantuan127@gmail.com
 */
public class TypeWallpaperModel {
    private String mTextTitle;
    private int mImageTitle;

    public TypeWallpaperModel(String textTitle, int imageTitle) {
        mTextTitle = textTitle;
        mImageTitle = imageTitle;
    }

    public String getTextTitle() {
        return mTextTitle;
    }

    public void setTextTitle(String textTitle) {
        mTextTitle = textTitle;
    }

    public int getImageTitle() {
        return mImageTitle;
    }

    public void setImageTitle(int imageTitle) {
        mImageTitle = imageTitle;
    }
}
