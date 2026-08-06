package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.image.CloseableImage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimatedFactoryProvider {
    private static AnimatedTempBitmapFactory sAnimatedTempBitmapFactory;
    private static AnimatedFactory sImpl;
    private static boolean sImplLoaded;
    private static int sPreDecodeCount;

    public static AnimatedFactory getImpl() {
        if (sImplLoaded) {
            return sImpl;
        }
        return null;
    }

    public static AnimatedFactory getAnimatedFactory(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, HashMapMemoryCache<CacheKey, Bitmap> hashMapMemoryCache) {
        if (!sImplLoaded) {
            try {
                sImpl = (AnimatedFactory) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, HashMapMemoryCache.class).newInstance(platformBitmapFactory, executorSupplier, countingMemoryCache, hashMapMemoryCache);
            } catch (Throwable unused) {
            }
            if (sImpl != null) {
                sImplLoaded = true;
            }
        }
        return sImpl;
    }

    public static void setAnimatedTempBitmapFactory(AnimatedTempBitmapFactory animatedTempBitmapFactory) {
        sAnimatedTempBitmapFactory = animatedTempBitmapFactory;
    }

    public static AnimatedTempBitmapFactory getAnimatedTempBitmapFactory() {
        return sAnimatedTempBitmapFactory;
    }

    public static void setDefaultPreDecodeCount(int i) {
        sPreDecodeCount = i;
    }

    public static int getDefaultPreDecodeCount() {
        return sPreDecodeCount;
    }
}
