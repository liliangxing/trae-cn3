package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, String>, CloseableReference<CloseableImage>> {
    private final CacheKeyFactory mCacheKeyFactory;

    public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, Producer producer) {
        super(producer);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, String> getKey(ProducerContext producerContext) {
        return Pair.create(this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), buildSecondOfPair(producerContext));
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public CloseableReference<CloseableImage> cloneOrNull(CloseableReference<CloseableImage> closeableReference) {
        return CloseableReference.cloneOrNull(closeableReference);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public CloseableReference<CloseableImage> cloneResultOrNull(CloseableReference<CloseableImage> closeableReference) {
        if (closeableReference == null || closeableReference.get() == null) {
            return null;
        }
        return CloseableReference.m496of(closeableReference.get().cloneOrNull());
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public ImageFormat getImageFormat(CloseableReference<CloseableImage> closeableReference) {
        if (closeableReference == null || closeableReference.get() == null) {
            return null;
        }
        return closeableReference.get().getImageFormat();
    }

    private String buildSecondOfPair(ProducerContext producerContext) {
        if (!producerContext.getImageRequest().isMultiplexerEnabled()) {
            return producerContext.getId();
        }
        return String.valueOf(producerContext.getLowestPermittedRequestLevel().getValue());
    }
}
