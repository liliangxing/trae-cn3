package com.ttnet.org.chromium.base.jank_tracker;

import android.os.Handler;
import android.os.HandlerThread;
import com.ttnet.org.chromium.base.TraceEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class JankReportingScheduler {
    private static final long PERIODIC_METRIC_DELAY_MS = 30000;
    private static final long TRACE_EVENT_TRACK_ID = 84186319646187624L;
    private final FrameMetricsStore mFrameMetricsStore;
    private Handler mHandler;
    protected HandlerThread mHandlerThread;
    private final Runnable mPeriodicMetricReporter = new Runnable() { // from class: com.ttnet.org.chromium.base.jank_tracker.JankReportingScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JankReportingScheduler.this.finishTrackingScenario(1);
            if (JankReportingScheduler.this.mIsPeriodicReporterLooping.get()) {
                JankReportingScheduler.this.startTrackingScenario(1);
                JankReportingScheduler.this.getOrCreateHandler().postDelayed(JankReportingScheduler.this.mPeriodicMetricReporter, JankReportingScheduler.PERIODIC_METRIC_DELAY_MS);
            }
        }
    };
    private final AtomicBoolean mIsPeriodicReporterLooping = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public JankReportingScheduler(FrameMetricsStore frameMetricsStore) {
        this.mFrameMetricsStore = frameMetricsStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startTrackingScenario(int i) {
        TraceEvent.startAsync("JankCUJ:" + JankMetricUMARecorder.scenarioToString(i), i + TRACE_EVENT_TRACK_ID);
        getOrCreateHandler().post(new JankReportingRunnable(this.mFrameMetricsStore, i, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finishTrackingScenario(int i) {
        TraceEvent.finishAsync("JankCUJ:" + JankMetricUMARecorder.scenarioToString(i), i + TRACE_EVENT_TRACK_ID);
        getOrCreateHandler().post(new JankReportingRunnable(this.mFrameMetricsStore, i, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Handler getOrCreateHandler() {
        if (this.mHandler == null) {
            HandlerThread handlerThread = new HandlerThread("Jank-Tracker");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }
        return this.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startReportingPeriodicMetrics() {
        if (this.mIsPeriodicReporterLooping.getAndSet(true)) {
            return;
        }
        startTrackingScenario(1);
        getOrCreateHandler().postDelayed(this.mPeriodicMetricReporter, PERIODIC_METRIC_DELAY_MS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopReportingPeriodicMetrics() {
        if (this.mIsPeriodicReporterLooping.getAndSet(false)) {
            getOrCreateHandler().removeCallbacks(this.mPeriodicMetricReporter);
            getOrCreateHandler().post(this.mPeriodicMetricReporter);
        }
    }
}
