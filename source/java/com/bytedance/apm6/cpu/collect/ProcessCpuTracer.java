package com.bytedance.apm6.cpu.collect;

import android.os.Process;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ProcessCpuTracer {
    private static final boolean DEBUG = false;
    static final int PROCESS_FULL_STAT_MAJOR_FAULTS = 2;
    static final int PROCESS_FULL_STAT_MINOR_FAULTS = 1;
    static final int PROCESS_FULL_STAT_STIME = 4;
    static final int PROCESS_FULL_STAT_UTIME = 3;
    static final int PROCESS_FULL_STAT_VSIZE = 5;
    static final int PROCESS_STAT_MAJOR_FAULTS = 1;
    static final int PROCESS_STAT_MINOR_FAULTS = 0;
    static final int PROCESS_STAT_STIME = 3;
    static final int PROCESS_STAT_UTIME = 2;
    public static final int PROC_CHAR = 2048;
    public static final int PROC_COMBINE = 256;
    public static final int PROC_NEWLINE_TERM = 10;
    public static final int PROC_OUT_FLOAT = 16384;
    public static final int PROC_OUT_LONG = 8192;
    public static final int PROC_OUT_STRING = 4096;
    public static final int PROC_PARENS = 512;
    public static final int PROC_QUOTES = 1024;
    public static final int PROC_SPACE_TERM = 32;
    public static final int PROC_TAB_TERM = 9;
    public static final int PROC_TERM_MASK = 255;
    public static final int PROC_ZERO_TERM = 0;
    private static final String TAG = "ProcessCpuTracker";
    private static final boolean localLOGV = false;
    private int mCpuNumber;
    private Stats mSt;
    private static final int[] PROCESS_STATS_FORMAT = {32, 544, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224};
    private static final int[] PROCESS_FULL_STATS_FORMAT = {32, 4640, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224, 32, 32, 32, 32, 32, 32, 32, 8224};
    private final long[] mProcessStatsData = new long[4];
    private final long[] mSinglePidStatsData = new long[4];
    private final String[] mProcessFullStatsStringData = new String[6];
    private final long[] mProcessFullStatsData = new long[6];
    private boolean mFirst = true;
    private final long mJiffyMillis = 1000 / Os.sysconf(OsConstants._SC_CLK_TCK);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Stats {
        public boolean active;
        public boolean added;
        public String baseName;
        public long base_majfaults;
        public long base_minfaults;
        public long base_stime;
        public long base_uptime;
        public long base_utime;
        public boolean interesting;
        public String name;
        public final int pid;
        public int rel_majfaults;
        public int rel_minfaults;
        public int rel_stime;
        public long rel_uptime;
        public int rel_utime;
        public boolean removed;
        final String statFile;
        public final int uid;
        public long vsize;
        public boolean working;

        Stats(int i) {
            this.pid = i;
            File file = new File("/proc", Integer.toString(i));
            this.uid = getUid(file.toString());
            this.statFile = new File(file, "stat").toString();
        }

        private static int getUid(String str) {
            try {
                return Os.stat(str).st_uid;
            } catch (ErrnoException e) {
                Log.w(ProcessCpuTracer.TAG, "Failed to stat(" + str + "): " + e);
                return -1;
            }
        }
    }

    public void init() {
        this.mFirst = true;
        this.mCpuNumber = Runtime.getRuntime().availableProcessors();
        update();
    }

    public void update() {
        if (PerfMonitorManager.isSoLoaded()) {
            try {
                collectStats(this.mFirst);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mFirst = false;
        }
    }

    private void collectStats(boolean z) {
        int myPid = Process.myPid();
        Stats stats = this.mSt;
        if (stats != null && stats.pid == myPid) {
            this.mSt.added = false;
            this.mSt.working = false;
            if (this.mSt.interesting) {
                long uptimeMillis = SystemClock.uptimeMillis();
                long[] jArr = this.mProcessStatsData;
                if (PerfMonitorManager.getInstance().readProcFile(this.mSt.statFile.toString(), PROCESS_STATS_FORMAT, (Object[]) null, jArr, (float[]) null)) {
                    long j = jArr[0];
                    long j2 = jArr[1];
                    long j3 = jArr[2];
                    long j4 = this.mJiffyMillis;
                    long j5 = j3 * j4;
                    long j6 = jArr[3] * j4;
                    if (j5 == this.mSt.base_utime && j6 == this.mSt.base_stime) {
                        this.mSt.rel_utime = 0;
                        this.mSt.rel_stime = 0;
                        this.mSt.rel_minfaults = 0;
                        this.mSt.rel_majfaults = 0;
                        if (this.mSt.active) {
                            this.mSt.active = false;
                            return;
                        }
                        return;
                    }
                    if (!this.mSt.active) {
                        this.mSt.active = true;
                    }
                    Stats stats2 = this.mSt;
                    stats2.rel_uptime = uptimeMillis - stats2.base_uptime;
                    this.mSt.base_uptime = uptimeMillis;
                    Stats stats3 = this.mSt;
                    stats3.rel_utime = (int) (j5 - stats3.base_utime);
                    Stats stats4 = this.mSt;
                    stats4.rel_stime = (int) (j6 - stats4.base_stime);
                    this.mSt.base_utime = j5;
                    this.mSt.base_stime = j6;
                    Stats stats5 = this.mSt;
                    stats5.rel_minfaults = (int) (j - stats5.base_minfaults);
                    Stats stats6 = this.mSt;
                    stats6.rel_majfaults = (int) (j2 - stats6.base_majfaults);
                    this.mSt.base_minfaults = j;
                    this.mSt.base_majfaults = j2;
                    this.mSt.working = true;
                    return;
                }
                return;
            }
            return;
        }
        Stats stats7 = this.mSt;
        if (stats7 == null || stats7.pid > myPid) {
            Stats stats8 = new Stats(myPid);
            this.mSt = stats8;
            String[] strArr = this.mProcessFullStatsStringData;
            long[] jArr2 = this.mProcessFullStatsData;
            stats8.base_uptime = SystemClock.uptimeMillis();
            if (PerfMonitorManager.getInstance().readProcFile(this.mSt.statFile.toString(), PROCESS_FULL_STATS_FORMAT, strArr, jArr2, (float[]) null)) {
                this.mSt.vsize = jArr2[5];
                this.mSt.interesting = true;
                this.mSt.baseName = strArr[0];
                this.mSt.base_minfaults = jArr2[1];
                this.mSt.base_majfaults = jArr2[2];
                this.mSt.base_utime = jArr2[3] * this.mJiffyMillis;
                this.mSt.base_stime = jArr2[4] * this.mJiffyMillis;
            } else {
                Log.w(TAG, "Skipping unknown process pid " + myPid);
                this.mSt.baseName = "<unknown>";
                Stats stats9 = this.mSt;
                stats9.base_stime = 0L;
                stats9.base_utime = 0L;
                Stats stats10 = this.mSt;
                stats10.base_majfaults = 0L;
                stats10.base_minfaults = 0L;
            }
            this.mSt.rel_utime = 0;
            this.mSt.rel_stime = 0;
            this.mSt.rel_minfaults = 0;
            this.mSt.rel_majfaults = 0;
            this.mSt.added = true;
            if (z || !this.mSt.interesting) {
                return;
            }
            this.mSt.working = true;
            return;
        }
        this.mSt.rel_utime = 0;
        this.mSt.rel_stime = 0;
        this.mSt.rel_minfaults = 0;
        this.mSt.rel_majfaults = 0;
        this.mSt.removed = true;
        this.mSt.working = true;
        this.mSt.rel_utime = 0;
        this.mSt.rel_stime = 0;
        this.mSt.rel_minfaults = 0;
        this.mSt.rel_majfaults = 0;
        this.mSt.removed = true;
        this.mSt.working = true;
    }

    public String printCurrentState() {
        StringBuffer stringBuffer = new StringBuffer();
        printProcessCPU(stringBuffer, this.mSt.added ? " +" : this.mSt.removed ? " -" : "  ", this.mSt.pid, this.mSt.baseName, (int) this.mSt.rel_uptime, this.mSt.rel_utime, this.mSt.rel_stime, 0, 0, 0, this.mSt.rel_minfaults, this.mSt.rel_majfaults);
        return stringBuffer.toString();
    }

    public float getProcessCpuPercentAllCore() {
        Stats stats = this.mSt;
        if (stats == null) {
            return 0.0f;
        }
        long j = stats.rel_utime + this.mSt.rel_stime;
        if (((int) this.mSt.rel_uptime) <= 0) {
            return 0.0f;
        }
        return (float) (((j * 1000) / r4) / 10.0d);
    }

    public float getProcessCpuPercent() {
        if (this.mCpuNumber <= 0) {
            return 0.0f;
        }
        return getProcessCpuPercentAllCore() / this.mCpuNumber;
    }

    public int getMinfaults() {
        Stats stats = this.mSt;
        if (stats == null) {
            return -1;
        }
        return stats.rel_minfaults;
    }

    public int getMajfaults() {
        Stats stats = this.mSt;
        if (stats == null) {
            return -1;
        }
        return stats.rel_majfaults;
    }

    public int getProcessStatUtime() {
        Stats stats = this.mSt;
        if (stats == null) {
            return -1;
        }
        return stats.rel_utime;
    }

    public int getProcessStatStime() {
        Stats stats = this.mSt;
        if (stats == null) {
            return -1;
        }
        return stats.rel_stime;
    }

    private void printRatio(StringBuffer stringBuffer, long j, long j2) {
        long j3 = (j * 1000) / j2;
        long j4 = j3 / 10;
        stringBuffer.append(j4);
        if (j4 < 10) {
            long j5 = j3 - (j4 * 10);
            if (j5 != 0) {
                stringBuffer.append('.');
                stringBuffer.append(j5);
            }
        }
    }

    private void printProcessCPU(StringBuffer stringBuffer, String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        stringBuffer.append(str);
        long j = i2 == 0 ? 1 : i2;
        printRatio(stringBuffer, i3 + i4 + i5 + i6 + i7, j);
        stringBuffer.append("% ");
        if (i >= 0) {
            stringBuffer.append(i);
            stringBuffer.append("/");
        }
        stringBuffer.append(str2);
        stringBuffer.append(": ");
        printRatio(stringBuffer, i3, j);
        stringBuffer.append("% user + ");
        printRatio(stringBuffer, i4, j);
        stringBuffer.append("% kernel");
        if (i5 > 0) {
            stringBuffer.append(" + ");
            printRatio(stringBuffer, i5, j);
            stringBuffer.append("% iowait");
        }
        if (i6 > 0) {
            stringBuffer.append(" + ");
            printRatio(stringBuffer, i6, j);
            stringBuffer.append("% irq");
        }
        if (i7 > 0) {
            stringBuffer.append(" + ");
            printRatio(stringBuffer, i7, j);
            stringBuffer.append("% softirq");
        }
        if (i8 > 0 || i9 > 0) {
            stringBuffer.append(" / faults:");
            if (i8 > 0) {
                stringBuffer.append(" ");
                stringBuffer.append(i8);
                stringBuffer.append(" minor");
            }
            if (i9 > 0) {
                stringBuffer.append(" ");
                stringBuffer.append(i9);
                stringBuffer.append(" major");
            }
        }
    }
}
