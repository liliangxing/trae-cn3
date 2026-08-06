package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.TTBufferedDiskCache;
import com.facebook.cache.disk.TempEncodedImage;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TTDiskCacheProducer extends DiskCacheReadProducer {
    private final CacheKeyFactory mCacheKeyFactory;
    private final boolean mChooseCacheByImageSize;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final int mForceSmallCacheThresholdBytes;
    private final Producer<EncodedImage> mInputProducer;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public TTDiskCacheProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer, int i, PooledByteBufferFactory pooledByteBufferFactory) {
        super(bufferedDiskCache, bufferedDiskCache2, hashMap, cacheKeyFactory, producer, pooledByteBufferFactory);
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
        this.mForceSmallCacheThresholdBytes = i;
        this.mChooseCacheByImageSize = i > 0;
    }

    @Override // com.facebook.imagepipeline.producers.DiskCacheReadProducer, com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Task<EncodedImage> task;
        BufferedDiskCache bufferedDiskCache;
        final BufferedDiskCache bufferedDiskCache2;
        Task<EncodedImage> task2;
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!imageRequest.isDiskCacheEnabled()) {
            maybeStartInputProducer(consumer, consumer, producerContext);
            return;
        }
        producerContext.getListener().onProducerStart(producerContext.getId(), DiskCacheReadProducer.PRODUCER_NAME);
        final CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
        BufferedDiskCache bufferedDiskCache3 = imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (this.mChooseCacheByImageSize) {
            boolean containsSync = this.mSmallImageBufferedDiskCache.containsSync(encodedCacheKey);
            boolean containsSync2 = this.mDefaultBufferedDiskCache.containsSync(encodedCacheKey);
            if (containsSync || !containsSync2) {
                bufferedDiskCache = this.mSmallImageBufferedDiskCache;
                bufferedDiskCache2 = this.mDefaultBufferedDiskCache;
            } else {
                bufferedDiskCache = this.mDefaultBufferedDiskCache;
                bufferedDiskCache2 = this.mSmallImageBufferedDiskCache;
            }
            if (bufferedDiskCache instanceof TTBufferedDiskCache) {
                task2 = ((TTBufferedDiskCache) bufferedDiskCache).get(encodedCacheKey, atomicBoolean, false);
            } else {
                task2 = bufferedDiskCache.get(encodedCacheKey, atomicBoolean);
            }
            task = task2.continueWithTask(new Continuation<EncodedImage, Task<EncodedImage>>() { // from class: com.facebook.imagepipeline.producers.TTDiskCacheProducer.1
                /* renamed from: then, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2690then(Task task3) throws Exception {
                    return then((Task<EncodedImage>) task3);
                }

                public Task<EncodedImage> then(Task<EncodedImage> task3) throws Exception {
                    if (TTDiskCacheProducer.isTaskCancelled(task3)) {
                        return task3;
                    }
                    if (!task3.isFaulted() && task3.getResult() != null) {
                        return task3;
                    }
                    BufferedDiskCache bufferedDiskCache4 = bufferedDiskCache2;
                    if (bufferedDiskCache4 instanceof TTBufferedDiskCache) {
                        return ((TTBufferedDiskCache) bufferedDiskCache4).get(encodedCacheKey, atomicBoolean, false);
                    }
                    return bufferedDiskCache4.get(encodedCacheKey, atomicBoolean);
                }
            });
        } else if (bufferedDiskCache3 instanceof TTBufferedDiskCache) {
            task = ((TTBufferedDiskCache) bufferedDiskCache3).get(encodedCacheKey, atomicBoolean, false);
        } else {
            task = bufferedDiskCache3.get(encodedCacheKey, atomicBoolean);
        }
        task.continueWith(onFinishDiskReads(consumer, bufferedDiskCache3, encodedCacheKey, producerContext));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }

    private Continuation<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> consumer, final BufferedDiskCache bufferedDiskCache, final CacheKey cacheKey, final ProducerContext producerContext) {
        final String id = producerContext.getId();
        final ProducerListener listener = producerContext.getListener();
        return new Continuation<EncodedImage, Void>() { // from class: com.facebook.imagepipeline.producers.TTDiskCacheProducer.2
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m2691then((Task<EncodedImage>) task);
            }

            /* renamed from: then, reason: collision with other method in class */
            public Void m2691then(Task<EncodedImage> task) throws Exception {
                if (TTDiskCacheProducer.isTaskCancelled(task)) {
                    listener.onProducerFinishWithCancellation(id, DiskCacheReadProducer.PRODUCER_NAME, null);
                    consumer.onCancellation();
                } else if (task.isFaulted()) {
                    listener.onProducerFinishWithFailure(id, DiskCacheReadProducer.PRODUCER_NAME, task.getError(), null);
                    TTDiskCacheProducer.this.maybeStartInputProducer(consumer, new DiskCacheConsumer(consumer, bufferedDiskCache, cacheKey, null), producerContext);
                } else {
                    EncodedImage encodedImage = (EncodedImage) task.getResult();
                    if (encodedImage != null && !(encodedImage instanceof TempEncodedImage)) {
                        ProducerListener producerListener = listener;
                        String str = id;
                        producerListener.onProducerFinishWithSuccess(str, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(producerListener, str, true, encodedImage.getSize()));
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(encodedImage, 1);
                        encodedImage.close();
                    } else {
                        ProducerListener producerListener2 = listener;
                        String str2 = id;
                        producerListener2.onProducerFinishWithSuccess(str2, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(producerListener2, str2, false, encodedImage.getSize()));
                        TTDiskCacheProducer.this.maybeStartInputProducer(consumer, new DiskCacheConsumer(consumer, bufferedDiskCache, cacheKey, encodedImage), producerContext);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTaskCancelled(Task<?> task) {
        return task.isCancelled() || (task.isFaulted() && (task.getError() instanceof CancellationException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeStartInputProducer(Consumer<EncodedImage> consumer, Consumer<EncodedImage> consumer2, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(consumer2, producerContext);
        }
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.TTDiskCacheProducer.3
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class DiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final BufferedDiskCache mCache;
        private final CacheKey mCacheKey;
        private EncodedImage mTempEncodedImage;

        private DiskCacheConsumer(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, EncodedImage encodedImage) {
            super(consumer);
            this.mCache = bufferedDiskCache;
            this.mCacheKey = cacheKey;
            this.mTempEncodedImage = encodedImage;
        }

        public EncodedImage getTempEncodedImage() {
            return this.mTempEncodedImage;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (encodedImage != null && isLast(i) && !(encodedImage instanceof TempEncodedImage)) {
                if (TTDiskCacheProducer.this.mChooseCacheByImageSize) {
                    int size = encodedImage.getSize();
                    if (size <= 0 || size >= TTDiskCacheProducer.this.mForceSmallCacheThresholdBytes) {
                        TTDiskCacheProducer.this.mDefaultBufferedDiskCache.put(this.mCacheKey, encodedImage);
                    } else {
                        TTDiskCacheProducer.this.mSmallImageBufferedDiskCache.put(this.mCacheKey, encodedImage);
                    }
                } else {
                    this.mCache.put(this.mCacheKey, encodedImage);
                }
            }
            getConsumer().onNewResult(encodedImage, i);
        }

        public void onTempResultImpl(EncodedImage encodedImage, boolean z) {
            if (encodedImage instanceof TempEncodedImage) {
                if (TTDiskCacheProducer.this.mChooseCacheByImageSize) {
                    int size = encodedImage.getSize();
                    if (size <= 0 || size >= TTDiskCacheProducer.this.mForceSmallCacheThresholdBytes || !(TTDiskCacheProducer.this.mSmallImageBufferedDiskCache instanceof TTBufferedDiskCache)) {
                        if (TTDiskCacheProducer.this.mDefaultBufferedDiskCache instanceof TTBufferedDiskCache) {
                            ((TTBufferedDiskCache) TTDiskCacheProducer.this.mDefaultBufferedDiskCache).putTempSync(this.mCacheKey, (TempEncodedImage) encodedImage, z);
                            return;
                        }
                        return;
                    }
                    ((TTBufferedDiskCache) TTDiskCacheProducer.this.mSmallImageBufferedDiskCache).putTempSync(this.mCacheKey, (TempEncodedImage) encodedImage, z);
                    return;
                }
                BufferedDiskCache bufferedDiskCache = this.mCache;
                if (bufferedDiskCache instanceof TTBufferedDiskCache) {
                    ((TTBufferedDiskCache) bufferedDiskCache).putTempSync(this.mCacheKey, (TempEncodedImage) encodedImage, z);
                }
            }
        }
    }
}
