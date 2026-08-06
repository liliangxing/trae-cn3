package com.bytedance.fresco.sr;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* loaded from: classes2.dex */
interface ISuperResolution {
    void destroy();

    String getSRType();

    String getScaleType();

    CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) throws Exception;

    CloseableReference<Bitmap> processMultiScaleBitmap(int i, Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, int i2) throws Exception;

    CloseableReference<Bitmap> processMultiScaleBitmap(boolean z, Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, int i, int i2) throws Exception;
}
