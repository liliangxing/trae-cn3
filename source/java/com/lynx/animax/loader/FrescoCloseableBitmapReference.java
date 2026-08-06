package com.lynx.animax.loader;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* loaded from: classes6.dex */
public class FrescoCloseableBitmapReference implements IAnimaXCloseableBitmapReference {
    private final CloseableReference<Bitmap> mBitmapCloseableReference;

    public FrescoCloseableBitmapReference(CloseableReference<Bitmap> closeableReference) {
        this.mBitmapCloseableReference = closeableReference.m9335clone();
    }

    @Override // com.lynx.animax.loader.IAnimaXCloseableBitmapReference
    public Bitmap get() {
        if (this.mBitmapCloseableReference.isValid()) {
            return this.mBitmapCloseableReference.get();
        }
        return null;
    }

    @Override // com.lynx.animax.loader.IAnimaXCloseableBitmapReference
    public void close() {
        this.mBitmapCloseableReference.close();
    }

    @Override // com.lynx.animax.loader.IAnimaXCloseableBitmapReference
    public boolean isValid() {
        return this.mBitmapCloseableReference.isValid();
    }
}
