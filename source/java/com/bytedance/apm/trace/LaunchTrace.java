package com.bytedance.apm.trace;

import android.content.Context;
import android.util.Pair;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.launch.DefaultLaunchMode;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.LaunchDataDetector;
import com.bytedance.apm.launch.LaunchModeTrigger;
import com.bytedance.apm.launch.evil.LaunchEvilMethodManager;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.PerfMonitorManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LaunchTrace {
    private static final int LOCK_STACK_DEFAULT_THRESHOLD_MS = 30;
    private static final String TAG = "AppStartStats";
    private static boolean sCollectEvilMethod;
    private static TraceStats sTraceStats;

    @Deprecated
    public static void endTask(String str) {
    }

    @Deprecated
    public static void startAndEndTask(String str, long j, long j2) {
    }

    @Deprecated
    public static void startTask(String str) {
    }

    private LaunchTrace() {
    }

    public static void startTrace() {
        TraceStats traceStats = new TraceStats("start_trace", TraceStatsConsts.START_STATS_NAME);
        sTraceStats = traceStats;
        traceStats.startTrace();
        if (ApmContext.isMainProcessSimple()) {
            boolean isOpenLaunchEvilMethod = EvilMethodSwitcher.isOpenLaunchEvilMethod();
            sCollectEvilMethod = isOpenLaunchEvilMethod;
            if (isOpenLaunchEvilMethod) {
                LaunchEvilMethodManager.startMonitorEvilMethod();
            }
        }
    }

    public static void startSpan(String str, String str2) {
        TraceStats traceStats = sTraceStats;
        if (traceStats != null) {
            traceStats.startSpan(str, str2);
        }
    }

    public static void startSpan(String str, String str2, boolean z) {
        TraceStats traceStats = sTraceStats;
        if (traceStats != null) {
            traceStats.startSpan(str, str2, z);
        }
    }

    public static void endSpan(String str, String str2) {
        TraceStats traceStats = sTraceStats;
        if (traceStats != null) {
            traceStats.endSpan(str, str2);
        }
    }

    public static void recordSpan(String str, String str2, long j) {
        TraceStats traceStats = sTraceStats;
        if (traceStats != null) {
            traceStats.recordSpan(str, str2, j);
        }
    }

    public static void endTrace(int i, String str, long j) {
        endTrace(i, str, j, 0L);
    }

    public static void endTrace(int i, String str, long j, long j2) {
        if (sCollectEvilMethod) {
            LaunchEvilMethodManager.stopMonitorEvilMethod();
        }
        TraceStats traceStats = sTraceStats;
        if (traceStats != null) {
            traceStats.endTrace(i, str, j, j2);
        }
    }

    public static void endTrace(String str, String str2, long j) {
        endTrace(str, str2, j, 0L);
    }

    public static void endTrace(String str, String str2, long j, long j2) {
        if (sCollectEvilMethod) {
            LaunchEvilMethodManager.stopMonitorEvilMethod();
        }
        TraceStats traceStats = sTraceStats;
        if (traceStats != null) {
            traceStats.endTrace(str, str2, j, j2);
        }
    }

    public static void cancelTrace() {
        if (sCollectEvilMethod) {
            LaunchEvilMethodManager.stopMonitorEvilMethod();
        }
        TraceStats traceStats = sTraceStats;
        if (traceStats != null) {
            traceStats.cancelTrace();
            sTraceStats = null;
        }
    }

    @Deprecated
    public static void startDetect(Context context, LaunchMonitor launchMonitor) {
        if (ApmContext.isMainProcessSimple()) {
            LaunchDataDetector.startDetect(context, launchMonitor);
        }
    }

    public static Pair<DefaultLaunchMode, Long> getDefaultLaunchMode(String str) {
        return LaunchModeTrigger.getLaunchMode(str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class LaunchMonitor {
        private boolean isDetectBinder;
        private boolean isDetectLock;
        private boolean isDetectLongSleep;
        private boolean isDetectOneMinLock;

        private LaunchMonitor(LaunchMonitorBuilder launchMonitorBuilder) {
            this.isDetectLongSleep = launchMonitorBuilder.isDetectLongSleep;
            this.isDetectLock = launchMonitorBuilder.isDetectLock;
            this.isDetectBinder = launchMonitorBuilder.isDetectBinder;
            this.isDetectOneMinLock = launchMonitorBuilder.isDetectOneMinLock;
        }

        public boolean isDetectLongSleep() {
            return this.isDetectLongSleep;
        }

        public boolean isDetectLock() {
            return this.isDetectLock;
        }

        public boolean isDetectBinder() {
            return this.isDetectBinder;
        }

        public boolean isDetectOneMinLock() {
            return this.isDetectOneMinLock;
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class LaunchMonitorBuilder {
            private boolean isDetectBinder;
            private boolean isDetectLock;
            private boolean isDetectLongSleep;
            private boolean isDetectOneMinLock;

            public LaunchMonitorBuilder detectLongSleep() {
                this.isDetectLongSleep = true;
                return this;
            }

            public LaunchMonitorBuilder detectLock() {
                this.isDetectLock = true;
                return this;
            }

            public LaunchMonitorBuilder detectOneMinLock() {
                this.isDetectOneMinLock = true;
                return this;
            }

            public LaunchMonitorBuilder detectBinder() {
                this.isDetectBinder = true;
                return this;
            }

            public LaunchMonitor build() {
                return new LaunchMonitor(this);
            }
        }
    }

    public static long getTraceStartTime() {
        TraceStats traceStats = sTraceStats;
        if (traceStats == null) {
            return 0L;
        }
        return traceStats.getTraceBeginTimestamp();
    }

    @Deprecated
    public static void setLaunchCollectExtraInfoTimeMs(long j) {
        NetDataPipeline.setLaunchCollectExtraInfoTimeMs(j);
    }

    @Deprecated
    public static void setLaunchCollectExtraInfoFlag(int i) {
        boolean z = true;
        if ((i & 1) != 0 && !LaunchAnalysisContext.getInstance().getConfig().isNeedCollectNetData()) {
            z = false;
        }
        NetDataPipeline.setLaunchCollectExtraInfoFlag(z);
    }

    public static boolean startLockDetect() {
        return startLockDetect(30L);
    }

    public static synchronized boolean startLockDetect(final long j) {
        synchronized (LaunchTrace.class) {
            if (com.bytedance.apm6.foundation.context.ApmContext.getContext() == null) {
                return false;
            }
            if (!PerfMonitorManager.getInstance().hasInited()) {
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.LaunchTrace.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PerfMonitorManager.getInstance().hasInited()) {
                            LockMonitorManager.startLockDetect(j);
                        }
                    }
                });
            } else {
                LockMonitorManager.startLockDetect(j);
            }
            return true;
        }
    }

    public static synchronized boolean startLockDetect(final long j, final boolean z) {
        synchronized (LaunchTrace.class) {
            if (com.bytedance.apm6.foundation.context.ApmContext.getContext() == null) {
                return false;
            }
            if (!PerfMonitorManager.getInstance().hasInited()) {
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.LaunchTrace.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PerfMonitorManager.getInstance().hasInited()) {
                            LockMonitorManager.startLockDetect(j, z);
                        }
                    }
                });
            } else {
                LockMonitorManager.startLockDetect(j, z);
            }
            return true;
        }
    }

    public static void endLockDetect() {
        LockMonitorManager.endLockDetect(new JSONObject());
    }

    public static synchronized void endLockDetect(JSONObject jSONObject) {
        synchronized (LaunchTrace.class) {
            LockMonitorManager.endLockDetect(jSONObject);
        }
    }
}
