package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.dumper.CommonParamInfo;
import com.bytedance.crash.dumper.CustomData;
import com.bytedance.crash.dumper.CustomFile;
import com.bytedance.crash.dumper.CustomFilter;
import com.bytedance.crash.dumper.GfxInfo;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.RepairInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.plugin.PluginInfoManager;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashDumper {
    private final File mDirectory;
    private final AtomicBoolean mAppVersion = new AtomicBoolean(false);
    private final AtomicBoolean mCommonParamsLatch = new AtomicBoolean(false);
    private final AtomicBoolean mLocaleInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mCustomFilterLatch = new AtomicBoolean(false);
    private final AtomicBoolean mMemoryInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mScrapsLatch = new AtomicBoolean(false);
    private final AtomicBoolean mLooperMessagesLatch = new AtomicBoolean(false);
    private final AtomicBoolean mSdkInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mActivityInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mAllStacksLatch = new AtomicBoolean(false);
    private final AtomicBoolean mGfxInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mRepairInfoLatch = new AtomicBoolean(false);
    private final AtomicBoolean mViewTreeLatch = new AtomicBoolean(false);
    private final AtomicBoolean mCustomDataLatch = new AtomicBoolean(false);
    private final AtomicBoolean mCustomFileLatch = new AtomicBoolean(false);
    private final AtomicBoolean mALogLatch = new AtomicBoolean(false);
    private final AtomicBoolean mExtension = new AtomicBoolean(false);
    private long mCrashTime = 0;
    private CrashType mCrashType = CrashType.UNKNOWN;
    private int mCrashTid = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashDumper(File file) {
        this.mDirectory = file;
    }

    private void updateCrashTid(int i) {
        this.mCrashTid = i;
    }

    private void updateCrashType(CrashType crashType, long j) {
        if (j != 0) {
            long j2 = this.mCrashTime;
            if (j2 == 0 || j2 > j) {
                this.mCrashTime = j;
                this.mCrashType = crashType;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File getDirectory() {
        return this.mDirectory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpJavaInfoAfterNative(long j, boolean z, boolean z2, boolean z3, int i) {
        updateCrashType(CrashType.NATIVE, j);
        updateCrashTid(i);
        dumpJavaInfo(z, z2, z3);
    }

    private long dumpNativeInfo(long j) {
        return NativeBridge.dumpCrashNativeInfo(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpAppVersion() {
        try {
            if (this.mAppVersion.compareAndSet(false, true)) {
                AppVersion.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("NPTH_DUMP", th);
        }
    }

    void dumpCommonParams() {
        try {
            if (this.mCommonParamsLatch.compareAndSet(false, true)) {
                CommonParamInfo.dump(this.mDirectory);
            }
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpCommonParams", th);
        }
    }

    private void dumpJavaInfo(boolean z, boolean z2, boolean z3) {
        dumpCommonParams();
        dumpLocaleInfo();
        dumpCustomFilter();
        dumpMemoryInfo();
        dumpScraps();
        if (z3) {
            dumpLooperMessages();
        }
        dumpSdkInfo();
        dumpActivityInfo();
        if (z) {
            dumpAllStacks();
        }
        dumpGfxInfo();
        if (z2) {
            dumpViewTree();
        }
        dumpExtension();
        dumpCustomData();
        dumpCustomFile();
        dumpALog();
        dumpRepairInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpCrashInfoFromJava(CrashType crashType, long j, boolean z, boolean z2) {
        try {
            updateCrashType(crashType, j);
            dumpJavaInfoAfterNative(dumpNativeInfo(j), true, z, z2, 0);
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("NPTH_DUMP", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadCrashInfo(JSONObject jSONObject, JSONObject jSONObject2, File file) {
        MemoryInfo.pushTo(jSONObject, file);
        LooperMessageRecorder.load(jSONObject, file);
        PluginInfoManager.pushTo(jSONObject, file);
        SdkInfo.pushTo(jSONObject, file);
        Logcat.pushTo(jSONObject, file);
        ActivityLifecycle.load(jSONObject, file);
        JavaStack.pushAllStackTo(jSONObject, file);
        Scraps.pushTo(jSONObject, file);
        pushExtension(jSONObject, jSONObject2, file);
        CustomData.pushTo(jSONObject, file);
    }

    private void dumpLocaleInfo() {
        if (this.mLocaleInfoLatch.compareAndSet(false, true)) {
            LocaleInfo.dump(this.mDirectory);
        }
    }

    private void dumpCustomFilter() {
        if (this.mCustomFilterLatch.compareAndSet(false, true)) {
            CustomFilter.dump(this.mDirectory);
            CustomFilter.dumpCustomCrashReason(this.mDirectory);
        }
    }

    private void dumpMemoryInfo() {
        if (this.mMemoryInfoLatch.compareAndSet(false, true)) {
            MemoryInfo.dump(this.mDirectory);
        }
    }

    private void dumpScraps() {
        if (this.mScrapsLatch.compareAndSet(false, true)) {
            Scraps.dump(this.mDirectory);
        }
    }

    void dumpLooperMessages() {
        try {
            if (this.mLooperMessagesLatch.compareAndSet(false, true)) {
                LooperMessageRecorder.getInstance().dumpMessages(this.mDirectory);
            }
        } catch (Throwable unused) {
        }
    }

    private void dumpSdkInfo() {
        if (this.mSdkInfoLatch.compareAndSet(false, true)) {
            SdkInfo.dump(this.mDirectory);
        }
    }

    private void dumpActivityInfo() {
        if (this.mActivityInfoLatch.compareAndSet(false, true)) {
            ActivityLifecycle.dump(this.mDirectory);
        }
    }

    private void dumpAllStacks() {
        if (this.mAllStacksLatch.compareAndSet(false, true)) {
            JavaStack.dumpAllStack(this.mDirectory);
        }
    }

    private void dumpGfxInfo() {
        if (this.mGfxInfoLatch.compareAndSet(false, true)) {
            GfxInfo.dump(this.mDirectory);
        }
    }

    private void dumpRepairInfo() {
        if (this.mRepairInfoLatch.compareAndSet(false, true)) {
            RepairInfo.dumpSignalMonitorInfo(this.mDirectory);
        }
    }

    private void dumpViewTree() {
        if (this.mViewTreeLatch.compareAndSet(false, true)) {
            ViewTree.dump(this.mDirectory);
        }
    }

    void dumpCustomData() {
        if (this.mCustomDataLatch.compareAndSet(false, true)) {
            CustomData.dump(this.mDirectory, this.mCrashType, this.mCrashTid);
        }
    }

    private void dumpCustomFile() {
        if (this.mCustomFileLatch.compareAndSet(false, true)) {
            CustomFile.dump(this.mDirectory, this.mCrashType);
        }
    }

    private void dumpALog() {
        if (this.mALogLatch.compareAndSet(false, true)) {
            Flavor.dumpAppLog(this.mDirectory);
        }
    }

    private void dumpExtension() {
        ICrashBodyExtensionDumper bodyDumper;
        if (MonitorManager.getAppMonitor() == null || (bodyDumper = MonitorManager.getAppMonitor().getBodyDumper()) == null || !this.mExtension.compareAndSet(false, true)) {
            return;
        }
        bodyDumper.dump(this.mDirectory);
    }

    private static void pushExtension(JSONObject jSONObject, JSONObject jSONObject2, File file) {
        ICrashBodyExtensionDumper bodyDumper;
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null || (bodyDumper = appMonitor.getBodyDumper()) == null) {
            return;
        }
        bodyDumper.load(jSONObject, jSONObject2, file);
    }
}
