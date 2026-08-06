package com.bytedance.apm.trace;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PageLoadTrace {
    private static final String TAG = "PageLoadTrace";
    private String mPageName;
    private int mPageType;
    private TraceStats mTraceStats;

    public PageLoadTrace(String str) {
        this(str, 1);
    }

    public PageLoadTrace(String str, int i) {
        this.mPageName = str;
        this.mPageType = i;
    }

    public void startTrace() {
        TraceStats traceStats = new TraceStats("page_load_trace", this.mPageType == 1 ? "activity" : "fragment");
        this.mTraceStats = traceStats;
        traceStats.startTrace();
    }

    public void startSpan(String str) {
        TraceStats traceStats = this.mTraceStats;
        if (traceStats != null) {
            traceStats.startSpan("", str);
        }
    }

    public void endSpan(String str) {
        TraceStats traceStats = this.mTraceStats;
        if (traceStats != null) {
            traceStats.endSpan("", str);
        }
    }

    public void endTrace(int i, long j) {
        TraceStats traceStats = this.mTraceStats;
        if (traceStats != null) {
            traceStats.endTrace(i, this.mPageName, j);
        }
    }

    public void cancelTrace() {
        TraceStats traceStats = this.mTraceStats;
        if (traceStats != null) {
            traceStats.cancelTrace();
            this.mTraceStats = null;
        }
    }
}
