package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.HeaderUpdateCallback;
import com.bytedance.bdinstall.callback.InstallFinishCallback;
import com.bytedance.bdinstall.callback.OaidCallback;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.DataObserverInstance;
import com.bytedance.bdinstall.util.InstanceHolder;
import com.bytedance.bdinstall.util.NetworkStatusProvider;
import com.bytedance.bdinstall.util.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BdInstallInstance implements IBDInstallApi {
    private ApiParamsUtil mApiParamsUtil;
    public final CallbackCenter mCallbackCenter;
    private DataObserverInstance mDataObserverInstance;
    private volatile AppContext sAppContext;
    private volatile IParamFilter sFilter;
    private static Map<String, BdInstallInstance> sInstanceMap = new ConcurrentHashMap();
    private static final AtomicInteger sInstId = new AtomicInteger(0);
    private volatile InstallOptions sOptions = null;
    private volatile IAdIdConfig sAdIdConfig = new IAdIdConfig.AdIdConfig();
    private final InstallWaitingLock sInstallLock = new InstallWaitingLock();
    private final AtomicBoolean hasInit = new AtomicBoolean(false);
    private final AtomicBoolean autoActiveAfterInit = new AtomicBoolean(false);
    private final BDInstallConfig bdInstallConfig = new BDInstallConfig();
    private final InstanceHolder<IInstallService> service = new InstanceHolder<IInstallService>() { // from class: com.bytedance.bdinstall.BdInstallInstance.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.InstanceHolder
        public IInstallService create(Object... objArr) {
            if (Utils.isMainProcess((Context) objArr[0])) {
                InstallServiceImpl installServiceImpl = new InstallServiceImpl(BdInstallInstance.this);
                installServiceImpl.registerLifeCycleListener((Application) Utils.getApp((Context) objArr[0]));
                installServiceImpl.setCallbackCenter(BdInstallInstance.this.mCallbackCenter);
                return installServiceImpl;
            }
            OpInstallServiceImpl opInstallServiceImpl = new OpInstallServiceImpl(BdInstallInstance.this);
            opInstallServiceImpl.setCallbackCenter(BdInstallInstance.this.mCallbackCenter);
            return opInstallServiceImpl;
        }
    };
    private final Singleton<InstallInfo> sInstallInfoBeforeInit = new Singleton<InstallInfo>() { // from class: com.bytedance.bdinstall.BdInstallInstance.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public InstallInfo create(Object... objArr) {
            return new OpInstallOptionsHelper((Context) objArr[0]).getSavedInstallInfo();
        }
    };

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void clearInstallInfoWhenSwitchChildMode(Env env) {
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void resetInstallInfoWhenSwitchChildMode(Context context, Env env, long j, OnResetListener onResetListener) {
    }

    public static BdInstallInstance getInstance(String str) {
        return sInstanceMap.get(str);
    }

    public InstallWaitingLock getsInstallLock() {
        return this.sInstallLock;
    }

    public ApiParamsUtil getApiParamsUtil() {
        return this.mApiParamsUtil;
    }

    public DataObserverInstance getDataObserverInstance() {
        return this.mDataObserverInstance;
    }

    public BdInstallInstance() {
        sInstId.incrementAndGet();
        this.mApiParamsUtil = new ApiParamsUtil(this);
        this.mDataObserverInstance = new DataObserverInstance();
        this.mCallbackCenter = new CallbackCenter();
    }

    private boolean checkInit() {
        return BDInstall.isMainInstance(this) || this.sOptions != null;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void init(InstallOptions installOptions) {
        init(installOptions, new Env(InstallUrl.createUriByDomain("https://log.snssdk.com"), false, false));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void init(InstallOptions installOptions, Env env) {
        synchronized (this) {
            try {
                if (installOptions == null) {
                    throw new IllegalStateException("options must not be null!");
                }
                if (!sInstanceMap.containsKey(String.valueOf(installOptions.getAid()))) {
                    DrLog.m139d("instance init " + installOptions.getAid());
                    sInstanceMap.put(String.valueOf(installOptions.getAid()), this);
                    installOptions.setIsMainInstance(BDInstall.isMainInstance(this));
                    this.sOptions = installOptions;
                    this.mCallbackCenter.init(this.sOptions.getAidString());
                    IParamFilter paramFilter = installOptions.getParamFilter();
                    if (paramFilter != null) {
                        this.sFilter = paramFilter;
                    }
                    if (installOptions.getAdIdConfig() != null) {
                        this.sAdIdConfig = installOptions.getAdIdConfig();
                    }
                    ISstInfoProvider sstInfoProvider = installOptions.getSstInfoProvider();
                    if (sstInfoProvider != null) {
                        SstInfoCompat.setSstInfoProvider(String.valueOf(installOptions.getAid()), sstInfoProvider);
                    }
                    if (installOptions.isEnableNetCommOpt()) {
                        this.mApiParamsUtil.setNetworkProvider(NetworkStatusProvider.getInstance(installOptions.getContext()));
                        NetworkStatusProvider.incrementReferenceCount();
                    }
                    this.service.get(installOptions.getContext()).init(installOptions, env);
                    this.hasInit.set(true);
                    if (this.autoActiveAfterInit.get()) {
                        activeManually();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public Map<String, String> getRequestHeader() {
        DeviceTokenService deviceTokenService;
        if (!checkInit() || this.sOptions == null || (deviceTokenService = (DeviceTokenService) ServiceManager.getService(DeviceTokenService.class, String.valueOf(this.sOptions.getAid()))) == null) {
            return null;
        }
        return deviceTokenService.getRequestHeader();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void start() {
        if (this.sOptions == null) {
            return;
        }
        this.service.get(this.sOptions.getContext()).start();
        Oaid.instance(this.sOptions.getContext()).setInstallOptions(this.sOptions);
        Oaid.instance(this.sOptions.getContext()).setCallbackCenter(this.mCallbackCenter);
        Oaid.instance(this.sOptions.getContext()).startNotify();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public Env getCurrentEnv() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return this.service.get(context).getCurEnv();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void changeUriRuntimeAndReInstall(Env env) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.service.get(context).changeUriRuntimeAndReInstall(env);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setExecutor(ExecutorOptions executorOptions, String str) {
        ExecutorUtil.setExecutor(str, executorOptions);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return addNetCommonParams(context, new StringBuilder(str), z, level);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context context, StringBuilder sb, boolean z, Level level) {
        if (checkInit()) {
            return this.mApiParamsUtil.appendNetParams(context, sb, null, z, level);
        }
        return null;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context context, StringBuilder sb, String str, boolean z, Level level) {
        if (checkInit()) {
            return this.mApiParamsUtil.appendNetParams(context, sb, str, z, level);
        }
        return null;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        if (checkInit()) {
            this.mApiParamsUtil.appendParamsToMap(context, z, null, map, level);
        }
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setCommonExtraParam(IExtraParams iExtraParams) {
        if (checkInit()) {
            this.mApiParamsUtil.setExtraParams(iExtraParams);
        }
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addCustomParamsWithLevel(String str, String str2, Level level) {
        if (checkInit()) {
            this.mApiParamsUtil.addCustomParamsWithLevel(str, str2, level);
        }
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeCustomParamsWithLevel(String str, Level level) {
        if (checkInit()) {
            this.mApiParamsUtil.removeCustomParamsWithLevel(str, level);
        }
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addInstallListener(boolean z, IInstallListener iInstallListener) {
        if (iInstallListener == null) {
            return;
        }
        this.mCallbackCenter.register(z, new InstallFinishCallback(iInstallListener));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeInstallListener(IInstallListener iInstallListener) {
        this.mCallbackCenter.unregister(iInstallListener);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addHeaderChangeListener(boolean z, HeaderUpdateListener headerUpdateListener) {
        if (headerUpdateListener == null) {
            return;
        }
        this.mCallbackCenter.register(z, new HeaderUpdateCallback(headerUpdateListener));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeHeaderChangeListener(HeaderUpdateListener headerUpdateListener) {
        this.mCallbackCenter.unregister(headerUpdateListener);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addOaidObserver(boolean z, IOaidObserver iOaidObserver) {
        if (iOaidObserver == null) {
            return;
        }
        this.mCallbackCenter.register(z, new OaidCallback(iOaidObserver));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeOaidObserver(IOaidObserver iOaidObserver) {
        this.mCallbackCenter.unregister(iOaidObserver);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addOnDataObserver(IDataObserver iDataObserver) {
        this.mDataObserverInstance.addDataObserver(iDataObserver);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeOnDataObserver(IDataObserver iDataObserver) {
        this.mDataObserverInstance.removeDataObserver(iDataObserver);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setUserUniqueId(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_unique_id", str);
        this.service.get(context).updateHeader(context, hashMap, true, true);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setCustomHeader(Context context, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("custom", jSONObject);
        this.service.get(context).updateMemoryHeader(context, hashMap);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void updateLanguageAndRegion(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(Api.KEY_APP_LANGUAGE, str);
        hashMap.put(Api.KEY_APP_REGION, str2);
        this.service.get(context).updateHeader(context, hashMap, true, true);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setUserAgent(Context context, String str) {
        if (context == null) {
            DrLog.m140e("context is null when setUserAgent");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Api.KEY_USER_AGENT, str);
        this.service.get(context).updateHeader(context, hashMap, true, false);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAppTrack(Context context, JSONObject jSONObject) {
        if (context == null) {
            DrLog.m140e("context is null when setAppTrack");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Api.KEY_APP_TRACK, jSONObject == null ? null : jSONObject.toString());
        this.service.get(context).updateHeader(context, hashMap, true, false);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAccount(Account account) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.service.get(context).setAccount(account);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public JSONObject loadOrGetHeader() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return this.service.get(context).loadOrGetHeader();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean getCurrentHeader(JSONObject jSONObject) {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        try {
            return this.service.get(context).getHeader(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void getSSIDs(Map<String, String> map) {
        InstallInfo installInfo;
        if (map == null || (installInfo = getInstallInfo()) == null) {
            return;
        }
        String did = installInfo.getDid();
        if (!TextUtils.isEmpty(did)) {
            map.put("device_id", did);
        }
        String iid = installInfo.getIid();
        if (!TextUtils.isEmpty(iid)) {
            map.put("install_id", iid);
        }
        String openUdid = installInfo.getOpenUdid();
        if (!TextUtils.isEmpty(openUdid)) {
            map.put("openudid", openUdid);
        }
        String clientUdid = installInfo.getClientUdid();
        if (TextUtils.isEmpty(clientUdid)) {
            return;
        }
        map.put("clientudid", clientUdid);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo getInstallInfo() {
        if (this.sOptions != null && this.sOptions.getContext() != null) {
            return this.service.get(this.sOptions.getContext()).getInstallInfo();
        }
        DrLog.m140e("BDInstall#getInstallInfo error, not init yet!");
        return tryGetFallbackInstallInfo(getAppContext());
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String getDid() {
        if (this.sOptions != null && this.sOptions.getContext() != null) {
            return this.service.get(this.sOptions.getContext()).getDid();
        }
        DrLog.m140e("BDInstall#getDid error, not init yet!");
        InstallInfo tryGetFallbackInstallInfo = tryGetFallbackInstallInfo(getAppContext());
        if (tryGetFallbackInstallInfo == null) {
            return null;
        }
        return tryGetFallbackInstallInfo.getDid();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setInstallInfo(InstallInfo installInfo) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.service.get(context).setInstallInfo(installInfo);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo tryGetFallbackInstallInfo(AppContext appContext) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return this.sInstallInfoBeforeInit.get(context);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo waitingForInstallFinish(long j) throws InterruptedException {
        Integer aid = getAid();
        InstallInfo installInfo = getInstallInfo();
        if (aid == null || !(installInfo == null || TextUtils.isEmpty(installInfo.getDid()) || TextUtils.isEmpty(installInfo.getIid()))) {
            return installInfo;
        }
        this.sInstallLock.tryWaitingForInstallFinish(j, aid);
        return getInstallInfo();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo waitingForInstallFinishWithOldWay() {
        Integer aid = getAid();
        InstallInfo installInfo = getInstallInfo();
        if (aid == null || !(installInfo == null || TextUtils.isEmpty(installInfo.getDid()) || TextUtils.isEmpty(installInfo.getIid()))) {
            return installInfo;
        }
        this.sInstallLock.tryWaitingForInstallFinishInOldWay(aid);
        return getInstallInfo();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean activeManually() {
        if (!this.hasInit.get()) {
            this.autoActiveAfterInit.set(true);
            return false;
        }
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return this.service.get(context).activeManually();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public NUApi newUserMode() {
        INewUserModeService iNewUserModeService;
        Integer aid = getAid();
        if (aid == null || (iNewUserModeService = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(aid))) == null) {
            return null;
        }
        return iNewUserModeService.getApi();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserMode() {
        INewUserModeService iNewUserModeService;
        Integer aid = getAid();
        if (aid == null || (iNewUserModeService = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(aid))) == null) {
            return false;
        }
        return iNewUserModeService.isNewUserMode();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserFirstLaunch() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return this.service.get(context).isNewUserFirstLaunch();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserModeAvailable() {
        try {
            return Class.forName(Constants.NAME_NEW_USER_IMPL) != null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public IParamFilter getParamsFilter() {
        return this.sFilter;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setParamsFilter(IParamFilter iParamFilter) {
        this.sFilter = iParamFilter;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAdIdConfig(IAdIdConfig iAdIdConfig) {
        if (iAdIdConfig == null) {
            return;
        }
        this.sAdIdConfig = iAdIdConfig;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public IAdIdConfig getAdIdConfig() {
        return this.sAdIdConfig;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallOptions getInstallOptions() {
        return this.sOptions;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void registerLifeCycleListener(Application application) {
        if (application == null) {
            Log.e("bdinstall# ", "application is null when registerLifeCycleListener");
        } else {
            this.service.get(application).registerLifeCycleListener(application);
        }
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAppContext(AppContext appContext) {
        this.sAppContext = appContext;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public AppContext getAppContext() {
        return this.sAppContext;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void clearAndSetEnv(Env env) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.service.get(context).clearAndSetEnv(env);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void resetAndReInstall(Context context, Env env, long j, OnResetListener onResetListener) {
        Context context2 = getContext();
        if (context2 == null) {
            return;
        }
        this.service.get(context2).resetAndReInstall(context, env, j, onResetListener);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void stopNetCommOpt(Context context) {
        if (NetworkStatusProvider.instance() != null) {
            NetworkStatusProvider.instance().stop();
        }
    }

    private Context getContext() {
        if (this.sOptions != null && this.sOptions.getContext() != null) {
            return this.sOptions.getContext();
        }
        if (this.sAppContext != null && this.sAppContext.getContext() != null) {
            return this.sAppContext.getContext();
        }
        return BDInstallProvider.getFallbackContext();
    }

    private Integer getAid() {
        if (this.sOptions != null) {
            return Integer.valueOf(this.sOptions.getAid());
        }
        if (this.sAppContext != null) {
            return Integer.valueOf(this.sAppContext.getAid());
        }
        return null;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public BDInstallConfig getBDInstallConfig() {
        return this.bdInstallConfig;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addRegisterCustomHeader(Context context, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put(Api.KEY_REGISTER_CUSTOM, jSONObject);
        this.service.get(context).updateMemoryHeader(context, hashMap);
    }
}
