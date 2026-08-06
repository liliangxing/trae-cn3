package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.cache.disk.TempEncodedImage;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.TTDiskCacheProducer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TTNetworkFetchProducer extends NetworkFetchProducer {
    public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
    static final String PRODUCER_NAME = "TTNetworkFetchProducer";
    private static final int READ_SIZE = 16384;
    static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100;
    private final ByteArrayPool mByteArrayPool;
    private final NetworkFetcher mNetworkFetcher;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public TTNetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        super(pooledByteBufferFactory, byteArrayPool, networkFetcher);
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetchProducer, com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        producerContext.getListener().onProducerStart(producerContext.getId(), PRODUCER_NAME);
        final FetchState createFetchState = this.mNetworkFetcher.createFetchState(consumer, producerContext);
        this.mNetworkFetcher.fetch(createFetchState, new NetworkFetcher.Callback() { // from class: com.facebook.imagepipeline.producers.TTNetworkFetchProducer.1
            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onResponse(InputStream inputStream, int i) throws IOException {
                TTNetworkFetchProducer.this.onResponse(createFetchState, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onFailure(Throwable th) {
                TTNetworkFetchProducer.this.onFailure(createFetchState, th);
            }

            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onCancellation() {
                TTNetworkFetchProducer.this.onCancellation(createFetchState);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079 A[SYNTHETIC] */
    @Override // com.facebook.imagepipeline.producers.NetworkFetchProducer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onResponse(FetchState fetchState, InputStream inputStream, int i) throws IOException {
        PooledByteBufferOutputStream newOutputStream;
        int read;
        EncodedImage encodedImage;
        InputStream inputStream2;
        byte[] bArr = this.mByteArrayPool.get(16384);
        if (i > 0) {
            if (!(fetchState.getConsumer() instanceof TTDiskCacheProducer.DiskCacheConsumer) || ((TTDiskCacheProducer.DiskCacheConsumer) fetchState.getConsumer()).getTempEncodedImage() == null) {
                encodedImage = null;
            } else {
                encodedImage = ((TTDiskCacheProducer.DiskCacheConsumer) fetchState.getConsumer()).getTempEncodedImage();
                if (EncodedImage.isValid(encodedImage)) {
                    i += encodedImage.getSize();
                }
            }
            newOutputStream = this.mPooledByteBufferFactory.newOutputStream(i);
            if (encodedImage != null) {
                try {
                    inputStream2 = encodedImage.getInputStream();
                } catch (Exception unused) {
                }
                if (inputStream2 != null) {
                    while (true) {
                        int read2 = inputStream2.read(bArr);
                        if (read2 > 0) {
                            newOutputStream.write(bArr, 0, read2);
                        }
                    }
                    while (true) {
                        try {
                            read = inputStream.read(bArr);
                            if (read >= 0) {
                                this.mNetworkFetcher.onFetchCompletion(fetchState, newOutputStream.size());
                                handleFinalResult(newOutputStream, fetchState);
                                return;
                            } else if (read > 0) {
                                newOutputStream.write(bArr, 0, read);
                                maybeHandleIntermediateResult(newOutputStream, fetchState, newOutputStream.size() - read);
                                fetchState.getConsumer().onProgressUpdate(calculateProgress(newOutputStream.size(), i));
                            }
                        } finally {
                            this.mByteArrayPool.release(bArr);
                            newOutputStream.close();
                        }
                    }
                }
            }
        } else {
            newOutputStream = this.mPooledByteBufferFactory.newOutputStream();
        }
        while (true) {
            read = inputStream.read(bArr);
            if (read >= 0) {
            }
        }
    }

    protected static float calculateProgress(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState, int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (shouldPropagateIntermediateResults(fetchState) && uptimeMillis - fetchState.getLastIntermediateResultTimeMs() >= TIME_BETWEEN_PARTIAL_RESULTS_MS) {
            fetchState.setLastIntermediateResultTimeMs(uptimeMillis);
            fetchState.getListener().onProducerEvent(fetchState.getId(), PRODUCER_NAME, "intermediate_result");
            notifyConsumer(pooledByteBufferOutputStream, false, fetchState.getConsumer(), i, false);
            return;
        }
        notifyConsumer(pooledByteBufferOutputStream, false, fetchState.getConsumer(), i, true);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetchProducer
    protected void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        fetchState.getListener().onProducerFinishWithSuccess(fetchState.getId(), PRODUCER_NAME, getExtraMap(fetchState, pooledByteBufferOutputStream.size()));
        notifyConsumer(pooledByteBufferOutputStream, true, fetchState.getConsumer(), pooledByteBufferOutputStream.size(), false);
    }

    private void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, boolean z, Consumer<EncodedImage> consumer, int i, boolean z2) {
        CloseableReference m496of = CloseableReference.m496of(pooledByteBufferOutputStream.toByteBuffer());
        EncodedImage encodedImage = null;
        try {
            if (consumer instanceof TTDiskCacheProducer.DiskCacheConsumer) {
                TempEncodedImage tempEncodedImage = new TempEncodedImage((CloseableReference<PooledByteBuffer>) m496of);
                try {
                    TempEncodedImage tempEncodedImage2 = tempEncodedImage;
                    tempEncodedImage.setOffset(i);
                    encodedImage = tempEncodedImage;
                } catch (Throwable th) {
                    th = th;
                    encodedImage = tempEncodedImage;
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely((CloseableReference<?>) m496of);
                    throw th;
                }
            } else {
                encodedImage = new EncodedImage((CloseableReference<PooledByteBuffer>) m496of);
            }
            encodedImage.parseMetaData();
            if (consumer instanceof TTDiskCacheProducer.DiskCacheConsumer) {
                ((TTDiskCacheProducer.DiskCacheConsumer) consumer).onTempResultImpl(encodedImage, z);
            }
            if (!z2) {
                consumer.onNewResult(encodedImage, z ? 1 : 0);
            }
            EncodedImage.closeSafely(encodedImage);
            CloseableReference.closeSafely((CloseableReference<?>) m496of);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailure(FetchState fetchState, Throwable th) {
        fetchState.getListener().onProducerFinishWithFailure(fetchState.getId(), PRODUCER_NAME, th, getExtraMap(fetchState, -1));
        fetchState.getConsumer().onFailure(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancellation(FetchState fetchState) {
        fetchState.getListener().onProducerFinishWithCancellation(fetchState.getId(), PRODUCER_NAME, getExtraMap(fetchState, -1));
        fetchState.getConsumer().onCancellation();
    }

    private boolean shouldPropagateIntermediateResults(FetchState fetchState) {
        if (fetchState.getContext().getImageRequest().getProgressiveRenderingEnabled()) {
            return this.mNetworkFetcher.shouldPropagate(fetchState);
        }
        return false;
    }

    private Map<String, String> getExtraMap(FetchState fetchState, int i) {
        if (fetchState.getListener().requiresExtraMap(fetchState.getId())) {
            return this.mNetworkFetcher.getExtraMap(fetchState, i);
        }
        return null;
    }
}
