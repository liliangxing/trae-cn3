package com.bytedance.applog.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.BDInstallInitHook;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.Builder;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorOptions;
import com.bytedance.bdinstall.HeaderUpdateListener;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IDataObserver;
import com.bytedance.bdinstall.IEncryptor;
import com.bytedance.bdinstall.IEventDepend;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BdInstallImpl implements IBdInstallService, IInstallListener {
    private static volatile boolean mPassLooper = true;
    private final AppLogInstance appLogInstance;
    private String cacheDeviceId;
    private String cacheIid;
    private InstallInfo cacheInstallInfo;
    private String cacheSsid;
    private volatile IBDInstallApi mBDInstallInstance;
    private volatile CustomHeaderAdapter mCustomHeaderAdapter;
    private volatile InstallOptions mOptions;
    private volatile Builder mBuilder = new Builder();
    private final ConcurrentHashMap<String, Object> customHeaderCache = new ConcurrentHashMap<>();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface OnHeaderAndInstallInfoCallback {
        void onLoad(JSONObject jSONObject, InstallInfo installInfo);

        void onUpdate(JSONObject jSONObject, InstallInfo installInfo);
    }

    public BdInstallImpl(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    public static void setPassLooper(boolean z) {
        mPassLooper = z;
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void init(ConfigManager configManager, Env env, Looper looper, BDInstallInitHook bDInstallInitHook) {
        final InitConfig initConfig = configManager.getInitConfig();
        this.mCustomHeaderAdapter = new CustomHeaderAdapter(this.appLogInstance, getBDInstallInstance());
        if (!this.customHeaderCache.isEmpty()) {
            this.mCustomHeaderAdapter.appendHeaderInfo(this.customHeaderCache);
            this.customHeaderCache.clear();
        }
        if (mPassLooper) {
            final Handler handler = new Handler(looper);
            ExecutorOptions executorOptions = new ExecutorOptions();
            executorOptions.networkExecutor = new Executor() { // from class: com.bytedance.applog.bdinstall.BdInstallImpl.1
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    if (handler.getLooper() == Looper.myLooper()) {
                        runnable.run();
                    } else {
                        handler.post(runnable);
                    }
                }
            };
            executorOptions.workLooper = looper;
            getBDInstallInstance().setExecutor(executorOptions, initConfig.getAid());
        }
        this.mBuilder.setContext(this.appLogInstance.getContext()).setAccount(initConfig.getAccount()).setAutoActive(initConfig.isAutoActive()).setAid(Integer.parseInt(initConfig.getAid())).setAnonymous(initConfig.getAnonymous()).setAppLanguage(initConfig.getLanguage()).setAppRegion(initConfig.getRegion()).setAppName(initConfig.getAppName()).setBDTrackerDepend(new IEventDepend() { // from class: com.bytedance.applog.bdinstall.BdInstallImpl.2
            @Override // com.bytedance.bdinstall.IEventDepend
            public void onEvent(String str, JSONObject jSONObject) {
                if (BdInstallImpl.this.appLogInstance.isBDInstallEventTrackEnabled()) {
                    BdInstallImpl.this.appLogInstance.onEventV3(str, jSONObject);
                }
            }
        }).setLogger(this.appLogInstance.isLogEnabled() ? new ILogger() { // from class: com.bytedance.applog.bdinstall.BdInstallImpl.3
            @Override // com.bytedance.bdinstall.ILogger
            /* renamed from: v */
            public void mo129v(String str, Throwable th) {
                if (th != null) {
                    BdInstallImpl.this.appLogInstance.getLogger().error(1, str, th, new Object[0]);
                } else {
                    BdInstallImpl.this.appLogInstance.getLogger().verbose(1, str, new Object[0]);
                }
            }

            @Override // com.bytedance.bdinstall.ILogger
            /* renamed from: d */
            public void mo126d(String str, Throwable th) {
                if (th != null) {
                    BdInstallImpl.this.appLogInstance.getLogger().error(1, str, th, new Object[0]);
                } else {
                    BdInstallImpl.this.appLogInstance.getLogger().debug(1, str, new Object[0]);
                }
            }

            @Override // com.bytedance.bdinstall.ILogger
            /* renamed from: w */
            public void mo130w(String str, Throwable th) {
                if (th != null) {
                    BdInstallImpl.this.appLogInstance.getLogger().error(1, str, th, new Object[0]);
                } else {
                    BdInstallImpl.this.appLogInstance.getLogger().warn(1, str, new Object[0]);
                }
            }

            @Override // com.bytedance.bdinstall.ILogger
            /* renamed from: i */
            public void mo128i(String str, Throwable th) {
                if (th != null) {
                    BdInstallImpl.this.appLogInstance.getLogger().error(1, str, th, new Object[0]);
                } else {
                    BdInstallImpl.this.appLogInstance.getLogger().info(1, str, new Object[0]);
                }
            }

            @Override // com.bytedance.bdinstall.ILogger
            /* renamed from: e */
            public void mo127e(String str, Throwable th) {
                BdInstallImpl.this.appLogInstance.getLogger().error(1, str, th, new Object[0]);
            }
        } : null).setChannel(initConfig.getChannel()).setTweakedChannel(initConfig.getTweakedChannel()).setIsLocalTest(initConfig.getLocalTest()).setTouristMode(initConfig.isTouristMode()).setSSTInfoProvider(initConfig.getSensitiveInfoProvider()).setAbContext(initConfig.getAbContext()).setDebug(false).setEncryptAndCompress(this.appLogInstance.getEncryptAndCompress()).setCustomInfo(initConfig.getCommonHeader()).setNetworkClient(new BDInstallNetworkClientWrapper(this.appLogInstance)).setManifestVersionCode(initConfig.getManifestVersionCode()).setVersionCode(initConfig.getVersionCode()).setVersionName(initConfig.getVersion()).setUpdateVersionCode(initConfig.getUpdateVersionCode()).setUpdateVersionName(initConfig.getVersionMinor()).setReleaseBuild(initConfig.getReleaseBuild()).setSilenceInBackground(initConfig.isSilenceInBackground()).setSpFileName(initConfig.getSpName()).setZijiePackage(initConfig.getZiJieCloudPkg()).setAntiCheatingEnable(initConfig.isAntiCheatingEnable()).isMainProcess(configManager.isMainProcess()).setPreInstallChannelCallback(initConfig.getPreInstallCallback()).setCustomHeaders(this.mCustomHeaderAdapter).setAppTraitCallback(initConfig.getAppTraitCallback()).enableListenNetChange(initConfig.isEnableListenNetChange()).setLogger(initConfig.getLogger()).setDeviceCategory(initConfig.getDeviceCategory()).setEnableNetCommOpt(initConfig.isNetCommOptEnabled()).enableOneKeyMigrateDetect(initConfig.isOneKeyMigrateDetectEnabled()).setSensitiveInterceptor(initConfig.getDefaultSensitiveInterceptor()).enableGetIPV6(initConfig.isCollectIpv6Enabled());
        if (initConfig.getEncryptor() != null) {
            this.mBuilder.setEncryptor(new IEncryptor() { // from class: com.bytedance.applog.bdinstall.BdInstallImpl.4
                @Override // com.bytedance.bdinstall.IEncryptor
                public byte[] encrypt(byte[] bArr, int i) {
                    com.bytedance.mpaas.IEncryptor encryptor = initConfig.getEncryptor();
                    return encryptor != null ? encryptor.encrypt(bArr, i) : new byte[0];
                }
            });
        }
        if (bDInstallInitHook != null) {
            bDInstallInitHook.beforeInit(this.mBuilder);
        }
        synchronized (BdInstallImpl.class) {
            InstallOptions build = this.mBuilder.build();
            getBDInstallInstance().init(build, env);
            this.mBuilder = null;
            this.mOptions = build;
        }
        if (bDInstallInitHook != null) {
            bDInstallInitHook.afterHook();
        }
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void start() {
        getBDInstallInstance().start();
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public boolean manualActivate() {
        return getBDInstallInstance().activeManually();
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public boolean isValidDidAndIid() {
        InstallInfo installInfo = getInstallInfo();
        if (installInfo == null) {
            return false;
        }
        return Utils.checkId(installInfo.getDid()) && Utils.checkId(installInfo.getIid());
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public InstallInfo getInstallInfo() {
        if (this.cacheInstallInfo == null) {
            this.cacheInstallInfo = getBDInstallInstance().getInstallInfo();
        }
        return this.cacheInstallInfo;
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public String getDid() {
        if (TextUtils.isEmpty(this.cacheDeviceId)) {
            this.cacheDeviceId = getBDInstallInstance().getDid();
        }
        return this.cacheDeviceId;
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public String getClientUdid() {
        InstallInfo installInfo = getInstallInfo();
        if (installInfo != null) {
            return installInfo.getClientUdid();
        }
        return null;
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public String getIid() {
        if (TextUtils.isEmpty(this.cacheIid)) {
            InstallInfo installInfo = getInstallInfo();
            this.cacheIid = installInfo != null ? installInfo.getIid() : null;
        }
        return this.cacheIid;
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public String getOpenUdid() {
        InstallInfo installInfo = getInstallInfo();
        if (installInfo != null) {
            return installInfo.getOpenUdid();
        }
        return null;
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public String getSsid() {
        if (TextUtils.isEmpty(this.cacheSsid)) {
            InstallInfo installInfo = getInstallInfo();
            this.cacheSsid = installInfo != null ? installInfo.getSsid() : null;
        }
        return this.cacheSsid;
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void addHeaderAndInstallFinishListener(OnHeaderAndInstallInfoCallback onHeaderAndInstallInfoCallback) {
        Callback callback = new Callback(this, onHeaderAndInstallInfoCallback);
        getBDInstallInstance().addHeaderChangeListener(true, callback);
        getBDInstallInstance().addInstallListener(true, callback);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void setAccount(Account account) {
        synchronized (BdInstallImpl.class) {
            if (this.mBuilder != null) {
                this.mBuilder.setAccount(account);
            } else {
                getBDInstallInstance().setAccount(account);
            }
        }
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void setAppTrack(Context context, JSONObject jSONObject) {
        synchronized (BdInstallImpl.class) {
            if (this.mBuilder != null) {
                this.mBuilder.setAppTrack(jSONObject);
            } else {
                getBDInstallInstance().setAppTrack(context, jSONObject);
            }
        }
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void setUserAgent(Context context, String str) {
        synchronized (BdInstallImpl.class) {
            if (this.mBuilder != null) {
                this.mBuilder.setUserAgent(str);
            } else {
                getBDInstallInstance().setUserAgent(context, str);
            }
        }
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void updateLanguageAndRegion(Context context, String str, String str2) {
        getBDInstallInstance().updateLanguageAndRegion(context, str, str2);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void setUriRuntime(Env env) {
        getBDInstallInstance().changeUriRuntimeAndReInstall(env);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void updateUserUniqueId(Application application, String str) {
        getBDInstallInstance().setUserUniqueId(application, str);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public boolean isNewUserMode(Context context) {
        return getBDInstallInstance().isNewUserMode();
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void setNewUserMode(Context context, boolean z) {
        NUApi newUserMode = getBDInstallInstance().newUserMode();
        if (newUserMode != null) {
            newUserMode.setNUMode(z).done();
        }
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public boolean isNewUserAvailable() {
        return getBDInstallInstance().isNewUserModeAvailable();
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public NUApi newUserMode(Context context) {
        return getBDInstallInstance().newUserMode();
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        if (this.mCustomHeaderAdapter != null) {
            this.mCustomHeaderAdapter.appendHeaderInfo(hashMap);
        } else {
            this.customHeaderCache.putAll(hashMap);
        }
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void removeHeaderInfo(String str) {
        if (this.mCustomHeaderAdapter != null) {
            this.mCustomHeaderAdapter.removeHeader(str);
        } else {
            this.customHeaderCache.remove(str);
        }
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public InstallOptions getInstallOptions() {
        return this.mOptions;
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public String addNetCommonParams(Context context, StringBuilder sb, boolean z, Level level) {
        return getBDInstallInstance().addNetCommonParams(context, sb, z, level);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        getBDInstallInstance().putCommonParams(context, map, z, level);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void setCommonExtraParam(IExtraParams iExtraParams) {
        getBDInstallInstance().setCommonExtraParam(iExtraParams);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public boolean isNewUserFirstLaunch() {
        return getBDInstallInstance().isNewUserFirstLaunch();
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public Map<String, String> getRequestHeader() {
        return getBDInstallInstance().getRequestHeader();
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public boolean getCurrentHeader(JSONObject jSONObject) {
        return getBDInstallInstance().getCurrentHeader(jSONObject);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void addDataObserver() {
        getBDInstallInstance().addOnDataObserver(new IDataObserver() { // from class: com.bytedance.applog.bdinstall.BdInstallImpl.5
            @Override // com.bytedance.bdinstall.IDataObserver
            public void onIdLoaded(final String str, final String str2, final String str3) {
                BdInstallImpl.this.cacheDeviceId = str;
                BdInstallImpl.this.cacheIid = str2;
                BdInstallImpl.this.cacheSsid = str3;
                if (BdInstallImpl.this.appLogInstance.getDataObserverHolder() != null) {
                    BdInstallImpl.this.appLogInstance.getDataObserverHolder().onIdLoaded(str, str2, str3);
                }
                BdInstallImpl.this.appLogInstance.getMonitorHelper().setHeader("device_id", str);
                if (LogUtils.isDisabled()) {
                    return;
                }
                LogUtils.sendJsonFetcher("local_did_load", new EventBus.DataFetcher() { // from class: com.bytedance.applog.bdinstall.BdInstallImpl.5.1
                    @Override // com.bytedance.applog.log.EventBus.DataFetcher
                    public Object fetch() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appId", BdInstallImpl.this.appLogInstance.getAppId());
                            jSONObject.put("did", str);
                            jSONObject.put("ssid", str3);
                            jSONObject.put("installId", str2);
                        } catch (Throwable unused) {
                        }
                        return jSONObject;
                    }
                });
            }

            @Override // com.bytedance.bdinstall.IDataObserver
            public void onRemoteIdGet(boolean z, String str, final String str2, String str3, final String str4, String str5, final String str6) {
                BdInstallImpl.this.cacheDeviceId = str2;
                BdInstallImpl.this.cacheIid = str4;
                BdInstallImpl.this.cacheSsid = str6;
                if (BdInstallImpl.this.appLogInstance.getDataObserverHolder() != null) {
                    BdInstallImpl.this.appLogInstance.getDataObserverHolder().onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
                }
                BdInstallImpl.this.appLogInstance.getMonitorHelper().setHeader("device_id", str2);
                if (LogUtils.isDisabled()) {
                    return;
                }
                LogUtils.sendJsonFetcher("device_register_end", new EventBus.DataFetcher() { // from class: com.bytedance.applog.bdinstall.BdInstallImpl.5.2
                    @Override // com.bytedance.applog.log.EventBus.DataFetcher
                    public Object fetch() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appId", BdInstallImpl.this.appLogInstance.getAppId());
                            jSONObject.put("did", str2);
                            jSONObject.put("installId", str4);
                            jSONObject.put("ssid", str6);
                        } catch (Throwable unused) {
                        }
                        return jSONObject;
                    }
                });
            }
        });
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(InstallInfo installInfo) {
        this.cacheInstallInfo = installInfo;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class Callback implements IInstallListener, HeaderUpdateListener {
        private final IInstallListener bdInstallImpl;
        private boolean hasUpdate = false;
        private JSONObject mHeaderCopy;
        private InstallInfo mInstallInfo;
        private final OnHeaderAndInstallInfoCallback mListener;

        public Callback(IInstallListener iInstallListener, OnHeaderAndInstallInfoCallback onHeaderAndInstallInfoCallback) {
            this.bdInstallImpl = iInstallListener;
            this.mListener = onHeaderAndInstallInfoCallback;
        }

        @Override // com.bytedance.bdinstall.HeaderUpdateListener
        public void onHeaderUpdate(JSONObject jSONObject) {
            this.mHeaderCopy = jSONObject;
            tryNotify();
        }

        private void tryNotify() {
            InstallInfo installInfo;
            synchronized (this) {
                if (this.hasUpdate) {
                    this.mListener.onUpdate(this.mHeaderCopy, this.mInstallInfo);
                } else {
                    JSONObject jSONObject = this.mHeaderCopy;
                    if (jSONObject != null && (installInfo = this.mInstallInfo) != null) {
                        this.hasUpdate = true;
                        this.mListener.onLoad(jSONObject, installInfo);
                    }
                }
            }
        }

        @Override // com.bytedance.bdinstall.IInstallListener
        public void installFinished(InstallInfo installInfo) {
            this.bdInstallImpl.installFinished(installInfo);
            this.mInstallInfo = installInfo;
            tryNotify();
        }
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void clearInstallInfoWhenSwitchChildMode(Env env) {
        getBDInstallInstance().clearInstallInfoWhenSwitchChildMode(env);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void resetInstallInfoWhenSwitchChildMode(Context context, Env env, long j, OnResetListener onResetListener) {
        getBDInstallInstance().resetInstallInfoWhenSwitchChildMode(context, env, j, onResetListener);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void clearAndSetEnv(Env env) {
        getBDInstallInstance().clearAndSetEnv(env);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void resetAndReInstall(Context context, Env env, long j, OnResetListener onResetListener) {
        getBDInstallInstance().resetAndReInstall(context, env, j, onResetListener);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public void addRegisterCustomHeader(Context context, JSONObject jSONObject) {
        BdInstallBridge.addRegisterCustomHeader(getBDInstallInstance(), context, jSONObject);
    }

    @Override // com.bytedance.applog.bdinstall.IBdInstallService
    public IBDInstallApi getBDInstallApi() {
        return getBDInstallInstance();
    }

    private IBDInstallApi getBDInstallInstance() {
        if (this.mBDInstallInstance == null) {
            synchronized (this) {
                if (this.mBDInstallInstance == null) {
                    if (AppLogHelper.isGlobalInstance(this.appLogInstance)) {
                        this.mBDInstallInstance = BDInstall.getInstance();
                    } else {
                        this.mBDInstallInstance = BDInstall.newInstance();
                    }
                }
            }
        }
        return this.mBDInstallInstance;
    }
}
