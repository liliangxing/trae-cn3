package com.facebook.imagepipeline.producers;

import android.util.Pair;
import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "DiskCacheProducer";
    private static final String TAG = "DiskCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer, PooledByteBufferFactory pooledByteBufferFactory) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCustomImageBufferedDiskCacheMap = hashMap;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!isCacheEnabled(producerContext)) {
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        producerContext.getListener().onProducerStart(producerContext.getId(), "DiskCacheProducer");
        CacheKey key = getKey(this.mCacheKeyFactory, producerContext);
        boolean z = imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL;
        BufferedDiskCache bufferedDiskCache = imageRequest.getCacheChoice() == ImageRequest.CacheChoice.CUSTOM ? this.mCustomImageBufferedDiskCacheMap.get(imageRequest.getCustomCacheName()) : null;
        if (bufferedDiskCache == null) {
            bufferedDiskCache = z ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCache.get(key, atomicBoolean).continueWith(onFinishDiskReads(consumer, producerContext));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }

    protected CacheKey getKey(CacheKeyFactory cacheKeyFactory, ProducerContext producerContext) {
        return cacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
    }

    protected boolean isCacheEnabled(ProducerContext producerContext) {
        return producerContext.getImageRequest().isDiskCacheEnabled();
    }

    private Continuation<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> consumer, final ProducerContext producerContext) {
        final String id = producerContext.getId();
        final ProducerListener listener = producerContext.getListener();
        return new Continuation<EncodedImage, Void>() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m2688then((Task<EncodedImage>) task);
            }

            /* renamed from: then, reason: collision with other method in class */
            public Void m2688then(Task<EncodedImage> task) throws Exception {
                int i;
                if (DiskCacheReadProducer.isTaskCancelled(task)) {
                    listener.onProducerFinishWithCancellation(id, "DiskCacheProducer", null);
                    consumer.onCancellation();
                } else if (task.isFaulted()) {
                    listener.onProducerFinishWithFailure(id, "DiskCacheProducer", task.getError(), null);
                    DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                } else {
                    EncodedImage encodedImage = (EncodedImage) task.getResult();
                    int i2 = 0;
                    if (encodedImage != null) {
                        if (producerContext.getImageRequest() != null) {
                            encodedImage.setUri(producerContext.getImageRequest().getSourceUri() != null ? producerContext.getImageRequest().getSourceUri().toString() : "");
                            SizeDeterminer sizeDeterminer = producerContext.getImageRequest().getSizeDeterminer();
                            if (sizeDeterminer != null && sizeDeterminer.getSize() != null) {
                                Pair<Integer, Integer> size = sizeDeterminer.getSize();
                                int intValue = ((Integer) size.first).intValue();
                                i = ((Integer) size.second).intValue();
                                i2 = intValue;
                                encodedImage.setViewWidth(i2);
                                encodedImage.setViewHeight(i);
                                EncodedImage decryptEncodeImage = getDecryptEncodeImage(encodedImage, producerContext);
                                decryptEncodeImage.hitDisCache();
                                ProducerListener producerListener = listener;
                                String str = id;
                                producerListener.onProducerFinishWithSuccess(str, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener, str, true, decryptEncodeImage.getSize()));
                                listener.onUltimateProducerReached(id, "DiskCacheProducer", true);
                                consumer.onProgressUpdate(1.0f);
                                consumer.onNewResult(decryptEncodeImage, 1);
                                encodedImage.close();
                                decryptEncodeImage.close();
                            }
                        }
                        i = 0;
                        encodedImage.setViewWidth(i2);
                        encodedImage.setViewHeight(i);
                        EncodedImage decryptEncodeImage2 = getDecryptEncodeImage(encodedImage, producerContext);
                        decryptEncodeImage2.hitDisCache();
                        ProducerListener producerListener2 = listener;
                        String str2 = id;
                        producerListener2.onProducerFinishWithSuccess(str2, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener2, str2, true, decryptEncodeImage2.getSize()));
                        listener.onUltimateProducerReached(id, "DiskCacheProducer", true);
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(decryptEncodeImage2, 1);
                        encodedImage.close();
                        decryptEncodeImage2.close();
                    } else {
                        ProducerListener producerListener3 = listener;
                        String str3 = id;
                        producerListener3.onProducerFinishWithSuccess(str3, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener3, str3, false, 0));
                        DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                    }
                }
                return null;
            }

            private EncodedImage getDecryptEncodeImage(EncodedImage encodedImage, ProducerContext producerContext2) {
                byte[] decrypt = ((ForwardingRequestListener) producerContext2.getListener()).decrypt(encodedImage.getInputStream());
                if (decrypt != null && decrypt.length > 0) {
                    PooledByteBufferOutputStream newOutputStream = DiskCacheReadProducer.this.mPooledByteBufferFactory.newOutputStream(decrypt.length);
                    CloseableReference closeableReference = null;
                    try {
                        newOutputStream.write(decrypt, 0, decrypt.length);
                        closeableReference = CloseableReference.m496of(newOutputStream.toByteBuffer());
                        EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) closeableReference);
                        encodedImage2.copyMetaDataFrom(encodedImage);
                        encodedImage2.parseMetaData();
                        return encodedImage2;
                    } catch (IOException e) {
                        FLog.m443e("DiskCacheProducer", "Construct decrypted data error", e);
                    } finally {
                        CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    }
                }
                return encodedImage;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTaskCancelled(Task<?> task) {
        return task.isCancelled() || (task.isFaulted() && (task.getError() instanceof CancellationException));
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getExtraMap(ProducerListener producerListener, String str, boolean z, int i) {
        if (!producerListener.requiresExtraMap(str)) {
            return null;
        }
        if (z) {
            return ImmutableMap.m415of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.m414of("cached_value_found", String.valueOf(z));
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }
}
