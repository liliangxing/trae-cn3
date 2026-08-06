package com.ttnet.org.chromium.base.jank_tracker;

import android.app.Activity;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class JankTrackerImpl implements JankTracker {
    private static final boolean IS_TRACKING_ENABLED = true;
    private final JankActivityTracker mActivityTracker;
    private final JankReportingScheduler mReportingScheduler;

    public JankTrackerImpl(Activity activity) {
        if (!IS_TRACKING_ENABLED) {
            this.mActivityTracker = null;
            this.mReportingScheduler = null;
            return;
        }
        FrameMetricsStore frameMetricsStore = new FrameMetricsStore();
        FrameMetricsListener frameMetricsListener = new FrameMetricsListener(frameMetricsStore);
        JankReportingScheduler jankReportingScheduler = new JankReportingScheduler(frameMetricsStore);
        this.mReportingScheduler = jankReportingScheduler;
        JankActivityTracker jankActivityTracker = new JankActivityTracker(activity, frameMetricsListener, jankReportingScheduler);
        this.mActivityTracker = jankActivityTracker;
        jankActivityTracker.initialize();
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankTracker
    public void startTrackingScenario(int i) {
        if (IS_TRACKING_ENABLED) {
            this.mReportingScheduler.startTrackingScenario(i);
        }
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankTracker
    public void finishTrackingScenario(int i) {
        if (IS_TRACKING_ENABLED) {
            this.mReportingScheduler.finishTrackingScenario(i);
        }
    }

    public void destroy() {
        if (IS_TRACKING_ENABLED) {
            this.mActivityTracker.destroy();
        }
    }
}
