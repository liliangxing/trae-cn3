package com.bytedance.lynx.service.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.lynx.tasm.image.ReleasableImage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FrescoReleasableImage implements ReleasableImage {
    private final Bitmap mBitmap;
    private final Drawable mDrawable;
    private final CloseableReference<CloseableImage> mImageReference;

    public FrescoReleasableImage(CloseableReference<CloseableImage> closeableReference) {
        this.mImageReference = closeableReference;
        CloseableImage closeableImage = closeableReference != null ? (CloseableImage) closeableReference.get() : null;
        if (closeableImage instanceof CloseableBitmap) {
            this.mBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
        } else {
            this.mBitmap = null;
        }
        this.mDrawable = null;
    }

    public FrescoReleasableImage(Drawable drawable, CloseableReference<CloseableImage> closeableReference) {
        this.mImageReference = closeableReference;
        this.mDrawable = drawable;
        this.mBitmap = null;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public void release() {
        CloseableReference<CloseableImage> closeableReference = this.mImageReference;
        if (closeableReference != null) {
            CloseableReference.closeSafely(closeableReference);
        }
    }
}
