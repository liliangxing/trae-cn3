package com.bytedance.crash;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.alog.IALogCrashObserver;
import com.bytedance.crash.alog.IAlogUploadStrategy;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.applog.NpthApplog;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.dart.DartCrash;
import com.bytedance.crash.diagnose.InitMonitor;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.ensure.EnsureApi;
import com.bytedance.crash.game.GameCrash;
import com.bytedance.crash.game.GameScriptStack;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.plugin.PluginInfoManager;
import com.bytedance.crash.protector.CrashProtector;
import com.bytedance.crash.repair.RepairAdapter;
import com.bytedance.crash.resource.gwpasan.GwpAsanAdapter;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.runtime.ILogcatImpl;
import com.bytedance.crash.soloader.NpthSoData;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.tracker.ProcessTracker;
import com.bytedance.crash.tracker.TrackerManager;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.IRequestIntercept;
import com.bytedance.crash.upload.LaunchScanner;
import com.bytedance.crash.upload.NetworkDisasterManager;
import com.bytedance.crash.util.NpthDiskMonitor;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IFdCheck;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NpthCore {
    private static boolean dumpAnrAsync;
    private static boolean sIsCurrentMiniAppProcess;
    private static volatile int sMiniAppId;
    private static volatile String sMiniAppVersion;

    @Deprecated
    public static boolean hasCrash() {
        return false;
    }

    @Deprecated
    public static void reportError(String str) {
    }

    public static void setLogcatImpl(ILogcatImpl iLogcatImpl) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class EventCore {
        private static EventCore sInstance;

        static void createInstance() {
            if (sInstance == null) {
                synchronized (EventCore.class) {
                    if (sInstance == null) {
                        sInstance = new EventCore();
                    }
                }
            }
        }

        private EventCore() {
            startMonitor();
        }

        private void startMonitor() {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.NpthCore.EventCore.1
                @Override // java.lang.Runnable
                public void run() {
                    NpthCore.initAsyncForEvent();
                }
            });
        }

        static void init() {
            createInstance();
        }

        static boolean isInit() {
            return sInstance != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class CrashCore {
        private static CrashCore sInstance;

        static void createInstance(Context context, File file) {
            if (sInstance == null) {
                synchronized (CrashCore.class) {
                    if (sInstance == null) {
                        sInstance = new CrashCore(context, file);
                    }
                }
            }
        }

        static void init(Context context, File file) {
            createInstance(context, file);
        }

        static boolean isInit() {
            return sInstance != null;
        }

        private CrashCore(Context context, File file) {
            startMonitor(context, file);
        }

        private void startMonitor(Context context, File file) {
            if (!CrashManager.isDirectoryExist(file)) {
                ActivityLifecycle.markFirstLaunch();
            }
            CrashManager.startMonitor(context, file);
            InitMonitor.step("Crash_Init");
            AnrManager.startMonitor(context, file);
            InitMonitor.step("Anr_Init");
            DefaultWorkThread.postAtFront(new Runnable() { // from class: com.bytedance.crash.NpthCore.CrashCore.1
                @Override // java.lang.Runnable
                public void run() {
                    TrackerManager.startActivityTrack();
                }
            });
            ProcessTracker.getInstance().setEnable(true);
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.NpthCore.CrashCore.2
                @Override // java.lang.Runnable
                public void run() {
                    NetworkDisasterManager.init();
                    NpthCore.initAsyncForCrash();
                }
            });
            InitMonitor.step("DefaultWorkThread_Init");
        }
    }

    public static void initForCrashMonitor(Context context, File file) {
        CrashCore.init(context, file);
    }

    public static void initForEventMonitor() {
        EventCore.init();
    }

    public static boolean isInit() {
        return CrashCore.isInit();
    }

    public static boolean isInitForEvent() {
        return EventCore.isInit() || CrashCore.isInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initAsyncForEvent() {
        NpthLog.m233i("initAsyncForEvent");
        NpthMonitor.init();
        GeneralInfoManager.init();
        EnsureApi.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initAsyncForCrash() {
        NpthLog.m233i("initAsyncForCrash");
        NpthSoData.checkDumperFile();
        initAsyncForEvent();
        TrackerManager.start();
        CrashManager.startDumperThread();
        CrashManager.dumperLateInit();
        CrashProtector.addDefaultConfig();
        try {
            NpthApplog.init();
        } catch (Throwable unused) {
        }
        try {
            NpthApm.init();
        } catch (Throwable unused2) {
        }
        try {
            NpthAlog.init();
            AlogManager.setExternalController();
        } catch (Throwable unused3) {
        }
        try {
            TagService.cleanTags();
        } catch (Throwable unused4) {
        }
        PluginInfoManager.init();
        LaunchScanner.start();
        ServiceManager.registerService(IFdCheck.class, new IFdCheck() { // from class: com.bytedance.crash.NpthCore.1
            public List<String> getFdList() {
                return new ArrayList();
            }
        });
        NpthDiskMonitor.getInstance().init();
    }

    public static void setAnrInfoFileObserver(String str, IFileContentGetter iFileContentGetter) {
        AnrManager.registerAnrInfoObserver(str, iFileContentGetter);
    }

    public static boolean isAnrThreadRunning() {
        if (isInit()) {
            return AnrManager.isRunning();
        }
        return false;
    }

    public static void reportDartError(String str) {
        if (isInit() && !TextUtils.isEmpty(str)) {
            DartCrash.reportError(str);
        }
    }

    public static void reportDartError(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, IUploadCallback iUploadCallback) {
        if (isInit() && !TextUtils.isEmpty(str)) {
            DartCrash.reportError(str, map, map2, iUploadCallback);
        }
    }

    public static void reportGameException(String str, String str2, String str3) {
        if (isInit()) {
            GameCrash.reportError(str, str2, str3);
        }
    }

    @Deprecated
    public static void reportError(Throwable th) {
        NpthBus.getConfigManager().isReportErrorEnable();
    }

    public static void EnableGwpAsan() {
        GwpAsanAdapter.GwpAsanInit();
    }

    public static void setScriptStackCallback(IScriptCallback iScriptCallback) {
        if (isInit()) {
            GameScriptStack.setCallback(iScriptCallback);
        }
    }

    public static void stopAnr() {
        if (isInit()) {
            AnrManager.stopMonitor();
        }
    }

    public static void setRequestIntercept(IRequestIntercept iRequestIntercept) {
        CrashUploader.setRequestIntercept(iRequestIntercept);
    }

    public static void enableALogCollector(String str, IALogCrashObserver iALogCrashObserver, IAlogUploadStrategy iAlogUploadStrategy) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return;
        }
        AlogManager.setInnerController(str, iALogCrashObserver, iAlogUploadStrategy);
    }

    public static void setEncryptImpl(IEncrypt iEncrypt) {
        RuntimeConfig.setEncryptImpl(iEncrypt);
    }

    public static boolean isStopUpload() {
        return RuntimeConfig.isStopUpload();
    }

    public static void stopUpload() {
        RuntimeConfig.stopUpload();
    }

    public static void stopEnsure() {
        RuntimeConfig.stopEnsure();
    }

    public static void setCurrentMiniAppProcess(boolean z) {
        sIsCurrentMiniAppProcess = z;
    }

    public static boolean isCurrentMiniAppProcess() {
        return sIsCurrentMiniAppProcess;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerMiniApp(int i, String str) {
        sMiniAppId = i;
        sMiniAppVersion = str;
    }

    public static int getMiniAppId() {
        return sMiniAppId;
    }

    public static String getMiniAppVersion() {
        return sMiniAppVersion;
    }

    public static int startOptMtkBuffer(int i) {
        return RepairAdapter.startOptMtkBuffer(i);
    }

    public static void setDumpAnrAsync(boolean z) {
        dumpAnrAsync = z;
    }

    public static boolean getDumpAnrAsync() {
        return dumpAnrAsync;
    }

    public static void setAnrResendSigquit(boolean z) {
        NativeBridge.setAnrResendSigquit(z);
    }
}
