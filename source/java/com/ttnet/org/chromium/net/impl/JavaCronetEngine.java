package com.ttnet.org.chromium.net.impl;

import android.os.Process;
import android.util.Log;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTMpaService;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.impl.CronetLogger;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class JavaCronetEngine extends CronetEngineBase {
    private static final String TAG = "JavaCronetEngine";
    private final int mCronetEngineId;
    private final ExecutorService mExecutorService;
    private final CronetLogger mLogger;
    private final String mUserAgent;

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void configureNetworkQualityEstimatorForTesting(boolean z, boolean z2, boolean z3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback callback, Executor executor, int i, List<String> list, int i2, int i3, int i4) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTMpaService createTTMpaService() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback callback, Executor executor, List<String> list, int i, String str, long j, int i2, long j2, String str2, int i3, String str3, Map<String, String> map, Map<String, String> map2, boolean z) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback callback, Executor executor, List<String> list, Map<String, String> map, Map<String, String> map2, boolean z) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveConnectionType() {
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public byte[] getGlobalMetricsDeltas() {
        return new byte[0];
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getHttpRttMs() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getTransportRttMs() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppInfoProvider(TTAppInfoProvider tTAppInfoProvider) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppMonitorProvider(TTMonitorProvider tTMonitorProvider) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerEventListener(TTEventListener tTEventListener) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startNetLogToDisk(String str, boolean z, int i) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void startNetLogToFile(String str, boolean z) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void stopNetLog() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase, com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor) {
        return super.newUrlRequestBuilder(str, callback, executor);
    }

    public JavaCronetEngine(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        int hashCode = hashCode();
        this.mCronetEngineId = hashCode;
        final int threadPriority = cronetEngineBuilderImpl.threadPriority(9);
        this.mUserAgent = cronetEngineBuilderImpl.getUserAgent();
        this.mExecutorService = new ThreadPoolExecutor(10, 20, 50L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.ttnet.org.chromium.net.impl.JavaCronetEngine.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return Executors.defaultThreadFactory().newThread(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaCronetEngine.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Thread.currentThread().setName(JavaCronetEngine.TAG);
                        Process.setThreadPriority(threadPriority);
                        runnable.run();
                    }
                });
            }
        });
        CronetLogger createLogger = CronetLoggerFactory.createLogger(cronetEngineBuilderImpl.getContext(), CronetLogger.CronetSource.CRONET_SOURCE_FALLBACK);
        this.mLogger = createLogger;
        try {
            createLogger.logCronetEngineCreation(hashCode, new CronetLogger.CronetEngineBuilderInfo(cronetEngineBuilderImpl), buildCronetVersion(), CronetLogger.CronetSource.CRONET_SOURCE_FALLBACK);
        } catch (RuntimeException e) {
            Log.e(TAG, "Error while trying to log JavaCronetEngine creation: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCronetEngineId() {
        return this.mCronetEngineId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CronetLogger getCronetLogger() {
        return this.mLogger;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, RequestFinishedInfo.Listener listener, int i4, long j) {
        if (j != -1) {
            throw new UnsupportedOperationException("The multi-network API is not supported by the Java implementation of Cronet Engine");
        }
        return new JavaUrlRequest(this, callback, this.mExecutorService, executor, str, this.mUserAgent, z3, z4, i2, z5, i3);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL url, Proxy proxy, boolean z) throws IOException {
        return url.openConnection(proxy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public ExperimentalBidirectionalStream createBidirectionalStream(String str, BidirectionalStream.Callback callback, Executor executor, String str2, List<Map.Entry<String, String>> list, int i, boolean z, Collection<Object> collection, boolean z2, int i2, boolean z3, int i3, long j) {
        throw new UnsupportedOperationException("Can't create a bidi stream - httpurlconnection doesn't have those APIs");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String str, BidirectionalStream.Callback callback, Executor executor) {
        throw new UnsupportedOperationException("The bidirectional stream API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public String getVersionString() {
        return "CronetHttpURLConnection/" + ImplVersion.getCronetVersionWithLastChange();
    }

    private CronetLogger.CronetVersion buildCronetVersion() {
        return new CronetLogger.CronetVersion(getVersionString().split("/")[1].split("@")[0]);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void shutdown() {
        this.mExecutorService.shutdown();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindToNetwork(long j) {
        throw new UnsupportedOperationException("The multi-network API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL url) throws IOException {
        return url.openConnection();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        return url.openConnection(proxy);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new URLStreamHandlerFactory() { // from class: com.ttnet.org.chromium.net.impl.JavaCronetEngine.2
            @Override // java.net.URLStreamHandlerFactory
            public URLStreamHandler createURLStreamHandler(String str) {
                return null;
            }
        };
    }
}
