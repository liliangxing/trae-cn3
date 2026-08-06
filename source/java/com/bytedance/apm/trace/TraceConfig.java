package com.bytedance.apm.trace;

@Deprecated
/* loaded from: classes3.dex */
public class TraceConfig {
    public static final String KEY_FRAGMENT_CREATE_TO_VIEW_SHOW_TIME = "fragmentOnCreateToViewShow";
    public static final String KEY_FRAGMENT_HIDECHANGED_TO_VIEW_SHOW_TIME = "fragmentOnHiddenChangedToViewShow";
    public static final String KEY_FRAGMENT_VISIBLEHINT_TO_VIEW_SHOW_TIME = "fragmentUserVisibleToViewShow";
    public static final String KEY_PAGE_LOAD_TO_VIEW_SHOW_TIME = "activityOnCreateToViewShow";
    private boolean mDropFrameReportEvilMethodSwitch;
    private boolean mPageAnnotationTraceTimeSwitch;
    private long maxWaitViewShowTimeMs = 30000;
    private int mEvilMethodThresholdMs = 1000;

    public TraceConfig setAnnotationPageTimeTraceSwitch(boolean z) {
        this.mPageAnnotationTraceTimeSwitch = z;
        return this;
    }

    public TraceConfig setMaxWaitViewShowTime(long j) {
        this.maxWaitViewShowTimeMs = j;
        return this;
    }

    public TraceConfig setBlockThresholdMs(int i) {
        this.mEvilMethodThresholdMs = i;
        return this;
    }

    public TraceConfig setDropFrameReportStackSwitch(boolean z) {
        this.mDropFrameReportEvilMethodSwitch = z;
        return this;
    }

    public boolean isDropFrameReportEvilMethodSwitch() {
        return this.mDropFrameReportEvilMethodSwitch;
    }

    @Deprecated
    public TraceConfig setSwitch(boolean z) {
        return setAnnotationPageTimeTraceSwitch(z);
    }

    public long getMaxWaitViewShowTimeMs() {
        return this.maxWaitViewShowTimeMs;
    }

    public boolean isPageAnnotationTraceTimeSwitchOn() {
        return this.mPageAnnotationTraceTimeSwitch;
    }

    public int getEvilMethodThresholdMs() {
        return this.mEvilMethodThresholdMs;
    }
}
