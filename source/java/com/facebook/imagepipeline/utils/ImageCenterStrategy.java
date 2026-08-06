package com.facebook.imagepipeline.utils;

import java.util.Map;

/* loaded from: classes6.dex */
public abstract class ImageCenterStrategy {
    public static final String IMAGE_RESULT_KEY_SHARPEN = "sharpen";
    public static final String IMAGE_RESULT_KEY_SR = "super_resolution";
    public static final int IMAGE_STRATEGY_TYPE_SHARPEN = 4;
    public static final int IMAGE_STRATEGY_TYPE_SR = 2;
    private static ImageCenterStrategy sStrategy;

    public abstract Map<String, Object> getImageStrategyResult(String str, Map<String, Object> map);

    public static ImageCenterStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageCenterStrategy imageCenterStrategy) {
        sStrategy = imageCenterStrategy;
    }
}
