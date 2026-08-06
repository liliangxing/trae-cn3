package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum EarMonitorMode {
    EAR_MONITOR_MODE_OFF(0),
    EAR_MONITOR_MODE_ON(1);

    private int value;

    EarMonitorMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == EAR_MONITOR_MODE_ON ? "kEarMonitorModeOn" : "kEarMonitorModeOff";
    }

    public static EarMonitorMode fromId(int id) {
        for (EarMonitorMode earMonitorMode : values()) {
            if (earMonitorMode.value() == id) {
                return earMonitorMode;
            }
        }
        return null;
    }
}
