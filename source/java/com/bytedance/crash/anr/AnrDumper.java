package com.bytedance.crash.anr;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.IPreCrashCallback;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.dumper.CommonParamInfo;
import com.bytedance.crash.dumper.CustomData;
import com.bytedance.crash.dumper.CustomFile;
import com.bytedance.crash.dumper.CustomFilter;
import com.bytedance.crash.dumper.EvilDumpFile;
import com.bytedance.crash.dumper.GfxInfo;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.ProcessState;
import com.bytedance.crash.dumper.RepairInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.plugin.PluginInfoManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AnrDumper {
    private static volatile boolean enableUploadBackgroundANR;
    private static volatile boolean sIsDumpViewTree;
    private JSONArray mAllData;
    private final long mCrashTime;
    private final File mDirectory;
    private final boolean mFromSignal;
    private final long mNativeDumper;
    private final AtomicBoolean mSummaryLatch = new AtomicBoolean(false);
    private final AtomicBoolean mAdjDump = new AtomicBoolean(false);
    private final AtomicBoolean mMainStackLatch = new AtomicBoolean(false);
    private final AtomicBoolean mAppVersionLatch = new AtomicBoolean(false);
    private final AtomicBoolean mCommonParamsLatch = new AtomicBoolean(false);
    private final AtomicBoolean mAnrProfilerLatch = new AtomicBoolean(false);
    private final AtomicBoolean mProcessStateLatch = new AtomicBoolean(false);
    private final AtomicBoolean mLooperMessagesLatch = new AtomicBoolean(false);
    private final AtomicBoolean mAnrTraceLatch = new AtomicBoolean(false);
    private final AtomicBoolean mLocaleInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mCustomFilterLatch = new AtomicBoolean(false);
    private final AtomicBoolean mMemoryInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mScrapsLatch = new AtomicBoolean(false);
    private final AtomicBoolean mSdkInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mActivityLifecycleLatch = new AtomicBoolean(false);
    private final AtomicBoolean mGfxInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mRepairInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mViewTreeLatch = new AtomicBoolean(false);
    private final AtomicBoolean mCustomDataLatch = new AtomicBoolean(false);
    private final AtomicBoolean mCustomFileLatch = new AtomicBoolean(false);
    private final AtomicBoolean mEvilFileLatch = new AtomicBoolean(false);
    private final AtomicBoolean mALogLatch = new AtomicBoolean(false);
    private boolean mNativeInfoDumped = false;
    private final AtomicBoolean mExtension = new AtomicBoolean(false);
    private final AtomicBoolean mCallbackLatch = new AtomicBoolean(false);

    private AnrDumper(File file, long j, boolean z) {
        this.mDirectory = file;
        this.mCrashTime = j;
        this.mFromSignal = z;
        this.mNativeDumper = NativeBridge.anrDumperNativeInit(file.getAbsolutePath());
    }

    public static void setDumpViewTreeEnable(boolean z) {
        sIsDumpViewTree = z;
    }

    protected void finalize() {
        NativeBridge.anrDumpNativeRelease(this.mNativeDumper);
    }

    public static AnrDumper create(File file, long j, boolean z) {
        return new AnrDumper(file, j, z);
    }

    public static void setUploadBackgroundANR(boolean z) {
        enableUploadBackgroundANR = z;
    }

    private void dumpSummary(int i) {
        try {
            if (this.mSummaryLatch.compareAndSet(false, true)) {
                AnrSummary.dump(this.mDirectory, this.mCrashTime, this.mFromSignal, i);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpSummary", th);
        }
    }

    private void dumpAdj(int i) {
        try {
            if (!this.mAdjDump.compareAndSet(false, true) || i == Integer.MAX_VALUE) {
                return;
            }
            ConfigDump.dump(this.mDirectory, i);
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpAdj", th);
        }
    }

    private void dumpMainStack() {
        try {
            if (AnrManager.isDumpData() && this.mMainStackLatch.compareAndSet(false, true)) {
                this.mAllData = Flavor.Tob.saveAllData(CrashType.ANR, JavaStack.dumpMainStack(this.mDirectory).getStackTraceElements(), this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpMainStack", th);
        }
    }

    private void dumpAppVersion() {
        try {
            if (this.mAppVersionLatch.compareAndSet(false, true)) {
                AppVersion.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpAppVersion", th);
        }
    }

    private void dumpCommonParams() {
        try {
            if (this.mCommonParamsLatch.compareAndSet(false, true)) {
                CommonParamInfo.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpCommonParams", th);
        }
    }

    private void dumpProfileInfoAndNativeInfo() {
        try {
            if (this.mAnrProfilerLatch.compareAndSet(false, true)) {
                AnrManager.dumpProfilerWithNativeInfo(this.mDirectory, this.mNativeDumper);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpProfileInfo", th);
        }
    }

    private void dumpProcessState() {
        try {
            if (this.mProcessStateLatch.compareAndSet(false, true)) {
                ProcessState.getInstance().dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpProfileInfo", th);
        }
    }

    private void dumpLooperMessages(boolean z) {
        if (z) {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.anr.AnrDumper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (AnrDumper.this.mLooperMessagesLatch.compareAndSet(false, true)) {
                            LooperMessageRecorder.getInstance().dumpMessages(AnrDumper.this.mDirectory);
                        }
                    } catch (Throwable th) {
                        NpthMonitor.directReportInnerException("dumpLooperMessages", th);
                    }
                }
            });
            return;
        }
        try {
            if (this.mLooperMessagesLatch.compareAndSet(false, true)) {
                LooperMessageRecorder.getInstance().dumpMessages(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpLooperMessages", th);
        }
    }

    private void dumpAnrAllThreadTrace() {
        if (AnrManager.isDumpData()) {
            try {
                if (this.mAnrTraceLatch.compareAndSet(false, true)) {
                    NativeBridge.anrDumpTrace(AnrTraceParser.getTraceFile(this.mDirectory).getAbsolutePath());
                }
            } catch (Throwable th) {
                NpthMonitor.directReportInnerException("dumpAnrTrace", th);
            }
        }
    }

    private void dumpLocaleInfo() {
        try {
            if (this.mLocaleInfoLatch.compareAndSet(false, true)) {
                LocaleInfo.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpLocaleInfo", th);
        }
    }

    private void dumpCustomFilter() {
        try {
            if (this.mCustomFilterLatch.compareAndSet(false, true)) {
                CustomFilter.dump(this.mDirectory);
                CustomFilter.dumpCustomCrashReason(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpCustomFilter", th);
        }
    }

    private void dumpMemoryInfo() {
        try {
            if (this.mMemoryInfoLatch.compareAndSet(false, true)) {
                MemoryInfo.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpMemoryInfo", th);
        }
    }

    private void dumpScraps() {
        try {
            if (this.mScrapsLatch.compareAndSet(false, true)) {
                Scraps.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpScraps", th);
        }
    }

    private void dumpSdkInfo() {
        try {
            if (this.mSdkInfoLatch.compareAndSet(false, true)) {
                SdkInfo.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpSdkInfo", th);
        }
    }

    private void dumpActivityLifecycle() {
        try {
            if (this.mActivityLifecycleLatch.compareAndSet(false, true)) {
                ActivityLifecycle.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpActivityLifecycle", th);
        }
    }

    private void dumpGfxInfo() {
        try {
            if (this.mGfxInfoLatch.compareAndSet(false, true)) {
                GfxInfo.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpGfxInfo", th);
        }
    }

    private void dumpRepairInfo() {
        try {
            if (this.mRepairInfoLatch.compareAndSet(false, true)) {
                RepairInfo.dumpSignalMonitorInfo(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpRepairInfo", th);
        }
    }

    private void dumpViewTree() {
        if (sIsDumpViewTree) {
            try {
                if (this.mViewTreeLatch.compareAndSet(false, true)) {
                    ViewTree.dump(this.mDirectory);
                }
            } catch (Throwable th) {
                NpthMonitor.directReportInnerException("dumpViewTree", th);
            }
        }
    }

    private void dumpCustomData() {
        try {
            if (this.mCustomDataLatch.compareAndSet(false, true)) {
                CustomData.dump(this.mDirectory, CrashType.ANR, 0);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpCustomData", th);
        }
    }

    private void dumpCustomFile() {
        try {
            if (this.mCustomFileLatch.compareAndSet(false, true)) {
                CustomFile.dump(this.mDirectory, CrashType.ANR);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpCustomFile", th);
        }
    }

    private void dumpEvilMethodFile() {
        try {
            if (this.mEvilFileLatch.compareAndSet(false, true)) {
                EvilDumpFile.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpCustomFile", th);
        }
    }

    private void dumpALog() {
        try {
            if (this.mALogLatch.compareAndSet(false, true)) {
                Flavor.dumpAppLog(this.mDirectory);
            }
        } catch (Throwable unused) {
        }
    }

    private void dumpNativeInfo() {
        if (this.mNativeInfoDumped) {
            return;
        }
        NativeBridge.anrDumpNativeInfo(this.mNativeDumper);
        this.mNativeInfoDumped = true;
    }

    private void dumpExtension() {
        ICrashBodyExtensionDumper bodyDumper;
        try {
            if (MonitorManager.getAppMonitor() == null || (bodyDumper = MonitorManager.getAppMonitor().getBodyDumper()) == null || !this.mExtension.compareAndSet(false, true)) {
                return;
            }
            bodyDumper.dump(this.mDirectory);
        } catch (Throwable unused) {
        }
    }

    private static void loadExtension(JSONObject jSONObject, JSONObject jSONObject2, File file) {
        ICrashBodyExtensionDumper bodyDumper;
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null || (bodyDumper = appMonitor.getBodyDumper()) == null) {
            return;
        }
        bodyDumper.load(jSONObject, jSONObject2, file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONArray dumpAllInfo(int i, int i2) {
        if (AnrManager.isDropData()) {
            return null;
        }
        dumpBeforeTrace(i2);
        handleCallback();
        dumpTrace();
        dumpAfterTrace(i);
        return this.mAllData;
    }

    private void dumpBeforeTrace(int i) {
        dumpSummary(i);
        dumpAppVersion();
        dumpProfileInfoAndNativeInfo();
        dumpProcessState();
        dumpLooperMessages(true);
    }

    private void dumpTrace() {
        dumpMainStack();
        dumpAnrAllThreadTrace();
    }

    public void handleCallback() {
        AppMonitor appMonitor;
        try {
            if (!this.mCallbackLatch.compareAndSet(false, true) || (appMonitor = MonitorManager.getAppMonitor()) == null) {
                return;
            }
            Iterator<IPreCrashCallback> it = appMonitor.getUserDataCenter().getPreCrashCallback(CrashType.ANR).iterator();
            while (it.hasNext()) {
                try {
                    it.next().onCrash(CrashType.ANR, this.mCrashTime);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void dumpAfterTrace(int i) {
        if (AnrManager.isDumpData()) {
            dumpAdj(i);
            dumpEvilMethodFile();
            dumpLooperMessages(false);
            dumpNativeInfo();
            dumpCommonParams();
            dumpMemoryInfo();
            dumpLocaleInfo();
            dumpCustomFilter();
            dumpScraps();
            dumpSdkInfo();
            dumpActivityLifecycle();
            dumpGfxInfo();
            dumpViewTree();
            dumpExtension();
            dumpALog();
            dumpCustomData();
            dumpCustomFile();
            dumpRepairInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadCrashInfo(JSONObject jSONObject, JSONObject jSONObject2, File file) {
        MemoryInfo.pushTo(jSONObject, file);
        LooperMessageRecorder.load(jSONObject, file);
        if (file != null) {
            PluginInfoManager.pushTo(jSONObject, file.getParentFile());
        }
        SdkInfo.pushTo(jSONObject, file);
        Logcat.pushTo(jSONObject, file);
        ActivityLifecycle.load(jSONObject, file);
        Scraps.pushTo(jSONObject, file);
        CustomData.pushTo(jSONObject, file);
        loadExtension(jSONObject, jSONObject2, file);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ConfigDump {
        private static final String KEY_TIME = "init_sub_launch_time";
        private static final String KEY_TIME_RANGE = "npth_init_sub_launch_range";

        public static void dump(File file, int i) {
            JsonDumper jsonDumper = new JsonDumper(file.getAbsolutePath() + "/anr_config.txt");
            jsonDumper.objectBegin();
            jsonDumper.key(Constants.PROCESS_ADJ);
            jsonDumper.value(i);
            jsonDumper.next();
            jsonDumper.key("enable_upload_bg_anr");
            jsonDumper.value(AnrDumper.enableUploadBackgroundANR);
            jsonDumper.next();
            jsonDumper.key("enable_new_anr");
            jsonDumper.value(GlobalSwitch.isOpenNewAnrMonitor());
            long initElapsedRealtime = Global.getInitElapsedRealtime() - Process.getStartElapsedRealtime();
            jsonDumper.next();
            jsonDumper.key(KEY_TIME);
            jsonDumper.value(initElapsedRealtime);
            jsonDumper.objectEnd();
            jsonDumper.release();
        }

        public static void push(File file, JSONObject jSONObject) {
            JSONObject jSONObject2;
            String readUtf8File = FileSystemUtils.readUtf8File(new File(file, "anr_config.txt"));
            if (readUtf8File != null) {
                try {
                    jSONObject2 = new JSONObject(readUtf8File);
                } catch (Throwable unused) {
                    jSONObject2 = null;
                }
                if (jSONObject2 == null) {
                    return;
                }
                try {
                    int optInt = jSONObject2.optInt(Constants.PROCESS_ADJ, -1);
                    boolean z = optInt < 200 && new File(file, "background_v2").exists();
                    if (optInt >= 0) {
                        jSONObject.put("is_background_v1", String.valueOf(z));
                    }
                } catch (Throwable unused2) {
                }
                try {
                    if (jSONObject2.has(KEY_TIME)) {
                        long j = jSONObject2.getLong(KEY_TIME) / 1000;
                        if (j > 0) {
                            jSONObject.put(KEY_TIME_RANGE, j + "~" + (j + 1));
                        } else {
                            jSONObject.put(KEY_TIME_RANGE, "<1");
                        }
                        jSONObject2.remove(KEY_TIME);
                    }
                } catch (Exception e) {
                    NpthLog.m233i(e);
                }
                if (jSONObject2 != null) {
                    JSONUtils.combineJson(jSONObject, jSONObject2);
                }
            }
        }
    }
}
