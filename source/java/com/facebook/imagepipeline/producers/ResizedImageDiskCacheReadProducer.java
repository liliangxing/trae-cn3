package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ResizedImageDiskCacheReadProducer extends DiskCacheReadProducer {
    public static final String PRODUCER_NAME = "ResizedDiskCacheReadProducer";

    public ResizedImageDiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer, PooledByteBufferFactory pooledByteBufferFactory) {
        super(bufferedDiskCache, bufferedDiskCache2, hashMap, cacheKeyFactory, producer, pooledByteBufferFactory);
    }

    @Override // com.facebook.imagepipeline.producers.DiskCacheReadProducer
    protected CacheKey getKey(CacheKeyFactory cacheKeyFactory, ProducerContext producerContext) {
        return cacheKeyFactory.getResizedImageCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
    }

    @Override // com.facebook.imagepipeline.producers.DiskCacheReadProducer
    protected boolean isCacheEnabled(ProducerContext producerContext) {
        return producerContext.getImageRequest().isResizedImageDiskCacheActuallyEnabled();
    }
}
