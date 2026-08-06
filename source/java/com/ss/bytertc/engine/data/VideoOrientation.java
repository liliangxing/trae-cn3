package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoOrientation {
    ADAPTIVE(0),
    PORTRAIT(1),
    LANDSCAPE(2);

    private int value;

    VideoOrientation(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = this.value;
        return i != 0 ? i != 1 ? i != 2 ? "" : "kVideoOrientationLandscape" : "kVideoOrientationPortrait" : "kVideoOrientationAdaptive";
    }

    public static VideoOrientation fromId(int id) {
        for (VideoOrientation videoOrientation : values()) {
            if (videoOrientation.value() == id) {
                return videoOrientation;
            }
        }
        return null;
    }
}
