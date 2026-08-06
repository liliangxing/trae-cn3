package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.fresco.cloudcontrol.ImageFormatUtils;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.datasource.FrescoOptUtil;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImagePipelineConfig {
    public static final long DEFAULT_BIG_IMG_SIZE_LIMIT = 2097152;
    private ImagePipelineConfigLazySet mImagePipelineConfigLazySet;
    private static DefaultImageRequestConfig sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    private static boolean mWasImmediate = true;
    public static boolean useSingleImageRequest = false;
    private static ImagePipelineConfig mImagePipelineConfig = null;

    public static ImagePipelineConfig getInstance() {
        if (mImagePipelineConfig == null) {
            mImagePipelineConfig = new ImagePipelineConfig();
        }
        return mImagePipelineConfig;
    }

    public void preloadConfig() {
        this.mImagePipelineConfigLazySet.getMImagePipelineExperiments();
        this.mImagePipelineConfigLazySet.getMBitmapConfig();
        this.mImagePipelineConfigLazySet.getMImageDecoderConfig();
        this.mImagePipelineConfigLazySet.getMPoolFactory();
        this.mImagePipelineConfigLazySet.getMImageDecoderConfig();
        this.mImagePipelineConfigLazySet.getMBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMAnimBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMBitmapMemoryCacheTrimStrategy();
        this.mImagePipelineConfigLazySet.getMCacheKeyFactory();
        this.mImagePipelineConfigLazySet.getMContext();
        this.mImagePipelineConfigLazySet.getMIsSplitMemCache();
        this.mImagePipelineConfigLazySet.getMEnableSingleMemCache();
        this.mImagePipelineConfigLazySet.getMSingleBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheEnabled();
        this.mImagePipelineConfigLazySet.getMShowHeifDebugLog();
        this.mImagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheForImageRequestEnabled();
        this.mImagePipelineConfigLazySet.getMDiskCacheEnabled();
        this.mImagePipelineConfigLazySet.getMDownsampleEnabled();
        this.mImagePipelineConfigLazySet.getMEncodedMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMExecutorSupplier();
        this.mImagePipelineConfigLazySet.getMFileCacheFactory();
        this.mImagePipelineConfigLazySet.getMHttpNetworkTimeout();
        this.mImagePipelineConfigLazySet.getMImageCacheStatsTracker();
        this.mImagePipelineConfigLazySet.getMImageTranscoderFactory();
        this.mImagePipelineConfigLazySet.getMIsPrefetchEnabledSupplier();
        this.mImagePipelineConfigLazySet.getMMainDiskCacheConfig();
        this.mImagePipelineConfigLazySet.getMMemoryChunkType();
        this.mImagePipelineConfigLazySet.getMMemoryTrimmableRegistry();
        this.mImagePipelineConfigLazySet.getMImageDecoder();
        this.mImagePipelineConfigLazySet.getMPlatformBitmapFactory();
        this.mImagePipelineConfigLazySet.getMProgressiveJpegConfig();
        this.mImagePipelineConfigLazySet.getMRequestListeners();
        this.mImagePipelineConfigLazySet.getMResizeAndRotateEnabledForNetwork();
        this.mImagePipelineConfigLazySet.getMSmallImageDiskCacheConfig();
        this.mImagePipelineConfigLazySet.getMCustomImageDiskCacheConfigMap();
        this.mImagePipelineConfigLazySet.getMWasImmediate();
        this.mImagePipelineConfigLazySet.getMEnableBigImgCache();
        this.mImagePipelineConfigLazySet.getMBigImgBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMBigImgSizeLimit();
        this.mImagePipelineConfigLazySet.getMEnablePrefetchImgCache();
        this.mImagePipelineConfigLazySet.getMPrefetchImgBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getUseSingleImageRequest();
        this.mImagePipelineConfigLazySet.getMEnableNewLocalVideoThumbnailOpt();
        this.mImagePipelineConfigLazySet.getMRetainPreviousImage();
        this.mImagePipelineConfigLazySet.getMUseOptHeifBitmap();
    }

    private ImagePipelineConfig() {
        WebpBitmapFactory loadWebpBitmapFactoryIfExists;
        ImagePipelineConfigLazySet imagePipelineConfigLazySet = new ImagePipelineConfigLazySet();
        this.mImagePipelineConfigLazySet = imagePipelineConfigLazySet;
        WebpBitmapFactory webpBitmapFactory = imagePipelineConfigLazySet.getMImagePipelineExperiments() != null ? this.mImagePipelineConfigLazySet.getMImagePipelineExperiments().getWebpBitmapFactory() : null;
        if (webpBitmapFactory != null) {
            setWebpBitmapFactory(webpBitmapFactory, this.mImagePipelineConfigLazySet.getMImagePipelineExperiments(), new HoneycombBitmapCreator(getPoolFactory()));
        } else {
            if (this.mImagePipelineConfigLazySet.getMImagePipelineExperiments() == null || !this.mImagePipelineConfigLazySet.getMImagePipelineExperiments().isWebpSupportEnabled() || !WebpSupportStatus.sIsWebpSupportRequired || (loadWebpBitmapFactoryIfExists = WebpSupportStatus.loadWebpBitmapFactoryIfExists()) == null) {
                return;
            }
            setWebpBitmapFactory(loadWebpBitmapFactoryIfExists, this.mImagePipelineConfigLazySet.getMImagePipelineExperiments(), new HoneycombBitmapCreator(getPoolFactory()));
        }
    }

    private ImagePipelineConfig(Builder builder) {
        CacheKeyFactory cacheKeyFactory;
        ImageCacheStatsTracker imageCacheStatsTracker;
        MemoryTrimmableRegistry memoryTrimmableRegistry;
        NetworkFetcher<? extends FetchState> networkFetcher;
        PoolFactory poolFactory;
        DiskCacheConfig diskCacheConfig;
        HashMap<String, DiskCacheConfig> hashMap;
        WebpBitmapFactory loadWebpBitmapFactoryIfExists;
        this.mImagePipelineConfigLazySet = new ImagePipelineConfigLazySet();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        this.mImagePipelineConfigLazySet.setMImagePipelineExperiments(builder.mExperimentsBuilder.build());
        this.mImagePipelineConfigLazySet.setMBitmapMemoryCacheParamsSupplier(builder.mBitmapMemoryCacheParamsSupplier == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity")) : builder.mBitmapMemoryCacheParamsSupplier);
        this.mImagePipelineConfigLazySet.setMSingleBitmapMemoryCacheParamsSupplier(builder.mSingleBitmapMemoryCacheParamsSupplier == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity")) : builder.mSingleBitmapMemoryCacheParamsSupplier);
        this.mImagePipelineConfigLazySet.setMBigImgBitmapMemoryCacheParamsSupplier(builder.mBigImgBitmapMemoryCacheParamsSupplier == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity")) : builder.mBigImgBitmapMemoryCacheParamsSupplier);
        this.mImagePipelineConfigLazySet.setMPrefetchImgBitmapMemoryCacheParamsSupplier(builder.mPrefetchImgBitmapMemoryCacheParamsSupplier == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity")) : builder.mPrefetchImgBitmapMemoryCacheParamsSupplier);
        this.mImagePipelineConfigLazySet.setMAnimBitmapMemoryCacheParamsSupplier(builder.mAnimBitmapMemoryCacheParamsSupplier == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity")) : builder.mAnimBitmapMemoryCacheParamsSupplier);
        this.mImagePipelineConfigLazySet.setMBitmapMemoryCacheTrimStrategy(builder.mBitmapMemoryCacheTrimStrategy == null ? new BitmapMemoryCacheTrimStrategy() : builder.mBitmapMemoryCacheTrimStrategy);
        FrescoCacheMonitorUtil.setSplitMemCache(builder.isSplitMemCache());
        FrescoCacheMonitorUtil.setEnableSingleCache(builder.isEnableSingleMemCache());
        FrescoCacheMonitorUtil.setEnableBigImgCache(builder.isEnableBigImgCache());
        FrescoCacheMonitorUtil.setBigImgSizeLimit(builder.getBigImgSizeLimit());
        FrescoCacheMonitorUtil.setRetainPreviousImage(builder.isRetainPreviousImage());
        FrescoCacheMonitorUtil.setEnableSavePreSrPostBitmap(builder.isSavePrePostBitmap());
        FrescoCacheMonitorUtil.setEnableSaveAfterSrPostBitmap(builder.isSaveAfterPostBitmap());
        FrescoCacheMonitorUtil.setNewLocalVideoThumbnailOptEnabled(builder.isNewLocalVideoThumbnailOptEnabled());
        FrescoCacheMonitorUtil.setWaitParseParamFromUrl(builder.getWaitParseParamFromUrl());
        FrescoCacheMonitorUtil.setUseOptHeifBitmap(builder.isUseOptHeifBitmap());
        FrescoCacheMonitorUtil.setUseNewOptHeifBitmap(builder.isUseNewOptHeifBitmap());
        FrescoCacheMonitorUtil.setVvicUseWpp(builder.isVvicUseWpp());
        FrescoCacheMonitorUtil.setVvicDecodeThreads(builder.getVvicDecodeThreads());
        FrescoCacheMonitorUtil.setHeicUseWpp(builder.isHeicUseWpp());
        FrescoCacheMonitorUtil.setHeicDecodeThreads(builder.getHeicDecodeThreads());
        FrescoCacheMonitorUtil.setHeifUseWpp(builder.isHeifUseWpp());
        FrescoCacheMonitorUtil.setHeifDecodeThreads(builder.getHeifDecodeThreads());
        FrescoCacheMonitorUtil.setOptMultiOriginListener(builder.isOptMultiOriginListener());
        FrescoCacheMonitorUtil.setSRAutoScaleLowerFirst(builder.isSRAutoScaleLowerFirst());
        FrescoCacheMonitorUtil.setSplitPrefetchCache(builder.isSplitPrefetchCache());
        FrescoCacheMonitorUtil.setOptPrefetchCacheKey(builder.isOptPrefetchCacheKey());
        FrescoCacheMonitorUtil.setEnableAddLogUriInfo(builder.isOptAddLogUriInfo());
        this.mImagePipelineConfigLazySet.setMBitmapConfig(builder.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : builder.mBitmapConfig);
        ImagePipelineConfigLazySet imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet;
        if (builder.mCacheKeyFactory == null) {
            cacheKeyFactory = DefaultCacheKeyFactory.getInstance();
        } else {
            cacheKeyFactory = builder.mCacheKeyFactory;
        }
        imagePipelineConfigLazySet.setMCacheKeyFactory(cacheKeyFactory);
        this.mImagePipelineConfigLazySet.setMContext((Context) Preconditions.checkNotNull(builder.mContext));
        this.mImagePipelineConfigLazySet.setMFileCacheFactory(builder.mFileCacheFactory == null ? new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory()) : builder.mFileCacheFactory);
        this.mImagePipelineConfigLazySet.setMDownsampleEnabled(Boolean.valueOf(builder.mDownsampleEnabled));
        this.mImagePipelineConfigLazySet.setMEncodedMemoryCacheParamsSupplier(builder.mEncodedMemoryCacheParamsSupplier == null ? new DefaultEncodedMemoryCacheParamsSupplier() : builder.mEncodedMemoryCacheParamsSupplier);
        ImagePipelineConfigLazySet imagePipelineConfigLazySet2 = this.mImagePipelineConfigLazySet;
        if (builder.mImageCacheStatsTracker == null) {
            imageCacheStatsTracker = NoOpImageCacheStatsTracker.getInstance();
        } else {
            imageCacheStatsTracker = builder.mImageCacheStatsTracker;
        }
        imagePipelineConfigLazySet2.setMImageCacheStatsTracker(imageCacheStatsTracker);
        this.mImagePipelineConfigLazySet.setMImageDecoder(builder.mImageDecoder);
        this.mImagePipelineConfigLazySet.setMImageTranscoderFactory(getImageTranscoderFactory(builder));
        this.mImagePipelineConfigLazySet.setMImageTranscoderType(builder.mImageTranscoderType);
        this.mImagePipelineConfigLazySet.setMIsPrefetchEnabledSupplier(builder.mIsPrefetchEnabledSupplier == null ? new Supplier<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfig.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public Boolean get() {
                return true;
            }
        } : builder.mIsPrefetchEnabledSupplier);
        this.mImagePipelineConfigLazySet.setMMainDiskCacheConfig(builder.mMainDiskCacheConfig == null ? getDefaultMainDiskCacheConfig(builder.mContext) : builder.mMainDiskCacheConfig);
        ImagePipelineConfigLazySet imagePipelineConfigLazySet3 = this.mImagePipelineConfigLazySet;
        if (builder.mMemoryTrimmableRegistry == null) {
            memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        } else {
            memoryTrimmableRegistry = builder.mMemoryTrimmableRegistry;
        }
        imagePipelineConfigLazySet3.setMMemoryTrimmableRegistry(memoryTrimmableRegistry);
        ImagePipelineConfigLazySet imagePipelineConfigLazySet4 = this.mImagePipelineConfigLazySet;
        imagePipelineConfigLazySet4.setMMemoryChunkType(Integer.valueOf(getMemoryChunkType(builder, imagePipelineConfigLazySet4.getMImagePipelineExperiments())));
        this.mImagePipelineConfigLazySet.setMHttpNetworkTimeout(Integer.valueOf(builder.mHttpConnectionTimeout < 0 ? HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT : builder.mHttpConnectionTimeout));
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
        }
        ImagePipelineConfigLazySet imagePipelineConfigLazySet5 = this.mImagePipelineConfigLazySet;
        if (builder.mNetworkFetcher == null) {
            networkFetcher = new HttpUrlConnectionNetworkFetcher(this.mImagePipelineConfigLazySet.getMHttpNetworkTimeout().intValue());
        } else {
            networkFetcher = builder.mNetworkFetcher;
        }
        imagePipelineConfigLazySet5.setMNetworkFetcher(networkFetcher);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        this.mImagePipelineConfigLazySet.setMPlatformBitmapFactory(builder.mPlatformBitmapFactory);
        ImagePipelineConfigLazySet imagePipelineConfigLazySet6 = this.mImagePipelineConfigLazySet;
        if (builder.mPoolFactory == null) {
            poolFactory = new PoolFactory(PoolConfig.newBuilder().build());
        } else {
            poolFactory = builder.mPoolFactory;
        }
        imagePipelineConfigLazySet6.setMPoolFactory(poolFactory);
        this.mImagePipelineConfigLazySet.setMProgressiveJpegConfig(builder.mProgressiveJpegConfig == null ? new SimpleProgressiveJpegConfig() : builder.mProgressiveJpegConfig);
        this.mImagePipelineConfigLazySet.setMRequestListeners(builder.mRequestListeners == null ? new HashSet<>() : builder.mRequestListeners);
        this.mImagePipelineConfigLazySet.setMResizeAndRotateEnabledForNetwork(Boolean.valueOf(builder.mResizeAndRotateEnabledForNetwork));
        ImagePipelineConfigLazySet imagePipelineConfigLazySet7 = this.mImagePipelineConfigLazySet;
        if (builder.mSmallImageDiskCacheConfig == null) {
            diskCacheConfig = this.mImagePipelineConfigLazySet.getMMainDiskCacheConfig();
        } else {
            diskCacheConfig = builder.mSmallImageDiskCacheConfig;
        }
        imagePipelineConfigLazySet7.setMSmallImageDiskCacheConfig(diskCacheConfig);
        ImagePipelineConfigLazySet imagePipelineConfigLazySet8 = this.mImagePipelineConfigLazySet;
        if (builder.mCustomImageDiskCacheConfigMap == null) {
            hashMap = getDefaultCustomDiskCacheConfigMap();
        } else {
            hashMap = builder.mCustomImageDiskCacheConfigMap;
        }
        imagePipelineConfigLazySet8.setMCustomImageDiskCacheConfigMap(hashMap);
        this.mImagePipelineConfigLazySet.setMImageDecoderConfig(builder.mImageDecoderConfig);
        this.mImagePipelineConfigLazySet.setMExecutorSupplier(builder.mExecutorSupplier == null ? new DefaultExecutorSupplier(this.mImagePipelineConfigLazySet.getMPoolFactory().getFlexByteArrayPoolMaxNumThreads()) : builder.mExecutorSupplier);
        this.mImagePipelineConfigLazySet.setMAnimatedHeifIndividualCacheEnabled(Boolean.valueOf(builder.mAnimatedHeifIndividualCacheEnabled));
        this.mImagePipelineConfigLazySet.setMShowHeifDebugLog(Boolean.valueOf(builder.isShowHeifDebugLog()));
        this.mImagePipelineConfigLazySet.setMAnimatedHeifIndividualCacheForImageRequestEnabled(Boolean.valueOf(builder.mAnimatedHeifIndividualCacheForImageRequestEnabled));
        this.mImagePipelineConfigLazySet.setMDiskCacheEnabled(Boolean.valueOf(builder.mDiskCacheEnabled));
        mWasImmediate = builder.mWasImmediate;
        WebpBitmapFactory webpBitmapFactory = this.mImagePipelineConfigLazySet.getMImagePipelineExperiments().getWebpBitmapFactory();
        if (webpBitmapFactory != null) {
            setWebpBitmapFactory(webpBitmapFactory, this.mImagePipelineConfigLazySet.getMImagePipelineExperiments(), new HoneycombBitmapCreator(getPoolFactory()));
        } else if (this.mImagePipelineConfigLazySet.getMImagePipelineExperiments().isWebpSupportEnabled() && WebpSupportStatus.sIsWebpSupportRequired && (loadWebpBitmapFactoryIfExists = WebpSupportStatus.loadWebpBitmapFactoryIfExists()) != null) {
            setWebpBitmapFactory(loadWebpBitmapFactoryIfExists, this.mImagePipelineConfigLazySet.getMImagePipelineExperiments(), new HoneycombBitmapCreator(getPoolFactory()));
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public static boolean isWasImmediate() {
        return mWasImmediate;
    }

    private static void setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory, ImagePipelineExperiments imagePipelineExperiments, BitmapCreator bitmapCreator) {
        WebpSupportStatus.sWebpBitmapFactory = webpBitmapFactory;
        WebpBitmapFactory.WebpErrorLogger webpErrorLogger = imagePipelineExperiments.getWebpErrorLogger();
        if (webpErrorLogger != null) {
            webpBitmapFactory.setWebpErrorLogger(webpErrorLogger);
        }
        if (bitmapCreator != null) {
            webpBitmapFactory.setBitmapCreator(bitmapCreator);
        }
    }

    private static DiskCacheConfig getDefaultMainDiskCacheConfig(Context context) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");
            }
            return DiskCacheConfig.newBuilder(context).build();
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private static HashMap<String, DiskCacheConfig> getDefaultCustomDiskCacheConfigMap() {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DiskCacheConfig.getDefaultCustomDiskCacheConfigMap");
            }
            return new HashMap<>();
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    static void resetDefaultRequestConfig() {
        sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mImagePipelineConfigLazySet.getMBitmapConfig();
    }

    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMBitmapMemoryCacheParamsSupplier();
    }

    public Supplier<MemoryCacheParams> getSingleBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMSingleBitmapMemoryCacheParamsSupplier();
    }

    public Supplier<MemoryCacheParams> getBigImgBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMBigImgBitmapMemoryCacheParamsSupplier();
    }

    public Supplier<MemoryCacheParams> getAnimBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMAnimBitmapMemoryCacheParamsSupplier();
    }

    public Supplier<MemoryCacheParams> getPrefetchImgBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMPrefetchImgBitmapMemoryCacheParamsSupplier();
    }

    public CountingMemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.mImagePipelineConfigLazySet.getMBitmapMemoryCacheTrimStrategy();
    }

    public boolean isSplitMemCache() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        try {
            if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMIsSplitMemCache() == null)) {
                return false;
            }
            return this.mImagePipelineConfigLazySet.getMIsSplitMemCache().booleanValue();
        } catch (Throwable th) {
            FLog.m442e("debug_tt", "isSplitMemCache: t = " + th);
            return false;
        }
    }

    public boolean isEnableSingleMemCache() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        try {
            if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMEnableSingleMemCache() == null)) {
                return false;
            }
            return this.mImagePipelineConfigLazySet.getMEnableSingleMemCache().booleanValue();
        } catch (Throwable th) {
            FLog.m442e("debug_tt", "isSplitMemCache: t = " + th);
            return false;
        }
    }

    public boolean isEnableBigImgCache() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        try {
            if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMEnableBigImgCache() == null)) {
                return false;
            }
            return this.mImagePipelineConfigLazySet.getMEnableBigImgCache().booleanValue();
        } catch (Throwable th) {
            FLog.m442e("debug_tt", "isEnableBigImgCache: t = " + th);
            return false;
        }
    }

    public boolean isEnablePrefetchImgCache() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        try {
            if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMEnablePrefetchImgCache() == null)) {
                return false;
            }
            return this.mImagePipelineConfigLazySet.getMEnablePrefetchImgCache().booleanValue();
        } catch (Throwable th) {
            FLog.m442e("debug_tt", "isEnablePrefetchImgCache: t = " + th);
            return false;
        }
    }

    public boolean isUseOptHeifBitmap() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        try {
            if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMUseOptHeifBitmap() == null)) {
                return false;
            }
            return this.mImagePipelineConfigLazySet.getMUseOptHeifBitmap().booleanValue();
        } catch (Throwable th) {
            FLog.m442e("debug_tt", "isUseOptHeifBitmap: t = " + th);
            return false;
        }
    }

    public long getBigImgSizeLimit() {
        return this.mImagePipelineConfigLazySet.getMBigImgSizeLimit().longValue();
    }

    public boolean isShowHeifDebugLog() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMShowHeifDebugLog() == null)) {
            return false;
        }
        return this.mImagePipelineConfigLazySet.getMShowHeifDebugLog().booleanValue();
    }

    public boolean isAnimatedHeifIndividualCacheEnabled() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheEnabled() == null)) {
            return false;
        }
        return this.mImagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheEnabled().booleanValue();
    }

    public boolean isAnimatedHeifIndividualCacheForImageRequestEnabled() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheForImageRequestEnabled() == null)) {
            return false;
        }
        return this.mImagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheForImageRequestEnabled().booleanValue();
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mImagePipelineConfigLazySet.getMCacheKeyFactory();
    }

    public Context getContext() {
        return this.mImagePipelineConfigLazySet.getMContext();
    }

    public static DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return sDefaultImageRequestConfig;
    }

    public FileCacheFactory getFileCacheFactory() {
        return this.mImagePipelineConfigLazySet.getMFileCacheFactory();
    }

    public boolean isDownsampleEnabled() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMDownsampleEnabled() == null)) {
            return false;
        }
        return this.mImagePipelineConfigLazySet.getMDownsampleEnabled().booleanValue();
    }

    public boolean isDiskCacheEnabled() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMDiskCacheEnabled() == null)) {
            return false;
        }
        return this.mImagePipelineConfigLazySet.getMDiskCacheEnabled().booleanValue();
    }

    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMEncodedMemoryCacheParamsSupplier();
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.mImagePipelineConfigLazySet.getMExecutorSupplier();
    }

    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.mImagePipelineConfigLazySet.getMImageCacheStatsTracker();
    }

    @Nullable
    public ImageDecoder getImageDecoder() {
        return this.mImagePipelineConfigLazySet.getMImageDecoder();
    }

    @Nullable
    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.mImagePipelineConfigLazySet.getMImageTranscoderFactory();
    }

    @Nullable
    public Integer getImageTranscoderType() {
        return this.mImagePipelineConfigLazySet.getMImageTranscoderType();
    }

    public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        return this.mImagePipelineConfigLazySet.getMIsPrefetchEnabledSupplier();
    }

    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.mImagePipelineConfigLazySet.getMMainDiskCacheConfig();
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mImagePipelineConfigLazySet.getMMemoryTrimmableRegistry();
    }

    public int getMemoryChunkType() {
        return this.mImagePipelineConfigLazySet.getMMemoryChunkType().intValue();
    }

    public NetworkFetcher getNetworkFetcher() {
        return this.mImagePipelineConfigLazySet.getMNetworkFetcher();
    }

    @Nullable
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.mImagePipelineConfigLazySet.getMPlatformBitmapFactory();
    }

    public PoolFactory getPoolFactory() {
        return this.mImagePipelineConfigLazySet.getMPoolFactory();
    }

    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.mImagePipelineConfigLazySet.getMProgressiveJpegConfig();
    }

    public Set<RequestListener> getRequestListeners() {
        return Collections.unmodifiableSet(this.mImagePipelineConfigLazySet.getMRequestListeners());
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMResizeAndRotateEnabledForNetwork() == null)) {
            return false;
        }
        return this.mImagePipelineConfigLazySet.getMResizeAndRotateEnabledForNetwork().booleanValue();
    }

    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.mImagePipelineConfigLazySet.getMSmallImageDiskCacheConfig();
    }

    public HashMap<String, DiskCacheConfig> getCustomImageDiskCacheConfigMap() {
        return this.mImagePipelineConfigLazySet.getMCustomImageDiskCacheConfigMap();
    }

    @Nullable
    public ImageDecoderConfig getImageDecoderConfig() {
        return this.mImagePipelineConfigLazySet.getMImageDecoderConfig();
    }

    public ImagePipelineExperiments getExperiments() {
        return this.mImagePipelineConfigLazySet.getMImagePipelineExperiments();
    }

    public boolean isNewLocalVideoThumbnailOptEnabled() {
        ImagePipelineConfigLazySet imagePipelineConfigLazySet;
        try {
            if (FrescoCacheMonitorUtil.isOptLazyInit() && ((imagePipelineConfigLazySet = this.mImagePipelineConfigLazySet) == null || imagePipelineConfigLazySet.getMEnableNewLocalVideoThumbnailOpt() == null)) {
                return false;
            }
            return this.mImagePipelineConfigLazySet.getMEnableNewLocalVideoThumbnailOpt().booleanValue();
        } catch (Throwable th) {
            FLog.m442e("debug_tt", "isNewLocalVideoThumbnailOptEnabled: t = " + th);
            return false;
        }
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    @Nullable
    private static ImageTranscoderFactory getImageTranscoderFactory(Builder builder) {
        if (builder.mImageTranscoderFactory != null && builder.mImageTranscoderType != null) {
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
        }
        if (builder.mImageTranscoderFactory != null) {
            return builder.mImageTranscoderFactory;
        }
        return null;
    }

    private static int getMemoryChunkType(Builder builder, ImagePipelineExperiments imagePipelineExperiments) {
        if (builder.mMemoryChunkType != null) {
            return builder.mMemoryChunkType.intValue();
        }
        return imagePipelineExperiments.isNativeCodeDisabled() ? 1 : 0;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class DefaultImageRequestConfig {
        private boolean mDecodeHeicUseSystemApiFirst;
        private int mPixelsToPick;
        private boolean mProgressiveRenderingAnimatedEnabled;
        private boolean mProgressiveRenderingEnabled;
        private boolean mProgressiveRenderingHeicEnabled;

        private DefaultImageRequestConfig() {
            this.mProgressiveRenderingEnabled = false;
            this.mProgressiveRenderingAnimatedEnabled = false;
            this.mProgressiveRenderingHeicEnabled = false;
            this.mDecodeHeicUseSystemApiFirst = false;
            this.mPixelsToPick = 30;
        }

        public void setProgressiveRenderingEnabled(boolean z) {
            this.mProgressiveRenderingEnabled = z;
        }

        public boolean isProgressiveRenderingEnabled() {
            return this.mProgressiveRenderingEnabled;
        }

        public void setProgressiveRenderingAnimatedEnabled(boolean z) {
            this.mProgressiveRenderingAnimatedEnabled = z;
        }

        public boolean isProgressiveRenderingAnimatedEnabled() {
            return this.mProgressiveRenderingAnimatedEnabled;
        }

        public boolean isProgressiveRenderingHeicEnabled() {
            return this.mProgressiveRenderingHeicEnabled;
        }

        public void setProgressiveRenderingHeicEnabled(boolean z) {
            this.mProgressiveRenderingHeicEnabled = z;
        }

        public void setDecodeHeicUseSystemApiFirst(boolean z) {
            this.mDecodeHeicUseSystemApiFirst = z;
        }

        public boolean isDecodeHeicUseSystemApiFirst() {
            return this.mDecodeHeicUseSystemApiFirst;
        }

        public int getPixelsToPick() {
            return this.mPixelsToPick;
        }

        public void setPixelsToPick(int i) {
            this.mPixelsToPick = i;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Builder {
        private static int mHeicDecodeThreads = 1;
        private static boolean mHeicUseWpp = false;
        private static int mHeifDecodeThreads = 1;
        private static boolean mHeifUseWpp = false;
        private static boolean mOptMultiOriginListener = false;
        private static boolean mSRAutoScaleLowerFirst = false;
        private static boolean mUseNewOptHeifBitmap = false;
        private static boolean mUseOptHeifBitmap = false;
        private static int mVvicDecodeThreads = 1;
        private static boolean mVvicUseWpp;
        private Supplier<MemoryCacheParams> mAnimBitmapMemoryCacheParamsSupplier;
        private boolean mAnimatedHeifIndividualCacheEnabled;
        private boolean mAnimatedHeifIndividualCacheForImageRequestEnabled;
        private Supplier<MemoryCacheParams> mBigImgBitmapMemoryCacheParamsSupplier;
        private long mBigImgSizeLimit;
        private Bitmap.Config mBitmapConfig;
        private Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
        private CountingMemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
        private CacheKeyFactory mCacheKeyFactory;
        private final Context mContext;
        private HashMap<String, DiskCacheConfig> mCustomImageDiskCacheConfigMap;
        private boolean mDiskCacheEnabled;
        private boolean mDownsampleEnabled;
        private boolean mEnableAddLogUriInfo;
        private boolean mEnableBigImgCache;
        private boolean mEnableNewLocalVideoThumbnailOpt;
        private boolean mEnableSingleMemCache;
        private Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
        private ExecutorSupplier mExecutorSupplier;
        private final ImagePipelineExperiments.Builder mExperimentsBuilder;
        private FileCacheFactory mFileCacheFactory;
        private int mHttpConnectionTimeout;
        private ImageCacheStatsTracker mImageCacheStatsTracker;
        private ImageDecoder mImageDecoder;
        private ImageDecoderConfig mImageDecoderConfig;
        private ImageTranscoderFactory mImageTranscoderFactory;

        @Nullable
        private Integer mImageTranscoderType;
        private Supplier<Boolean> mIsPrefetchEnabledSupplier;
        private boolean mIsSplitMemCache;
        private boolean mIsSplitPrefetchCache;
        private DiskCacheConfig mMainDiskCacheConfig;

        @Nullable
        private Integer mMemoryChunkType;
        private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        private NetworkFetcher mNetworkFetcher;
        private boolean mOptPrefetchCacheKey;
        private PlatformBitmapFactory mPlatformBitmapFactory;
        private PoolFactory mPoolFactory;
        private Supplier<MemoryCacheParams> mPrefetchImgBitmapMemoryCacheParamsSupplier;
        private ProgressiveJpegConfig mProgressiveJpegConfig;
        private Set<RequestListener> mRequestListeners;
        private boolean mResizeAndRotateEnabledForNetwork;
        private boolean mRetainPreviousImage;
        private boolean mSaveAfterSrPostBitmap;
        private boolean mSavePreSrPostBitmap;
        private boolean mShowHeifDebugLog;
        private Supplier<MemoryCacheParams> mSingleBitmapMemoryCacheParamsSupplier;
        private DiskCacheConfig mSmallImageDiskCacheConfig;
        private Map<String, String> mWaitParseParamFromUrl;
        private boolean mWasImmediate;

        private Builder(Context context) {
            this.mDownsampleEnabled = FrescoOptUtil.isDownsampleEnabled();
            this.mImageTranscoderType = null;
            this.mMemoryChunkType = null;
            this.mResizeAndRotateEnabledForNetwork = true;
            this.mHttpConnectionTimeout = -1;
            this.mExperimentsBuilder = new ImagePipelineExperiments.Builder(this);
            this.mDiskCacheEnabled = true;
            this.mAnimatedHeifIndividualCacheEnabled = false;
            this.mAnimatedHeifIndividualCacheForImageRequestEnabled = false;
            this.mWasImmediate = true;
            this.mIsSplitMemCache = false;
            this.mEnableSingleMemCache = false;
            this.mShowHeifDebugLog = false;
            this.mEnableBigImgCache = false;
            this.mBigImgSizeLimit = ImagePipelineConfig.DEFAULT_BIG_IMG_SIZE_LIMIT;
            this.mRetainPreviousImage = false;
            this.mSavePreSrPostBitmap = true;
            this.mSaveAfterSrPostBitmap = false;
            this.mEnableNewLocalVideoThumbnailOpt = false;
            this.mIsSplitPrefetchCache = false;
            this.mOptPrefetchCacheKey = false;
            this.mEnableAddLogUriInfo = false;
            this.mContext = (Context) Preconditions.checkNotNull(context);
        }

        public Builder setWasImmediate(boolean z) {
            this.mWasImmediate = z;
            return this;
        }

        public Builder setBitmapsConfig(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setSingleBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mSingleBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setBigImgBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mBigImgBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setPrefetchImgBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mPrefetchImgBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setAnimBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mAnimBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setBitmapMemoryCacheTrimStrategy(CountingMemoryCache.CacheTrimStrategy cacheTrimStrategy) {
            this.mBitmapMemoryCacheTrimStrategy = cacheTrimStrategy;
            return this;
        }

        public Builder setSplitMemCache(boolean z) {
            this.mIsSplitMemCache = z;
            return this;
        }

        public boolean isSplitMemCache() {
            return this.mIsSplitMemCache;
        }

        public boolean isEnableSingleMemCache() {
            return this.mEnableSingleMemCache;
        }

        public Builder setEnableSingleMemCache(boolean z) {
            this.mEnableSingleMemCache = z;
            return this;
        }

        public Builder setSplitPrefetchCache(boolean z) {
            this.mIsSplitPrefetchCache = z;
            return this;
        }

        public boolean isSplitPrefetchCache() {
            return this.mIsSplitPrefetchCache;
        }

        public Builder setOptPrefetchCacheKey(boolean z) {
            this.mOptPrefetchCacheKey = z;
            return this;
        }

        public boolean isOptPrefetchCacheKey() {
            return this.mOptPrefetchCacheKey;
        }

        public Builder setEnableBigImgCache(boolean z) {
            this.mEnableBigImgCache = z;
            return this;
        }

        public boolean isEnableBigImgCache() {
            return this.mEnableBigImgCache;
        }

        public Builder setBigImgSizeLimit(long j) {
            this.mBigImgSizeLimit = j;
            return this;
        }

        public long getBigImgSizeLimit() {
            return this.mBigImgSizeLimit;
        }

        public Builder setEnableSavePreSrPostBitmap(boolean z) {
            this.mSavePreSrPostBitmap = z;
            return this;
        }

        public boolean isSavePrePostBitmap() {
            return this.mSavePreSrPostBitmap;
        }

        public Builder setEnableSaveAfterSrPostBitmap(boolean z) {
            this.mSaveAfterSrPostBitmap = z;
            return this;
        }

        public boolean isSaveAfterPostBitmap() {
            return this.mSaveAfterSrPostBitmap;
        }

        public Builder setRetainPreviousImage(boolean z) {
            this.mRetainPreviousImage = z;
            return this;
        }

        public boolean isRetainPreviousImage() {
            return this.mRetainPreviousImage;
        }

        public Builder setWaitParseParamFromUrl(Map<String, String> map) {
            this.mWaitParseParamFromUrl = map;
            return this;
        }

        public Map<String, String> getWaitParseParamFromUrl() {
            return this.mWaitParseParamFromUrl;
        }

        public Builder setUseOptHeifBitmap(boolean z) {
            mUseOptHeifBitmap = z;
            return this;
        }

        public boolean isUseOptHeifBitmap() {
            return mUseOptHeifBitmap;
        }

        public Builder setUseNewOptHeifBitmap(boolean z) {
            mUseNewOptHeifBitmap = z;
            return this;
        }

        public boolean isUseNewOptHeifBitmap() {
            return mUseNewOptHeifBitmap;
        }

        public Builder setVvicUseWpp(boolean z) {
            mVvicUseWpp = z;
            return this;
        }

        public boolean isVvicUseWpp() {
            return mVvicUseWpp;
        }

        public Builder setVvicDecodeThreads(int i) {
            mVvicDecodeThreads = i;
            return this;
        }

        public int getVvicDecodeThreads() {
            return mVvicDecodeThreads;
        }

        public Builder setHeicUseWpp(boolean z) {
            mHeicUseWpp = z;
            return this;
        }

        public boolean isHeicUseWpp() {
            return mHeicUseWpp;
        }

        public Builder setHeicDecodeThreads(int i) {
            mHeicDecodeThreads = i;
            return this;
        }

        public int getHeicDecodeThreads() {
            return mHeicDecodeThreads;
        }

        public Builder setHeifUseWpp(boolean z) {
            mHeifUseWpp = z;
            return this;
        }

        public boolean isHeifUseWpp() {
            return mHeifUseWpp;
        }

        public Builder setHeifDecodeThreads(int i) {
            mHeifDecodeThreads = i;
            return this;
        }

        public int getHeifDecodeThreads() {
            return mHeifDecodeThreads;
        }

        public Builder setOptMultiOriginListener(boolean z) {
            mOptMultiOriginListener = z;
            return this;
        }

        public boolean isOptMultiOriginListener() {
            return mOptMultiOriginListener;
        }

        public Builder setSRAutoScaleLowerFirst(boolean z) {
            mSRAutoScaleLowerFirst = z;
            return this;
        }

        public boolean isSRAutoScaleLowerFirst() {
            return mSRAutoScaleLowerFirst;
        }

        public Builder setShowHeifDebugLog(boolean z) {
            this.mShowHeifDebugLog = z;
            return this;
        }

        public boolean isShowHeifDebugLog() {
            return this.mShowHeifDebugLog;
        }

        public Builder setEnableAnimatedHeifIndividualCache(boolean z) {
            this.mAnimatedHeifIndividualCacheEnabled = z;
            return this;
        }

        public boolean isEnableAnimatedHeifIndividualCache() {
            return this.mAnimatedHeifIndividualCacheEnabled;
        }

        public Builder setEnableAnimatedHeifIndividualCacheForImageRequest(boolean z) {
            this.mAnimatedHeifIndividualCacheForImageRequestEnabled = z;
            return this;
        }

        public boolean isEnableAnimatedHeifIndividualCacheForImageRequest() {
            return this.mAnimatedHeifIndividualCacheForImageRequestEnabled;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.mCacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public Builder setHttpConnectionTimeout(int i) {
            this.mHttpConnectionTimeout = i;
            return this;
        }

        public Builder setFileCacheFactory(FileCacheFactory fileCacheFactory) {
            this.mFileCacheFactory = fileCacheFactory;
            return this;
        }

        public boolean isDownsampleEnabled() {
            return this.mDownsampleEnabled;
        }

        public Builder setDownsampleEnabled(boolean z) {
            this.mDownsampleEnabled = z;
            return this;
        }

        public boolean isDiskCacheEnabled() {
            return this.mDiskCacheEnabled;
        }

        public Builder setDiskCacheEnabled(boolean z) {
            this.mDiskCacheEnabled = z;
            return this;
        }

        public Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mEncodedMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setExecutorSupplier(ExecutorSupplier executorSupplier) {
            this.mExecutorSupplier = executorSupplier;
            return this;
        }

        public Builder setImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.mImageCacheStatsTracker = imageCacheStatsTracker;
            return this;
        }

        public Builder setImageDecoder(ImageDecoder imageDecoder) {
            this.mImageDecoder = imageDecoder;
            return this;
        }

        @Nullable
        public Integer getImageTranscoderType() {
            return this.mImageTranscoderType;
        }

        public Builder setImageTranscoderType(int i) {
            this.mImageTranscoderType = Integer.valueOf(i);
            return this;
        }

        public Builder setImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
            this.mImageTranscoderFactory = imageTranscoderFactory;
            return this;
        }

        public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> supplier) {
            this.mIsPrefetchEnabledSupplier = supplier;
            return this;
        }

        public Builder setMainDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mMainDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        @Nullable
        public Integer getMemoryChunkType() {
            return this.mMemoryChunkType;
        }

        public Builder setMemoryChunkType(int i) {
            this.mMemoryChunkType = Integer.valueOf(i);
            return this;
        }

        public Builder setNetworkFetcher(NetworkFetcher networkFetcher) {
            this.mNetworkFetcher = networkFetcher;
            return this;
        }

        public Builder setPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
            this.mPlatformBitmapFactory = platformBitmapFactory;
            return this;
        }

        public Builder setPoolFactory(PoolFactory poolFactory) {
            this.mPoolFactory = poolFactory;
            return this;
        }

        public Builder setProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
            this.mProgressiveJpegConfig = progressiveJpegConfig;
            return this;
        }

        public Builder setRequestListeners(Set<RequestListener> set) {
            this.mRequestListeners = set;
            return this;
        }

        public Builder setResizeAndRotateEnabledForNetwork(boolean z) {
            this.mResizeAndRotateEnabledForNetwork = z;
            return this;
        }

        public Builder setSmallImageDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mSmallImageDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder setCustomImageDiskCacheConfigMap(HashMap<String, DiskCacheConfig> hashMap) {
            this.mCustomImageDiskCacheConfigMap = hashMap;
            return this;
        }

        public Builder setImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
            this.mImageDecoderConfig = imageDecoderConfig;
            Iterator<ImageFormat> it = imageDecoderConfig.getCustomImageDecoders().keySet().iterator();
            while (it.hasNext()) {
                ImageFormatUtils.addCustomFormat(it.next().getFileExtension());
            }
            return this;
        }

        public boolean isNewLocalVideoThumbnailOptEnabled() {
            return this.mEnableNewLocalVideoThumbnailOpt;
        }

        public Builder setNewLocalVideoThumbnailOptEnabled(boolean z) {
            this.mEnableNewLocalVideoThumbnailOpt = z;
            return this;
        }

        public Builder setOptAddLogUriInfo(boolean z) {
            this.mEnableAddLogUriInfo = z;
            return this;
        }

        public boolean isOptAddLogUriInfo() {
            return this.mEnableAddLogUriInfo;
        }

        public ImagePipelineExperiments.Builder experiment() {
            return this.mExperimentsBuilder;
        }

        public ImagePipelineConfig build() {
            return new ImagePipelineConfig(this);
        }
    }
}
