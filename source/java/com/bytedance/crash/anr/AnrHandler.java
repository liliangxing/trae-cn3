package com.bytedance.crash.anr;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AnrHandler {
    static final int PENDING_TIME_INTERVAL_MS = 120000;
    private static final int WAIT_ANR_INFO_TIME_OUT_MS = 35000;
    private JSONArray mAllData;
    protected final AnrInfoMonitor mAnrInfoMonitor;
    protected final long mCrashTime;
    protected final File mDumpDirectory;
    protected final AnrDumper mDumper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isDiscarded(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void start(long j, boolean z, File file, int i, int i2);

    AnrHandler(AnrInfoMonitor anrInfoMonitor, File file, long j, boolean z) {
        this.mAnrInfoMonitor = anrInfoMonitor;
        this.mCrashTime = j;
        File createAnrDirectory = createAnrDirectory(file, j);
        this.mDumpDirectory = createAnrDirectory;
        this.mDumper = AnrDumper.create(createAnrDirectory, j, z);
    }

    public static AnrHandler get(AnrInfoMonitor anrInfoMonitor, File file, long j, boolean z) {
        if (GlobalSwitch.isOpenNewAnrMonitor()) {
            return new RunningAppAnrHandler(anrInfoMonitor, file, j, z);
        }
        return new DefaultAnrHandler(anrInfoMonitor, file, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSameTask(long j, long j2) {
        return Math.abs(j - j2) <= 35000;
    }

    void handleCallbacks(File file) {
        String readUtf8File = FileSystemUtils.readUtf8File(file);
        if (TextUtils.isEmpty(readUtf8File)) {
            return;
        }
        Iterator<CrashListener> it = MonitorManager.getCrashListenerList().iterator();
        while (it.hasNext()) {
            handleMonitorCallbacks(it.next(), readUtf8File);
        }
    }

    void handleMonitorCallbacks(CrashListener crashListener, String str) {
        Iterator<ICrashCallback> it = crashListener.getUserDataCenter().getCrashCallback(CrashType.ANR).iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(CrashType.ANR, str, null);
            } catch (Throwable unused) {
            }
        }
    }

    private File createAnrDirectory(File file, long j) {
        return FileSystemUtils.createDirectory(FileSystemUtils.createDirectory(file, CrashManager.getProcessDirectoryName()), String.valueOf(j));
    }

    protected long moveAnrInfoToDumperDirectory(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        long crashTimeFromFileName = AnrInfoMonitor.getCrashTimeFromFileName(file.getName());
        file.renameTo(new File(this.mDumpDirectory, AnrInfoParser.getFileName()));
        return crashTimeFromFileName;
    }

    final void processDump(int i, int i2) {
        this.mAllData = this.mDumper.dumpAllInfo(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class RunningAppAnrHandler extends AnrHandler {
        private final AtomicInteger mInProcessCount;
        private Runnable runnable;

        @Override // com.bytedance.crash.anr.AnrHandler
        boolean isDiscarded(boolean z) {
            return false;
        }

        RunningAppAnrHandler(AnrInfoMonitor anrInfoMonitor, File file, long j, boolean z) {
            super(anrInfoMonitor, file, j, z);
            this.mInProcessCount = new AtomicInteger(2);
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        void start(long j, boolean z, File file, int i, int i2) {
            if (processEnter()) {
                if (file != null && file.exists()) {
                    moveAnrInfoToDumperDirectory(file);
                }
                processDump(i, i2);
                if (!new File(this.mDumpDirectory, AnrInfoParser.getFileName()).exists()) {
                    FileSystemUtils.writeFile(new File(this.mDumpDirectory, AnrInfoParser.getFileName()), AnrManager.SILENT_ANR_NO_ANR_INFO);
                }
                processExit();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processExit() {
            if (this.mInProcessCount.get() <= 0) {
                handleCallbacks(new File(this.mDumpDirectory, AnrInfoParser.getFileName()));
                DefaultWorkThread.removeCallbacks(this.runnable);
                this.runnable = null;
                AnrManager.resetPendingAnrProcess(this);
            }
        }

        private boolean processEnter() {
            if (this.mInProcessCount.decrementAndGet() < 0) {
                return false;
            }
            if (this.runnable != null) {
                return true;
            }
            Runnable runnable = new Runnable() { // from class: com.bytedance.crash.anr.AnrHandler.RunningAppAnrHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    RunningAppAnrHandler.this.mInProcessCount.decrementAndGet();
                    RunningAppAnrHandler.this.processExit();
                }
            };
            this.runnable = runnable;
            DefaultWorkThread.postDelayed(runnable, 120000L);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class DefaultAnrHandler extends AnrHandler {
        private long mAnrInfoTime;
        private volatile boolean mAnrInfoTimeout;
        private final AtomicInteger mInProcessCount;
        private long mSignalTime;
        private final Runnable mWaitAnrInfoTimeoutHandler;

        DefaultAnrHandler(AnrInfoMonitor anrInfoMonitor, File file, long j, boolean z) {
            super(anrInfoMonitor, file, j, z);
            this.mInProcessCount = new AtomicInteger(0);
            this.mWaitAnrInfoTimeoutHandler = new Runnable() { // from class: com.bytedance.crash.anr.AnrHandler.DefaultAnrHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultAnrHandler.this.processTimeout();
                }
            };
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        boolean isDiscarded(boolean z) {
            if (z) {
                if (this.mSignalTime != 0) {
                    return true;
                }
            } else if (this.mAnrInfoTime != 0) {
                return true;
            }
            return false;
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        void start(long j, boolean z, File file, int i, int i2) {
            if (processEnter(j, z, file)) {
                processDump(i, i2);
                if (file != null) {
                    handleCallbacks(file);
                }
                processExit();
            }
        }

        private boolean processEnter(long j, boolean z, File file) {
            if (this.mInProcessCount.incrementAndGet() <= 0) {
                return false;
            }
            if (z) {
                synchronized (this) {
                    this.mSignalTime = j;
                }
                if (this.mAnrInfoTime != 0) {
                    return true;
                }
                DefaultWorkThread.postDelayed(this.mWaitAnrInfoTimeoutHandler, 35000L);
                return true;
            }
            if (this.mSignalTime != 0) {
                DefaultWorkThread.removeCallbacks(this.mWaitAnrInfoTimeoutHandler);
            }
            synchronized (this) {
                this.mAnrInfoTime = moveAnrInfoToDumperDirectory(file);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processTimeout() {
            this.mAnrInfoTimeout = true;
            this.mInProcessCount.incrementAndGet();
            processExit();
        }

        private void processExit() {
            if (this.mInProcessCount.decrementAndGet() > 0) {
                return;
            }
            if (this.mAnrInfoTime == 0) {
                File findMatchedAnrInfoFile = this.mAnrInfoMonitor.findMatchedAnrInfoFile(Process.myPid(), this.mCrashTime);
                synchronized (this) {
                    this.mAnrInfoTime = moveAnrInfoToDumperDirectory(findMatchedAnrInfoFile);
                }
            }
            if (this.mAnrInfoTime != 0) {
                DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.anr.AnrHandler.DefaultAnrHandler.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnrManager.resetPendingAnrProcess(DefaultAnrHandler.this);
                    }
                }, 120000L);
            } else if (this.mAnrInfoTimeout) {
                AnrManager.resetPendingAnrProcess(this);
                if (this.mInProcessCount.decrementAndGet() < 0) {
                    FileSystemUtils.deleteAll(this.mDumpDirectory);
                }
            }
        }
    }
}
