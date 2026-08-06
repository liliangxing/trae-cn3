package com.lynx.animax.loader;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public class SimpleCloseableBitmapReference implements IAnimaXCloseableBitmapReference {
    private final Bitmap mBitmap;

    public SimpleCloseableBitmapReference(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    @Override // com.lynx.animax.loader.IAnimaXCloseableBitmapReference
    public Bitmap get() {
        if (isValid()) {
            return this.mBitmap;
        }
        return null;
    }

    @Override // com.lynx.animax.loader.IAnimaXCloseableBitmapReference
    public void close() {
        this.mBitmap.recycle();
    }

    @Override // com.lynx.animax.loader.IAnimaXCloseableBitmapReference
    public boolean isValid() {
        return !this.mBitmap.isRecycled();
    }
}
