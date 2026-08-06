package com.lynx.tasm.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public interface ReleasableImage {
    Bitmap getBitmap();

    Drawable getDrawable();

    void release();
}
