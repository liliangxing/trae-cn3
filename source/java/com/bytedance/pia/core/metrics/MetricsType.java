package com.bytedance.pia.core.metrics;

/* loaded from: classes4.dex */
public enum MetricsType {
    EXCEPTION("exception"),
    PV("pv"),
    NSR_PERFORMANCE("nsr_worker_performance");

    private final String value;

    MetricsType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
