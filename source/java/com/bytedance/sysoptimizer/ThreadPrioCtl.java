package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class ThreadPrioCtl {
    private static final long DELAY_MASK = -256;
    private static final int DELAY_RIGHT_MOVE_TIME = 8;
    private static final int MAX_TASK_COMM_LEN = 16;
    private static final long PRIO_MASK = 255;
    private static final int SECOND_TO_MILLISECOND = 1000;
    private static final String TAG = "ThreadPrioCtrl";
    private static volatile boolean isOptDone;
    private static char[] sComm;
    private static int sFgActivityCount;
    private static long sOptStartTime;
    private static ScheduledExecutorService sScheduledExecutorService;
    private static int sTargetThreadNum;
    private static Map<String, String> sTargetThreadPrioInfo;

    static /* synthetic */ int access$008() {
        int i = sFgActivityCount;
        sFgActivityCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$010() {
        int i = sFgActivityCount;
        sFgActivityCount = i - 1;
        return i;
    }

    private static String getThreadName(int i) {
        File file = new File("/proc/self/task/" + i + "/comm");
        if (!file.exists()) {
            return "Unknown";
        }
        try {
            FileReader fileReader = new FileReader(file);
            try {
                int read = fileReader.read(sComm);
                if (read <= 0 || read > 16) {
                    fileReader.close();
                    return "Unknown";
                }
                String str = new String(sComm, 0, read - 1);
                fileReader.close();
                return str;
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void changeThreadPrios() {
        File[] listFiles;
        if (isOptDone) {
            return;
        }
        synchronized (ThreadPrioCtl.class) {
            if (!isOptDone) {
                isOptDone = true;
                File file = new File("/proc/self/task");
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    int i = 0;
                    for (File file2 : listFiles) {
                        if (i >= sTargetThreadNum) {
                            Log.i(TAG, "return because we have found enough threads!");
                            return;
                        }
                        final int parseInt = Integer.parseInt(file2.getName());
                        String threadName = getThreadName(parseInt);
                        if (sTargetThreadPrioInfo.keySet().contains(threadName)) {
                            i++;
                            Log.d(TAG, "thread " + parseInt + " origin priority " + Process.getThreadPriority(parseInt));
                            long parseLong = Long.parseLong(sTargetThreadPrioInfo.get(threadName));
                            final int i2 = ((int) (255 & parseLong)) - 20;
                            int i3 = (int) ((parseLong & DELAY_MASK) >> 8);
                            long currentTimeMillis = System.currentTimeMillis();
                            long j = sOptStartTime;
                            long j2 = i3 * 1000;
                            int currentTimeMillis2 = currentTimeMillis - j <= j2 ? (int) (((j + j2) - System.currentTimeMillis()) / 1000) : 0;
                            Log.d(TAG, currentTimeMillis2 + " seconds later, assign priority " + i2 + " to thread " + parseInt);
                            if (currentTimeMillis2 == 0) {
                                try {
                                    Process.setThreadPriority(parseInt, i2);
                                } catch (Exception e) {
                                    Log.e(TAG, "exception in setThreadPriority", e);
                                }
                                Log.d(TAG, "assign priority " + i2 + " to thread " + parseInt + " result " + Process.getThreadPriority(parseInt) + " now");
                            } else {
                                sScheduledExecutorService.schedule(new Runnable() { // from class: com.bytedance.sysoptimizer.ThreadPrioCtl.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            Process.setThreadPriority(parseInt, i2);
                                        } catch (Exception e2) {
                                            Log.e(ThreadPrioCtl.TAG, "exception in setThreadPriority", e2);
                                        }
                                        Log.d(ThreadPrioCtl.TAG, "assign priority " + i2 + " to thread " + parseInt + " result " + Process.getThreadPriority(parseInt));
                                    }
                                }, currentTimeMillis2, TimeUnit.SECONDS);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void startOpt(Context context, ScheduledExecutorService scheduledExecutorService, Map<String, String> map, int i) {
        sScheduledExecutorService = scheduledExecutorService;
        sTargetThreadPrioInfo = map;
        sOptStartTime = System.currentTimeMillis();
        sTargetThreadNum = i;
        sComm = new char[16];
        try {
            changeThreadPrios();
        } catch (Exception e) {
            Log.e(TAG, "exception in changeThreadPrios", e);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sysoptimizer.ThreadPrioCtl.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ThreadPrioCtl.access$008();
                if (ThreadPrioCtl.sFgActivityCount == 1) {
                    try {
                        ThreadPrioCtl.sScheduledExecutorService.schedule(new Runnable() { // from class: com.bytedance.sysoptimizer.ThreadPrioCtl.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    ThreadPrioCtl.changeThreadPrios();
                                } catch (Exception e2) {
                                    Log.e(ThreadPrioCtl.TAG, "exception in changeThreadPrios", e2);
                                }
                            }
                        }, 0L, TimeUnit.SECONDS);
                    } catch (Exception e2) {
                        Log.e(ThreadPrioCtl.TAG, "exception in call schedule", e2);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ThreadPrioCtl.access$010();
                if (ThreadPrioCtl.sFgActivityCount == 0) {
                    boolean unused = ThreadPrioCtl.isOptDone = false;
                }
            }
        });
    }
}
