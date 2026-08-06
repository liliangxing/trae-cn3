package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.IFileContentGetter;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AnrInfoMonitor {
    public static final String ANR_FROM_EXTERNAL = "from_external_flag";
    private static final String ANR_INFO_DIR = "anr_info";
    private static final String PREFIX = "ai_";
    private static final String SUFFIX_CURRENT = "_current";
    private static final String SUFFIX_OTHER = "_other";
    private static final String TAG = "AnrInfoMonitor";
    private LightAnrInfoGetThread lightGetAnrInfoThread;
    private final Context mContext;
    private final File mDirectory;
    private final InnerObserver mObserver;
    private boolean mStarted;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mObserver.startWatching();
        if (!GlobalSwitch.isOpenNewAnrMonitor()) {
            new AnrInfoWriter(this.mDirectory).start();
            return;
        }
        LightAnrInfoGetThread lightAnrInfoGetThread = new LightAnrInfoGetThread();
        this.lightGetAnrInfoThread = lightAnrInfoGetThread;
        lightAnrInfoGetThread.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (this.mStarted) {
            this.mStarted = false;
            this.mObserver.stopWatching();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnrInfoMonitor(Context context, File file) {
        this.mContext = context;
        File createDirectory = FileSystemUtils.createDirectory(file, "anr_info");
        this.mDirectory = createDirectory;
        this.mObserver = new InnerObserver(createDirectory.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class InnerObserver extends FileObserver {
        private final File mDirectory;

        public InnerObserver(String str) {
            super(str, 264);
            this.mDirectory = new File(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 0 && str.startsWith(AnrInfoMonitor.PREFIX) && AnrInfoMonitor.getPidFromFileName(str) == Process.myPid() && str.endsWith(AnrInfoMonitor.SUFFIX_OTHER)) {
                AnrManager.onAnrInfoDetected(AnrInfoMonitor.getCrashTimeFromFileName(str), new File(this.mDirectory, str));
            }
        }
    }

    void startFastBootAnrMonitor() {
        if (App.isMainProcess(this.mContext)) {
            try {
                File externalFilesDir = this.mContext.getExternalFilesDir("fastbot");
                if (externalFilesDir != null && externalFilesDir.exists()) {
                    registerExternalObserver(externalFilesDir.getAbsolutePath(), new IFileContentGetter() { // from class: com.bytedance.crash.anr.AnrInfoMonitor.1
                        @Override // com.bytedance.crash.IFileContentGetter
                        public String get(String str, String str2) {
                            if (str2.startsWith(AnrManager.ANR_ROOT_DIR)) {
                                return FileSystemUtils.readUtf8File(new File(str, str2));
                            }
                            return null;
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerExternalObserver(final String str, final IFileContentGetter iFileContentGetter) {
        new FileObserver(str, 136) { // from class: com.bytedance.crash.anr.AnrInfoMonitor.2
            @Override // android.os.FileObserver
            public void onEvent(int i, String str2) {
                String str3;
                int anrProcessPid;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    str3 = iFileContentGetter.get(str, str2);
                } catch (Throwable unused) {
                    str3 = null;
                }
                if (TextUtils.isEmpty(str3) && (anrProcessPid = new AnrInfoParser(str3).getAnrProcessPid()) == Process.myPid()) {
                    File file = new File(AnrInfoMonitor.this.mDirectory, AnrInfoMonitor.getAnrInfoFileName(System.currentTimeMillis(), anrProcessPid, false));
                    FileSystemUtils.createNewFile(new File(AnrInfoMonitor.this.mDirectory, AnrInfoMonitor.ANR_FROM_EXTERNAL));
                    try {
                        FileUtils.writeFile(file, str3, false);
                    } catch (IOException e) {
                        ANRUtils.reportInnerError(e);
                    }
                }
            }
        }.startWatching();
    }

    public void startCheckAnrInfo(long j) {
        this.lightGetAnrInfoThread.startCheckAnrInfo(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class LightAnrInfoGetThread extends Thread {
        private final LinkedBlockingQueue<Long> mQueue;

        LightAnrInfoGetThread() {
            super("FetchingAnrInfo");
            this.mQueue = new LinkedBlockingQueue<>();
        }

        public void startCheckAnrInfo(long j) {
            if (GlobalSwitch.isAnrMonitorOpt()) {
                FileSystemUtils.writeFile(new File(AnrInfoMonitor.this.mDirectory, AnrInfoMonitor.getAnrInfoFileName(j, Process.myPid(), true)), AnrManager.SILENT_ANR_NO_ANR_INFO);
            }
            this.mQueue.add(Long.valueOf(j));
        }

        private void dumpAnrInfo(long j) {
            try {
                System.out.println("get_anr_info_start_" + j);
                String newCurrentProcessANRInfo = ANRUtils.getNewCurrentProcessANRInfo(AnrInfoMonitor.this.mContext, 150);
                if (TextUtils.isEmpty(newCurrentProcessANRInfo)) {
                    System.out.println("get_anr_info_is_empty");
                    newCurrentProcessANRInfo = AnrManager.SILENT_ANR_NO_ANR_INFO;
                }
                notifyAnrInfo(j, newCurrentProcessANRInfo);
            } catch (Throwable unused) {
                notifyAnrInfo(j, AnrManager.SILENT_ANR_NO_ANR_INFO);
            }
        }

        private void notifyAnrInfo(long j, String str) {
            File file = new File(AnrInfoMonitor.this.mDirectory, AnrInfoMonitor.getAnrInfoFileName(j, Process.myPid(), true));
            FileSystemUtils.writeFile(file, str);
            AnrManager.onAnrInfoDetected(j, file);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Long take = this.mQueue.take();
                    if (take != null) {
                        dumpAnrInfo(take.longValue());
                    } else {
                        System.out.println("get_anr_info_start_time_null");
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class AnrInfoWriter extends Thread {
        private final File mLockFile;

        AnrInfoWriter(File file) {
            super("NPTH-AnrInfoPolling");
            this.mLockFile = FileSystemUtils.createFile(file, "monitor.lock");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            NpthLog.m234i(AnrInfoMonitor.TAG, "AnrInfoMonitor:prepare lock：" + App.getProcessName());
            int fLock = NativeBridge.fLock(this.mLockFile.getAbsolutePath());
            NpthLog.m234i(AnrInfoMonitor.TAG, "AnrInfoMonitor:run：" + App.getProcessName());
            threadLooper();
            if (fLock != -1) {
                try {
                    NativeBridge.unFlock(fLock);
                } catch (Throwable th) {
                    NpthLog.m232e(th);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x001b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void threadLooper() {
            ActivityManager activityManager = (ActivityManager) AnrInfoMonitor.this.mContext.getSystemService("activity");
            long anrCheckInterval = RuntimeConfig.getAnrCheckInterval();
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
            while (AnrInfoMonitor.this.mStarted) {
                SystemClock.sleep(anrCheckInterval);
                if (activityManager == null) {
                    activityManager = (ActivityManager) AnrInfoMonitor.this.mContext.getSystemService("activity");
                }
                if (activityManager != null) {
                    try {
                        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                        if (processesInErrorState != null) {
                            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 : processesInErrorState) {
                                if (processErrorStateInfo2.condition == 2 && (processErrorStateInfo == null || !AnrInfoParser.isSameProcessErrorStateInfo(processErrorStateInfo, processErrorStateInfo2))) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    File file = new File(AnrInfoMonitor.this.mDirectory, AnrInfoMonitor.getAnrInfoFileName(currentTimeMillis, processErrorStateInfo2.pid, Process.myPid() == processErrorStateInfo2.pid));
                                    FileSystemUtils.writeFile(file, AnrInfoParser.format(processErrorStateInfo2));
                                    if (file.exists()) {
                                        try {
                                            if (Process.myPid() == processErrorStateInfo2.pid) {
                                                AnrManager.onAnrInfoDetected(currentTimeMillis, file);
                                            }
                                            SystemClock.sleep(20 * anrCheckInterval);
                                            processErrorStateInfo = processErrorStateInfo2;
                                        } catch (Throwable unused) {
                                            processErrorStateInfo = processErrorStateInfo2;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                while (AnrInfoMonitor.this.mStarted) {
                }
            }
        }
    }

    static String getAnrInfoFileName(long j, int i, boolean z) {
        return PREFIX + j + "_" + i + (z ? SUFFIX_CURRENT : SUFFIX_OTHER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getCrashTimeFromFileName(String str) {
        String[] split = str.split("_");
        if (split.length == 4) {
            try {
                return Long.decode(split[1]).longValue();
            } catch (Throwable unused) {
            }
        }
        return System.currentTimeMillis();
    }

    static int getPidFromFileName(String str) {
        String[] split = str.split("_");
        if (split.length != 4) {
            return 0;
        }
        try {
            return Integer.decode(split[2]).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private File[] findUndetectedAnrInfoFiles() {
        if (this.mDirectory.exists()) {
            return this.mDirectory.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.anr.AnrInfoMonitor.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return str.startsWith(AnrInfoMonitor.PREFIX);
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File findMatchedAnrInfoFile(int i, long j) {
        File[] findUndetectedAnrInfoFiles = findUndetectedAnrInfoFiles();
        if (findUndetectedAnrInfoFiles == null) {
            return null;
        }
        for (File file : findUndetectedAnrInfoFiles) {
            if (getPidFromFileName(file.getName()) == i && AnrHandler.isSameTask(j, getCrashTimeFromFileName(file.getName()))) {
                return file;
            }
        }
        return null;
    }

    private static File findMatchedCrashDirectory(File file, long j, final long j2, StringBuffer stringBuffer) {
        long j3;
        int i;
        int i2;
        long j4;
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.anr.AnrInfoMonitor.4
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith("-" + j2);
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            stringBuffer.append("processDirs==null");
            return null;
        }
        int length = listFiles.length;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            File file2 = listFiles[i4];
            if (file2.isDirectory()) {
                String[] split = file2.getName().split("-");
                if (split.length == 2) {
                    try {
                        j3 = Long.parseLong(split[i3]);
                    } catch (Throwable unused) {
                        j3 = 0;
                    }
                    if (j3 == 0 || j3 > j) {
                        i = length;
                        stringBuffer.append("startTime:" + j3 + "_" + j);
                        i4++;
                        length = i;
                        i3 = 0;
                    } else {
                        File[] listFiles2 = file2.listFiles();
                        if (listFiles2 == null) {
                            stringBuffer.append("crashDirs is null ");
                        } else {
                            int length2 = listFiles2.length;
                            int i5 = i3;
                            while (i5 < length2) {
                                File file3 = listFiles2[i5];
                                if (!file3.isDirectory()) {
                                    stringBuffer.append("crashDirs is not directory ");
                                } else if (!AnrSummary.hasSummaryFile(file3)) {
                                    stringBuffer.append("hasSummaryFile is false ");
                                } else if (new File(file3, AnrInfoParser.getFileName()).exists()) {
                                    stringBuffer.append("anrinfo exist:");
                                } else {
                                    try {
                                        i2 = length;
                                        j4 = Long.parseLong(file3.getName());
                                    } catch (Throwable unused2) {
                                        i2 = length;
                                        j4 = 0;
                                    }
                                    if (j4 != 0 && AnrHandler.isSameTask(j4, j)) {
                                        return file3;
                                    }
                                    stringBuffer.append("last error:" + j4 + "_" + j);
                                    i5++;
                                    length = i2;
                                }
                                i2 = length;
                                i5++;
                                length = i2;
                            }
                        }
                    }
                }
            }
            i = length;
            i4++;
            length = i;
            i3 = 0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processUndetectedAnrInfo(File file) {
        int pidFromFileName;
        long crashTimeFromFileName;
        File[] findUndetectedAnrInfoFiles = findUndetectedAnrInfoFiles();
        if (findUndetectedAnrInfoFiles == null) {
            return;
        }
        for (File file2 : findUndetectedAnrInfoFiles) {
            try {
                pidFromFileName = getPidFromFileName(file2.getName());
                crashTimeFromFileName = getCrashTimeFromFileName(file2.getName());
            } catch (Throwable th) {
                NpthMonitor.reportInnerExceptionWithSpace("NPTH_ANR_ERROR", th);
            }
            if (pidFromFileName != 0 && crashTimeFromFileName != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                File findMatchedCrashDirectory = findMatchedCrashDirectory(file, crashTimeFromFileName, pidFromFileName, stringBuffer);
                if (findMatchedCrashDirectory == null) {
                    file2.delete();
                    ANRUtils.reportInnerError(new Exception("Not found matched directory pid:" + pidFromFileName + "_" + file2.getName() + "_:reason:" + ((Object) stringBuffer)));
                } else {
                    file2.renameTo(new File(findMatchedCrashDirectory, AnrInfoParser.getFileName()));
                }
            }
            file2.delete();
            ANRUtils.reportInnerError(new Exception("Invalid ANR Info File Name :{" + file2.getName() + "}"));
        }
    }
}
