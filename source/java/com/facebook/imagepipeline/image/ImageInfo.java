package com.facebook.imagepipeline.image;

import android.graphics.Rect;
import com.facebook.imageformat.ImageFormat;

/* loaded from: classes6.dex */
public interface ImageInfo {
    CalculateColorInfo getCalculateColorInfo();

    int getHeight();

    int getImageCount();

    ImageFormat getImageFormat();

    QualityInfo getQualityInfo();

    Rect getRegionToDecode();

    int getSampleSize();

    Rect getSmartCrop();

    int getWidth();

    void setCalculateColorInfo(CalculateColorInfo calculateColorInfo);
}
