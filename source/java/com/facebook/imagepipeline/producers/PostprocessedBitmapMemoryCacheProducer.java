package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
    static final String VALUE_FOUND = "cached_value_found";
    private boolean isPrefetch = false;
    private final MemoryCache<CacheKey, CloseableImage> mBigImgMemoryCache;
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mPrefetchImgMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mSingleMemoryCache;

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mSingleMemoryCache = (ImagePipelineFactory.getInstance().isEnableSingleCache() || ImagePipelineConfig.getInstance().isEnableSingleMemCache()) ? ImagePipelineFactory.getInstance().getSingleBitmapMemoryCache() : null;
        this.mBigImgMemoryCache = ImagePipelineFactory.getInstance().isEnableBigImgCache() ? ImagePipelineFactory.getInstance().getBigImgBitmapMemoryCache() : null;
        this.mPrefetchImgMemoryCache = ImagePipelineFactory.getInstance().isSplitPrefetchCache() ? ImagePipelineFactory.getInstance().getPrefetchImgBitmapMemoryCache() : null;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        MemoryCache<CacheKey, CloseableImage> memoryCache;
        MemoryCache<CacheKey, CloseableImage> memoryCache2;
        MemoryCache<CacheKey, CloseableImage> memoryCache3;
        ProducerListener listener = producerContext.getListener();
        String id = producerContext.getId();
        ImageRequest imageRequest = producerContext.getImageRequest();
        Object callerContext = producerContext.getCallerContext();
        this.isPrefetch = producerContext.getImageRequest() != null && producerContext.getImageRequest().isOptPrefetch();
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor == null || postprocessor.getPostprocessorCacheKey() == null) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        listener.onProducerStart(id, getProducerName());
        CacheKey postprocessedBitmapCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
        CloseableReference<CloseableImage> closeableReference = (!ImagePipelineFactory.getInstance().isEnableSingleCache() || (memoryCache3 = this.mSingleMemoryCache) == null) ? null : memoryCache3.get(postprocessedBitmapCacheKey);
        if (closeableReference == null && ImagePipelineFactory.getInstance().isEnableBigImgCache() && (memoryCache2 = this.mBigImgMemoryCache) != null) {
            closeableReference = memoryCache2.get(postprocessedBitmapCacheKey);
        }
        if (closeableReference == null) {
            closeableReference = this.mMemoryCache.get(postprocessedBitmapCacheKey);
        }
        if (closeableReference == null && ImagePipelineFactory.getInstance().isSplitPrefetchCache() && (memoryCache = this.mPrefetchImgMemoryCache) != null) {
            closeableReference = memoryCache.get(postprocessedBitmapCacheKey);
        }
        if (closeableReference != null) {
            listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.m414of("cached_value_found", "true") : null);
            listener.onUltimateProducerReached(id, PRODUCER_NAME, true);
            consumer.onProgressUpdate(1.0f);
            consumer.onNewResult(closeableReference, 1);
            closeableReference.close();
            return;
        }
        CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer, postprocessedBitmapCacheKey, postprocessor instanceof RepeatedPostprocessor, this.mMemoryCache, producerContext.getImageRequest().isMemoryCacheEnabled() && (!"SRPostProcessor".equalsIgnoreCase(postprocessor.getName()) || FrescoCacheMonitorUtil.isSaveAfterPostBitmap()), this.isPrefetch, callerContext);
        listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.m414of("cached_value_found", "false") : null);
        this.mInputProducer.produceResults(cachedPostprocessorConsumer, producerContext);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private final Object callerContext;
        private final MemoryCache<CacheKey, CloseableImage> mBigImgMemoryCache;
        private final CacheKey mCacheKey;
        private final boolean mIsMemoryCachedEnabled;
        private final boolean mIsPrefetch;
        private final boolean mIsRepeatedProcessor;
        private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
        private final MemoryCache<CacheKey, CloseableImage> mPrefetchImgMemoryCache;
        private final MemoryCache<CacheKey, CloseableImage> mSingleMemoryCache;

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z2) {
            this(consumer, cacheKey, z, memoryCache, z2, false, null);
        }

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z2, boolean z3) {
            this(consumer, cacheKey, z, memoryCache, z2, z3, null);
        }

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z2, boolean z3, Object obj) {
            super(consumer);
            this.mCacheKey = cacheKey;
            this.mIsRepeatedProcessor = z;
            this.mMemoryCache = memoryCache;
            this.mSingleMemoryCache = (ImagePipelineFactory.getInstance().isEnableSingleCache() || ImagePipelineConfig.getInstance().isEnableSingleMemCache()) ? ImagePipelineFactory.getInstance().getSingleBitmapMemoryCache() : null;
            this.mBigImgMemoryCache = ImagePipelineFactory.getInstance().isEnableBigImgCache() ? ImagePipelineFactory.getInstance().getBigImgBitmapMemoryCache() : null;
            this.mPrefetchImgMemoryCache = ImagePipelineFactory.getInstance().isSplitPrefetchCache() ? ImagePipelineFactory.getInstance().getPrefetchImgBitmapMemoryCache() : null;
            this.mIsMemoryCachedEnabled = z2;
            this.mIsPrefetch = z3;
            this.callerContext = obj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            MemoryCache<CacheKey, CloseableImage> memoryCache;
            CloseableReference<CloseableImage> closeableReference2 = null;
            if (closeableReference == null) {
                if (isLast(i)) {
                    getConsumer().onNewResult(null, i);
                    return;
                }
                return;
            }
            if (!isNotLast(i) || this.mIsRepeatedProcessor) {
                if (this.mIsMemoryCachedEnabled) {
                    if (this.mIsPrefetch && ImagePipelineFactory.getInstance().isSplitPrefetchCache() && (memoryCache = this.mPrefetchImgMemoryCache) != null) {
                        closeableReference2 = memoryCache.cache(this.mCacheKey, closeableReference);
                    } else {
                        List<String> currentSceneTags = FrescoCacheMonitorUtil.getCurrentSceneTags();
                        boolean z = false;
                        if (currentSceneTags != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < currentSceneTags.size()) {
                                    if (currentSceneTags.get(i2) != null && currentSceneTags.get(i2).equals(this.callerContext)) {
                                        z = true;
                                        break;
                                    }
                                    i2++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (ImagePipelineFactory.getInstance().isEnableSingleCache() && z && closeableReference.get() != null) {
                            closeableReference2 = this.mSingleMemoryCache.cache(this.mCacheKey, closeableReference);
                        } else if (ImagePipelineFactory.getInstance().isEnableBigImgCache() && closeableReference.get() != null && closeableReference.get().getSizeInBytes() > ImagePipelineFactory.getInstance().getBigImgSizeLimit()) {
                            closeableReference2 = this.mBigImgMemoryCache.cache(this.mCacheKey, closeableReference);
                        } else {
                            closeableReference2 = this.mMemoryCache.cache(this.mCacheKey, closeableReference);
                        }
                    }
                }
                try {
                    getConsumer().onProgressUpdate(1.0f);
                    Consumer<CloseableReference<CloseableImage>> consumer = getConsumer();
                    if (closeableReference2 != null) {
                        closeableReference = closeableReference2;
                    }
                    consumer.onNewResult(closeableReference, i);
                } finally {
                    CloseableReference.closeSafely(closeableReference2);
                }
            }
        }
    }
}
