package com.bytedance.crash.crash;

import android.content.Context;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.diagnose.InitMonitor;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.event.ProtectorManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.ResourceMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashManager {
    public static final String DIR_NAME = "crash";
    private static CrashManager sInstance;
    private final File crashDumpDir;
    private final CustomJavaHandler customJavaHandler;
    private final File mDirectory;
    private final JavaCrashHandler mJavaCrashHandler;
    private final NativeCrashHandler mNativeCrashHandler;

    public static boolean isDirectoryExist(File file) {
        return new File(file, DIR_NAME).exists();
    }

    public static synchronized void startMonitor(Context context, File file) {
        synchronized (CrashManager.class) {
            NpthLog.m233i("CrashManager startMonitor");
            if (sInstance == null) {
                sInstance = new CrashManager(context, file);
            }
        }
    }

    public static CustomJavaHandler getCustomJavaHandler() {
        CrashManager crashManager = sInstance;
        if (crashManager == null) {
            return null;
        }
        return crashManager.customJavaHandler;
    }

    CrashManager(Context context, File file) {
        File createDirectory = FileSystemUtils.createDirectory(file, DIR_NAME);
        this.mDirectory = createDirectory;
        FileSystemUtils.createDirectory(file, "protector");
        File file2 = new File(createDirectory, getProcessDirectoryName());
        this.crashDumpDir = file2;
        CrashDumper crashDumper = new CrashDumper(file2);
        this.customJavaHandler = new CustomJavaHandler(file);
        this.mJavaCrashHandler = new JavaCrashHandler(crashDumper);
        InitMonitor.step("JavaCrash_Init");
        this.mNativeCrashHandler = new NativeCrashHandler(context, crashDumper);
        InitMonitor.step("NativeCrash_Init");
    }

    public static File getRootDirectory() {
        CrashManager crashManager = sInstance;
        if (crashManager != null) {
            return crashManager.mDirectory;
        }
        return null;
    }

    public static String getProcessDirectoryName() {
        return getProcessDirectoryName(Global.getAppStartTime(), Process.myPid());
    }

    public static String getProcessDirectoryName(long j, int i) {
        return j + "-" + i;
    }

    public static void startDumperThread() {
        NativeBridge.startDumperThread();
    }

    public static void dumperLateInit() {
        NativeBridge.dumperLateInit();
    }

    public static void handleNativeCrash(long j, int i) {
        Global.setHasCrashBefore(true);
        CrashManager crashManager = sInstance;
        if (crashManager != null) {
            crashManager.mNativeCrashHandler.nativeDumperFinished(j, i);
        }
    }

    public static List<CrashSummary> getNativeCrashList(Context context) {
        File[] listFiles = new File(Global.getRootDirectory(context), DIR_NAME).listFiles();
        if (listFiles == null) {
            return null;
        }
        NativeBridge.loadLibrary();
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            CrashSummary loadFromDirectory = CrashSummary.loadFromDirectory(file, true);
            if (loadFromDirectory != null) {
                arrayList.add(loadFromDirectory);
            }
        }
        return arrayList;
    }

    private void uploadAll(AppMonitor appMonitor, File[] fileArr) {
        for (File file : fileArr) {
            if (!file.getName().equals(this.crashDumpDir.getName())) {
                NpthLog.m233i("uploadAll " + file.getAbsolutePath());
                CrashSummary loadFromDirectory = CrashSummary.loadFromDirectory(file);
                if (loadFromDirectory != null) {
                    CrashAccessibilityMonitor.setCrashInfo(loadFromDirectory.mCrashType, loadFromDirectory.getProcessName(), loadFromDirectory.getPid(), loadFromDirectory.getCrashTime());
                    NpthLog.m233i("uploadAll create summary");
                    JSONObject jSONObject = new JSONObject();
                    CoredumpAdapter.upload(appMonitor, loadFromDirectory, file, jSONObject);
                    loadFromDirectory.upload(appMonitor, jSONObject);
                } else {
                    NpthLog.m233i("uploadAll delete dir" + file.getAbsolutePath());
                    FileSystemUtils.deleteAll(file);
                    NpthMonitor.reportInnerExceptionWithSpace("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + file.getAbsolutePath()));
                }
            }
        }
    }

    private void uploadAll(final AppMonitor appMonitor, File[] fileArr, long j) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (File file : fileArr) {
            if (!file.getName().equals(this.crashDumpDir.getName())) {
                NpthLog.m233i("uploadAll " + file.getAbsolutePath());
                CrashSummary loadFromDirectory = CrashSummary.loadFromDirectory(file);
                if (loadFromDirectory != null) {
                    CrashAccessibilityMonitor.setCrashInfo(loadFromDirectory.mCrashType, loadFromDirectory.getProcessName(), loadFromDirectory.getPid(), loadFromDirectory.getCrashTime());
                    if (loadFromDirectory.getCrashTime() - loadFromDirectory.getStartTime() > RuntimeConfig.getLaunchCrashInterval()) {
                        arrayList.add(loadFromDirectory);
                        arrayList2.add(file);
                    } else {
                        updateOne(loadFromDirectory, appMonitor, file);
                    }
                } else {
                    NpthLog.m233i("uploadAll delete dir" + file.getAbsolutePath());
                    FileSystemUtils.deleteAll(file);
                    NpthMonitor.reportInnerExceptionWithSpace("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + file.getAbsolutePath()));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.crash.CrashManager.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < arrayList.size(); i++) {
                    CrashManager.this.updateOne((CrashSummary) arrayList.get(i), appMonitor, (File) arrayList2.get(i));
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOne(CrashSummary crashSummary, AppMonitor appMonitor, File file) {
        NpthLog.m233i("uploadAll create summary");
        JSONObject jSONObject = new JSONObject();
        CoredumpAdapter.upload(appMonitor, crashSummary, file, jSONObject);
        if (crashSummary.mCrashType == CrashType.JAVA || crashSummary.mCrashType == CrashType.LAUNCH) {
            JSONUtils.put(jSONObject, Constants.FROM_CUSTOM, false);
        }
        crashSummary.upload(appMonitor, jSONObject);
    }

    private void uploadAll(final AppMonitor appMonitor, long j) {
        File[] listFiles = this.mDirectory.listFiles();
        if (listFiles != null) {
            NpthLog.m233i("uploadAll:crashDumpDir:" + this.crashDumpDir.getName());
            if (j > 0) {
                uploadAll(appMonitor, listFiles, j);
            } else {
                uploadAll(appMonitor, listFiles);
            }
        }
        DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.crash.CrashManager.2
            @Override // java.lang.Runnable
            public void run() {
                ResourceMonitor.upload(appMonitor);
                ProtectorManager.upload();
            }
        }, j);
    }

    public static void upload(AppMonitor appMonitor, long j) {
        try {
            if (sInstance != null) {
                NpthLog.m233i("uploadAll");
                sInstance.uploadAll(appMonitor, j);
            }
        } catch (Exception e) {
            NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AppMonitor", e);
        }
    }
}
