package com.bytedance.apm.launch;

/* loaded from: classes3.dex */
public class LaunchInitConfig {
    private long maxCollectTimeMs;
    private boolean needCollectDeviceInfo;
    private boolean needCollectNetData;
    private boolean needCollectPerfData;
    private boolean needCollectSlowLaunchTrace;
    private boolean needCollectTimingTrace;
    private long slowLaunchThreshold;

    public LaunchInitConfig(boolean z, boolean z2, boolean z3, long j, boolean z4, long j2, boolean z5) {
        this.needCollectPerfData = z;
        this.needCollectNetData = z2;
        this.needCollectTimingTrace = z3;
        this.maxCollectTimeMs = j;
        this.needCollectDeviceInfo = z4;
        this.slowLaunchThreshold = j2;
        this.needCollectSlowLaunchTrace = z5;
    }

    public boolean isNeedCollectPerfData() {
        return this.needCollectPerfData;
    }

    public boolean isNeedCollectNetData() {
        return this.needCollectNetData;
    }

    public boolean isNeedCollectTimingTrace() {
        return this.needCollectTimingTrace;
    }

    public boolean isNeedCollectDeviceInfo() {
        return this.needCollectDeviceInfo;
    }

    public long getMaxCollectTimeMs() {
        return this.maxCollectTimeMs;
    }

    public long getSlowLaunchThreshold() {
        return this.slowLaunchThreshold;
    }

    public boolean isNeedCollectSlowLaunchTrace() {
        return this.needCollectSlowLaunchTrace;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private static final long DEFAULT_SLOW_LAUNCH_THRESHOLD_MS = 1000;
        private boolean needCollectPerfData = false;
        private boolean needCollectNetData = false;
        private boolean needCollectTimingTrace = false;
        private boolean needCollectDeviceInfo = false;
        private boolean needCollectSlowLaunchTrace = false;
        private long maxCollectTimeMs = -1;
        private long slowLaunchThreshold = 1000;

        public Builder collectPerfData() {
            this.needCollectPerfData = true;
            return this;
        }

        public Builder collectNetData() {
            this.needCollectNetData = true;
            return this;
        }

        public Builder collectTimingTrace() {
            this.needCollectTimingTrace = true;
            return this;
        }

        public Builder collectDeviceInfo() {
            this.needCollectDeviceInfo = true;
            return this;
        }

        public Builder collectSlowLaunchTrace() {
            this.needCollectSlowLaunchTrace = true;
            return this;
        }

        public Builder setSlowLaunchThreshold(long j) {
            this.slowLaunchThreshold = j;
            return this;
        }

        public Builder setMaxCollectTimeMs(long j) {
            this.maxCollectTimeMs = j;
            return this;
        }

        public LaunchInitConfig build() {
            return new LaunchInitConfig(this.needCollectPerfData, this.needCollectNetData, this.needCollectTimingTrace, this.maxCollectTimeMs, this.needCollectDeviceInfo, this.slowLaunchThreshold, this.needCollectSlowLaunchTrace);
        }
    }
}
