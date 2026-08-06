package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, String>, EncodedImage> {
    private final CacheKeyFactory mCacheKeyFactory;

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, Producer producer) {
        super(producer);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, String> getKey(ProducerContext producerContext) {
        return Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), buildSecondOfPair(producerContext));
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public EncodedImage cloneOrNull(EncodedImage encodedImage) {
        return EncodedImage.cloneOrNull(encodedImage);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public ImageFormat getImageFormat(EncodedImage encodedImage) {
        if (encodedImage != null) {
            return encodedImage.getImageFormat();
        }
        return null;
    }

    private String buildSecondOfPair(ProducerContext producerContext) {
        if (!producerContext.getImageRequest().isMultiplexerEnabled()) {
            return producerContext.getId();
        }
        return String.valueOf(producerContext.getLowestPermittedRequestLevel().getValue());
    }
}
