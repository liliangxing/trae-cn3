package com.bytedance.lynx.service.image.utils;

import android.net.Uri;
import com.bytedance.lynx.service.image.decoder.GifDecoder;
import com.bytedance.lynx.service.image.decoder.MultiPostProcessor;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.image.model.ImageRequestInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageUtils {
    private static CacheKeyFactory sCacheKeyFactory;

    public static ResizeOptions getResizeOptions(int i, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0 || Math.abs(i - i3) > 1 || Math.abs(i2 - i4) > 1) {
            return new ResizeOptions(i, i2);
        }
        return new ResizeOptions(i3, i4);
    }

    public static ImageRequest getFrescoImageRequest(ImageRequestInfo imageRequestInfo) {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageRequestInfo.getUrl()));
        ImageDecodeOptionsBuilder imageDecodeOptionsBuilder = new ImageDecodeOptionsBuilder();
        imageDecodeOptionsBuilder.setPreDecodeFrameCount(0);
        if (imageRequestInfo.getConfig() != null) {
            imageDecodeOptionsBuilder.setBitmapConfig(imageRequestInfo.getConfig());
        }
        if (imageRequestInfo.isEnableGifLiteDecoder()) {
            imageDecodeOptionsBuilder.setCustomImageDecoder(new GifDecoder());
        }
        if (imageRequestInfo.getCustomParam() != null) {
            newBuilderWithSource.setCustomParam(imageRequestInfo.getCustomParam());
        }
        newBuilderWithSource.setAutoRotateEnabled(true).setProgressiveRenderingEnabled(false);
        if (!imageRequestInfo.isEnableResourceHint()) {
            ResizeOptions resizeOptions = imageRequestInfo.isEnableDownSampling() ? new ResizeOptions(imageRequestInfo.getResizeWidth(), imageRequestInfo.getResizeHeight()) : null;
            if (resizeOptions != null) {
                newBuilderWithSource.setResizeOptions(resizeOptions);
            }
        }
        if (imageRequestInfo.getDiskCacheChoice() != null && 1 == imageRequestInfo.getDiskCacheChoice().intValue()) {
            newBuilderWithSource.setCacheChoice(ImageRequest.CacheChoice.SMALL);
        }
        if (imageRequestInfo.isEnableAsyncRequest()) {
            newBuilderWithSource.setRequestPriority(Priority.HIGH);
        }
        if (imageRequestInfo.getProcessors() != null && !imageRequestInfo.getProcessors().isEmpty()) {
            newBuilderWithSource.setPostprocessor(new MultiPostProcessor(imageRequestInfo.getProcessors(), imageRequestInfo.getConfig()));
        }
        return newBuilderWithSource.build();
    }

    public static CloseableReference<CloseableImage> getCachedImage(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKey cacheKey) {
        if (memoryCache == null || cacheKey == null) {
            return null;
        }
        return memoryCache.get(cacheKey);
    }

    public static CacheKey getCacheKey(ImageRequest imageRequest, Object obj) {
        if (sCacheKeyFactory == null) {
            sCacheKeyFactory = Fresco.getImagePipeline().getCacheKeyFactory();
        }
        if (sCacheKeyFactory == null || imageRequest == null) {
            return null;
        }
        if (imageRequest.getPostprocessor() != null) {
            return sCacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, obj);
        }
        return sCacheKeyFactory.getBitmapCacheKey(imageRequest, obj);
    }
}
