package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils;

/* loaded from: classes6.dex */
public interface DraweePlaceHolderConfig {
    Drawable getFailureDrawable();

    int getFailureImageColorRes();

    int getFailureImageDrawableRes();

    ScalingUtils.ScaleType getFailureScaleType();

    Drawable getPlaceHolderDrawable();

    int getPlaceHolderImageColorRes();

    int getPlaceHolderImageDrawableRes();

    ScalingUtils.ScaleType getPlaceHolderScaleType();
}
