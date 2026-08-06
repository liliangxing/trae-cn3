package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.net.ExpiredUrlException;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class NetworkFetchProducer implements Producer<EncodedImage> {
    public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
    public static final String PRODUCER_NAME = "NetworkFetchProducer";
    private static final int READ_SIZE = 16384;
    static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100;
    static final long TIME_BETWEEN_STATIC_PARTIAL_RESULTS_MS = 10;
    private static INetHeaderInterceptor mHeaderInterceptor;
    private static RequestUrlCallBack mRequestUrlCallBack;
    private final ByteArrayPool mByteArrayPool;
    private final NetworkFetcher mNetworkFetcher;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface INetHeaderInterceptor {
        Map<String, String> interceptHeader(Uri uri, Object obj, Map<String, String> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface RequestUrlCallBack {
        boolean canRequestUrl(Uri uri);
    }

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    public static void setRequestUrlCallBack(RequestUrlCallBack requestUrlCallBack) {
        mRequestUrlCallBack = requestUrlCallBack;
    }

    public static void setHeaderInterceptor(INetHeaderInterceptor iNetHeaderInterceptor) {
        mHeaderInterceptor = iNetHeaderInterceptor;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        producerContext.getListener().onProducerStart(producerContext.getId(), PRODUCER_NAME);
        final FetchState createFetchState = this.mNetworkFetcher.createFetchState(consumer, producerContext);
        RequestUrlCallBack requestUrlCallBack = mRequestUrlCallBack;
        if (requestUrlCallBack != null && !requestUrlCallBack.canRequestUrl(createFetchState.getUri())) {
            onFailure(createFetchState, new ExpiredUrlException("The expired url does not request network"));
            return;
        }
        INetHeaderInterceptor iNetHeaderInterceptor = mHeaderInterceptor;
        if (iNetHeaderInterceptor != null) {
            createFetchState.getContext().getImageRequest().setHttpHeader(iNetHeaderInterceptor.interceptHeader(createFetchState.getUri(), createFetchState.getContext().getCallerContext(), createFetchState.getContext().getImageRequest().getHttpHeader()));
        }
        this.mNetworkFetcher.fetch(createFetchState, new NetworkFetcher.Callback() { // from class: com.facebook.imagepipeline.producers.NetworkFetchProducer.1
            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onResponse(InputStream inputStream, int i) throws IOException {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("NetworkFetcher->onResponse");
                }
                NetworkFetchProducer.this.onResponse(createFetchState, inputStream, i);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }

            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onFailure(Throwable th) {
                NetworkFetchProducer.this.onFailure(createFetchState, th);
            }

            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onCancellation() {
                NetworkFetchProducer.this.onCancellation(createFetchState);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[Catch: all -> 0x011c, TryCatch #1 {all -> 0x011c, blocks: (B:13:0x0039, B:15:0x003f, B:17:0x0046, B:19:0x004c, B:21:0x005c, B:23:0x0062, B:25:0x006c, B:27:0x007a, B:29:0x0080, B:30:0x0098, B:31:0x009b, B:35:0x00a3, B:37:0x00a8, B:38:0x00ab, B:44:0x00c0, B:46:0x00ca, B:48:0x00cf, B:50:0x00e5, B:51:0x00ea, B:52:0x00f0, B:54:0x00ff, B:56:0x0105, B:58:0x010b, B:59:0x0110), top: B:12:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be A[EDGE_INSN: B:42:0x00be->B:43:0x00be BREAK  A[LOOP:0: B:31:0x009b->B:40:0x009b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c0 A[Catch: all -> 0x011c, TryCatch #1 {all -> 0x011c, blocks: (B:13:0x0039, B:15:0x003f, B:17:0x0046, B:19:0x004c, B:21:0x005c, B:23:0x0062, B:25:0x006c, B:27:0x007a, B:29:0x0080, B:30:0x0098, B:31:0x009b, B:35:0x00a3, B:37:0x00a8, B:38:0x00ab, B:44:0x00c0, B:46:0x00ca, B:48:0x00cf, B:50:0x00e5, B:51:0x00ea, B:52:0x00f0, B:54:0x00ff, B:56:0x0105, B:58:0x010b, B:59:0x0110), top: B:12:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onResponse(FetchState fetchState, InputStream inputStream, int i) throws IOException {
        MessageDigest messageDigest;
        PooledByteBufferOutputStream newOutputStream;
        byte[] bArr;
        Map<String, String> encodeImageExtraInfo;
        int read;
        SizeDeterminer sizeDeterminer;
        Pair<Integer, Integer> size;
        boolean needHandleDiskCacheMD5 = needHandleDiskCacheMD5(fetchState);
        boolean z = needHandleMD5(fetchState) && fetchState.needMd5();
        try {
            if (z || needHandleDiskCacheMD5) {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                } catch (Exception unused) {
                }
                if (i <= 0) {
                    newOutputStream = this.mPooledByteBufferFactory.newOutputStream(i);
                } else {
                    newOutputStream = this.mPooledByteBufferFactory.newOutputStream();
                }
                bArr = this.mByteArrayPool.get(16384);
                encodeImageExtraInfo = fetchState.getEncodeImageExtraInfo();
                if (encodeImageExtraInfo == null) {
                    encodeImageExtraInfo = new HashMap<>();
                }
                if (fetchState != null && fetchState.getUri() != null) {
                    encodeImageExtraInfo.put("url", fetchState.getUri().toString());
                }
                if (fetchState != null && fetchState.getContext() != null && fetchState.getContext().getImageRequest() != null && (sizeDeterminer = fetchState.getContext().getImageRequest().getSizeDeterminer()) != null && (size = sizeDeterminer.getSize()) != null) {
                    encodeImageExtraInfo.put("viewWidth", String.valueOf(size.first));
                    encodeImageExtraInfo.put("viewHeight", String.valueOf(size.second));
                }
                fetchState.setEncodeImageExtraInfo(encodeImageExtraInfo);
                while (true) {
                    read = inputStream.read(bArr);
                    if (read >= 0) {
                        break;
                    }
                    if (read > 0) {
                        newOutputStream.write(bArr, 0, read);
                        if (messageDigest != null) {
                            messageDigest.update(bArr, 0, read);
                        }
                        maybeHandleIntermediateResult(newOutputStream, fetchState);
                        fetchState.getConsumer().onProgressUpdate(calculateProgress(newOutputStream.size(), i));
                    }
                }
                if (messageDigest != null) {
                    String bytesToHexString = bytesToHexString(messageDigest.digest());
                    if (z) {
                        fetchState.setMd5(bytesToHexString);
                    }
                    if (needHandleDiskCacheMD5) {
                        String uri = fetchState.getContext().getImageRequest().getSourceUri().toString();
                        Map<String, String> encodeImageExtraInfo2 = fetchState.getEncodeImageExtraInfo();
                        if (encodeImageExtraInfo2 == null) {
                            encodeImageExtraInfo2 = new HashMap<>();
                        }
                        encodeImageExtraInfo2.put(uri, bytesToHexString);
                        fetchState.setEncodeImageExtraInfo(encodeImageExtraInfo2);
                    }
                }
                this.mNetworkFetcher.onFetchCompletion(fetchState, newOutputStream.size());
                if (FrescoCacheMonitorUtil.isAddMDLCancel() && FrescoCacheMonitorUtil.isOptMDLCancel() && newOutputStream.size() < i) {
                    fetchState.setOnNewResultStatusFlags(8);
                }
                handleFinalResult(newOutputStream, fetchState);
                return;
            }
            encodeImageExtraInfo = fetchState.getEncodeImageExtraInfo();
            if (encodeImageExtraInfo == null) {
            }
            if (fetchState != null) {
                encodeImageExtraInfo.put("url", fetchState.getUri().toString());
            }
            if (fetchState != null) {
                encodeImageExtraInfo.put("viewWidth", String.valueOf(size.first));
                encodeImageExtraInfo.put("viewHeight", String.valueOf(size.second));
            }
            fetchState.setEncodeImageExtraInfo(encodeImageExtraInfo);
            while (true) {
                read = inputStream.read(bArr);
                if (read >= 0) {
                }
            }
            if (messageDigest != null) {
            }
            this.mNetworkFetcher.onFetchCompletion(fetchState, newOutputStream.size());
            if (FrescoCacheMonitorUtil.isAddMDLCancel()) {
                fetchState.setOnNewResultStatusFlags(8);
            }
            handleFinalResult(newOutputStream, fetchState);
            return;
        } finally {
            this.mByteArrayPool.release(bArr);
            newOutputStream.close();
        }
        messageDigest = null;
        if (i <= 0) {
        }
        bArr = this.mByteArrayPool.get(16384);
    }

    protected static float calculateProgress(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        long uptimeMillis = SystemClock.uptimeMillis();
        ImageRequest imageRequest = fetchState.getContext().getImageRequest();
        if (!shouldPropagateIntermediateResults(fetchState) || uptimeMillis - fetchState.getLastIntermediateResultTimeMs() < getTimeBetweenPartialResultsMs(imageRequest)) {
            return;
        }
        fetchState.setLastIntermediateResultTimeMs(uptimeMillis);
        fetchState.getListener().onProducerEvent(fetchState.getId(), PRODUCER_NAME, "intermediate_result");
        notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags(), fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getEncodeImageExtraInfo());
    }

    protected boolean needHandleMD5(FetchState fetchState) {
        return "http".equals(fetchState.getUri().getScheme());
    }

    private boolean needHandleDiskCacheMD5(FetchState fetchState) {
        ImageRequest imageRequest = fetchState.getContext().getImageRequest();
        if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
            return ImagePipelineFactory.getInstance().getSmallImageBufferedDiskCache().getNeedMD5();
        }
        if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.CUSTOM) {
            return ImagePipelineFactory.getInstance().getCustomImageBufferedDiskCacheMap().get(imageRequest.getCustomCacheName()).getNeedMD5();
        }
        return ImagePipelineFactory.getInstance().getMainBufferedDiskCache().getNeedMD5();
    }

    protected void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Map<String, String> extraMap = getExtraMap(fetchState, pooledByteBufferOutputStream.size());
        ProducerListener listener = fetchState.getListener();
        listener.onProducerFinishWithSuccess(fetchState.getId(), PRODUCER_NAME, extraMap);
        listener.onUltimateProducerReached(fetchState.getId(), PRODUCER_NAME, true);
        notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags() | 1, fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getEncodeImageExtraInfo());
    }

    protected static void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, @Nullable BytesRange bytesRange, Consumer<EncodedImage> consumer, Map<String, String> map) {
        CloseableReference m496of = CloseableReference.m496of(pooledByteBufferOutputStream.toByteBuffer());
        EncodedImage encodedImage = null;
        try {
            EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) m496of);
            if (map != null) {
                try {
                    encodedImage2.setUri(map.get("url"));
                    int i2 = 0;
                    encodedImage2.setViewWidth(TextUtils.isEmpty(map.get("viewWidth")) ? 0 : Integer.parseInt(map.get("viewWidth")));
                    if (!TextUtils.isEmpty(map.get("viewHeight"))) {
                        i2 = Integer.parseInt(map.get("viewHeight"));
                    }
                    encodedImage2.setViewHeight(i2);
                } catch (Throwable th) {
                    th = th;
                    encodedImage = encodedImage2;
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely((CloseableReference<?>) m496of);
                    throw th;
                }
            }
            encodedImage2.setExtraInfo(map);
            encodedImage2.setBytesRange(bytesRange);
            encodedImage2.parseMetaData();
            encodedImage2.setRequestNetwork();
            consumer.onNewResult(encodedImage2, i);
            EncodedImage.closeSafely(encodedImage2);
            CloseableReference.closeSafely((CloseableReference<?>) m496of);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailure(FetchState fetchState, Throwable th) {
        Map<String, String> extraMap = getExtraMap(fetchState, -1);
        if (extraMap == null) {
            extraMap = new HashMap<>(1);
        }
        extraMap.put("NetworkFetcher", this.mNetworkFetcher == null ? "null" : this.mNetworkFetcher.getClass().getName() + ", " + this.mNetworkFetcher.toString());
        fetchState.getListener().onProducerFinishWithFailure(fetchState.getId(), PRODUCER_NAME, th, extraMap);
        fetchState.getListener().onUltimateProducerReached(fetchState.getId(), PRODUCER_NAME, false);
        fetchState.getConsumer().onFailure(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancellation(FetchState fetchState) {
        fetchState.getListener().onProducerFinishWithCancellation(fetchState.getId(), PRODUCER_NAME, getExtraMap(fetchState, -1));
        fetchState.getConsumer().onCancellation();
    }

    private boolean shouldPropagateIntermediateResults(FetchState fetchState) {
        if (fetchState.getContext().isIntermediateResultExpected()) {
            return this.mNetworkFetcher.shouldPropagate(fetchState);
        }
        return false;
    }

    private long getTimeBetweenPartialResultsMs(ImageRequest imageRequest) {
        return imageRequest.isThumbDataInFetch() ? TIME_BETWEEN_STATIC_PARTIAL_RESULTS_MS : TIME_BETWEEN_PARTIAL_RESULTS_MS;
    }

    @Nullable
    private Map<String, String> getExtraMap(FetchState fetchState, int i) {
        if (fetchState.getListener().requiresExtraMap(fetchState.getId())) {
            return this.mNetworkFetcher.getExtraMap(fetchState, i);
        }
        return null;
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }
}
