package com.bytedance.sysoptimizer.anr;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.util.Log;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.bytedance.sysoptimizer.anr.utils.ActivityLeakCollect;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class AnrManager {
    private static final String TAG = "SysAnrOpt";
    private static volatile AnrManager instance = null;
    private static int sLooperWaitMs = 1000;
    private static int sProxyTimeMs = 80000;
    private Context mContext;
    private final CopyOnWriteArrayList<AnrListener> mAnrListeners = new CopyOnWriteArrayList<>();
    private boolean mEnableAnrReason = true;
    private float mCpuHighThreshold = 20.0f;
    private float mJavaMemHighThreshold = 70.0f;
    private float mIoHighThreshold = 20.0f;
    private float mMajFltHighThreshold = 100.0f;
    private int mLowMemThreshold = 1024;
    private int mTotalPssThreshold = 2048;
    private int mblockGCTimeForSecondThreshold = 200;
    private int mblockGCCountFor10SecondThreshold = 100;
    private int mFreedMBForSecondThreshold = 30;
    ResourceUsage mLastUsage = new ResourceUsage();
    GcUsage mLastGcUsage = new GcUsage();
    private long mLeve1Time = 0;

    private AnrManager() {
        try {
            SysOptimizer.loadOptimizerLibrary(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void init(Application application) {
        this.mContext = application;
        ActivityLeakCollect.registerActivity(application);
    }

    public void setProxyTimeMs(int i) {
        sProxyTimeMs = i;
    }

    public void setLooperWaitMs(int i) {
        sLooperWaitMs = i;
    }

    public static AnrManager getInstance() {
        if (instance == null) {
            synchronized (AnrMonitor.class) {
                if (instance == null) {
                    instance = new AnrManager();
                }
            }
        }
        return instance;
    }

    public void setEnableAnrReason(boolean z) {
        this.mEnableAnrReason = z;
    }

    public void setCpuHighThreshold(float f) {
        this.mCpuHighThreshold = f;
    }

    public void setJavaMemHighThreshold(float f) {
        this.mJavaMemHighThreshold = f;
    }

    public void setIoHighThreshold(float f) {
        this.mIoHighThreshold = f;
    }

    public void setMajFltHighThreshold(float f) {
        this.mMajFltHighThreshold = f;
    }

    public void setTotalPssThreshold(int i) {
        this.mTotalPssThreshold = i;
    }

    public void setBlockGCTimeForSecondThreshold(int i) {
        this.mblockGCTimeForSecondThreshold = i;
    }

    public void setBlockGCCountFor10SecondThreshold(int i) {
        this.mblockGCCountFor10SecondThreshold = i;
    }

    public void setFreedMBForSecondThreshold(int i) {
        this.mFreedMBForSecondThreshold = i;
    }

    public void registerListener(AnrListener anrListener) {
        if (this.mAnrListeners.size() == 0) {
            AnrMonitor.getInstance().anrOptStart(sProxyTimeMs, sLooperWaitMs);
        }
        if (anrListener == null || this.mAnrListeners.contains(anrListener)) {
            return;
        }
        this.mAnrListeners.add(anrListener);
    }

    public void unRegisterListener(AnrListener anrListener) {
        this.mAnrListeners.remove(anrListener);
        if (this.mAnrListeners.size() == 0) {
            AnrMonitor.getInstance().pauseThread();
        }
    }

    public void onAnrChange(boolean z, int i, int i2) {
        AnrReason anrReason = new AnrReason();
        if (i == 1) {
            this.mLeve1Time = System.currentTimeMillis();
        } else if (i > 1 && i - 1 == (System.currentTimeMillis() - this.mLeve1Time) / sLooperWaitMs) {
            anrReason.setIsContinuouslyStuck(true);
        }
        if (this.mEnableAnrReason) {
            try {
                long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                anrReason.setNewAnrLevel(i2);
                Log.d(TAG, "cpuTime:" + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 100000) + "ms");
                readCpuData(anrReason);
                readMemData(anrReason);
                readGcData(anrReason);
                if (anrReason.getReason() == 0) {
                    anrReason.setReason(6);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Iterator<AnrListener> it = this.mAnrListeners.iterator();
        while (it.hasNext()) {
            AnrListener next = it.next();
            if (next != null) {
                next.onAnrChange(z, i, anrReason);
            }
        }
    }

    private long readRunTimeStats(Map<String, String> map, String str) {
        if (map.containsKey(str)) {
            try {
                return Long.parseLong(map.get(str));
            } catch (NumberFormatException e) {
                Log.e(TAG, "Error parsing", e);
            }
        }
        return 0L;
    }

    private int readRunTimeStatsRateHistogram(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return 0;
        }
        int i = 0;
        for (String str2 : map.get(str).split(",")) {
            String[] split = str2.split(Constants.COLON_SEPARATOR);
            if (split.length == 2) {
                try {
                    i += Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Error parsing rate histogram", e);
                }
            }
        }
        return i;
    }

    private void readGcData(AnrReason anrReason) {
        GcUsage gcUsage = new GcUsage();
        Map<String, String> runtimeStats = Debug.getRuntimeStats();
        gcUsage.blockingGcCountTotal = readRunTimeStats(runtimeStats, PerfConsts.ART_GC_BLOCKING_GC_COUNT);
        gcUsage.blockingGcTimeTotal = readRunTimeStats(runtimeStats, PerfConsts.ART_GC_BLOCKING_GC_TIME);
        gcUsage.gcCountTotal = readRunTimeStats(runtimeStats, PerfConsts.ART_GC_GC_COUNT);
        gcUsage.gcTimeTotal = readRunTimeStats(runtimeStats, PerfConsts.ART_GC_GC_TIME);
        gcUsage.bytesAllocatedTotal = readRunTimeStats(runtimeStats, "art.gc.bytes-allocated");
        gcUsage.bytesFreedTotal = readRunTimeStats(runtimeStats, "art.gc.bytes-freed");
        gcUsage.blockingGcCountRateHistogram = readRunTimeStatsRateHistogram(runtimeStats, "art.gc.blocking-gc-count-rate-histogram");
        gcUsage.gcCountRateHistogram = readRunTimeStatsRateHistogram(runtimeStats, "art.gc.gc-count-rate-histogram");
        gcUsage.recordTimestamp = System.currentTimeMillis();
        anrReason.setBlockGCCountFor10Second((float) gcUsage.blockingGcCountRateHistogram);
        if (gcUsage.blockingGcCountRateHistogram > this.mblockGCCountFor10SecondThreshold) {
            anrReason.setReason(5);
        }
        float f = ((float) (gcUsage.recordTimestamp - this.mLastGcUsage.recordTimestamp)) / 1000.0f;
        float f2 = ((float) (((gcUsage.bytesFreedTotal - this.mLastGcUsage.bytesFreedTotal) / 1024) / 1024)) / f;
        if (f2 >= 0.0f && f2 <= 512.0f) {
            anrReason.setFreedMBForSecond(f2);
        }
        anrReason.setBlockGCTimeForSecond(((float) (gcUsage.blockingGcTimeTotal - this.mLastGcUsage.blockingGcTimeTotal)) / f);
        if (anrReason.getBlockGCTimeForSecond() > this.mblockGCTimeForSecondThreshold) {
            anrReason.setReason(5);
        }
        this.mLastGcUsage = gcUsage;
    }

    private void readCpuData(AnrReason anrReason) {
        anrReason.setCpuUsage(0.0f);
        if (0.0f > this.mCpuHighThreshold) {
            anrReason.setReason(3);
        }
    }

    private float getMemoryUseRate(AnrReason anrReason) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long freeMemory = runtime.totalMemory() - runtime.freeMemory();
        anrReason.setUsageJavaHeapKb((int) (freeMemory / 1024));
        return (((float) freeMemory) * 100.0f) / ((float) maxMemory);
    }

    private void readMemData(AnrReason anrReason) {
        float memoryUseRate = getMemoryUseRate(anrReason);
        anrReason.setJavaMemUsage(memoryUseRate);
        if (memoryUseRate > this.mJavaMemHighThreshold) {
            anrReason.setReason(1);
        }
        ResourceUsage resourceUsage = new ResourceUsage();
        resourceUsage.maxPss = getPssMemory(this.mContext);
        resourceUsage.recordTimestamp = System.currentTimeMillis();
        int i = (int) (resourceUsage.maxPss / 1024);
        anrReason.setTotalPss(i);
        if (i > this.mTotalPssThreshold) {
            anrReason.setReason(2);
        }
        getAvailablePhysicalMemory(this.mContext, anrReason);
        if (anrReason.getAvailMemMB() <= this.mLowMemThreshold) {
            anrReason.setReason(8);
        }
        int i2 = (int) (((float) (resourceUsage.majFlt - this.mLastUsage.majFlt)) / (((float) (resourceUsage.recordTimestamp - resourceUsage.recordTimestamp)) / 1000.0f));
        anrReason.setAverageMajFltForSecond(i2);
        if (i2 > this.mMajFltHighThreshold) {
            anrReason.setReason(7);
        }
        if (("D".equals(resourceUsage.threadState) && ((resourceUsage.utm + resourceUsage.stm) - this.mLastUsage.utm) - this.mLastUsage.stm < 50) || ("D".equals(resourceUsage.threadState) && "D".equals(this.mLastUsage.threadState))) {
            anrReason.setReason(9);
        }
        anrReason.setActivityLeakMap(ActivityLeakCollect.getLeaksGreaterThanOne());
        this.mLastUsage = resourceUsage;
    }

    public static long getPssMemory(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
            return processMemoryInfo[0].dalvikPss + processMemoryInfo[0].nativePss + processMemoryInfo[0].otherPss + processMemoryInfo[0].getTotalSwappablePss();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void getAvailablePhysicalMemory(Context context, AnrReason anrReason) {
        if (context == null) {
            return;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        anrReason.setAvailMemMB((int) ((memoryInfo.availMem / 1024) / 1024));
        anrReason.setTotalMemMB((int) ((memoryInfo.totalMem / 1024) / 1024));
    }

    /* loaded from: classes5.dex */
    public class AnrReason {
        public static final int REASON_CPU_HIGHT = 3;
        public static final int REASON_GC_HIGHT = 5;
        public static final int REASON_IO_HIGHT = 4;
        public static final int REASON_JAVA_HEAP_HIGHT = 1;
        public static final int REASON_LOW_MEMORY = 8;
        public static final int REASON_MAIN_THREAD_D = 9;
        public static final int REASON_MAIN_THREAD_SLOW = 6;
        public static final int REASON_MAJFLT_HIGHT = 7;
        public static final int REASON_PSS_HIGHT = 2;
        public static final int REASON_UNKONW = 0;
        private float mJavaMemUsage = 0.0f;
        private int mTotalPss = 0;
        private float mCpuUsage = 0.0f;
        private int mAverageMajFltForSecond = 0;
        private int mUsageJavaHeapKb = 0;
        private float mBlockGCCountFor10Second = 0.0f;
        private float mBlockGCTimeForSecond = 0.0f;
        private float mFreedMBForSecond = 0.0f;
        private int mAvailMemMB = 0;
        private int mTotalMemMB = 0;
        private boolean mIsContinuouslyStuck = false;
        private int mNewAnrLevel = 0;
        private int mReason = 0;
        private Map<String, Integer> mActivityLeakMap = new HashMap();

        public String getReasonDescription(int i) {
            switch (i) {
                case 1:
                    return "REASON_JAVA_HEAP_HIGHT";
                case 2:
                    return "REASON_PSS_HIGHT";
                case 3:
                    return "REASON_CPU_HIGHT";
                case 4:
                    return "REASON_IO_HIGHT";
                case 5:
                    return "REASON_GC_HIGHT";
                case 6:
                    return "REASON_MAIN_THREAD_SLOW";
                case 7:
                    return "REASON_MAJFLT_HIGHT";
                case 8:
                    return "REASON_LOW_MEMORY";
                case 9:
                    return "REASON_MAIN_THREAD_D";
                default:
                    return "REASON_UNKONW";
            }
        }

        public AnrReason() {
        }

        public void setCpuUsage(float f) {
            this.mCpuUsage = f;
        }

        public void setJavaMemUsage(float f) {
            this.mJavaMemUsage = f;
        }

        public void setTotalPss(int i) {
            this.mTotalPss = i;
        }

        public float getCpuUsage() {
            return this.mCpuUsage;
        }

        public float getJavaMemUsage() {
            return this.mJavaMemUsage;
        }

        public int getTotalPss() {
            return this.mTotalPss;
        }

        public void setAverageMajFltForSecond(int i) {
            this.mAverageMajFltForSecond = i;
        }

        public int getAverageMajFltForSecond() {
            return this.mAverageMajFltForSecond;
        }

        public void setActivityLeakMap(Map<String, Integer> map) {
            this.mActivityLeakMap = map;
        }

        public void setAvailMemMB(int i) {
            this.mAvailMemMB = i;
        }

        public int getAvailMemMB() {
            return this.mAvailMemMB;
        }

        public void setNewAnrLevel(int i) {
            this.mNewAnrLevel = i;
        }

        public int getNewAnrLevel() {
            return this.mNewAnrLevel;
        }

        public void setIsContinuouslyStuck(boolean z) {
            this.mIsContinuouslyStuck = z;
        }

        public boolean isContinuouslyStuck() {
            return this.mIsContinuouslyStuck;
        }

        public void setTotalMemMB(int i) {
            this.mTotalMemMB = i;
        }

        public int getTotalMemMB() {
            return this.mTotalMemMB;
        }

        public Map<String, Integer> getActivityLeakMap() {
            return this.mActivityLeakMap;
        }

        public void setUsageJavaHeapKb(int i) {
            this.mUsageJavaHeapKb = i;
        }

        public int getUsageJavaHeapKb() {
            return this.mUsageJavaHeapKb;
        }

        public void setBlockGCCountFor10Second(float f) {
            this.mBlockGCCountFor10Second = f;
        }

        public float getBlockGCCountFor10Second() {
            return this.mBlockGCCountFor10Second;
        }

        public void setBlockGCTimeForSecond(float f) {
            this.mBlockGCTimeForSecond = f;
        }

        public float getBlockGCTimeForSecond() {
            return this.mBlockGCTimeForSecond;
        }

        public void setFreedMBForSecond(float f) {
            this.mFreedMBForSecond = f;
        }

        public float getFreedMBForSecond() {
            return this.mFreedMBForSecond;
        }

        public int getReason() {
            return this.mReason;
        }

        public void setReason(int i) {
            this.mReason = i;
        }

        public String toString() {
            return "AnrReason{javaMemUsage=" + this.mJavaMemUsage + "%, mUsageJavaHeapKb=" + this.mUsageJavaHeapKb + "KB, averageMajFltForSecond=" + this.mAverageMajFltForSecond + ", availMem=" + this.mAvailMemMB + "MB, totalMem=" + this.mTotalMemMB + "MB, totalPss=" + this.mTotalPss + "MB, cpuUsage=" + this.mCpuUsage + "%, blockGCCountFor10Second=" + this.mBlockGCCountFor10Second + ", blockGCTimeForSecond=" + this.mBlockGCTimeForSecond + ", bytesFreedMBForSecond=" + this.mFreedMBForSecond + "MB, mReason=" + getReasonDescription(this.mReason) + "}";
        }
    }
}
