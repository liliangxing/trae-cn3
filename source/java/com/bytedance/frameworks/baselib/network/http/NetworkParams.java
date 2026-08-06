package com.bytedance.frameworks.baselib.network.http;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.lifecycle.CoroutineLiveDataKt;
import coil3.disk.DiskLruCache;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.impl.CookieManagerWrap;
import com.bytedance.retrofit2.AppActivityResumeSuspendRecorder;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class NetworkParams {
    public static final String BDTURING_VERIFY_HEADER = "bdturing-verify";
    public static final String BYPASS_BDTURING_HEADER_KEY = "x-tt-bypass-bdturing";
    private static final String BYPASS_RETRY_BY_HEADER_KEY_PREFIX = "x-tt-bypass-retry-by-";
    public static final String BYPASS_RETRY_FOR_ACCOUNT_KEY = "x-tt-bypass-retry-for-account";
    private static final int CONNECT_TIMEOUT = 15000;
    private static final int IO_TIMEOUT = 15000;
    public static final int MAX_ROTATION_HOST_PATH_RETRY_COUNT = 3;
    public static final String PNAME_REMOTE_ADDRESS = "x-net-info.remoteaddr";
    public static final String RETRY_FOR_ACCOUNT_REQUEST_KEY = "x-tt-retry-for-account";
    public static final String RETRY_REQUEST_BY_BDTURING_HEADER = "x-tt-bdturing-retry";
    private static final String RETRY_REQUEST_BY_HEADER_KEY_PREFIX = "x-tt-retry-by-";
    private static final String RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD = "verify";
    private static final String RETRY_REQUEST_IGNORE_STATUS_CODE_CHECK = "ignore-status-code";
    private static final int WAIT_COOKIE_INIT_TIME = 5000;
    private static AddOecSecurityFactorProcessCallback sAddOecSecurityFactorProcessCallback;
    private static volatile addResponseHeadersCallback sAddResponseHeadersCallback;
    private static AddSecurityFactorProcessCallback sAddSecurityFactorProcessCallback;
    private static AllErrorReportHook sAllErrorReportHook;
    private static ApiRequestInterceptor sApiInterceptor;
    private static ApiProcessHook sApiProcessHook;
    private static AppCookieStore sAppCookieStore;
    private static CdnConnectionQualitySamplerHook sCdnConnectionQualitySamplerHook;
    private static CommandListener sCommandListener;
    private static ConnectionQualitySamplerHook sConnectionQualitySamplerHook;
    private static CookieShareInterceptor sCookieShareInterceptor;
    private static CookieUpdateListener sCookieUpdateListener;
    private static volatile boolean sDisallowDupReport;
    private static boolean sEnablePPForceUseSharedStream;
    private static MonitorProcessHook sMonitorProcessHook;
    private static MonitorProcessHookV2 sMonitorProcessHookV2;
    private static OldMonitorProcessHook sOldMonitorProcessHook;
    private static volatile boolean sOptReflection;
    private static volatile RetryForAccountRequestCallback sRetryForAccountRequestCallback;
    private static volatile RetryRequestByRotationHostListCallback sRetryRequestByRotationHostRetryListCallback;
    private static volatile RetryRequestByTuringHeaderCallback sRetryRequestCallback;
    private static StreamProcessor sStreamProcessor;
    private static volatile boolean sUseMonitorV2;
    private static volatile AtomicBoolean sCookieMgrInited = new AtomicBoolean(false);
    private static final Object COOKIE_LOCK = new Object();
    private static CountDownLatch sCookieInitedCountDown = new CountDownLatch(1);
    private static String sUserAgent = null;
    private static final Map<String, RetryRequestByHeaderCallback> sRetryRequestByHeaderCallbackMap = new ConcurrentHashMap();
    private static AtomicBoolean sDisableRotationHostRetryByTnc = new AtomicBoolean(false);
    private static int sDestroyDeltaMillis = 100;
    private static boolean sPrivateProtocolEnabled = true;
    private static boolean sEnableMainThreadCheck = false;

    @Deprecated
    private static volatile int sUseDnsMapping = -1;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface AddOecSecurityFactorProcessCallback {
        Map<String, String> onCallToAddSecurityFactor(String str, Map<String, List<String>> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface AddSecurityFactorProcessCallback {
        Map<String, String> onCallToAddSecurityFactor(String str, Map<String, List<String>> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface AllErrorReportHook {
        boolean isAllErrorReport();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ApiProcessHook<T extends BaseHttpRequestInfo> {
        String addCommonParams(String str, boolean z);

        default Map<String, String> addCommonParamsByLevel(String str, boolean z, int i) {
            return null;
        }

        String addRequestVertifyParams(String str, boolean z, Object... objArr);

        @Deprecated
        Map<String, String> getCommonParamsByLevel(int i);

        @Deprecated
        void handleApiError(String str, Throwable th, long j, T t);

        @Deprecated
        void handleApiOk(String str, long j, T t);

        void onTryInit();

        void putCommonParams(Map<String, String> map, boolean z);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ApiRequestInterceptor<T extends BaseRequestContext> {
        String filterUrl(String str, T t);

        boolean isOkHttp3Open();

        boolean isOkHttpOpen();

        void monitorApiHttp(String str, String str2, boolean z) throws IOException;

        @Deprecated
        List<InetAddress> resolveInetAddresses(String str);

        @Deprecated
        String tryDnsMapping(String str, String[] strArr);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface AppCookieStore {
        Map<String, List<String>> get(URI uri, Map<String, List<String>> map);

        void put(URI uri, Map<String, List<String>> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface CdnConnectionQualitySamplerHook {
        boolean cdnShouldSampling(String str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface CommandListener {
        String getHeaderKey();

        void onCommandReceived(List<String> list);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ConnectionQualitySamplerHook {
        boolean shouldSampling(String str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface CookieShareInterceptor {
        List<String> getShareCookie(CookieManager cookieManager, CookieManagerWrap cookieManagerWrap, URI uri);

        List<String> getShareCookieHostList(String str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface CookieUpdateListener {
        void onCookieBatchUpdate(Set<String> set);

        void onCookieUpdate(String str, String str2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface MonitorProcessHook<T extends BaseHttpRequestInfo> {
        @Deprecated
        default boolean handleApiSample(String str, String str2) {
            return false;
        }

        void monitorApiError(long j, long j2, String str, String str2, T t, Throwable th);

        void monitorApiOk(long j, long j2, String str, String str2, T t);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface MonitorProcessHookV2<T extends BaseHttpRequestInfo> {
        void monitorApiError(long j, long j2, String str, String str2, T t, Throwable th, JSONObject jSONObject);

        void monitorApiOk(long j, long j2, String str, String str2, T t, JSONObject jSONObject);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface OldMonitorProcessHook {
        boolean getOldmonitorSwitch();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface RetryForAccountRequestCallback {
        RequestRetryResult onCallToRetryForAccountRequest(String str, List<Header> list, Map<String, List<String>> map, boolean z);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface RetryRequestByHeaderCallback {
        RequestRetryResult onCallToRetryRequestByHeader(Map<String, List<String>> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface RetryRequestByHeaderCallbackV2 extends RetryRequestByHeaderCallback {
        RequestRetryResult onCallToRetryRequestByHeader(String str, List<Header> list, Map<String, List<String>> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface RetryRequestByRotationHostListCallback {
        RequestRetryResult onCallToRetryRequestByRotationHostRetryList(String str, String str2, BaseHttpRequestInfo baseHttpRequestInfo, int i, List<Header> list, Map<String, List<String>> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface RetryRequestByTuringHeaderCallback {
        RequestRetryResult onCallToRetryRequestByTuringHeader(Map<String, List<String>> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface StreamProcessor {
        InputStream processInputStream(InputStream inputStream, Map<String, List<String>> map, RetrofitMetrics retrofitMetrics);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface addResponseHeadersCallback {
        boolean onCallToRetryRequestByTuringHeader(Map<String, List<String>> map);
    }

    public static int getConnectTimeout() {
        return 15000;
    }

    public static int getIoTimeout() {
        return 15000;
    }

    @Deprecated
    public static void setDynamicTimeOutEnable(boolean z) {
    }

    @Deprecated
    public static void setNewCookieBlockPositionEnabled(boolean z) {
    }

    public static void setCommandListener(CommandListener commandListener) {
        sCommandListener = commandListener;
    }

    public static CommandListener getCommandListener() {
        return sCommandListener;
    }

    public static void setApiProcessHook(ApiProcessHook apiProcessHook) {
        sApiProcessHook = apiProcessHook;
    }

    public static void tryApiProcessHookInit(RetrofitMetrics retrofitMetrics) {
        ApiProcessHook apiProcessHook = sApiProcessHook;
        if (apiProcessHook != null) {
            if (retrofitMetrics != null) {
                retrofitMetrics.onTryInitStart();
            }
            try {
                apiProcessHook.onTryInit();
            } finally {
                if (retrofitMetrics != null) {
                    retrofitMetrics.onTryInitEnd();
                }
            }
        }
    }

    @Deprecated
    public static String addCommonParams(String str, boolean z) {
        return addCommonParams(str, z, null);
    }

    public static String addCommonParams(String str, boolean z, RetrofitMetrics retrofitMetrics) {
        if (sApiProcessHook != null) {
            if (retrofitMetrics != null) {
                retrofitMetrics.addCommonParamStart();
            }
            try {
                str = sApiProcessHook.addCommonParams(str, z);
            } finally {
                if (retrofitMetrics != null) {
                    retrofitMetrics.addCommonParamEnd();
                }
            }
        }
        return str;
    }

    public static Map<String, String> addCommonParamsByLevel(String str, boolean z, int i, RetrofitMetrics retrofitMetrics) {
        if (sApiProcessHook == null) {
            return null;
        }
        if (retrofitMetrics != null) {
            retrofitMetrics.addCommonParamStart();
        }
        try {
            Map<String, String> addCommonParamsByLevel = sApiProcessHook.addCommonParamsByLevel(str, z, i);
        } finally {
            if (retrofitMetrics != null) {
                retrofitMetrics.addCommonParamEnd();
            }
        }
    }

    public static String tryAddRequestVertifyParams(String str, boolean z, RetrofitMetrics retrofitMetrics, Object... objArr) {
        if (sApiProcessHook == null) {
            return null;
        }
        if (retrofitMetrics != null) {
            retrofitMetrics.requestVerifyStart();
        }
        try {
            String addRequestVertifyParams = sApiProcessHook.addRequestVertifyParams(str, z, objArr);
        } finally {
            if (retrofitMetrics != null) {
                retrofitMetrics.requestVerifyEnd();
            }
        }
    }

    public static void putCommonParams(Map<String, String> map, boolean z) {
        ApiProcessHook apiProcessHook = sApiProcessHook;
        if (apiProcessHook != null) {
            apiProcessHook.putCommonParams(map, z);
        }
    }

    @Deprecated
    public static Map<String, String> getCommonParamsByLevel(int i, RetrofitMetrics retrofitMetrics) {
        if (sApiProcessHook == null) {
            return null;
        }
        if (retrofitMetrics != null) {
            retrofitMetrics.addCommonParamStart();
        }
        try {
            Map<String, String> commonParamsByLevel = sApiProcessHook.getCommonParamsByLevel(i);
        } finally {
            if (retrofitMetrics != null) {
                retrofitMetrics.addCommonParamEnd();
            }
        }
    }

    @Deprecated
    public static void handleApiOk(String str, BaseHttpRequestInfo baseHttpRequestInfo) {
        if (baseHttpRequestInfo == null || baseHttpRequestInfo.bypassApiReport) {
            return;
        }
        ApiProcessHook apiProcessHook = sApiProcessHook;
        OldMonitorProcessHook oldMonitorProcessHook = sOldMonitorProcessHook;
        long j = baseHttpRequestInfo.metrics.retrofit.eventTs.requestEndTime - baseHttpRequestInfo.metrics.retrofit.eventTs.ssHttpCallApiStartTime;
        if (StringUtils.isEmpty(str) || j <= 0 || apiProcessHook == null || oldMonitorProcessHook == null || !oldMonitorProcessHook.getOldmonitorSwitch()) {
            return;
        }
        apiProcessHook.handleApiOk(str, j, baseHttpRequestInfo);
    }

    @Deprecated
    public static void handleApiError(String str, Throwable th, BaseHttpRequestInfo baseHttpRequestInfo) {
        if (StringUtils.isEmpty(str) || th == null || baseHttpRequestInfo == null || baseHttpRequestInfo.bypassApiReport) {
            return;
        }
        ApiProcessHook apiProcessHook = sApiProcessHook;
        OldMonitorProcessHook oldMonitorProcessHook = sOldMonitorProcessHook;
        if (apiProcessHook == null || oldMonitorProcessHook == null || !oldMonitorProcessHook.getOldmonitorSwitch()) {
            return;
        }
        apiProcessHook.handleApiError(str, th, baseHttpRequestInfo.requestEnd - baseHttpRequestInfo.requestStart, baseHttpRequestInfo);
    }

    public static void setUseMonitorV2ForDeprecatedApi(boolean z) {
        sUseMonitorV2 = z;
    }

    public static void setDisallowDupReport(boolean z) {
        sDisallowDupReport = z;
    }

    public static void setOptReflection(boolean z) {
        sOptReflection = z;
    }

    public static boolean getOptReflection() {
        return sOptReflection;
    }

    public static void setMonitorProcessHook(MonitorProcessHook monitorProcessHook) {
        sMonitorProcessHook = monitorProcessHook;
        TTNetRequestLogReporterBridge.inject();
    }

    private static boolean checkIfReportLog(String str, BaseHttpRequestInfo baseHttpRequestInfo) {
        if (baseHttpRequestInfo == null || baseHttpRequestInfo.bypassApiReport || StringUtils.isEmpty(baseHttpRequestInfo.metrics.networklib.networkKernelRawRequestLog) || baseHttpRequestInfo.metrics.retrofit.getRequestDurationMs() < 0) {
            return false;
        }
        return !StringUtils.isEmpty(str);
    }

    @Deprecated
    public static void monitorApiError(long j, long j2, String str, String str2, BaseHttpRequestInfo baseHttpRequestInfo, Throwable th) {
        if (baseHttpRequestInfo == null) {
            return;
        }
        baseHttpRequestInfo.metrics.retrofit.eventTs.ssHttpCallApiStartTime = j2;
        baseHttpRequestInfo.requestStart = j2;
        long j3 = j2 + j;
        baseHttpRequestInfo.metrics.retrofit.eventTs.requestEndTime = j3;
        baseHttpRequestInfo.requestEnd = j3;
        if (baseHttpRequestInfo.metrics.retrofit.eventTs.requestEnd == -1) {
            baseHttpRequestInfo.metrics.retrofit.eventTs.requestEnd = System.nanoTime();
        }
        baseHttpRequestInfo.metrics.setRequestEndAppResumeState(AppActivityResumeSuspendRecorder.GetAppActivityResumeState());
        baseHttpRequestInfo.traceCode = str2;
        baseHttpRequestInfo.useDeprecatedApi = true;
        if (!sDisallowDupReport || baseHttpRequestInfo.reported.compareAndSet(false, true)) {
            if (Logger.debug()) {
                Logger.d("Report with deprecated monitorApiError, url: " + str);
            }
            if (sUseMonitorV2) {
                monitorApiErrorV2(str, baseHttpRequestInfo, th);
            } else {
                monitorApiError(str, baseHttpRequestInfo, th);
            }
        }
    }

    public static void monitorApiError(String str, BaseHttpRequestInfo baseHttpRequestInfo, Throwable th) {
        if (!checkIfReportLog(str, baseHttpRequestInfo) || sMonitorProcessHook == null || th == null) {
            return;
        }
        baseHttpRequestInfo.metrics.logReport();
        sMonitorProcessHook.monitorApiError(baseHttpRequestInfo.metrics.retrofit.getRequestDurationMs(), baseHttpRequestInfo.metrics.retrofit.eventTs.ssHttpCallApiStartTime, str, baseHttpRequestInfo.traceCode, baseHttpRequestInfo, th);
    }

    @Deprecated
    public static void monitorApiSample(long j, long j2, String str, String str2, BaseHttpRequestInfo baseHttpRequestInfo) {
        if (baseHttpRequestInfo == null) {
            return;
        }
        baseHttpRequestInfo.metrics.retrofit.eventTs.ssHttpCallApiStartTime = j2;
        baseHttpRequestInfo.requestStart = j2;
        long j3 = j2 + j;
        baseHttpRequestInfo.metrics.retrofit.eventTs.requestEndTime = j3;
        baseHttpRequestInfo.requestEnd = j3;
        if (baseHttpRequestInfo.metrics.retrofit.eventTs.requestEnd == -1) {
            baseHttpRequestInfo.metrics.retrofit.eventTs.requestEnd = System.nanoTime();
        }
        baseHttpRequestInfo.metrics.setRequestEndAppResumeState(AppActivityResumeSuspendRecorder.GetAppActivityResumeState());
        baseHttpRequestInfo.traceCode = str2;
        baseHttpRequestInfo.useDeprecatedApi = true;
        if (!sDisallowDupReport || baseHttpRequestInfo.reported.compareAndSet(false, true)) {
            if (Logger.debug()) {
                Logger.d("Report with deprecated monitorApiSample, url: " + str);
            }
            if (sUseMonitorV2) {
                monitorApiOkV2(str, baseHttpRequestInfo);
            } else {
                monitorApiOk(str, baseHttpRequestInfo);
            }
        }
    }

    public static void monitorApiOk(String str, BaseHttpRequestInfo baseHttpRequestInfo) {
        if (!checkIfReportLog(str, baseHttpRequestInfo) || sMonitorProcessHook == null) {
            return;
        }
        baseHttpRequestInfo.metrics.logReport();
        sMonitorProcessHook.monitorApiOk(baseHttpRequestInfo.metrics.retrofit.getRequestDurationMs(), baseHttpRequestInfo.metrics.retrofit.eventTs.ssHttpCallApiStartTime, str, baseHttpRequestInfo.traceCode, baseHttpRequestInfo);
    }

    public static void setMonitorProcessHookV2(MonitorProcessHookV2 monitorProcessHookV2) {
        sMonitorProcessHookV2 = monitorProcessHookV2;
        TTNetRequestLogReporterBridge.inject();
    }

    public static void monitorApiOkV2(String str, BaseHttpRequestInfo baseHttpRequestInfo) {
        if (!checkIfReportLog(str, baseHttpRequestInfo) || sMonitorProcessHookV2 == null) {
            return;
        }
        baseHttpRequestInfo.metrics.logReport();
        JSONObject jSONObject = new JSONObject();
        try {
            baseHttpRequestInfo.metrics.toJson(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sMonitorProcessHookV2.monitorApiOk(baseHttpRequestInfo.metrics.retrofit.getRequestDurationMs(), baseHttpRequestInfo.metrics.retrofit.eventTs.ssHttpCallApiStartTime, str, baseHttpRequestInfo.traceCode, baseHttpRequestInfo, jSONObject);
    }

    public static void monitorApiErrorV2(String str, BaseHttpRequestInfo baseHttpRequestInfo, Throwable th) {
        if (!checkIfReportLog(str, baseHttpRequestInfo) || sMonitorProcessHookV2 == null || th == null) {
            return;
        }
        baseHttpRequestInfo.metrics.logReport();
        JSONObject jSONObject = new JSONObject();
        try {
            baseHttpRequestInfo.metrics.toJson(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sMonitorProcessHookV2.monitorApiError(baseHttpRequestInfo.metrics.retrofit.getRequestDurationMs(), baseHttpRequestInfo.metrics.retrofit.eventTs.ssHttpCallApiStartTime, str, baseHttpRequestInfo.traceCode, baseHttpRequestInfo, th, jSONObject);
    }

    public static void setAllErrorReportHook(AllErrorReportHook allErrorReportHook) {
        sAllErrorReportHook = allErrorReportHook;
    }

    public static boolean isAllErrorReport() {
        AllErrorReportHook allErrorReportHook = sAllErrorReportHook;
        if (allErrorReportHook == null) {
            return false;
        }
        return allErrorReportHook.isAllErrorReport();
    }

    public static void setOldMonitorProcessHook(OldMonitorProcessHook oldMonitorProcessHook) {
        sOldMonitorProcessHook = oldMonitorProcessHook;
    }

    public static void setApiRequestInterceptor(ApiRequestInterceptor apiRequestInterceptor) {
        sApiInterceptor = apiRequestInterceptor;
    }

    public static ApiRequestInterceptor getApiRequestInterceptor() {
        return sApiInterceptor;
    }

    public static String filterUrl(String str) {
        return filterUrl(str, null, null);
    }

    public static String filterUrl(String str, RetrofitMetrics retrofitMetrics) {
        return filterUrl(str, null, retrofitMetrics);
    }

    @Deprecated
    public static String filterUrl(String str, BaseRequestContext baseRequestContext) {
        return filterUrl(str, baseRequestContext, null);
    }

    public static String filterUrl(String str, BaseRequestContext baseRequestContext, RetrofitMetrics retrofitMetrics) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (sApiInterceptor != null) {
            if (retrofitMetrics != null) {
                retrofitMetrics.filterUrlStart();
            }
            try {
                str = sApiInterceptor.filterUrl(str, baseRequestContext);
            } finally {
                if (retrofitMetrics != null) {
                    retrofitMetrics.filterUrlEnd();
                }
            }
        }
        return str;
    }

    public static void monitorApiHttp(String str, String str2, boolean z, RetrofitMetrics retrofitMetrics) throws IOException {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2) || sApiInterceptor == null) {
            return;
        }
        if (retrofitMetrics != null) {
            if (!z) {
                retrofitMetrics.monitorApiHttpBeforeFilterStart();
            } else {
                retrofitMetrics.monitorApiHttpAfterFilterStart();
            }
        }
        try {
            sApiInterceptor.monitorApiHttp(str, str2, z);
            if (retrofitMetrics != null) {
                if (!z) {
                    retrofitMetrics.monitorApiHttpBeforeFilterEnd();
                } else {
                    retrofitMetrics.monitorApiHttpAfterFilterEnd();
                }
            }
        } catch (Throwable th) {
            if (retrofitMetrics != null) {
                if (!z) {
                    retrofitMetrics.monitorApiHttpBeforeFilterEnd();
                } else {
                    retrofitMetrics.monitorApiHttpAfterFilterEnd();
                }
            }
            throw th;
        }
    }

    public static void setCookieShareInterceptor(CookieShareInterceptor cookieShareInterceptor) {
        sCookieShareInterceptor = cookieShareInterceptor;
    }

    public static CookieShareInterceptor getCookieShareInterceptor() {
        return sCookieShareInterceptor;
    }

    public static void setAppCookieStore(AppCookieStore appCookieStore) {
        sAppCookieStore = appCookieStore;
    }

    public static AppCookieStore getAppCookieStore() {
        return sAppCookieStore;
    }

    public static void setCookieUpdateListener(CookieUpdateListener cookieUpdateListener) {
        sCookieUpdateListener = cookieUpdateListener;
    }

    public static CookieUpdateListener getCookieUpdateListener() {
        return sCookieUpdateListener;
    }

    public static void setConnectionQualitySamplerHook(ConnectionQualitySamplerHook connectionQualitySamplerHook) {
        sConnectionQualitySamplerHook = connectionQualitySamplerHook;
    }

    public static ConnectionQualitySamplerHook getConnectionQualitySamplerHook() {
        return sConnectionQualitySamplerHook;
    }

    public static void setCdnConnectionQualitySamplerHook(CdnConnectionQualitySamplerHook cdnConnectionQualitySamplerHook) {
        sCdnConnectionQualitySamplerHook = cdnConnectionQualitySamplerHook;
    }

    public static CdnConnectionQualitySamplerHook getCdnConnectionQualitySamplerHook() {
        return sCdnConnectionQualitySamplerHook;
    }

    public static void setStreamProcessor(StreamProcessor streamProcessor) {
        sStreamProcessor = streamProcessor;
    }

    public static StreamProcessor getStreamProcessor() {
        return sStreamProcessor;
    }

    private static void cookieInitedCountDown() {
        CountDownLatch countDownLatch = sCookieInitedCountDown;
        if (countDownLatch == null || countDownLatch.getCount() <= 0) {
            return;
        }
        sCookieInitedCountDown.countDown();
    }

    public static void setCookieMgrInited(boolean z) {
        if (sCookieMgrInited.get() == z) {
            return;
        }
        sCookieMgrInited.getAndSet(z);
        cookieInitedCountDown();
        if (z) {
            return;
        }
        sCookieInitedCountDown = new CountDownLatch(1);
    }

    public static boolean interceptCookie(Object obj) {
        return obj != null && (obj instanceof BaseRequestContext) && ((BaseRequestContext) obj).bypassCookie;
    }

    public static CookieManager tryNecessaryInit() {
        return tryNecessaryInit("");
    }

    public static CookieManager tryNecessaryInit(String str) {
        tryApiProcessHookInit(null);
        return tryCookieManagerInit();
    }

    public static CookieManager tryCookieManagerInit() {
        synchronized (COOKIE_LOCK) {
            if (!sCookieMgrInited.get()) {
                try {
                    CountDownLatch countDownLatch = sCookieInitedCountDown;
                    if (countDownLatch != null) {
                        countDownLatch.await(CoroutineLiveDataKt.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
                        if (sCookieInitedCountDown.getCount() == 1) {
                            sCookieInitedCountDown.countDown();
                        }
                    }
                } catch (Exception unused) {
                }
                sCookieMgrInited.getAndSet(true);
            }
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            try {
                if (cookieManager.acceptCookie()) {
                    return cookieManager;
                }
                cookieManager.setAcceptCookie(true);
                return cookieManager;
            } catch (Throwable unused2) {
                return cookieManager;
            }
        } catch (Throwable unused3) {
            return null;
        }
    }

    public static String getUserAgent() {
        return sUserAgent;
    }

    public static void setDefaultUserAgent(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    char[] charArray = str.toCharArray();
                    int length = charArray.length;
                    boolean z = false;
                    for (int i = 0; i < length; i++) {
                        char c = charArray[i];
                        if (c < ' ' || c > '~') {
                            charArray[i] = '?';
                            z = true;
                        }
                    }
                    if (z) {
                        str = new String(charArray);
                    }
                }
            } catch (Exception unused) {
            }
        }
        sUserAgent = str;
    }

    public static void setAddSecurityFactorProcessCallback(AddSecurityFactorProcessCallback addSecurityFactorProcessCallback) {
        sAddSecurityFactorProcessCallback = addSecurityFactorProcessCallback;
    }

    public static Map<String, String> tryAddSecurityFactor(String str, Map<String, List<String>> map) {
        AddSecurityFactorProcessCallback addSecurityFactorProcessCallback = sAddSecurityFactorProcessCallback;
        if (addSecurityFactorProcessCallback != null) {
            return addSecurityFactorProcessCallback.onCallToAddSecurityFactor(str, map);
        }
        return null;
    }

    public static void setAddOecSecurityFactorProcessCallback(AddOecSecurityFactorProcessCallback addOecSecurityFactorProcessCallback) {
        sAddOecSecurityFactorProcessCallback = addOecSecurityFactorProcessCallback;
    }

    public static Map<String, String> tryAddOecSecurityFactor(String str, Map<String, List<String>> map) {
        AddOecSecurityFactorProcessCallback addOecSecurityFactorProcessCallback = sAddOecSecurityFactorProcessCallback;
        if (addOecSecurityFactorProcessCallback != null) {
            return addOecSecurityFactorProcessCallback.onCallToAddSecurityFactor(str, map);
        }
        return null;
    }

    @Deprecated
    public static synchronized void setAddResponseHeadersCallback(addResponseHeadersCallback addresponseheaderscallback) {
        synchronized (NetworkParams.class) {
            sAddResponseHeadersCallback = addresponseheaderscallback;
        }
    }

    public static synchronized void setRetryRequestCallback(RetryRequestByTuringHeaderCallback retryRequestByTuringHeaderCallback) {
        synchronized (NetworkParams.class) {
            sRetryRequestCallback = retryRequestByTuringHeaderCallback;
        }
    }

    public static synchronized boolean addRetryRequestByHeaderCallback(String str, RetryRequestByHeaderCallback retryRequestByHeaderCallback) {
        synchronized (NetworkParams.class) {
            if (!StringUtils.isEmpty(str) && str.toLowerCase().contains(RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD) && retryRequestByHeaderCallback != null) {
                Iterator<String> it = sRetryRequestByHeaderCallbackMap.keySet().iterator();
                while (it.hasNext()) {
                    if (it.next().equalsIgnoreCase(str)) {
                        return false;
                    }
                }
                sRetryRequestByHeaderCallbackMap.put(str, retryRequestByHeaderCallback);
                return true;
            }
            return false;
        }
    }

    public static synchronized boolean removeRetryRequestByHeaderCallback(String str) {
        synchronized (NetworkParams.class) {
            if (StringUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : sRetryRequestByHeaderCallbackMap.keySet()) {
                if (str2.equalsIgnoreCase(str)) {
                    sRetryRequestByHeaderCallbackMap.remove(str2);
                    return true;
                }
            }
            return false;
        }
    }

    private static synchronized Map.Entry<String, RetryRequestByHeaderCallback> getRetryRequestByHeaderCallbackEntry(Set<String> set) {
        synchronized (NetworkParams.class) {
            for (Map.Entry<String, RetryRequestByHeaderCallback> entry : sRetryRequestByHeaderCallbackMap.entrySet()) {
                for (String str : set) {
                    if (!StringUtils.isEmpty(str) && str.equalsIgnoreCase(entry.getKey())) {
                        return entry;
                    }
                }
            }
            return null;
        }
    }

    private static RequestRetryResult onCallToResponseCallback(Map<String, List<String>> map) {
        if (sRetryRequestCallback != null) {
            RequestRetryResult onCallToRetryRequestByTuringHeader = sRetryRequestCallback.onCallToRetryRequestByTuringHeader(map);
            map.remove(BDTURING_VERIFY_HEADER);
            return onCallToRetryRequestByTuringHeader;
        }
        if (sAddResponseHeadersCallback != null) {
            boolean onCallToRetryRequestByTuringHeader2 = sAddResponseHeadersCallback.onCallToRetryRequestByTuringHeader(map);
            map.remove(BDTURING_VERIFY_HEADER);
            return new RequestRetryResult(onCallToRetryRequestByTuringHeader2);
        }
        return new RequestRetryResult(false);
    }

    private static RequestRetryResult shouldRetryRequestByHeader(Request request, BaseHttpRequestInfo baseHttpRequestInfo, List<Header> list, Map<String, List<String>> map) {
        Map.Entry<String, RetryRequestByHeaderCallback> retryRequestByHeaderCallbackEntry;
        RequestRetryResult onCallToRetryRequestByHeader;
        boolean z = false;
        RequestRetryResult requestRetryResult = new RequestRetryResult(false);
        if (map == null || map.isEmpty() || sRetryRequestByHeaderCallbackMap.isEmpty()) {
            return requestRetryResult;
        }
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (!StringUtils.isEmpty(next) && next.toLowerCase().contains(RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD)) {
                z = true;
                break;
            }
        }
        if (!z || (retryRequestByHeaderCallbackEntry = getRetryRequestByHeaderCallbackEntry(map.keySet())) == null) {
            return requestRetryResult;
        }
        if (list != null) {
            String str = BYPASS_RETRY_BY_HEADER_KEY_PREFIX + retryRequestByHeaderCallbackEntry.getKey();
            for (Header header : list) {
                if (header != null && str.equalsIgnoreCase(header.getName()) && DiskLruCache.VERSION.equals(header.getValue())) {
                    return requestRetryResult;
                }
            }
        }
        RetryRequestByHeaderCallback value = retryRequestByHeaderCallbackEntry.getValue();
        if (value == null) {
            return requestRetryResult;
        }
        baseHttpRequestInfo.metrics.bdTuringStart();
        try {
            if (value instanceof RetryRequestByHeaderCallbackV2) {
                onCallToRetryRequestByHeader = ((RetryRequestByHeaderCallbackV2) value).onCallToRetryRequestByHeader(request.getUrl(), list, map);
            } else {
                onCallToRetryRequestByHeader = value.onCallToRetryRequestByHeader(map);
            }
            baseHttpRequestInfo.metrics.bdTuringEnd();
            baseHttpRequestInfo.retryByHeaderFilterKey = retryRequestByHeaderCallbackEntry.getKey();
            if (onCallToRetryRequestByHeader != null && onCallToRetryRequestByHeader.isRequestRetryEnabled()) {
                baseHttpRequestInfo.bdTuringRetry = true;
                Map<String, String> addRequestHeaders = onCallToRetryRequestByHeader.getAddRequestHeaders();
                if (addRequestHeaders == null) {
                    addRequestHeaders = new HashMap<>();
                }
                addRequestHeaders.put(RETRY_REQUEST_BY_HEADER_KEY_PREFIX + retryRequestByHeaderCallbackEntry.getKey(), DiskLruCache.VERSION);
                onCallToRetryRequestByHeader.setAddRequestHeaders(addRequestHeaders);
            }
            return onCallToRetryRequestByHeader;
        } catch (Throwable th) {
            baseHttpRequestInfo.metrics.bdTuringEnd();
            throw th;
        }
    }

    public static synchronized boolean setRetryForAccountRequestCallback(RetryForAccountRequestCallback retryForAccountRequestCallback) {
        synchronized (NetworkParams.class) {
            if (sRetryForAccountRequestCallback != null) {
                return false;
            }
            sRetryForAccountRequestCallback = retryForAccountRequestCallback;
            return true;
        }
    }

    public static synchronized boolean setRetryRequestByRotationHostRetryListCallback(RetryRequestByRotationHostListCallback retryRequestByRotationHostListCallback) {
        synchronized (NetworkParams.class) {
            if (sRetryRequestByRotationHostRetryListCallback != null) {
                return false;
            }
            sRetryRequestByRotationHostRetryListCallback = retryRequestByRotationHostListCallback;
            return true;
        }
    }

    public static void setDisableRotationHostRetryByTnc(boolean z) {
        sDisableRotationHostRetryByTnc.set(z);
    }

    private static RequestRetryResult shouldRetryRequestByRotationHost(Request request, BaseHttpRequestInfo baseHttpRequestInfo, int i, List<Header> list, Map<String, List<String>> map, boolean z) {
        RotationHostRetryHandler rotationHostRetryHandler;
        RequestRetryResult requestRetryResult = new RequestRetryResult(false);
        if (z || baseHttpRequestInfo.bdTuringRetry || baseHttpRequestInfo.accountRetry || sDisableRotationHostRetryByTnc.get() || sRetryRequestByRotationHostRetryListCallback == null || (rotationHostRetryHandler = baseHttpRequestInfo.rotationHostPathRetryHandler) == null) {
            return requestRetryResult;
        }
        if (rotationHostRetryHandler.noRemainingRetryHost()) {
            rotationHostRetryHandler.recordMetrics(request.getHost(), request.getPath(), i, -1L, requestRetryResult, baseHttpRequestInfo);
            return requestRetryResult;
        }
        String url = request.getUrl();
        BaseRequestContext.RotationHostRetryInfo nextRetryHostInfo = rotationHostRetryHandler.getNextRetryHostInfo();
        if (nextRetryHostInfo == null) {
            return requestRetryResult;
        }
        String str = nextRetryHostInfo.host;
        String str2 = nextRetryHostInfo.path;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String host = request.getHost();
            String path = request.getPath();
            String replaceFirst = url.replaceFirst(host, str).replaceFirst(path, str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            baseHttpRequestInfo.metrics.rotationRetryStart();
            try {
                requestRetryResult = sRetryRequestByRotationHostRetryListCallback.onCallToRetryRequestByRotationHostRetryList(url, replaceFirst, baseHttpRequestInfo, i, list, map);
            } finally {
                try {
                    rotationHostRetryHandler.recordMetrics(host, path, i, SystemClock.elapsedRealtime() - elapsedRealtime, requestRetryResult, baseHttpRequestInfo);
                    if (requestRetryResult != null) {
                        baseHttpRequestInfo.rotationHostRetry = true;
                        requestRetryResult.setNextRetryUrl(replaceFirst);
                    }
                    return requestRetryResult;
                } finally {
                }
            }
            rotationHostRetryHandler.recordMetrics(host, path, i, SystemClock.elapsedRealtime() - elapsedRealtime, requestRetryResult, baseHttpRequestInfo);
            if (requestRetryResult != null && requestRetryResult.isRequestRetryEnabled()) {
                baseHttpRequestInfo.rotationHostRetry = true;
                requestRetryResult.setNextRetryUrl(replaceFirst);
            }
            return requestRetryResult;
        }
        return requestRetryResult;
    }

    private static RequestRetryResult shouldRetryForAccountRequest(String str, BaseHttpRequestInfo baseHttpRequestInfo, boolean z, List<Header> list, Map<String, List<String>> map) {
        RequestRetryResult requestRetryResult = null;
        if (sRetryForAccountRequestCallback == null) {
            return null;
        }
        if (list != null) {
            for (Header header : list) {
                if (header != null && BYPASS_RETRY_FOR_ACCOUNT_KEY.equalsIgnoreCase(header.getName()) && DiskLruCache.VERSION.equals(header.getValue())) {
                    return null;
                }
            }
        }
        baseHttpRequestInfo.metrics.accountRetryStart();
        try {
            requestRetryResult = sRetryForAccountRequestCallback.onCallToRetryForAccountRequest(str, list, map, z);
        } catch (Throwable unused) {
        }
        baseHttpRequestInfo.metrics.accountRetryEnd();
        if (!z && requestRetryResult != null && requestRetryResult.isRequestRetryEnabled()) {
            HashMap hashMap = new HashMap();
            hashMap.put(RETRY_FOR_ACCOUNT_REQUEST_KEY, DiskLruCache.VERSION);
            if (requestRetryResult.getAddRequestHeaders() != null) {
                hashMap.putAll(requestRetryResult.getAddRequestHeaders());
            }
            requestRetryResult.setAddRequestHeaders(hashMap);
            baseHttpRequestInfo.accountRetry = true;
        }
        return requestRetryResult;
    }

    private static RequestRetryResult shouldRetryRequestFromTuringHeader(BaseHttpRequestInfo baseHttpRequestInfo, List<Header> list, Map<String, List<String>> map) {
        RequestRetryResult requestRetryResult = new RequestRetryResult(false);
        if (map == null || !map.containsKey(BDTURING_VERIFY_HEADER)) {
            return requestRetryResult;
        }
        if (list != null) {
            for (Header header : list) {
                if (header != null && BYPASS_BDTURING_HEADER_KEY.equalsIgnoreCase(header.getName()) && DiskLruCache.VERSION.equals(header.getValue())) {
                    return requestRetryResult;
                }
            }
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(map);
        baseHttpRequestInfo.metrics.bdTuringStart();
        RequestRetryResult onCallToResponseCallback = onCallToResponseCallback(treeMap);
        baseHttpRequestInfo.metrics.bdTuringEnd();
        if (!treeMap.containsKey(BDTURING_VERIFY_HEADER)) {
            baseHttpRequestInfo.executeTuringCallback = true;
            baseHttpRequestInfo.retryByHeaderFilterKey = BDTURING_VERIFY_HEADER;
        }
        if (onCallToResponseCallback != null && onCallToResponseCallback.isRequestRetryEnabled()) {
            baseHttpRequestInfo.bdTuringRetry = true;
            HashMap hashMap = new HashMap();
            hashMap.put(RETRY_REQUEST_BY_BDTURING_HEADER, DiskLruCache.VERSION);
            if (onCallToResponseCallback.getAddRequestHeaders() != null) {
                hashMap.putAll(onCallToResponseCallback.getAddRequestHeaders());
            }
            onCallToResponseCallback.setAddRequestHeaders(hashMap);
        }
        return onCallToResponseCallback;
    }

    private static boolean ignoreStatusCodeCheck(Map<String, List<String>> map) {
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                if (!StringUtils.isEmpty(str) && str.toLowerCase().contains(RETRY_REQUEST_IGNORE_STATUS_CODE_CHECK)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static RequestRetryResult shouldRetryRequestOnceTime(Request request, int i, BaseHttpRequestInfo baseHttpRequestInfo, List<Header> list, Map<String, List<String>> map, boolean z, boolean z2) {
        boolean z3 = false;
        RequestRetryResult requestRetryResult = new RequestRetryResult(false);
        baseHttpRequestInfo.rotationHostRetry = false;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return requestRetryResult;
        }
        if ((i != 200 && !ignoreStatusCodeCheck(map)) || !z) {
            return shouldRetryRequestByRotationHost(request, baseHttpRequestInfo, i, list, map, z2);
        }
        RequestRetryResult shouldRetryRequestFromTuringHeader = shouldRetryRequestFromTuringHeader(baseHttpRequestInfo, list, map);
        if (!baseHttpRequestInfo.executeTuringCallback) {
            shouldRetryRequestFromTuringHeader = shouldRetryRequestByHeader(request, baseHttpRequestInfo, list, map);
        }
        boolean z4 = shouldRetryRequestFromTuringHeader != null && shouldRetryRequestFromTuringHeader.isRequestRetryEnabled();
        RequestRetryResult shouldRetryForAccountRequest = shouldRetryForAccountRequest(request.getUrl(), baseHttpRequestInfo, z4, list, map);
        if (!z4 && shouldRetryForAccountRequest != null) {
            if (shouldRetryRequestFromTuringHeader != null) {
                shouldRetryForAccountRequest.setRemoveHitResponseHeaderIfNotRetry(shouldRetryRequestFromTuringHeader.isRemoveHitResponseHeaderIfNotRetry());
            }
            shouldRetryRequestFromTuringHeader = shouldRetryForAccountRequest;
        } else if (shouldRetryForAccountRequest != null && shouldRetryForAccountRequest.getAddRequestHeaders() != null) {
            HashMap hashMap = new HashMap();
            if (shouldRetryRequestFromTuringHeader.getAddRequestHeaders() != null) {
                hashMap.putAll(shouldRetryRequestFromTuringHeader.getAddRequestHeaders());
            }
            hashMap.putAll(shouldRetryForAccountRequest.getAddRequestHeaders());
            shouldRetryRequestFromTuringHeader.setAddRequestHeaders(hashMap);
        }
        if (shouldRetryRequestFromTuringHeader != null && shouldRetryRequestFromTuringHeader.isRequestRetryEnabled()) {
            z3 = true;
        }
        if (z3) {
            return shouldRetryRequestFromTuringHeader;
        }
        RequestRetryResult shouldRetryRequestByRotationHost = shouldRetryRequestByRotationHost(request, baseHttpRequestInfo, i, list, map, z2);
        if (shouldRetryRequestFromTuringHeader != null && shouldRetryRequestByRotationHost != null) {
            shouldRetryRequestByRotationHost.setRemoveHitResponseHeaderIfNotRetry(shouldRetryRequestFromTuringHeader.isRemoveHitResponseHeaderIfNotRetry());
        }
        return shouldRetryRequestByRotationHost;
    }

    public static void setDestroyDeltaMillis(int i) {
        sDestroyDeltaMillis = i;
    }

    public static int getDestroyDeltaMillis() {
        return sDestroyDeltaMillis;
    }

    public static void setPrivateProtocolEnabled(boolean z) {
        sPrivateProtocolEnabled = z;
    }

    public static boolean isPrivateProtocolEnabled() {
        return sPrivateProtocolEnabled;
    }

    public static void setEnableMainThreadCheck(boolean z) {
        sEnableMainThreadCheck = z;
    }

    public static boolean getEnableMainThreadCheck() {
        return sEnableMainThreadCheck;
    }

    @Deprecated
    public static void setUseDnsMapping(int i) {
        sUseDnsMapping = i;
    }

    @Deprecated
    public static boolean getUseDnsMapping() {
        return sUseDnsMapping != 0;
    }

    public static boolean isEnablePPForceUseSharedStream() {
        return sEnablePPForceUseSharedStream;
    }

    public static void setEnablePPForceUseSharedStream(boolean z) {
        sEnablePPForceUseSharedStream = z;
    }
}
