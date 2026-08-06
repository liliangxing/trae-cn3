package com.bytedance.iesgurd.core;

import android.content.Context;
import android.util.Log;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.IGeckoGlobalInit;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.probe.ProbeManager;
import com.bytedance.geckox.policy.queue.UpdateTaskManager;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.statistic.monitor.MonitorManager;
import com.bytedance.geckox.task.HandlerTask;
import com.bytedance.geckox.task.HandlerTimerTaskManager;
import com.bytedance.gkfs.GeckoFileSystem;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.model.Common;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GlobalManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u0004\u0018\u00010&J\b\u0010'\u001a\u0004\u0018\u00010\u0012J\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0012J\u0006\u0010,\u001a\u00020\rJ\u0012\u0010-\u001a\u00020$2\n\u0010.\u001a\u00020/\"\u00020\u0013J\u0016\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\u0016\u00103\u001a\u00020$2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u00020$R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\"\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006:"}, d2 = {"Lcom/bytedance/iesgurd/core/GlobalManager;", "", "()V", "accessKeyDirs", "", "", "getAccessKeyDirs", "()Ljava/util/Map;", "common", "Lcom/bytedance/iesgurd/model/Common;", "getCommon", "()Lcom/bytedance/iesgurd/model/Common;", "<set-?>", "", "enable", "getEnable", "()Z", "globalConfig", "Lcom/bytedance/geckox/GeckoGlobalConfig;", "", "initTime", "getInitTime", "()J", "inited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInited", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "needMigrateLocalVersion", "getNeedMigrateLocalVersion", "settingsFetched", "getSettingsFetched", "Lcom/bytedance/geckox/policy/queue/UpdateTaskManager;", "updateTaskManager", "getUpdateTaskManager", "()Lcom/bytedance/geckox/policy/queue/UpdateTaskManager;", "ensureInit", "", "getContext", "Landroid/content/Context;", "getGlobalConfig", "getSettingsEnsureInit", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings;", EventConstants.PARAM_SOURCE_INIT, "config", "isGeckoEnable", "pauseAllUpdate", "autoResumeDelay", "", "registerAccessKey2Dir", "accessKey", "dir", "registerAccessKey2DirOverride", "registerGecko", "geckoRegister", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "resetDeviceId", "deviceId", "resumeAllUpdate", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GlobalManager {
    private static GeckoGlobalConfig globalConfig;
    private static long initTime;
    private static UpdateTaskManager updateTaskManager;
    public static final GlobalManager INSTANCE = new GlobalManager();
    private static final AtomicBoolean settingsFetched = new AtomicBoolean(false);
    private static final AtomicBoolean needMigrateLocalVersion = new AtomicBoolean(false);
    private static final AtomicBoolean inited = new AtomicBoolean(false);
    private static final Map<String, String> accessKeyDirs = new ConcurrentHashMap();
    private static final Common common = new Common();
    private static boolean enable = true;

    private GlobalManager() {
    }

    public final AtomicBoolean getSettingsFetched() {
        return settingsFetched;
    }

    public final AtomicBoolean getNeedMigrateLocalVersion() {
        return needMigrateLocalVersion;
    }

    public final AtomicBoolean getInited() {
        return inited;
    }

    public final Map<String, String> getAccessKeyDirs() {
        return accessKeyDirs;
    }

    public final Common getCommon() {
        return common;
    }

    public final boolean getEnable() {
        return enable;
    }

    public final long getInitTime() {
        return initTime;
    }

    public final UpdateTaskManager getUpdateTaskManager() {
        return updateTaskManager;
    }

    public final void init(GeckoGlobalConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        AtomicBoolean atomicBoolean = inited;
        if (atomicBoolean.get()) {
            return;
        }
        GeckoLogger.d("GeckoGlobalManager init");
        globalConfig = config;
        Context context = config.getContext();
        atomicBoolean.set(true);
        initTime = System.currentTimeMillis();
        HandlerTimerTaskManager.inst();
        MonitorManager.inst().init(context, config);
        updateTaskManager = new UpdateTaskManager();
        ProbeManager probeManager = ProbeManager.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        probeManager.registerProbeListener(context, config);
        if (GkFSUtils.INSTANCE.isEnable()) {
            GeckoFileSystem.INSTANCE.init(context);
        }
        CacheManager.INSTANCE.init(context);
        common.init(config);
        GeckoLogger.d("GeckoGlobalManager init finish");
    }

    public final synchronized void ensureInit() {
        GeckoGlobalConfig geckoGlobalConfig;
        if (inited.get()) {
            return;
        }
        IGeckoGlobalInit iGeckoGlobalInit = (IGeckoGlobalInit) ServiceManager.get().getServiceForReal(IGeckoGlobalInit.class);
        if (iGeckoGlobalInit != null && (geckoGlobalConfig = iGeckoGlobalInit.getGeckoGlobalConfig()) != null) {
            INSTANCE.init(geckoGlobalConfig);
        }
    }

    public final void resetDeviceId(String deviceId) {
        GeckoGlobalConfig geckoGlobalConfig;
        Intrinsics.checkParameterIsNotNull(deviceId, "deviceId");
        if ((deviceId.length() == 0) || (geckoGlobalConfig = globalConfig) == null) {
            return;
        }
        if (geckoGlobalConfig == null) {
            Intrinsics.throwNpe();
        }
        geckoGlobalConfig.setDeviceId(deviceId);
        common.setDeviceId(deviceId);
    }

    public final GeckoGlobalConfig getGlobalConfig() {
        ensureInit();
        return globalConfig;
    }

    public final Context getContext() {
        GeckoGlobalConfig geckoGlobalConfig = globalConfig;
        if (geckoGlobalConfig != null) {
            return geckoGlobalConfig.getContext();
        }
        return null;
    }

    public final GlobalConfigSettings getSettingsEnsureInit() {
        ensureInit();
        if (inited.get()) {
            return GlobalSettingsManager.INSTANCE.getGlobalSettings();
        }
        return null;
    }

    public final boolean isGeckoEnable() {
        GlobalConfigSettings.ReqMeta reqMeta;
        GlobalConfigSettings settingsEnsureInit = getSettingsEnsureInit();
        if (settingsEnsureInit != null && (reqMeta = settingsEnsureInit.getReqMeta()) != null) {
            enable = enable && reqMeta.getEnable();
        }
        return enable;
    }

    public final void registerGecko(IGeckoRegister geckoRegister) {
        Intrinsics.checkParameterIsNotNull(geckoRegister, "geckoRegister");
        ensureInit();
        if (!inited.get()) {
            GeckoLogger.d("register gecko,global gecko has not been initialized");
            RegisterManager.INSTANCE.cacheRegister(geckoRegister);
        } else {
            RegisterManager.INSTANCE.register(geckoRegister, true);
        }
    }

    public final void registerAccessKey2Dir(String accessKey, String dir) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(dir, "dir");
        if (!(accessKey.length() == 0)) {
            if (!(dir.length() == 0)) {
                Map<String, String> map = accessKeyDirs;
                String str = map.get(accessKey);
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    map.put(accessKey, dir);
                    if (needMigrateLocalVersion.get()) {
                        ChannelMetaManager.INSTANCE.migrateLocalVersion(accessKey, dir);
                    }
                    GeckoLogger.d("gecko register root dir, accessKey:" + accessKey + ", root dir:" + dir);
                    GeckoGlobalConfig geckoGlobalConfig = globalConfig;
                    if (geckoGlobalConfig != null) {
                        if (geckoGlobalConfig == null) {
                            Intrinsics.throwNpe();
                        }
                        Context context = geckoGlobalConfig.getContext();
                        Intrinsics.checkExpressionValueIsNotNull(context, "globalConfig!!.context");
                        File filesDir = context.getFilesDir();
                        Intrinsics.checkExpressionValueIsNotNull(filesDir, "globalConfig!!.context.filesDir");
                        String absolutePath = filesDir.getAbsolutePath();
                        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "internal");
                        if (StringsKt.startsWith$default(dir, absolutePath, false, 2, (Object) null)) {
                            return;
                        }
                        new EventMessageModel(EventSubType.EXTERNAL_DIR, accessKey, null, null, dir, 0L).upload();
                        return;
                    }
                    return;
                }
                if (!Intrinsics.areEqual(str, dir)) {
                    String str3 = "oldPath: " + str + ", newPath: " + dir + ", stackTrace: " + Log.getStackTraceString(new Throwable());
                    GeckoLogger.d("registerAccessKey2Dir error for ak: " + accessKey + ", " + str3);
                    UploadStatistic.INSTANCE.uploadEvent(EventSubType.DIFFERENT_PATH_FOR_AK, str3, accessKey, 0L);
                    return;
                }
                return;
            }
        }
        GeckoLogger.w("gecko register failed, accessKey: " + accessKey + ", root dir: " + dir);
    }

    public final void registerAccessKey2DirOverride(String accessKey, String dir) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(dir, "dir");
        Map<String, String> map = accessKeyDirs;
        String str = map.get(accessKey);
        map.put(accessKey, dir);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            GeckoLogger.d("registerAccessKey2DirOverride, accessKey: " + accessKey + ", root dir: " + dir);
        } else if (!Intrinsics.areEqual(str, dir)) {
            GeckoLogger.d("registerAccessKey2DirOverride error for ak[" + accessKey + "]: " + str + ", " + dir);
            UploadStatistic.INSTANCE.uploadEvent(EventSubType.OVERRIDE_PATH, "oldPath: " + str + ", newPath: " + dir, accessKey, 0L);
        }
    }

    public final void pauseAllUpdate(long... autoResumeDelay) {
        Intrinsics.checkParameterIsNotNull(autoResumeDelay, "autoResumeDelay");
        UpdateTaskManager updateTaskManager2 = updateTaskManager;
        if (updateTaskManager2 == null) {
            return;
        }
        if (updateTaskManager2 == null) {
            Intrinsics.throwNpe();
        }
        updateTaskManager2.pauseUpdate();
        if (!(autoResumeDelay.length == 0)) {
            HandlerTimerTaskManager.inst().cancel(8);
            HandlerTimerTaskManager.inst().schedule(new HandlerTask<Object>() { // from class: com.bytedance.iesgurd.core.GlobalManager$pauseAllUpdate$1
                public int taskType() {
                    return 8;
                }

                public void execute() {
                    GlobalManager.INSTANCE.resumeAllUpdate();
                }
            }, autoResumeDelay[0] * BytePatchException.ErrorCode.paramsError);
        }
    }

    public final void resumeAllUpdate() {
        UpdateTaskManager updateTaskManager2 = updateTaskManager;
        if (updateTaskManager2 != null) {
            updateTaskManager2.resumeUpdate();
        }
    }
}
