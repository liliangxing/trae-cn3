package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    private static final Pattern INVALID_PKP_HOST_NAME = Pattern.compile("^[0-9\\.]*$");
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String JAVA_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.JavaCronetEngine";
    private static final String NATIVE_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.CronetUrlRequestContext";
    private static String TAG;
    private long mALogFuncAddr;
    private TTAppInfoProvider mAppInfoProvider;
    private TTAppInfoProvider.AppInfo mAppInfoSubset;
    private TTMonitorProvider mAppMonitorProvider;
    private int mAppSecurityLevel;
    private final Context mApplicationContext;
    private String mBoeJson;
    private boolean mBoeProxyEnabled;
    private boolean mBrotiEnabled;
    private TTThreadConfigInfoProvider.Callback mCallback;
    private Map<String[], Pair<byte[], byte[]>> mClientOpaqueData;
    private String mCronetSoPath;
    private boolean mDisableCache;
    private TTEventListener mEventListener;
    private String mExperimentalOptions;
    private String mGetDomainDefaultJSON;
    private boolean mHttp2Enabled;
    private long mHttpCacheMaxSize;
    private HttpCacheMode mHttpCacheMode;
    private boolean mHttpDnsEnabled;
    private boolean mIsMainProcess;
    private boolean mLazyInitIPC;
    private boolean mListenAppStateIndependently;
    protected long mMockCertVerifier;
    private boolean mNetworkQualityEstimatorEnabled;
    private ArrayList<byte[]> mOpaqueData;
    private boolean mOptInit;
    private boolean mOptNqeDefault;
    private boolean mOptNqePersist;
    private boolean mOptStack;
    private String mProcessName;
    private String mProxyConfig;
    private boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    private boolean mQuicEnabled;
    private TTSamplingSettingProvider.TTSlaSamplingSetting mSlaSamplingSetting;
    private String mStoragePath;
    private String mStoreIdcRuleJson;
    private long mTTNetInitStart;
    private ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> mThreadConfigInfoList;
    private String mThreadStackInitReason;
    private boolean mTncSecureModeEnabled;
    private String mUserAgent;
    private boolean mVerboseLogEnabled;
    private final List<QuicHint> mQuicHints = new LinkedList();
    private final List<Pkp> mPkps = new LinkedList();
    private int mThreadPriority = 20;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public @interface HttpCacheSetting {
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableSdch(boolean z) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String str, Set set, boolean z, Date date) {
        return addPublicKeyPins(str, (Set<byte[]>) set, z, date);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setClientOpaqueData(Map map) {
        return setClientOpaqueData((Map<String[], Pair<byte[], byte[]>>) map);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOpaqueData(ArrayList arrayList) {
        return setOpaqueData((ArrayList<byte[]>) arrayList);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigInfoList(ArrayList arrayList) {
        return setThreadConfigInfoList((ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo>) arrayList);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class QuicHint {
        final int mAlternatePort;
        final String mHost;
        final int mPort;

        QuicHint(String str, int i, int i2) {
            this.mHost = str;
            this.mPort = i;
            this.mAlternatePort = i2;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Pkp {
        final Date mExpirationDate;
        final byte[][] mHashes;
        final String mHost;
        final boolean mIncludeSubdomains;

        Pkp(String str, byte[][] bArr, boolean z, Date date) {
            this.mHost = str;
            this.mHashes = bArr;
            this.mIncludeSubdomains = z;
            this.mExpirationDate = date;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum HttpCacheMode {
        DISABLED(0, false),
        DISK(1, true),
        DISK_NO_HTTP(1, false),
        MEMORY(2, true);

        private final boolean mContentCacheEnabled;
        private final int mType;

        HttpCacheMode(int i, boolean z) {
            this.mContentCacheEnabled = z;
            this.mType = i;
        }

        int getType() {
            return this.mType;
        }

        boolean isContentCacheEnabled() {
            return this.mContentCacheEnabled;
        }

        int toPublicBuilderCacheMode() {
            int i = C10971.f216xc250b2dc[ordinal()];
            if (i == 1) {
                return 0;
            }
            int i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    if (i == 4) {
                        return 1;
                    }
                    throw new IllegalArgumentException("Unknown internal builder cache mode");
                }
            }
            return i2;
        }

        static HttpCacheMode fromPublicBuilderCacheMode(int i) {
            if (i == 0) {
                return DISABLED;
            }
            if (i == 1) {
                return MEMORY;
            }
            if (i == 2) {
                return DISK_NO_HTTP;
            }
            if (i == 3) {
                return DISK;
            }
            throw new IllegalArgumentException("Unknown public builder cache mode");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C10971 {

        /* renamed from: $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode */
        static final /* synthetic */ int[] f216xc250b2dc;

        static {
            int[] iArr = new int[HttpCacheMode.values().length];
            f216xc250b2dc = iArr;
            try {
                iArr[HttpCacheMode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f216xc250b2dc[HttpCacheMode.DISK_NO_HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f216xc250b2dc[HttpCacheMode.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f216xc250b2dc[HttpCacheMode.MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public CronetEngineBuilderImpl(Context context, boolean z) {
        this.mApplicationContext = context.getApplicationContext();
        enableQuic(true);
        enableHttp2(true);
        enableBrotli(false);
        enableHttpCache(0, 0L);
        enableNetworkQualityEstimator(false);
        enablePublicKeyPinningBypassForLocalTrustAnchors(true);
        enableHttpDns(false);
        listenAppStateIndependently(false);
        if (!z) {
            TAG = "CronetEngineBuilderImpl";
        } else {
            TAG = "CronetEngineBuilderImpl";
        }
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public String getDefaultUserAgent() {
        return UserAgent.from(this.mApplicationContext);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setUserAgent(String str) {
        this.mUserAgent = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserAgent() {
        return this.mUserAgent;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoragePath(String str) {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IllegalArgumentException("create Storage path failed");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.mStoragePath = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String storagePath() {
        return this.mStoragePath;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableQuic(boolean z) {
        this.mQuicEnabled = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean quicEnabled() {
        return this.mQuicEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDefaultQuicUserAgentId() {
        return this.mQuicEnabled ? UserAgent.getQuicUserAgentIdFrom(this.mApplicationContext) : "";
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttp2(boolean z) {
        this.mHttp2Enabled = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean http2Enabled() {
        return this.mHttp2Enabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBrotli(boolean z) {
        this.mBrotiEnabled = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpDns(boolean z) {
        this.mHttpDnsEnabled = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean httpDnsEnabled() {
        return this.mHttpDnsEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl listenAppStateIndependently(boolean z) {
        this.mListenAppStateIndependently = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getListenAppStateIndependently() {
        return this.mListenAppStateIndependently;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableVerboseLog() {
        this.mVerboseLogEnabled = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean verboseLogEnabled() {
        return this.mVerboseLogEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppInfoProvider(TTAppInfoProvider tTAppInfoProvider) {
        this.mAppInfoProvider = tTAppInfoProvider;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTAppInfoProvider getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppMonitorProvider(TTMonitorProvider tTMonitorProvider) {
        this.mAppMonitorProvider = tTMonitorProvider;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTMonitorProvider getAppMonitorProvider() {
        return this.mAppMonitorProvider;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setEventListener(TTEventListener tTEventListener) {
        this.mEventListener = tTEventListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTEventListener getEventListener() {
        return this.mEventListener;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setGetDomainDefaultJSON(String str) {
        this.mGetDomainDefaultJSON = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOpaqueData(ArrayList<byte[]> arrayList) {
        this.mOpaqueData = arrayList;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> map) {
        this.mClientOpaqueData = map;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getGetDomainDefaultJSON() {
        return this.mGetDomainDefaultJSON;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<byte[]> getOpaqueData() {
        return this.mOpaqueData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return this.mClientOpaqueData;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setBypassBOEJSON(String str) {
        this.mBoeJson = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBypassBOEJSON() {
        return this.mBoeJson;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoreIdcRuleJSON(String str) {
        this.mStoreIdcRuleJson = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getStoreIdcRuleJSON() {
        return this.mStoreIdcRuleJson;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProxyConfig(String str) {
        this.mProxyConfig = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getProxyConfig() {
        return this.mProxyConfig;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setCronetSoPath(String str) {
        this.mCronetSoPath = str;
        return this;
    }

    public String getCronetSoPath() {
        return this.mCronetSoPath;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBoeProxy(boolean z) {
        this.mBoeProxyEnabled = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean boeProxyEnabled() {
        return this.mBoeProxyEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableTncSecureMode(boolean z) {
        this.mTncSecureModeEnabled = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tncSecureModeEnabled() {
        return this.mTncSecureModeEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setALogFuncAddr(long j) {
        this.mALogFuncAddr = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aLogFuncAddr() {
        return this.mALogFuncAddr;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppSecurityLevel(int i) {
        this.mAppSecurityLevel = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAppSecurityLevel() {
        return this.mAppSecurityLevel;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setIsMainProcess(boolean z) {
        this.mIsMainProcess = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLazyInitIPC(boolean z) {
        this.mLazyInitIPC = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean lazyInitIPC() {
        return this.mLazyInitIPC;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProcessName(String str) {
        this.mProcessName = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String processName() {
        return this.mProcessName;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo appInfo) {
        this.mAppInfoSubset = appInfo;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTAppInfoProvider.AppInfo TTAppInfoSubset() {
        return this.mAppInfoSubset;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOptInit(boolean z) {
        this.mOptInit = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean optInit() {
        return this.mOptInit;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOptNqeInit(boolean z, boolean z2) {
        this.mOptNqeDefault = z;
        this.mOptNqePersist = z2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean optNqeDefault() {
        return this.mOptNqeDefault;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean optNqePersist() {
        return this.mOptNqePersist;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTTNetInitStart(long j) {
        this.mTTNetInitStart = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ttnetInitStart() {
        return this.mTTNetInitStart;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> arrayList) {
        this.mThreadConfigInfoList = arrayList;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> threadConfigInfoList() {
        return this.mThreadConfigInfoList;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback callback) {
        this.mCallback = callback;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTThreadConfigInfoProvider.Callback threadConfigCallbackImpl() {
        return this.mCallback;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting tTSlaSamplingSetting) {
        this.mSlaSamplingSetting = tTSlaSamplingSetting;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTSamplingSettingProvider.TTSlaSamplingSetting samplingSetting() {
        return this.mSlaSamplingSetting;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStackInfo(boolean z, String str) {
        this.mOptStack = z;
        this.mThreadStackInitReason = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean optStack() {
        return this.mOptStack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String threadStackInitReason() {
        return this.mThreadStackInitReason;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean brotliEnabled() {
        return this.mBrotiEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpCache(int i, long j) {
        HttpCacheMode fromPublicBuilderCacheMode = HttpCacheMode.fromPublicBuilderCacheMode(i);
        if (fromPublicBuilderCacheMode.getType() == 1 && storagePath() == null) {
            throw new IllegalArgumentException("Storage path must be set");
        }
        this.mHttpCacheMode = fromPublicBuilderCacheMode;
        this.mHttpCacheMaxSize = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cacheDisabled() {
        return !this.mHttpCacheMode.isContentCacheEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long httpCacheMaxSize() {
        return this.mHttpCacheMaxSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int httpCacheMode() {
        return this.mHttpCacheMode.getType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int publicBuilderHttpCacheMode() {
        return this.mHttpCacheMode.toPublicBuilderCacheMode();
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addQuicHint(String str, int i, int i2) {
        if (str.contains("/")) {
            throw new IllegalArgumentException("Illegal QUIC Hint Host: " + str);
        }
        this.mQuicHints.add(new QuicHint(str, i, i2));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<QuicHint> quicHints() {
        return this.mQuicHints;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addPublicKeyPins(String str, Set<byte[]> set, boolean z, Date date) {
        if (str == null) {
            throw new NullPointerException("The hostname cannot be null");
        }
        if (set == null) {
            throw new NullPointerException("The set of SHA256 pins cannot be null");
        }
        if (date == null) {
            throw new NullPointerException("The pin expiration date cannot be null");
        }
        String validateHostNameForPinningAndConvert = validateHostNameForPinningAndConvert(str);
        HashMap hashMap = new HashMap();
        for (byte[] bArr : set) {
            if (bArr == null || bArr.length != 32) {
                throw new IllegalArgumentException("Public key pin is invalid");
            }
            hashMap.put(Base64.encodeToString(bArr, 0), bArr);
        }
        this.mPkps.add(new Pkp(validateHostNameForPinningAndConvert, (byte[][]) hashMap.values().toArray(new byte[hashMap.size()]), z, date));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Pkp> publicKeyPins() {
        return this.mPkps;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z) {
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean publicKeyPinningBypassForLocalTrustAnchorsEnabled() {
        return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    }

    private static String validateHostNameForPinningAndConvert(String str) throws IllegalArgumentException {
        boolean z;
        try {
            z = INVALID_PKP_HOST_NAME.matcher(str).matches();
        } catch (IllegalArgumentException unused) {
            z = false;
        }
        if (z) {
            throw new IllegalArgumentException("Hostname " + str + " is illegal. A hostname should not consist of digits and/or dots only.");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("Hostname " + str + " is too long. The name of the host does not comply with RFC 1122 and RFC 1123.");
        }
        try {
            return IDN.toASCII(str, 2);
        } catch (IllegalArgumentException unused2) {
            throw new IllegalArgumentException("Hostname " + str + " is illegal. The name of the host does not comply with RFC 1122 and RFC 1123.");
        }
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setExperimentalOptions(String str) {
        this.mExperimentalOptions = str;
        return this;
    }

    public String experimentalOptions() {
        return this.mExperimentalOptions;
    }

    public CronetEngineBuilderImpl setMockCertVerifierForTesting(long j) {
        this.mMockCertVerifier = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long mockCertVerifier() {
        return this.mMockCertVerifier;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean networkQualityEstimatorEnabled() {
        return this.mNetworkQualityEstimatorEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableNetworkQualityEstimator(boolean z) {
        this.mNetworkQualityEstimatorEnabled = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadPriority(int i) {
        if (i > 19 || i < -20) {
            throw new IllegalArgumentException("Thread priority invalid");
        }
        this.mThreadPriority = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int threadPriority(int i) {
        int i2 = this.mThreadPriority;
        return i2 == 20 ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mApplicationContext;
    }
}
