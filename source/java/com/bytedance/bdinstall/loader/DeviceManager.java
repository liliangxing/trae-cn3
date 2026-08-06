package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.BdInstallInstance;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.DeviceTokenService;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.IEventDepend;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.EgdiCallback;
import com.bytedance.bdinstall.callback.RegisterResultListener;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.bytedance.bdinstall.callback.event.RequestDrSuccessEvent;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.event.VerifyMonitor;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.storage.DeviceParamProviderCreator;
import com.bytedance.bdinstall.storage.ICache;
import com.bytedance.bdinstall.storage.SPCache;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.DataObserverInstance;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.bdinstall.util.Singleton;
import com.bytedance.bdinstall.util.TicketGuardHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DeviceManager implements RegisterResultListener {
    private static final String KEY_DR_AID = "dr_aid";
    private static final String KEY_DR_CHANNEL = "dr_channel";
    private static final String KEY_INSTALL_VERSION_CODE = "dr_install_vc";
    private static final int MAX_PERMISSION = 10;
    public static final int STATE_DIFF = 2;
    public static final int STATE_EMPTY = 0;
    public static final int STATE_SAME = 1;
    private static final AtomicBoolean mNeedMigrate = new AtomicBoolean(true);
    private static final Singleton<DRCommonHeader> sCommonHeader = new Singleton<DRCommonHeader>() { // from class: com.bytedance.bdinstall.loader.DeviceManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public DRCommonHeader create(Object... objArr) {
            return new DRCommonHeader((Context) objArr[0], (InstallOptions) objArr[1], (Env) objArr[2]);
        }
    };
    private MigrateDetector detector;
    private EgdiCallback egdiCallback;
    private boolean mAllReady;
    protected final Context mApp;
    private CallbackCenter mCallbackCenter;
    private DataObserverInstance mDataObserverInstance;
    private final DRSpecialLoader mDrSpecialHeaderLoader;
    private Env mEnv;
    private boolean mIsNewUser;
    protected final InstallOptions mOptions;
    private ICache mSpCache;
    private final TicketGuardHelper ticketGuardHelper;
    private final Map<Class<?>, BaseLoader> mLoaders = new LinkedHashMap(32);
    private final Object mLock = new Object();
    private boolean hasInitLoader = false;
    private volatile boolean mDetectedMigrate = false;
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    private int mCountPermission = 0;
    private JSONObject mHeader = new JSONObject();

    public DeviceManager(Context context, InstallOptions installOptions, Env env) {
        this.mDataObserverInstance = null;
        this.mApp = context;
        this.mEnv = env;
        this.mOptions = installOptions;
        this.mDrSpecialHeaderLoader = new DRSpecialLoader(installOptions);
        this.mSpCache = createSpCache(context, env);
        this.mDataObserverInstance = BdInstallInstance.getInstance(String.valueOf(installOptions.getAid())).getDataObserverInstance();
        ExecutorUtil.runOnHandlerThread(installOptions.getAidString(), new Runnable() { // from class: com.bytedance.bdinstall.loader.DeviceManager.2
            @Override // java.lang.Runnable
            public void run() {
                DeviceManager.this.migrate();
            }
        });
        this.ticketGuardHelper = new TicketGuardHelper();
    }

    private ICache createSpCache(Context context, Env env) {
        INewUserModeService iNewUserModeService = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(this.mOptions.getAid()));
        SPCache sPCache = new SPCache(context, env.getEnvIsolateSp(this.mOptions), this.mOptions);
        return iNewUserModeService != null ? (ICache) iNewUserModeService.tryReplaceService(ICache.class, sPCache) : sPCache;
    }

    public void start() {
        if (this.mStarted.getAndSet(true)) {
            return;
        }
        DeviceParamProviderCreator.registerInstallParameterProvider(this.mApp, this.mEnv, this.mOptions);
    }

    public void changeEnv(Env env, boolean z) {
        this.mEnv = env;
        this.mSpCache = createSpCache(this.mApp, env);
        DeviceParamProviderCreator.registerInstallParameterProvider(this.mApp, env, this.mOptions);
        synchronized (this.mLoaders) {
            this.mLoaders.put(ServerIdLoader.class, new ServerIdLoader(this.mOptions, env));
            this.mLoaders.put(DeviceParamsLoader.class, new DeviceParamsLoader(this.mApp, this.mOptions, env));
            this.mLoaders.put(ConfigLoader.class, new ConfigLoader(this.mApp, this.mOptions, env));
            this.mLoaders.put(CdidLoader.class, new CdidLoader(this.mApp, this.mOptions));
        }
        resetRequestTime(env);
        if (z) {
            loadHeaderAndNotify();
        }
    }

    public void setEgdiCallback(EgdiCallback egdiCallback) {
        this.egdiCallback = egdiCallback;
    }

    public void setCallbackCenter(CallbackCenter callbackCenter) {
        this.mCallbackCenter = callbackCenter;
    }

    public void loadHeaderAndNotify() {
        load();
        CallbackCenter callbackCenter = this.mCallbackCenter;
        if (callbackCenter != null) {
            callbackCenter.postEvent(new HeaderChangeEvent(getConstHeader()));
        }
        notifyDidAndIidLoadSuccessEvent();
    }

    private void resetRequestTime(Env env) {
        SharedPreferences envIsolateSp = env.getEnvIsolateSp(this.mOptions);
        if (envIsolateSp != null) {
            envIsolateSp.edit().putLong(Api.KEY_REGISTER_TIME, 0L).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void migrate() {
        boolean detectMigrate;
        Context context = this.mApp;
        try {
            if (!this.mOptions.enableOneKeyMigrateDetect()) {
                DrLog.m139d("disable OneKeyMigrateDetect");
                detectMigrate = false;
            } else {
                detectMigrate = detectMigrate(context, this.mEnv);
            }
            if (!detectMigrate) {
                OldSpMigrater.tryDoSDKMigrate(context, this.mEnv, this.mOptions);
            }
            synchronized (this.mLock) {
                this.mDetectedMigrate = true;
                this.mLock.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.mLock) {
                this.mDetectedMigrate = true;
                this.mLock.notifyAll();
                throw th;
            }
        }
    }

    private boolean detectMigrate(Context context, Env env) {
        MigrateDetector migrateDetector = new MigrateDetector(context, this.mOptions);
        this.detector = migrateDetector;
        boolean isMigrate = migrateDetector.isMigrate();
        DrLog.m139d("is one key migrate：" + isMigrate);
        if (isMigrate) {
            MigrateDetector.saveOldDid(context, this.mOptions, getDid(), true);
            MigrateClear.clear(context, this.mOptions, env);
        }
        this.detector.disableComponent();
        return isMigrate;
    }

    public JSONObject getConstHeader() {
        return this.mHeader;
    }

    private boolean needSyncFromSub(BaseLoader baseLoader) {
        boolean z = !Utils.isMainProcess(this.mOptions.getContext()) && baseLoader.syncFromSub;
        if (DrLog.debug()) {
            DrLog.m139d("needSyncFromSub " + baseLoader + " " + z);
        }
        return z;
    }

    public boolean load() {
        boolean z;
        boolean z2;
        synchronized (this.mLoaders) {
            if (!this.hasInitLoader) {
                this.hasInitLoader = true;
                this.mLoaders.put(ConfigLoader.class, new ConfigLoader(this.mApp, this.mOptions, this.mEnv));
                this.mLoaders.put(PackageLoader.class, new PackageLoader(this.mApp, this.mOptions));
                this.mLoaders.put(ServerIdLoader.class, new ServerIdLoader(this.mOptions, this.mEnv));
                this.mLoaders.put(SigHashLoader.class, new SigHashLoader(this.mApp));
                this.mLoaders.put(CdidLoader.class, new CdidLoader(this.mApp, this.mOptions));
                this.mLoaders.put(AppTraitLoader.class, new AppTraitLoader(this.mApp, this.mOptions));
                this.mLoaders.put(AppKeyLoader.class, new AppKeyLoader(this.mApp));
                this.mLoaders.put(CustomLoader.class, new CustomLoader(this.mOptions));
                this.mLoaders.put(SstLoader.class, new SstLoader(this.mApp, this.mOptions));
                this.mLoaders.put(DeviceCategoryLoader.class, new DeviceCategoryLoader(this.mApp, this.mOptions));
            }
        }
        synchronized (DeviceManager.class) {
            JSONObject constHeader = getConstHeader();
            JSONObject jSONObject = new JSONObject();
            Utils.copy(jSONObject, constHeader);
            Singleton<DRCommonHeader> singleton = sCommonHeader;
            if (singleton.get(this.mApp, this.mOptions, this.mEnv).load()) {
                Utils.copy(jSONObject, singleton.get(this.mApp, this.mOptions, this.mEnv).getConstHeader());
                z = false;
            } else {
                z = true;
            }
            boolean z3 = true;
            int i = 0;
            int i2 = 0;
            for (BaseLoader baseLoader : this.mLoaders.values()) {
                if (!baseLoader.mReady || baseLoader.mShouldUpdate || needSyncFromSub(baseLoader)) {
                    try {
                        baseLoader.remove(jSONObject);
                        baseLoader.mReady = baseLoader.doLoad(jSONObject);
                    } catch (SecurityException e) {
                        if (!baseLoader.mOptional) {
                            i++;
                            DrLog.m145w("loadHeader, " + this.mCountPermission, e);
                            if (!baseLoader.mReady && this.mCountPermission > 10) {
                                baseLoader.mReady = true;
                            }
                        }
                    } catch (JSONException e2) {
                        DrLog.ysnp(e2);
                    }
                    if (!baseLoader.mReady && !baseLoader.mOptional && z) {
                        i2++;
                    }
                }
                if (!baseLoader.mReady && !baseLoader.mOptional && z) {
                    z2 = false;
                    z3 &= z2;
                }
                z2 = true;
                z3 &= z2;
            }
            this.mHeader = jSONObject;
            this.mAllReady = z3;
            if (DrLog.debug()) {
                DrLog.m139d("loadHeader, " + this.mAllReady + ", " + this.mCountPermission + ", " + this.mHeader);
            } else {
                DrLog.m142i("loadHeader, " + this.mAllReady + ", " + this.mCountPermission, null);
            }
            if (i > 0 && i == i2) {
                this.mCountPermission++;
                if (getRegisterState() != 0) {
                    this.mCountPermission += 10;
                }
            }
        }
        return this.mAllReady;
    }

    private String getSsid() {
        return this.mSpCache.getCachedString("ssid");
    }

    public int getRegisterState() {
        String optString = getConstHeader().optString("device_id", "");
        String optString2 = getConstHeader().optString("install_id", "");
        String optString3 = getConstHeader().optString("bd_did", "");
        if ((Utils.checkId(optString) || Utils.checkId(optString3)) && Utils.checkId(optString2)) {
            return LocalConstants.getCommonSp(this.mApp, this.mOptions).getLong(KEY_INSTALL_VERSION_CODE, 0L) == getConstHeader().optLong("version_code", -1L) ? 1 : 2;
        }
        return 0;
    }

    public boolean updateHeader(String str, Object obj) {
        boolean z;
        Object opt = getConstHeader().opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z = false;
        } else {
            synchronized (DeviceManager.class) {
                try {
                    JSONObject jSONObject = this.mHeader;
                    JSONObject jSONObject2 = new JSONObject();
                    Utils.copy(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.mHeader = jSONObject2;
                } catch (JSONException e) {
                    DrLog.ysnp(e);
                }
            }
            z = true;
        }
        if (DrLog.debug()) {
            DrLog.m139d("updateHeader, " + str + ", " + opt + ", " + obj);
        }
        return z;
    }

    public String getDid() {
        IInstallParameters iInstallParameters = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, this.mOptions.getAidString());
        if (iInstallParameters != null) {
            return iInstallParameters.getDeviceId();
        }
        return this.mSpCache.loadDeviceId("", "");
    }

    private String getIid() {
        return this.mSpCache.getCachedString("install_id");
    }

    private String getClientUdid() {
        return LocalConstants.getCommonSp(this.mApp, this.mOptions).getString("clientudid", null);
    }

    private String getOpenUdid() {
        return LocalConstants.getCommonSp(this.mApp, this.mOptions).getString("openudid", null);
    }

    private String getEgdi() {
        return LocalConstants.getCommonSp(this.mApp, this.mOptions).getString(Api.KEY_KLINK_EGDI, null);
    }

    public InstallInfo getInstallInfo() {
        synchronized (this.mLock) {
            awaitLoadedLocked();
        }
        String did = getDid();
        String iid = getIid();
        String openUdid = getOpenUdid();
        String clientUdid = getClientUdid();
        String ssid = getSsid();
        String egdi = getEgdi();
        InstallInfo installInfo = new InstallInfo();
        if (TextUtils.isEmpty(did)) {
            did = "";
        }
        installInfo.setDid(did);
        if (TextUtils.isEmpty(iid)) {
            iid = "";
        }
        installInfo.setIid(iid);
        installInfo.setClientUdid(clientUdid);
        installInfo.setOpenUdid(openUdid);
        installInfo.setSsid(ssid);
        installInfo.setEgdi(egdi);
        return installInfo;
    }

    public JSONObject getHeader() {
        if (this.mAllReady) {
            return getConstHeader();
        }
        return null;
    }

    public boolean isUpgrade() {
        return LocalConstants.getCommonSp(this.mApp, this.mOptions).getLong(KEY_INSTALL_VERSION_CODE, 0L) != getConstHeader().optLong("version_code", 0L);
    }

    public void updateDrSpecialHeader(JSONObject jSONObject, Env env) {
        try {
            this.mDrSpecialHeaderLoader.doLoad(jSONObject, env);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void notifyBeforeRegister() {
        CallbackCenter callbackCenter;
        InstallInfo installInfo = getInstallInfo();
        String did = installInfo != null ? installInfo.getDid() : null;
        String iid = installInfo != null ? installInfo.getIid() : null;
        String ssid = installInfo != null ? installInfo.getSsid() : null;
        DataObserverInstance dataObserverInstance = this.mDataObserverInstance;
        if (dataObserverInstance != null) {
            dataObserverInstance.onIdLoaded(did, iid, ssid);
        }
        if (installInfo == null || TextUtils.isEmpty(installInfo.getDid()) || TextUtils.isEmpty(installInfo.getIid()) || (callbackCenter = this.mCallbackCenter) == null) {
            return;
        }
        callbackCenter.postEvent(new InstallFinishEvent(installInfo));
    }

    public void notifyDidAndIidLoadSuccessEvent() {
        CallbackCenter callbackCenter;
        InstallInfo installInfo = getInstallInfo();
        if (installInfo == null || TextUtils.isEmpty(installInfo.getDid()) || TextUtils.isEmpty(installInfo.getIid()) || (callbackCenter = this.mCallbackCenter) == null) {
            return;
        }
        callbackCenter.postEvent(new InstallFinishEvent(installInfo));
    }

    private void awaitLoadedLocked() {
        while (!this.mDetectedMigrate) {
            try {
                this.mLock.wait();
            } catch (InterruptedException e) {
                DrLog.ysnp(e);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(48:10|(1:12)(1:164)|13|(1:15)|16|(1:22)|23|24|25|26|(2:157|158)|28|29|(2:30|31)|(3:140|141|(25:(1:149)(2:145|146)|147|(3:136|137|(1:139))|35|36|(1:38)|(4:40|(4:42|1fd|47|48)|68|(3:70|(1:72)|73))|74|(3:78|(2:80|(1:82))|83)|(2:87|88)|89|(1:133)(2:93|94)|95|(1:132)(1:99)|100|(1:131)(1:104)|(1:108)|(4:126|127|128|129)(1:111)|112|(1:114)|115|(2:(1:125)(1:120)|121)|(1:67)(1:59)|(1:63)|64))|33|(0)|35|36|(0)|(0)|74|(4:76|78|(0)|83)|(3:85|87|88)|89|(1:91)|133|95|(1:97)|132|100|(1:102)|131|(2:106|108)|(0)|126|127|128|129|112|(0)|115|(0)|(0)|65|67|(2:61|63)|64) */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0357, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x035b, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0359, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x035a, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0324 A[Catch: JSONException -> 0x0357, TryCatch #3 {JSONException -> 0x0357, blocks: (B:112:0x0320, B:114:0x0324, B:115:0x0333, B:118:0x0345, B:121:0x0353, B:129:0x031d), top: B:128:0x031d }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c7 A[Catch: JSONException -> 0x01b9, TRY_ENTER, TryCatch #6 {JSONException -> 0x01b9, blocks: (B:137:0x019f, B:139:0x01b2, B:38:0x01c7, B:40:0x01ed, B:43:0x01fd, B:47:0x020e, B:52:0x0217, B:68:0x0218, B:70:0x021e, B:72:0x0224, B:76:0x0237, B:78:0x023f, B:80:0x024c, B:82:0x0263, B:85:0x026d, B:87:0x0275, B:91:0x029f, B:93:0x02a8, B:97:0x02e1, B:102:0x02f1, B:106:0x02fd, B:108:0x0301, B:45:0x01fe, B:46:0x020d), top: B:136:0x019f, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ed A[Catch: JSONException -> 0x01b9, TryCatch #6 {JSONException -> 0x01b9, blocks: (B:137:0x019f, B:139:0x01b2, B:38:0x01c7, B:40:0x01ed, B:43:0x01fd, B:47:0x020e, B:52:0x0217, B:68:0x0218, B:70:0x021e, B:72:0x0224, B:76:0x0237, B:78:0x023f, B:80:0x024c, B:82:0x0263, B:85:0x026d, B:87:0x0275, B:91:0x029f, B:93:0x02a8, B:97:0x02e1, B:102:0x02f1, B:106:0x02fd, B:108:0x0301, B:45:0x01fe, B:46:0x020d), top: B:136:0x019f, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x036b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x024c A[Catch: JSONException -> 0x01b9, TryCatch #6 {JSONException -> 0x01b9, blocks: (B:137:0x019f, B:139:0x01b2, B:38:0x01c7, B:40:0x01ed, B:43:0x01fd, B:47:0x020e, B:52:0x0217, B:68:0x0218, B:70:0x021e, B:72:0x0224, B:76:0x0237, B:78:0x023f, B:80:0x024c, B:82:0x0263, B:85:0x026d, B:87:0x0275, B:91:0x029f, B:93:0x02a8, B:97:0x02e1, B:102:0x02f1, B:106:0x02fd, B:108:0x0301, B:45:0x01fe, B:46:0x020d), top: B:136:0x019f, inners: #2 }] */
    @Override // com.bytedance.bdinstall.callback.RegisterResultListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onRegisterResult(TTResponse tTResponse, Env env, IInstallParameters iInstallParameters) {
        JSONObject jSONObject;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        CallbackCenter callbackCenter;
        boolean checkId;
        Pair<String, String> handleTicketData;
        String str;
        String str2;
        String str3;
        boolean z5;
        boolean z6;
        String optString;
        boolean z7;
        boolean z8;
        DataObserverInstance dataObserverInstance;
        RegisterMonitor registerMonitor;
        CallbackCenter callbackCenter2;
        EgdiCallback egdiCallback;
        try {
            jSONObject = new JSONObject(tTResponse.getBody());
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            DrLog.m139d("onRegisterResult# response is null");
            return false;
        }
        String optString2 = jSONObject.optString("device_id_str", "");
        String optString3 = jSONObject.optString("install_id_str", "");
        String optString4 = jSONObject.optString("device_token", "");
        String optString5 = jSONObject.optString("ssid", "");
        String optString6 = jSONObject.optString(Api.KEY_CD, "");
        String optString7 = jSONObject.optString(Api.KEY_KLINK_EGDI, "");
        this.mIsNewUser = jSONObject.optInt(Api.KEY_NEW_USER, 0) > 0;
        String optString8 = jSONObject.optString(Api.KEY_ENCRYPT_DID, "");
        String optString9 = jSONObject.optString(Api.KEY_ENCRYPT_IID, "");
        if (DrLog.debug()) {
            DrLog.m139d("saveRegisterInfo, " + optString2 + ", " + optString3 + ", " + optString5 + ", , " + optString6 + ", " + jSONObject);
        }
        boolean checkId2 = Utils.checkId(optString2);
        boolean checkId3 = Utils.checkId(optString3);
        Utils.checkId(optString6);
        boolean checkId4 = Utils.checkId(optString8);
        boolean checkId5 = Utils.checkId(optString9);
        boolean checkId6 = Utils.checkId(optString7);
        if (BDInstall.getBDInstallConfig().isEnableGetEgdi() && checkId2 && !checkId6 && (egdiCallback = this.egdiCallback) != null) {
            egdiCallback.onEgdiFailed();
        }
        SharedPreferences.Editor edit = this.mOptions.getSp().edit();
        SharedPreferences commonSp = LocalConstants.getCommonSp(this.mApp, this.mOptions);
        SharedPreferences.Editor edit2 = commonSp.edit();
        try {
            checkId = Utils.checkId(optString5);
            long j = commonSp.getLong(KEY_INSTALL_VERSION_CODE, 0L);
            long optLong = getConstHeader().optLong("version_code", 0L);
            if (j != optLong) {
                try {
                    edit2.putLong(KEY_INSTALL_VERSION_CODE, optLong);
                } catch (JSONException e2) {
                    e = e2;
                    z2 = false;
                    z = false;
                    DrLog.ysnp(e);
                    z3 = checkId3;
                    if (z2) {
                    }
                    if (z4) {
                    }
                    return z4;
                }
            }
            edit2.putString(KEY_DR_CHANNEL, this.mOptions.getChannel());
            edit2.putString(KEY_DR_AID, String.valueOf(this.mOptions.getAid()));
        } catch (JSONException e3) {
            e = e3;
            z = false;
        }
        try {
            handleTicketData = handleTicketData(optString2, optString3, optString8, optString9, checkId4, checkId5, tTResponse, edit);
        } catch (JSONException e4) {
            e = e4;
            z = false;
            z2 = z;
            DrLog.ysnp(e);
            z3 = checkId3;
            if (z2) {
            }
            if (z4) {
            }
            return z4;
        }
        if (!TextUtils.isEmpty((CharSequence) handleTicketData.first)) {
            try {
            } catch (JSONException e5) {
                e = e5;
                z2 = false;
                z = false;
                DrLog.ysnp(e);
                z3 = checkId3;
                if (z2) {
                }
                if (z4) {
                }
                return z4;
            }
            if (!TextUtils.isEmpty((CharSequence) handleTicketData.second)) {
                if (checkId2 || checkId3) {
                    str = optString2;
                    str2 = optString3;
                } else {
                    str = (String) handleTicketData.first;
                    str2 = (String) handleTicketData.second;
                    boolean checkId7 = Utils.checkId(str);
                    checkId3 = Utils.checkId(str2);
                    checkId2 = checkId7;
                }
                str3 = str;
                z2 = checkId2;
                z3 = checkId3;
                z5 = true;
                z6 = true;
                if (!z2) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ApmTrafficStats.TTNET_RESPONSE, jSONObject);
                        IEventDepend eventDepend = this.mOptions.getEventDepend();
                        if (eventDepend != null) {
                            eventDepend.onEvent("tt_fetch_did_error", jSONObject2);
                        }
                    } catch (JSONException e6) {
                        e = e6;
                        checkId3 = z3;
                        z = false;
                        DrLog.ysnp(e);
                        z3 = checkId3;
                        if (z2) {
                        }
                        if (z4) {
                        }
                        return z4;
                    }
                }
                String did = getDid();
                if (DrLog.debug()) {
                    DrLog.m139d("od=" + did + " nd=" + str3 + " ck=" + z2);
                }
                if (z2) {
                    if (!str3.equals(this.mHeader.optString("device_id"))) {
                        synchronized (DeviceManager.class) {
                            JSONObject jSONObject3 = this.mHeader;
                            JSONObject jSONObject4 = new JSONObject();
                            Utils.copy(jSONObject4, jSONObject3);
                            jSONObject4.put("device_id", str3);
                            this.mHeader = jSONObject4;
                        }
                        iInstallParameters.updateDeviceId(str3);
                        z5 = true;
                        z6 = true;
                    }
                    if (!str3.equals(did)) {
                        if (!TextUtils.isEmpty(did)) {
                            monitorDidError(iInstallParameters, str3, did);
                        }
                        z6 = true;
                    }
                }
                optString = getConstHeader().optString("install_id", "");
                if (z3 && updateHeader("install_id", str2)) {
                    this.mSpCache.cacheString("install_id", str2);
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("old_id", optString);
                        jSONObject5.put("new_id", str2);
                        IEventDepend eventDepend2 = this.mOptions.getEventDepend();
                        if (eventDepend2 != null) {
                            eventDepend2.onEvent("iid_change", jSONObject5);
                        }
                    }
                    z5 = true;
                    z6 = true;
                }
                if (checkId6 && updateHeader(Api.KEY_KLINK_EGDI, optString7)) {
                    this.mSpCache.cacheString(Api.KEY_KLINK_EGDI, optString7);
                    DrLog.m139d("[egdi] no retry. direct cache egdi");
                    z5 = true;
                    z6 = true;
                }
                edit.putString("device_id", str3);
                edit.putString("install_id", str2);
                String optString10 = getConstHeader().optString("ssid", "");
                if (checkId || !updateHeader("ssid", optString5)) {
                    z7 = z6;
                } else {
                    this.mSpCache.cacheString("ssid", optString5);
                    z5 = true;
                    z7 = true;
                }
                this.mOptions.saveConfigAfterRegister(edit2);
                edit2.apply();
                edit.apply();
                ((DeviceTokenService) ServiceManager.getService(DeviceTokenService.class, String.valueOf(this.mOptions.getAid()))).updateToken(optString4, env);
                z8 = TextUtils.equals(str3, did) && !TextUtils.isEmpty(str3);
                boolean z9 = TextUtils.equals(str2, optString) && !TextUtils.isEmpty(str2);
                if (z5 && (callbackCenter2 = this.mCallbackCenter) != null) {
                    callbackCenter2.postEvent(new HeaderChangeEvent(getConstHeader()));
                }
                if (!z8 || z9) {
                    notifyDidAndIidLoadSuccessEvent();
                    z = false;
                    MigrateDetector.saveOldDid(this.mApp, this.mOptions, null, false);
                } else {
                    z = false;
                }
                dataObserverInstance = this.mDataObserverInstance;
                if (dataObserverInstance != null) {
                    dataObserverInstance.onRemoteIdGet(z7, did, str3, optString, str2, optString10, optString5);
                }
                registerMonitor = EventUtils.getInstance().getRegisterMonitor(this.mOptions.getAid());
                if (registerMonitor != null) {
                    registerMonitor.setDidChanged((!z8 || this.mHeader.optBoolean(Api.KEY_NEW_USER_MODE)) ? z : true);
                }
                z4 = ((z2 || !z3) && (!checkId4 || !checkId5)) ? z : true;
                if (z4 && (callbackCenter = this.mCallbackCenter) != null) {
                    callbackCenter.postEvent(new RequestDrSuccessEvent(jSONObject));
                }
                return z4;
            }
        }
        z2 = checkId2;
        z3 = checkId3;
        str3 = optString2;
        str2 = optString3;
        z5 = false;
        z6 = false;
        if (!z2) {
        }
        String did2 = getDid();
        if (DrLog.debug()) {
        }
        if (z2) {
        }
        optString = getConstHeader().optString("install_id", "");
        if (z3) {
            this.mSpCache.cacheString("install_id", str2);
            if (!TextUtils.isEmpty(optString)) {
            }
            z5 = true;
            z6 = true;
        }
        if (checkId6) {
            this.mSpCache.cacheString(Api.KEY_KLINK_EGDI, optString7);
            DrLog.m139d("[egdi] no retry. direct cache egdi");
            z5 = true;
            z6 = true;
        }
        edit.putString("device_id", str3);
        edit.putString("install_id", str2);
        String optString102 = getConstHeader().optString("ssid", "");
        if (checkId) {
        }
        z7 = z6;
        this.mOptions.saveConfigAfterRegister(edit2);
        edit2.apply();
        edit.apply();
        ((DeviceTokenService) ServiceManager.getService(DeviceTokenService.class, String.valueOf(this.mOptions.getAid()))).updateToken(optString4, env);
        if (TextUtils.equals(str3, did2)) {
        }
        if (TextUtils.equals(str2, optString)) {
        }
        if (z5) {
            callbackCenter2.postEvent(new HeaderChangeEvent(getConstHeader()));
        }
        if (z8) {
        }
        notifyDidAndIidLoadSuccessEvent();
        z = false;
        MigrateDetector.saveOldDid(this.mApp, this.mOptions, null, false);
        dataObserverInstance = this.mDataObserverInstance;
        if (dataObserverInstance != null) {
        }
        registerMonitor = EventUtils.getInstance().getRegisterMonitor(this.mOptions.getAid());
        if (registerMonitor != null) {
        }
        if (z2) {
        }
        if (z4) {
            callbackCenter.postEvent(new RequestDrSuccessEvent(jSONObject));
        }
        return z4;
    }

    private Pair<String, String> handleTicketData(String str, String str2, String str3, String str4, boolean z, boolean z2, TTResponse tTResponse, SharedPreferences.Editor editor) {
        String str5;
        List<Map<String, String>> handleProviderResponse;
        VerifyMonitor verifyMonitor;
        if (!BDInstall.getBDInstallConfig().isEnableDidGuard()) {
            return new Pair<>("", "");
        }
        String str6 = null;
        try {
            handleProviderResponse = this.ticketGuardHelper.handleProviderResponse(0L, "ts_sign", tTResponse.getHeaders().toString(), false, tTResponse.getHeaders());
            verifyMonitor = EventUtils.getInstance().getVerifyMonitor(this.mOptions.getAid());
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                str5 = null;
            } else {
                String decryptTicket = this.ticketGuardHelper.decryptTicket(Base64.decode(str3, 0));
                try {
                    str5 = this.ticketGuardHelper.decryptTicket(Base64.decode(str4, 0));
                    str6 = decryptTicket;
                } catch (Exception e) {
                    e = e;
                    str5 = null;
                    str6 = decryptTicket;
                    e.printStackTrace();
                    return new Pair<>(str6, str5);
                }
            }
        } catch (Exception e2) {
            e = e2;
            str5 = null;
        }
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                verifyMonitor.setDecryptCode((str.equals(str6) && str2.equals(str5)) ? 1 : 2);
                DrLog.m139d(Constants.TAG_TICKET + String.format("decrypt done: did %s, iid %s, decryptDid %s, decryptIid %s", str, str2, str6, str5));
            }
            if (z && !str3.equals(this.mHeader.optString(Api.KEY_ENCRYPT_DID))) {
                this.mHeader.put(Api.KEY_ENCRYPT_DID, str3);
                this.mSpCache.cacheString(Api.KEY_ENCRYPT_DID, str3);
                DrLog.m139d("TicketGuard# update header encrypt did " + this.mHeader.optString(Api.KEY_ENCRYPT_DID));
            }
            if (z2) {
                this.mHeader.put(Api.KEY_ENCRYPT_IID, str4);
                this.mSpCache.cacheString(Api.KEY_ENCRYPT_IID, str4);
                DrLog.m139d("TicketGuard# update header encrypt iid " + this.mHeader.optString(Api.KEY_ENCRYPT_IID));
            }
            editor.putString(Api.KEY_ENCRYPT_DID, str3);
            editor.putString(Api.KEY_ENCRYPT_IID, str4);
            this.ticketGuardHelper.cacheTicketAndTsSign(tTResponse, this.mSpCache, handleProviderResponse);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return new Pair<>(str6, str5);
        }
        return new Pair<>(str6, str5);
    }

    private void monitorDidError(IInstallParameters iInstallParameters, String str, String str2) throws JSONException {
        String clientUDID = iInstallParameters.getClientUDID();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("old_id", str2);
        jSONObject.put("new_id", str);
        if (!this.mEnv.isChildMode()) {
            jSONObject.put("openudid", iInstallParameters.getOpenUdid(true));
        }
        jSONObject.put("clientudid", clientUDID);
        IEventDepend eventDepend = this.mOptions.getEventDepend();
        if (eventDepend != null) {
            eventDepend.onEvent("did_change", jSONObject);
        }
    }

    public boolean isDiffChannel() {
        return !TextUtils.equals(LocalConstants.getCommonSp(this.mApp, this.mOptions).getString(KEY_DR_CHANNEL, null), this.mOptions.getChannel());
    }

    public boolean isDiffAid() {
        return !TextUtils.equals(LocalConstants.getCommonSp(this.mApp, this.mOptions).getString(KEY_DR_AID, null), String.valueOf(this.mOptions.getAid()));
    }

    public JSONObject loadOrGetHeader() {
        JSONObject header = getHeader();
        if (header != null) {
            return header;
        }
        start();
        load();
        return getHeader();
    }

    @Deprecated
    public boolean isNewUser() {
        return this.mIsNewUser;
    }

    public void clear() {
        IInstallParameters iInstallParameters = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOptions.getAid()));
        if (iInstallParameters != null) {
            iInstallParameters.clearAll();
        }
        Cdid.clearCdid(this.mApp, this.mOptions);
        RequestIdGenerator.clearReqId();
    }

    public Env getCurEnv() {
        return this.mEnv;
    }

    public TicketGuardHelper getTicketGuardHelper() {
        return this.ticketGuardHelper;
    }
}
