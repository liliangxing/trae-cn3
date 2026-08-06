package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ArtBitmapFactory extends PlatformBitmapFactory {
    private final BitmapPool mBitmapPool;

    public ArtBitmapFactory(BitmapPool bitmapPool) {
        this.mBitmapPool = bitmapPool;
    }

    public BitmapPool getBitmapPool() {
        return this.mBitmapPool;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = this.mBitmapPool.get(BitmapUtil.getSizeInByteForBitmap(i, i2, config));
        Preconditions.checkArgument(bitmap.getAllocationByteCount() >= (i * i2) * BitmapUtil.getPixelSizeForBitmapConfig(config));
        bitmap.reconfigure(i, i2, config);
        return CloseableReference.m497of(bitmap, this.mBitmapPool);
    }
}
