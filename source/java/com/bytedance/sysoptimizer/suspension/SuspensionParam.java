package com.bytedance.sysoptimizer.suspension;

import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import java.util.Set;

/* loaded from: classes5.dex */
public class SuspensionParam {
    private long threadSuspendDuration = 2000;
    private long intervalCheckSuspensionDuration = OnekeyLoginConfig.OVER_TIME;
    private long suspensionTaskMaxDuration = 180000;
    private Set<String> ignoredThreadSet = null;
    private float ratio = 1.0f;
    private boolean enableCrashWhenInitFailed = false;

    public long getThreadSuspendDuration() {
        return this.threadSuspendDuration;
    }

    public SuspensionParam setThreadSuspendDuration(long j) {
        this.threadSuspendDuration = j;
        return this;
    }

    public long getIntervalCheckSuspensionDuration() {
        return this.intervalCheckSuspensionDuration;
    }

    public SuspensionParam setIntervalCheckSuspensionDuration(long j) {
        this.intervalCheckSuspensionDuration = j;
        return this;
    }

    public long getSuspensionTaskMaxDuration() {
        return this.suspensionTaskMaxDuration;
    }

    public SuspensionParam setSuspensionTaskMaxDuration(long j) {
        this.suspensionTaskMaxDuration = j;
        return this;
    }

    public Set<String> getIgnoredThreadSet() {
        return this.ignoredThreadSet;
    }

    public SuspensionParam setIgnoredThreadSet(Set<String> set) {
        this.ignoredThreadSet = set;
        return this;
    }

    public float getRatio() {
        return this.ratio;
    }

    public SuspensionParam setRatio(float f) {
        this.ratio = f;
        return this;
    }

    public boolean isEnableCrashWhenInitFailed() {
        return this.enableCrashWhenInitFailed;
    }

    public SuspensionParam setEnableCrashWhenInitFailed(boolean z) {
        this.enableCrashWhenInitFailed = z;
        return this;
    }
}
