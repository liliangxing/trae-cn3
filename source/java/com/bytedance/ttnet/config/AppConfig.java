package com.bytedance.ttnet.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionClassManager;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamConfig;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetSsCallConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.impl.CookieManagerWrap;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3Builder;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.platform.thread.Constants;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.ttnet.AppConsts;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.JsonOptConfig;
import com.bytedance.ttnet.debug.DebugMode;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.CdnCacheVerifyUtils;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import com.bytedance.ttnet.utils.TtnetUtil;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AppConfig implements NetworkParams.ApiRequestInterceptor, WeakHandler.IHandler, RequestEncryptUtils.IEncryptConfig, HttpClient.IHttpClientConfig, SsCronetHttpClient.ICronetHttpDnsConfig, SsCronetHttpClient.ICronetBootFailureChecker, ConnectionClassManager.ConnectionClassStateChangeListener, NetworkParams.ConnectionQualitySamplerHook, SsCronetHttpClient.ITncInfoGet, NetworkParams.CdnConnectionQualitySamplerHook, NetworkParams.CookieShareInterceptor {
    static final int CONTINUOUS_FAILURES_TO_CLOSE_CRONET = 5;
    static final int CRONET_TRY_REBOOT_HOURS = 1;
    private static final int INVALID_VALUE = Integer.MIN_VALUE;
    static final String KEY_ADD_DEVICE_FINGERPRINT_OPEN = "add_device_fingerprint_open";
    static final String KEY_ADD_SS_QUERIES_HEADER_OPEN = "add_ss_queries_header_open";
    static final String KEY_ADD_SS_QUERIES_OPEN = "add_ss_queries_open";
    static final String KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN = "add_ss_queries_plaintext_open";
    static final String KEY_API_HTTP_HOST_LIST = "api_http_host_list";
    static final String KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED = "cdn_sample_band_width_enabled";
    static final String KEY_CHROMIUM_BOOT_FAILURES = "chromium_boot_failures";
    static final String KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP = "chromium_boot_failures_timestamp";
    static final String KEY_COLLECT_RECENT_PAGE_INFO_ENABLE = "collect_recent_page_info_enable";
    static final String KEY_COMMON_PARAMS_CONFIG = "add_common_params";
    static final String KEY_CONCURRENT_REQUEST_CONFIG = "concurrent_request_config";
    static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    static final String KEY_CRONET_SO_PATH = "cronet_so_path";
    static final String KEY_CRONET_VERSION = "cronet_version";
    static final String KEY_DESTROY_DELTA_MILLIS = "destroy_delta_millis";
    static final String KEY_DETECT_NATIVE_PAGE = "detect_native_page";
    static final String KEY_DETECT_OPEN = "detect_open";
    static final String KEY_DISABLE_FRAMED_TRANSPORT = "disable_framed_transport";
    static final String KEY_DISABLE_ROTATION_HOST_RETRY = "disable_rotating_host_path_retry";
    static final String KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN = "dynamic_adjust_threadpool_size_open";
    static final String KEY_ENCRYPT_SWITCH = "android_log_encrypt_switch";
    static final String KEY_HTTP_DNS_ENABLED = "http_dns_enabled";
    static final String KEY_HTTP_SHOW_HIJACK = "http_show_hijack";
    static final String KEY_HTTP_VERIFY_SIGN = "http_verify_sign";
    static final String KEY_IMAGE_TTNET_ENABLED = "image_ttnet_enabled";
    static final String KEY_OK_HTTP3_OPEN = "ok_http3_open";
    static final String KEY_OK_HTTP_OPEN = "ok_http_open";
    static final String KEY_PP_FORCE_USE_SHARED_STREAM = "pp_force_use_shared_stream";
    static final String KEY_PRIVATE_PROTOCOL_ENABLED = "private_protocol_enabled";
    static final String KEY_SAMPLE_BAND_WIDTH_ENABLED = "sample_band_width_enabled";
    static final String KEY_SHARE_COOKIE_HOST_LIST = "share_cookie_host_list";
    static final String KEY_TNC_HOST_ARRAYS = "send_tnc_host_arrays";
    static final String KEY_TNC_SUMMARY = "tnc_summary";
    static final String KEY_TNC_UPDATE_INTERVAL = "tnc_update_interval";
    static final String KEY_USE_HTTP_DNS = "use_http_dns";
    static final String KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE = "use_http_dns_refetch_on_expire";
    static final int MSG_CONFIG_ERROR = 102;
    static final int MSG_CONFIG_OK = 101;
    static final int MSG_TNC_COLDSTART_DELAY = 104;
    static final int MSG_TNC_POLLING = 103;
    static final String SP_SS_APP_CONFIG = "ss_app_config";
    private static final String SYNC_MAIN_PROCESS_CONFIG_ACTION = "com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG";
    static final String TAG = "AppConfig";
    private static String mFrontierUrls = "";
    private static AppConfig mInstance = null;
    private static ArrayList<String> sBlockModelList = null;
    static boolean sCronetUnsupportedModel = false;
    static boolean sDisableFallbackReasonBoot = false;
    static boolean sEnableFallbackReasonBootFix = true;
    static boolean sForceNotUseCronet = false;
    private static boolean sForceNotUseCronetHttpDns = false;
    private static String sPackageName = null;
    private static boolean sTestDeviceFingerPrint = false;
    private static boolean sTestSsQueries = false;
    private static int sUseHttpDns = -1;
    private static int sUseHttpDnsRefetchOnExpire = -1;
    private JSONObject mABTest;
    private final Context mContext;
    private volatile int mEncryptSwitch;
    private volatile boolean mEncryptSwitchFromSP;
    private final boolean mIsMainProcess;
    private String mTncSummary;
    private AtomicLong mLastRefreshTime = new AtomicLong(0);
    private AtomicBoolean mConfigUpdating = new AtomicBoolean(false);
    private final Object mLock = new Object();
    private volatile boolean mLocalLoaded = false;
    private int mOkHttpOpen = 0;
    private int mOkHttp3Open = 0;
    private volatile int mChromiumBootFailures = -1;
    private long mChromiumBootFailuresTimestamp = 0;
    private AtomicBoolean mPreloadBootFailureInfo = new AtomicBoolean(false);
    private int mHttpDnsEnabled = 0;
    private int mDetectOpen = 0;
    private int mDetectNativePage = 1;
    private int mCollectRecentPageInfoEnable = 1;
    private int mAddSsQueriesOpen = 0;
    private int mAddSsQueriesHeaderOpen = 0;
    private int mAddSsQueriesPlaintextOpen = 1;
    private int mImageTtnetEnabled = 1;
    private int mSampleBandWidthEnabled = 1;
    private int mCdnSampleBandWidthEnabled = 1;
    private int mAddDeviceFingerprintOpen = 1;
    private int mDynamicAdjustThreadPoolSizeOpen = 1;
    private String mCronetSoPath = "";
    private List<String> mShareCookieHostList = new CopyOnWriteArrayList();
    private int mCronetVersion = 0;
    private List<String> mApiHttpHostList = new CopyOnWriteArrayList();
    private String mTncEtag = "";
    private final AtomicInteger mTncUpdateInterval = new AtomicInteger(10800);
    private final List<String> mTncHostArrays = new CopyOnWriteArrayList();
    final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);

    @Deprecated
    public static boolean getHttpVerifySign() {
        return true;
    }

    @Deprecated
    public static boolean getHttpsRetryHttp() {
        return false;
    }

    @Deprecated
    public static boolean getHttpsShowHijack() {
        return true;
    }

    @Deprecated
    public static boolean getHttpsToHttp() {
        return false;
    }

    public static String getSsAppConfigFileName() {
        return SP_SS_APP_CONFIG;
    }

    @Deprecated
    public void enableNewCronetBootFallback(boolean z) {
    }

    public void handleConfigUpdate(String str) {
    }

    @Deprecated
    public List<InetAddress> resolveInetAddressesFromHttpDns(String str) {
        return null;
    }

    @Deprecated
    public void setCronetTryRebootHours(int i) {
    }

    @Deprecated
    public void setForceSwitch(boolean z) {
    }

    @Deprecated
    public void setForceUseCronet(boolean z) {
    }

    @Deprecated
    public void setForceUseCronetOn4X(boolean z) {
    }

    public String tryDnsMapping(String str, String[] strArr) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class SyncConfigBroadcastReceiver extends BroadcastReceiver {
        SyncConfigBroadcastReceiver() {
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.ttnet.config.AppConfig$SyncConfigBroadcastReceiver$1] */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !AppConfig.SYNC_MAIN_PROCESS_CONFIG_ACTION.equals(intent.getAction())) {
                return;
            }
            new ThreadPlus("SyncMainProcessConfig") { // from class: com.bytedance.ttnet.config.AppConfig.SyncConfigBroadcastReceiver.1
                public void run() {
                    SyncMultiProcessConfig.inst().SyncMainProcessConfig();
                }
            }.start();
        }
    }

    public static AppConfig getInstance(Context context) {
        AppConfig appConfig;
        synchronized (AppConfig.class) {
            if (mInstance == null) {
                boolean isMainProcessByProcessFlag = ProcessUtils.isMainProcessByProcessFlag(context);
                mInstance = new AppConfig(context.getApplicationContext(), isMainProcessByProcessFlag);
                if (sBlockModelList.contains(Build.MODEL)) {
                    sCronetUnsupportedModel = true;
                }
                sPackageName = context.getPackageName();
                if (isMainProcessByProcessFlag) {
                    RequestEncryptUtils.setEncryptConfig(mInstance);
                    SsCronetHttpClient.setCronetHttpDnsConfig(mInstance);
                    SsCronetHttpClient.setCronetBootFailureChecker(mInstance);
                    SsCronetHttpClient.setCronetTncInfoGet(mInstance);
                    HttpClient.setHttpClientConfig(mInstance);
                    ConnectionClassManager.getInstance().register(mInstance);
                    NetworkParams.setConnectionQualitySamplerHook(mInstance);
                    NetworkParams.setCdnConnectionQualitySamplerHook(mInstance);
                    if (NetworkParams.getCookieShareInterceptor() == null) {
                        NetworkParams.setCookieShareInterceptor(mInstance);
                    }
                } else {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(SYNC_MAIN_PROCESS_CONFIG_ACTION);
                    try {
                        TtnetUtil.registerNonExportedBroadcastReceiver(context, new SyncConfigBroadcastReceiver(), intentFilter);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    SyncMultiProcessConfig inst = SyncMultiProcessConfig.inst();
                    RequestEncryptUtils.setEncryptConfig(inst);
                    SsCronetHttpClient.setCronetHttpDnsConfig(inst);
                    SsCronetHttpClient.setCronetBootFailureChecker(inst);
                    HttpClient.setHttpClientConfig(inst);
                    if (NetworkParams.getCookieShareInterceptor() == null) {
                        NetworkParams.setCookieShareInterceptor(inst);
                    }
                }
                TTNetInitMetrics.inst().initMultiProcStackOptConfigStart = System.nanoTime();
                SsCronetHttpClient.setCronetThreadOptFailureChecker(MultiProcStackOptConfig.inst(context));
                TTNetInitMetrics.inst().initMultiProcStackOptConfigEnd = System.nanoTime();
                NetworkParams.setApiRequestInterceptor(mInstance);
                ImageStrategyController.Init(context);
            }
            appConfig = mInstance;
        }
        return appConfig;
    }

    private AppConfig(Context context, boolean z) {
        this.mContext = context;
        this.mIsMainProcess = z;
    }

    public void tryRefreshConfig(TNCManager.TNCUpdateSource tNCUpdateSource) {
        tryRefreshConfig(tNCUpdateSource, false);
    }

    public void tryRefreshConfig(TNCManager.TNCUpdateSource tNCUpdateSource, boolean z) {
        tryRefreshConfigInternal(tNCUpdateSource, z);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.ttnet.config.AppConfig$1] */
    private void tryRefreshConfigInternal(TNCManager.TNCUpdateSource tNCUpdateSource, boolean z) {
        if (this.mIsMainProcess) {
            doRefresh(tNCUpdateSource, z);
        } else if (this.mLastRefreshTime.get() <= 0) {
            try {
                new ThreadPlus("LoadDomainConfig4Other-Thread") { // from class: com.bytedance.ttnet.config.AppConfig.1
                    public void run() {
                        AppConfig.this.tryLoadDomainConfig4OtherProcess();
                    }
                }.start();
            } catch (Throwable unused) {
            }
        }
    }

    synchronized void tryLoadDomainConfig4OtherProcess() {
        if (System.currentTimeMillis() - this.mLastRefreshTime.get() > this.mTncUpdateInterval.get() * 1000) {
            this.mLastRefreshTime.set(System.currentTimeMillis());
            try {
                int providerInt = TTNetInit.getTTNetDepend().getProviderInt(this.mContext, KEY_DISABLE_FRAMED_TRANSPORT, 0);
                if (providerInt > 0) {
                    try {
                        OkHttp3Builder.disableFramedTransport(providerInt);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (TNCManager.getInstance().getTNCConfigHandler() != null) {
                    TNCManager.getInstance().getTNCConfigHandler().loadLocalConfigForOtherProcess(this.mLastRefreshTime.get());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ttnet.config.AppConfig$2] */
    public boolean doRefresh(final TNCManager.TNCUpdateSource tNCUpdateSource, final boolean z) {
        if (Logger.debug()) {
            Logger.d("TNCManager", "doRefresh: updating state " + this.mConfigUpdating.get());
        }
        if (!this.mConfigUpdating.compareAndSet(false, true) && tNCUpdateSource != TNCManager.TNCUpdateSource.TTCRONETFAILED) {
            if (Logger.debug()) {
                Logger.d("TNCManager", "doRefresh, already running " + tNCUpdateSource);
            }
            return false;
        }
        new ThreadPlus("AppConfigThread") { // from class: com.bytedance.ttnet.config.AppConfig.2
            public void run() {
                AppConfig.this.updateConfig(tNCUpdateSource, z);
            }
        }.start();
        return true;
    }

    public void handleMsg(Message message) {
        switch (message.what) {
            case 101:
                this.mLastRefreshTime.set(System.currentTimeMillis());
                if (Logger.debug()) {
                    Logger.d("TNCManager", "doRefresh, succ");
                }
                this.mConfigUpdating.set(false);
                return;
            case 102:
                if (Logger.debug()) {
                    Logger.d("TNCManager", "doRefresh, error");
                }
                this.mConfigUpdating.set(false);
                return;
            case 103:
                if (Logger.debug()) {
                    Logger.d("TNCManager", "do tnc polling");
                }
                tryRefreshConfig(TNCManager.TNCUpdateSource.TTPOLL);
                return;
            case 104:
                if (Logger.debug()) {
                    Logger.d("TNCManager", "did is empty, delay request tnc");
                }
                tryRefreshConfig(TNCManager.TNCUpdateSource.TTSERVER);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ttnet.config.AppConfig$3] */
    public void tryLoadLocalConfig() {
        synchronized (this.mLock) {
            if (this.mLocalLoaded) {
                return;
            }
            this.mLocalLoaded = true;
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
            this.mOkHttpOpen = sharedPreferences.getInt(KEY_OK_HTTP_OPEN, 0);
            this.mOkHttp3Open = sharedPreferences.getInt(KEY_OK_HTTP3_OPEN, 0);
            this.mCronetVersion = sharedPreferences.getInt(KEY_CRONET_VERSION, 0);
            this.mHttpDnsEnabled = sharedPreferences.getInt(KEY_HTTP_DNS_ENABLED, 0);
            this.mDetectOpen = sharedPreferences.getInt(KEY_DETECT_OPEN, 0);
            this.mDetectNativePage = sharedPreferences.getInt(KEY_DETECT_NATIVE_PAGE, 1);
            this.mCollectRecentPageInfoEnable = sharedPreferences.getInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, 1);
            this.mAddSsQueriesOpen = sharedPreferences.getInt(KEY_ADD_SS_QUERIES_OPEN, 0);
            this.mAddSsQueriesHeaderOpen = sharedPreferences.getInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, 0);
            this.mAddSsQueriesPlaintextOpen = sharedPreferences.getInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, 1);
            this.mAddDeviceFingerprintOpen = sharedPreferences.getInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, 1);
            this.mDynamicAdjustThreadPoolSizeOpen = sharedPreferences.getInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, 1);
            if (this.mChromiumBootFailures < 0) {
                this.mChromiumBootFailures = sharedPreferences.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
            }
            RequestQueue.setDynamicAdjustThreadPoolSizeOpen(this.mDynamicAdjustThreadPoolSizeOpen > 0);
            this.mImageTtnetEnabled = sharedPreferences.getInt(KEY_IMAGE_TTNET_ENABLED, 1);
            this.mSampleBandWidthEnabled = sharedPreferences.getInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, 1);
            this.mCdnSampleBandWidthEnabled = sharedPreferences.getInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, 1);
            sUseHttpDns = sharedPreferences.getInt(KEY_USE_HTTP_DNS, -1);
            sUseHttpDnsRefetchOnExpire = sharedPreferences.getInt(KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE, -1);
            StreamParser.onConfigUpdate(sharedPreferences);
            SsCronetHttpClient.tryUpdateBodyBufferSizeConfig((JSONObject) null, sharedPreferences);
            CdnCacheVerifyUtils.onLocalConfigUpdate(sharedPreferences);
            if (this.mAddSsQueriesOpen > 0 || this.mAddSsQueriesHeaderOpen > 0) {
                SsInterceptor.EnableEncryptQuery(true);
            }
            mFrontierUrls = sharedPreferences.getString(MultiProcessFileUtils.KEY_FRONTIER_URLS, "");
            this.mCronetSoPath = sharedPreferences.getString(KEY_CRONET_SO_PATH, "");
            String string = sharedPreferences.getString(KEY_API_HTTP_HOST_LIST, "");
            if (!StringUtils.isEmpty(string)) {
                for (String str : string.split(",")) {
                    if (!StringUtils.isEmpty(str)) {
                        this.mApiHttpHostList.add(str.trim());
                    }
                }
            }
            CronetSsCallConfig.inst().onNetConfigChanged(sharedPreferences.getString(KEY_CONCURRENT_REQUEST_CONFIG, ""));
            String string2 = sharedPreferences.getString(KEY_COMMON_PARAMS_CONFIG, "");
            CommonParamConfig commonParamConfig = CommonParamManager.inst().getCommonParamConfig();
            if (commonParamConfig != null) {
                commonParamConfig.onNetConfigChanged(string2);
            }
            QueryFilterEngine.inst().parseL0ParamsString(sharedPreferences.getString("L0_params", ""));
            int i = sharedPreferences.getInt("query_filter_enabled", Integer.MIN_VALUE);
            String string3 = sharedPreferences.getString("query_filter_actions", "");
            if (i != Integer.MIN_VALUE) {
                QueryFilterEngine.inst().enableQueryFilterEngine(i > 0);
                QueryFilterEngine.inst().onNetConfigChanged(string3);
            }
            String string4 = sharedPreferences.getString(KEY_SHARE_COOKIE_HOST_LIST, "");
            TtnetUtil.parseShareCookieHostList(string4, this.mShareCookieHostList);
            String shareCookieMainDomain = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
            if (!StringUtils.isEmpty(shareCookieMainDomain) && !TtnetUtil.inCookieHostList(shareCookieMainDomain, this.mShareCookieHostList)) {
                this.mShareCookieHostList.add(shareCookieMainDomain);
            }
            NetworkParams.setPrivateProtocolEnabled(sharedPreferences.getInt(KEY_PRIVATE_PROTOCOL_ENABLED, 1) >= 1);
            int i2 = sharedPreferences.getInt(KEY_DESTROY_DELTA_MILLIS, 100);
            if (i2 >= 0) {
                NetworkParams.setDestroyDeltaMillis(i2);
            }
            NetworkParams.setDisableRotationHostRetryByTnc(sharedPreferences.getInt(KEY_DISABLE_ROTATION_HOST_RETRY, -1) >= 1);
            this.mTncUpdateInterval.set(sharedPreferences.getInt(KEY_TNC_UPDATE_INTERVAL, 10800));
            String string5 = sharedPreferences.getString(KEY_TNC_HOST_ARRAYS, "");
            if (!TextUtils.isEmpty(string5)) {
                String[] split = string5.split(",");
                this.mTncHostArrays.clear();
                this.mTncHostArrays.addAll(Arrays.asList(split));
            }
            this.mTncSummary = sharedPreferences.getString(KEY_TNC_SUMMARY, "");
            if (TNCManager.getInstance().getTNCConfigHandler() != null) {
                TNCManager.getInstance().getTNCConfigHandler().loadLocalConfig(this.mLastRefreshTime.get());
            }
            int i3 = sharedPreferences.getInt(KEY_DISABLE_FRAMED_TRANSPORT, 0);
            if (i3 > 0) {
                try {
                    OkHttp3Builder.disableFramedTransport(i3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (this.mIsMainProcess) {
                try {
                    final LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (!StringUtils.isEmpty(mFrontierUrls)) {
                        linkedHashMap.put(MultiProcessFileUtils.KEY_FRONTIER_URLS, mFrontierUrls);
                    }
                    linkedHashMap.put(KEY_HTTP_DNS_ENABLED, Integer.valueOf(this.mHttpDnsEnabled));
                    linkedHashMap.put(KEY_ADD_SS_QUERIES_OPEN, Integer.valueOf(this.mAddSsQueriesOpen));
                    linkedHashMap.put(KEY_ADD_SS_QUERIES_HEADER_OPEN, Integer.valueOf(this.mAddSsQueriesHeaderOpen));
                    linkedHashMap.put(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, Integer.valueOf(this.mAddSsQueriesPlaintextOpen));
                    linkedHashMap.put(KEY_CHROMIUM_BOOT_FAILURES, Integer.valueOf(this.mChromiumBootFailures));
                    linkedHashMap.put(KEY_SHARE_COOKIE_HOST_LIST, string4);
                    linkedHashMap.put(KEY_DISABLE_FRAMED_TRANSPORT, Integer.valueOf(i3));
                    new ThreadPlus("SaveMapToProvider-Thread") { // from class: com.bytedance.ttnet.config.AppConfig.3
                        public void run() {
                            TTNetInit.getTTNetDepend().saveMapToProvider(AppConfig.this.mContext, linkedHashMap);
                            Intent intent = new Intent(AppConfig.SYNC_MAIN_PROCESS_CONFIG_ACTION);
                            if (!TextUtils.isEmpty(AppConfig.sPackageName)) {
                                intent.setPackage(AppConfig.sPackageName);
                            }
                            AppConfig.this.mContext.sendBroadcast(intent);
                        }
                    }.start();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Deprecated
    public List<InetAddress> resolveInetAddresses(String str) {
        if (StringUtils.isEmpty(str) || !this.mIsMainProcess) {
            return null;
        }
        return resolveInetAddressesFromHttpDns(str);
    }

    public boolean shouldSampling(String str) {
        URI safeCreateUri;
        if (StringUtils.isEmpty(str) || this.mSampleBandWidthEnabled <= 0) {
            return false;
        }
        try {
            safeCreateUri = URIUtils.safeCreateUri(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (safeCreateUri == null) {
            return false;
        }
        String host = safeCreateUri.getHost();
        if (StringUtils.isEmpty(host)) {
            return false;
        }
        return host.endsWith(AppConsts.getHostSuffix());
    }

    public boolean cdnShouldSampling(String str) {
        URI safeCreateUri;
        if (StringUtils.isEmpty(str) || this.mCdnSampleBandWidthEnabled <= 0) {
            return false;
        }
        try {
            safeCreateUri = URIUtils.safeCreateUri(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (safeCreateUri == null) {
            return false;
        }
        String host = safeCreateUri.getHost();
        if (StringUtils.isEmpty(host)) {
            return false;
        }
        return host.endsWith(AppConsts.getCdnHostSuffix());
    }

    public String filterUrl(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return filterUrlOnUIThread(str);
        }
        return filterUrl(str, null);
    }

    @Deprecated
    public String filterUrl(String str, BaseRequestContext baseRequestContext) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (this.mIsMainProcess) {
                tryLoadLocalConfig();
            } else {
                tryLoadDomainConfig4OtherProcess();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    @Deprecated
    public String filterUrlOnUIThread(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        try {
            return TNCManager.getInstance().handleHostMapping(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public boolean isNeedHttpDnsRefetchOnExpire() {
        return sUseHttpDnsRefetchOnExpire > 0;
    }

    public synchronized int getCronetVersion() {
        if (this.mLocalLoaded) {
            return this.mCronetVersion;
        }
        return this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).getInt(KEY_CRONET_VERSION, 0);
    }

    public boolean isOkHttpOpen() {
        return this.mOkHttpOpen > 0;
    }

    public boolean isOkHttp3Open() {
        return Logger.debug() || this.mOkHttp3Open > 0;
    }

    public void setDisableFallbackReasonBoot(boolean z) {
        sDisableFallbackReasonBoot = z;
    }

    public void setEnableFallbackReasonBootFix(boolean z) {
        sEnableFallbackReasonBootFix = z;
    }

    public void monitorApiHttp(String str, String str2, boolean z) throws IOException {
        if (this.mApiHttpHostList.isEmpty()) {
            return;
        }
        for (String str3 : this.mApiHttpHostList) {
            if (!StringUtils.isEmpty(str3) && str.endsWith(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str + str2);
                    jSONObject.put("replace", z);
                    TTNetInit.monitorLogSend("api_http", jSONObject);
                } catch (Throwable unused) {
                }
                if (TTNetInit.apiHttpInterceptEnabled() && !z) {
                    throw new NotAllowApiHttpException("Api http request is not allowed to be executed");
                }
                return;
            }
        }
    }

    public void setForceNotUseCronet(boolean z) {
        sForceNotUseCronet = z;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        sBlockModelList = arrayList;
        sCronetUnsupportedModel = false;
        arrayList.add("MI PAD 2");
        sBlockModelList.add("YT3-X90L");
        sBlockModelList.add("YT3-X90F");
        sBlockModelList.add("GT-810");
        sForceNotUseCronetHttpDns = false;
        sTestSsQueries = false;
        sTestDeviceFingerPrint = false;
    }

    public void preloadCronetBootFailureInfo() {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        if (this.mChromiumBootFailures < 0) {
            this.mChromiumBootFailures = sharedPreferences.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
        }
        if (Logger.debug()) {
            Logger.d(TAG, "mChromiumBootFailures is " + this.mChromiumBootFailures);
        }
        this.mChromiumBootFailuresTimestamp = sharedPreferences.getLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, 0L);
        if (this.mChromiumBootFailures <= 5 || System.currentTimeMillis() - this.mChromiumBootFailuresTimestamp <= TimeUnit.HOURS.toMillis(1L)) {
            return;
        }
        this.mChromiumBootFailures = 5;
    }

    @Override // com.bytedance.ttnet.HttpClient.IHttpClientConfig
    public boolean isChromiumOpen() {
        if (sEnableFallbackReasonBootFix && this.mPreloadBootFailureInfo.compareAndSet(false, true)) {
            preloadCronetBootFailureInfo();
        }
        if (sForceNotUseCronet) {
            SsOkHttp3Client.setFallbackReason(0);
            return false;
        }
        if (sCronetUnsupportedModel) {
            SsOkHttp3Client.setFallbackReason(8);
            return false;
        }
        if (isCronetUnsupportedABI()) {
            return false;
        }
        if (!sDisableFallbackReasonBoot && this.mChromiumBootFailures > 5) {
            SsOkHttp3Client.setFallbackReason(3);
            Logger.e(TAG, "After five consecutive crashes of cronet, you must reinstall app to enable cronet, or wait until several hours");
            return false;
        }
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled()) {
            return true;
        }
        SsOkHttp3Client.setFallbackReason(6);
        return false;
    }

    private static boolean isCronetUnsupportedABIv2() {
        boolean z;
        String[] strArr = Build.SUPPORTED_ABIS;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (strArr[i].contains("arm")) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            if (SsOkHttp3Client.getFallbackReason() == 2) {
                SsOkHttp3Client.setFallbackReason(-1);
            }
        } else {
            if (DebugMode.x86Support()) {
                Logger.d(TAG, "x86 support");
                return false;
            }
            SsOkHttp3Client.setFallbackReason(2);
        }
        if (Logger.debug()) {
            Logger.d(TAG, "use isCronetUnsupportedABIv2, result is " + (!z));
        }
        return !z;
    }

    public static boolean isCronetUnsupportedABI() {
        String str;
        if (ExperimentalSwitches.isEnableWithContainArmabi()) {
            return isCronetUnsupportedABIv2();
        }
        try {
            str = Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("x86".equalsIgnoreCase(str) || "x86_64".equalsIgnoreCase(str)) {
            if (DebugMode.x86Support()) {
                Logger.d(TAG, "x86 support");
                return false;
            }
            Logger.w(TAG, "Cronet unsupported CPU arch: " + str);
            SsOkHttp3Client.setFallbackReason(2);
            return true;
        }
        return false;
    }

    public void setForceNotUseCronetHttpDns(boolean z) {
        sForceNotUseCronetHttpDns = z;
    }

    public boolean isCronetHttpDnsOpen() {
        return !sForceNotUseCronetHttpDns && this.mHttpDnsEnabled > 0;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.bytedance.ttnet.config.AppConfig$4] */
    public boolean isCronetBootFailureExpected() {
        if (Logger.debug()) {
            Logger.d(TAG, "isCronetBootFailureExpected...");
        }
        boolean z = false;
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        if (!sEnableFallbackReasonBootFix) {
            if (this.mChromiumBootFailures < 0) {
                this.mChromiumBootFailures = sharedPreferences.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
            }
            this.mChromiumBootFailuresTimestamp = sharedPreferences.getLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, 0L);
            if (this.mChromiumBootFailures > 5 && System.currentTimeMillis() - this.mChromiumBootFailuresTimestamp > TimeUnit.HOURS.toMillis(1L)) {
                this.mChromiumBootFailures = 5;
            }
        }
        if (isChromiumOpen()) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            z = true;
            edit.putInt(KEY_CHROMIUM_BOOT_FAILURES, this.mChromiumBootFailures + 1);
            edit.putLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, System.currentTimeMillis());
            if (Logger.debug()) {
                Logger.d(TAG, "KEY_CHROMIUM_BOOT_FAILURES inc...");
            }
            SharedPrefsEditorCompat.apply(edit);
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(KEY_CHROMIUM_BOOT_FAILURES, Integer.valueOf(this.mChromiumBootFailures + 1));
            if (TTNetInit.getCronetProvider().getOptInit()) {
                new ThreadPlus("SaveMapToProvider-Thread") { // from class: com.bytedance.ttnet.config.AppConfig.4
                    public void run() {
                        TTNetInit.getTTNetDepend().saveMapToProvider(AppConfig.this.mContext, linkedHashMap);
                    }
                }.start();
            } else {
                TTNetInit.getTTNetDepend().saveMapToProvider(this.mContext, linkedHashMap);
            }
        }
        return z;
    }

    public boolean isDetectOpen() {
        return this.mDetectOpen > 0;
    }

    public static void setTestQuery(boolean z) {
        sTestSsQueries = z;
    }

    public boolean isSsQueriesOpen() {
        return sTestSsQueries || this.mAddSsQueriesOpen > 0;
    }

    public boolean isSsQueriesHeaderOpen() {
        return !sTestSsQueries && this.mAddSsQueriesHeaderOpen > 0;
    }

    public boolean isSsQueriesPlaintextOpen() {
        return sTestSsQueries || this.mAddSsQueriesPlaintextOpen > 0;
    }

    public static void setTestFingerPrint(boolean z) {
        sTestDeviceFingerPrint = z;
    }

    public boolean isDeviceFingerPrintOpen() {
        return sTestDeviceFingerPrint || this.mAddDeviceFingerprintOpen > 0;
    }

    public boolean isImageTtnetEnabled() {
        return this.mImageTtnetEnabled > 0;
    }

    public boolean isDetectNativePage() {
        return this.mDetectNativePage > 0;
    }

    public boolean isCollectRecentPageInfoEnable() {
        return this.mCollectRecentPageInfoEnable > 0;
    }

    void updateConfig(TNCManager.TNCUpdateSource tNCUpdateSource, boolean z) {
        if (Logger.debug()) {
            Logger.d("TNCManager", "doRefresh, actual request");
        }
        if (NetworkUtils.isNetworkAvailable(this.mContext)) {
            tryLoadLocalConfig();
            if (isChromiumOpen() && tNCUpdateSource != TNCManager.TNCUpdateSource.TTCRONETFAILED) {
                this.mConfigUpdating.set(false);
                return;
            }
            if (z && isDidEmpty()) {
                if (Logger.debug()) {
                    Logger.d("TNCManager", "did is empty, delay 5s send tnc again");
                }
                this.mHandler.sendEmptyMessageDelayed(104, Constants.TASK_RUN_THRESHOLD);
                this.mConfigUpdating.set(false);
                return;
            }
            int i = 101;
            if (!TNCManager.getInstance().getDomainInternal(this.mContext, true, tNCUpdateSource, this.mTncSummary)) {
                Logger.d(TAG, "tnc reqeust through okhttp failed, fallback to HttpUrlConnection");
                if (!TNCManager.getInstance().getDomainInternal(this.mContext, false, TNCManager.TNCUpdateSource.PORTRETRY, this.mTncSummary)) {
                    i = 102;
                }
            }
            this.mHandler.sendEmptyMessage(i);
            this.mHandler.removeMessages(103);
            this.mHandler.sendEmptyMessageDelayed(103, this.mTncUpdateInterval.get() * 1000);
        }
    }

    private boolean isDidEmpty() {
        List list;
        if (getConfigServers() != null && getConfigServers().length >= 1) {
            String str = getConfigServers()[0];
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = "https://" + str + "/get_domains/v5/";
            String addCommonParams = NetworkParams.addCommonParams(str2, true, (RetrofitMetrics) null);
            if (str2.equals(addCommonParams)) {
                return true;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                UrlUtils.parseUrlWithValueList(addCommonParams, linkedHashMap);
                if (!linkedHashMap.containsKey(CommonConstants.KEY_DID) || (list = (List) linkedHashMap.get(CommonConstants.KEY_DID)) == null) {
                    return true;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((String) it.next()).equals(ViewVisibleBridge.INVISIBLE)) {
                        return false;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public String[] getConfigServers() {
        String[] configServers = TTNetInit.getTTNetDepend().getConfigServers();
        return (configServers == null || configServers.length <= 0) ? new String[0] : configServers;
    }

    public void handleConfigUpdate(String str, Object obj) {
        boolean z;
        if (JsonOptConfig.isValid(obj)) {
            try {
                z = handleResponse(obj, TNCManager.TNCUpdateSource.TTCRONET, System.currentTimeMillis(), false);
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            int i = z ? 101 : 102;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PraiseDialogConstant.FROM, "cronet");
                TTNetInit.getTTNetDepend().onAppConfigUpdated(this.mContext, jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                handleConfigUpdate(str);
            } catch (Throwable unused) {
            }
            this.mHandler.sendEmptyMessage(i);
        }
    }

    public void resetCronetBootSucceed() {
        try {
            if (Logger.debug()) {
                Logger.d(TAG, "KEY_CHROMIUM_BOOT_FAILURES set 0");
            }
            if (this.mChromiumBootFailures == 0) {
                return;
            }
            this.mChromiumBootFailures = 0;
            SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).edit();
            edit.putInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
            SharedPrefsEditorCompat.apply(edit);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(KEY_CHROMIUM_BOOT_FAILURES, 0);
            TTNetInit.getTTNetDepend().saveMapToProvider(this.mContext, linkedHashMap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void reportShareCookieLog(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("return", str);
            jSONObject.put("CurrentShareCookieHostList", this.mShareCookieHostList.toString());
        } catch (JSONException unused) {
        }
        TTNetInit.getTTNetDepend().mobOnEvent(TTNetInit.getTTNetDepend().getContext(), "handleResponse", "shareCookieHostList", jSONObject);
    }

    public boolean handleResponse(Object obj, TNCManager.TNCUpdateSource tNCUpdateSource, long j, boolean z) throws Exception {
        JSONObject jsonObject;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String string;
        JSONObject jSONObject;
        boolean z2;
        String[] strArr;
        int i6;
        JSONObject jSONObject2 = new JSONObject();
        if (obj instanceof String) {
            String str = (String) obj;
            if (StringUtils.isEmpty(str)) {
                reportShareCookieLog(jSONObject2, "empty response.");
                return false;
            }
            jsonObject = new JSONObject(str);
        } else if (obj instanceof JSONObject) {
            jsonObject = (JSONObject) obj;
        } else {
            jsonObject = obj instanceof JsonOptConfig.JsonWrapper ? ((JsonOptConfig.JsonWrapper) obj).jsonObject() : null;
        }
        if (jsonObject == null) {
            reportShareCookieLog(jSONObject2, "object is null.");
            return false;
        }
        this.mTncSummary = jsonObject.optString("summary");
        JSONObject jSONObject3 = jsonObject.getJSONObject("data");
        sUseHttpDns = jSONObject3.optInt(KEY_USE_HTTP_DNS, -1);
        sUseHttpDnsRefetchOnExpire = jSONObject3.optInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, -1);
        int optInt = jSONObject3.optInt(KEY_OK_HTTP_OPEN, 0);
        int optInt2 = jSONObject3.optInt(KEY_OK_HTTP3_OPEN, 0);
        int optInt3 = jSONObject3.optInt(KEY_CRONET_VERSION, 0);
        int optInt4 = jSONObject3.optInt(KEY_HTTP_DNS_ENABLED, 0);
        int optInt5 = jSONObject3.optInt(KEY_DETECT_OPEN, 0);
        int optInt6 = jSONObject3.optInt(KEY_DETECT_NATIVE_PAGE, 1);
        int optInt7 = jSONObject3.optInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, 1);
        int optInt8 = jSONObject3.optInt(KEY_ADD_SS_QUERIES_OPEN, 0);
        int optInt9 = jSONObject3.optInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, 0);
        int optInt10 = jSONObject3.optInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, 1);
        int optInt11 = jSONObject3.optInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, 1);
        int optInt12 = jSONObject3.optInt(KEY_IMAGE_TTNET_ENABLED, 1);
        int optInt13 = jSONObject3.optInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, 1);
        int optInt14 = jSONObject3.optInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, 1);
        int optInt15 = jSONObject3.optInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, 1);
        int optInt16 = jSONObject3.optInt(KEY_HTTP_SHOW_HIJACK, 1);
        int optInt17 = jSONObject3.optInt(KEY_HTTP_VERIFY_SIGN, 1);
        int optInt18 = jSONObject3.optInt(KEY_TNC_UPDATE_INTERVAL, -1);
        if (optInt18 > 0) {
            this.mTncUpdateInterval.set(optInt18);
        }
        int optInt19 = jSONObject3.optInt(KEY_PRIVATE_PROTOCOL_ENABLED, 1);
        NetworkParams.setPrivateProtocolEnabled(optInt19 >= 1);
        int optInt20 = jSONObject3.optInt(KEY_DESTROY_DELTA_MILLIS, 100);
        if (optInt20 >= 0) {
            NetworkParams.setDestroyDeltaMillis(optInt20);
        }
        int optInt21 = jSONObject3.optInt(KEY_DISABLE_ROTATION_HOST_RETRY, -1);
        NetworkParams.setDisableRotationHostRetryByTnc(optInt21 >= 1);
        JSONArray optJSONArray = jSONObject3.optJSONArray(KEY_TNC_HOST_ARRAYS);
        if (optJSONArray != null) {
            this.mTncHostArrays.clear();
            i2 = optInt21;
            int i7 = 0;
            while (i7 < optJSONArray.length()) {
                if (TextUtils.isEmpty(optJSONArray.optString(i7))) {
                    i6 = optInt11;
                } else {
                    i6 = optInt11;
                    this.mTncHostArrays.add(optJSONArray.optString(i7));
                }
                i7++;
                optInt11 = i6;
            }
            i = optInt11;
        } else {
            i = optInt11;
            i2 = optInt21;
        }
        int optInt22 = jSONObject3.optInt(KEY_CRASH_LIMIT_TIMES, 0);
        int optInt23 = jSONObject3.optInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        synchronized (this) {
            this.mOkHttpOpen = optInt;
            this.mOkHttp3Open = optInt2;
            this.mCronetVersion = optInt3;
            this.mHttpDnsEnabled = optInt4;
            this.mDetectOpen = optInt5;
            this.mDetectNativePage = optInt6;
            this.mCollectRecentPageInfoEnable = optInt7;
            this.mAddSsQueriesOpen = optInt8;
            this.mAddSsQueriesHeaderOpen = optInt9;
            this.mAddSsQueriesPlaintextOpen = optInt10;
            i3 = i;
            this.mAddDeviceFingerprintOpen = i3;
            this.mDynamicAdjustThreadPoolSizeOpen = optInt15;
            this.mImageTtnetEnabled = optInt12;
            this.mSampleBandWidthEnabled = optInt13;
            this.mCdnSampleBandWidthEnabled = optInt14;
        }
        RequestQueue.setDynamicAdjustThreadPoolSizeOpen(optInt15 > 0);
        RequestTicketUtil.setEnable(jSONObject3.optInt("enable_req_ticket", 1) > 0);
        CdnCacheVerifyUtils.CdnCacheVerifyConfig onServerConfigUpdate = CdnCacheVerifyUtils.onServerConfigUpdate(jSONObject3);
        if (this.mAddSsQueriesOpen > 0 || this.mAddSsQueriesHeaderOpen > 0) {
            SsInterceptor.EnableEncryptQuery(true);
        }
        StreamParser.onServerConfigUpdate(jSONObject3);
        SsCronetHttpClient.tryUpdateBodyBufferSizeConfig(jSONObject3, (SharedPreferences) null);
        String optString = jSONObject3.optString(MultiProcessFileUtils.KEY_FRONTIER_URLS, "");
        String optString2 = jSONObject3.optString(KEY_SHARE_COOKIE_HOST_LIST, "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(optString2);
        String optString3 = jSONObject3.optString(KEY_API_HTTP_HOST_LIST, "");
        String optString4 = jSONObject3.optString(KEY_CONCURRENT_REQUEST_CONFIG, "");
        CronetSsCallConfig.inst().onNetConfigChanged(optString4);
        String optString5 = jSONObject3.optString(KEY_COMMON_PARAMS_CONFIG, "");
        CommonParamConfig commonParamConfig = CommonParamManager.inst().getCommonParamConfig();
        if (commonParamConfig != null) {
            commonParamConfig.onNetConfigChanged(optString5);
        }
        String optString6 = jSONObject3.optString("L0_params", "");
        QueryFilterEngine.inst().parseL0ParamsString(optString6);
        int optInt24 = jSONObject3.optInt("query_filter_enabled", Integer.MIN_VALUE);
        String optString7 = JsonOptConfig.optString(obj, jSONObject3, new String[]{"data", "query_filter_actions"});
        if (optInt24 != Integer.MIN_VALUE) {
            QueryFilterEngine.inst().enableQueryFilterEngine(optInt24 > 0);
            QueryFilterEngine.inst().onNetConfigChanged(optString7);
        }
        this.mEncryptSwitch = jSONObject3.optInt("disable_encrypt_switch", 0);
        this.mCronetSoPath = jSONObject3.optString(KEY_CRONET_SO_PATH, "");
        if (this.mEncryptSwitch == 2) {
            i4 = optInt24;
            i5 = 0;
            SharedPreferences.Editor edit = this.mContext.getSharedPreferences("app_log_encrypt_switch_count", 0).edit();
            edit.putInt("app_log_encrypt_faild_count", 0);
            SharedPrefsEditorCompat.apply(edit);
        } else {
            i4 = optInt24;
            i5 = 0;
        }
        int optInt25 = jSONObject3.optInt(KEY_DISABLE_FRAMED_TRANSPORT, i5);
        if (optInt25 > 0) {
            try {
                OkHttp3Builder.disableFramedTransport(optInt25);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        int optInt26 = jSONObject3.optInt(KEY_PP_FORCE_USE_SHARED_STREAM, i5);
        NetworkParams.setEnablePPForceUseSharedStream(optInt26 >= 1);
        synchronized (this) {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
            string = sharedPreferences.getString(KEY_SHARE_COOKIE_HOST_LIST, "");
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putString(CdnCacheVerifyUtils.KEY_TTNET_RESPONSE_VERIFY, onServerConfigUpdate.verifyRegexsStr);
            edit2.putInt(CdnCacheVerifyUtils.KEY_TTNET_RESPONSE_VERIFY_ENABLED, onServerConfigUpdate.ttnetResponseVerifyEnabled);
            StreamParser.onSaveConfigToSP(edit2);
            SsCronetHttpClient.onSaveConfigToSP(edit2);
            edit2.putInt(KEY_OK_HTTP_OPEN, optInt);
            edit2.putInt(KEY_OK_HTTP3_OPEN, optInt2);
            edit2.putInt(KEY_CRONET_VERSION, optInt3);
            edit2.putInt(KEY_HTTP_DNS_ENABLED, optInt4);
            edit2.putInt(KEY_DETECT_OPEN, optInt5);
            edit2.putInt(KEY_DETECT_NATIVE_PAGE, optInt6);
            edit2.putInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, optInt7);
            edit2.putInt(KEY_ADD_SS_QUERIES_OPEN, optInt8);
            edit2.putInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, optInt9);
            edit2.putInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, optInt10);
            edit2.putInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, i3);
            edit2.putInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, optInt15);
            edit2.putInt(KEY_IMAGE_TTNET_ENABLED, optInt12);
            edit2.putInt(KEY_USE_HTTP_DNS, sUseHttpDns);
            edit2.putInt(KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE, sUseHttpDnsRefetchOnExpire);
            edit2.putInt(KEY_HTTP_SHOW_HIJACK, optInt16);
            edit2.putInt(KEY_HTTP_VERIFY_SIGN, optInt17);
            edit2.putInt(KEY_CRASH_LIMIT_TIMES, optInt22);
            edit2.putInt(KEY_CRASH_DETECT_INTERVAL_MS, optInt23);
            edit2.putString(MultiProcessFileUtils.KEY_FRONTIER_URLS, optString);
            edit2.putString(KEY_CRONET_SO_PATH, this.mCronetSoPath);
            edit2.putString(KEY_SHARE_COOKIE_HOST_LIST, optString2);
            jSONObject2.put("oldShareCookieHosts", string);
            jSONObject2.put("newShareCookieHosts", optString2);
            if (!TextUtils.isEmpty(optString2)) {
                this.mShareCookieHostList.clear();
                TtnetUtil.parseShareCookieHostList(optString2, this.mShareCookieHostList);
            }
            String shareCookieMainDomain = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
            if (!StringUtils.isEmpty(shareCookieMainDomain) && !TtnetUtil.inCookieHostList(shareCookieMainDomain, this.mShareCookieHostList)) {
                this.mShareCookieHostList.add(shareCookieMainDomain);
            }
            edit2.putString(KEY_API_HTTP_HOST_LIST, optString3);
            edit2.putString(KEY_CONCURRENT_REQUEST_CONFIG, optString4);
            edit2.putString(KEY_COMMON_PARAMS_CONFIG, optString5);
            edit2.putString("query_filter_actions", optString7);
            edit2.putString("L0_params", optString6);
            int i8 = i4;
            edit2.putInt("query_filter_enabled", i8);
            String[] split = optString3.split(",");
            int length = split.length;
            int i9 = 0;
            while (i9 < length) {
                int i10 = length;
                String str2 = split[i9];
                if (StringUtils.isEmpty(str2)) {
                    strArr = split;
                } else {
                    strArr = split;
                    if (!TtnetUtil.inCookieHostList(str2, this.mApiHttpHostList)) {
                        this.mApiHttpHostList.add(str2.trim());
                    }
                }
                i9++;
                length = i10;
                split = strArr;
            }
            edit2.putInt(KEY_ENCRYPT_SWITCH, this.mEncryptSwitch);
            edit2.putInt(KEY_IMAGE_TTNET_ENABLED, this.mImageTtnetEnabled);
            edit2.putInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, this.mSampleBandWidthEnabled);
            edit2.putInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, this.mCdnSampleBandWidthEnabled);
            edit2.putInt(KEY_DISABLE_FRAMED_TRANSPORT, optInt25);
            edit2.putInt(KEY_TNC_UPDATE_INTERVAL, this.mTncUpdateInterval.get());
            edit2.putInt(KEY_PRIVATE_PROTOCOL_ENABLED, optInt19);
            edit2.putInt(KEY_DESTROY_DELTA_MILLIS, optInt20);
            int i11 = i2;
            edit2.putInt(KEY_DISABLE_ROTATION_HOST_RETRY, i11);
            edit2.putInt(KEY_PP_FORCE_USE_SHARED_STREAM, optInt26);
            StringBuilder sb = new StringBuilder();
            for (int i12 = 0; i12 < this.mTncHostArrays.size(); i12++) {
                sb.append(this.mTncHostArrays.get(i12));
                if (i12 != this.mTncHostArrays.size()) {
                    sb.append(StringListParam.SPLIT_DELIMITER);
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                edit2.putString(KEY_TNC_HOST_ARRAYS, sb2);
            }
            if (!TextUtils.isEmpty(this.mTncSummary)) {
                edit2.putString(KEY_TNC_SUMMARY, this.mTncSummary);
            }
            SharedPrefsEditorCompat.apply(edit2);
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (!StringUtils.isEmpty(optString) && !optString.equals(mFrontierUrls)) {
                    mFrontierUrls = optString;
                    linkedHashMap.put(MultiProcessFileUtils.KEY_FRONTIER_URLS, optString);
                }
                linkedHashMap.put(KEY_HTTP_DNS_ENABLED, Integer.valueOf(optInt4));
                linkedHashMap.put(KEY_ADD_SS_QUERIES_OPEN, Integer.valueOf(optInt8));
                linkedHashMap.put(KEY_ADD_SS_QUERIES_HEADER_OPEN, Integer.valueOf(optInt9));
                linkedHashMap.put(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, Integer.valueOf(optInt10));
                linkedHashMap.put(KEY_SHARE_COOKIE_HOST_LIST, optString2);
                linkedHashMap.put(KEY_DISABLE_FRAMED_TRANSPORT, Integer.valueOf(optInt25));
                linkedHashMap.put("query_filter_actions", optString7);
                linkedHashMap.put("L0_params", optString6);
                linkedHashMap.put("query_filter_enabled", Integer.valueOf(i8));
                linkedHashMap.put(KEY_PRIVATE_PROTOCOL_ENABLED, Integer.valueOf(optInt19));
                linkedHashMap.put(KEY_DISABLE_ROTATION_HOST_RETRY, Integer.valueOf(i11));
                linkedHashMap.put(KEY_PP_FORCE_USE_SHARED_STREAM, Integer.valueOf(optInt26));
                TTNetInit.getTTNetDepend().saveMapToProvider(this.mContext, linkedHashMap);
                Intent intent = new Intent(SYNC_MAIN_PROCESS_CONFIG_ACTION);
                if (!TextUtils.isEmpty(sPackageName)) {
                    intent.setPackage(sPackageName);
                }
                this.mContext.sendBroadcast(intent);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (!StringUtils.isEmpty(optString2)) {
            ShareCookieHostsSync.inst().onShareCookieHostsChanged(string, optString2);
        }
        if (ImageStrategyController.getInstance() != null) {
            jSONObject = jSONObject3;
            ImageStrategyController.getInstance().updateConfig(jSONObject);
        } else {
            jSONObject = jSONObject3;
        }
        if (TNCManager.getInstance().getTNCConfigHandler() != null) {
            if (JsonOptConfig.isTNCJsonOptEnable() && (obj instanceof JsonOptConfig.JsonWrapper) && ExperimentalSwitches.isEnableTNCJsonoptRefine()) {
                TNCManager.getInstance().getTNCConfigHandler().handleConfigChanged(obj, tNCUpdateSource, this.mTncEtag, "", j);
                z2 = true;
            } else {
                JSONObject jSONObject4 = jSONObject;
                z2 = true;
                TNCManager.getInstance().getTNCConfigHandler().handleConfigChanged(jSONObject4, tNCUpdateSource, this.mTncEtag, "", j);
            }
            if (z) {
                StoreRegionManager.inst().setReceivedTNCRegionConfig();
            }
        } else {
            z2 = true;
        }
        reportShareCookieLog(jSONObject2, "return true");
        return z2;
    }

    public boolean getEncryptSwitch() {
        getEncryptSwitchFromSP();
        return this.mEncryptSwitch == 0;
    }

    private void getEncryptSwitchFromSP() {
        if (this.mEncryptSwitchFromSP) {
            return;
        }
        this.mEncryptSwitch = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).getInt(KEY_ENCRYPT_SWITCH, 0);
        this.mEncryptSwitchFromSP = true;
    }

    public void setEncryptSwitch(int i) {
        if (this.mEncryptSwitch != i) {
            this.mEncryptSwitch = i;
        }
    }

    public String getCronetSoPath() {
        return this.mCronetSoPath;
    }

    public void onBandwidthStateChange(ConnectionQuality connectionQuality) {
        if (!Logger.debug() || connectionQuality == null) {
            return;
        }
        Logger.d(TAG, "onBandwidthStateChange bandwidthState = " + connectionQuality);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<String> getShareCookie(CookieManager cookieManager, CookieManagerWrap cookieManagerWrap, URI uri) {
        String str;
        if (uri == null) {
            return null;
        }
        if ((cookieManager == null && cookieManagerWrap == null) || StringUtils.isEmpty(TTNetInit.getTTNetDepend().getShareCookieMainDomain())) {
            return null;
        }
        try {
            str = uri.getHost();
        } catch (Exception unused) {
            str = null;
        }
        if (StringUtils.isEmpty(str) || !TtnetUtil.inCookieHostList(str, this.mShareCookieHostList)) {
            return null;
        }
        List arrayList = new ArrayList();
        if (cookieManager != null) {
            String cookie = cookieManager.getCookie(uri.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain());
            if (!StringUtils.isEmpty(cookie)) {
                arrayList.add(cookie);
                return arrayList;
            }
        }
        if (!Lists.isEmpty(arrayList) || cookieManagerWrap == null) {
            return arrayList;
        }
        try {
            Map map = cookieManagerWrap.get(URI.create(uri.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain()), new LinkedHashMap());
            if (map == null || map.isEmpty()) {
                return arrayList;
            }
            List list = (List) map.get("Cookie");
            if (list != null) {
                try {
                    list.add("x-tt-cookie-backup-source=1");
                } catch (Throwable th) {
                    th = th;
                    arrayList = list;
                    th.printStackTrace();
                    return arrayList;
                }
            }
            return list;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public List<String> getShareCookieHostList(String str) {
        if (TtnetUtil.inCookieHostList(str, this.mShareCookieHostList)) {
            return this.mShareCookieHostList;
        }
        return null;
    }

    public void setShareCookieHostList(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isEmpty(next) && !TtnetUtil.inCookieHostList(next, this.mShareCookieHostList)) {
                this.mShareCookieHostList.add(next.trim());
            }
        }
    }

    public List<String> getShareCookieHostList() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.mShareCookieHostList) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void setTncEtag(String str) {
        this.mTncEtag = str;
    }

    public void setTncABTest(String str) {
        this.mABTest = BaseHttpRequestInfo.getABTestInfo(str);
        TNCManager.getInstance().getTNCConfigHandler().setTncAbTest(str);
    }

    public JSONObject getABTest() {
        return this.mABTest;
    }

    public List<String> getTncHostArrays() {
        return this.mTncHostArrays;
    }

    public String getTncRules() {
        return this.mTncSummary;
    }

    public static List<String> getFrontierUrls() {
        if (TextUtils.isEmpty(mFrontierUrls)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(mFrontierUrls);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }
}
