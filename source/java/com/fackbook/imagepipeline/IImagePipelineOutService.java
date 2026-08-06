package com.fackbook.imagepipeline;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.core.FileCacheFactory;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: IImagePipelineOutService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\n\u0010!\u001a\u0004\u0018\u00010\"H&J\n\u0010#\u001a\u0004\u0018\u00010$H&J\u000f\u0010%\u001a\u0004\u0018\u00010&H&¢\u0006\u0002\u0010'J\n\u0010(\u001a\u0004\u0018\u00010)H&J\n\u0010*\u001a\u0004\u0018\u00010+H&J\n\u0010,\u001a\u0004\u0018\u00010-H&J\n\u0010.\u001a\u0004\u0018\u00010/H&J\n\u00100\u001a\u0004\u0018\u000101H&J\n\u00102\u001a\u0004\u0018\u000103H&J\u000f\u00104\u001a\u0004\u0018\u00010&H&¢\u0006\u0002\u0010'J\u0010\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H&J\u000f\u00106\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u0010\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u000f\u00108\u001a\u0004\u0018\u00010&H&¢\u0006\u0002\u0010'J\n\u00109\u001a\u0004\u0018\u00010:H&J\u0012\u0010;\u001a\f\u0012\u0006\b\u0001\u0012\u00020=\u0018\u00010<H&J\n\u0010>\u001a\u0004\u0018\u00010?H&J\n\u0010@\u001a\u0004\u0018\u00010AH&J\u0010\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\n\u0010C\u001a\u0004\u0018\u00010DH&J\u0010\u0010E\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010FH&J\u000f\u0010H\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010I\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010J\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\n\u0010L\u001a\u0004\u0018\u00010\u0018H&J\u000f\u0010M\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010N\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010O\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006P"}, d2 = {"Lcom/fackbook/imagepipeline/IImagePipelineOutService;", "", "getAnimMemoryCacheParams", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "getAnimatedHeifIndividualCacheEnabled", "", "()Ljava/lang/Boolean;", "getAnimatedHeifIndividualCacheForImageRequestEnabled", "getBigImgBitmapMemoryCacheParamsSupplier", "getBigImgSizeLimit", "", "()Ljava/lang/Long;", "getBitmapConfig", "Landroid/graphics/Bitmap$Config;", "getCacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "getCacheTrimStrategy", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;", "getContext", "Landroid/content/Context;", "getCustomImageDiskCacheConfigMap", "Ljava/util/HashMap;", "", "Lcom/facebook/cache/disk/DiskCacheConfig;", "getDiskCacheConfig", "getDiskCacheEnabled", "getDownsampleEnabled", "getEnableBigImgCache", "getEnableNewLocalVideoThumbnailOpt", "getEnablePrefetchImgCache", "getEnableSingleMemCache", "getEncodedMemoryCacheParams", "getExecutorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "getFileCacheFactory", "Lcom/facebook/imagepipeline/core/FileCacheFactory;", "getHttpNetworkTimeout", "", "()Ljava/lang/Integer;", "getImageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "getImageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "getImageDecoderConfig", "Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "getImagePipelineExperiments", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "getImagePipelineFactory", "Lcom/facebook/imagepipeline/core/ImagePipelineFactory;", "getImageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "getImageTranscoderType", "getIsPrefetchEnabledSupplier", "getIsSplitMemCache", "getMemoryCacheParams", "getMemoryChunkType", "getMemoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "getNetworkFetcher", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "Lcom/facebook/imagepipeline/producers/FetchState;", "getPlatformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "getPoolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "getPrefetchImgBitmapMemoryCacheParamsSupplier", "getProgressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "getRequestListeners", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "getResizeAndRotateEnabledForNetwork", "getRetainPreviousImage", "getShowHeifDebugLog", "getSingleBitmapMemoryCacheParamsSupplier", "getSmallImageDiskCacheConfig", "getUseOptHeifBitmap", "getUseSingleImageRequest", "getWasImmediate", "imagepipeline_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IImagePipelineOutService {
    Supplier<MemoryCacheParams> getAnimMemoryCacheParams();

    Boolean getAnimatedHeifIndividualCacheEnabled();

    Boolean getAnimatedHeifIndividualCacheForImageRequestEnabled();

    Supplier<MemoryCacheParams> getBigImgBitmapMemoryCacheParamsSupplier();

    Long getBigImgSizeLimit();

    Bitmap.Config getBitmapConfig();

    CacheKeyFactory getCacheKeyFactory();

    CountingMemoryCache.CacheTrimStrategy getCacheTrimStrategy();

    Context getContext();

    HashMap<String, DiskCacheConfig> getCustomImageDiskCacheConfigMap();

    DiskCacheConfig getDiskCacheConfig();

    Boolean getDiskCacheEnabled();

    Boolean getDownsampleEnabled();

    Boolean getEnableBigImgCache();

    Boolean getEnableNewLocalVideoThumbnailOpt();

    Boolean getEnablePrefetchImgCache();

    Boolean getEnableSingleMemCache();

    Supplier<MemoryCacheParams> getEncodedMemoryCacheParams();

    ExecutorSupplier getExecutorSupplier();

    FileCacheFactory getFileCacheFactory();

    Integer getHttpNetworkTimeout();

    ImageCacheStatsTracker getImageCacheStatsTracker();

    ImageDecoder getImageDecoder();

    ImageDecoderConfig getImageDecoderConfig();

    ImagePipelineExperiments getImagePipelineExperiments();

    ImagePipelineFactory getImagePipelineFactory();

    ImageTranscoderFactory getImageTranscoderFactory();

    Integer getImageTranscoderType();

    Supplier<Boolean> getIsPrefetchEnabledSupplier();

    Boolean getIsSplitMemCache();

    Supplier<MemoryCacheParams> getMemoryCacheParams();

    Integer getMemoryChunkType();

    MemoryTrimmableRegistry getMemoryTrimmableRegistry();

    NetworkFetcher<? extends FetchState> getNetworkFetcher();

    PlatformBitmapFactory getPlatformBitmapFactory();

    PoolFactory getPoolFactory();

    Supplier<MemoryCacheParams> getPrefetchImgBitmapMemoryCacheParamsSupplier();

    ProgressiveJpegConfig getProgressiveJpegConfig();

    Set<RequestListener> getRequestListeners();

    Boolean getResizeAndRotateEnabledForNetwork();

    Boolean getRetainPreviousImage();

    Boolean getShowHeifDebugLog();

    Supplier<MemoryCacheParams> getSingleBitmapMemoryCacheParamsSupplier();

    DiskCacheConfig getSmallImageDiskCacheConfig();

    Boolean getUseOptHeifBitmap();

    Boolean getUseSingleImageRequest();

    Boolean getWasImmediate();
}
