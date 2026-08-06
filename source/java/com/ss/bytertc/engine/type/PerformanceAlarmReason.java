package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum PerformanceAlarmReason {
    BANDWIDTH_FALLBACKED(0),
    BANDWIDTH_RESUMED(1),
    PERFORMANCE_FALLBACKED(2),
    PERFORMANCE_RESUMED(3);

    private int value;

    PerformanceAlarmReason(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
