package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RtcMode {
    RTC_MODE_GENERAL(0),
    RTC_MODE_LOCAL_AUDIO(1);

    private int value;

    RtcMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
