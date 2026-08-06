package com.ss.android.deviceregister;

/* loaded from: classes7.dex */
public enum DeviceCategory {
    PHONE("phone"),
    PAD("pad"),
    TV("tv"),
    CAR("car"),
    VR("vr"),
    AR("ar"),
    WATCH("watch");

    private String lower;

    DeviceCategory(String str) {
        this.lower = str;
    }

    public String getLower() {
        return this.lower;
    }
}
