package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ResizedImageCacheKeyMultiplexProducer extends EncodedCacheKeyMultiplexProducer {
    private final CacheKeyFactory mCacheKeyFactory;

    public ResizedImageCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, Producer producer) {
        super(cacheKeyFactory, producer);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer, com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, String> getKey(ProducerContext producerContext) {
        return Pair.create(this.mCacheKeyFactory.getResizedImageCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), buildSecondOfPair(producerContext));
    }

    private String buildSecondOfPair(ProducerContext producerContext) {
        if (!producerContext.getImageRequest().isMultiplexerEnabled()) {
            return producerContext.getId();
        }
        return String.valueOf(producerContext.getLowestPermittedRequestLevel().getValue());
    }
}
