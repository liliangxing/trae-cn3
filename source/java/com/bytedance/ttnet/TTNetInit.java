package com.bytedance.ttnet;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.frameworks.baselib.network.LifeCycleMonitor;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTask;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.frameworks.baselib.network.http.impl.PersistentCookieStore;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterStateListener;
import com.bytedance.frameworks.baselib.network.utils.ReflectWrap;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.retrofit2.AppActivityResumeSuspendRecorder;
import com.bytedance.retrofit2.AppLaunchTimeStampProvider;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.config.SDKConfig;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import com.bytedance.ttnet.debug.DebugMode;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.httpdns.TTDnsOuterService;
import com.bytedance.ttnet.httpdns.TTDnsResult;
import com.bytedance.ttnet.okhttp.OkHttpAppInfoProvider;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import com.bytedance.ttnet.utils.TtnetUtil;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.File;
import java.net.CookieHandler;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTNetInit {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DOMAIN_BOE_HTTPS_KEY = "boe_https";
    public static final String DOMAIN_BOE_KEY = "boe";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";

    @Deprecated
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static final String ENCRYPT_RETRY_HEADER = "x-ttnet-retry-encrypt";
    public static final String ENCRYPT_RETRY_VERIFY_HEADER = "x-tt-e-ignore-status-code-verify";
    private static final int INIT_TIMEOUT_VALUE = 5;
    private static final String OKHTTP_DISPATCH_FAILED = "okhttp dispatch failed.";
    private static final String RETURN_WRONG_FORMAT = "Conversion = 'ttUrlDispatch returns wrong format'";
    private static final String TAG = "TTNetInit";
    private static final String TTNET_CRONET_NOT_INITIALIZED = "cronet not init.";
    private static volatile ENV env = null;
    private static volatile String sClientIPString = null;
    private static long sCookieManagerInitStartTime = 0;
    public static ICronetAppProvider sCronetProvider = null;
    private static volatile int sDelayTime = 10;
    public static Map<String, String> sGetDomainRegionMap;
    private static ITTNetDepend sITTNetDepend;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;
    public static JSONObject sSlaSamplingSettingObject;
    private static ITTSystemApiSandbox sSystemApiSandbox;
    private static TTNetThreadConfigInfoManager sTTNetThreadConfigInfoManager;
    private static volatile CountDownLatch sLatchInitCompleted = new CountDownLatch(1);
    private static volatile boolean sApiHttpInterceptEnabled = false;
    private static volatile boolean sCookieLogReportEnabled = false;
    private static volatile boolean sListenAppStateIndependently = false;
    private static volatile boolean sStateDelayNewStrategyEnabled = false;
    private static volatile boolean sMainThreadInitCookieEnabled = true;
    private static volatile long sMaxHttpDiskCacheSize = 67108864;
    private static volatile int sAppSecurityLevel = 0;
    public static LifeCycleMonitor sLifeCycleMonitor = new LifeCycleMonitor();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum ENV {
        DEBUG,
        RELEASE
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface RetryEncryptRequestCallback {
        void onCallToRetryEncryptRequestByHeader(String str, List<Header> list, Map<String, List<String>> map);
    }

    @Deprecated
    public static void doCommand(Context context, String str) {
    }

    @Deprecated
    public static void setALogFuncAddr(long j) throws Exception {
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean z) throws Exception {
    }

    public static void setFirstRequestWaitTime(long j) {
    }

    public static void setHttpDnsForTesting(boolean z, boolean z2, boolean z3) throws Exception {
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    static {
        TTALog.init();
        env = ENV.RELEASE;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
        sCookieManagerInitStartTime = 0L;
    }

    public static ENV getEnv() {
        return env;
    }

    public static void setEnv(ENV env2) {
        env = env2;
    }

    public static void setListenAppStateIndependently(boolean z) {
        sListenAppStateIndependently = z;
    }

    public static boolean getListenAppStateIndependently() {
        return sListenAppStateIndependently;
    }

    public static void setMaxHttpDiskCacheSize(long j) {
        if (j > 0) {
            sMaxHttpDiskCacheSize = j;
        }
    }

    public static long getMaxHttpDiskCacheSize() {
        return sMaxHttpDiskCacheSize;
    }

    public static void setAppSecurityLevel(int i) {
        sAppSecurityLevel = i;
    }

    public static int getAppSecurityLevel() {
        return sAppSecurityLevel;
    }

    public static void setTTNetDepend(ITTNetDepend iTTNetDepend) {
        sITTNetDepend = iTTNetDepend;
        Map<String, String> tTNetServiceDomainMap = getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(tTNetServiceDomainMap.get(DOMAIN_HTTPDNS_KEY)) || (TextUtils.isEmpty(tTNetServiceDomainMap.get(DOMAIN_BOE_KEY)) && TextUtils.isEmpty(tTNetServiceDomainMap.get(DOMAIN_BOE_HTTPS_KEY)))) {
            sITTNetDepend = null;
            throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
        }
        Object obj = sITTNetDepend;
        if ((obj instanceof AbsOptionalTTNetDepend) && !((AbsOptionalTTNetDepend) obj).isPrivacyAccessEnabled()) {
            setAppSecurityLevel(sAppSecurityLevel | 1);
        }
        ITTNetDepend iTTNetDepend2 = sITTNetDepend;
        if (iTTNetDepend2 instanceof AppLaunchTimeStampProvider) {
            RetrofitMetrics.sAppStartTimeProvider = (AppLaunchTimeStampProvider) iTTNetDepend2;
        }
        HttpRequestInfo.injectCreate();
        BoeUtils.setBoeSuffix(tTNetServiceDomainMap.get(DOMAIN_BOE_KEY));
        BoeUtils.setBoeHttpsSuffix(tTNetServiceDomainMap.get(DOMAIN_BOE_HTTPS_KEY));
        OkHttpAppInfoProvider.inst().setTTNetDepend(iTTNetDepend);
    }

    public static void setTTNetThreadConfigInfoManager(TTNetThreadConfigInfoManager tTNetThreadConfigInfoManager) {
        sTTNetThreadConfigInfoManager = tTNetThreadConfigInfoManager;
    }

    public static List<TTNetThreadConfig> getThreadConfigInfoList() {
        TTNetThreadConfigInfoManager tTNetThreadConfigInfoManager = sTTNetThreadConfigInfoManager;
        if (tTNetThreadConfigInfoManager == null) {
            return null;
        }
        return tTNetThreadConfigInfoManager.getThreadConfigInfoList();
    }

    public static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        TTNetThreadConfigInfoManager tTNetThreadConfigInfoManager = sTTNetThreadConfigInfoManager;
        if (tTNetThreadConfigInfoManager == null) {
            return null;
        }
        return tTNetThreadConfigInfoManager.getThreadConfigCallbackImpl();
    }

    public static ITTNetDepend getTTNetDepend() {
        ITTNetDepend iTTNetDepend = sITTNetDepend;
        if (iTTNetDepend != null) {
            return iTTNetDepend;
        }
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static void setCronetDepend(ICronetAppProvider iCronetAppProvider) {
        if (iCronetAppProvider == null) {
            throw new IllegalArgumentException("cronetDepend is null");
        }
        sCronetProvider = iCronetAppProvider;
        TNCManager.initStoreRegionModule(iCronetAppProvider);
        OkHttpAppInfoProvider.inst().setCronetProvider(iCronetAppProvider);
        SsCronetHttpClient.setCronetAppInfoProvider(iCronetAppProvider);
        SsOkHttp3Client.injectAppInfoProvider(OkHttpAppInfoProvider.inst());
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static void setSystemApiSandbox(ITTSystemApiSandbox iTTSystemApiSandbox) {
        sSystemApiSandbox = iTTSystemApiSandbox;
    }

    public static ITTSystemApiSandbox getSystemApiSandbox() {
        return sSystemApiSandbox;
    }

    public static void setGetDomainRegionMap(Map<String, String> map) {
        if (map == null) {
            throw new IllegalArgumentException("getDomainRegionMap is null");
        }
        sGetDomainRegionMap = map;
    }

    public static String getGetDomainConfigByRegion(String str) {
        Map<String, String> map = sGetDomainRegionMap;
        if (map == null || map.isEmpty() || sCronetProvider == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return sGetDomainRegionMap.get(str.toLowerCase());
    }

    public static void setSlaSamplingSetting(Context context, JSONObject jSONObject) {
        try {
            if (Logger.debug()) {
                Logger.d(TAG, "setSlaSamplingSetting");
            }
            SsCronetHttpClient.inst(context).setSlaSamplingSetting(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            sSlaSamplingSettingObject = jSONObject;
        }
    }

    public static JSONObject getSlaSamplingSetting() {
        return sSlaSamplingSettingObject;
    }

    public static void enableCookieLogReport(boolean z) {
        sCookieLogReportEnabled = z;
    }

    public static void setStateDelayNewStrategyEnabled(boolean z) {
        sStateDelayNewStrategyEnabled = z;
    }

    public static boolean getStateDelayNewStrategyEnabled() {
        return sStateDelayNewStrategyEnabled;
    }

    public static boolean cookieLogReportEnabled() {
        return sCookieLogReportEnabled;
    }

    public static void getInitCompletedLatch() {
        try {
            sLatchInitCompleted.await(5L, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void countDownInitCompletedLatch() {
        try {
            if (sLatchInitCompleted.getCount() > 0) {
                sLatchInitCompleted.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ttnet.TTNetInit$2] */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.bytedance.ttnet.TTNetInit$1] */
    public static void tryInitTTNet(final Context context, Application application, NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook, NetworkParams.MonitorProcessHook<HttpRequestInfo> monitorProcessHook, NetworkParams.CommandListener commandListener, final boolean z, boolean... zArr) {
        TTNetInitMetrics.inst().initTTNetStartTime = System.currentTimeMillis();
        TTNetInitMetrics.inst().initTTNetStart = System.nanoTime();
        if (context == null) {
            throw new IllegalArgumentException("tryInitTTNet context is null");
        }
        SDKConfig.registerSdk();
        DebugMode.openIfDebug(context);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
        NetworkParams.setApiProcessHook(apiProcessHook);
        HttpRequestInfo.injectCreate();
        KevaBuilder.getInstance().setContext(context);
        boolean z2 = (zArr == null || zArr.length <= 0) ? false : zArr[0];
        boolean isMainProcessByProcessFlag = ProcessUtils.isMainProcessByProcessFlag(context);
        if (isMainProcessByProcessFlag) {
            new ThreadPlus("NetWork-AsyncInit") { // from class: com.bytedance.ttnet.TTNetInit.1
                public void run() {
                    if (Logger.debug()) {
                        Logger.d(TTNetInit.TAG, "throttle control use new logic " + TTNetInit.sStateDelayNewStrategyEnabled);
                    }
                    if (TTNetInit.sStateDelayNewStrategyEnabled) {
                        SsHttpCall.setThrottleControl(TTHttpCallPriorityControl.getInstance());
                    } else {
                        SsHttpCall.setThrottleControl(TTHttpCallThrottleControl.getInstance());
                    }
                    AppConfig.getInstance(context).tryLoadLocalConfig();
                    AppConfig.getInstance(context).tryRefreshConfig(TNCManager.TNCUpdateSource.TTSERVER, true);
                    TTNetInit.tryInitCookieManager(context, z, true);
                }
            }.start();
        } else {
            final boolean z3 = z2 || ProcessUtils.isMessageProcess(context);
            new ThreadPlus("NetWork-AsyncInit-other") { // from class: com.bytedance.ttnet.TTNetInit.2
                public void run() {
                    AppConfig.getInstance(context).tryLoadLocalConfig();
                    AppConfig.getInstance(context).tryRefreshConfig(TNCManager.TNCUpdateSource.TTSERVER, true);
                    if (z3) {
                        TTNetInit.tryInitCookieManager(context, z, false);
                    } else {
                        NetworkParams.setCookieMgrInited(true);
                        TTNetInit.setCookieInitCompleted();
                    }
                }
            }.start();
        }
        TNCRequestFlagHandler.getInstance();
        TNCManager.getInstance().initTnc(context, isMainProcessByProcessFlag);
        URLDispatcher.inst().setContext(context);
        AppConfig.getInstance(context);
        TTNetInitMetrics.inst().initMSSdkFromTTNet(context);
        NetworkParams.setMonitorProcessHook(monitorProcessHook);
        countDownInitCompletedLatch();
        if (!isMainProcessByProcessFlag) {
            TTNetInitMetrics.inst().isMainProcess = false;
            TTNetInitMetrics.inst().initTTNetEnd = System.nanoTime();
            return;
        }
        NetworkParams.setCommandListener(commandListener);
        if (RequestTicketUtil.getRequestTicketProcessor() == null) {
            RequestTicketUtil.setRequestTicketProcessor(new RequestTicketUtil.IRequestTicketProcessor() { // from class: com.bytedance.ttnet.TTNetInit.3
                @Override // com.bytedance.ttnet.utils.RequestTicketUtil.IRequestTicketProcessor
                public void checkReqTicket(String str, String str2, String str3, HttpRequestInfo httpRequestInfo) {
                }

                @Override // com.bytedance.ttnet.utils.RequestTicketUtil.IRequestTicketProcessor
                public void sendSetCookieEvent(String str, String str2, int i, boolean z4, JSONObject jSONObject) {
                    int i2 = z4 ? 1 : 0;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", str2);
                        jSONObject2.put("value", i);
                        jSONObject2.put("ext_value", i2);
                        jSONObject2.put("extraObject", jSONObject);
                        TTNetInit.getTTNetDepend().mobOnEvent(context, "set_cookie", str, jSONObject2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
        sLifeCycleMonitor.addListener(QueryFilterStateListener.getInstance());
        if (application != null) {
            application.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
        }
        if (!HttpClient.isCronetClientEnable()) {
            Log.d(TAG, "cronet disable");
            notifyColdStartFinish();
        }
        TTNetInitMetrics.inst().initTTNetEnd = System.nanoTime();
    }

    public static void setMonitorProcessHookV2(NetworkParams.MonitorProcessHookV2<HttpRequestInfo> monitorProcessHookV2) {
        NetworkParams.setMonitorProcessHookV2(monitorProcessHookV2);
    }

    public static void notifyColdStartFinish() {
        if (sITTNetDepend == null || sNotifiedColdStartFinsish) {
            return;
        }
        sNotifiedColdStartFinsish = true;
        sITTNetDepend.onColdStartFinish();
    }

    public static void onClientIPChanged(String str) {
        if (str != null) {
            sClientIPString = str;
        }
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    public static void onPublicIPsChanged(List<String> list, List<String> list2) {
        sPublicIPv4List = list;
        sPublicIPv6List = list2;
    }

    public static void setRetryEncryptedRequestEnabled(final RetryEncryptRequestCallback retryEncryptRequestCallback) {
        NetworkParams.addRetryRequestByHeaderCallback(ENCRYPT_RETRY_VERIFY_HEADER, new NetworkParams.RetryRequestByHeaderCallbackV2() { // from class: com.bytedance.ttnet.TTNetInit.4
            public RequestRetryResult onCallToRetryRequestByHeader(Map<String, List<String>> map) {
                return null;
            }

            public RequestRetryResult onCallToRetryRequestByHeader(String str, List<Header> list, Map<String, List<String>> map) {
                RequestRetryResult requestRetryResult = new RequestRetryResult(false, false, (Map) null);
                try {
                    List<String> list2 = map.get(TTNetInit.ENCRYPT_RETRY_VERIFY_HEADER);
                    if (list2 != null && !list2.isEmpty()) {
                        String str2 = list2.get(0);
                        if (!StringUtils.isEmpty(str2) && str2.startsWith("2")) {
                            RetryEncryptRequestCallback retryEncryptRequestCallback2 = RetryEncryptRequestCallback.this;
                            if (retryEncryptRequestCallback2 != null) {
                                retryEncryptRequestCallback2.onCallToRetryEncryptRequestByHeader(str, list, map);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put(TTNetInit.ENCRYPT_RETRY_HEADER, str2);
                            return new RequestRetryResult(true, false, hashMap);
                        }
                    }
                    return requestRetryResult;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return requestRetryResult;
                }
            }
        });
    }

    public static List<String> getPublicIPv4List() {
        return sPublicIPv4List;
    }

    public static List<String> getPublicIPv6List() {
        return sPublicIPv6List;
    }

    public static void setCookieHandler(final Context context) {
        CookieManager cookieManager;
        try {
            CookieHandler cookieHandler = CookieHandler.getDefault();
            if (cookieHandler != null && (cookieHandler instanceof SSCookieHandler)) {
                NetworkParams.setCookieMgrInited(true);
                setCookieInitCompleted();
                return;
            }
            if (sCookieManagerInitStartTime <= 0) {
                NetworkParams.setCookieMgrInited(true);
                setCookieInitCompleted();
                return;
            }
            if (TTNetInitMetrics.inst().initCookieManagerStart == 0) {
                TTNetInitMetrics.inst().initCookieManagerStart = System.nanoTime();
            }
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Throwable th) {
                sDelayTime = 0;
                CookieInitFailedReport(context, th.getMessage());
                cookieManager = null;
            }
            CookieHandler.setDefault(new SSCookieHandler(context, sDelayTime, cookieManager, getTTNetDepend().getCookieFlushPathList(), new SSCookieHandler.ICookieEventHandler() { // from class: com.bytedance.ttnet.TTNetInit.5
                public void onEvent(String str, String str2, JSONObject jSONObject) {
                    if (TTNetInit.cookieLogReportEnabled()) {
                        TTNetInit.getTTNetDepend().mobOnEvent(context, str, str2, jSONObject);
                    }
                }

                public boolean enableSetCookieLog() {
                    return TTNetInit.cookieLogReportEnabled();
                }
            }));
            NetworkParams.setCookieMgrInited(true);
            setCookieInitCompleted();
            TTNetInitMetrics.inst().initCookieManagerEnd = System.nanoTime();
        } catch (Throwable th2) {
            CookieInitFailedReport(context, th2.getMessage());
            th2.printStackTrace();
        }
    }

    public static void trySetDefaultUserAgent(String str) {
        NetworkParams.setDefaultUserAgent(str);
    }

    public static void setMainThreadInitCookieEnabled(boolean z) {
        sMainThreadInitCookieEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tryInitCookieManager(final Context context, final boolean z, final boolean z2) {
        if (Logger.debug()) {
            Logger.d(TAG, "tryInitCookieManager needSetCookieHandler:" + z + ", isMain:" + z2);
        }
        try {
            sCookieManagerInitStartTime = System.currentTimeMillis();
            if (z) {
                if (TTNetInitMetrics.inst().initCookieManagerStart == 0) {
                    TTNetInitMetrics.inst().initCookieManagerStart = System.nanoTime();
                }
                CookieSyncManager.createInstance(context);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                setCookieHandler(context);
                if (Logger.debug()) {
                    Logger.d("Process", " CookieManager = " + cookieManager.toString() + " pid = " + Process.myPid());
                }
            } else {
                NetworkParams.setCookieMgrInited(true);
                setCookieInitCompleted();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (ProcessUtils.isMainProcessByProcessFlag(context) && Thread.currentThread() != Looper.getMainLooper().getThread()) {
                if (sMainThreadInitCookieEnabled) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ttnet.TTNetInit.6
                        @Override // java.lang.Runnable
                        public void run() {
                            TTNetInit.tryInitCookieManager(context, z, z2);
                        }
                    });
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error", th.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ITTNetDepend iTTNetDepend = sITTNetDepend;
                if (iTTNetDepend != null) {
                    iTTNetDepend.monitorLogSend("async_init_cookie_manager_fail", jSONObject);
                }
                CookieInitFailedReport(context, th.getMessage());
            }
        }
        ClientKeyManager.inst().InitClientKeyAndSessionInfo(z2);
    }

    private static void CookieInitFailedReport(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.PARAM_SOURCE_INIT, CDNLoader.PIPELINE_STATUS_FAILED);
            jSONObject.put("exception", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getTTNetDepend().mobOnEvent(context, "TTNET-COOKIE", EventConstants.PARAM_SOURCE_INIT, jSONObject);
    }

    public static void useCustomizedCookieStoreName() {
        PersistentCookieStore.useCustomizedCookieStoreName();
    }

    public static void triggerGetDomain(Context context, boolean z) {
        SsCronetHttpClient.inst(context).triggerGetDomain(z);
    }

    public static void trigerGetDomain(Context context) {
        triggerGetDomain(context, false);
    }

    public static void runInBackGround(Context context, boolean z) {
        SsCronetHttpClient.inst(context).runInBackGround(z);
    }

    public static void addClientOpaqueData(Context context, String[] strArr, byte[] bArr, byte[] bArr2, long j, long j2) {
        SsCronetHttpClient.inst(context).addClientOpaqueData(strArr, bArr, bArr2, j, j2, false);
    }

    public static void addClientOpaqueData(Context context, String[] strArr, byte[] bArr, byte[] bArr2) {
        SsCronetHttpClient.inst(context).addClientOpaqueData(strArr, bArr, bArr2, 0L, 0L, false);
    }

    public static void clearClientOpaqueData(Context context) {
        SsCronetHttpClient.inst(context).clearClientOpaqueData(false);
    }

    public static void removeClientOpaqueData(Context context, String str) {
        SsCronetHttpClient.inst(context).removeClientOpaqueData(str, false);
    }

    public static void addClientOpaqueDataV1(Context context, String[] strArr, byte[] bArr, byte[] bArr2, long j, long j2) {
        SsCronetHttpClient.inst(context).addClientOpaqueData(strArr, bArr, bArr2, j, j2, true);
    }

    public static void addClientOpaqueDataV1(Context context, String[] strArr, byte[] bArr, byte[] bArr2) {
        SsCronetHttpClient.inst(context).addClientOpaqueData(strArr, bArr, bArr2, 0L, 0L, true);
    }

    public static void clearClientOpaqueDataV1(Context context) {
        SsCronetHttpClient.inst(context).clearClientOpaqueData(true);
    }

    public static void removeClientOpaqueDataV1(Context context, String str) {
        SsCronetHttpClient.inst(context).removeClientOpaqueData(str, true);
    }

    public static void setProxy(String str) throws Exception {
        if (TTNetInitMetrics.isCronetInitSuccess()) {
            SsCronetHttpClient.inst(getTTNetDepend().getContext()).setProxy(str);
        } else {
            SsOkHttp3Client.inst(getTTNetDepend().getContext());
            SsOkHttp3Client.setProxy(str);
        }
    }

    @Deprecated
    public static List<InetAddress> dnsLookup(String str) throws Exception {
        if (!TTNetInitMetrics.isCronetInitSuccess()) {
            throw new IllegalStateException("Cronet engine has not been initialized and completed.");
        }
        TTDnsResult TTDnsResolve = TTDnsResolve(str, 0);
        if (TTDnsResolve.ret != 0 || TTDnsResolve.iplist == null || TTDnsResolve.iplist.isEmpty()) {
            throw new UnknownHostException(str);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = TTDnsResolve.iplist.iterator();
        while (it.hasNext()) {
            byte[] address = InetAddress.getByName(it.next()).getAddress();
            if (address != null) {
                arrayList.add(InetAddress.getByAddress(str, address));
            }
        }
        if (arrayList.isEmpty()) {
            throw new UnknownHostException(str);
        }
        return arrayList;
    }

    public static NetworkQuality getNetworkQuality() throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getNetworkQuality();
    }

    public static PacketLossMetrics getPacketLossRateMetrics(int i) throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getPacketLossRateMetrics(i);
    }

    public static Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getGroupRttEstimates();
    }

    public static void preInitCronetKernel() throws Exception {
        int i = -1;
        try {
            if (getCronetHttpClient(TTNetInitMetrics.CronetInitMode.PRE_INIT) == null) {
                i = SsOkHttp3Client.getFallbackReason();
                feedBackCronetInitFailedLog(i, "");
            }
        } catch (Throwable th) {
            if (th instanceof IllegalArgumentException) {
                i = 3;
            }
            String outputThrowableStackTrace = TtnetUtil.outputThrowableStackTrace(th);
            if (outputThrowableStackTrace.length() > 1024) {
                outputThrowableStackTrace = outputThrowableStackTrace.substring(0, 1024);
            }
            feedBackCronetInitFailedLog(i, outputThrowableStackTrace);
            TNCManager.getInstance().handleCronetInitFailed();
            throw th;
        }
    }

    private static void feedBackCronetInitFailedLog(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fallback", i);
            jSONObject.put("exception", str);
            jSONObject.put("model", Build.MODEL);
            String str2 = "";
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr != null && strArr.length > 0) {
                str2 = Arrays.asList(strArr).toString();
            }
            jSONObject.put("abis", str2);
            getTTNetDepend().monitorLogSend("cronet_failed", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static void forceInitCronetKernel() throws Exception {
        if (TTNetInitMetrics.inst().mode == TTNetInitMetrics.CronetInitMode.NONE) {
            TTNetInitMetrics.inst().mode = TTNetInitMetrics.CronetInitMode.FORCE_INIT;
        }
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).tryCreateCronetEngine(false, false, false, AppConfig.getInstance(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), true, sCronetProvider);
    }

    @Deprecated
    public static void setHostResolverRulesForTesting(String str) throws Exception {
        SsCronetHttpClient cronetHttpClient = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.DEPRECATED_API);
        if (cronetHttpClient != null) {
            cronetHttpClient.setHostResolverRules(str);
        }
    }

    public static boolean tryStartTTNetDetect(String[] strArr, int i, int i2) {
        if (strArr != null && strArr.length > 0 && i > 0 && i <= 180 && i2 >= 0) {
            try {
                SsCronetHttpClient.inst(getTTNetDepend().getContext()).tryStartNetDetect(strArr, i, i2);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static TTDnsResult TTDnsResolve(String str, int i) throws Exception {
        return TTDnsResolve(str, i, null);
    }

    public static TTDnsResult TTDnsResolve(String str, int i, Map<String, String> map) throws Exception {
        if (!TTNetInitMetrics.isCronetInitSuccess()) {
            throw new IllegalStateException("Cronet engine has not been initialized and completed.");
        }
        return TTDnsOuterService.getInstance().TTDnsResolve(str, i, map);
    }

    public static void getMappingRequestState(String str) {
        try {
            SsCronetHttpClient.inst(getTTNetDepend().getContext()).getMappingRequestState(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setDelayTime(int i) {
        sDelayTime = i;
    }

    public static void setBypassOfflineCheck(boolean z) {
        SsCronetHttpClient.setBypassOfflineCheck(z);
    }

    @Deprecated
    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static void enableApiHttpIntercept(boolean z) {
        sApiHttpInterceptEnabled = z;
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static void monitorLogSend(String str, JSONObject jSONObject) {
        ITTNetDepend iTTNetDepend = sITTNetDepend;
        if (iTTNetDepend != null) {
            iTTNetDepend.monitorLogSend(str, jSONObject);
        }
    }

    private static SsCronetHttpClient getCronetHttpClient(TTNetInitMetrics.CronetInitMode cronetInitMode) throws Exception {
        if (TTNetInitMetrics.inst().mode == TTNetInitMetrics.CronetInitMode.NONE) {
            TTNetInitMetrics.inst().mode = cronetInitMode;
        }
        if (!HttpClient.isCronetClientEnable()) {
            return null;
        }
        SsCronetHttpClient inst = SsCronetHttpClient.inst(getTTNetDepend().getContext());
        inst.tryCreateCronetEngine(false, true, false, AppConfig.getInstance(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), false, sCronetProvider);
        sSlaSamplingSettingObject = null;
        return inst;
    }

    public static void enableTTBizHttpDns(boolean z, String str, String str2, String str3, boolean z2, String str4) {
        if (z && (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3))) {
            return;
        }
        try {
            SsCronetHttpClient cronetHttpClient = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.BIZ_HTTPDNS_API);
            if (cronetHttpClient != null) {
                cronetHttpClient.enableTTBizHttpDns(z, str, str2, str3, z2, str4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int getEffectiveConnectionType() {
        try {
            return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getEffectiveConnectionType();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static TTDispatchResult ttUrlDispatch(String str) throws Exception {
        return ttUrlDispatchInternal(str, -1, true);
    }

    private static TTDispatchResult ttUrlDispatchInternal(String str, int i, boolean z) throws Exception {
        if (!AppConfig.getInstance(getTTNetDepend().getContext()).isChromiumOpen()) {
            DispatchResult dispatchResultForUrl = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(str, (String) null, (List) null));
            if (dispatchResultForUrl == null) {
                throw new IllegalArgumentException(OKHTTP_DISPATCH_FAILED);
            }
            return new TTDispatchResult(str, dispatchResultForUrl.mDispatchedURL, String.valueOf(URLDispatcher.inst().getEpoch()), URLDispatcher.inst().getTncEtag(), TTDispatchResult.DispatchState.SUCCESS, "");
        }
        if (!TTNetInitMetrics.isCronetInitSuccess()) {
            throw new IllegalStateException(TTNET_CRONET_NOT_INITIALIZED);
        }
        try {
            new URL(str).toURI();
            return SsCronetHttpClient.ttUrlDispatch(str, i, z);
        } catch (Exception e) {
            throw e;
        }
    }

    public static TTDispatchResult ttUrlDispatchV2(String str, int i) {
        return ttUrlDispatchV2(str, i, true);
    }

    public static TTDispatchResult ttUrlDispatchV2(String str, int i, boolean z) {
        try {
            new URL(str).toURI();
            try {
                return ttUrlDispatchInternal(str, i, z);
            } catch (Exception e) {
                String message = e.getMessage();
                if ((e instanceof IllegalArgumentException) && OKHTTP_DISPATCH_FAILED.equals(message)) {
                    return new TTDispatchResult(str, TTDispatchResult.DispatchState.OKHTTP_DISPATCH_FAILED, e);
                }
                boolean z2 = e instanceof IllegalStateException;
                if (z2 && TTNET_CRONET_NOT_INITIALIZED.equals(message)) {
                    return new TTDispatchResult(str, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
                }
                if ((e instanceof UnsupportedOperationException) && "CronetEngine has not been initialized.".equals(message)) {
                    return new TTDispatchResult(str, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
                }
                if (z2 && "Engine is shut down.".equals(message)) {
                    return new TTDispatchResult(str, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
                }
                if ((e instanceof UnknownFormatConversionException) && RETURN_WRONG_FORMAT.equals(message)) {
                    return new TTDispatchResult(str, TTDispatchResult.DispatchState.WRONG_FORMAT, e);
                }
                if ((e instanceof URISyntaxException) || (e instanceof MalformedURLException)) {
                    return new TTDispatchResult(str, TTDispatchResult.DispatchState.INVALID_FINAL_URL, e);
                }
                if ((e instanceof SocketTimeoutException) && ForestLoader.DOWNLOAD_ENGINE_TTNET.equals(message)) {
                    return new TTDispatchResult(str, TTDispatchResult.DispatchState.TIMEOUT, e);
                }
                return new TTDispatchResult(str, TTDispatchResult.DispatchState.NOT_REACHED, e);
            }
        } catch (Exception e2) {
            return new TTDispatchResult(str, TTDispatchResult.DispatchState.INVALID_ORIGIN_URL, e2);
        }
    }

    public static void preconnectUrl(String str) throws Exception {
        preconnectUrl(str, null);
    }

    public static void preconnectUrl(String str, Map<String, String> map) throws Exception {
        if (!TTNetInitMetrics.isCronetInitSuccess()) {
            throw new IllegalStateException("Cronet engine has not been initialized and completed.");
        }
        try {
            new URL(str).toURI();
            SsCronetHttpClient.inst(getTTNetDepend().getContext()).preconnectUrl(str, map);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void setProcessFlag(int i) {
        ProcessUtils.setProcessFlag(i);
    }

    public static void setZstdFuncAddr(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) throws Exception {
        SsCronetHttpClient cronetHttpClient = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.ZSTD_API);
        if (cronetHttpClient != null) {
            if (Logger.debug()) {
                Logger.d("TTNet_ZSTD", " createDCtxAddr:" + j + " decompressStreamAddr:" + j2 + " freeDctxAddr:" + j3 + " isErrorAddr:" + j4 + " createDDictAddr:" + j5 + " dctxRefDDictAddr:" + j6 + " freeDDictAddr:" + j7 + " dctxResetAddr:" + j8);
            }
            cronetHttpClient.setZstdFuncAddr(j, j2, j3, j4, j5, j6, j7, j8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setCookieInitCompleted() {
        try {
            SsCronetHttpClient cronetHttpClient = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.COOKIE_INIT_COMPLETE_API);
            if (cronetHttpClient != null) {
                cronetHttpClient.setCookieInitCompleted();
            }
        } catch (Throwable unused) {
        }
    }

    public static void clearTNCFileBeforeStart(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        try {
            File file = new File(context.getFilesDir(), "server.json");
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(context.getFilesDir(), "tt_net_config.config");
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Throwable unused) {
        }
        clearSharedPreferencesFile(context, AppConfig.getSsAppConfigFileName());
        clearSharedPreferencesFile(context, TNCManager.TNC_SP_NAME);
        clearSharedPreferencesFile(context, StoreRegionManager.getStoreRegionSpName());
    }

    private static void clearSharedPreferencesFile(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().clear().apply();
    }

    public static void OnAppActiviyResume() {
        AppActivityResumeSuspendRecorder.OnAppActiviyResume();
    }

    public static void OnAppActivitySuspend() {
        AppActivityResumeSuspendRecorder.OnAppActivitySuspend();
    }

    public static void enableSsCallUseOkioReadForNoneStream(boolean z) {
        BaseSsCall.setUseOkioRead(z);
    }

    public static void enableSsCallUseZeroCopyReadForNoneStream(boolean z, int i) {
        BaseCronetSsCall.setUseZeroCopyRead(z);
        if (!z || i <= 0) {
            return;
        }
        long j = i * 1000;
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask(j, j) { // from class: com.bytedance.ttnet.TTNetInit.7
            public void run() {
                try {
                    ReflectWrap.on("com.ttnet.org.chromium.net.urlconnection.SegmentPool").call("checkAndReleaseIdleSegments");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void enableProceedWithoutHook(boolean z) {
        RealInterceptorChain.setProceedWithoutHookEnabled(z);
    }
}
