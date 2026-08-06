package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum EarMonitorAudioFilter {
    NONE(1),
    REUSE_AUDIO_PROCESSING(32768);

    private int value;

    EarMonitorAudioFilter(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == NONE ? "kEarMonitorAudioFilterNone" : "kEarMonitorAudioFilterReuseAudioProcessing";
    }

    public static EarMonitorAudioFilter fromId(int id) {
        for (EarMonitorAudioFilter earMonitorAudioFilter : values()) {
            if (earMonitorAudioFilter.value() == id) {
                return earMonitorAudioFilter;
            }
        }
        return null;
    }
}
