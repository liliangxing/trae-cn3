package com.bytedance.crash.anr;

import android.content.Context;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.IAnrUploadCallback;
import com.bytedance.crash.IFileContentGetter;
import com.bytedance.crash.IPreANRCallback;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.ProcessState;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AnrManager {
    public static final long ANR_MIN_INTERVAL = 120000;
    public static final String ANR_ROOT_DIR = "anr";
    public static final String CLOSE_ANR_INFO = "close anr_info report";
    private static final long MIN_SIGNAL_INTERVAL = 5000;
    public static final String SILENT_ANR_NO_ANR_INFO = "silent anr no anr info";
    private static volatile boolean enableUploadBackgroundANR = true;
    private static boolean isDumpData = true;
    private static long lastAnrTime;
    private static AnrManager sInstance;
    private static boolean sIsDropData;
    private long lastSignalTime;
    private final AnrInfoMonitor mAnrInfoMonitor;
    private final AnrProfiler mAnrProfiler;
    final File mAnrRootDirectory;
    private final AnrSignalMonitor mAnrSignalMonitor;
    private boolean mIsRunning;
    private AnrHandler mPendingHandler;

    private File[] getProcessDirectories() {
        return this.mAnrRootDirectory.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.anr.AnrManager.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                String[] split = str.split("-");
                if (split.length == 2) {
                    try {
                        Long.parseLong(split[0]);
                        Integer.parseInt(split[1]);
                        return true;
                    } catch (Throwable unused) {
                    }
                }
                return false;
            }
        });
    }

    private File[] getCrashDirectories(File file) {
        return file.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.anr.AnrManager.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                if (!new File(file2, str).isDirectory()) {
                    return false;
                }
                try {
                    Long.parseLong(str);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
    }

    public static void setUploadBackgroundANR(boolean z) {
        enableUploadBackgroundANR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (this.mIsRunning) {
            return;
        }
        this.mIsRunning = true;
        this.mAnrSignalMonitor.start();
        this.mAnrInfoMonitor.start();
        this.mAnrProfiler.start();
        ProcessState.getInstance().start();
        if (GlobalSwitch.isOpenLooperMonitor()) {
            LooperMessageRecorder.getInstance().start();
        }
    }

    private void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mAnrSignalMonitor.stop();
            this.mAnrInfoMonitor.stop();
            this.mAnrProfiler.exit();
            LooperMessageRecorder.getInstance().stop();
        }
    }

    public static void dumpProfilerWithNativeInfo(File file, long j) {
        AnrProfiler anrProfiler;
        if (!isRunning() || (anrProfiler = sInstance.mAnrProfiler) == null) {
            return;
        }
        anrProfiler.dumpWithNativeInfo(file, j);
    }

    public static File getRootDirectory() {
        AnrManager anrManager = sInstance;
        if (anrManager != null) {
            return anrManager.mAnrRootDirectory;
        }
        return null;
    }

    public static void setAnrDisableDumpData(boolean z) {
        isDumpData = !z;
    }

    public static void setDropData(boolean z) {
        sIsDropData = z;
    }

    public static boolean isDumpData() {
        return isDumpData;
    }

    public static boolean isDropData() {
        return sIsDropData || Global.hasCrashBefore();
    }

    private AnrManager(Context context, File file) {
        this.mIsRunning = false;
        this.lastSignalTime = 0L;
        this.mAnrSignalMonitor = new AnrSignalMonitor();
        File createDirectory = FileSystemUtils.createDirectory(file, ANR_ROOT_DIR);
        this.mAnrRootDirectory = createDirectory;
        this.mAnrInfoMonitor = new AnrInfoMonitor(context, createDirectory);
        this.mAnrProfiler = new AnrProfiler();
    }

    public static synchronized void startMonitor(final Context context, final File file) {
        synchronized (AnrManager.class) {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.anr.AnrManager.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AnrManager.sInstance == null) {
                        AnrManager unused = AnrManager.sInstance = new AnrManager(context, file);
                    }
                    AnrManager.sInstance.start();
                }
            });
        }
    }

    public static void stopMonitor() {
        AnrManager anrManager = sInstance;
        if (anrManager != null) {
            anrManager.stop();
        }
    }

    public static boolean isRunning() {
        AnrManager anrManager = sInstance;
        return anrManager != null && anrManager.mIsRunning;
    }

    public static void registerAnrInfoObserver(final String str, final IFileContentGetter iFileContentGetter) {
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.anr.AnrManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (!App.isMainProcess() || AnrManager.sInstance == null) {
                    return;
                }
                AnrManager.sInstance.mAnrInfoMonitor.registerExternalObserver(str, iFileContentGetter);
            }
        });
    }

    public static void onSigquitDetected(int i, int i2) {
        if (isRunning()) {
            handlePreANRs();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (GlobalSwitch.isOpenNewAnrMonitor()) {
                    sInstance.onSigquitDetected(currentTimeMillis, i, i2);
                } else {
                    AnrManager anrManager = sInstance;
                    if (currentTimeMillis - anrManager.lastSignalTime >= 5000) {
                        anrManager.lastSignalTime = currentTimeMillis;
                        anrManager.onAnrDetected(currentTimeMillis, true, null, i, i2);
                    }
                }
            } catch (Throwable th) {
                ANRUtils.reportInnerError(th);
            }
        }
    }

    public static void onAnrInfoDetected(long j, File file) {
        if (isRunning()) {
            try {
                sInstance.onAnrDetected(j, false, file, 0, 1000);
            } catch (Throwable th) {
                ANRUtils.reportInnerError(th);
            }
        }
    }

    private void onAnrDetected(long j, boolean z, File file, int i, int i2) {
        AnrHandler pendingHandler = getPendingHandler(j, z);
        if (pendingHandler != null) {
            pendingHandler.start(j, z, file, i, i2);
        }
    }

    private synchronized AnrHandler getPendingHandler(long j, boolean z) {
        AnrHandler anrHandler = this.mPendingHandler;
        if (anrHandler == null) {
            this.mPendingHandler = AnrHandler.get(this.mAnrInfoMonitor, this.mAnrRootDirectory, j, z);
        } else if (anrHandler.isDiscarded(z)) {
            return null;
        }
        return this.mPendingHandler;
    }

    private synchronized void resetPendingAnrHandler(AnrHandler anrHandler) {
        AnrManager anrManager = sInstance;
        if (anrManager.mPendingHandler == anrHandler) {
            anrManager.mPendingHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resetPendingAnrProcess(AnrHandler anrHandler) {
        AnrManager anrManager = sInstance;
        if (anrManager != null) {
            anrManager.resetPendingAnrHandler(anrHandler);
        }
    }

    private void uploadAll(File[] fileArr, AppMonitor appMonitor) {
        for (File file : fileArr) {
            AnrSummary loadFromDirectory = AnrSummary.loadFromDirectory(file);
            if (loadFromDirectory == null) {
                FileSystemUtils.deleteAll(file);
                ANRUtils.reportInnerError(new Exception("invalid summary : neither AnrInfo nor Stack"));
            } else {
                CrashAccessibilityMonitor.setCrashInfo(CrashType.ANR, loadFromDirectory.getProcessName(), loadFromDirectory.getPid(), loadFromDirectory.getCrashTime());
                uploadOne(loadFromDirectory, appMonitor);
            }
        }
    }

    private void uploadAll(File[] fileArr, final AppMonitor appMonitor, long j) {
        final ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            AnrSummary loadFromDirectory = AnrSummary.loadFromDirectory(file);
            if (loadFromDirectory == null) {
                FileSystemUtils.deleteAll(file);
                ANRUtils.reportInnerError(new Exception("invalid summary : neither AnrInfo nor Stack"));
            } else {
                CrashAccessibilityMonitor.setCrashInfo(CrashType.ANR, loadFromDirectory.getProcessName(), loadFromDirectory.getPid(), loadFromDirectory.getCrashTime());
                if (loadFromDirectory.getCrashTime() - loadFromDirectory.getStartTime() <= RuntimeConfig.getLaunchCrashInterval()) {
                    uploadOne(loadFromDirectory, appMonitor);
                } else {
                    arrayList.add(loadFromDirectory);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.anr.AnrManager.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AnrManager.this.uploadOne((AnrSummary) it.next(), appMonitor);
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOne(AnrSummary anrSummary, AppMonitor appMonitor) {
        anrSummary.upload(appMonitor, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void uploadAll(AppMonitor appMonitor, long j) {
        long j2;
        long j3;
        try {
            this.mAnrInfoMonitor.processUndetectedAnrInfo(this.mAnrRootDirectory);
        } catch (Exception e) {
            ANRUtils.reportInnerError(e);
        }
        for (File file : getProcessDirectories()) {
            try {
                String[] split = file.getName().split("-");
                if (split.length == 2) {
                    j2 = Long.parseLong(split[0]);
                    try {
                        j3 = Integer.parseInt(split[1]);
                    } catch (Throwable unused) {
                        j3 = 0;
                        if (j2 == Global.getAppStartTime()) {
                        }
                        File[] crashDirectories = getCrashDirectories(file);
                        if (j <= 0) {
                        }
                        if (getCrashDirectories(file).length != 0) {
                        }
                    }
                } else {
                    j2 = 0;
                    j3 = 0;
                }
            } catch (Throwable unused2) {
                j2 = 0;
            }
            if (j2 == Global.getAppStartTime() || j3 != Process.myPid()) {
                File[] crashDirectories2 = getCrashDirectories(file);
                if (j <= 0) {
                    uploadAll(crashDirectories2, appMonitor, j);
                } else {
                    uploadAll(crashDirectories2, appMonitor);
                }
                if (getCrashDirectories(file).length != 0) {
                    FileSystemUtils.deleteAll(file);
                }
            }
        }
    }

    public static void upload(AppMonitor appMonitor, long j) {
        try {
            AnrManager anrManager = sInstance;
            if (anrManager != null) {
                anrManager.uploadAll(appMonitor, j);
            }
        } catch (Exception e) {
            NpthMonitor.reportInnerException("NPTH_ANR_ERROR_upload", e);
        }
    }

    public static void handlePreANRs() {
        try {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor != null) {
                Iterator<IPreANRCallback> it = appMonitor.getUserDataCenter().getPreANRCallback().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onSignal();
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private static void notifyAnrUpload(long j, long j2, String str, JSONObject jSONObject) {
        try {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor == null) {
                return;
            }
            List<IAnrUploadCallback> anrUploadCallback = appMonitor.getUserDataCenter().getAnrUploadCallback();
            if (anrUploadCallback.isEmpty()) {
                return;
            }
            Iterator<IAnrUploadCallback> it = anrUploadCallback.iterator();
            while (it.hasNext()) {
                it.next().onCrash(j2, j, str, jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    private void onSigquitDetected(long j, int i, int i2) {
        if (!GlobalSwitch.isAnrMonitorOpt()) {
            if (j - this.lastSignalTime < 5000) {
                return;
            } else {
                this.lastSignalTime = j;
            }
        }
        if ((enableUploadBackgroundANR || i <= 200) && Math.abs(lastAnrTime - j) >= 120000 && ANRUtils.isANR()) {
            lastAnrTime = j;
            sInstance.mAnrInfoMonitor.startCheckAnrInfo(j);
            sInstance.onAnrDetected(j, true, null, i, i2);
        }
    }
}
