package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DiskCacheWriteProducer implements Producer<EncodedImage> {
    public static final String PRODUCER_NAME = "DiskCacheWriteProducer";
    private static final String TAG = "DiskCacheWriteProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheWriteProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer, PooledByteBufferFactory pooledByteBufferFactory) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCustomImageBufferedDiskCacheMap = hashMap;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        maybeStartInputProducer(consumer, producerContext);
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(new DiskCacheWriteConsumer(consumer, producerContext, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCustomImageBufferedDiskCacheMap, this.mCacheKeyFactory, producerContext.getImageRequest().isDiskCacheEnabled(), this.mPooledByteBufferFactory), producerContext);
        }
    }

    static Map<String, String> getExtraMap(ProducerListener producerListener, String str, String str2) {
        if (producerListener.requiresExtraMap(str)) {
            return ImmutableMap.m414of("imageType", str2);
        }
        return null;
    }

    static Map<String, String> getExtraMap(ProducerListener producerListener, String str, String str2, String str3) {
        if (producerListener.requiresExtraMap(str)) {
            return ImmutableMap.m415of("imageType", str2, "encodedImageSize", str3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class DiskCacheWriteConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final boolean isCache;
        private final CacheKeyFactory mCacheKeyFactory;
        private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
        private final BufferedDiskCache mDefaultBufferedDiskCache;
        private String mImageType;
        private final PooledByteBufferFactory mPooledByteBufferFactory;
        private final ProducerContext mProducerContext;
        private final BufferedDiskCache mSmallImageBufferedDiskCache;

        private DiskCacheWriteConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, boolean z, PooledByteBufferFactory pooledByteBufferFactory) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
            this.mCustomImageBufferedDiskCacheMap = hashMap;
            this.mCacheKeyFactory = cacheKeyFactory;
            this.isCache = z;
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
        }

        private DiskCacheWriteConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory) {
            this(consumer, producerContext, bufferedDiskCache, bufferedDiskCache2, hashMap, cacheKeyFactory, true, pooledByteBufferFactory);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (isNotLast(i) || encodedImage == null || statusHasAnyFlag(i, 10)) {
                getConsumer().onNewResult(encodedImage, i);
                return;
            }
            String id = this.mProducerContext.getId();
            this.mProducerContext.getListener().onProducerStart(id, "DiskCacheWriteProducer");
            EncodedImage decryptEncodeImage = getDecryptEncodeImage(encodedImage);
            try {
                this.mImageType = decryptEncodeImage.getImageFormat().getName();
                if (decryptEncodeImage.getImageFormat() == ImageFormat.UNKNOWN) {
                    getConsumer().onNewResult(decryptEncodeImage, i);
                    return;
                }
                if (!this.isCache) {
                    this.mProducerContext.getListener().onProducerFinishWithSuccess(id, "DiskCacheWriteProducer", DiskCacheWriteProducer.getExtraMap(this.mProducerContext.getListener(), id, getImageType(), decryptEncodeImage != null ? decryptEncodeImage.getWidth() + "x" + decryptEncodeImage.getHeight() : ""));
                    getConsumer().onNewResult(decryptEncodeImage, i);
                    return;
                }
                ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, this.mProducerContext.getCallerContext());
                if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
                    this.mSmallImageBufferedDiskCache.put(encodedCacheKey, encodedImage);
                } else if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.CUSTOM) {
                    BufferedDiskCache bufferedDiskCache = this.mCustomImageBufferedDiskCacheMap.get(imageRequest.getCustomCacheName());
                    if (bufferedDiskCache != null) {
                        bufferedDiskCache.put(encodedCacheKey, encodedImage);
                    }
                } else {
                    this.mDefaultBufferedDiskCache.put(encodedCacheKey, encodedImage);
                }
                this.mProducerContext.getListener().onProducerFinishWithSuccess(id, "DiskCacheWriteProducer", DiskCacheWriteProducer.getExtraMap(this.mProducerContext.getListener(), id, getImageType(), decryptEncodeImage != null ? decryptEncodeImage.getWidth() + "x" + decryptEncodeImage.getHeight() : ""));
                getConsumer().onNewResult(decryptEncodeImage, i);
            } finally {
                EncodedImage.closeSafely(decryptEncodeImage);
            }
        }

        public String getImageType() {
            return this.mImageType;
        }

        private EncodedImage getDecryptEncodeImage(EncodedImage encodedImage) {
            byte[] decrypt = ((ForwardingRequestListener) this.mProducerContext.getListener()).decrypt(encodedImage.getInputStream());
            if (decrypt != null && decrypt.length > 0) {
                PooledByteBufferOutputStream newOutputStream = this.mPooledByteBufferFactory.newOutputStream(decrypt.length);
                CloseableReference closeableReference = null;
                try {
                    newOutputStream.write(decrypt, 0, decrypt.length);
                    closeableReference = CloseableReference.m496of(newOutputStream.toByteBuffer());
                    EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) closeableReference);
                    encodedImage2.copyMetaDataFrom(encodedImage);
                    encodedImage2.parseMetaData();
                    return encodedImage2;
                } catch (IOException e) {
                    FLog.m443e("DiskCacheWriteProducer", "Construct decrypted data error", e);
                } finally {
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                }
            }
            return encodedImage;
        }
    }
}
