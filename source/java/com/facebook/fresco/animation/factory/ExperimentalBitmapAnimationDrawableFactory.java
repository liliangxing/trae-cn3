package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedHeifFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final HashMapMemoryCache<CacheKey, Bitmap> mAnimatedHeifBackingCache;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final Supplier<Integer> mCachingStrategySupplier;
    private final ExecutorService mExecutorServiceForFramePreparing;
    private final MonotonicClock mMonotonicClock;
    private final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, HashMapMemoryCache<CacheKey, Bitmap> hashMapMemoryCache, Supplier<Integer> supplier, Supplier<Integer> supplier2) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mExecutorServiceForFramePreparing = executorService;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = countingMemoryCache;
        this.mAnimatedHeifBackingCache = hashMapMemoryCache;
        this.mCachingStrategySupplier = supplier;
        this.mNumberOfFramesToPrepareSupplier = supplier2;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage closeableImage) {
        return closeableImage instanceof CloseableAnimatedImage;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public AnimatedDrawable2 createDrawable(CloseableImage closeableImage) {
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) closeableImage;
        AnimatedImageResult imageResult = closeableAnimatedImage.getImageResult();
        if (imageResult.getImage().getFrameCount() <= 0) {
            return null;
        }
        BitmapFrameCache createBitmapFrameCache = createBitmapFrameCache(imageResult);
        return new AnimatedDrawable2(createAnimationBackend(closeableAnimatedImage, createBitmapFrameCache), closeableAnimatedImage.getOptions().decodeContext, createBitmapFrameCache, imageResult.getImage().getDecodeStatus(), imageResult.getImage().getImageFormat());
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    @Nullable
    public Drawable createDrawable(CloseableImage closeableImage, Drawable drawable) {
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        BitmapFramePreparer bitmapFramePreparer;
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) closeableImage;
        AnimatedImageResult imageResult = closeableAnimatedImage.getImageResult();
        int decodeStatus = imageResult.getImage().getDecodeStatus();
        if (imageResult.getImage().getFrameCount() <= 0) {
            return drawable;
        }
        if ((drawable instanceof AnimatedDrawable2) && (decodeStatus == 2 || decodeStatus == 3)) {
            AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) drawable;
            BitmapFrameCache bitmapFrameCache = animatedDrawable2.getBitmapFrameCache();
            if (!shouldUpdateAnimatedImage(animatedDrawable2, imageResult.getImage())) {
                return animatedDrawable2;
            }
            AnimatedDrawableBackend createAnimatedDrawableBackend = createAnimatedDrawableBackend(imageResult);
            AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(bitmapFrameCache, createAnimatedDrawableBackend);
            int intValue = this.mNumberOfFramesToPrepareSupplier.get().intValue();
            if (intValue <= 0 || DefaultImageFormats.isHeifFormatAnimated(closeableImage.getImageFormat())) {
                fixedNumberBitmapFramePreparationStrategy = null;
                bitmapFramePreparer = null;
            } else {
                fixedNumberBitmapFramePreparationStrategy = new FixedNumberBitmapFramePreparationStrategy(intValue);
                bitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer, closeableAnimatedImage.getOptions().bitmapConfig);
            }
            BitmapAnimationBackend bitmapAnimationBackend = new BitmapAnimationBackend(this.mPlatformBitmapFactory, bitmapFrameCache, new AnimatedDrawableBackendAnimationInformation(createAnimatedDrawableBackend), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, bitmapFramePreparer);
            bitmapAnimationBackend.setBitmapConfig(closeableAnimatedImage.getOptions().bitmapConfig);
            bitmapAnimationBackend.setImageFormat(closeableAnimatedImage.getImageFormat());
            bitmapAnimationBackend.setAnimHeifIndividualCacheForCurrentRequestEnabled(closeableAnimatedImage.getOptions().animatedHeifIndividualCacheEnabled);
            animatedDrawable2.updateDrawable(AnimationBackendDelegateWithInactivityCheck.createForBackend(bitmapAnimationBackend, this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread), closeableAnimatedImage.getOptions().decodeContext, decodeStatus);
            return animatedDrawable2;
        }
        return createDrawable(closeableImage);
    }

    private boolean shouldUpdateAnimatedImage(AnimatedDrawable2 animatedDrawable2, AnimatedImage animatedImage) {
        AnimatedImageResult animatedImageResult;
        AnimatedImage image;
        AnimationBackend animationBackend = animatedDrawable2.getAnimationBackend();
        if (!(animationBackend instanceof AnimationBackendDelegate)) {
            return false;
        }
        AnimationBackend animationBackend2 = ((AnimationBackendDelegate) animationBackend).getAnimationBackend();
        return (!(animationBackend2 instanceof BitmapAnimationBackend) || (animatedImageResult = ((AnimatedDrawableBackendAnimationInformation) ((BitmapAnimationBackend) animationBackend2).getAnimationInformation()).getAnimatedDrawableBackend().getAnimatedImageResult()) == null || (image = animatedImageResult.getImage()) == null || animatedImage == null || animatedImage == image) ? false : true;
    }

    private AnimationBackend createAnimationBackend(CloseableAnimatedImage closeableAnimatedImage, BitmapFrameCache bitmapFrameCache) {
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        BitmapFramePreparer bitmapFramePreparer;
        AnimatedDrawableBackend createAnimatedDrawableBackend = createAnimatedDrawableBackend(closeableAnimatedImage.getImageResult());
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(bitmapFrameCache, createAnimatedDrawableBackend);
        int i = closeableAnimatedImage.getOptions().preDecodeFrameCount;
        if (i <= 0) {
            i = this.mNumberOfFramesToPrepareSupplier.get().intValue();
        }
        if (ImagePipelineFactory.getInstance().isShowHeifDebugLog()) {
            Log.d("heif_log", "createAnimationBackend: isHeifFormatAnimated = " + DefaultImageFormats.isHeifFormatAnimated(closeableAnimatedImage.getImageFormat()) + ", isAnimatedHeifIndividualCacheEnabled = " + ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled() + ", isAnimatedHeifIndividualCacheForImageRequestEnabled = " + ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled());
        }
        if (i <= 0 || !(!DefaultImageFormats.isHeifFormatAnimated(closeableAnimatedImage.getImageFormat()) || ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled() || ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled())) {
            fixedNumberBitmapFramePreparationStrategy = null;
            bitmapFramePreparer = null;
        } else {
            FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy2 = new FixedNumberBitmapFramePreparationStrategy(i);
            bitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer, closeableAnimatedImage.getOptions().bitmapConfig);
            fixedNumberBitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy2;
        }
        BitmapAnimationBackend bitmapAnimationBackend = new BitmapAnimationBackend(this.mPlatformBitmapFactory, bitmapFrameCache, new AnimatedDrawableBackendAnimationInformation(createAnimatedDrawableBackend), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, bitmapFramePreparer);
        bitmapAnimationBackend.setBitmapConfig(closeableAnimatedImage.getOptions().bitmapConfig);
        bitmapAnimationBackend.setImageFormat(closeableAnimatedImage.getImageFormat());
        bitmapAnimationBackend.setAnimHeifIndividualCacheForCurrentRequestEnabled(closeableAnimatedImage.getOptions().animatedHeifIndividualCacheEnabled);
        AnimatedImage image = closeableAnimatedImage.getImage();
        return AnimationBackendDelegateWithInactivityCheck.createForBackend(image != null ? image.getImageFormat() : null, bitmapAnimationBackend, this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread);
    }

    private BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer bitmapFrameRenderer, Bitmap.Config config) {
        return new DefaultBitmapFramePreparer(this.mPlatformBitmapFactory, bitmapFrameRenderer, config, this.mExecutorServiceForFramePreparing);
    }

    private AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult animatedImageResult) {
        AnimatedImage image = animatedImageResult.getImage();
        return this.mAnimatedDrawableBackendProvider.get(animatedImageResult, new Rect(0, 0, image.getWidth(), image.getHeight()));
    }

    private BitmapFrameCache createBitmapFrameCache(AnimatedImageResult animatedImageResult) {
        int intValue = this.mCachingStrategySupplier.get().intValue();
        if (intValue == 1) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), createAnimatedHeifFrameCache(animatedImageResult), true);
        }
        if (intValue == 2) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), createAnimatedHeifFrameCache(animatedImageResult), false);
        }
        if (intValue == 3) {
            return new KeepLastFrameCache();
        }
        return new NoOpCache();
    }

    private AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult animatedImageResult) {
        AnimatedFrameCache animatedFrameCache = new AnimatedFrameCache(new AnimationFrameCacheKey(TextUtils.isEmpty(animatedImageResult.getSourceUri()) ? animatedImageResult.hashCode() : animatedImageResult.getSourceUri().hashCode()), this.mBackingCache);
        int decodedFrameSize = animatedImageResult.getDecodedFrameSize();
        if (decodedFrameSize > 0) {
            for (int i = 0; i < decodedFrameSize; i++) {
                if (animatedImageResult.hasDecodedFrame(i)) {
                    cacheDecodedBitmap(animatedFrameCache, i, animatedImageResult.getDecodedFrame(i));
                }
            }
        }
        return animatedFrameCache;
    }

    private void cacheDecodedBitmap(AnimatedFrameCache animatedFrameCache, int i, CloseableReference<Bitmap> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = null;
        try {
            closeableReference2 = CloseableReference.m496of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
            animatedFrameCache.cache(i, closeableReference2);
        } finally {
            CloseableReference.closeSafely(closeableReference2);
        }
    }

    private AnimatedHeifFrameCache createAnimatedHeifFrameCache(AnimatedImageResult animatedImageResult) {
        return new AnimatedHeifFrameCache(new AnimationFrameCacheKey(TextUtils.isEmpty(animatedImageResult.getSourceUri()) ? animatedImageResult.hashCode() : animatedImageResult.getSourceUri().hashCode()), this.mAnimatedHeifBackingCache);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class AnimationFrameCacheKey implements CacheKey {
        private static final String URI_PREFIX = "anim://";
        private final String mAnimationUriString;

        public AnimationFrameCacheKey(int i) {
            this.mAnimationUriString = URI_PREFIX + i;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri uri) {
            return uri.toString().startsWith(this.mAnimationUriString);
        }

        @Override // com.facebook.cache.common.CacheKey
        public String getUriString() {
            return this.mAnimationUriString;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String toString() {
            return this.mAnimationUriString;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            String str = this.mAnimationUriString;
            String str2 = ((AnimationFrameCacheKey) obj).mAnimationUriString;
            return str != null ? str.equals(str2) : str2 == null;
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            String str = this.mAnimationUriString;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }
    }
}
