package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes7.dex */
public class TimingMetric implements AutoCloseable {
    private final String mMetricName;
    private long mStartTime;
    private final int mTimerType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    private @interface TimerType {
        public static final int MEDIUM_UPTIME = 1;
        public static final int SHORT_THREAD_TIME = 2;
        public static final int SHORT_UPTIME = 0;
    }

    public static TimingMetric shortUptime(String str) {
        TimingMetric timingMetric = new TimingMetric(str, 0);
        timingMetric.mStartTime = TimeUtils.uptimeMillis();
        return timingMetric;
    }

    public static TimingMetric mediumUptime(String str) {
        TimingMetric timingMetric = new TimingMetric(str, 1);
        timingMetric.mStartTime = TimeUtils.uptimeMillis();
        return timingMetric;
    }

    public static TimingMetric shortThreadTime(String str) {
        TimingMetric timingMetric = new TimingMetric(str, 2);
        timingMetric.mStartTime = TimeUtils.currentThreadTimeMillis();
        return timingMetric;
    }

    private TimingMetric(String str, int i) {
        this.mMetricName = str;
        this.mTimerType = i;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        String str = this.mMetricName;
        long j = this.mStartTime;
        if (j == 0) {
            return;
        }
        this.mStartTime = 0L;
        int i = this.mTimerType;
        if (i == 0) {
            RecordHistogram.recordTimesHistogram(str, TimeUtils.uptimeMillis() - j);
        } else if (i == 1) {
            RecordHistogram.recordMediumTimesHistogram(str, TimeUtils.uptimeMillis() - j);
        } else {
            if (i != 2) {
                return;
            }
            RecordHistogram.recordTimesHistogram(str, TimeUtils.currentThreadTimeMillis() - j);
        }
    }
}
