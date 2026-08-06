package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TTDiskCacheWriteProducer extends DiskCacheWriteProducer {
    static final String PRODUCER_NAME = "DiskCacheProducer";
    private final Producer<EncodedImage> mInputProducer;

    public TTDiskCacheWriteProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer, PooledByteBufferFactory pooledByteBufferFactory) {
        super(bufferedDiskCache, bufferedDiskCache2, hashMap, cacheKeyFactory, producer, pooledByteBufferFactory);
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.DiskCacheWriteProducer, com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(consumer, producerContext);
    }
}
