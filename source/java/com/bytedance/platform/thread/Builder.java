package com.bytedance.platform.thread;

import com.bytedance.platform.thread.PlatformThreadPool;

/* loaded from: classes4.dex */
public class Builder {
    private PlatformThreadPool.Options mBackgroundOptions;
    private PlatformThreadPool.Options mDefaultOptions;
    private PlatformThreadPool.Options mFixedOptions;
    private PlatformThreadPool.Options mIOOptions;
    private PlatformThreadPool.Options mScheduleOptions;
    private PlatformThreadPool.Options mSingleOptions;

    public static Builder builder() {
        return new Builder();
    }

    public PlatformThreadPool.Options getIOOptions() {
        return this.mIOOptions;
    }

    public Builder setIOOptions(PlatformThreadPool.Options options) {
        this.mIOOptions = options;
        return this;
    }

    public PlatformThreadPool.Options getDefaultOptions() {
        return this.mDefaultOptions;
    }

    public Builder setDefaultOptions(PlatformThreadPool.Options options) {
        this.mDefaultOptions = options;
        return this;
    }

    public PlatformThreadPool.Options getBackgroundOptions() {
        return this.mBackgroundOptions;
    }

    public Builder setBackgroundOptions(PlatformThreadPool.Options options) {
        this.mBackgroundOptions = options;
        return this;
    }

    public PlatformThreadPool.Options getScheduleOptions() {
        return this.mScheduleOptions;
    }

    public Builder setScheduleOptions(PlatformThreadPool.Options options) {
        this.mScheduleOptions = options;
        return this;
    }

    public PlatformThreadPool.Options getSingleOptions() {
        return this.mSingleOptions;
    }

    public Builder setSingleOptions(PlatformThreadPool.Options options) {
        this.mSingleOptions = options;
        return this;
    }

    public PlatformThreadPool.Options getFixedOptions() {
        return this.mFixedOptions;
    }

    public Builder setFixedOptions(PlatformThreadPool.Options options) {
        this.mFixedOptions = options;
        return this;
    }
}
