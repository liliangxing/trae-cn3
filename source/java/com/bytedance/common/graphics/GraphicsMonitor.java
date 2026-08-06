package com.bytedance.common.graphics;

import android.app.Activity;
import android.util.Log;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GraphicsMonitor {
    private static final long COLLECT_WINDOWS = 100;
    private static final String MTK = "mt";
    private static final long POLL_INTERVAL = 15000;
    private static ScheduledFuture<?> gpuFuture = null;
    private static double gpuLoadDataOnce = -1.0d;
    private static ScheduledExecutorService gpuScheduleService;
    private static boolean isInit;
    private static boolean isInitGraphicsLoad;
    private static volatile boolean isPause;
    private static ActivityLifecycleService lifecycleService;
    private static long sCollectInterval;
    private static long sCollectWindow;
    private static int startTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void closeStatistical();

    private static native double getStatisticOnceData();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void openStatistical();

    private static native boolean startHook();

    static /* synthetic */ double access$500() {
        return getStatisticOnceData();
    }

    public static synchronized double getByteGpu() {
        double d;
        synchronized (GraphicsMonitor.class) {
            d = gpuLoadDataOnce;
        }
        return d;
    }

    public static synchronized boolean isStart() {
        boolean z;
        synchronized (GraphicsMonitor.class) {
            z = startTime > 0;
        }
        return z;
    }

    public static synchronized void init() {
        synchronized (GraphicsMonitor.class) {
            if (isInit) {
                return;
            }
            isInit = true;
            sCollectInterval = 15000L;
            sCollectWindow = 100L;
            ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
            lifecycleService = activityLifecycleService;
            activityLifecycleService.register(new IActivityLifecycleObserver() { // from class: com.bytedance.common.graphics.GraphicsMonitor.1
                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onActivityCreated(Activity activity) {
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onActivityPause(Activity activity) {
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onActivityResume(Activity activity) {
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onActivityStarted(Activity activity) {
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onFront(Activity activity) {
                    boolean unused = GraphicsMonitor.isPause = false;
                }

                @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                public void onBackground(Activity activity) {
                    boolean unused = GraphicsMonitor.isPause = true;
                }
            });
            if (lifecycleService.isForeground()) {
                isPause = false;
            }
        }
    }

    public static synchronized void start() {
        synchronized (GraphicsMonitor.class) {
            if (isInit) {
                if (!isInitGraphicsLoad) {
                    initGraphicsLoad();
                }
                ScheduledExecutorService scheduledExecutorService = gpuScheduleService;
                if (scheduledExecutorService == null) {
                    return;
                }
                int i = startTime + 1;
                startTime = i;
                if (i > 1) {
                    return;
                }
                Runnable runnable = new Runnable() { // from class: com.bytedance.common.graphics.GraphicsMonitor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!GraphicsMonitor.isPause) {
                                GraphicsMonitor.openStatistical();
                                Thread.sleep(GraphicsMonitor.sCollectWindow);
                                GraphicsMonitor.closeStatistical();
                                double unused = GraphicsMonitor.gpuLoadDataOnce = GraphicsMonitor.access$500();
                            } else {
                                double unused2 = GraphicsMonitor.gpuLoadDataOnce = -1.0d;
                            }
                            Log.i("atrace_gpu", "bytegpu: " + GraphicsMonitor.gpuLoadDataOnce);
                        } catch (Throwable unused3) {
                        }
                    }
                };
                long j = sCollectInterval;
                gpuFuture = scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static synchronized void stop() {
        synchronized (GraphicsMonitor.class) {
            if (isInit && isStart()) {
                int i = startTime - 1;
                startTime = i;
                if (i > 0) {
                    return;
                }
                ScheduledFuture<?> scheduledFuture = gpuFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                gpuLoadDataOnce = -1.0d;
            }
        }
    }

    private static void initGraphicsLoad() {
        isInitGraphicsLoad = true;
        try {
            PerfMonitorManager.loadLibrary(ApmBaseContext.getContext());
            startHook();
            gpuScheduleService = Executors.newScheduledThreadPool(0);
        } catch (Throwable unused) {
            isInitGraphicsLoad = false;
        }
    }
}
