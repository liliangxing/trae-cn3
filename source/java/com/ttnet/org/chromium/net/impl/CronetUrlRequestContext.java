package com.ttnet.org.chromium.net.impl;

import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.PowerMonitor;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTMpaService;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl;
import com.ttnet.org.chromium.net.impl.CronetLogger;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.urlconnection.CronetURLStreamHandlerFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@JNINamespace("cronet")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CronetUrlRequestContext extends CronetEngineBase {
    private static final int LOG_DEBUG = -1;
    private static final int LOG_NONE = 3;
    static final String LOG_TAG = "CronetUrlRequestContext";
    private static final int LOG_VERBOSE = -2;
    private static final HashSet<String> sInUseStoragePaths = new HashSet<>();
    private final AtomicInteger mActiveRequestCount;
    private TTAppInfoProvider mAppInfoProvider;
    private TTMonitorProvider mAppMonitorProvider;
    private final int mCronetEngineId;
    private double[] mDownstreamPacketLossRate;
    private double[] mDownstreamPacketLossRateVariance;
    private int mDownstreamThroughputKbps;
    private int mEffectiveConnectionType;
    private int mEffectiveHrttMs;
    private int mEffectiveRxThroughputKbps;
    private int mEffectiveTrttMs;
    private TTEventListener mEventListener;
    private final Object mFinishedListenerLock;
    private final Map<RequestFinishedInfo.Listener, VersionSafeCallbacks.RequestFinishedInfoListener> mFinishedListenerMap;
    private int[] mGroupHttpRttMs;
    private int[] mGroupTransportRttMs;
    private int mHttpRttMs;
    private final String mInUseStoragePath;
    private final ConditionVariable mInitCompleted;
    private boolean mIsLogging;
    private boolean mIsStoppingNetLog;
    private boolean mListenAppStateIndependently;
    private final Object mLock;
    private final CronetLogger mLogger;
    private long mNetworkHandle;
    private final boolean mNetworkQualityEstimatorEnabled;
    private final Object mNetworkQualityLevelLock;
    private final Object mNetworkQualityLock;
    private Thread mNetworkThread;
    private int mNql;
    private final ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> mRttListenerList;
    private final boolean mSkipLogging;
    private final ConditionVariable mStopNetLogCompleted;
    private TTThreadConfigInfoProvider.Callback mThreadConfigCallback;
    private Map<TTThreadConfigInfoProvider.ThreadType, TTThreadConfigInfoProvider.BindCore> mThreadTypeBindCoreMap;
    private final Object mThreadTypeIdLock;
    private Map<TTThreadConfigInfoProvider.ThreadType, Integer> mThreadTypeIdMap;
    private final ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> mThroughputListenerList;
    private int mTransportRttMs;
    private double[] mUpstreamPacketLossRate;
    private double[] mUpstreamPacketLossRateVariance;
    private long mUrlRequestContextAdapter;
    private String[] mWatchingGroups;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Natives {
        @NativeClassQualifiedName("CronetContextAdapter")
        void addClientOpaqueData(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, byte[] bArr, byte[] bArr2, long j2, long j3);

        void addPkp(long j, String str, byte[][] bArr, boolean z, long j2);

        void addQuicHint(long j, String str, int i, int i2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void addSamplingSetting(long j, CronetUrlRequestContext cronetUrlRequestContext, TTSamplingSettingProvider.TTSlaSamplingSetting tTSlaSamplingSetting);

        @NativeClassQualifiedName("CronetContextAdapter")
        void clearClientOpaqueData(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void configureNetworkQualityEstimatorForTesting(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z, boolean z2, boolean z3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void controlHttpDNSConfig(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z, boolean z2, boolean z3);

        long createRequestContextAdapter(long j);

        long createRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i, long j, String str4, long j2, boolean z5, boolean z6, int i2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void destroy(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void enableTTBizHttpDns(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z, String str, String str2, String str3, boolean z2, String str4);

        byte[] getHistogramDeltas();

        long[] getOpaqueFuncAddress();

        void initALogFuncAddr(long j);

        @NativeClassQualifiedName("CronetContextAdapter")
        void initRequestContextOnInitThread(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void parseTNCConfigFromSystemHTTPRequest(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2, String str3, String str4, String str5, String str6);

        @NativeClassQualifiedName("CronetContextAdapter")
        void preconnectUrl(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, int i, String str2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void provideRTTObservations(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void provideThroughputObservations(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void removeClientOpaqueData(long j, CronetUrlRequestContext cronetUrlRequestContext, String str);

        @NativeClassQualifiedName("CronetContextAdapter")
        void reportNetDiagnosisUserLog(long j, CronetUrlRequestContext cronetUrlRequestContext, String str);

        @NativeClassQualifiedName("CronetContextAdapter")
        void runInBackGround(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setAlogFuncAddr(long j, CronetUrlRequestContext cronetUrlRequestContext, long j2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setAppStartUpState(long j, CronetUrlRequestContext cronetUrlRequestContext, int i);

        void setClientOpaqueData(long j, String[] strArr, byte[] bArr, byte[] bArr2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setCookieInitCompleted(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setHostResolverRules(long j, CronetUrlRequestContext cronetUrlRequestContext, String str);

        int setMinLogLevel(int i);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setProxy(long j, CronetUrlRequestContext cronetUrlRequestContext, String str);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setRouteSelectionBestHost(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2);

        void setTTNetInitConfig(long j, int i, boolean z, boolean z2, String str, String str2, String str3, boolean z3, String str4, String str5, byte[][] bArr, TTThreadConfigInfoProvider.ThreadConfigInfo[] threadConfigInfoArr, boolean z4, boolean z5, boolean z6, String str6, TTAppInfoProvider.AppInfo appInfo, long j2, boolean z7, boolean z8, boolean z9, TTSamplingSettingProvider.TTSlaSamplingSetting tTSlaSamplingSetting, boolean z10, String str7);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setZstdFuncAddr(long j, CronetUrlRequestContext cronetUrlRequestContext, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean skipLogging(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void startNetLogToDisk(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, boolean z, int i);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean startNetLogToFile(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void startThrottle(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i, long j2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void stopNetLog(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void stopThrottle(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i);

        @NativeClassQualifiedName("CronetContextAdapter")
        void triggerTNCRequestByUser(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void tryStartNetDetect(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i, int i2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void ttDnsResolve(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, int i, String str2, String str3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void ttUrlDispatch(long j, CronetUrlRequestContext cronetUrlRequestContext, URLDispatch uRLDispatch, String str, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void updateStoreRegionFromServer(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase, com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor) {
        return super.newUrlRequestBuilder(str, callback, executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCronetEngineId() {
        return this.mCronetEngineId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CronetLogger getCronetLogger() {
        return this.mLogger;
    }

    public CronetUrlRequestContext(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        boolean skipLogging;
        Object obj = new Object();
        this.mLock = obj;
        this.mInitCompleted = new ConditionVariable(false);
        this.mActiveRequestCount = new AtomicInteger(0);
        this.mNetworkQualityLock = new Object();
        this.mFinishedListenerLock = new Object();
        this.mEffectiveConnectionType = 0;
        this.mHttpRttMs = -1;
        this.mTransportRttMs = -1;
        this.mDownstreamThroughputKbps = -1;
        ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> observerList = new ObserverList<>();
        this.mRttListenerList = observerList;
        ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> observerList2 = new ObserverList<>();
        this.mThroughputListenerList = observerList2;
        this.mFinishedListenerMap = new HashMap();
        this.mNetworkQualityLevelLock = new Object();
        this.mEffectiveHrttMs = -1;
        this.mEffectiveTrttMs = -1;
        this.mEffectiveRxThroughputKbps = -1;
        this.mUpstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mUpstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        Object obj2 = new Object();
        this.mThreadTypeIdLock = obj2;
        this.mThreadTypeIdMap = new HashMap();
        this.mThreadTypeBindCoreMap = new HashMap();
        this.mStopNetLogCompleted = new ConditionVariable();
        this.mNetworkHandle = -1L;
        this.mCronetEngineId = hashCode();
        observerList.disableThreadAsserts();
        observerList2.disableThreadAsserts();
        this.mNetworkQualityEstimatorEnabled = cronetEngineBuilderImpl.networkQualityEstimatorEnabled();
        CronetLibraryLoader.ensureInitialized(cronetEngineBuilderImpl.getContext(), cronetEngineBuilderImpl);
        CronetUrlRequestContextJni.get().setMinLogLevel(getLoggingLevel());
        if (cronetEngineBuilderImpl.httpCacheMode() == 1) {
            String storagePath = cronetEngineBuilderImpl.storagePath();
            this.mInUseStoragePath = storagePath;
            HashSet<String> hashSet = sInUseStoragePaths;
            synchronized (hashSet) {
                if (!hashSet.add(storagePath)) {
                    throw new IllegalStateException("Disk cache storage path already in use");
                }
            }
        } else {
            this.mInUseStoragePath = null;
        }
        this.mAppInfoProvider = cronetEngineBuilderImpl.getAppInfoProvider();
        this.mAppMonitorProvider = cronetEngineBuilderImpl.getAppMonitorProvider();
        this.mEventListener = cronetEngineBuilderImpl.getEventListener();
        this.mListenAppStateIndependently = cronetEngineBuilderImpl.getListenAppStateIndependently();
        synchronized (obj2) {
            this.mThreadConfigCallback = cronetEngineBuilderImpl.threadConfigCallbackImpl();
        }
        synchronized (obj) {
            long createRequestContextAdapter = CronetUrlRequestContextJni.get().createRequestContextAdapter(createNativeUrlRequestContextConfig(cronetEngineBuilderImpl));
            this.mUrlRequestContextAdapter = createRequestContextAdapter;
            if (createRequestContextAdapter == 0) {
                throw new NullPointerException("Context Adapter creation failed.");
            }
            skipLogging = CronetUrlRequestContextJni.get().skipLogging(this.mUrlRequestContextAdapter, this);
            this.mSkipLogging = skipLogging;
        }
        if (skipLogging) {
            this.mLogger = CronetLoggerFactory.createNoOpLogger();
        } else {
            this.mLogger = CronetLoggerFactory.createLogger(cronetEngineBuilderImpl.getContext(), getCronetSource());
        }
        try {
            this.mLogger.logCronetEngineCreation(getCronetEngineId(), new CronetLogger.CronetEngineBuilderInfo(cronetEngineBuilderImpl), buildCronetVersion(), getCronetSource());
        } catch (RuntimeException e) {
            Log.m282e(LOG_TAG, "Error while trying to log CronetEngine creation: ", e);
        }
        CronetLibraryLoader.postToInitThread(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.1
            @Override // java.lang.Runnable
            public void run() {
                CronetLibraryLoader.ensureInitializedOnInitThread();
                CronetLibraryLoader.createNetworkChangeNotifierOnInitThread();
                PowerMonitor.setListenAppStateIndependently(CronetUrlRequestContext.this.mListenAppStateIndependently);
                PowerMonitor.create();
                synchronized (CronetUrlRequestContext.this.mLock) {
                    CronetUrlRequestContextJni.get().initRequestContextOnInitThread(CronetUrlRequestContext.this.mUrlRequestContextAdapter, CronetUrlRequestContext.this);
                }
            }
        });
    }

    static CronetLogger.CronetSource getCronetSource() {
        return CronetEngine.class.getClassLoader().equals(CronetUrlRequest.class.getClassLoader()) ? CronetLogger.CronetSource.CRONET_SOURCE_STATICALLY_LINKED : CronetLogger.CronetSource.CRONET_SOURCE_PLAY_SERVICES;
    }

    public static long createNativeUrlRequestContextConfig(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        String str = "";
        try {
            File filesDir = cronetEngineBuilderImpl.getContext().getFilesDir();
            if (filesDir != null) {
                str = filesDir.getAbsolutePath();
            }
        } catch (Throwable unused) {
        }
        String str2 = str;
        long createRequestContextConfig = CronetUrlRequestContextJni.get().createRequestContextConfig(cronetEngineBuilderImpl.getUserAgent(), cronetEngineBuilderImpl.storagePath(), cronetEngineBuilderImpl.quicEnabled(), cronetEngineBuilderImpl.getDefaultQuicUserAgentId(), cronetEngineBuilderImpl.http2Enabled(), cronetEngineBuilderImpl.brotliEnabled(), cronetEngineBuilderImpl.cacheDisabled(), cronetEngineBuilderImpl.httpCacheMode(), cronetEngineBuilderImpl.httpCacheMaxSize(), cronetEngineBuilderImpl.experimentalOptions(), cronetEngineBuilderImpl.mockCertVerifier(), cronetEngineBuilderImpl.networkQualityEstimatorEnabled(), cronetEngineBuilderImpl.publicKeyPinningBypassForLocalTrustAnchorsEnabled(), cronetEngineBuilderImpl.threadPriority(0));
        if (createRequestContextConfig == 0) {
            throw new IllegalArgumentException("Experimental options parsing failed.");
        }
        for (CronetEngineBuilderImpl.QuicHint quicHint : cronetEngineBuilderImpl.quicHints()) {
            CronetUrlRequestContextJni.get().addQuicHint(createRequestContextConfig, quicHint.mHost, quicHint.mPort, quicHint.mAlternatePort);
        }
        for (CronetEngineBuilderImpl.Pkp pkp : cronetEngineBuilderImpl.publicKeyPins()) {
            CronetUrlRequestContextJni.get().addPkp(createRequestContextConfig, pkp.mHost, pkp.mHashes, pkp.mIncludeSubdomains, pkp.mExpirationDate.getTime());
        }
        ArrayList<byte[]> opaqueData = cronetEngineBuilderImpl.getOpaqueData();
        byte[][] bArr = (opaqueData == null || opaqueData.isEmpty()) ? null : (byte[][]) opaqueData.toArray(new byte[opaqueData.size()]);
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> threadConfigInfoList = cronetEngineBuilderImpl.threadConfigInfoList();
        CronetUrlRequestContextJni.get().setTTNetInitConfig(createRequestContextConfig, cronetEngineBuilderImpl.getAppSecurityLevel(), cronetEngineBuilderImpl.httpDnsEnabled(), cronetEngineBuilderImpl.verboseLogEnabled(), str2, cronetEngineBuilderImpl.getProxyConfig(), cronetEngineBuilderImpl.getGetDomainDefaultJSON(), cronetEngineBuilderImpl.boeProxyEnabled(), cronetEngineBuilderImpl.getBypassBOEJSON(), cronetEngineBuilderImpl.getStoreIdcRuleJSON(), bArr, (threadConfigInfoList == null || threadConfigInfoList.isEmpty()) ? null : (TTThreadConfigInfoProvider.ThreadConfigInfo[]) threadConfigInfoList.toArray(new TTThreadConfigInfoProvider.ThreadConfigInfo[threadConfigInfoList.size()]), cronetEngineBuilderImpl.tncSecureModeEnabled(), cronetEngineBuilderImpl.isMainProcess(), cronetEngineBuilderImpl.lazyInitIPC(), cronetEngineBuilderImpl.processName(), cronetEngineBuilderImpl.TTAppInfoSubset(), cronetEngineBuilderImpl.ttnetInitStart(), cronetEngineBuilderImpl.optInit(), cronetEngineBuilderImpl.optNqeDefault(), cronetEngineBuilderImpl.optNqePersist(), cronetEngineBuilderImpl.samplingSetting(), cronetEngineBuilderImpl.optStack(), cronetEngineBuilderImpl.threadStackInitReason());
        Map<String[], Pair<byte[], byte[]>> clientOpaqueData = cronetEngineBuilderImpl.getClientOpaqueData();
        if (clientOpaqueData != null && !clientOpaqueData.isEmpty()) {
            for (Map.Entry<String[], Pair<byte[], byte[]>> entry : clientOpaqueData.entrySet()) {
                CronetUrlRequestContextJni.get().setClientOpaqueData(createRequestContextConfig, entry.getKey(), (byte[]) entry.getValue().first, (byte[]) entry.getValue().second);
            }
        }
        CronetUrlRequestContextJni.get().initALogFuncAddr(cronetEngineBuilderImpl.aLogFuncAddr());
        return createRequestContextConfig;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String str, BidirectionalStream.Callback callback, Executor executor) {
        return new BidirectionalStreamBuilderImpl(str, callback, executor, this);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, RequestFinishedInfo.Listener listener, int i4, long j) {
        long j2 = j == -1 ? this.mNetworkHandle : j;
        synchronized (this.mLock) {
            try {
                try {
                    checkHaveAdapter();
                    return new CronetUrlRequest(this, str, i, callback, executor, collection, z, z2, z3, z4, i2, z5, i3, listener, i4, j2);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    protected ExperimentalBidirectionalStream createBidirectionalStream(String str, BidirectionalStream.Callback callback, Executor executor, String str2, List<Map.Entry<String, String>> list, int i, boolean z, Collection<Object> collection, boolean z2, int i2, boolean z3, int i3, long j) {
        long j2 = j == -1 ? this.mNetworkHandle : j;
        synchronized (this.mLock) {
            try {
                try {
                    checkHaveAdapter();
                    return new CronetBidirectionalStream(this, str, i, callback, executor, str2, list, z, collection, z2, i2, z3, i3, j2);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public String getVersionString() {
        return "Cronet/" + ImplVersion.getCronetVersionWithLastChange();
    }

    private CronetLogger.CronetVersion buildCronetVersion() {
        return new CronetLogger.CronetVersion(getVersionString().split("/")[1].split("@")[0]);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void shutdown() {
        if (this.mInUseStoragePath != null) {
            HashSet<String> hashSet = sInUseStoragePaths;
            synchronized (hashSet) {
                hashSet.remove(this.mInUseStoragePath);
            }
        }
        synchronized (this.mLock) {
            checkHaveAdapter();
            if (this.mActiveRequestCount.get() != 0) {
                throw new IllegalStateException("Cannot shutdown with active requests.");
            }
            if (Thread.currentThread() == this.mNetworkThread) {
                throw new IllegalThreadStateException("Cannot shutdown from network thread.");
            }
        }
        this.mInitCompleted.block();
        stopNetLog();
        synchronized (this.mLock) {
            if (haveRequestContextAdapter()) {
                CronetUrlRequestContextJni.get().destroy(this.mUrlRequestContextAdapter, this);
                this.mUrlRequestContextAdapter = 0L;
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void startNetLogToFile(String str, boolean z) {
        synchronized (this.mLock) {
            checkHaveAdapter();
            if (this.mIsLogging) {
                return;
            }
            if (!CronetUrlRequestContextJni.get().startNetLogToFile(this.mUrlRequestContextAdapter, this, str, z)) {
                throw new RuntimeException("Unable to start NetLog");
            }
            this.mIsLogging = true;
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startNetLogToDisk(String str, boolean z, int i) {
        synchronized (this.mLock) {
            checkHaveAdapter();
            if (this.mIsLogging) {
                return;
            }
            CronetUrlRequestContextJni.get().startNetLogToDisk(this.mUrlRequestContextAdapter, this, str, z, i);
            this.mIsLogging = true;
        }
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void stopNetLog() {
        synchronized (this.mLock) {
            checkHaveAdapter();
            if (this.mIsLogging && !this.mIsStoppingNetLog) {
                CronetUrlRequestContextJni.get().stopNetLog(this.mUrlRequestContextAdapter, this);
                this.mIsStoppingNetLog = true;
                this.mStopNetLogCompleted.block();
                this.mStopNetLogCompleted.close();
                synchronized (this.mLock) {
                    this.mIsStoppingNetLog = false;
                    this.mIsLogging = false;
                }
            }
        }
    }

    public void stopNetLogCompleted() {
        this.mStopNetLogCompleted.open();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback callback, Executor executor, List<String> list, Map<String, String> map, Map<String, String> map2, boolean z) {
        return new CronetWebsocketConnection(this, callback, executor, list, map, map2, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback callback, Executor executor, List<String> list, int i, String str, long j, int i2, long j2, String str2, int i3, String str3, Map<String, String> map, Map<String, String> map2, boolean z) {
        return new CronetWebsocketConnection(this, callback, executor, list, i, str, j, i2, j2, str2, i3, str3, map, map2, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    protected TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback callback, Executor executor, int i, List<String> list, int i2, int i3, int i4) {
        return new TTCronetNetExpRequest(this, callback, executor, i, list, i2, i3, i4);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTMpaService createTTMpaService() {
        return new TTCronetMpaService(this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void notifyTNCConfigUpdated(String str, String str2, String str3, String str4, String str5, String str6) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().parseTNCConfigFromSystemHTTPRequest(this.mUrlRequestContextAdapter, this, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void triggerGetDomain(boolean z) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().triggerTNCRequestByUser(this.mUrlRequestContextAdapter, this, z);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, String> ttUrlDispatch(String str, int i, boolean z) throws IOException {
        URLDispatch uRLDispatch = new URLDispatch(str);
        synchronized (this.mLock) {
            checkHaveAdapter();
            CronetUrlRequestContextJni.get().ttUrlDispatch(this.mUrlRequestContextAdapter, this, uRLDispatch, str, z);
        }
        uRLDispatch.waitResult(i);
        HashMap hashMap = new HashMap();
        hashMap.put(URLDispatch.KEY_FINAL_URL, uRLDispatch.getFinalUrl());
        hashMap.put(URLDispatch.KEY_EPOCH, uRLDispatch.getEpoch());
        hashMap.put(URLDispatch.KEY_ETAG, uRLDispatch.getEtag());
        hashMap.put(URLDispatch.KEY_TTNET_ORIGIN_HOST, uRLDispatch.getTTNetOriginHost());
        return hashMap;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void runInBackGround(boolean z) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().runInBackGround(this.mUrlRequestContextAdapter, this, z);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addClientOpaqueData(String[] strArr, byte[] bArr, byte[] bArr2, long j, long j2) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().addClientOpaqueData(this.mUrlRequestContextAdapter, this, strArr, bArr, bArr2, j, j2);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void clearClientOpaqueData() {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().clearClientOpaqueData(this.mUrlRequestContextAdapter, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeClientOpaqueData(String str) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().removeClientOpaqueData(this.mUrlRequestContextAdapter, this, str);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setProxy(String str) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().setProxy(this.mUrlRequestContextAdapter, this, str);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void preconnectUrl(String str, int i, Map<String, String> map) {
        synchronized (this.mLock) {
            checkHaveAdapter();
            CronetUrlRequestContextJni.get().preconnectUrl(this.mUrlRequestContextAdapter, this, str, i, constructControlHeaders(map));
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String str) {
        synchronized (this.mLock) {
            checkHaveAdapter();
            CronetUrlRequestContextJni.get().setHostResolverRules(this.mUrlRequestContextAdapter, this, str);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting tTSlaSamplingSetting) {
        synchronized (this.mLock) {
            checkHaveAdapter();
            CronetUrlRequestContextJni.get().addSamplingSetting(this.mUrlRequestContextAdapter, this, tTSlaSamplingSetting);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRate(int i) {
        double d;
        handleProtocolException(i);
        synchronized (this.mNetworkQualityLock) {
            d = this.mUpstreamPacketLossRate[i];
        }
        return d;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRateVariance(int i) {
        double d;
        handleProtocolException(i);
        synchronized (this.mNetworkQualityLock) {
            d = this.mUpstreamPacketLossRateVariance[i];
        }
        return d;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRate(int i) {
        double d;
        handleProtocolException(i);
        synchronized (this.mNetworkQualityLock) {
            d = this.mUpstreamPacketLossRate[i];
        }
        return d;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRateVariance(int i) {
        double d;
        handleProtocolException(i);
        synchronized (this.mNetworkQualityLock) {
            d = this.mDownstreamPacketLossRateVariance[i];
        }
        return d;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getNetworkQualityLevel() {
        int i;
        synchronized (this.mNetworkQualityLevelLock) {
            i = this.mNql;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveHttpRtt() {
        int i;
        synchronized (this.mNetworkQualityLevelLock) {
            i = this.mEffectiveHrttMs;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveTransportRtt() {
        int i;
        synchronized (this.mNetworkQualityLevelLock) {
            i = this.mEffectiveTrttMs;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveRxThroughput() {
        int i;
        synchronized (this.mNetworkQualityLevelLock) {
            i = this.mEffectiveRxThroughputKbps;
        }
        return i;
    }

    private void handleProtocolException(int i) {
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        if (i != 0 && i != 1) {
            throw new IllegalStateException("Error protocol: " + i);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppInfoProvider(TTAppInfoProvider tTAppInfoProvider) {
        this.mAppInfoProvider = tTAppInfoProvider;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppMonitorProvider(TTMonitorProvider tTMonitorProvider) {
        this.mAppMonitorProvider = tTMonitorProvider;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerEventListener(TTEventListener tTEventListener) {
        this.mEventListener = tTEventListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> onCallToAddSecurityFactor(String str, Map<String, String> map) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener == null) {
            return null;
        }
        return tTEventListener.onCallToAddSecurityFactor(str, map);
    }

    private String[] addSecurityFactor(String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            hashMap.put(strArr[i2].toLowerCase(Locale.US), strArr[i2 + 1]);
        }
        Map<String, String> onCallToAddSecurityFactor = onCallToAddSecurityFactor(str, hashMap);
        if (onCallToAddSecurityFactor == null) {
            return null;
        }
        String[] strArr2 = new String[onCallToAddSecurityFactor.size() * 2];
        for (Map.Entry<String, String> entry : onCallToAddSecurityFactor.entrySet()) {
            strArr2[i] = entry.getKey();
            strArr2[i + 1] = entry.getValue();
            i += 2;
        }
        return strArr2;
    }

    String onRequestInterceptorToStart(String str, String[] strArr, String[] strArr2) {
        if (this.mEventListener == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strArr.length; i += 2) {
            hashMap.put(strArr[i].toLowerCase(Locale.US), strArr[i + 1]);
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr2) {
            arrayList.add(str2);
        }
        return this.mEventListener.onRequestInterceptorToStart(str, hashMap, arrayList);
    }

    String onResponseInterceptorToStart(String str, String[] strArr, int i) {
        if (this.mEventListener == null) {
            return null;
        }
        ArrayList<Map.Entry> arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2].toLowerCase(Locale.US), strArr[i2 + 1]));
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry entry : arrayList) {
            ArrayList arrayList2 = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList2.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList2.add((String) entry.getValue());
            treeMap.put((String) entry.getKey(), Collections.unmodifiableList(arrayList2));
        }
        return this.mEventListener.onResponseInterceptorToStart(str, treeMap, i);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public byte[] getGlobalMetricsDeltas() {
        return CronetUrlRequestContextJni.get().getHistogramDeltas();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveConnectionType() {
        int i;
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            i = this.mEffectiveConnectionType;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getHttpRttMs() {
        int i;
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            i = this.mHttpRttMs;
            if (i == -1) {
                i = -1;
            }
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getTransportRttMs() {
        int i;
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            i = this.mTransportRttMs;
            if (i == -1) {
                i = -1;
            }
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        int i;
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            i = this.mDownstreamThroughputKbps;
            if (i == -1) {
                i = -1;
            }
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindToNetwork(long j) {
        this.mNetworkHandle = j;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void configureNetworkQualityEstimatorForTesting(boolean z, boolean z2, boolean z3) {
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mLock) {
            checkHaveAdapter();
            CronetUrlRequestContextJni.get().configureNetworkQualityEstimatorForTesting(this.mUrlRequestContextAdapter, this, z, z2, z3);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRttListener(NetworkQualityRttListener networkQualityRttListener) {
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            if (this.mRttListenerList.isEmpty()) {
                synchronized (this.mLock) {
                    checkHaveAdapter();
                    CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, true);
                }
            }
            this.mRttListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(networkQualityRttListener));
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRttListener(NetworkQualityRttListener networkQualityRttListener) {
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            if (this.mRttListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(networkQualityRttListener)) && this.mRttListenerList.isEmpty()) {
                synchronized (this.mLock) {
                    checkHaveAdapter();
                    CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, false);
                }
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            if (this.mThroughputListenerList.isEmpty()) {
                synchronized (this.mLock) {
                    checkHaveAdapter();
                    CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, true);
                }
            }
            this.mThroughputListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(networkQualityThroughputListener));
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            if (this.mThroughputListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(networkQualityThroughputListener)) && this.mThroughputListenerList.isEmpty()) {
                synchronized (this.mLock) {
                    checkHaveAdapter();
                    CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, false);
                }
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
        synchronized (this.mFinishedListenerLock) {
            this.mFinishedListenerMap.put(listener, new VersionSafeCallbacks.RequestFinishedInfoListener(listener));
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener listener) {
        synchronized (this.mFinishedListenerLock) {
            this.mFinishedListenerMap.remove(listener);
        }
    }

    boolean hasRequestFinishedListener() {
        boolean z;
        synchronized (this.mFinishedListenerLock) {
            z = !this.mFinishedListenerMap.isEmpty();
        }
        return z;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL url) {
        return openConnection(url, Proxy.NO_PROXY);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL url, Proxy proxy) {
        return openConnection(url, proxy, false);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL url, Proxy proxy, boolean z) {
        if (proxy.type() != Proxy.Type.DIRECT) {
            throw new UnsupportedOperationException();
        }
        String protocol = url.getProtocol();
        if (ImageDelegate.HTTP_PREFIX.equals(protocol) || "https".equals(protocol)) {
            return new CronetHttpURLConnection(url, this, z);
        }
        throw new UnsupportedOperationException("Unexpected protocol:" + protocol);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new CronetURLStreamHandlerFactory(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onRequestStarted() {
        this.mActiveRequestCount.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onRequestDestroyed() {
        this.mActiveRequestCount.decrementAndGet();
    }

    public long getUrlRequestContextAdapter() {
        long j;
        synchronized (this.mLock) {
            checkHaveAdapter();
            j = this.mUrlRequestContextAdapter;
        }
        return j;
    }

    private void checkHaveAdapter() throws IllegalStateException {
        if (!haveRequestContextAdapter()) {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    private boolean haveRequestContextAdapter() {
        return this.mUrlRequestContextAdapter != 0;
    }

    private int getLoggingLevel() {
        String str = LOG_TAG;
        if (Log.isLoggable(str, 2)) {
            return -2;
        }
        return Log.isLoggable(str, 3) ? -1 : 3;
    }

    private static int convertConnectionTypeToApiValue(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        if (i == 5) {
                            return 5;
                        }
                        throw new RuntimeException("Internal Error: Illegal EffectiveConnectionType value " + i);
                    }
                }
            }
        }
        return i2;
    }

    private void initNetworkThread() {
        this.mNetworkThread = Thread.currentThread();
        this.mInitCompleted.open();
        Thread.currentThread().setName("ChromiumNet" + Process.getThreadPriority(0));
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onCronetBootSucceed();
        }
    }

    private void onEffectiveConnectionTypeChanged(int i) {
        synchronized (this.mNetworkQualityLock) {
            this.mEffectiveConnectionType = i;
            TTEventListener tTEventListener = this.mEventListener;
            if (tTEventListener != null) {
                tTEventListener.onEffectiveConnectionTypeChanged(i);
            }
        }
    }

    private void onRTTOrThroughputEstimatesComputed(int i, int i2, int i3) {
        synchronized (this.mNetworkQualityLock) {
            this.mHttpRttMs = i;
            this.mTransportRttMs = i2;
            this.mDownstreamThroughputKbps = i3;
            TTEventListener tTEventListener = this.mEventListener;
            if (tTEventListener != null) {
                tTEventListener.onRTTOrThroughputEstimatesComputed(i, i2, i3);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long j) {
        synchronized (this.mLock) {
            checkHaveAdapter();
            Log.m282e(LOG_TAG, "Set alog func addr: " + j, new Object[0]);
            CronetUrlRequestContextJni.get().setAlogFuncAddr(this.mUrlRequestContextAdapter, this, j);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, int[]> getGroupRttEstimates() {
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        HashMap hashMap = new HashMap();
        synchronized (this.mNetworkQualityLock) {
            if (this.mWatchingGroups == null) {
                return hashMap;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.mWatchingGroups;
                if (i >= strArr.length) {
                    return hashMap;
                }
                hashMap.put(strArr[i], new int[]{this.mGroupTransportRttMs[i], this.mGroupHttpRttMs[i]});
                i++;
            }
        }
    }

    private void onGroupRTTOrThroughputEstimatesComputed(String[] strArr, int[] iArr, int[] iArr2) {
        synchronized (this.mNetworkQualityLock) {
            this.mWatchingGroups = strArr;
            this.mGroupTransportRttMs = iArr;
            this.mGroupHttpRttMs = iArr2;
        }
    }

    private void onContextInitCompleted(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, String str, String str2) {
        TTCronetInitTimingInfo.sNativeInitTimingJson = str;
        TTCronetInitTimingInfo.sABTest = str2;
        this.mInitCompleted.open();
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onContextInitCompleted(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16);
        }
    }

    private void onThreadIdChanged(int[] iArr) {
        synchronized (this.mThreadTypeIdLock) {
            for (int i = 0; i < iArr.length - 1; i += 2) {
                TTThreadConfigInfoProvider.ThreadType threadType = TTThreadConfigInfoProvider.ThreadType.values()[iArr[i]];
                int i2 = iArr[i + 1];
                this.mThreadTypeIdMap.put(threadType, Integer.valueOf(i2));
                if (this.mThreadTypeBindCoreMap.containsKey(threadType) && this.mThreadConfigCallback != null) {
                    int i3 = C11206.f217xd94db6ea[this.mThreadTypeBindCoreMap.get(threadType).ordinal()];
                    if (i3 == 1) {
                        this.mThreadConfigCallback.bindBigCore(i2);
                    } else if (i3 == 2) {
                        this.mThreadConfigCallback.bindLittleCore(i2);
                    } else if (i3 == 3) {
                        this.mThreadConfigCallback.resetCoreBind(i2);
                    }
                }
            }
        }
    }

    /* renamed from: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext$6 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C11206 {

        /* renamed from: $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore */
        static final /* synthetic */ int[] f217xd94db6ea;

        static {
            int[] iArr = new int[TTThreadConfigInfoProvider.BindCore.values().length];
            f217xd94db6ea = iArr;
            try {
                iArr[TTThreadConfigInfoProvider.BindCore.BIG_CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f217xd94db6ea[TTThreadConfigInfoProvider.BindCore.LITTLE_CORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f217xd94db6ea[TTThreadConfigInfoProvider.BindCore.CANCEL_BIND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void onNQLChanged(int i) {
        synchronized (this.mNetworkQualityLevelLock) {
            this.mNql = i;
            TTEventListener tTEventListener = this.mEventListener;
            if (tTEventListener != null) {
                tTEventListener.onNetworkQualityLevelChanged(i);
            }
        }
    }

    private void onNetworkQualityRttAndThroughputNotified(int i, int i2, int i3) {
        synchronized (this.mNetworkQualityLevelLock) {
            this.mEffectiveHrttMs = i;
            this.mEffectiveTrttMs = i2;
            this.mEffectiveRxThroughputKbps = i3;
            TTEventListener tTEventListener = this.mEventListener;
            if (tTEventListener != null) {
                tTEventListener.onNetworkQualityRttAndThroughputNotified(i, i2, i3);
            }
        }
    }

    private void onPacketLossComputed(int i, double d, double d2, double d3, double d4) {
        synchronized (this.mNetworkQualityLock) {
            if (i != 0 && i != 1) {
                Log.m282e(LOG_TAG, "Error protocol from native. Protocol: " + i, new Object[0]);
                return;
            }
            this.mUpstreamPacketLossRate[i] = d;
            this.mUpstreamPacketLossRateVariance[i] = d2;
            this.mDownstreamPacketLossRate[i] = d3;
            this.mDownstreamPacketLossRateVariance[i] = d4;
            TTEventListener tTEventListener = this.mEventListener;
            if (tTEventListener != null) {
                tTEventListener.onPacketLossComputed(i, d, d2, d3, d4);
            }
        }
    }

    private void onNetworkQualityTypeChangedV3(int i) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onNetworkQualityTypeChangedV3(i);
        }
    }

    private void onUrlDispatchComplete(final URLDispatch uRLDispatch, String str, String str2, String str3, String str4) {
        uRLDispatch.setResult(str, str2, str3, str4);
        uRLDispatch.resume(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.2
            @Override // java.lang.Runnable
            public void run() {
                uRLDispatch.done();
            }
        });
    }

    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider tTAppInfoProvider = this.mAppInfoProvider;
        if (tTAppInfoProvider != null) {
            return tTAppInfoProvider.getAppInfo();
        }
        return null;
    }

    private void onSendAppMonitorEvent(String str, String str2) {
        TTMonitorProvider tTMonitorProvider = this.mAppMonitorProvider;
        if (tTMonitorProvider != null) {
            tTMonitorProvider.sendAppMonitorEvent(str, str2);
        }
    }

    private void onTNCConfigChanged(String str, String str2, String str3) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onServerConfigUpdated(str, str2, str3);
        }
    }

    private void onTNCRequestSucceeded(boolean z, boolean z2, int i) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onTncRequestSucceeded(z, z2, i);
        }
    }

    private void onTTNetDetectInfoChanged(String str) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onTTNetDetectInfoChanged(str);
        }
    }

    private void onTTDnsResolveResult(String str, String str2, int i, int i2, int i3, String[] strArr, String str3) {
        Log.m281d(LOG_TAG, " onTTDnsResolveResult, uuid: " + str + " host: " + str2 + " ret: " + i + " ips: " + strArr.length, new Object[0]);
        ArrayList arrayList = new ArrayList(strArr.length);
        Collections.addAll(arrayList, strArr);
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onTTDnsResolveResult(str, str2, i, i2, i3, arrayList, str3);
        }
    }

    private void onColdStartFinish() {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onColdStartFinish();
        }
    }

    private void onClientIPChanged(String str) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onClientIPChanged(str);
        }
    }

    private void onTLBDecompressFail() {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onTLBDecompressFail();
        }
    }

    private void onPublicIPsChanged(String[] strArr, String[] strArr2) {
        if (this.mEventListener != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            Collections.addAll(arrayList, strArr);
            Collections.addAll(arrayList2, strArr2);
            this.mEventListener.onPublicIPsChanged(arrayList, arrayList2);
        }
    }

    private void onStoreIdcChanged(String str, String str2, String str3, String str4, String str5, String str6) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onStoreIdcChanged(str, str2, str3, str4, str5, str6);
        }
    }

    private void onDropReasonChanged(boolean z, int[] iArr) {
        if (this.mEventListener != null) {
            List<Integer> arrayList = new ArrayList<>();
            if (iArr != null) {
                arrayList = (List) Arrays.stream(iArr).boxed().collect(Collectors.toList());
            }
            this.mEventListener.onDropReasonChanged(z, arrayList);
        }
    }

    private void handleApiResult(boolean z, String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, boolean z2, long j11, long j12, String str4, String str5, String str6, int i, int i2, String str7) {
        TTMonitorProvider tTMonitorProvider = this.mAppMonitorProvider;
        if (tTMonitorProvider != null) {
            tTMonitorProvider.handleApiResult(z, str, str2, str3, j, j2, j3, j4, j5, j6, j7, j8, j9, j10, z2, j11, j12, str4, str5, str6, i, i2, str7);
        }
    }

    private boolean handleApiSample(String str, String str2) {
        TTMonitorProvider tTMonitorProvider = this.mAppMonitorProvider;
        if (tTMonitorProvider != null) {
            return tTMonitorProvider.handleApiSample(str, str2);
        }
        return false;
    }

    private void onTNCUpdateFailed(String[] strArr, String str) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onTNCUpdateFailed(strArr, str);
        }
    }

    private void onWiFiToCellStateChanged(int i, int i2) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onWiFiToCellStateChanged(i, i2);
        }
    }

    private void onMultiNetworkStateChanged(int i, int i2) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onMultiNetworkStateChanged(i, i2);
        }
    }

    private void onUserSpecifiedNetworkEnabled(boolean z) {
        TTEventListener tTEventListener = this.mEventListener;
        if (tTEventListener != null) {
            tTEventListener.onUserSpecifiedNetworkEnabled(z);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void tryStartNetDetect(String[] strArr, int i, int i2) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().tryStartNetDetect(this.mUrlRequestContextAdapter, this, strArr, i, i2);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void ttDnsResolve(String str, int i, String str2, Map<String, String> map) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().ttDnsResolve(this.mUrlRequestContextAdapter, this, str, i, str2, constructControlHeaders(map));
        }
    }

    private String constructControlHeaders(Map<String, String> map) {
        String str = "";
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!key.isEmpty() && !value.isEmpty()) {
                    str = key + Constants.COLON_SEPARATOR + value + "\r\n" + str;
                }
            }
        }
        return str;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setHttpDnsForTesting(boolean z, boolean z2, boolean z3) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().controlHttpDNSConfig(this.mUrlRequestContextAdapter, this, z, z2, z3);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void enableTTBizHttpDns(boolean z, String str, String str2, String str3, boolean z2, String str4) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().enableTTBizHttpDns(this.mUrlRequestContextAdapter, this, z, str, str2, str3, z2, str4);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindBigCore(int i) {
        synchronized (this.mThreadTypeIdLock) {
            if (this.mThreadConfigCallback == null) {
                return;
            }
            TTThreadConfigInfoProvider.ThreadType threadType = TTThreadConfigInfoProvider.ThreadType.values()[i];
            if (this.mThreadTypeIdMap.containsKey(threadType)) {
                this.mThreadConfigCallback.bindBigCore(this.mThreadTypeIdMap.get(threadType).intValue());
            } else {
                this.mThreadTypeBindCoreMap.put(threadType, TTThreadConfigInfoProvider.BindCore.BIG_CORE);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindLittleCore(int i) {
        synchronized (this.mThreadTypeIdLock) {
            if (this.mThreadConfigCallback == null) {
                return;
            }
            TTThreadConfigInfoProvider.ThreadType threadType = TTThreadConfigInfoProvider.ThreadType.values()[i];
            if (this.mThreadTypeIdMap.containsKey(threadType)) {
                this.mThreadConfigCallback.bindLittleCore(this.mThreadTypeIdMap.get(threadType).intValue());
            } else {
                this.mThreadTypeBindCoreMap.put(threadType, TTThreadConfigInfoProvider.BindCore.LITTLE_CORE);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void resetCoreBind(int i) {
        synchronized (this.mThreadTypeIdLock) {
            if (this.mThreadConfigCallback == null) {
                return;
            }
            TTThreadConfigInfoProvider.ThreadType threadType = TTThreadConfigInfoProvider.ThreadType.values()[i];
            if (this.mThreadTypeIdMap.containsKey(threadType)) {
                this.mThreadConfigCallback.resetCoreBind(this.mThreadTypeIdMap.get(threadType).intValue());
            } else {
                this.mThreadTypeBindCoreMap.put(threadType, TTThreadConfigInfoProvider.BindCore.CANCEL_BIND);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void updateStoreRegionFromServer(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        synchronized (this.mLock) {
            try {
                try {
                    CronetUrlRequestContextJni.get().updateStoreRegionFromServer(this.mUrlRequestContextAdapter, this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            for (long j : CronetUrlRequestContextJni.get().getOpaqueFuncAddress()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int i) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().setAppStartUpState(this.mUrlRequestContextAdapter, this, i);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setCookieInitCompleted() {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().setCookieInitCompleted(this.mUrlRequestContextAdapter, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void reportNetDiagnosisUserLog(String str) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().reportNetDiagnosisUserLog(this.mUrlRequestContextAdapter, this, str);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setZstdFuncAddr(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        synchronized (this.mLock) {
            try {
                try {
                    checkHaveAdapter();
                    CronetUrlRequestContextJni.get().setZstdFuncAddr(this.mUrlRequestContextAdapter, this, j, j2, j3, j4, j5, j6, j7, j8);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setRouteSelectionBestHost(String str, String str2) {
        synchronized (this.mLock) {
            CronetUrlRequestContextJni.get().setRouteSelectionBestHost(this.mUrlRequestContextAdapter, this, str, str2);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startThrottle(String[] strArr, int i, long j) {
        synchronized (this.mLock) {
            checkHaveAdapter();
            CronetUrlRequestContextJni.get().startThrottle(this.mUrlRequestContextAdapter, this, strArr, i, j);
        }
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void stopThrottle(String[] strArr, int i) {
        synchronized (this.mLock) {
            checkHaveAdapter();
            CronetUrlRequestContextJni.get().stopThrottle(this.mUrlRequestContextAdapter, this, strArr, i);
        }
    }

    private void onRttObservation(final int i, final long j, final int i2) {
        synchronized (this.mNetworkQualityLock) {
            Iterator<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> it = this.mRttListenerList.iterator();
            while (it.hasNext()) {
                final VersionSafeCallbacks.NetworkQualityRttListenerWrapper next = it.next();
                postObservationTaskToExecutor(next.getExecutor(), new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.3
                    @Override // java.lang.Runnable
                    public void run() {
                        next.onRttObservation(i, j, i2);
                    }
                });
            }
        }
    }

    private void onThroughputObservation(final int i, final long j, final int i2) {
        synchronized (this.mNetworkQualityLock) {
            Iterator<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> it = this.mThroughputListenerList.iterator();
            while (it.hasNext()) {
                final VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper next = it.next();
                postObservationTaskToExecutor(next.getExecutor(), new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.4
                    @Override // java.lang.Runnable
                    public void run() {
                        next.onThroughputObservation(i, j, i2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportRequestFinished(final RequestFinishedInfo requestFinishedInfo) {
        synchronized (this.mFinishedListenerLock) {
            if (this.mFinishedListenerMap.isEmpty()) {
                return;
            }
            Iterator it = new ArrayList(this.mFinishedListenerMap.values()).iterator();
            while (it.hasNext()) {
                final VersionSafeCallbacks.RequestFinishedInfoListener requestFinishedInfoListener = (VersionSafeCallbacks.RequestFinishedInfoListener) it.next();
                postObservationTaskToExecutor(requestFinishedInfoListener.getExecutor(), new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.5
                    @Override // java.lang.Runnable
                    public void run() {
                        requestFinishedInfoListener.onRequestFinished(requestFinishedInfo);
                    }
                });
            }
        }
    }

    private static void postObservationTaskToExecutor(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.m282e(LOG_TAG, "Exception posting task to executor", e);
        }
    }

    public boolean isNetworkThread(Thread thread) {
        return thread == this.mNetworkThread;
    }
}
