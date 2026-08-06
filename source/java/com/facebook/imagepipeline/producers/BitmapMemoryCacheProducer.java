package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapCacheUtil;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    private final MemoryCache<CacheKey, CloseableImage> mBigImgMemoryCache;
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mPrefetchImgMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mSingleMemoryCache;
    private boolean isSrPost = false;
    private boolean isPrefetch = false;
    private boolean isFallBackToMainMemory = false;

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mSingleMemoryCache = (ImagePipelineFactory.getInstance().isEnableSingleCache() || ImagePipelineConfig.getInstance().isEnableSingleMemCache()) ? ImagePipelineFactory.getInstance().getSingleBitmapMemoryCache() : null;
        this.mBigImgMemoryCache = (ImagePipelineFactory.getInstance().isEnableBigImgCache() || ImagePipelineConfig.getInstance().isEnableBigImgCache()) ? ImagePipelineFactory.getInstance().getBigImgBitmapMemoryCache() : null;
        this.mPrefetchImgMemoryCache = (ImagePipelineFactory.getInstance().isSplitPrefetchCache() || ImagePipelineConfig.getInstance().isEnablePrefetchImgCache()) ? ImagePipelineFactory.getInstance().getPrefetchImgBitmapMemoryCache() : null;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        MemoryCache<CacheKey, CloseableImage> memoryCache;
        boolean isTracing;
        MemoryCache<CacheKey, CloseableImage> memoryCache2;
        MemoryCache<CacheKey, CloseableImage> memoryCache3;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");
            }
            ProducerListener listener = producerContext.getListener();
            String id = producerContext.getId();
            listener.onProducerStart(id, getProducerName());
            ImageRequest imageRequest = producerContext.getImageRequest();
            Object callerContext = producerContext.getCallerContext();
            this.isPrefetch = producerContext.getImageRequest() != null && producerContext.getImageRequest().isOptPrefetch();
            this.isFallBackToMainMemory = producerContext.getImageRequest() != null && producerContext.getImageRequest().isFallBackToMainMemory();
            if (imageRequest.getPostprocessor() != null) {
                this.isSrPost = "SRPostProcessor".equalsIgnoreCase(imageRequest.getPostprocessor().getName());
            } else {
                this.isSrPost = false;
            }
            CacheKey reuseOptCacheKey = BitmapMemoryCacheKey.getReuseOptCacheKey(this.mCacheKeyFactory.getBitmapCacheKey(imageRequest, callerContext));
            CloseableReference<CloseableImage> closeableReference = ((ImagePipelineFactory.getInstance().isEnableBigImgCache() || ImagePipelineConfig.getInstance().isEnableBigImgCache()) && (memoryCache = this.mBigImgMemoryCache) != null) ? memoryCache.get(reuseOptCacheKey) : null;
            if (closeableReference == null && ((ImagePipelineFactory.getInstance().isEnableSingleCache() || ImagePipelineConfig.getInstance().isEnableSingleMemCache()) && (memoryCache3 = this.mSingleMemoryCache) != null)) {
                closeableReference = memoryCache3.get(reuseOptCacheKey);
            }
            if (closeableReference == null) {
                closeableReference = this.mMemoryCache.get(reuseOptCacheKey);
            }
            if (closeableReference == null && ((ImagePipelineFactory.getInstance().isSplitPrefetchCache() || ImagePipelineConfig.getInstance().isEnablePrefetchImgCache()) && (memoryCache2 = this.mPrefetchImgMemoryCache) != null)) {
                closeableReference = memoryCache2.get(reuseOptCacheKey);
            }
            if (closeableReference != null) {
                boolean z = closeableReference.get().getQualityInfo().isOfFullQuality() && !closeableReference.get().isThumbCache();
                if (z) {
                    listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.m414of("cached_value_found", "true") : null);
                    listener.onUltimateProducerReached(id, getProducerName(), true);
                    consumer.onProgressUpdate(1.0f);
                }
                consumer.onNewResult(closeableReference, BaseConsumer.simpleStatusForIsLast(z));
                closeableReference.close();
                if (z) {
                    if (isTracing) {
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
                listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.m414of("cached_value_found", "false") : null);
                listener.onUltimateProducerReached(id, getProducerName(), false);
                consumer.onNewResult(null, 1);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            Consumer<CloseableReference<CloseableImage>> wrapConsumer = wrapConsumer(consumer, reuseOptCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled(), producerContext.getCallerContext());
            listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.m414of("cached_value_found", "false") : null);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.mInputProducer.produceResults(wrapConsumer, producerContext);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, final CacheKey cacheKey, final boolean z, final Object obj) {
        return new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(consumer) { // from class: com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
                boolean isTracing;
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("BitmapMemoryCacheProducer#onNewResultImpl");
                    }
                    boolean isLast = isLast(i);
                    CloseableReference<CloseableImage> closeableReference2 = null;
                    if (closeableReference == null) {
                        if (isLast) {
                            getConsumer().onNewResult(null, i);
                        }
                        if (isTracing) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (!closeableReference.get().isStateful() && !statusHasFlag(i, 8)) {
                        if (!isLast) {
                            CacheKey reuseOptCacheKey = BitmapMemoryCacheKey.getReuseOptCacheKey(cacheKey);
                            CloseableReference<CloseableImage> closeableReference3 = ((ImagePipelineFactory.getInstance().isEnableBigImgCache() || ImagePipelineConfig.getInstance().isEnableBigImgCache()) && BitmapMemoryCacheProducer.this.mBigImgMemoryCache != null) ? BitmapMemoryCacheProducer.this.mBigImgMemoryCache.get(reuseOptCacheKey) : null;
                            if (closeableReference3 == null && ((ImagePipelineFactory.getInstance().isEnableSingleCache() || ImagePipelineConfig.getInstance().isEnableSingleMemCache()) && BitmapMemoryCacheProducer.this.mSingleMemoryCache != null)) {
                                closeableReference3 = BitmapMemoryCacheProducer.this.mSingleMemoryCache.get(reuseOptCacheKey);
                            }
                            if (closeableReference3 == null) {
                                closeableReference3 = BitmapMemoryCacheProducer.this.mMemoryCache.get(reuseOptCacheKey);
                            }
                            if (closeableReference3 == null && ((ImagePipelineFactory.getInstance().isSplitPrefetchCache() || ImagePipelineConfig.getInstance().isEnablePrefetchImgCache()) && BitmapMemoryCacheProducer.this.mPrefetchImgMemoryCache != null)) {
                                closeableReference3 = BitmapMemoryCacheProducer.this.mPrefetchImgMemoryCache.get(reuseOptCacheKey);
                            }
                            if (closeableReference3 != null) {
                                try {
                                    QualityInfo qualityInfo = closeableReference.get().getQualityInfo();
                                    QualityInfo qualityInfo2 = closeableReference3.get().getQualityInfo();
                                    if (qualityInfo2.isOfFullQuality() || qualityInfo2.getQuality() >= qualityInfo.getQuality()) {
                                        getConsumer().onNewResult(closeableReference3, i);
                                        if (FrescoSystrace.isTracing()) {
                                            FrescoSystrace.endSection();
                                            return;
                                        }
                                        return;
                                    }
                                } finally {
                                    CloseableReference.closeSafely(closeableReference3);
                                }
                            }
                        }
                        if (z && (!BitmapMemoryCacheProducer.this.isSrPost || FrescoCacheMonitorUtil.isSavePrePostBitmap())) {
                            BitmapCacheUtil.insertReuseBitmapCacheMap(cacheKey);
                            if (!BitmapMemoryCacheProducer.this.isPrefetch || (!(ImagePipelineFactory.getInstance().isSplitPrefetchCache() || ImagePipelineConfig.getInstance().isEnablePrefetchImgCache()) || BitmapMemoryCacheProducer.this.mPrefetchImgMemoryCache == null)) {
                                List<String> currentSceneTags = FrescoCacheMonitorUtil.getCurrentSceneTags();
                                boolean z2 = false;
                                if (currentSceneTags != null) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 < currentSceneTags.size()) {
                                            if (currentSceneTags.get(i2) != null && currentSceneTags.get(i2).equals(obj)) {
                                                z2 = true;
                                                break;
                                            }
                                            i2++;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                if ((ImagePipelineFactory.getInstance().isEnableSingleCache() || ImagePipelineConfig.getInstance().isEnableSingleMemCache()) && z2 && closeableReference.get() != null && BitmapMemoryCacheProducer.this.mSingleMemoryCache != null) {
                                    closeableReference2 = BitmapMemoryCacheProducer.this.mSingleMemoryCache.cache(cacheKey, closeableReference);
                                    if (closeableReference2 == null && BitmapMemoryCacheProducer.this.isFallBackToMainMemory) {
                                        closeableReference2 = BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference);
                                    }
                                } else if ((ImagePipelineFactory.getInstance().isEnableBigImgCache() || ImagePipelineConfig.getInstance().isEnableBigImgCache()) && closeableReference.get() != null && closeableReference.get().getSizeInBytes() > ImagePipelineFactory.getInstance().getBigImgSizeLimit() && BitmapMemoryCacheProducer.this.mBigImgMemoryCache != null) {
                                    closeableReference2 = BitmapMemoryCacheProducer.this.mBigImgMemoryCache.cache(cacheKey, closeableReference);
                                    if (closeableReference2 == null && BitmapMemoryCacheProducer.this.isFallBackToMainMemory) {
                                        closeableReference2 = BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference);
                                    }
                                } else {
                                    closeableReference2 = BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference);
                                }
                            } else {
                                closeableReference2 = BitmapMemoryCacheProducer.this.mPrefetchImgMemoryCache.cache(cacheKey, closeableReference);
                            }
                        }
                        if (isLast) {
                            try {
                                getConsumer().onProgressUpdate(1.0f);
                            } finally {
                                CloseableReference.closeSafely(closeableReference2);
                            }
                        }
                        Consumer<CloseableReference<CloseableImage>> consumer2 = getConsumer();
                        if (closeableReference2 != null) {
                            closeableReference = closeableReference2;
                        }
                        consumer2.onNewResult(closeableReference, i);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                    getConsumer().onNewResult(closeableReference, i);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }
        };
    }
}
