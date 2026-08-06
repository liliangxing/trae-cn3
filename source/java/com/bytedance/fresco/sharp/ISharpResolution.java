package com.bytedance.fresco.sharp;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* loaded from: classes2.dex */
interface ISharpResolution {
    void destroy(int i);

    CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, int i, float f, float f2, float f3, boolean z, float f4, float f5) throws Exception;
}
