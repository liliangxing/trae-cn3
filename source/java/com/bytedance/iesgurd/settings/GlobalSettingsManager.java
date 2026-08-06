package com.bytedance.iesgurd.settings;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.gson.GsonUtil;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.RequestExecutor;
import com.bytedance.geckox.net.Response;
import com.bytedance.geckox.policy.ebretry.ExponentialBackoffRetry;
import com.bytedance.geckox.policy.ebretry.IEBRetryTask;
import com.bytedance.geckox.policy.meta.MetaDataManager;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.settings.model.SettingsLocal;
import com.bytedance.geckox.task.HandlerTask;
import com.bytedance.geckox.task.HandlerTimerTaskManager;
import com.bytedance.geckox.task.InitDelayTask;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.iesgurd.core.CacheManager;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.RegisterManager;
import com.bytedance.iesgurd.core.ReportNode;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.iesgurd.model.ApiResponse;
import com.bytedance.iesgurd.model.RequestBodySettings;
import com.bytedance.iesgurd.statistic.model.StatisticSettingsData;
import com.bytedance.iesgurd.strategy.ColdStartManager;
import com.bytedance.iesgurd.strategy.LoopManager;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalSettingsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010J\u0018\u0010 \u001a\u00020\u001e2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\"H\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\u0006\u0010$\u001a\u00020\u001eJ\b\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010J\u001a\u0010'\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/iesgurd/settings/GlobalSettingsManager;", "", "()V", "<set-?>", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings;", "globalSettings", "getGlobalSettings", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings;", "mExponentialBackoffRetry", "Lcom/bytedance/geckox/policy/ebretry/ExponentialBackoffRetry;", "mFetching", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsInit", "mSettingsStoreManager", "Lcom/bytedance/iesgurd/settings/GlobalSettingsStoreManager;", "mSettingsVersion", "", "nextReqType", "Lcom/bytedance/iesgurd/core/ReqType;", "probe", "reqType", "settingsExtra", "Lcom/bytedance/iesgurd/settings/SettingsExtra;", "getSettingsExtra", "()Lcom/bytedance/iesgurd/settings/SettingsExtra;", "setSettingsExtra", "(Lcom/bytedance/iesgurd/settings/SettingsExtra;)V", "statisticData", "Lcom/bytedance/iesgurd/statistic/model/StatisticSettingsData;", "cleanSettings", "", "fetchGlobalSettings", "handleResponse", "response", "Lcom/bytedance/iesgurd/model/ApiResponse;", "initSelf", "resetForTest", "scheduleSettings", "setProbe", "syncGlobalSettings", "isRetry", "", "syncRequestServer", "SettingsTimerTask", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GlobalSettingsManager {
    public static final GlobalSettingsManager INSTANCE;
    private static GlobalConfigSettings globalSettings;
    private static ExponentialBackoffRetry mExponentialBackoffRetry;
    private static final AtomicBoolean mFetching;
    private static final AtomicBoolean mIsInit;
    private static final GlobalSettingsStoreManager mSettingsStoreManager;
    private static String mSettingsVersion;
    private static ReqType nextReqType;
    private static String probe;
    private static ReqType reqType;
    private static SettingsExtra settingsExtra;
    private static StatisticSettingsData statisticData;

    static {
        GlobalSettingsManager globalSettingsManager = new GlobalSettingsManager();
        INSTANCE = globalSettingsManager;
        mSettingsVersion = ViewVisibleBridge.INVISIBLE;
        mSettingsStoreManager = new GlobalSettingsStoreManager();
        mIsInit = new AtomicBoolean(false);
        mFetching = new AtomicBoolean(false);
        globalSettingsManager.initSelf();
    }

    private GlobalSettingsManager() {
    }

    public static final /* synthetic */ ExponentialBackoffRetry access$getMExponentialBackoffRetry$p(GlobalSettingsManager globalSettingsManager) {
        ExponentialBackoffRetry exponentialBackoffRetry = mExponentialBackoffRetry;
        if (exponentialBackoffRetry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExponentialBackoffRetry");
        }
        return exponentialBackoffRetry;
    }

    public static final /* synthetic */ StatisticSettingsData access$getStatisticData$p(GlobalSettingsManager globalSettingsManager) {
        StatisticSettingsData statisticSettingsData = statisticData;
        if (statisticSettingsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statisticData");
        }
        return statisticSettingsData;
    }

    public final GlobalConfigSettings getGlobalSettings() {
        return globalSettings;
    }

    public final SettingsExtra getSettingsExtra() {
        return settingsExtra;
    }

    public final void setSettingsExtra(SettingsExtra settingsExtra2) {
        settingsExtra = settingsExtra2;
    }

    private final void initSelf() {
        String str;
        GlobalManager.INSTANCE.ensureInit();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        GlobalSettingsStoreManager globalSettingsStoreManager = mSettingsStoreManager;
        SettingsLocal settingsLocal = globalSettingsStoreManager.getSettingsLocal();
        Intrinsics.checkExpressionValueIsNotNull(globalConfig, "globalConfig");
        String name = globalConfig.getEnv().name();
        String appVersion = globalConfig.getAppVersion();
        String str2 = null;
        if (settingsLocal != null) {
            str2 = settingsLocal.getEnv();
            str = settingsLocal.getAppVersion();
        } else {
            str = null;
        }
        settingsExtra = GlobalSettingsStoreManager.INSTANCE.getSettingsExtra();
        Intrinsics.checkExpressionValueIsNotNull(appVersion, "currentVersion");
        globalSettingsStoreManager.putSettingsLocal(new SettingsLocal(name, appVersion));
        if (str2 != null) {
            if (Intrinsics.areEqual(name, str2) && Intrinsics.areEqual(appVersion, str)) {
                GlobalConfigSettings settings = globalSettingsStoreManager.getSettings();
                globalSettings = settings;
                if (settings != null) {
                    if (settings == null) {
                        Intrinsics.throwNpe();
                    }
                    String version = settings.getVersion();
                    Intrinsics.checkExpressionValueIsNotNull(version, "globalSettings!!.version");
                    mSettingsVersion = version;
                }
            } else if (!Intrinsics.areEqual(name, str2)) {
                GeckoLogger.d("env changed, delete gecko cache, from " + str2 + " to " + name);
                CacheManager.INSTANCE.deleteAll();
                cleanSettings();
            } else if (!Intrinsics.areEqual(appVersion, str)) {
                GeckoLogger.d("app_version changed, from " + str + " to " + appVersion);
                GlobalConfigSettings settings2 = globalSettingsStoreManager.getSettings();
                globalSettings = settings2;
                mSettingsVersion = ViewVisibleBridge.INVISIBLE;
                if (settings2 != null) {
                    if (settings2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (settings2.getResourceMeta() != null) {
                        GlobalConfigSettings globalConfigSettings = globalSettings;
                        if (globalConfigSettings == null) {
                            Intrinsics.throwNpe();
                        }
                        GlobalConfigSettings.ResourceMeta resourceMeta = globalConfigSettings.getResourceMeta();
                        Intrinsics.checkExpressionValueIsNotNull(resourceMeta, "globalSettings!!.resourceMeta");
                        resourceMeta.setAccessKeys(MapsKt.emptyMap());
                    }
                }
            }
        }
        mExponentialBackoffRetry = new ExponentialBackoffRetry(new IEBRetryTask() { // from class: com.bytedance.iesgurd.settings.GlobalSettingsManager$initSelf$1
            public final void execute() {
                ReqType reqType2;
                GeckoLogger.d("sync global settings retry");
                GlobalSettingsManager globalSettingsManager = GlobalSettingsManager.INSTANCE;
                GlobalSettingsManager globalSettingsManager2 = GlobalSettingsManager.INSTANCE;
                reqType2 = GlobalSettingsManager.reqType;
                if (reqType2 == null) {
                    Intrinsics.throwNpe();
                }
                globalSettingsManager.syncGlobalSettings(reqType2, true);
            }
        });
    }

    public static /* synthetic */ void fetchGlobalSettings$default(GlobalSettingsManager globalSettingsManager, ReqType reqType2, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        globalSettingsManager.fetchGlobalSettings(reqType2, str);
    }

    public final void fetchGlobalSettings(ReqType reqType2, String probe2) {
        Intrinsics.checkParameterIsNotNull(reqType2, "reqType");
        probe = probe2;
        syncGlobalSettings(reqType2, false);
    }

    public static /* synthetic */ void syncGlobalSettings$default(GlobalSettingsManager globalSettingsManager, ReqType reqType2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        globalSettingsManager.syncGlobalSettings(reqType2, z);
    }

    public final void syncGlobalSettings(final ReqType reqType2, final boolean isRetry) {
        GeckoExecutors.INSTANCE.getCheckUpdateExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.settings.GlobalSettingsManager$syncGlobalSettings$1
            @Override // java.lang.Runnable
            public final void run() {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                AtomicBoolean atomicBoolean3;
                AtomicBoolean atomicBoolean4;
                ReqType reqType3;
                GlobalConfigSettings.ReqMeta reqMeta;
                GlobalSettingsManager globalSettingsManager = GlobalSettingsManager.INSTANCE;
                atomicBoolean = GlobalSettingsManager.mFetching;
                if (atomicBoolean.get()) {
                    GeckoLogger.d("settings is syncing, return, next fetch type is " + ReqType.this);
                    GlobalSettingsManager globalSettingsManager2 = GlobalSettingsManager.INSTANCE;
                    GlobalSettingsManager.nextReqType = ReqType.this;
                    return;
                }
                GlobalSettingsManager globalSettingsManager3 = GlobalSettingsManager.INSTANCE;
                atomicBoolean2 = GlobalSettingsManager.mFetching;
                atomicBoolean2.set(true);
                GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.SYNC_GLOBAL_SETTING, "settings start, retry: " + isRetry + ", reqType: " + ReqType.this);
                GlobalSettingsManager globalSettingsManager4 = GlobalSettingsManager.INSTANCE;
                GlobalSettingsManager.reqType = ReqType.this;
                GlobalSettingsManager globalSettingsManager5 = GlobalSettingsManager.INSTANCE;
                GlobalSettingsManager.statisticData = new StatisticSettingsData();
                GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).setRetry(isRetry);
                if (ReqType.this == ReqType.NORMAL) {
                    GlobalManager.INSTANCE.getSettingsFetched().set(true);
                }
                GlobalSettingsManager globalSettingsManager6 = GlobalSettingsManager.INSTANCE;
                atomicBoolean3 = GlobalSettingsManager.mIsInit;
                if (atomicBoolean3.compareAndSet(false, true)) {
                    RegisterManager.INSTANCE.registerDirAndCustomParams();
                    GlobalSettingsManager.INSTANCE.scheduleSettings();
                }
                try {
                    GlobalSettingsManager.INSTANCE.syncRequestServer(ReqType.this, isRetry);
                } catch (Throwable th) {
                    GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).setErrorMsg(th.getMessage());
                    GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).upload();
                    GeckoLogger.d("sync global settings exception:" + th.getMessage());
                    GlobalSettingsManager.access$getMExponentialBackoffRetry$p(GlobalSettingsManager.INSTANCE).retry();
                }
                if (ReqType.this == ReqType.NORMAL) {
                    MetaDataManager.INSTANCE.initMetaData();
                    InitDelayTask.INSTANCE.start();
                }
                GlobalSettingsManager globalSettingsManager7 = GlobalSettingsManager.INSTANCE;
                atomicBoolean4 = GlobalSettingsManager.mFetching;
                atomicBoolean4.set(false);
                GlobalSettingsManager globalSettingsManager8 = GlobalSettingsManager.INSTANCE;
                reqType3 = GlobalSettingsManager.nextReqType;
                if (reqType3 == ReqType.REGISTER_LATE) {
                    GeckoLogger.d("sync global settings with REGISTER_LATE");
                    GlobalSettingsManager.syncGlobalSettings$default(GlobalSettingsManager.INSTANCE, ReqType.REGISTER_LATE, false, 2, null);
                }
                GlobalSettingsManager globalSettingsManager9 = GlobalSettingsManager.INSTANCE;
                GlobalSettingsManager.nextReqType = null;
                ColdStartManager.INSTANCE.startUp();
                GlobalConfigSettings globalSettings2 = GlobalSettingsManager.INSTANCE.getGlobalSettings();
                if (globalSettings2 == null || (reqMeta = globalSettings2.getReqMeta()) == null) {
                    return;
                }
                LoopManager.INSTANCE.updateBySettings(reqMeta.getPollingInterval());
            }
        });
    }

    public final void syncRequestServer(ReqType reqType2, boolean isRetry) throws Throwable {
        StatisticSettingsData statisticSettingsData = statisticData;
        if (statisticSettingsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statisticData");
        }
        statisticSettingsData.setReqType(reqType2);
        StatisticSettingsData statisticSettingsData2 = statisticData;
        if (statisticSettingsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statisticData");
        }
        statisticSettingsData2.setLocalVersion(mSettingsVersion);
        String str = probe;
        if (str != null) {
            StatisticSettingsData statisticSettingsData3 = statisticData;
            if (statisticSettingsData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statisticData");
            }
            statisticSettingsData3.setProbeHeader(str);
        }
        RequestBodySettings requestBodySettings = new RequestBodySettings(reqType2, mSettingsVersion);
        if (isRetry) {
            requestBodySettings.getReqInfo().setRetry(true);
        }
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        StringBuilder sb = new StringBuilder("https://");
        Intrinsics.checkExpressionValueIsNotNull(globalConfig, "globalConfig");
        new RequestExecutor(requestBodySettings, sb.append(globalConfig.getHost()).append("/gkx/api/settings/v3").toString(), true, probe, new Function1<Response, Unit>() { // from class: com.bytedance.iesgurd.settings.GlobalSettingsManager$syncRequestServer$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v13, types: [com.bytedance.iesgurd.settings.GlobalSettingsManager$syncRequestServer$2$type$1] */
            public final void invoke(Response response) {
                Intrinsics.checkParameterIsNotNull(response, "it");
                GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).setHttpStatus(response.code);
                GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).setErrorMsg(response.msg);
                GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).setLogId(RequestExecutor.Companion.getLogId(response));
                GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.SETTINGS_RESPONSE, "settings response log id:" + GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).getLogId());
                if (response.code != 200) {
                    throw new Throwable("settings failed, code: " + response.code + ", msg: " + response.msg);
                }
                try {
                    Object fromJson = GsonUtil.Companion.inst().gson().fromJson(response.body, new TypeToken<ApiResponse<GlobalConfigSettings>>() { // from class: com.bytedance.iesgurd.settings.GlobalSettingsManager$syncRequestServer$2$type$1
                    }.getType());
                    Intrinsics.checkExpressionValueIsNotNull(fromJson, "GsonUtil.inst().gson().fromJson(it.body, type)");
                    ApiResponse apiResponse = (ApiResponse) fromJson;
                    if (apiResponse.getStatus() == 0 && apiResponse.getData() == null) {
                        throw new Throwable("get settings error,response data is null");
                    }
                    if (apiResponse.getStatus() != 2100 && apiResponse.getStatus() != 0) {
                        GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).setErrCode(apiResponse.getStatus());
                        GlobalSettingsManager.access$getStatisticData$p(GlobalSettingsManager.INSTANCE).setErrorMsg(apiResponse.getMsg());
                    }
                    GlobalSettingsManager.INSTANCE.handleResponse(apiResponse);
                } catch (Exception e) {
                    throw new Throwable("json parse failed：" + e.getMessage() + ", content: " + response.body);
                }
            }
        }).run();
    }

    public final void handleResponse(ApiResponse<GlobalConfigSettings> response) {
        SettingsExtra extra = response.getExtra();
        if (extra != null) {
            mSettingsStoreManager.putSettingsExtra(extra);
            settingsExtra = extra;
        }
        if (response.getStatus() == 0) {
            ExponentialBackoffRetry exponentialBackoffRetry = mExponentialBackoffRetry;
            if (exponentialBackoffRetry == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExponentialBackoffRetry");
            }
            exponentialBackoffRetry.stopRetry();
            GlobalConfigSettings data = response.getData();
            globalSettings = data;
            if (data == null) {
                Intrinsics.throwNpe();
            }
            String version = data.getVersion();
            Intrinsics.checkExpressionValueIsNotNull(version, "globalSettings!!.version");
            mSettingsVersion = version;
            StatisticSettingsData statisticSettingsData = statisticData;
            if (statisticSettingsData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statisticData");
            }
            statisticSettingsData.setVersion(mSettingsVersion);
            GlobalSettingsStoreManager globalSettingsStoreManager = mSettingsStoreManager;
            GlobalConfigSettings globalConfigSettings = globalSettings;
            if (globalConfigSettings == null) {
                Intrinsics.throwNpe();
            }
            globalSettingsStoreManager.putSettings(globalConfigSettings);
            HandlerTimerTaskManager.inst().cancel(0);
            scheduleSettings();
        }
        GeckoLogger.d("request finish: " + response.getStatus() + ", " + response.getMsg());
        ExponentialBackoffRetry exponentialBackoffRetry2 = mExponentialBackoffRetry;
        if (exponentialBackoffRetry2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExponentialBackoffRetry");
        }
        exponentialBackoffRetry2.stopRetry();
        StatisticSettingsData statisticSettingsData2 = statisticData;
        if (statisticSettingsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statisticData");
        }
        statisticSettingsData2.upload();
    }

    public final void scheduleSettings() {
        GlobalConfigSettings globalConfigSettings = globalSettings;
        if (globalConfigSettings == null) {
            return;
        }
        if (globalConfigSettings == null) {
            Intrinsics.throwNpe();
        }
        GlobalConfigSettings.SettingsConfig settingsConfig = globalConfigSettings.getSettingsConfig();
        if (settingsConfig == null || settingsConfig.getPollingInterval() <= 0) {
            return;
        }
        long pollingInterval = settingsConfig.getPollingInterval() * BytePatchException.ErrorCode.paramsError;
        HandlerTimerTaskManager.inst().schedule(new SettingsTimerTask(), pollingInterval, pollingInterval);
    }

    /* compiled from: GlobalSettingsManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/iesgurd/settings/GlobalSettingsManager$SettingsTimerTask;", "Lcom/bytedance/geckox/task/HandlerTask;", "", "()V", "execute", "", "taskType", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class SettingsTimerTask extends HandlerTask<Object> {
        public int taskType() {
            return 0;
        }

        public void execute() {
            GlobalSettingsManager.syncGlobalSettings$default(GlobalSettingsManager.INSTANCE, ReqType.POLLING, false, 2, null);
        }
    }

    public final void setProbe(String probe2) {
        probe = probe2;
    }

    public final void cleanSettings() {
        globalSettings = null;
        mSettingsVersion = ViewVisibleBridge.INVISIBLE;
        mSettingsStoreManager.deleteSettings();
    }

    public final void resetForTest() {
        cleanSettings();
        ExponentialBackoffRetry exponentialBackoffRetry = mExponentialBackoffRetry;
        if (exponentialBackoffRetry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExponentialBackoffRetry");
        }
        exponentialBackoffRetry.stopRetry();
        HandlerTimerTaskManager.inst().cancel(0);
    }
}
