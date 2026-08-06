package com.lynx.tasm.p001ui.image;

import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class LynxDraweeController extends LynxAbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
    private final DrawableFactory mDefaultDrawableFactory;
    private ImageOriginListener mImageOriginListener;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public LynxDraweeController(AsyncDeferredReleaser asyncDeferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache) {
        super(asyncDeferredReleaser, executor, null, null);
        this.mDefaultDrawableFactory = drawableFactory;
        this.mMemoryCache = memoryCache;
    }

    public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, Object obj, ImageOriginListener imageOriginListener) {
        this.mImageOriginListener = imageOriginListener;
        super.initialize(str, obj);
        init(supplier);
    }

    private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier) {
        this.mDataSourceSupplier = supplier;
    }

    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeController
    public DataSource<CloseableReference<CloseableImage>> getDataSource() {
        return (DataSource) this.mDataSourceSupplier.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeController
    public Drawable createDrawable(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        CloseableImage closeableImage = (CloseableImage) closeableReference.get();
        Drawable createDrawable = this.mDefaultDrawableFactory.createDrawable(closeableImage);
        if (createDrawable != null) {
            return createDrawable;
        }
        throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeController
    public ImageInfo getImageInfo(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        return (ImageInfo) closeableReference.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeController
    public int getImageHash(CloseableReference<CloseableImage> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.getValueHash();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeController
    public void releaseImage(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference.closeSafely(closeableReference);
    }

    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeController
    protected void releaseDrawable(Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).dropCaches();
        }
    }

    public synchronized RequestListener getRequestListener() {
        return this.mImageOriginListener != null ? new ImageOriginRequestListener(getId(), this.mImageOriginListener) : null;
    }

    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeController
    public String toString() {
        return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
    }
}
