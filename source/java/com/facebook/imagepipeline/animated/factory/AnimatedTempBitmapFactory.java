package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public interface AnimatedTempBitmapFactory {
    public static final int DRAW_DECODE_FRAME = 2;
    public static final int PRE_DECODE_FRAME = 1;

    Bitmap createBitmap(int i, int i2, Bitmap.Config config, int i3);
}
