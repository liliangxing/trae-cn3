package com.ss.android.common.applog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.IAbSdkVersion;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.IEventObserver;
import com.bytedance.applog.ILogCompressor;
import com.bytedance.applog.ISessionObserver;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.isolate.IDataIsolateCallback;
import com.bytedance.applog.task.BgSessionTaskCallback;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.IAbContext;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallUrl;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.service.middleware.applog.IHeaderCustomTimelyCallback;
import com.ss.android.common.AppContext;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.LogTrace;
import com.ss.android.common.applog.UserProfileHelper;
import com.ss.android.common.applog.task.TaskCallback;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.common.util.ILogger;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.BdtrackerImpl;
import com.ss.android.deviceregister.DeviceCategory;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.OnResetListener;
import com.ss.android.deviceregister.PreInstallChannelCallback;
import com.ss.android.deviceregister.SensitiveApiCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NewAppLogBdtrackerImpl implements IAppLogApi {
    private static final String TAG = "NewAppLogBdtrackerImpl";
    private static AppLog.IAbSdkVersion abSdkVersionCallback = null;
    private static volatile DeviceCategory deviceCategory = null;
    private static GlobalEventCallback globalEventCallback = null;
    private static volatile boolean isMainProcess = true;
    private static volatile String sAbSdkVersion = null;
    private static volatile IAliYunHandler sAliYunHandler = null;
    private static volatile AppContext sAppContext = null;
    private static volatile String sAppLanguage = null;
    private static volatile String sAppRegion = null;
    private static volatile String sAppVersionMinor = "";
    private static volatile boolean sChildMode = false;
    private static WeakReference<AppLog.ConfigUpdateListener> sConfigUpdateListener = null;
    private static volatile String sCustomDbName = null;
    private static volatile String sCustomSpName = null;
    private static volatile boolean sEnableMigrate = true;
    private static volatile int sEventFilterEnable = 0;
    private static volatile IHeaderCustomTimelyCallback sIHeaderCustomTimelyCallback = null;
    private static volatile InitConfig sInitConfig = null;
    private static volatile boolean sInitGuard = false;
    private static volatile AppLog.ILogEncryptConfig sLogEncryptConfig = null;
    private static volatile boolean sNetCommonOptEnabled = false;
    private static volatile DefaultSensitiveInterceptor sSensitiveInterceptor = null;
    private static volatile String sSessionKey = "";
    private static long sStartDelay;
    private static volatile String sUserUniqueId;
    private final List<Object[]> launchListenerMap = new ArrayList();
    private ILogger mLogger = null;
    private static final Bundle sCustomBundle = new Bundle();
    private static final ConcurrentHashMap<AppLog.ILogSessionHook, ISessionObserver> sSessionHookMap = new ConcurrentHashMap<>();

    @Override // com.ss.android.common.applog.IAppLogApi
    public void addAppCount() {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public int checkHttpRequestException(Throwable th, String[] strArr) {
        return 1;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public int getEncodeType() {
        return 0;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public long getLastActiveTime() {
        return 0L;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onActivityCreate(Context context) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onActivityCreate(String str) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onAppQuit() {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onImageFailure() {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onImageFailure(String str, int i, int i2) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onImageSample(String str, int i, long j) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onImageSuccess() {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onQuit() {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void registerLogRequestCallback(LogTrace.LogRequestTraceCallback logRequestTraceCallback) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setCollectFreeSpace(boolean z, AppLog.FreeSpaceCollector freeSpaceCollector) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setCustomInfo(AppLog.ICustomInfo iCustomInfo) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEncryptCountSPName(String str) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setMyPushIncludeValues(boolean z) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setPushCustomValues(boolean z, boolean z2, boolean z3, boolean z4) {
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setUseGoogleAdId(boolean z) {
    }

    private static void assertNotInit() {
        if (sInitGuard) {
            throw new IllegalStateException("please call before init!");
        }
    }

    public static void setBDInstallEventTrack(boolean z) {
        com.bytedance.applog.AppLog.setBDInstallEventTrackEnabled(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAnonymous(boolean z) {
        if (sInitGuard) {
            return;
        }
        DeviceRegisterManager.setAnonymous(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setDBNamme(String str) {
        sCustomDbName = str;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setSPName(String str) {
        sCustomSpName = str;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAppContext(final AppContext appContext) {
        sAppContext = appContext;
        BDInstall.setAppContext(new com.bytedance.bdinstall.AppContext() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.1
            public boolean isMainInstance() {
                return true;
            }

            public Context getContext() {
                return appContext.getContext();
            }

            public String getAppName() {
                return appContext.getAppName();
            }

            public String getVersion() {
                return appContext.getVersion();
            }

            public String getChannel() {
                return appContext.getChannel();
            }

            public String getTweakedChannel() {
                return appContext.getTweakedChannel();
            }

            public long getVersionCode() {
                return appContext.getVersionCode();
            }

            public long getUpdateVersionCode() {
                return appContext.getUpdateVersionCode();
            }

            public long getManifestVersionCode() {
                return appContext.getManifestVersionCode();
            }

            public int getAid() {
                return appContext.getAid();
            }

            public String getAbVersion() {
                return appContext.getAbVersion();
            }

            public String getAbClient() {
                return appContext.getAbClient();
            }

            public String getAbGroup() {
                return appContext.getAbGroup();
            }

            public String getAbFeature() {
                return appContext.getAbFeature();
            }

            public long getAbFlag() {
                return appContext.getAbFlag();
            }
        });
        DeviceRegisterManager.setAppContext(appContext);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void init(Context context, boolean z, UrlConfig urlConfig) {
        boolean z2;
        boolean z3;
        if (sAppContext == null) {
            throw new IllegalStateException("wrapper AppContext should be set before init!");
        }
        com.bytedance.applog.AppLog.setBgSessionTaskEnabled(false);
        long j = AppLog.sUserId.get();
        if (j > 0 && com.bytedance.applog.AppLog.getUserID() == null) {
            com.bytedance.applog.AppLog.setUserID(j);
        }
        sInitConfig = new InitConfig(String.valueOf(DeviceRegisterManager.getAppId()), DeviceRegisterManager.getChannel(context));
        sInitConfig.setAutoStart(sStartDelay <= 0);
        initUriConfig(sInitConfig, urlConfig);
        sInitConfig.setAutoActive(z);
        if (sLogEncryptConfig != null) {
            try {
                z2 = sLogEncryptConfig.getEncryptSwitch();
            } catch (Throwable th) {
                TLog.m76e("NewAppLogBdtrackerImpl getEncryptSwitch", th);
                z2 = true;
            }
            try {
                z3 = sLogEncryptConfig.getRecoverySwitch();
            } catch (Throwable th2) {
                TLog.m76e("NewAppLogBdtrackerImpl getRecoverySwitch", th2);
                z3 = true;
            }
        } else {
            z2 = true;
            z3 = true;
        }
        com.bytedance.applog.AppLog.setEncryptAndCompress(z2);
        sInitConfig.setCongestionControlEnable(z3);
        sInitConfig.setAnonymous(BdtrackerImpl.getAnonymous());
        sInitConfig.setEventFilterEnable(sEventFilterEnable > 0);
        String fakePackage = DeviceRegisterManager.getFakePackage();
        if (!TextUtils.isEmpty(fakePackage)) {
            sInitConfig.setZiJieCloudPkg(fakePackage);
        }
        final PreInstallChannelCallback preInstallChannelCallback = BdtrackerImpl.getPreInstallChannelCallback();
        if (preInstallChannelCallback != null) {
            sInitConfig.setPreInstallChannelCallback(new com.bytedance.bdinstall.PreInstallChannelCallback() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.2
                public String getChannel(Context context2) {
                    return preInstallChannelCallback.getChannel(context2);
                }
            });
        }
        sInitConfig.setNeedAntiCheating(BdtrackerImpl.getAntiCheatingSwitch());
        sInitConfig.setVersionMinor(sAppVersionMinor);
        if (!TextUtils.isEmpty(sCustomDbName)) {
            sInitConfig.setDbName(sCustomDbName);
        }
        if (!TextUtils.isEmpty(sCustomSpName)) {
            sInitConfig.setSpName(sCustomSpName);
        }
        String customVersion = DeviceRegisterManager.getCustomVersion();
        if (!TextUtils.isEmpty(customVersion)) {
            sInitConfig.setVersion(customVersion);
        } else if (!TextUtils.isEmpty(sAppContext.getVersion())) {
            sInitConfig.setVersion(sAppContext.getVersion());
        }
        if (!TextUtils.isEmpty(sAppLanguage)) {
            sInitConfig.setLanguage(sAppLanguage);
        }
        if (!TextUtils.isEmpty(sAppRegion)) {
            sInitConfig.setRegion(sAppRegion);
        }
        String releaseBuild = BdtrackerImpl.getReleaseBuild();
        if (!TextUtils.isEmpty(releaseBuild)) {
            sInitConfig.setReleaseBuild(releaseBuild);
        }
        if (sAliYunHandler != null) {
            String cloudUUID = sAliYunHandler.getCloudUUID();
            if (!TextUtils.isEmpty(cloudUUID)) {
                sInitConfig.setAliyunUdid(cloudUUID);
            }
        }
        sInitConfig.setBDInstallInitHook(AppLog.getBDInstallInitHook());
        sInitConfig.setLocalTest(DeviceRegisterManager.isLocalTest());
        if (!TextUtils.isEmpty(sAppContext.getAppName())) {
            sInitConfig.setAppName(sAppContext.getAppName());
        }
        if (sAppContext.getVersionCode() != 0) {
            sInitConfig.setVersionCode(sAppContext.getVersionCode());
        }
        if (sAppContext.getUpdateVersionCode() != 0) {
            sInitConfig.setUpdateVersionCode(sAppContext.getUpdateVersionCode());
        }
        if (!TextUtils.isEmpty(sAppContext.getTweakedChannel())) {
            sInitConfig.setTweakedChannel(sAppContext.getTweakedChannel());
        }
        if (sAppContext.getManifestVersionCode() != 0) {
            sInitConfig.setManifestVersionCode(sAppContext.getManifestVersionCode());
        }
        if (!TextUtils.isEmpty(sAppContext.getManifestVersion())) {
            sInitConfig.setManifestVersion(sAppContext.getManifestVersion());
        }
        sInitConfig.setAbContext(new IAbContext() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.3
            public String getAbClient() {
                return NewAppLogBdtrackerImpl.sAppContext.getAbClient();
            }

            public long getAbFlag() {
                return NewAppLogBdtrackerImpl.sAppContext.getAbFlag();
            }

            public String getAbVersion() {
                return NewAppLogBdtrackerImpl.sAppContext.getAbVersion();
            }

            public String getAbGroup() {
                return NewAppLogBdtrackerImpl.sAppContext.getAbGroup();
            }

            public String getAbFeature() {
                return NewAppLogBdtrackerImpl.sAppContext.getAbFeature();
            }
        });
        sInitConfig.setNetworkClient(new INetworkClient() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.4
            public String get(String str, Map<String, String> map) throws RangersHttpException {
                try {
                    return NetworkClient.getDefault().get(str, map, (NetworkClient.ReqContext) null);
                } catch (Exception e) {
                    if (e instanceof CommonHttpException) {
                        CommonHttpException commonHttpException = e;
                        throw new RangersHttpException(commonHttpException.getResponseCode(), commonHttpException.getCause());
                    }
                    throw new RangersHttpException(400, e.getCause());
                }
            }

            public String post(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
                try {
                    return NetworkClient.getDefault().post(str, bArr, map, (NetworkClient.ReqContext) null);
                } catch (CommonHttpException e) {
                    throw new RangersHttpException(e.getResponseCode(), e.getCause());
                }
            }

            public String post(String str, byte[] bArr, String str2) throws RangersHttpException {
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("Content-Type", str2);
                }
                return post(str, bArr, hashMap);
            }

            public String post(String str, List<Pair<String, String>> list) throws RangersHttpException {
                try {
                    return NetworkClient.getDefault().post(str, list);
                } catch (CommonHttpException e) {
                    throw new RangersHttpException(e.getResponseCode(), e.getCause());
                }
            }

            public byte[] postStream(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
                try {
                    return NetworkClient.getDefault().postDataStream(str, bArr, map, (NetworkClient.ReqContext) null);
                } catch (CommonHttpException e) {
                    throw new RangersHttpException(e.getResponseCode(), e.getCause());
                }
            }
        });
        if (this.mLogger != null) {
            sInitConfig.setLogEnable(true);
            com.bytedance.bdinstall.ILogger iLogger = new com.bytedance.bdinstall.ILogger() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.5
                /* renamed from: v */
                public void m62v(String str, Throwable th3) {
                    NewAppLogBdtrackerImpl.this.mLogger.m67v(str, th3);
                }

                /* renamed from: d */
                public void m59d(String str, Throwable th3) {
                    NewAppLogBdtrackerImpl.this.mLogger.m64d(str, th3);
                }

                /* renamed from: w */
                public void m63w(String str, Throwable th3) {
                    NewAppLogBdtrackerImpl.this.mLogger.m68w(str, th3);
                }

                /* renamed from: i */
                public void m61i(String str, Throwable th3) {
                    NewAppLogBdtrackerImpl.this.mLogger.m66i(str, th3);
                }

                /* renamed from: e */
                public void m60e(String str, Throwable th3) {
                    NewAppLogBdtrackerImpl.this.mLogger.m65e(str, th3);
                }
            };
            sInitConfig.setLogger(iLogger);
            BDInstall.setLogger(iLogger);
        } else {
            sInitConfig.setLogEnable(false);
        }
        sInitConfig.setTouristMode(com.bytedance.applog.AppLog.isTouristMode());
        sInitConfig.setAppTraitCallback(DeviceRegisterManager.getAppTraitCallback());
        sInitConfig.setEnableListenNetChange(AppLog.isEnableListenNetChange());
        sInitConfig.setProcess(isMainProcess);
        sInitConfig.setNetCommOptEnabled(sNetCommonOptEnabled);
        sInitConfig.setOneKeyMigrateDetectEnabled(sEnableMigrate);
        sInitConfig.setDefaultSensitiveInterceptor(sSensitiveInterceptor);
        if (deviceCategory != null) {
            try {
                sInitConfig.setDeviceCategory(com.bytedance.bdinstall.util.DeviceCategory.valueOf(deviceCategory.name()));
            } catch (Throwable unused) {
                TLog.m75e("Cannot convert device category info.");
            }
        }
        com.bytedance.applog.AppLog.init(context, sInitConfig);
        if (!TextUtils.isEmpty(sAbSdkVersion)) {
            com.bytedance.applog.AppLog.setExternalAbVersion(sAbSdkVersion);
        } else if (!TextUtils.isEmpty(AppLog.tempAbSDKVersion)) {
            setAbSDKVersion(AppLog.tempAbSDKVersion);
        }
        if (abSdkVersionCallback == null && AppLog.sIAbSdkVersion != null) {
            registerAbSdkVersionCallback(AppLog.sIAbSdkVersion);
        }
        if (sIHeaderCustomTimelyCallback == null && AppLog.sIHeaderCustomTimelyCallback != null) {
            registerHeaderCustomCallback(AppLog.sIHeaderCustomTimelyCallback);
        }
        if (globalEventCallback == null && AppLog.sGlobalEventCallback != null) {
            registerGlobalEventCallback(AppLog.sGlobalEventCallback);
        }
        com.bytedance.applog.AppLog.removeHeaderInfo("_debug_flag");
        if (!TextUtils.isEmpty(sUserUniqueId)) {
            com.bytedance.applog.AppLog.setUserUniqueID(sUserUniqueId);
        }
        sInitGuard = true;
        if (sStartDelay > 0) {
            TeaThread.getInst().postDelay(new Runnable() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.applog.AppLog.start();
                    NewAppLogBdtrackerImpl.this.setInitCustomHeader();
                }
            }, sStartDelay);
        } else {
            setInitCustomHeader();
        }
        ApplogServiceImpl.isServicePrepared = true;
        ApplogServiceImpl.handleCachedData();
        TLog.m78i("wrapper bdtracker init!", null);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAllowPushService(int i, int i2) {
        notifyConfigUpdate();
    }

    private static void initUriConfig(InitConfig initConfig, UrlConfig urlConfig) {
        String str;
        String[] strArr;
        if (urlConfig == null) {
            initConfig.setUriConfig(0);
            return;
        }
        UriConfig.Builder builder = new UriConfig.Builder();
        String[] registerUrls = BdtrackerImpl.getRegisterUrls();
        if (registerUrls != null && registerUrls.length > 0) {
            int length = registerUrls.length;
            for (int i = 0; i < length; i++) {
                str = registerUrls[i];
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        str = null;
        if (TextUtils.isEmpty(str) && (strArr = urlConfig.mDeviceRegisterUrl) != null && strArr.length > 0) {
            int length2 = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                String str2 = strArr[i2];
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                    break;
                }
                i2++;
            }
        }
        String activeUrl = BdtrackerImpl.getActiveUrl();
        if (TextUtils.isEmpty(activeUrl)) {
            activeUrl = urlConfig.mAppActiveUrl[0];
        }
        builder.setInstallEnv(new Env(new InstallUrl(str, activeUrl), false, BdtrackerImpl.getIsBoe(), sChildMode));
        ArrayList arrayList = new ArrayList();
        if (urlConfig.mApplogURL != null && urlConfig.mApplogURL.length > 0) {
            for (String str3 : urlConfig.mApplogURL) {
                if (!TextUtils.isEmpty(str3)) {
                    arrayList.add(str3);
                }
            }
        }
        if (urlConfig.mApplogFallbackUrl != null && urlConfig.mApplogFallbackUrl.length > 0) {
            for (String str4 : urlConfig.mApplogFallbackUrl) {
                if (!TextUtils.isEmpty(str4)) {
                    arrayList.add(str4);
                }
            }
        }
        builder.setSendUris((String[]) arrayList.toArray(new String[arrayList.size()]));
        builder.setRealUris(urlConfig.mApplogTimelyUrl);
        if (!TextUtils.isEmpty(urlConfig.mApplogSettingsUrl)) {
            builder.setSettingUri(urlConfig.mApplogSettingsUrl);
        } else {
            builder.setSettingUri(urlConfig.mApplogSettingsFallbackUrl);
        }
        initConfig.setUriConfig(builder.build());
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public int getHttpMonitorPort() {
        return com.bytedance.applog.AppLog.getHttpMonitorPort();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setHttpMonitorPort(int i) {
        com.bytedance.applog.AppLog.setHttpMonitorPort(i);
        notifyConfigUpdate();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAppTrack(JSONObject jSONObject) {
        com.bytedance.applog.AppLog.setAppTrack(jSONObject);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void getSSIDs(Map<String, String> map) {
        if (map != null) {
            com.bytedance.applog.AppLog.getSsidGroup(map);
            String userID = com.bytedance.applog.AppLog.getUserID();
            if (userID != null) {
                map.put("user_id", userID);
            }
        }
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setCustomerHeader(Bundle bundle) {
        if (bundle == null || bundle.size() <= 0) {
            return;
        }
        try {
            if (com.bytedance.applog.AppLog.hasStarted()) {
                HashMap hashMap = new HashMap();
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                com.bytedance.applog.AppLog.setHeaderInfo(hashMap);
                return;
            }
            Bundle bundle2 = sCustomBundle;
            synchronized (bundle2) {
                bundle2.putAll(bundle);
            }
        } catch (Throwable th) {
            TLog.m76e("NewAppLogBdtrackerImpl setCustomerHeader", th);
        }
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getInstallId() {
        return com.bytedance.applog.AppLog.getIid();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setSessionKey(String str) {
        sSessionKey = str;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getSessionKey() {
        return sSessionKey;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getUserId() {
        return com.bytedance.applog.AppLog.getUserID();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setUserId(long j) {
        com.bytedance.applog.AppLog.setUserID(j);
        notifyConfigUpdate();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getClientId() {
        return com.bytedance.applog.AppLog.getClientUdid();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getServerDeviceId() {
        return com.bytedance.applog.AppLog.getDid();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public boolean isBadDeviceId(String str) {
        return !Utils.checkId(str);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getVersion(Context context) {
        return DeviceRegisterManager.getVersionName();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setDefaultUserAgent(String str) {
        com.bytedance.applog.AppLog.setUserAgent(str);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAppLanguageAndRegion(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (com.bytedance.applog.AppLog.hasStarted()) {
            com.bytedance.applog.AppLog.setAppLanguageAndRegion(str, str2);
        } else {
            sAppLanguage = str;
            sAppRegion = str2;
        }
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void addSessionHook(final AppLog.ILogSessionHook iLogSessionHook) {
        if (iLogSessionHook == null) {
            return;
        }
        ISessionObserver iSessionObserver = new ISessionObserver() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.7
            public void onSessionStart(long j, String str) {
                iLogSessionHook.onLogSessionStart(j);
            }

            public void onSessionTerminate(long j, String str, JSONObject jSONObject) {
                iLogSessionHook.onLogSessionTerminate(j, str, jSONObject);
            }

            public void onSessionBatchEvent(long j, String str, JSONObject jSONObject) {
                iLogSessionHook.onLogSessionBatchEvent(j, str, jSONObject);
            }
        };
        sSessionHookMap.put(iLogSessionHook, iSessionObserver);
        com.bytedance.applog.AppLog.addSessionHook(iSessionObserver);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void removeSessionHook(AppLog.ILogSessionHook iLogSessionHook) {
        if (iLogSessionHook == null) {
            return;
        }
        com.bytedance.applog.AppLog.removeSessionHook(sSessionHookMap.remove(iLogSessionHook));
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setLogEncryptConfig(AppLog.ILogEncryptConfig iLogEncryptConfig) {
        if (sInitGuard) {
            return;
        }
        sLogEncryptConfig = iLogEncryptConfig;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject) {
        String str4 = null;
        if (jSONObject != null && jSONObject.optInt("_event_v3") == 1) {
            jSONObject.remove("_event_v3");
            jSONObject.remove(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);
            jSONObject.remove(AppLog.KEY_AB_SDK_VERSION);
            try {
                try {
                    str4 = jSONObject.toString();
                } catch (ConcurrentModificationException unused) {
                    str4 = AppLogNewUtils.copyJson(jSONObject).toString();
                }
            } catch (Throwable unused2) {
            }
            com.bytedance.applog.AppLog.getInstance().onEventV3String(str2, str4);
            return;
        }
        try {
            if (jSONObject != null) {
                try {
                    str4 = jSONObject.toString();
                } catch (ConcurrentModificationException unused3) {
                    str4 = AppLogNewUtils.copyJson(jSONObject).toString();
                }
            }
        } catch (Throwable unused4) {
        }
        com.bytedance.applog.AppLog.getInstance().onEventString(str, str2, str3, j, j2, str4);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getCurrentSessionId() {
        return com.bytedance.applog.AppLog.getSessionId();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void recordMiscLog(Context context, String str, JSONObject jSONObject) {
        com.bytedance.applog.AppLog.onMiscEvent(str, jSONObject);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAliYunHanlder(IAliYunHandler iAliYunHandler) {
        if (sInitGuard) {
            return;
        }
        sAliYunHandler = iAliYunHandler;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onResume(Context context) {
        com.bytedance.applog.AppLog.onResume(context);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onResume(Context context, String str, int i) {
        com.bytedance.applog.AppLog.onActivityResumed(str, i);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onPause(Context context) {
        com.bytedance.applog.AppLog.onPause(context);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onPause(Context context, String str, int i) {
        onPause(context);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public AppLog getInstance(Context context) {
        return AppLog.getInstance(context, true);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public JSONObject getHeaderCopy() {
        return com.bytedance.applog.AppLog.getHeader();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setConfigUpdateListener(final AppLog.ConfigUpdateListener configUpdateListener) {
        if (configUpdateListener == null) {
            sConfigUpdateListener = null;
        } else {
            sConfigUpdateListener = new WeakReference<>(configUpdateListener);
            com.bytedance.applog.AppLog.addDataObserver(new IDataObserver() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.8
                public void onAbVidsChange(String str, String str2) {
                }

                public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
                }

                public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
                }

                public void onIdLoaded(String str, String str2, String str3) {
                    configUpdateListener.onConfigUpdate();
                }

                public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
                    configUpdateListener.onConfigUpdate();
                    configUpdateListener.onRemoteConfigUpdate(jSONObject != null);
                }
            });
        }
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setConfigUpdateListener(final AppLog.ConfigUpdateListenerEnhanced configUpdateListenerEnhanced) {
        if (configUpdateListenerEnhanced == null) {
            sConfigUpdateListener = null;
        } else {
            sConfigUpdateListener = new WeakReference<>(configUpdateListenerEnhanced);
            com.bytedance.applog.AppLog.addDataObserver(new IDataObserver() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.9
                public void onAbVidsChange(String str, String str2) {
                }

                public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
                }

                public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
                }

                public void onIdLoaded(String str, String str2, String str3) {
                    configUpdateListenerEnhanced.onConfigUpdate();
                }

                public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
                    configUpdateListenerEnhanced.handleConfigUpdate(jSONObject);
                    configUpdateListenerEnhanced.onConfigUpdate();
                    configUpdateListenerEnhanced.onRemoteConfigUpdate(jSONObject != null);
                }
            });
        }
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getSigHash(Context context) {
        return (String) com.bytedance.applog.AppLog.getHeaderValue("sig_hash", "", String.class);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public JSONObject getTimeSync() {
        return com.bytedance.applog.AppLog.getInstance().getApi().mTimeSync;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void activeUser(Context context) {
        com.bytedance.applog.AppLog.manualActivate();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void userProfileCheck(UserProfileHelper.UserProfileCheckCallback userProfileCheckCallback) {
        if (com.bytedance.applog.AppLog.hasStarted()) {
            Context context = com.bytedance.applog.AppLog.getContext();
            String did = com.bytedance.applog.AppLog.getDid();
            String aid = com.bytedance.applog.AppLog.getAid();
            if (!TextUtils.isEmpty(did) && !TextUtils.isEmpty(aid) && !TextUtils.isEmpty("")) {
                if (userProfileCheckCallback != null) {
                    userProfileCheckCallback.onCheckSuccess(aid, context, did, "");
                    return;
                }
                return;
            }
        }
        if (userProfileCheckCallback != null) {
            userProfileCheckCallback.onCheckFail();
        }
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAbSDKVersion(String str) {
        sAbSdkVersion = str;
        com.bytedance.applog.AppLog.setExternalAbVersion(str);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getAbSDKVersion() {
        String abSdkVersion = com.bytedance.applog.AppLog.getAbSdkVersion();
        return !TextUtils.isEmpty(abSdkVersion) ? abSdkVersion : sAbSdkVersion;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void registerGlobalEventCallback(GlobalEventCallback globalEventCallback2) {
        if (globalEventCallback2 == null) {
            return;
        }
        boolean z = globalEventCallback != null;
        globalEventCallback = globalEventCallback2;
        if (z) {
            return;
        }
        com.bytedance.applog.AppLog.addEventObserver(new IEventObserver() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.10
            public void onMiscEvent(String str, String str2) {
            }

            public void onEvent(String str, String str2, String str3, long j, long j2, String str4) {
                NewAppLogBdtrackerImpl.globalEventCallback.onEvent(str, str2, str3, j, j2, false, str4);
            }

            public void onEventV3(String str, String str2) {
                NewAppLogBdtrackerImpl.globalEventCallback.onEvent("event_v3", str, null, 0L, 0L, false, str2);
            }
        });
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        sIHeaderCustomTimelyCallback = iHeaderCustomTimelyCallback;
        com.bytedance.applog.AppLog.registerHeaderCustomCallback(new com.bytedance.applog.IHeaderCustomTimelyCallback() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.11
            public void updateHeader(JSONObject jSONObject) {
                if (NewAppLogBdtrackerImpl.sIHeaderCustomTimelyCallback != null) {
                    NewAppLogBdtrackerImpl.sIHeaderCustomTimelyCallback.updateHeader(jSONObject);
                }
            }
        });
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public IHeaderCustomTimelyCallback getIHeaderCustomTimelyCallback() {
        return sIHeaderCustomTimelyCallback;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getAppVersionMinor() {
        return sAppVersionMinor;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAppVersionMinor(String str) {
        sAppVersionMinor = str;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public String getUserUniqueId() {
        return sUserUniqueId;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setUserUniqueId(String str) {
        sUserUniqueId = str;
        com.bytedance.applog.AppLog.setUserUniqueID(str);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEventFilterByClient(List<String> list, boolean z) {
        com.bytedance.applog.AppLog.setEventFilterByClient(list, z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setChildModeBeforeInit(boolean z) {
        sChildMode = z;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void clearWhenSwitchChildMode(boolean z) {
        com.bytedance.applog.AppLog.clearWhenSwitchChildMode(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void resetDidWhenSwitchChildMode(Context context, boolean z, long j, final OnResetListener onResetListener) {
        com.bytedance.applog.AppLog.resetDidWhenSwitchChildMode(context, z, j, new com.bytedance.bdinstall.OnResetListener() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.12
            public void onDidUpdate(InstallInfo installInfo) {
                if (installInfo != null) {
                    onResetListener.onDidUpdate(installInfo.getDid(), installInfo.getIid());
                } else {
                    onResetListener.onDidUpdate(null, null);
                }
            }

            public void onTimeout() {
                onResetListener.onTimeout();
            }
        });
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEventFilterEnable(Context context, int i) {
        sEventFilterEnable = i;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEventSamplingEnable(boolean z) {
        com.bytedance.applog.AppLog.setEventSamplingEnable(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setTeaEventSamplingEnable(boolean z) {
        com.bytedance.applog.AppLog.setTeaEventSamplingEnable(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void registerAbSdkVersionCallback(AppLog.IAbSdkVersion iAbSdkVersion) {
        abSdkVersionCallback = iAbSdkVersion;
        com.bytedance.applog.AppLog.registerAbSdkVersionCallback(new IAbSdkVersion() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.13
            public String getAbSdkVersion(String str) {
                if (NewAppLogBdtrackerImpl.abSdkVersionCallback == null) {
                    return null;
                }
                return NewAppLogBdtrackerImpl.abSdkVersionCallback.getAbSdkVersion(str);
            }
        });
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEnableEventUserId(boolean z) {
        com.bytedance.applog.AppLog.setEnableEventUserId(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setTouristMode(boolean z) {
        com.bytedance.applog.AppLog.setTouristMode(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEnableEventInTouristMode(boolean z) {
        com.bytedance.applog.AppLog.setEnableEventInTouristMode(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setAdjustTerminate(boolean z) {
        com.bytedance.applog.AppLog.setAdjustTerminate(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void flush() {
        com.bytedance.applog.AppLog.flush();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setBDAccountCallback(IBDAccountCallback iBDAccountCallback) {
        com.bytedance.applog.AppLog.setBDAccountCallback(iBDAccountCallback);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setLogger(ILogger iLogger) {
        this.mLogger = iLogger;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setDisablePersonalization(int i) {
        com.bytedance.applog.AppLog.setDisablePersonalization(i);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void addLaunchObserver(final ILaunchObserver iLaunchObserver) {
        com.bytedance.applog.ILaunchObserver iLaunchObserver2 = new com.bytedance.applog.ILaunchObserver() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.14
            public void onLaunch(String str, long j, boolean z) {
                iLaunchObserver.onLaunch(str, j, z);
            }
        };
        this.launchListenerMap.add(new Object[]{iLaunchObserver, iLaunchObserver2});
        com.bytedance.applog.AppLog.addLaunchObserver(iLaunchObserver2);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void removeLaunchObserver(ILaunchObserver iLaunchObserver) {
        Object[] objArr;
        Iterator<Object[]> it = this.launchListenerMap.iterator();
        while (true) {
            if (!it.hasNext()) {
                objArr = null;
                break;
            } else {
                objArr = it.next();
                if (objArr[0] == iLaunchObserver) {
                    break;
                }
            }
        }
        if (objArr != null) {
            com.bytedance.applog.AppLog.removeLaunchObserver((com.bytedance.applog.ILaunchObserver) objArr[1]);
            this.launchListenerMap.remove(objArr);
        }
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setLogCompressor(ILogCompressor iLogCompressor) {
        com.bytedance.applog.AppLog.setLogCompressor(iLogCompressor);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public ILogCompressor getLogCompressor() {
        return com.bytedance.applog.AppLog.getLogCompressor();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setStartLogReaperDelay(long j) {
        sStartDelay = j;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setIsMainProcess(boolean z) {
        isMainProcess = z;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setNewMonitorEnabled(boolean z) {
        com.bytedance.applog.AppLog.setNewMonitorEnabled(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onTaskResume(Context context) {
        com.bytedance.applog.AppLog.onBgSessionTaskResume();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void onTaskPause(Context context) {
        com.bytedance.applog.AppLog.onBgSessionTaskPause();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void registerTaskCallback(final TaskCallback taskCallback) {
        if (taskCallback == null) {
            return;
        }
        com.bytedance.applog.AppLog.registerBgSessionTaskCallback(new BgSessionTaskCallback() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.15
            public boolean isTaskRunning() {
                return taskCallback.isTaskRunning();
            }
        });
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setDeviceCategory(DeviceCategory deviceCategory2) {
        deviceCategory = deviceCategory2;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEnableNetCommOpt(boolean z) {
        sNetCommonOptEnabled = z;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public boolean isEnableNetCommOpt() {
        return sNetCommonOptEnabled;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEnableMigrate(boolean z) {
        sEnableMigrate = z;
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setSensitiveApiCallback(SensitiveApiCallback sensitiveApiCallback) {
        if (sensitiveApiCallback == null) {
            sSensitiveInterceptor = null;
        } else {
            sSensitiveInterceptor = new DefaultSensitiveInterceptorAdaptor(sensitiveApiCallback);
        }
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public boolean isNewUser() {
        return com.bytedance.applog.AppLog.isNewUser();
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setTerminateImmediately(boolean z) {
        com.bytedance.applog.AppLog.setTerminateImmediately(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEnableGetEgdi(boolean z) {
        BDInstallAdaptor.setEnableGetEgdi(z);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setEgdiRetryInterval(int i) {
        BDInstallAdaptor.setEgdiRetryInterval(i);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setUserIdIsolateEnabled(boolean z) {
        com.bytedance.applog.AppLog.setDataIsolateEnabled(z);
        com.bytedance.applog.AppLog.setDataIsolateKey(DataIsolateKey.USER_ID);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public void setUserIdIsolateCallback(final UserIdIsolateCallback userIdIsolateCallback) {
        com.bytedance.applog.AppLog.setDataIsolateCallback(new IDataIsolateCallback() { // from class: com.ss.android.common.applog.NewAppLogBdtrackerImpl.16
            public boolean beforeIsolate() {
                userIdIsolateCallback.beforeIsolate();
                return false;
            }

            public boolean allowIsolateDataReport(DataIsolateKey dataIsolateKey, String str) {
                if (dataIsolateKey == DataIsolateKey.USER_ID) {
                    return userIdIsolateCallback.allowIsolateDataReport(str);
                }
                return true;
            }

            public boolean afterIsolate() {
                userIdIsolateCallback.afterIsolate();
                return false;
            }

            public Map<String, String> generateIsolateHttpHeader() {
                return userIdIsolateCallback.generateIsolateHttpHeader();
            }
        });
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public boolean isHitStickySamplingDrop(String str) {
        return com.bytedance.applog.AppLog.isEventHitStickySamplingDrop(str);
    }

    @Override // com.ss.android.common.applog.IAppLogApi
    public boolean isHitStickySamplingDrop(String str, JSONObject jSONObject) {
        return com.bytedance.applog.AppLog.isEventHitStickySamplingDrop(str, jSONObject);
    }

    private void notifyConfigUpdate() {
        AppLog.ConfigUpdateListener configUpdateListener;
        WeakReference<AppLog.ConfigUpdateListener> weakReference = sConfigUpdateListener;
        if (weakReference == null || (configUpdateListener = weakReference.get()) == null) {
            return;
        }
        try {
            configUpdateListener.onConfigUpdate();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInitCustomHeader() {
        Bundle bundle = sCustomBundle;
        if (bundle.size() > 0) {
            Bundle bundle2 = new Bundle();
            synchronized (bundle) {
                bundle2.putAll(bundle);
            }
            HashMap hashMap = new HashMap();
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
            com.bytedance.applog.AppLog.setHeaderInfo(hashMap);
        }
    }
}
