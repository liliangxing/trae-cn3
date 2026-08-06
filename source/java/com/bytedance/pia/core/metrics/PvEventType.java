package com.bytedance.pia.core.metrics;

/* loaded from: classes4.dex */
public enum PvEventType {
    PREFETCH_ENABLED("prefetch_enabled"),
    LOADING_ENABLED("native_loading_enabled"),
    NSR_ENABLED("nsr_enabled"),
    NSR_HIT("nsr_hit"),
    SNAPSHOT_ENABLED("snapshot_enabled"),
    SNAPSHOT_HIT("snapshot_hit");

    private final String value;

    PvEventType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
