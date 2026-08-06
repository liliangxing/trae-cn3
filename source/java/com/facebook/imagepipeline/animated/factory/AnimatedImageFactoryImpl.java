package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.base.BaseAnimatedImage;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCacheUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimatedImageFactoryImpl implements AnimatedImageFactory {
    private static final String TAG = "AnimatedImageFactoryImp";
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final PlatformBitmapFactory mBitmapFactory;
    static AnimatedImageDecoder sGifAnimatedImageDecoder = loadIfPresent("com.facebook.animated.gif.GifImage");
    static AnimatedImageDecoder sWebpAnimatedImageDecoder = loadIfPresent("com.facebook.animated.webp.WebPImage");
    static AnimatedImageDecoder sHeifAnimatedImageDecoder = loadIfPresent("com.bytedance.fresco.animatedheif.HeifImage");

    private static AnimatedImageDecoder loadIfPresent(String str) {
        try {
            return (AnimatedImageDecoder) Class.forName(str).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mBitmapFactory = platformBitmapFactory;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage decode;
        if (sGifAnimatedImageDecoder == null) {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Preconditions.checkNotNull(byteBufferRef);
        try {
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer.getByteBuffer() != null) {
                decode = sGifAnimatedImageDecoder.decode(pooledByteBuffer.getByteBuffer());
            } else {
                decode = sGifAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size());
            }
            return getCloseableImage(imageDecodeOptions, decode, config, encodedImage.getImageFormat());
        } finally {
            CloseableReference.closeSafely(byteBufferRef);
        }
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage decode;
        if (sWebpAnimatedImageDecoder == null) {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Preconditions.checkNotNull(byteBufferRef);
        try {
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer.getByteBuffer() != null) {
                decode = sWebpAnimatedImageDecoder.decode(pooledByteBuffer.getByteBuffer());
            } else {
                decode = sWebpAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size());
            }
            if (decode instanceof BaseAnimatedImage) {
                ((BaseAnimatedImage) decode).setDecodeStatus(encodedImage.getDecodeStatus());
            }
            return getCloseableImage(imageDecodeOptions, decode, config, encodedImage.getImageFormat());
        } finally {
            CloseableReference.closeSafely(byteBufferRef);
        }
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeHeif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage decode;
        if (sHeifAnimatedImageDecoder == null) {
            throw new UnsupportedOperationException("To encode animated heif please add the dependency to the animated-heif module");
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Preconditions.checkNotNull(byteBufferRef);
        try {
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer.getByteBuffer() != null) {
                decode = sHeifAnimatedImageDecoder.decode(pooledByteBuffer.getByteBuffer());
            } else {
                decode = sHeifAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size());
            }
            if (decode instanceof BaseAnimatedImage) {
                ((BaseAnimatedImage) decode).setDecodeStatus(encodedImage.getDecodeStatus());
            }
            return getCloseableImage(imageDecodeOptions, decode, config, encodedImage.getImageFormat());
        } finally {
            CloseableReference.closeSafely(byteBufferRef);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder] */
    private CloseableImage getCloseableImage(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Bitmap.Config config, ImageFormat imageFormat) {
        ?? r1;
        List<CloseableReference<Bitmap>> list;
        CloseableReference<Bitmap> closeableReference = null;
        try {
            int frameCount = imageDecodeOptions.useLastFrameForPreview ? animatedImage.getFrameCount() - 1 : 0;
            int width = animatedImage.getWidth() * animatedImage.getHeight() * 4;
            int frameCount2 = animatedImage.getFrameCount() * width;
            if (!imageDecodeOptions.forceStaticImage && (!BitmapCacheUtil.isOptAnim() || (frameCount2 <= BitmapCacheUtil.getOptAnimTotalLimit() && width <= BitmapCacheUtil.getOptAnimSingleLimit()))) {
                r1 = DefaultImageFormats.isHeifFormatAnimated(imageFormat);
                try {
                    if (r1 == 0) {
                        if (imageDecodeOptions.decodeAllFrames) {
                            List<CloseableReference<Bitmap>> decodeAllFrames = decodeAllFrames(animatedImage, imageDecodeOptions.bitmapConfig);
                            int size = decodeAllFrames.size();
                            list = decodeAllFrames;
                            if (size > frameCount) {
                                closeableReference = CloseableReference.cloneOrNull(decodeAllFrames.get(frameCount));
                                list = decodeAllFrames;
                            }
                        } else if (imageDecodeOptions.preDecodeFrameCount > 0) {
                            List<CloseableReference<Bitmap>> decodeFrames = decodeFrames(animatedImage, imageDecodeOptions.bitmapConfig, imageDecodeOptions.preDecodeFrameCount);
                            int size2 = decodeFrames.size();
                            list = decodeFrames;
                            if (size2 > frameCount) {
                                closeableReference = CloseableReference.cloneOrNull(decodeFrames.get(frameCount));
                                list = decodeFrames;
                            }
                        } else {
                            list = null;
                        }
                        r1 = list;
                        r1 = list;
                        if (imageDecodeOptions.decodePreviewFrame && closeableReference == null) {
                            closeableReference = createPreviewBitmap(animatedImage, imageDecodeOptions.bitmapConfig, frameCount);
                            r1 = list;
                        }
                    } else {
                        r1 = 0;
                    }
                    CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(animatedImage).setPreviewBitmap(closeableReference).setFrameForPreview(frameCount).setDecodedFrames(r1).setAnimHeifIndividualCacheForCurrentRequestEnabled(imageDecodeOptions.animatedHeifIndividualCacheEnabled).build(), imageDecodeOptions, imageFormat);
                    CloseableReference.closeSafely(closeableReference);
                    CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) r1);
                    return closeableAnimatedImage;
                } catch (Throwable th) {
                    th = th;
                    CloseableReference.closeSafely(closeableReference);
                    CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) r1);
                    throw th;
                }
            }
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(createPreviewBitmap(animatedImage, imageDecodeOptions.bitmapConfig, frameCount), ImmutableQualityInfo.FULL_QUALITY, 0);
            CloseableReference.closeSafely((CloseableReference<?>) null);
            CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) null);
            return closeableStaticBitmap;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
        }
    }

    private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage animatedImage, Bitmap.Config config, int i) {
        CloseableReference<Bitmap> createBitmap = createBitmap(animatedImage.getWidth(), animatedImage.getHeight(), config);
        new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null), new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int i2, ImageFormat imageFormat, boolean z) {
                return null;
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i2, Bitmap bitmap) {
            }
        }).renderFrame(i, createBitmap.get());
        return createBitmap;
    }

    private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage animatedImage, Bitmap.Config config) {
        AnimatedDrawableBackend animatedDrawableBackend = this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null);
        final ArrayList arrayList = new ArrayList(animatedDrawableBackend.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.2
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int i, ImageFormat imageFormat, boolean z) {
                return CloseableReference.cloneOrNull((CloseableReference) arrayList.get(i));
            }
        });
        for (int i = 0; i < animatedDrawableBackend.getFrameCount(); i++) {
            CloseableReference<Bitmap> createBitmap = createBitmap(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), config);
            animatedImageCompositor.renderFrame(i, createBitmap.get());
            arrayList.add(createBitmap);
        }
        return arrayList;
    }

    private List<CloseableReference<Bitmap>> decodeFrames(AnimatedImage animatedImage, Bitmap.Config config, int i) {
        AnimatedDrawableBackend animatedDrawableBackend = this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null);
        int frameCount = animatedDrawableBackend.getFrameCount();
        if (i > frameCount) {
            i = frameCount;
        }
        if (animatedDrawableBackend instanceof AnimatedDrawableBackendImpl) {
            ((AnimatedDrawableBackendImpl) animatedDrawableBackend).setDecodeType(1);
        }
        final ArrayList arrayList = new ArrayList(i);
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.3
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i2, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int i2, ImageFormat imageFormat, boolean z) {
                return CloseableReference.cloneOrNull((CloseableReference) arrayList.get(i2));
            }
        });
        for (int i2 = 0; i2 < i; i2++) {
            CloseableReference<Bitmap> createBitmap = createBitmap(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), config);
            try {
                animatedImageCompositor.renderFrame(i2, createBitmap.get());
                arrayList.add(createBitmap);
            } catch (IllegalStateException e) {
                FLog.m485w(TAG, e, "preview decode failed", new Object[0]);
            }
        }
        return arrayList;
    }

    private CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config) {
        CloseableReference<Bitmap> createBitmapInternal = this.mBitmapFactory.createBitmapInternal(i, i2, config);
        createBitmapInternal.get().eraseColor(0);
        createBitmapInternal.get().setHasAlpha(true);
        return createBitmapInternal;
    }
}
