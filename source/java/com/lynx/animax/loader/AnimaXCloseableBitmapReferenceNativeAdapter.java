package com.lynx.animax.loader;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public class AnimaXCloseableBitmapReferenceNativeAdapter {
    private final IAnimaXCloseableBitmapReference mCloseableBitmap;

    public static AnimaXCloseableBitmapReferenceNativeAdapter create(IAnimaXCloseableBitmapReference iAnimaXCloseableBitmapReference) {
        return new AnimaXCloseableBitmapReferenceNativeAdapter(iAnimaXCloseableBitmapReference);
    }

    private AnimaXCloseableBitmapReferenceNativeAdapter(IAnimaXCloseableBitmapReference iAnimaXCloseableBitmapReference) {
        this.mCloseableBitmap = iAnimaXCloseableBitmapReference;
    }

    public Bitmap get() {
        return this.mCloseableBitmap.get();
    }

    public void close() {
        this.mCloseableBitmap.close();
    }

    boolean isValid() {
        return this.mCloseableBitmap.isValid();
    }
}
