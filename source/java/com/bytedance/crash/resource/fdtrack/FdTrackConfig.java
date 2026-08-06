package com.bytedance.crash.resource.fdtrack;

import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes3.dex */
public class FdTrackConfig extends ResourceMonitorConfig {
    protected int mBacktraceLimit;
    protected boolean mDebug;
    protected int mDumpLine;
    protected boolean mFdTrackEnable;
    protected boolean mLoopMonitorEnable;
    protected long mSleepTime;
    protected int mWaterLine;

    public FdTrackConfig(boolean z, boolean z2, int i, int i2, long j, int i3) {
        super(21, 35, 2);
        this.mFdTrackEnable = false;
        this.mLoopMonitorEnable = false;
        this.mDebug = false;
        this.mWaterLine = 500;
        this.mDumpLine = 1000;
        this.mBacktraceLimit = 10;
        this.mSleepTime = 60000L;
        if (RuntimeConfig.isLocalTest()) {
            this.mFdTrackEnable = true;
            this.mLoopMonitorEnable = true;
            this.mWaterLine = 200;
            this.mDumpLine = 400;
            this.mSleepTime = 1000L;
            this.mBacktraceLimit = 10;
            this.mDebug = true;
            return;
        }
        this.mFdTrackEnable = z;
        this.mLoopMonitorEnable = z2;
        this.mWaterLine = i;
        this.mDumpLine = i2;
        this.mSleepTime = Math.max(1000L, j);
        this.mBacktraceLimit = i3;
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return "fdTrackEnable=" + this.mFdTrackEnable + "\nwaterLine=" + this.mWaterLine + "\ndumpLine=" + this.mDumpLine + "\nloopMonitorEnable=" + this.mLoopMonitorEnable + "\nmSleepTime=" + this.mSleepTime + "\nmBacktraceLimit=" + this.mBacktraceLimit + "\ndebug=" + this.mDebug + UpdateDialogNewBase.TYPE;
    }
}
