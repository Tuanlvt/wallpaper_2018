package com.tuanlvt.wallpaper.screen.listImage;

import android.support.annotation.StringDef;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 06/06/2018.
 * tantuan127@gmail.com
 */

@StringDef({
        TypeWallpaper.TAB_3D, TypeWallpaper.TAB_NATURE, TypeWallpaper.TAB_ABSTRACT,
        TypeWallpaper.TAB_CARS, TypeWallpaper.TAB_ANIMALS, TypeWallpaper.TAB_SPORT
})
public @interface TypeWallpaper {
    String TAB_3D = "3D";
    String TAB_NATURE = "Nature";
    String TAB_ABSTRACT = "Abstract";
    String TAB_SPORT = "Sport";
    String TAB_CARS = "Cars";
    String TAB_ANIMALS = "Animals";
}
