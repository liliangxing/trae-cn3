package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CalculateColorInfo;
import com.facebook.imagepipeline.image.CloseableDrawable;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ColorCalculator;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    private static final Class<?> TAG = PipelineDraweeController.class;

    @Nullable
    private final MemoryCache<CacheKey, CloseableImage> mBigImgMemoryCache;
    private CacheKey mCacheKey;

    @Nullable
    private ImmutableList<DrawableFactory> mCustomDrawableFactories;
    private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
    private DebugOverlayImageOriginListener mDebugOverlayImageOriginListener;
    private final DrawableFactory mDefaultDrawableFactory;
    private boolean mDrawDebugOverlay;

    @Nullable
    private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;

    @Nullable
    private final ImmutableList<DrawableFactory> mGlobalDrawableFactories;

    @Nullable
    private ImageOriginListener mImageOriginListener;

    @Nullable
    private ImagePerfMonitor mImagePerfMonitor;

    @Nullable
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    @Nullable
    private final MemoryCache<CacheKey, CloseableImage> mPrefetchImgMemoryCache;

    @Nullable
    private Set<RequestListener> mRequestListeners;
    private final Resources mResources;

    @Nullable
    private final MemoryCache<CacheKey, CloseableImage> mSingleMemoryCache;

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, @Nullable MemoryCache<CacheKey, CloseableImage> memoryCache, @Nullable ImmutableList<DrawableFactory> immutableList) {
        super(deferredReleaser, executor, null, null);
        this.mResources = resources;
        this.mDefaultDrawableFactory = new DefaultDrawableFactory(resources, drawableFactory);
        this.mGlobalDrawableFactories = immutableList;
        this.mMemoryCache = memoryCache;
        this.mSingleMemoryCache = ImagePipelineFactory.getInstance().isEnableSingleCache() ? ImagePipelineFactory.getInstance().getSingleBitmapMemoryCache() : null;
        this.mBigImgMemoryCache = ImagePipelineFactory.getInstance().isEnableBigImgCache() ? ImagePipelineFactory.getInstance().getBigImgBitmapMemoryCache() : null;
        this.mPrefetchImgMemoryCache = ImagePipelineFactory.getInstance().isSplitPrefetchCache() ? ImagePipelineFactory.getInstance().getPrefetchImgBitmapMemoryCache() : null;
        this.mEncodedMemoryCache = ImagePipelineFactory.getInstance().getEncodedMemoryCache();
    }

    public static void setLimit(int i, long j, long j2) {
        DebugControllerOverlayDrawable.setLimit(i, j, j2);
    }

    public static void setPaintSizeRatio(float f) {
        DebugControllerOverlayDrawable.setPaintSizeRatio(f);
    }

    public static void setShowOverlayInfo(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        DebugControllerOverlayDrawable.showOverlayInfo(z, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11);
    }

    public static void setShowBigOverlayInfo(boolean z) {
        DebugControllerOverlayDrawable.showBigOverlayInfo(z);
    }

    public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, @Nullable ImmutableList<DrawableFactory> immutableList, @Nullable ImageOriginListener imageOriginListener) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#initialize");
        }
        super.initialize(str, obj);
        init(supplier);
        this.mCacheKey = cacheKey;
        setCustomDrawableFactories(immutableList);
        clearImageOriginListeners();
        maybeUpdateDebugOverlay(null);
        addImageOriginListener(imageOriginListener);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, @Nullable ImmutableList<DrawableFactory> immutableList, @Nullable ImageOriginListener imageOriginListener, ImageRequest imageRequest) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#initialize");
        }
        this.mCacheKey = cacheKey;
        super.initialize(str, obj, imageRequest);
        init(supplier);
        setCustomDrawableFactories(immutableList);
        clearImageOriginListeners();
        maybeUpdateDebugOverlay(null);
        addImageOriginListener(imageOriginListener);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void initializePerformanceMonitoring(@Nullable ImagePerfDataListener imagePerfDataListener) {
        ImagePerfMonitor imagePerfMonitor = this.mImagePerfMonitor;
        if (imagePerfMonitor != null) {
            imagePerfMonitor.reset();
        }
        if (imagePerfDataListener != null) {
            if (this.mImagePerfMonitor == null) {
                this.mImagePerfMonitor = new ImagePerfMonitor(AwakeTimeSinceBootClock.get(), this);
            }
            this.mImagePerfMonitor.addImagePerfDataListener(imagePerfDataListener);
            this.mImagePerfMonitor.setEnabled(true);
        }
    }

    public void setDrawDebugOverlay(boolean z) {
        this.mDrawDebugOverlay = z;
    }

    public void setCustomDrawableFactories(@Nullable ImmutableList<DrawableFactory> immutableList) {
        this.mCustomDrawableFactories = immutableList;
    }

    public synchronized void addRequestListener(RequestListener requestListener) {
        if (this.mRequestListeners == null) {
            this.mRequestListeners = new HashSet();
        }
        this.mRequestListeners.add(requestListener);
    }

    public synchronized void removeRequestListener(RequestListener requestListener) {
        Set<RequestListener> set = this.mRequestListeners;
        if (set == null) {
            return;
        }
        set.remove(requestListener);
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        ImageOriginListener imageOriginListener2 = this.mImageOriginListener;
        if (imageOriginListener2 instanceof ForwardingImageOriginListener) {
            ((ForwardingImageOriginListener) imageOriginListener2).addImageOriginListener(imageOriginListener);
        } else if (imageOriginListener2 != null) {
            this.mImageOriginListener = new ForwardingImageOriginListener(this.mImageOriginListener, imageOriginListener);
        } else {
            this.mImageOriginListener = imageOriginListener;
        }
    }

    public synchronized void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        ImageOriginListener imageOriginListener2 = this.mImageOriginListener;
        if (imageOriginListener2 instanceof ForwardingImageOriginListener) {
            ((ForwardingImageOriginListener) imageOriginListener2).removeImageOriginListener(imageOriginListener);
        } else if (imageOriginListener2 != null) {
            this.mImageOriginListener = new ForwardingImageOriginListener(this.mImageOriginListener, imageOriginListener);
        } else {
            this.mImageOriginListener = imageOriginListener;
        }
    }

    protected void clearImageOriginListeners() {
        synchronized (this) {
            this.mImageOriginListener = null;
        }
    }

    private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier) {
        this.mDataSourceSupplier = supplier;
        maybeUpdateDebugOverlay(null);
    }

    protected Resources getResources() {
        return this.mResources;
    }

    protected CacheKey getCacheKey() {
        return this.mCacheKey;
    }

    @Nullable
    public synchronized RequestListener getRequestListener() {
        ImageOriginRequestListener imageOriginRequestListener = this.mImageOriginListener != null ? new ImageOriginRequestListener(getId(), this.mImageOriginListener) : null;
        if (this.mRequestListeners == null) {
            return imageOriginRequestListener;
        }
        ForwardingRequestListener forwardingRequestListener = new ForwardingRequestListener(this.mRequestListeners);
        if (imageOriginRequestListener != null) {
            forwardingRequestListener.addRequestListener(imageOriginRequestListener);
        }
        return forwardingRequestListener;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public DataSource<CloseableReference<CloseableImage>> getDataSource() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#getDataSource");
        }
        if (FLog.isLoggable(2)) {
            FLog.m463v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        DataSource<CloseableReference<CloseableImage>> dataSource = this.mDataSourceSupplier.get();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return dataSource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Drawable createDrawable(CloseableReference<CloseableImage> closeableReference) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("PipelineDraweeController#createDrawable");
            }
            Preconditions.checkState(CloseableReference.isValid(closeableReference));
            CloseableImage closeableImage = closeableReference.get();
            maybeUpdateDebugOverlay(closeableImage);
            if (closeableImage instanceof CloseableDrawable) {
                return ((CloseableDrawable) closeableImage).getUnderlyingDrawable();
            }
            Drawable maybeCreateDrawableFromFactories = maybeCreateDrawableFromFactories(this.mCustomDrawableFactories, closeableImage);
            if (maybeCreateDrawableFromFactories != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return maybeCreateDrawableFromFactories;
            }
            Drawable maybeCreateDrawableFromFactories2 = maybeCreateDrawableFromFactories(this.mGlobalDrawableFactories, closeableImage);
            if (maybeCreateDrawableFromFactories2 != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return maybeCreateDrawableFromFactories2;
            }
            if (!Fresco.getImagePipeline().getWebpOptSwitch().isEnableWebpFrameCacheKeyOpt()) {
                closeableImage.setSourceUri(null);
            }
            Drawable createDrawable = this.mDefaultDrawableFactory.createDrawable(closeableImage, getDrawable());
            if (createDrawable == null) {
                throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return createDrawable;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private Drawable maybeCreateDrawableFromFactories(@Nullable ImmutableList<DrawableFactory> immutableList, CloseableImage closeableImage) {
        Drawable createDrawable;
        if (immutableList == null) {
            return null;
        }
        Iterator<DrawableFactory> it = immutableList.iterator();
        while (it.hasNext()) {
            DrawableFactory next = it.next();
            if (next.supportsImageType(closeableImage) && (createDrawable = next.createDrawable(closeableImage)) != null) {
                return createDrawable;
            }
        }
        return null;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@Nullable DraweeHierarchy draweeHierarchy) {
        super.setHierarchy(draweeHierarchy);
        maybeUpdateDebugOverlay(null);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public void clearHierarchy() {
        super.clearHierarchy();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean isSameImageRequest(@Nullable DraweeController draweeController) {
        CacheKey cacheKey = this.mCacheKey;
        if (cacheKey == null || !(draweeController instanceof PipelineDraweeController)) {
            return false;
        }
        return Objects.equal(cacheKey, ((PipelineDraweeController) draweeController).getCacheKey());
    }

    private void maybeUpdateDebugOverlay(@Nullable CloseableImage closeableImage) {
        ScaleTypeDrawable activeScaleTypeDrawable;
        if (this.mDrawDebugOverlay) {
            if (getControllerOverlay() == null) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                ImageLoadingTimeControllerListener imageLoadingTimeControllerListener = new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable);
                this.mDebugOverlayImageOriginListener = new DebugOverlayImageOriginListener();
                addControllerListener(imageLoadingTimeControllerListener);
                setControllerOverlay(debugControllerOverlayDrawable);
            }
            if (this.mImageOriginListener == null) {
                addImageOriginListener(this.mDebugOverlayImageOriginListener);
            }
            if (getControllerOverlay() instanceof DebugControllerOverlayDrawable) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable2 = (DebugControllerOverlayDrawable) getControllerOverlay();
                debugControllerOverlayDrawable2.setControllerId(getId());
                DraweeHierarchy hierarchy = getHierarchy();
                ScalingUtils.ScaleType scaleType = null;
                if (hierarchy != null && (activeScaleTypeDrawable = ScalingUtils.getActiveScaleTypeDrawable(hierarchy.getTopLevelDrawable())) != null) {
                    scaleType = activeScaleTypeDrawable.getScaleType();
                }
                debugControllerOverlayDrawable2.setScaleType(scaleType);
                debugControllerOverlayDrawable2.setOrigin(this.mDebugOverlayImageOriginListener.getImageOrigin());
                if (closeableImage != null) {
                    debugControllerOverlayDrawable2.setDimensions(closeableImage.getWidth(), closeableImage.getHeight());
                    debugControllerOverlayDrawable2.setImageSize(closeableImage.getSizeInBytes());
                    try {
                        debugControllerOverlayDrawable2.setFileSize(closeableImage.getFileSize());
                        return;
                    } catch (Exception e) {
                        FLog.m438e(TAG, "updateDebugOverlay setFileSize failed, exception is: " + e);
                        return;
                    }
                }
                debugControllerOverlayDrawable2.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageInfo getImageInfo(CloseableReference<CloseableImage> closeableReference) {
        CalculateColorInfo calculateColorInfo;
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        if (FrescoCacheMonitorUtil.isEnableCalculateColor()) {
            CloseableImage closeableImage = closeableReference.get();
            if (closeableImage instanceof CloseableStaticBitmap) {
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap();
                ImageRequest imageRequest = getImageRequest();
                if (imageRequest != null && imageRequest.getCalculateColorConfig() != null) {
                    calculateColorInfo = ColorCalculator.getColorByAlgorithm(underlyingBitmap, imageRequest.getCalculateColorConfig().getCalculateHeight(), imageRequest.getCalculateColorConfig().getResizeBitmapTo(), imageRequest.getCalculateColorConfig().getPhotoBgColorStyle());
                    if (calculateColorInfo != null) {
                        closeableImage.setCalculateColorInfo(calculateColorInfo);
                    }
                    return closeableImage;
                }
            }
            calculateColorInfo = null;
            if (calculateColorInfo != null) {
            }
            return closeableImage;
        }
        return closeableReference.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public int getImageHash(@Nullable CloseableReference<CloseableImage> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.getValueHash();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void releaseImage(@Nullable CloseableReference<CloseableImage> closeableReference) {
        CloseableReference.closeSafely(closeableReference);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    protected void releaseDrawable(@Nullable Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).dropCaches();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    protected boolean isLastImageInEncodedCached() {
        if (this.mCacheKey != null && this.mEncodedMemoryCache != null && this.encodedCacheHashcode != 0) {
            CloseableReference<PooledByteBuffer> closeableReference = this.mEncodedMemoryCache.get(new SimpleCacheKey(this.mCacheKey.getUriString()));
            if (closeableReference == null) {
                this.encodedCacheHashcode = 0;
                return false;
            }
            int valueHash = closeableReference.getValueHash();
            CloseableReference.closeSafely(closeableReference);
            if (valueHash == this.encodedCacheHashcode) {
                return true;
            }
            this.encodedCacheHashcode = 0;
        }
        return false;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    protected void storeEncodedCacheHash() {
        MemoryCache<CacheKey, PooledByteBuffer> memoryCache;
        if (this.mCacheKey == null || (memoryCache = this.mEncodedMemoryCache) == null) {
            return;
        }
        CloseableReference<PooledByteBuffer> closeableReference = memoryCache.get(new SimpleCacheKey(this.mCacheKey.getUriString()));
        if (closeableReference != null) {
            this.encodedCacheHashcode = closeableReference.getValueHash();
            CloseableReference.closeSafely(closeableReference);
        } else {
            this.encodedCacheHashcode = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public CloseableReference<CloseableImage> getCachedImage() {
        CacheKey cacheKey;
        MemoryCache<CacheKey, CloseableImage> memoryCache;
        MemoryCache<CacheKey, CloseableImage> memoryCache2;
        MemoryCache<CacheKey, CloseableImage> memoryCache3;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#getCachedImage");
        }
        try {
            if (this.mMemoryCache != null && (cacheKey = this.mCacheKey) != null) {
                this.mCacheKey = BitmapMemoryCacheKey.getReuseOptCacheKey(cacheKey);
                CloseableReference<CloseableImage> closeableReference = (!ImagePipelineFactory.getInstance().isEnableBigImgCache() || (memoryCache3 = this.mBigImgMemoryCache) == null) ? null : memoryCache3.get(this.mCacheKey);
                if (closeableReference == null && ImagePipelineFactory.getInstance().isEnableSingleCache() && (memoryCache2 = this.mSingleMemoryCache) != null) {
                    closeableReference = memoryCache2.get(this.mCacheKey);
                }
                if (closeableReference == null) {
                    closeableReference = this.mMemoryCache.get(this.mCacheKey);
                }
                if (closeableReference == null && ImagePipelineFactory.getInstance().isSplitPrefetchCache() && (memoryCache = this.mPrefetchImgMemoryCache) != null) {
                    closeableReference = memoryCache.get(this.mCacheKey);
                }
                if (closeableReference != null && !closeableReference.get().getQualityInfo().isOfFullQuality()) {
                    closeableReference.close();
                    return null;
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return closeableReference;
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return null;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void onImageLoadedFromCacheImmediately(String str, CloseableReference<CloseableImage> closeableReference) {
        super.onImageLoadedFromCacheImmediately(str, (String) closeableReference);
        synchronized (this) {
            ImageOriginListener imageOriginListener = this.mImageOriginListener;
            if (imageOriginListener != null) {
                imageOriginListener.onImageLoaded(str, 5, true);
            }
            if (getImageRequest() != null) {
                RequestListener requestListenerForRequest = ImagePipelineFactory.getInstance().getImagePipeline().getRequestListenerForRequest(getImageRequest(), getRequestListener());
                requestListenerForRequest.onRequestStart(getImageRequest(), getCallerContext(), getId(), false);
                if (FrescoCacheMonitorUtil.isOptUltimateProducerReached()) {
                    requestListenerForRequest.onUltimateProducerReached(getId(), BitmapMemoryCacheGetProducer.PRODUCER_NAME, true);
                }
                requestListenerForRequest.onRequestSuccess(getImageRequest(), getId(), false);
            }
        }
    }

    protected Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
    }
}
