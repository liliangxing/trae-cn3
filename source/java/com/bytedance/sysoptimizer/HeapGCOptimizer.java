package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class HeapGCOptimizer {
    private static final long GB = 1073741824;
    private static final long KB = 1024;
    private static final long MB = 1048576;
    private static final String TAG = "HeapGCOptimizer";
    private static long currentRegionSpaces = 0;
    private static boolean sGlobalSwitchOff = false;
    private static boolean sInited = false;
    private static int sMaxAPISupport = 33;
    private static boolean sShrinkInited;
    private static Timer sVssCheckTimer;
    private static final String numRegEx = "[^0-9]";
    private static final Pattern numPattern = Pattern.compile(numRegEx);
    private static VssConfig sVssConfig = new VssConfig();

    /* loaded from: classes5.dex */
    public static class VssConfig {
        public int firstDelay = 30;
        public int periodOfCheck = 30;
        public float periodOfShrink = 0.65f;
        public float periodOfLessMemoryUsage = 0.45f;
        public int shrinkStep = 125;
        public int lowerLimit = 384;
    }

    private static native long getCurrentRegionSpaceSize();

    private static native boolean heap_expand(int i, boolean z);

    private static native boolean init(int i);

    private static native boolean init_4shrink_region_space(int i);

    private static native boolean init_shrink_region_space_step_size(long j);

    private static native boolean optimize(int i, float f, float f2, float f3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean shrink_regionspace_vss(long j);

    static /* synthetic */ long access$400() {
        return readVssSize();
    }

    public static synchronized void heapOptimizeSwitchOff(boolean z) {
        synchronized (HeapGCOptimizer.class) {
            sGlobalSwitchOff = z;
        }
    }

    public static synchronized void setHeapOptMaxAPISupport(int i) {
        synchronized (HeapGCOptimizer.class) {
            sMaxAPISupport = i;
        }
    }

    public static boolean shouldSkipHeapOptimize() {
        return Build.VERSION.SDK_INT > sMaxAPISupport || sGlobalSwitchOff;
    }

    public static synchronized void optimize(Context context, float f, float f2, float f3) {
        synchronized (HeapGCOptimizer.class) {
            if (shouldSkipHeapOptimize()) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    int i = Build.VERSION.SDK_INT;
                    if (!sInited && init(i)) {
                        sInited = true;
                    }
                    if (sInited) {
                        if (optimize(i, f, f2, f3)) {
                            Log.d(TAG, "opt for heap gc");
                        } else {
                            Log.d(TAG, "opt failed");
                        }
                    }
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static synchronized void heapExpand(Context context, int i, boolean z) {
        synchronized (HeapGCOptimizer.class) {
            if (shouldSkipHeapOptimize()) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    int i2 = Build.VERSION.SDK_INT;
                    if (!sInited && init(i2)) {
                        sInited = true;
                    }
                    if (sInited) {
                        if (heap_expand(i, z)) {
                            Log.d(TAG, "opt for heap expand");
                        } else {
                            Log.d(TAG, "opt failed");
                        }
                    }
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static synchronized void initOptimizeRegionSpaceVSS(Context context, int i) {
        synchronized (HeapGCOptimizer.class) {
            if (Build.VERSION.SDK_INT >= 26 && !sGlobalSwitchOff) {
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    try {
                        try {
                            int i2 = Build.VERSION.SDK_INT;
                            if (!sShrinkInited && init_4shrink_region_space(i2)) {
                                sShrinkInited = true;
                            }
                            if (sShrinkInited) {
                                init_shrink_region_space_step_size(i);
                            }
                        } catch (UnsatisfiedLinkError e) {
                            Log.e(TAG, "UnsatisfiedLinkError", e);
                        }
                    } catch (NoSuchMethodError e2) {
                        Log.e(TAG, "NoSuchMethodError", e2);
                    }
                }
            }
        }
    }

    public static synchronized void optimizeRegionSpaceVSS(Context context, VssConfig vssConfig) {
        synchronized (HeapGCOptimizer.class) {
            if (Build.VERSION.SDK_INT >= 26 && !sGlobalSwitchOff) {
                if (Process.is64Bit()) {
                    return;
                }
                sVssConfig = vssConfig;
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    try {
                        try {
                            int i = Build.VERSION.SDK_INT;
                            if (!sShrinkInited && init_4shrink_region_space(i)) {
                                sShrinkInited = true;
                            }
                            if (sShrinkInited) {
                                if (sVssConfig.periodOfCheck == -1) {
                                    if (!shrink_regionspace_vss(sVssConfig.shrinkStep * 1048576)) {
                                        Log.e(TAG, "vss resize just once failed, stop watching.");
                                    }
                                } else {
                                    currentRegionSpaces = getCurrentRegionSpaceSize() / 1048576;
                                    Log.d(TAG, "current Region Space:" + currentRegionSpaces + " mb");
                                    startVssCheckTimer(vssConfig.firstDelay, sVssConfig.periodOfCheck);
                                }
                            }
                        } catch (UnsatisfiedLinkError e) {
                            Log.e(TAG, "UnsatisfiedLinkError", e);
                        }
                    } catch (NoSuchMethodError e2) {
                        Log.e(TAG, "NoSuchMethodError", e2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startVssCheckTimer(int i, int i2) {
        if (sVssCheckTimer != null) {
            stopVssCheckTimer();
        }
        if (i2 <= 0) {
            Log.e(TAG, "Non-positive period:" + i2);
            return;
        }
        sVssCheckTimer = new Timer();
        Log.i(TAG, "start a timer to check vss,firstDelay is:" + i + "s,period is:" + i2 + "s");
        if (i > 0 && i > i2) {
            sVssCheckTimer.schedule(new VssCheckAndShrinkTask(), i * 1000, i2 * 1000);
        } else {
            long j = i2 * 1000;
            sVssCheckTimer.schedule(new VssCheckAndShrinkTask(), j, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stopVssCheckTimer() {
        Timer timer = sVssCheckTimer;
        if (timer != null) {
            timer.cancel();
            sVssCheckTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class VssCheckAndShrinkTask extends TimerTask {
        private VssCheckAndShrinkTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Log.e(HeapGCOptimizer.TAG, "VssCheckAndShrinkTask run");
            if (HeapGCOptimizer.currentRegionSpaces - HeapGCOptimizer.sVssConfig.shrinkStep < HeapGCOptimizer.sVssConfig.lowerLimit) {
                Log.e(HeapGCOptimizer.TAG, "vss has no space to resize, stop watching. current region space = " + HeapGCOptimizer.currentRegionSpaces + " mb");
                HeapGCOptimizer.stopVssCheckTimer();
                return;
            }
            long access$400 = HeapGCOptimizer.access$400();
            if (access$400 < 0) {
                Log.e(HeapGCOptimizer.TAG, "failed to read Vss");
                HeapGCOptimizer.stopVssCheckTimer();
                return;
            }
            float f = ((float) access$400) / 4.2949673E9f;
            long j = access$400 / 1048576;
            Log.i(HeapGCOptimizer.TAG, "vss check and shrink task is running , current vss size:" + j + " mb,currentPeriod:" + f);
            double d = f;
            if (d >= 1.0d || f <= HeapGCOptimizer.sVssConfig.periodOfShrink) {
                if (d >= 1.0d || f >= HeapGCOptimizer.sVssConfig.periodOfLessMemoryUsage) {
                    return;
                }
                HeapGCOptimizer.startVssCheckTimer(-1, HeapGCOptimizer.sVssConfig.periodOfCheck * 2);
                return;
            }
            Log.i(HeapGCOptimizer.TAG, "vss has over the period, current vss = " + j + "mb, period = " + f);
            if (HeapGCOptimizer.shrink_regionspace_vss(HeapGCOptimizer.sVssConfig.shrinkStep * 1048576)) {
                HeapGCOptimizer.currentRegionSpaces -= HeapGCOptimizer.sVssConfig.shrinkStep;
                Log.i(HeapGCOptimizer.TAG, "resize success, step = " + HeapGCOptimizer.sVssConfig.shrinkStep + "mb, current vss = " + j + "mb, current region space =" + HeapGCOptimizer.currentRegionSpaces + " mb");
                HeapGCOptimizer.startVssCheckTimer(-1, HeapGCOptimizer.sVssConfig.periodOfCheck / 2);
            } else {
                Log.e(HeapGCOptimizer.TAG, "vss resize failed, stop watching.");
                HeapGCOptimizer.stopVssCheckTimer();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
    
        r1 = java.lang.Integer.parseInt(com.bytedance.sysoptimizer.HeapGCOptimizer.numPattern.matcher(r3).replaceAll("").trim()) * 1024;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long readVssSize() {
        BufferedReader bufferedReader;
        long j = -1;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream("/proc/" + Process.myPid() + "/status");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.toLowerCase().contains("vmsize")) {
                                break;
                            }
                        } catch (Throwable unused) {
                            fileInputStream = fileInputStream2;
                            try {
                                Log.e(TAG, "read current status failed.");
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return j;
                            } catch (Throwable th) {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        }
                    }
                    fileInputStream2.close();
                    bufferedReader.close();
                } catch (Throwable unused2) {
                    bufferedReader = null;
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return j;
    }
}
