package com.facebook.imagepipeline.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.datasource.FrescoOptUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imageutils.BitmapUtil;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImagePipelineExperiments {
    private boolean mBitmapPrepareToDrawForPrefetch;
    private final int mBitmapPrepareToDrawMaxSizeBytes;
    private final int mBitmapPrepareToDrawMinSizeBytes;
    private final boolean mDecodeCancellationEnabled;
    private final boolean mGingerbreadDecoderEnabled;
    private final boolean mIntermediateProgressUpdatesDisabled;
    private final boolean mIntermediateProgressUpdatesForPrefetchDisabled;
    private final Supplier<Boolean> mLazyDataSource;
    private final int mMaxBitmapSize;
    private final boolean mNativeCodeDisabled;
    private final boolean mOomOptEnabled;
    private final boolean mPartialImageCachingEnabled;
    private final boolean mPieDecoderEnabled;
    private final ProducerFactoryMethod mProducerFactoryMethod;
    private final boolean mQDecoderEnabled;
    private final boolean mUseBitmapPrepareToDraw;
    private final boolean mUseDownsamplingRatioForResizing;
    private final WebpBitmapFactory mWebpBitmapFactory;
    private final WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
    private final boolean mWebpSupportEnabled;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface ProducerFactoryMethod {
        ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, Bitmap> memoryCache2, MemoryCache<CacheKey, PooledByteBuffer> memoryCache3, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, boolean z5);
    }

    private ImagePipelineExperiments(Builder builder) {
        this.mWebpSupportEnabled = builder.mWebpSupportEnabled;
        this.mWebpErrorLogger = builder.mWebpErrorLogger;
        this.mDecodeCancellationEnabled = builder.mDecodeCancellationEnabled;
        this.mWebpBitmapFactory = builder.mWebpBitmapFactory;
        this.mUseDownsamplingRatioForResizing = builder.mUseDownsamplingRatioForResizing;
        this.mUseBitmapPrepareToDraw = builder.mUseBitmapPrepareToDraw;
        this.mBitmapPrepareToDrawMinSizeBytes = builder.mBitmapPrepareToDrawMinSizeBytes;
        this.mBitmapPrepareToDrawMaxSizeBytes = builder.mBitmapPrepareToDrawMaxSizeBytes;
        this.mBitmapPrepareToDrawForPrefetch = builder.mBitmapPrepareToDrawForPrefetch;
        this.mMaxBitmapSize = builder.mMaxBitmapSize;
        this.mNativeCodeDisabled = builder.mNativeCodeDisabled;
        this.mPartialImageCachingEnabled = builder.mPartialImageCachingEnabled;
        if (builder.mProducerFactoryMethod == null) {
            this.mProducerFactoryMethod = new DefaultProducerFactoryMethod();
        } else {
            this.mProducerFactoryMethod = builder.mProducerFactoryMethod;
        }
        this.mLazyDataSource = builder.mLazyDataSource;
        this.mGingerbreadDecoderEnabled = builder.mGingerbreadDecoderEnabled;
        this.mPieDecoderEnabled = builder.mPieDecoderEnabled;
        this.mQDecoderEnabled = builder.mQDecoderEnabled;
        this.mOomOptEnabled = builder.mOomOptEnabled;
        this.mIntermediateProgressUpdatesDisabled = builder.mIntermediateProgressUpdatesDisabled;
        this.mIntermediateProgressUpdatesForPrefetchDisabled = builder.mIntermediateProgressUpdatesForPrefetchDisabled;
    }

    public boolean getUseDownsamplingRatioForResizing() {
        return this.mUseDownsamplingRatioForResizing;
    }

    public boolean isWebpSupportEnabled() {
        return this.mWebpSupportEnabled;
    }

    public boolean isDecodeCancellationEnabled() {
        return this.mDecodeCancellationEnabled;
    }

    public WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger() {
        return this.mWebpErrorLogger;
    }

    public WebpBitmapFactory getWebpBitmapFactory() {
        return this.mWebpBitmapFactory;
    }

    public boolean getUseBitmapPrepareToDraw() {
        return this.mUseBitmapPrepareToDraw;
    }

    public int getBitmapPrepareToDrawMinSizeBytes() {
        return this.mBitmapPrepareToDrawMinSizeBytes;
    }

    public int getBitmapPrepareToDrawMaxSizeBytes() {
        return this.mBitmapPrepareToDrawMaxSizeBytes;
    }

    public boolean isNativeCodeDisabled() {
        return this.mNativeCodeDisabled;
    }

    public boolean isPartialImageCachingEnabled() {
        return this.mPartialImageCachingEnabled;
    }

    public ProducerFactoryMethod getProducerFactoryMethod() {
        return this.mProducerFactoryMethod;
    }

    public static Builder newBuilder(ImagePipelineConfig.Builder builder) {
        return new Builder(builder);
    }

    public boolean getBitmapPrepareToDrawForPrefetch() {
        return this.mBitmapPrepareToDrawForPrefetch;
    }

    public int getMaxBitmapSize() {
        return this.mMaxBitmapSize;
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.mLazyDataSource;
    }

    public boolean isGingerbreadDecoderEnabled() {
        return this.mGingerbreadDecoderEnabled;
    }

    public boolean isPieDecoderEnabled() {
        return this.mPieDecoderEnabled;
    }

    public boolean isQDecoderEnabled() {
        return this.mQDecoderEnabled;
    }

    public boolean isOomOptEnabled() {
        return this.mOomOptEnabled;
    }

    public boolean getIntermediateProgressUpdatesDisabled() {
        return this.mIntermediateProgressUpdatesDisabled;
    }

    public boolean getIntermediateProgressUpdatesForPrefetchDisabled() {
        return this.mIntermediateProgressUpdatesForPrefetchDisabled;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Builder {
        private final ImagePipelineConfig.Builder mConfigBuilder;
        public boolean mGingerbreadDecoderEnabled;
        public Supplier<Boolean> mLazyDataSource;
        public boolean mOomOptEnabled;
        public boolean mPieDecoderEnabled;
        private ProducerFactoryMethod mProducerFactoryMethod;
        public boolean mQDecoderEnabled;
        private WebpBitmapFactory mWebpBitmapFactory;
        private WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
        private boolean mWebpSupportEnabled = false;
        private boolean mDecodeCancellationEnabled = false;
        private boolean mUseDownsamplingRatioForResizing = false;
        private boolean mUseBitmapPrepareToDraw = FrescoOptUtil.isUseBitmapPrepareToDraw();
        private int mBitmapPrepareToDrawMinSizeBytes = 0;
        private int mBitmapPrepareToDrawMaxSizeBytes = 0;
        public boolean mBitmapPrepareToDrawForPrefetch = FrescoOptUtil.isBitmapPrepareToDrawForPrefetch();
        private int mMaxBitmapSize = (int) BitmapUtil.MAX_BITMAP_SIZE;
        private boolean mNativeCodeDisabled = false;
        private boolean mPartialImageCachingEnabled = false;
        private boolean mIntermediateProgressUpdatesDisabled = false;
        private boolean mIntermediateProgressUpdatesForPrefetchDisabled = false;

        public Builder(ImagePipelineConfig.Builder builder) {
            this.mConfigBuilder = builder;
        }

        public ImagePipelineConfig.Builder setWebpSupportEnabled(boolean z) {
            this.mWebpSupportEnabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setUseDownsampligRatioForResizing(boolean z) {
            this.mUseDownsamplingRatioForResizing = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setPartialImageCachingEnabled(boolean z) {
            this.mPartialImageCachingEnabled = z;
            return this.mConfigBuilder;
        }

        public boolean isPartialImageCachingEnabled() {
            return this.mPartialImageCachingEnabled;
        }

        public ImagePipelineConfig.Builder setDecodeCancellationEnabled(boolean z) {
            this.mDecodeCancellationEnabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            this.mWebpErrorLogger = webpErrorLogger;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory) {
            this.mWebpBitmapFactory = webpBitmapFactory;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setBitmapPrepareToDraw(boolean z, int i, int i2, boolean z2) {
            this.mUseBitmapPrepareToDraw = z;
            this.mBitmapPrepareToDrawMinSizeBytes = i;
            this.mBitmapPrepareToDrawMaxSizeBytes = i2;
            this.mBitmapPrepareToDrawForPrefetch = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setMaxBitmapSize(int i) {
            this.mMaxBitmapSize = i;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setNativeCodeDisabled(boolean z) {
            this.mNativeCodeDisabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setProducerFactoryMethod(ProducerFactoryMethod producerFactoryMethod) {
            this.mProducerFactoryMethod = producerFactoryMethod;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setLazyDataSource(Supplier<Boolean> supplier) {
            this.mLazyDataSource = supplier;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setGingerbreadDecoderEnabled(boolean z) {
            this.mGingerbreadDecoderEnabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setPieDecoderEnabled(boolean z) {
            this.mPieDecoderEnabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setQDecoderEnabled(boolean z) {
            this.mQDecoderEnabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setOomOptEnabled(boolean z) {
            this.mOomOptEnabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setIntermediateProgressUpdatesDisabled(boolean z) {
            this.mIntermediateProgressUpdatesDisabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setIntermediateProgressUpdatesForPrefetchDisabled(boolean z) {
            this.mIntermediateProgressUpdatesForPrefetchDisabled = z;
            return this.mConfigBuilder;
        }

        public ImagePipelineExperiments build() {
            return new ImagePipelineExperiments(this);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
        @Override // com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod
        public ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, Bitmap> memoryCache2, MemoryCache<CacheKey, PooledByteBuffer> memoryCache3, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, boolean z5) {
            return new ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, z, z2, z3, executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, memoryCache3, bufferedDiskCache, bufferedDiskCache2, hashMap, cacheKeyFactory, platformBitmapFactory, i, i2, z4, i3, z5);
        }
    }
}
