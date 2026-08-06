package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class GingerbreadBitmapFactory extends PlatformBitmapFactory {
    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Bitmap.Config config) {
        return CloseableReference.m497of(Bitmap.createBitmap(i, i2, config), SimpleBitmapReleaser.getInstance());
    }
}
