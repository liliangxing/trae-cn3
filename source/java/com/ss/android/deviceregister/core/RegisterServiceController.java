package com.ss.android.deviceregister.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.CountryCommomParams;
import com.ss.android.common.applog.AppLogNewMonitor;
import com.ss.android.common.applog.NetUtil;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.DeviceRegisterParameterFactory;
import com.ss.android.deviceregister.EgdiManager;
import com.ss.android.deviceregister.GaidGetter;
import com.ss.android.deviceregister.OnResetListener;
import com.ss.android.deviceregister.PreInstallChannelCallback;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.base.ICustomMonitor;
import com.ss.android.deviceregister.base.ILogDepend;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter;
import com.ss.android.deviceregister.utils.Cdid;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.token.TokenConstants;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class RegisterServiceController implements EgdiManager.EgdiCallback {
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final String KEY_APP_TRACK = "app_track";
    private static final String KEY_CHANNEL = "dr_channel";
    static final String KEY_CUSTOM = "custom";
    public static final String KEY_DEVICE_TOKEN = "device_token";
    private static final long KEY_IS_RETRY_INTERVAL = 600000;
    private static final String KEY_LAST_CONFIG_TIME = "last_config_time";
    private static final String KEY_LAST_CONFIG_VERSION = "last_config_version";
    private static final String KEY_MAGIC_TAG = "magic_tag";
    private static final String MAGIC_TAG = "ss_app_log";
    private static final String NAME_DEVICE_REGISTER_THREAD = "DeviceRegisterThread";
    private static final String TAG = "RegisterServiceController";
    private static ICustomMonitor sCustomMonitor;
    private static ILogDepend sLogDepend;
    private static volatile PreInstallChannelCallback sPreInstallChannelCallback;
    private static volatile long sStartTime;
    private EgdiManager egdiManager;
    private volatile boolean isChildMode;
    private boolean isRetryLimit;
    private NetworkObserver.OnNetworkReadyListener listener;
    private final Context mContext;
    protected final IDeviceRegisterParameter mDeviceParamsProvider;
    private DeviceRegisterThread mDeviceRegisterThread;
    private JSONObject mHeader;
    private String mInstallId;
    private int mLastConfigVersion;
    private volatile OnResetListener mListener;
    private NetworkObserver mObservers;
    private final SharedPreferences mStatsInfoSp;
    private volatile int retryCount;
    private String sAppTrack;
    private static final Object sLogConfigLock = new Object();
    private static final Bundle sCustomerHeader = new Bundle();
    private static volatile boolean sLogConfigInited = false;
    private static volatile boolean sLoadingOnlineConfig = false;
    public static volatile boolean sThrottleByAppLogConfig = false;
    private static long sActivityTime = 0;
    private static volatile boolean sStop = false;
    private static List<WeakReference<DeviceRegisterManager.OnDeviceConfigUpdateListener>> sListenerRef = Collections.synchronizedList(new ArrayList());
    private static final ThreadLocal<Boolean> sIsConfigThread = new ThreadLocal<>();
    private static boolean sIsNewUser = false;
    private final Object mLock = new Object();
    private long mUpdateConfigTime = 0;
    private long mTryUpdateConfigTime = 0;
    private long mLastGetAppConfigTime = 0;

    protected abstract void onEventDidChanged(String str, String str2);

    static /* synthetic */ int access$608(RegisterServiceController registerServiceController) {
        int i = registerServiceController.retryCount;
        registerServiceController.retryCount = i + 1;
        return i;
    }

    public RegisterServiceController(Context context, boolean z) {
        this.mContext = context;
        this.mDeviceParamsProvider = DeviceRegisterParameterFactory.getProvider(context);
        this.mStatsInfoSp = AppLogConstants.getApplogStatsSp(context);
        this.isChildMode = z;
        this.isRetryLimit = DeviceRegisterManager.getRetryCount() != -1;
        this.egdiManager = new EgdiManager(context);
    }

    public static void setCustomMonitor(ICustomMonitor iCustomMonitor) {
        sCustomMonitor = iCustomMonitor;
    }

    public static void addCustomHeader(Bundle bundle) {
        if (bundle == null || bundle.size() <= 0) {
            return;
        }
        Bundle bundle2 = sCustomerHeader;
        synchronized (bundle2) {
            bundle2.putAll(bundle);
        }
    }

    public static void setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback) {
        sPreInstallChannelCallback = preInstallChannelCallback;
    }

    public void init() {
        this.mHeader = new JSONObject();
        loadSSIDs();
        if (!RegistrationHeaderHelper.getHeader(this.mContext, this.mHeader, isChildMode()) && Logger.debug()) {
            throw new RuntimeException("init header error.");
        }
        DeviceRegisterThread deviceRegisterThread = new DeviceRegisterThread();
        this.mDeviceRegisterThread = deviceRegisterThread;
        deviceRegisterThread.start();
    }

    public void updateDeviceInfo() {
        DeviceRegisterThread deviceRegisterThread = this.mDeviceRegisterThread;
        if (deviceRegisterThread == null) {
            return;
        }
        deviceRegisterThread.tryUpdateDeviceId();
    }

    private void loadSSIDs() {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences applogStatsSp = AppLogConstants.getApplogStatsSp(this.mContext);
        this.mLastConfigVersion = applogStatsSp.getInt(KEY_LAST_CONFIG_VERSION, 0);
        this.mInstallId = applogStatsSp.getString("install_id", "");
        boolean equals = TextUtils.equals(RegistrationHeaderHelper.getChannelCompat(this.mContext), applogStatsSp.getString(KEY_CHANNEL, null));
        if (this.mLastConfigVersion == RegistrationHeaderHelper.getVersionCode() && equals) {
            long j = applogStatsSp.getLong(KEY_LAST_CONFIG_TIME, 0L);
            if (j <= currentTimeMillis) {
                currentTimeMillis = j;
            }
            boolean isBadId = NetUtil.isBadId(getDeviceId());
            boolean isBadId2 = NetUtil.isBadId(getInstallId());
            if (isBadId || isBadId2) {
                return;
            }
            this.mUpdateConfigTime = currentTimeMillis;
        }
    }

    @Deprecated
    public int getLastConfigVersion() {
        return this.mLastConfigVersion;
    }

    public String getDeviceId() {
        return this.mDeviceParamsProvider.getDeviceId();
    }

    public static void onUpdateActivityTime() {
        sActivityTime = System.currentTimeMillis();
    }

    public void saveAppTrack(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.sAppTrack = jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            RegistrationHeaderHelper.saveAppTrack(context, this.sAppTrack);
        }
    }

    public String getInstallId() {
        return this.mInstallId;
    }

    public static void addOnDeviceRegisterConfigUpdateListener(DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener) {
        if (onDeviceConfigUpdateListener == null) {
            return;
        }
        sListenerRef.add(new WeakReference<>(onDeviceConfigUpdateListener));
    }

    public void stop() {
        synchronized (this.mLock) {
            sStop = true;
            this.mLock.notifyAll();
        }
    }

    public static void tryWaitDeviceInit(Context context) {
        tryWaitDeviceInit(context, -1L);
    }

    public static void tryWaitDeviceInit(Context context, long j) {
        if (sIsConfigThread.get() == null && StringUtils.isEmpty(tryGetDeviceId(context))) {
            Object obj = sLogConfigLock;
            synchronized (obj) {
                if (sLogConfigInited) {
                    return;
                }
                if (StringUtils.isEmpty(tryGetDeviceId(context))) {
                    long j2 = sLoadingOnlineConfig ? 4000L : 1500L;
                    if (j != -1) {
                        if (j > 120000) {
                            j = 120000;
                        } else if (j < 0) {
                            j = 1000;
                        }
                        j2 = j;
                    }
                    try {
                        obj.wait(j2);
                    } catch (Exception unused) {
                    }
                    sLogConfigInited = true;
                }
            }
        }
    }

    private static String tryGetDeviceId(Context context) {
        try {
            return DeviceRegisterParameterFactory.getProvider(context).getDeviceId();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void setILogDepend(ILogDepend iLogDepend) {
        sLogDepend = iLogDepend;
        RegistrationHeaderHelper.setILogDepend(iLogDepend);
    }

    public String getOpenUdid() {
        return isChildMode() ? "" : this.mDeviceParamsProvider.getOpenUdid(true);
    }

    protected boolean isChildMode() {
        return this.isChildMode;
    }

    public String getClientUDID() {
        return this.mDeviceParamsProvider.getClientUDID();
    }

    public void tryUpdateDeviceId() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    public void clearWhenSwitchChildMode(boolean z) {
        this.mInstallId = null;
        this.isChildMode = z;
        this.mDeviceParamsProvider.clear("device_id");
        this.mDeviceParamsProvider.clear("install_id");
        this.mDeviceParamsProvider.clear("clientudid");
        AppLogConstants.getApplogStatsSp(this.mContext).edit().remove("install_id").apply();
        Cdid.clear(this.mContext);
        JSONObject jSONObject = new JSONObject();
        RegistrationHeaderHelper.clearHeaderCache();
        RegistrationHeaderHelper.getHeader(this.mContext, jSONObject, z);
        this.mHeader = jSONObject;
    }

    public void resetDidWhenSwitchChildMode(boolean z, long j, OnResetListener onResetListener) {
        synchronized (this) {
            this.isChildMode = z;
            this.mUpdateConfigTime = 0L;
            this.mLastGetAppConfigTime = 0L;
            DeviceRegisterThread deviceRegisterThread = this.mDeviceRegisterThread;
            if (deviceRegisterThread != null) {
                deviceRegisterThread.mBadDidCount = 0;
            }
            RegistrationHeaderHelper.clearHeaderCache();
            JSONObject jSONObject = new JSONObject();
            RegistrationHeaderHelper.getHeader(this.mContext, jSONObject, isChildMode());
            this.mHeader = jSONObject;
            this.mListener = onResetListener;
            tryUpdateDeviceId();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.deviceregister.core.RegisterServiceController.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (RegisterServiceController.this) {
                    if (RegisterServiceController.this.mListener != null) {
                        RegisterServiceController.this.mListener.onTimeout();
                        RegisterServiceController.this.mListener = null;
                    }
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class DeviceRegisterThread extends Thread {
        private static final int MAX_BAD_ID_COUNT_CUT = 10;
        private static final int MAX_BAD_ID_COUNT_NET = 3;
        int mBadDidCount;

        DeviceRegisterThread() {
            super(RegisterServiceController.NAME_DEVICE_REGISTER_THREAD);
            this.mBadDidCount = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x00c4, code lost:
        
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x00c5, code lost:
        
            tryUpdateDeviceId();
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x00ce, code lost:
        
            if (r5.this$0.isRetryLimit == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00d0, code lost:
        
            com.ss.android.deviceregister.core.RegisterServiceController.access$608(r5.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00d5, code lost:
        
            monitor-exit(r5);
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            super.run();
            RegisterServiceController.this.notifyLoadDidResult(!StringUtils.isEmpty(RegisterServiceController.this.mHeader.optString("device_id", null)));
            while (true) {
                if (!RegisterServiceController.sStop) {
                    if (needToThrottle()) {
                        synchronized (RegisterServiceController.this.mLock) {
                            if (Logger.debug()) {
                                TLog.m73d("RegisterServiceController throttle by applog/settings sThrottleByAppLogConfig=" + RegisterServiceController.sThrottleByAppLogConfig + " did=" + RegisterServiceController.this.getDeviceId() + " iid=" + RegisterServiceController.this.getInstallId());
                            }
                            try {
                                RegisterServiceController.this.mLock.wait(TimeUnit.MINUTES.toMillis(1L));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        long waitTime = getWaitTime();
                        synchronized (RegisterServiceController.this.mLock) {
                            if (waitTime > 0) {
                                try {
                                    if (!RegisterServiceController.sStop) {
                                        RegisterServiceController.this.mLock.wait(waitTime);
                                    }
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (RegisterServiceController.sStop) {
                            }
                        }
                        break;
                    }
                } else {
                    break;
                }
            }
            if (Logger.debug()) {
                TLog.m73d("RegisterServiceController DeviceRegisterThread finished");
            }
        }

        private boolean needToThrottle() {
            return RegisterServiceController.sThrottleByAppLogConfig && !NetUtil.isBadId(RegisterServiceController.this.getDeviceId()) && !NetUtil.isBadId(RegisterServiceController.this.getInstallId()) && RegisterServiceController.this.mLastConfigVersion == RegistrationHeaderHelper.getVersionCode();
        }

        private long getWaitTime() {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = RegisterServiceController.this.mLastConfigVersion == RegistrationHeaderHelper.getVersionCode();
            long j = (DeviceRegisterConfig.isInitWithActivity() || RegisterServiceController.sActivityTime >= 0 || !z) ? 21600000L : 43200000L;
            long j2 = z ? 180000L : 30000L;
            long badIdCount = getBadIdCount();
            if (badIdCount != 0) {
                j2 = 4000 * badIdCount;
            }
            long j3 = j - (currentTimeMillis - RegisterServiceController.this.mUpdateConfigTime);
            long j4 = j2 - (currentTimeMillis - RegisterServiceController.this.mTryUpdateConfigTime);
            if (j3 > 0 && RegisterServiceController.this.isRetryLimit) {
                RegisterServiceController.this.retryCount = 0;
            }
            long max = Math.max(j3, j4);
            if (RegisterServiceController.this.isRetryLimit && RegisterServiceController.this.retryCount == DeviceRegisterManager.getRetryCount()) {
                RegisterServiceController.this.oberserveNetwork();
                RegisterServiceController.this.retryCount = 0;
            } else {
                j = max;
            }
            if (Logger.debug()) {
                if (j >= 0) {
                    currentTimeMillis += j;
                }
                TLog.m73d("RegisterServiceController next query time : " + DateFormat.getDateTimeInstance().format(new Date(currentTimeMillis)));
            }
            return j;
        }

        void tryUpdateDeviceId() {
            Pair<String, Boolean> gaid;
            if (RegisterServiceController.sLoadingOnlineConfig) {
                return;
            }
            IAppTraitCallback appTraitCallback = DeviceRegisterManager.getAppTraitCallback();
            String str = appTraitCallback != null ? appTraitCallback.get(RegisterServiceController.this.mContext) : null;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (RegisterServiceController.sStartTime <= 0) {
                    long unused = RegisterServiceController.sStartTime = currentTimeMillis;
                }
                RegisterServiceController.this.mTryUpdateConfigTime = currentTimeMillis;
                if (NetworkUtils.isNetworkAvailable(RegisterServiceController.this.mContext)) {
                    String userAgent = RegistrationHeaderHelper.getUserAgent(RegisterServiceController.this.mContext);
                    if (!StringUtils.isEmpty(userAgent)) {
                        RegisterServiceController.this.mHeader.put(AppLogConstants.KEY_USER_AGENT, userAgent);
                    }
                    if (!StringUtils.isEmpty(RegisterServiceController.this.sAppTrack)) {
                        RegisterServiceController.this.mHeader.put(RegisterServiceController.KEY_APP_TRACK, RegisterServiceController.this.sAppTrack);
                    }
                    JSONObject jSONObject = new JSONObject(new JSONTokener(RegisterServiceController.this.mHeader.toString()));
                    jSONObject.put("req_id", DeviceRegisterManager.getRequestId());
                    if (RegisterServiceController.this.isChildMode()) {
                        jSONObject.put(TokenConstants.SCENE_KEY, 2);
                    }
                    jSONObject.put("device_platform", RomUtils.OS_ANDROID);
                    new HarmonyLoader().doLoad(jSONObject);
                    try {
                        Bundle bundle = new Bundle();
                        synchronized (RegisterServiceController.sCustomerHeader) {
                            bundle.putAll(RegisterServiceController.sCustomerHeader);
                        }
                        if (bundle.size() > 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            for (String str2 : bundle.keySet()) {
                                jSONObject2.put(str2, bundle.get(str2));
                            }
                            jSONObject.put("custom", jSONObject2);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            jSONObject.put("app_trait", str);
                        }
                        String appLanguage = CountryCommomParams.getAppLanguage();
                        String appRegion = CountryCommomParams.getAppRegion();
                        if (!RegisterServiceController.this.isChildMode() && !DeviceRegisterManager.isNewUserMode(RegisterServiceController.this.mContext) && !DeviceRegisterManager.isTouristMode() && (gaid = GaidGetter.getGaid(RegisterServiceController.this.mContext)) != null) {
                            jSONObject.put(RegistrationHeaderHelper.KEY_GOOGLE_AID_LIMIT, gaid.second != null && ((Boolean) gaid.second).booleanValue() ? 1 : 0);
                            jSONObject.put("google_aid", gaid.first);
                        }
                        if (!StringUtils.isEmpty(appLanguage)) {
                            jSONObject.put("app_language", appLanguage);
                        }
                        if (!StringUtils.isEmpty(appRegion)) {
                            jSONObject.put("app_region", appRegion);
                        }
                    } catch (Throwable unused2) {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                    }
                    RegisterServiceController.this.addPreInstallInfo(jSONObject);
                    jSONObject.put(RegistrationHeaderHelper.KEY_SDK_VERSION, "3.10.6");
                    jSONObject.put("sdk_flavor", "china");
                    jSONObject.put("guest_mode", DeviceRegisterManager.isTouristMode() ? 1 : 0);
                    RegistrationHeaderHelper.filterHeader(jSONObject);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(RegisterServiceController.KEY_MAGIC_TAG, RegisterServiceController.MAGIC_TAG);
                    jSONObject3.put("header", jSONObject);
                    jSONObject3.put("_gen_time", System.currentTimeMillis());
                    boolean unused3 = RegisterServiceController.sLoadingOnlineConfig = true;
                    RegisterServiceController.sIsConfigThread.set(Boolean.TRUE);
                    boolean doRegisterRequest = doRegisterRequest(jSONObject3.toString(), jSONObject);
                    if (doRegisterRequest) {
                        System.currentTimeMillis();
                        if (RegisterServiceController.sStartTime > 0) {
                            long unused4 = RegisterServiceController.sStartTime = 0L;
                        }
                        if (RegisterServiceController.this.listener != null && RegisterServiceController.this.mObservers != null) {
                            RegisterServiceController.this.mObservers.unObserve(RegisterServiceController.this.listener);
                        }
                    }
                    synchronized (RegisterServiceController.sLogConfigLock) {
                        boolean unused5 = RegisterServiceController.sLoadingOnlineConfig = false;
                        try {
                            RegisterServiceController.sLogConfigLock.notifyAll();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    boolean unused6 = RegisterServiceController.sLogConfigInited = true;
                    RegisterServiceController.sIsConfigThread.remove();
                    if (doRegisterRequest) {
                        return;
                    }
                    RegisterServiceController.this.notifyConfigUpdate(false, StringUtils.isEmpty(RegisterServiceController.this.mDeviceParamsProvider.getDeviceId()));
                    return;
                }
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
                RegisterServiceController.this.oberserveNetwork();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        private boolean doRegisterRequest(String str, JSONObject jSONObject) {
            int i;
            String doPost;
            String str2;
            try {
                TLog.m73d("RegisterServiceController app_log_config: " + str);
                byte[] bytes = str.getBytes(HTTP.UTF_8);
                RegisterServiceController.this.mLastGetAppConfigTime = System.currentTimeMillis();
                String[] URL_DEVICE_REGISTER = DeviceRegisterConfig.URL_DEVICE_REGISTER();
                if (URL_DEVICE_REGISTER == null) {
                    throw new IllegalArgumentException("url is null");
                }
                int length = URL_DEVICE_REGISTER.length;
                int i2 = 0;
                while (i2 < length) {
                    String str3 = URL_DEVICE_REGISTER[i2];
                    byte[] bArr = (byte[]) bytes.clone();
                    if (StringUtils.isEmpty(str3)) {
                        i = i2;
                    } else {
                        if (Logger.debug()) {
                            TLog.m73d("RegisterServiceController request url : " + str3);
                        }
                        boolean z = TextUtils.isEmpty(jSONObject.optString("device_id")) || TextUtils.isEmpty(jSONObject.optString("install_id"));
                        try {
                            if (getLogEncryptSwitch()) {
                                try {
                                    if (str3.indexOf(63) < 0) {
                                        str2 = str3 + "?";
                                    } else {
                                        str2 = str3 + "&";
                                    }
                                    doPost = NetUtil.sendEncryptLog(null, str2, bArr, RegisterServiceController.this.mContext, false, null, null, null, z, false);
                                    i = i2;
                                } catch (RuntimeException unused) {
                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                    i = i2;
                                    doPost = NetUtil.doPost(null, str3, bytes, true, "application/json; charset=utf-8", false, null, z, false);
                                }
                            } else {
                                i = i2;
                                doPost = NetUtil.doPost(null, str3, bytes, true, "application/json; charset=utf-8", false, null, z, false);
                            }
                            TLog.m79v("device_register response: " + doPost);
                            if (doPost != null) {
                                try {
                                    if (doPost.length() != 0) {
                                        if (updateDeviceInfo(new JSONObject(doPost))) {
                                            return true;
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                    if (!RegisterServiceController.this.shouldRetryWhenError(th)) {
                                        throw th;
                                    }
                                    i2 = i + 1;
                                }
                            }
                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                        } catch (Throwable th2) {
                            th = th2;
                            i = i2;
                        }
                    }
                    i2 = i + 1;
                }
                return false;
            } catch (Throwable unused2) {
                return false;
            }
        }

        private boolean updateDeviceInfo(JSONObject jSONObject) {
            String str;
            boolean z;
            if (jSONObject == null) {
                return false;
            }
            RegisterServiceController.this.mLastConfigVersion = RegistrationHeaderHelper.getVersionCode();
            boolean unused = RegisterServiceController.sIsNewUser = jSONObject.optInt("new_user", 0) > 0;
            SharedPreferences.Editor edit = RegisterServiceController.this.mStatsInfoSp.edit();
            edit.putInt(RegisterServiceController.KEY_LAST_CONFIG_VERSION, RegisterServiceController.this.mLastConfigVersion);
            edit.putString(RegisterServiceController.KEY_CHANNEL, RegistrationHeaderHelper.getChannelCompat(RegisterServiceController.this.mContext));
            String str2 = RegisterServiceController.this.mInstallId;
            String deviceId = RegisterServiceController.this.mDeviceParamsProvider.getDeviceId();
            boolean isEmpty = StringUtils.isEmpty(deviceId);
            final String optString = jSONObject.optString("install_id", null);
            final String optString2 = jSONObject.optString("device_id", null);
            String optString3 = jSONObject.optString(RegisterServiceController.KEY_DEVICE_TOKEN, "");
            String optString4 = jSONObject.optString(AppLogConstants.KLINK_EGDI, "");
            boolean isBadId = NetUtil.isBadId(optString2);
            boolean isBadId2 = NetUtil.isBadId(optString);
            boolean isBadId3 = NetUtil.isBadId(optString4);
            if (DeviceRegisterManager.isEnableGetEgdi() && !isBadId && isBadId3) {
                TLog.m73d("[egdi] has no egdi, try get egdi...");
                RegisterServiceController.this.onEgdiFailed();
            }
            if (isBadId || isBadId2) {
                str = str2;
            } else {
                str = str2;
                RegisterServiceController.this.mUpdateConfigTime = System.currentTimeMillis();
                edit.putLong(RegisterServiceController.KEY_LAST_CONFIG_TIME, RegisterServiceController.this.mUpdateConfigTime);
            }
            if (isBadId2 || optString.equals(RegisterServiceController.this.mInstallId)) {
                z = false;
            } else {
                RegisterServiceController.this.mInstallId = optString;
                if (!StringUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("old_id", str);
                        jSONObject2.put("new_id", optString);
                        RegisterServiceController.this.onEvent("iid_change", jSONObject2);
                    } catch (Exception unused2) {
                    }
                }
                z = true;
            }
            if (!isBadId && !optString2.equals(deviceId)) {
                RegisterServiceController.this.onEventDidChanged(deviceId, optString2);
                z = true;
            }
            if (isBadId && RegisterServiceController.sCustomMonitor != null) {
                RegisterServiceController.sCustomMonitor.monitorEvent("service_monitor", "diderror", 0, null, null);
            }
            if (z) {
                try {
                    RegisterServiceController.this.mHeader.put("install_id", RegisterServiceController.this.mInstallId);
                    RegisterServiceController.this.mHeader.put("device_id", optString2);
                    RegisterServiceController.this.mHeader.put(AppLogConstants.KLINK_EGDI, optString4);
                    edit.putString("install_id", RegisterServiceController.this.mInstallId);
                    edit.putString("device_id", optString2);
                    edit.putString(AppLogConstants.KLINK_EGDI, optString4);
                } catch (Exception unused3) {
                }
            }
            edit.putString(RegisterServiceController.KEY_DEVICE_TOKEN, optString3);
            edit.commit();
            if (z) {
                RegisterServiceController.this.mDeviceParamsProvider.updateDeviceId(optString2);
                RegisterServiceController.this.notifyDeviceInfoUpdate();
            }
            RegisterServiceController.this.notifyConfigUpdate(true, isEmpty);
            if (RegisterServiceController.this.mListener != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ss.android.deviceregister.core.RegisterServiceController.DeviceRegisterThread.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (RegisterServiceController.this) {
                            if (RegisterServiceController.this.mListener != null) {
                                RegisterServiceController.this.mListener.onDidUpdate(optString2, optString);
                                RegisterServiceController.this.mListener = null;
                            }
                        }
                    }
                });
            }
            return true ^ isBadId;
        }

        private boolean getLogEncryptSwitch() {
            return DeviceRegisterConfig.isEncrypt();
        }

        private int getBadIdCount() {
            boolean z = NetUtil.isBadId(RegisterServiceController.this.getDeviceId()) || NetUtil.isBadId(RegisterServiceController.this.getInstallId());
            if (z) {
                z = this.mBadDidCount > (NetworkUtils.isNetworkAvailable(RegisterServiceController.this.mContext) ? 3 : 10);
            }
            if (!z) {
                return 0;
            }
            int i = this.mBadDidCount + 1;
            this.mBadDidCount = i;
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oberserveNetwork() {
        if (this.mObservers == null) {
            this.mObservers = new NetworkObserver(this.mContext);
        }
        NetworkObserver.OnNetworkReadyListener onNetworkReadyListener = new NetworkObserver.OnNetworkReadyListener() { // from class: com.ss.android.deviceregister.core.RegisterServiceController.2
            @Override // com.ss.android.deviceregister.core.RegisterServiceController.NetworkObserver.OnNetworkReadyListener
            public void onNetworkReady() {
                TLog.m73d("Retry update device id");
                if (TextUtils.isEmpty(RegisterServiceController.this.mDeviceParamsProvider.getDeviceId())) {
                    RegisterServiceController.this.tryUpdateDeviceId();
                }
            }
        };
        this.listener = onNetworkReadyListener;
        this.mObservers.observe(onNetworkReadyListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class NetworkObserver {
        private final Context mContext;
        private final Set<WeakReference<OnNetworkReadyListener>> mListeners = Collections.synchronizedSet(new HashSet());
        private final AtomicBoolean mHasListenNetwork = new AtomicBoolean(false);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public interface OnNetworkReadyListener {
            void onNetworkReady();
        }

        public NetworkObserver(Context context) {
            this.mContext = context;
        }

        public synchronized void observe(OnNetworkReadyListener onNetworkReadyListener) {
            this.mListeners.add(new WeakReference<>(onNetworkReadyListener));
            tryListenNetChange();
        }

        private void tryListenNetChange() {
            if (this.mHasListenNetwork.compareAndSet(false, true)) {
                try {
                    m100x35638e31(this.mContext, new BroadcastReceiver() { // from class: com.ss.android.deviceregister.core.RegisterServiceController.NetworkObserver.1
                        private boolean isFirstCallback = true;

                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            if (this.isFirstCallback) {
                                this.isFirstCallback = false;
                            } else {
                                if (intent == null || intent.getBooleanExtra("noConnectivity", false) || !NetworkUtils.isNetworkAvailable(NetworkObserver.this.mContext)) {
                                    return;
                                }
                                NetworkObserver.this.notifyObserver();
                            }
                        }
                    }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyObserver() {
            Iterator<WeakReference<OnNetworkReadyListener>> it = this.mListeners.iterator();
            while (it.hasNext()) {
                OnNetworkReadyListener onNetworkReadyListener = it.next().get();
                if (onNetworkReadyListener != null) {
                    onNetworkReadyListener.onNetworkReady();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        
            r0.remove();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void unObserve(OnNetworkReadyListener onNetworkReadyListener) {
            Iterator<WeakReference<OnNetworkReadyListener>> it = this.mListeners.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<OnNetworkReadyListener> next = it.next();
                if (next == null) {
                    it.remove();
                } else if (next.get() == onNetworkReadyListener) {
                    break;
                }
            }
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
        /* renamed from: INVOKEVIRTUAL_com_ss_android_deviceregister_core_RegisterServiceController$NetworkObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
        public static Intent m100x35638e31(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                ReceiverRegisterCrashOptimizer.doHWReceiverFix();
            }
            try {
                if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                    ReceiverRegisterLancet.initHandler();
                    Context context2 = context;
                    return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
                }
                if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                    ReceiverRegisterLancet.initProxyHandler();
                    Context context3 = context;
                    return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception e) {
                if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                    throw e;
                }
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPreInstallInfo(JSONObject jSONObject) throws JSONException {
        if (sPreInstallChannelCallback != null) {
            jSONObject.put(AppLogConstants.KEY_PRE_INSTALL_CHANNEL, sPreInstallChannelCallback.getChannel(this.mContext));
        }
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
            if (packageInfo != null) {
                jSONObject.put(AppLogConstants.KEY_FIRST_INSTALL_TIME, packageInfo.firstInstallTime);
                jSONObject.put(AppLogConstants.KEY_IS_SYSTEM_APP, (packageInfo.applicationInfo.flags & 1) == 1 ? 1 : 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldRetryWhenError(Throwable th) {
        if (th instanceof CommonHttpException) {
            int responseCode = ((CommonHttpException) th).getResponseCode();
            if (!this.isRetryLimit && responseCode >= 200 && responseCode != 301 && responseCode != 302) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLoadDidResult(boolean z) {
        DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener;
        int size = sListenerRef.size();
        for (int i = 0; i < size; i++) {
            WeakReference<DeviceRegisterManager.OnDeviceConfigUpdateListener> weakReference = sListenerRef.get(i);
            if (weakReference != null && (onDeviceConfigUpdateListener = weakReference.get()) != null) {
                try {
                    onDeviceConfigUpdateListener.onDidLoadLocally(z);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDeviceInfoUpdate() {
        DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener;
        RegistrationHeaderHelper.updateHeaderDidAndIid(this.mDeviceParamsProvider.getDeviceId(), this.mInstallId);
        int size = sListenerRef.size();
        for (int i = 0; i < size; i++) {
            WeakReference<DeviceRegisterManager.OnDeviceConfigUpdateListener> weakReference = sListenerRef.get(i);
            if (weakReference != null && (onDeviceConfigUpdateListener = weakReference.get()) != null) {
                try {
                    onDeviceConfigUpdateListener.onDeviceRegistrationInfoChanged(this.mDeviceParamsProvider.getDeviceId(), this.mInstallId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onEvent(String str, JSONObject jSONObject) {
        ILogDepend iLogDepend = sLogDepend;
        if (iLogDepend != null) {
            iLogDepend.onDeviceRegisterEvent(str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConfigUpdate(boolean z, boolean z2) {
        DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener;
        int size = sListenerRef.size();
        for (int i = 0; i < size; i++) {
            WeakReference<DeviceRegisterManager.OnDeviceConfigUpdateListener> weakReference = sListenerRef.get(i);
            if (weakReference != null && (onDeviceConfigUpdateListener = weakReference.get()) != null) {
                try {
                    onDeviceConfigUpdateListener.onRemoteConfigUpdate(z, z2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isNewUser() {
        return sIsNewUser;
    }

    @Override // com.ss.android.deviceregister.EgdiManager.EgdiCallback
    public void onEgdiFailed() {
        this.egdiManager.handleEgid(this);
    }

    public String getEgdi() {
        return this.egdiManager.getEgdi();
    }
}
