package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<EncodedImage> mInputProducer;
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        int i;
        int i2;
        boolean isTracing;
        SizeDeterminer sizeDeterminer;
        Pair<Integer, Integer> size;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");
            }
            String id = producerContext.getId();
            ProducerListener listener = producerContext.getListener();
            listener.onProducerStart(id, PRODUCER_NAME);
            ImageRequest imageRequest = producerContext.getImageRequest();
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
            if (imageRequest == null || (sizeDeterminer = imageRequest.getSizeDeterminer()) == null || sizeDeterminer.getSize() == null || (size = sizeDeterminer.getSize()) == null) {
                i = 0;
                i2 = 0;
            } else {
                i2 = ((Integer) size.first).intValue();
                i = ((Integer) size.second).intValue();
            }
            CloseableReference<PooledByteBuffer> closeableReference = this.mMemoryCache.get(encodedCacheKey);
            try {
                if (closeableReference != null) {
                    EncodedImage encodedImage = new EncodedImage(closeableReference);
                    if (imageRequest != null && imageRequest.getSourceUri() != null) {
                        encodedImage.setUri(imageRequest.getSourceUri().toString());
                    }
                    encodedImage.setViewWidth(i2);
                    encodedImage.setViewHeight(i);
                    try {
                        listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, listener.requiresExtraMap(id) ? ImmutableMap.m414of("cached_value_found", "true") : null);
                        listener.onUltimateProducerReached(id, PRODUCER_NAME, true);
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(encodedImage, 1);
                        if (isTracing) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        EncodedImage.closeSafely(encodedImage);
                    }
                }
                if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                    listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, listener.requiresExtraMap(id) ? ImmutableMap.m414of("cached_value_found", "false") : null);
                    listener.onUltimateProducerReached(id, PRODUCER_NAME, false);
                    consumer.onNewResult(null, 1);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                        return;
                    }
                    return;
                }
                EncodedMemoryCacheConsumer encodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(consumer, this.mMemoryCache, encodedCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled());
                listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, listener.requiresExtraMap(id) ? ImmutableMap.m414of("cached_value_found", "false") : null);
                this.mInputProducer.produceResults(encodedMemoryCacheConsumer, producerContext);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } finally {
                CloseableReference.closeSafely(closeableReference);
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final boolean mIsMemoryCacheEnabled;
        private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
        private final CacheKey mRequestedCacheKey;

        public EncodedMemoryCacheConsumer(Consumer<EncodedImage> consumer, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z) {
            super(consumer);
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsMemoryCacheEnabled = z;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            boolean isTracing;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");
                }
                if (!isNotLast(i) && encodedImage != null && !statusHasAnyFlag(i, 10) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                    CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
                    if (byteBufferRef != null) {
                        try {
                            CloseableReference<PooledByteBuffer> cache = this.mIsMemoryCacheEnabled ? this.mMemoryCache.cache(this.mRequestedCacheKey, byteBufferRef) : null;
                            if (cache != null) {
                                try {
                                    EncodedImage encodedImage2 = new EncodedImage(cache);
                                    encodedImage2.copyMetaDataFrom(encodedImage);
                                    try {
                                        getConsumer().onProgressUpdate(1.0f);
                                        getConsumer().onNewResult(encodedImage2, i);
                                        if (FrescoSystrace.isTracing()) {
                                            FrescoSystrace.endSection();
                                            return;
                                        }
                                        return;
                                    } finally {
                                        EncodedImage.closeSafely(encodedImage2);
                                    }
                                } finally {
                                    CloseableReference.closeSafely(cache);
                                }
                            }
                        } finally {
                            CloseableReference.closeSafely(byteBufferRef);
                        }
                    }
                    getConsumer().onNewResult(encodedImage, i);
                    if (isTracing) {
                        return;
                    } else {
                        return;
                    }
                }
                getConsumer().onNewResult(encodedImage, i);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }
}
