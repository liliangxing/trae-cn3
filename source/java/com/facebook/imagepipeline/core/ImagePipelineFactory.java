package com.facebook.imagepipeline.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.Lazy;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedHashMapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.OreoDecoder;
import com.facebook.imagepipeline.platform.PieDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory;
import com.fackbook.imagepipeline.DefaultImagepipelineConfig;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImagePipelineFactory {
    private static ImageDecoder sHeifDecoder;
    private CountingMemoryCache<CacheKey, CloseableImage> mAnimBitmapCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mAnimBitmapMemoryCache;
    private AnimatedFactory mAnimatedFactory;
    private HashMapMemoryCache<CacheKey, Bitmap> mAnimatedHeifFrameMemoryCache;
    private CountingMemoryCache<CacheKey, CloseableImage> mBigImgBitmapCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mBigImgBitmapMemoryCache;
    private long mBigImgSizeLimit;
    private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
    private HashMap<String, FileCache> mCustomImageFileCacheMap;
    private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private IImagePipelineConfig mIConfig;
    private ImageDecoder mImageDecoder;
    private ImagePipeline mImagePipeline;
    private ImageTranscoderFactory mImageTranscoderFactory;
    private InstrumentedMemoryCache<CacheKey, Bitmap> mInstrumentedHeifFrameMemoryCache;
    private BufferedDiskCache mMainBufferedDiskCache;
    private FileCache mMainFileCache;
    private PlatformBitmapFactory mPlatformBitmapFactory;
    private PlatformDecoder mPlatformDecoder;
    private CountingMemoryCache<CacheKey, CloseableImage> mPrefetchImgBitmapCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mPrefetchImgBitmapMemoryCache;
    private ProducerFactory mProducerFactory;
    private ProducerSequenceFactory mProducerSequenceFactory;
    private CountingMemoryCache<CacheKey, CloseableImage> mSingleBitmapCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mSingleBitmapMemoryCache;
    private BufferedDiskCache mSmallImageBufferedDiskCache;
    private FileCache mSmallImageFileCache;
    private static final Class<?> TAG = ImagePipelineFactory.class;
    private static ImagePipelineFactory sInstance = DefaultImagepipelineConfig.INSTANCE.getImagePipelineFactory();
    private Lazy<ThreadHandoffProducerQueue> mThreadHandoffProducerQueue = new Lazy<ThreadHandoffProducerQueue>() { // from class: com.facebook.imagepipeline.core.ImagePipelineFactory.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.common.util.Lazy
        public ThreadHandoffProducerQueue initialValue() {
            return new ThreadHandoffProducerQueue(((ImagePipelineConfig) ImagePipelineFactory.this.mConfig.get()).getExecutorSupplier().forLightweightBackgroundTasks());
        }
    };
    private Lazy<ImagePipelineConfig> mConfig = new Lazy<ImagePipelineConfig>() { // from class: com.facebook.imagepipeline.core.ImagePipelineFactory.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.common.util.Lazy
        public ImagePipelineConfig initialValue() {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipelineConfig()");
            }
            if (ImagePipelineFactory.this.mIConfig != null) {
                ImagePipelineConfig imagePipelineConfig = (ImagePipelineConfig) Preconditions.checkNotNull(ImagePipelineFactory.this.mIConfig.getImagePipelineConfig());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return imagePipelineConfig;
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return (ImagePipelineConfig) super.initialValue();
        }
    };
    private boolean mIsSplitMemCache = false;
    private boolean mEnableSingleCache = false;
    private boolean mEnableBigImgCache = false;
    private boolean mIsSplitPrefetchCache = false;
    private boolean mEnableNewLocalVideoThumbnailOpt = false;

    public static ImagePipelineFactory getInstance() {
        return (ImagePipelineFactory) Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
    }

    public static void setInstance(ImagePipelineFactory imagePipelineFactory) {
        sInstance = imagePipelineFactory;
    }

    public static synchronized void initialize(Context context) {
        synchronized (ImagePipelineFactory.class) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipelineFactory#initialize");
            }
            initialize(ImagePipelineConfig.newBuilder(context).build());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig) {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                FLog.m478w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            sInstance = new ImagePipelineFactory(imagePipelineConfig);
        }
    }

    public static synchronized void initialize(IImagePipelineConfig iImagePipelineConfig, Boolean bool) {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                FLog.m478w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            sInstance = new ImagePipelineFactory(iImagePipelineConfig);
            if (Boolean.TRUE == bool) {
                sInstance.tryInitConfig();
            }
        }
    }

    public static synchronized boolean hasBeenInitialized() {
        boolean z;
        synchronized (ImagePipelineFactory.class) {
            z = sInstance != null;
        }
        return z;
    }

    public static synchronized void shutDown() {
        synchronized (ImagePipelineFactory.class) {
            ImagePipelineFactory imagePipelineFactory = sInstance;
            if (imagePipelineFactory != null) {
                imagePipelineFactory.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
                sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
                sInstance.getAnimatedHeifFrameMemoryCache().removeAll(AndroidPredicates.True());
                if ((sInstance.mIsSplitMemCache || ImagePipelineConfig.getInstance().isSplitMemCache()) && sInstance.getAnimBitmapMemoryCache() != null) {
                    sInstance.getAnimBitmapMemoryCache().removeAll(AndroidPredicates.True());
                }
                if ((sInstance.mEnableBigImgCache || ImagePipelineConfig.getInstance().isEnableBigImgCache()) && sInstance.getBigImgBitmapMemoryCache() != null) {
                    sInstance.getBigImgBitmapMemoryCache().removeAll(AndroidPredicates.True());
                }
                if ((sInstance.mIsSplitPrefetchCache || ImagePipelineConfig.getInstance().isEnablePrefetchImgCache()) && sInstance.getPrefetchImgBitmapMemoryCache() != null) {
                    sInstance.getPrefetchImgBitmapMemoryCache().removeAll(AndroidPredicates.True());
                }
                sInstance = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        this.mConfig.set(Preconditions.checkNotNull(imagePipelineConfig));
        this.mThreadHandoffProducerQueue.set(new ThreadHandoffProducerQueue(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks()));
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public ImagePipelineFactory(IImagePipelineConfig iImagePipelineConfig) {
        this.mIConfig = (IImagePipelineConfig) Preconditions.checkNotNull(iImagePipelineConfig);
    }

    public ImagePipelineConfig getImagePipelineConfig() {
        tryInitConfig();
        return this.mConfig.get();
    }

    private void tryInitConfig() {
        if (this.mConfig != null) {
            return;
        }
        synchronized (this) {
            if (this.mConfig != null) {
                return;
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipelineConfig()");
            }
            ImagePipelineConfig imagePipelineConfig = (ImagePipelineConfig) Preconditions.checkNotNull(this.mIConfig.getImagePipelineConfig());
            this.mThreadHandoffProducerQueue.set(new ThreadHandoffProducerQueue(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks()));
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            this.mConfig.set(imagePipelineConfig);
        }
    }

    public AnimatedFactory getAnimatedFactory() {
        if (this.mAnimatedFactory == null) {
            tryInitConfig();
            if (this.mIsSplitMemCache || this.mConfig.get().isSplitMemCache()) {
                this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.get().getExecutorSupplier(), getAnimBitmapCountingMemoryCache(), getAnimatedHeifFrameMemoryCache());
            } else {
                this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.get().getExecutorSupplier(), getBitmapCountingMemoryCache(), getAnimatedHeifFrameMemoryCache());
            }
        }
        return this.mAnimatedFactory;
    }

    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        AnimatedFactory animatedFactory = getAnimatedFactory();
        if (animatedFactory == null) {
            return null;
        }
        return animatedFactory.getAnimatedDrawableFactory(context);
    }

    public void setSplitMemCache(boolean z) {
        this.mIsSplitMemCache = z;
    }

    public boolean isSplitMemCache() {
        return this.mIsSplitMemCache || ImagePipelineConfig.getInstance().isSplitMemCache();
    }

    public void setSplitPrefetchCache(boolean z) {
        this.mIsSplitPrefetchCache = z;
    }

    public boolean isSplitPrefetchCache() {
        return this.mIsSplitPrefetchCache || ImagePipelineConfig.getInstance().isEnablePrefetchImgCache();
    }

    public void setEnableSingleCache(boolean z) {
        this.mEnableSingleCache = z;
    }

    public boolean isEnableSingleCache() {
        return this.mEnableSingleCache || ImagePipelineConfig.getInstance().isEnableSingleMemCache();
    }

    public void setEnableBigImgCache(boolean z) {
        this.mEnableBigImgCache = z;
    }

    public boolean isEnableBigImgCache() {
        return this.mEnableBigImgCache || ImagePipelineConfig.getInstance().isEnableBigImgCache();
    }

    public void setBigImgSizeLimit(long j) {
        this.mBigImgSizeLimit = j;
    }

    public long getBigImgSizeLimit() {
        return this.mBigImgSizeLimit;
    }

    public boolean isNewLocalVideoThumbnailOptEnabled() {
        return this.mEnableNewLocalVideoThumbnailOpt;
    }

    public void setNewLocalVideoThumbnailOptEnabled(boolean z) {
        this.mEnableNewLocalVideoThumbnailOpt = z;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        if (this.mBitmapCountingMemoryCache == null) {
            tryInitConfig();
            this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.get().getBitmapMemoryCacheParamsSupplier(), this.mConfig.get().getMemoryTrimmableRegistry(), this.mConfig.get().getBitmapMemoryCacheTrimStrategy());
        }
        return this.mBitmapCountingMemoryCache;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getSingleBitmapCountingMemoryCache() {
        if (this.mSingleBitmapCountingMemoryCache == null) {
            this.mSingleBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.get().getSingleBitmapMemoryCacheParamsSupplier(), this.mConfig.get().getMemoryTrimmableRegistry(), this.mConfig.get().getBitmapMemoryCacheTrimStrategy());
        }
        return this.mSingleBitmapCountingMemoryCache;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBigImgBitmapCountingMemoryCache() {
        if (this.mBigImgBitmapCountingMemoryCache == null) {
            this.mBigImgBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.get().getBigImgBitmapMemoryCacheParamsSupplier(), this.mConfig.get().getMemoryTrimmableRegistry(), this.mConfig.get().getBitmapMemoryCacheTrimStrategy());
        }
        return this.mBigImgBitmapCountingMemoryCache;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getPrefetchImgBitmapCountingMemoryCache() {
        if (this.mPrefetchImgBitmapCountingMemoryCache == null) {
            this.mPrefetchImgBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.get().getPrefetchImgBitmapMemoryCacheParamsSupplier(), this.mConfig.get().getMemoryTrimmableRegistry(), this.mConfig.get().getBitmapMemoryCacheTrimStrategy());
        }
        return this.mPrefetchImgBitmapCountingMemoryCache;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getAnimBitmapCountingMemoryCache() {
        if (this.mAnimBitmapCountingMemoryCache == null) {
            this.mAnimBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.get().getAnimBitmapMemoryCacheParamsSupplier(), this.mConfig.get().getMemoryTrimmableRegistry(), this.mConfig.get().getBitmapMemoryCacheTrimStrategy());
        }
        return this.mAnimBitmapCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        if (this.mBitmapMemoryCache == null) {
            tryInitConfig();
            this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.get().getImageCacheStatsTracker());
        }
        return this.mBitmapMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getSingleBitmapMemoryCache() {
        if (this.mSingleBitmapMemoryCache == null) {
            this.mSingleBitmapMemoryCache = BitmapMemoryCacheFactory.get(getSingleBitmapCountingMemoryCache(), this.mConfig.get().getImageCacheStatsTracker());
        }
        return this.mSingleBitmapMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBigImgBitmapMemoryCache() {
        if (this.mBigImgBitmapMemoryCache == null) {
            this.mBigImgBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBigImgBitmapCountingMemoryCache(), this.mConfig.get().getImageCacheStatsTracker());
        }
        return this.mBigImgBitmapMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getPrefetchImgBitmapMemoryCache() {
        if (this.mPrefetchImgBitmapMemoryCache == null) {
            this.mPrefetchImgBitmapMemoryCache = BitmapMemoryCacheFactory.get(getPrefetchImgBitmapCountingMemoryCache(), this.mConfig.get().getImageCacheStatsTracker());
        }
        return this.mPrefetchImgBitmapMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getAnimBitmapMemoryCache() {
        if (this.mAnimBitmapMemoryCache == null) {
            this.mAnimBitmapMemoryCache = BitmapMemoryCacheFactory.get(getAnimBitmapCountingMemoryCache(), this.mConfig.get().getImageCacheStatsTracker());
        }
        return this.mAnimBitmapMemoryCache;
    }

    public HashMapMemoryCache<CacheKey, Bitmap> getAnimatedHeifFrameMemoryCache() {
        if (this.mAnimatedHeifFrameMemoryCache == null) {
            this.mAnimatedHeifFrameMemoryCache = HashMapMemoryCacheFactory.get();
        }
        return this.mAnimatedHeifFrameMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, Bitmap> getAnimatedHeifMemoryCache() {
        if (this.mInstrumentedHeifFrameMemoryCache == null) {
            this.mInstrumentedHeifFrameMemoryCache = InstrumentedHashMapMemoryCacheFactory.get(getAnimatedHeifFrameMemoryCache(), this.mConfig.get().getImageCacheStatsTracker());
        }
        return this.mInstrumentedHeifFrameMemoryCache;
    }

    public boolean isShowHeifDebugLog() {
        return this.mConfig.get().isShowHeifDebugLog();
    }

    public boolean isAnimatedHeifIndividualCacheEnabled() {
        return this.mConfig.get().isAnimatedHeifIndividualCacheEnabled();
    }

    public boolean isAnimatedHeifIndividualCacheForImageRequestEnabled() {
        return this.mConfig.get().isAnimatedHeifIndividualCacheForImageRequestEnabled();
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
        if (this.mEncodedCountingMemoryCache == null) {
            tryInitConfig();
            this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.get().getEncodedMemoryCacheParamsSupplier(), this.mConfig.get().getMemoryTrimmableRegistry());
        }
        return this.mEncodedCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        if (this.mEncodedMemoryCache == null) {
            tryInitConfig();
            this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(getEncodedCountingMemoryCache(), this.mConfig.get().getImageCacheStatsTracker());
        }
        return this.mEncodedMemoryCache;
    }

    private ImageDecoder getImageDecoder() {
        ImageDecoder imageDecoder;
        ImageDecoder imageDecoder2;
        ImageDecoder imageDecoder3;
        if (this.mImageDecoder == null) {
            tryInitConfig();
            if (this.mConfig.get().getImageDecoder() != null) {
                this.mImageDecoder = this.mConfig.get().getImageDecoder();
            } else {
                AnimatedFactory animatedFactory = getAnimatedFactory();
                ImageDecoder buildHeifDecoder = buildHeifDecoder();
                if (animatedFactory != null) {
                    ImageDecoder gifDecoder = animatedFactory.getGifDecoder(Bitmap.Config.RGB_565);
                    ImageDecoder webPDecoder = animatedFactory.getWebPDecoder(Bitmap.Config.RGB_565);
                    imageDecoder3 = animatedFactory.getHeifDecoder(Bitmap.Config.ARGB_8888);
                    imageDecoder2 = webPDecoder;
                    imageDecoder = gifDecoder;
                } else {
                    imageDecoder = null;
                    imageDecoder2 = null;
                    imageDecoder3 = null;
                }
                if (this.mConfig.get().getImageDecoderConfig() == null) {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder, imageDecoder2, imageDecoder3, buildHeifDecoder, getPlatformDecoder());
                } else {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder, imageDecoder2, imageDecoder3, buildHeifDecoder, getPlatformDecoder(), this.mConfig.get().getImageDecoderConfig().getCustomImageDecoders());
                    ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.get().getImageDecoderConfig().getCustomImageFormats());
                }
            }
        }
        return this.mImageDecoder;
    }

    public BufferedDiskCache getMainBufferedDiskCache() {
        if (this.mMainBufferedDiskCache == null) {
            tryInitConfig();
            BufferedDiskCache bufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.get().getPoolFactory().getPooledByteBufferFactory(this.mConfig.get().getMemoryChunkType()), this.mConfig.get().getPoolFactory().getPooledByteStreams(), this.mConfig.get().getExecutorSupplier().forLocalStorageRead(), this.mConfig.get().getExecutorSupplier().forLocalStorageWrite(), this.mConfig.get().getImageCacheStatsTracker());
            this.mMainBufferedDiskCache = bufferedDiskCache;
            FrescoCacheMonitorUtil.setMainStagingArea(bufferedDiskCache.getStagingArea());
            FrescoCacheMonitorUtil.setMainFileCache(getMainFileCache());
            this.mMainBufferedDiskCache.setNeedMD5(this.mConfig.get().getMainDiskCacheConfig().getNeedMD5());
            this.mMainBufferedDiskCache.setNeedEncrypt(this.mConfig.get().getMainDiskCacheConfig().getNeedEncrypt());
        }
        return this.mMainBufferedDiskCache;
    }

    public FileCache getMainFileCache() {
        if (this.mMainFileCache == null) {
            tryInitConfig();
            this.mMainFileCache = this.mConfig.get().getFileCacheFactory().get(this.mConfig.get().getMainDiskCacheConfig());
        }
        return this.mMainFileCache;
    }

    public ImagePipeline getImagePipeline() {
        if (this.mImagePipeline == null) {
            tryInitConfig();
            if (this.mIsSplitMemCache || this.mConfig.get().isSplitMemCache()) {
                this.mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.get().getRequestListeners(), this.mConfig.get().getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getAnimBitmapMemoryCache(), getAnimatedHeifMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), getCustomImageBufferedDiskCacheMap(), this.mConfig.get().getCacheKeyFactory(), this.mThreadHandoffProducerQueue.get(), Suppliers.m421of(false), this.mConfig.get().getExperiments().isLazyDataSource());
            } else {
                this.mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.get().getRequestListeners(), this.mConfig.get().getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getAnimatedHeifMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), getCustomImageBufferedDiskCacheMap(), this.mConfig.get().getCacheKeyFactory(), this.mThreadHandoffProducerQueue.get(), Suppliers.m421of(false), this.mConfig.get().getExperiments().isLazyDataSource());
            }
        }
        return this.mImagePipeline;
    }

    public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory poolFactory, PlatformDecoder platformDecoder) {
        return new ArtBitmapFactory(poolFactory.getBitmapPool());
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.mPlatformBitmapFactory == null) {
            tryInitConfig();
            this.mPlatformBitmapFactory = buildPlatformBitmapFactory(this.mConfig.get().getPoolFactory(), getPlatformDecoder());
        }
        return this.mPlatformBitmapFactory;
    }

    public static PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z, boolean z2, boolean z3) {
        if ((Build.VERSION.SDK_INT == 28 && z2) || (Build.VERSION.SDK_INT == 29 && z3)) {
            int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new PieDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            int flexByteArrayPoolMaxNumThreads2 = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new OreoDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads2, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads2));
        }
        int flexByteArrayPoolMaxNumThreads3 = poolFactory.getFlexByteArrayPoolMaxNumThreads();
        return new ArtDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads3, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads3));
    }

    public PlatformDecoder getPlatformDecoder() {
        if (this.mPlatformDecoder == null) {
            tryInitConfig();
            this.mPlatformDecoder = buildPlatformDecoder(this.mConfig.get().getPoolFactory(), this.mConfig.get().getExperiments().isGingerbreadDecoderEnabled(), this.mConfig.get().getExperiments().isPieDecoderEnabled(), this.mConfig.get().getExperiments().isQDecoderEnabled());
        }
        return this.mPlatformDecoder;
    }

    private ProducerFactory getProducerFactory() {
        if (this.mProducerFactory == null) {
            tryInitConfig();
            this.mProducerFactory = this.mConfig.get().getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.get().getContext(), this.mConfig.get().getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.get().getProgressiveJpegConfig(), this.mConfig.get().isDownsampleEnabled(), this.mConfig.get().isResizeAndRotateEnabledForNetwork(), this.mConfig.get().getExperiments().isDecodeCancellationEnabled(), this.mConfig.get().getExecutorSupplier(), this.mConfig.get().getPoolFactory().getPooledByteBufferFactory(this.mConfig.get().getMemoryChunkType()), getBitmapMemoryCache(), getAnimatedHeifMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), getCustomImageBufferedDiskCacheMap(), this.mConfig.get().getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.get().getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.get().getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.get().getExperiments().getBitmapPrepareToDrawForPrefetch(), this.mConfig.get().getExperiments().getMaxBitmapSize(), this.mConfig.get().getExperiments().isOomOptEnabled());
        }
        return this.mProducerFactory;
    }

    public ProducerSequenceFactory getProducerSequenceFactory() {
        tryInitConfig();
        boolean z = this.mConfig.get().getExperiments().getUseBitmapPrepareToDraw();
        if (this.mProducerSequenceFactory == null) {
            this.mProducerSequenceFactory = new ProducerSequenceFactory(this.mConfig.get().getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.get().getNetworkFetcher(), this.mConfig.get().isResizeAndRotateEnabledForNetwork(), this.mConfig.get().getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue.get(), this.mConfig.get().isDownsampleEnabled(), z, this.mConfig.get().getExperiments().isPartialImageCachingEnabled(), this.mConfig.get().isDiskCacheEnabled(), getImageTranscoderFactory());
        }
        return this.mProducerSequenceFactory;
    }

    public FileCache getSmallImageFileCache() {
        if (this.mSmallImageFileCache == null) {
            tryInitConfig();
            this.mSmallImageFileCache = this.mConfig.get().getFileCacheFactory().get(this.mConfig.get().getSmallImageDiskCacheConfig());
        }
        return this.mSmallImageFileCache;
    }

    public synchronized HashMap<String, FileCache> getCustomImageFileCacheMap() {
        if (this.mCustomImageFileCacheMap == null) {
            this.mCustomImageFileCacheMap = new HashMap<>();
            HashMap<String, DiskCacheConfig> customImageDiskCacheConfigMap = this.mConfig.get().getCustomImageDiskCacheConfigMap();
            for (String str : customImageDiskCacheConfigMap.keySet()) {
                this.mCustomImageFileCacheMap.put(str, this.mConfig.get().getFileCacheFactory().get(customImageDiskCacheConfigMap.get(str)));
            }
        }
        return this.mCustomImageFileCacheMap;
    }

    public BufferedDiskCache getSmallImageBufferedDiskCache() {
        if (this.mSmallImageBufferedDiskCache == null) {
            tryInitConfig();
            BufferedDiskCache bufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.get().getPoolFactory().getPooledByteBufferFactory(this.mConfig.get().getMemoryChunkType()), this.mConfig.get().getPoolFactory().getPooledByteStreams(), this.mConfig.get().getExecutorSupplier().forLocalStorageRead(), this.mConfig.get().getExecutorSupplier().forLocalStorageWrite(), this.mConfig.get().getImageCacheStatsTracker());
            this.mSmallImageBufferedDiskCache = bufferedDiskCache;
            bufferedDiskCache.setNeedMD5(this.mConfig.get().getMainDiskCacheConfig().getNeedMD5());
            this.mSmallImageBufferedDiskCache.setNeedEncrypt(this.mConfig.get().getMainDiskCacheConfig().getNeedEncrypt());
        }
        return this.mSmallImageBufferedDiskCache;
    }

    public HashMap<String, BufferedDiskCache> getCustomImageBufferedDiskCacheMap() {
        if (this.mCustomImageBufferedDiskCacheMap == null) {
            this.mCustomImageBufferedDiskCacheMap = new HashMap<>();
            HashMap<String, FileCache> customImageFileCacheMap = getCustomImageFileCacheMap();
            for (String str : customImageFileCacheMap.keySet()) {
                BufferedDiskCache bufferedDiskCache = new BufferedDiskCache(customImageFileCacheMap.get(str), this.mConfig.get().getPoolFactory().getPooledByteBufferFactory(this.mConfig.get().getMemoryChunkType()), this.mConfig.get().getPoolFactory().getPooledByteStreams(), this.mConfig.get().getExecutorSupplier().forLocalStorageRead(), this.mConfig.get().getExecutorSupplier().forLocalStorageWrite(), this.mConfig.get().getImageCacheStatsTracker());
                DiskCacheConfig diskCacheConfig = this.mConfig.get().getCustomImageDiskCacheConfigMap().get(str);
                if (diskCacheConfig != null) {
                    bufferedDiskCache.setNeedMD5(diskCacheConfig.getNeedMD5());
                    bufferedDiskCache.setNeedEncrypt(diskCacheConfig.getNeedEncrypt());
                }
                this.mCustomImageBufferedDiskCacheMap.put(str, bufferedDiskCache);
            }
        }
        return this.mCustomImageBufferedDiskCacheMap;
    }

    protected ImageTranscoderFactory getImageTranscoderFactory() {
        if (this.mImageTranscoderFactory == null) {
            tryInitConfig();
            if (this.mConfig.get().getImageTranscoderFactory() == null && this.mConfig.get().getImageTranscoderType() == null && this.mConfig.get().getExperiments().isNativeCodeDisabled()) {
                this.mImageTranscoderFactory = new SimpleImageTranscoderFactory(this.mConfig.get().getExperiments().getMaxBitmapSize());
            } else {
                this.mImageTranscoderFactory = new MultiImageTranscoderFactory(this.mConfig.get().getExperiments().getMaxBitmapSize(), this.mConfig.get().getExperiments().getUseDownsamplingRatioForResizing(), this.mConfig.get().getImageTranscoderFactory(), this.mConfig.get().getImageTranscoderType());
            }
        }
        return this.mImageTranscoderFactory;
    }

    protected ImageDecoder buildHeifDecoder() {
        if (sHeifDecoder == null) {
            try {
                sHeifDecoder = (ImageDecoder) Class.forName("com.bytedance.fresco.heif.HeifDecoder$HeifFormatDecoder").getConstructor(PooledByteBufferFactory.class).newInstance(this.mConfig.get().getPoolFactory().getPooledByteBufferFactory());
            } catch (Throwable unused) {
                return null;
            }
        }
        return sHeifDecoder;
    }
}
