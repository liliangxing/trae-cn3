package com.lynx.tasm.p001ui.image;

import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.lynx.tasm.LynxEnv;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TemporaryDraweeHolder extends DraweeHolder<GenericDraweeHierarchy> {
    private static Drawable sEmptyDrawable = new ColorDrawable();
    private CloseableReference<CloseableImage> mCurImage;
    private Drawable mDrawable;
    private ForwardingDrawable mForwardingDrawable;
    private Handler mUIHandler;

    public void onAttach() {
    }

    public TemporaryDraweeHolder(CloseableReference<CloseableImage> closeableReference) {
        super((DraweeHierarchy) null);
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mCurImage = closeableReference;
        this.mDrawable = new BitmapDrawable(LynxEnv.inst().getAppContext().getResources(), ((CloseableStaticBitmap) closeableReference.get()).getUnderlyingBitmap());
        this.mForwardingDrawable = new ForwardingDrawable(this.mDrawable);
    }

    public void onDetach() {
        this.mForwardingDrawable.setDrawable(sEmptyDrawable);
        this.mUIHandler.post(new Runnable() { // from class: com.lynx.tasm.ui.image.TemporaryDraweeHolder.1
            @Override // java.lang.Runnable
            public void run() {
                CloseableReference.closeSafely(TemporaryDraweeHolder.this.mCurImage);
            }
        });
    }

    public Drawable getTopLevelDrawable() {
        return this.mForwardingDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CloseableReference<CloseableImage> tryTemporaryDraweeHolder(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return null;
        }
        CloseableReference<CloseableImage> closeableReference = Fresco.getImagePipeline().getBitmapMemoryCache().get(Fresco.getImagePipeline().getCacheKeyFactory().getPostprocessedBitmapCacheKey(imageRequest, (Object) null));
        if (closeableReference == null || closeableReference.get() == null || !(closeableReference.get() instanceof CloseableStaticBitmap)) {
            return null;
        }
        return closeableReference;
    }
}
