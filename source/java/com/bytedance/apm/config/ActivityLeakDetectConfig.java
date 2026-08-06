package com.bytedance.apm.config;

import com.bytedance.apm.perf.memory.IActivityLeakListener;

/* loaded from: classes3.dex */
public class ActivityLeakDetectConfig {
    private IActivityLeakListener mActivityLeakListener;
    private boolean mIsGcDetect;
    private boolean mReportActivityLeakEvent;
    private boolean mUnbindActivityLeakSwitch;
    private long mWaitDetectActivityTimeMs;

    public boolean isGcDetect() {
        return this.mIsGcDetect;
    }

    public long getWaitDetectActivityTimeMs() {
        return this.mWaitDetectActivityTimeMs;
    }

    public boolean isReportActivityLeakEvent() {
        return this.mReportActivityLeakEvent;
    }

    public boolean isUnbindActivityLeak() {
        return this.mUnbindActivityLeakSwitch;
    }

    public IActivityLeakListener getActivityLeakListener() {
        return this.mActivityLeakListener;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ActivityLeakDetectConfig(Builder builder) {
        this.mIsGcDetect = builder.gcDetectActivityLeak;
        this.mWaitDetectActivityTimeMs = builder.waitDetectActivityTimeMs;
        this.mReportActivityLeakEvent = builder.reportActivityLeakEvent;
        this.mUnbindActivityLeakSwitch = builder.unbindActivityLeakSwitch;
        this.mActivityLeakListener = builder.activityLeakListener;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private IActivityLeakListener activityLeakListener;
        private boolean gcDetectActivityLeak;
        private boolean reportActivityLeakEvent;
        private boolean unbindActivityLeakSwitch;
        private long waitDetectActivityTimeMs;

        private Builder() {
            this.gcDetectActivityLeak = false;
            this.waitDetectActivityTimeMs = 60000L;
            this.reportActivityLeakEvent = false;
            this.unbindActivityLeakSwitch = true;
        }

        public Builder gcDetectActivityLeak(boolean z) {
            this.gcDetectActivityLeak = z;
            return this;
        }

        public Builder waitDetectActivityTimeMs(long j) {
            this.waitDetectActivityTimeMs = j;
            return this;
        }

        public Builder reportActivityLeakEvent(boolean z) {
            this.reportActivityLeakEvent = z;
            return this;
        }

        public Builder unbindActivityLeakSwitch(boolean z) {
            this.unbindActivityLeakSwitch = z;
            return this;
        }

        public Builder activityLeakListener(IActivityLeakListener iActivityLeakListener) {
            this.activityLeakListener = iActivityLeakListener;
            return this;
        }

        public ActivityLeakDetectConfig build() {
            return new ActivityLeakDetectConfig(this);
        }
    }
}
