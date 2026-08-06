package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimatedFactoryV2Impl implements AnimatedFactory {
    private static final int NUMBER_OF_FRAMES_TO_PREPARE = 3;
    private static int sAnimationCachingStrategy = 1;

    @Nullable
    private AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;

    @Nullable
    private DrawableFactory mAnimatedDrawableFactory;

    @Nullable
    private AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final HashMapMemoryCache<CacheKey, Bitmap> mAnimatedHeifBackingCache;

    @Nullable
    private AnimatedImageFactory mAnimatedImageFactory;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final ExecutorSupplier mExecutorSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, HashMapMemoryCache<CacheKey, Bitmap> hashMapMemoryCache) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mExecutorSupplier = executorSupplier;
        this.mBackingCache = countingMemoryCache;
        this.mAnimatedHeifBackingCache = hashMapMemoryCache;
    }

    @Nullable
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.mPlatformBitmapFactory;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    @Nullable
    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        if (this.mAnimatedDrawableFactory == null) {
            this.mAnimatedDrawableFactory = createDrawableFactory();
        }
        return this.mAnimatedDrawableFactory;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public ImageDecoder getGifDecoder(final Bitmap.Config config) {
        return new ImageDecoder() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeGif(encodedImage, imageDecodeOptions, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public ImageDecoder getWebPDecoder(final Bitmap.Config config) {
        return new ImageDecoder() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeWebP(encodedImage, imageDecodeOptions, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    @Nullable
    public ImageDecoder getHeifDecoder(final Bitmap.Config config) {
        return new ImageDecoder() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeHeif(encodedImage, imageDecodeOptions, config);
            }
        };
    }

    private ExperimentalBitmapAnimationDrawableFactory createDrawableFactory() {
        Supplier<Integer> supplier = new Supplier<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public Integer get() {
                return Integer.valueOf(AnimatedFactoryV2Impl.sAnimationCachingStrategy);
            }
        };
        return new ExperimentalBitmapAnimationDrawableFactory(getAnimatedDrawableBackendProvider(), UiThreadImmediateExecutorService.getInstance(), new DefaultSerialExecutorService(this.mExecutorSupplier.forDecode()), RealtimeSinceBootClock.get(), this.mPlatformBitmapFactory, this.mBackingCache, this.mAnimatedHeifBackingCache, supplier, new Supplier<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatedDrawableUtil getAnimatedDrawableUtil() {
        if (this.mAnimatedDrawableUtil == null) {
            this.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
        }
        return this.mAnimatedDrawableUtil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatedImageFactory getAnimatedImageFactory() {
        if (this.mAnimatedImageFactory == null) {
            this.mAnimatedImageFactory = buildAnimatedImageFactory();
        }
        return this.mAnimatedImageFactory;
    }

    private AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
        if (this.mAnimatedDrawableBackendProvider == null) {
            this.mAnimatedDrawableBackendProvider = new AnimatedDrawableBackendProvider() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
                @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
                public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                    return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect);
                }
            };
        }
        return this.mAnimatedDrawableBackendProvider;
    }

    public static void setAnimationCachingStrategy(int i) {
        sAnimationCachingStrategy = i;
    }

    private AnimatedImageFactory buildAnimatedImageFactory() {
        return new AnimatedImageFactoryImpl(new AnimatedDrawableBackendProvider() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.7
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
            public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect);
            }
        }, this.mPlatformBitmapFactory);
    }
}
