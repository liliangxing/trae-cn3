package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoSuperResolutionMode {
    OFF(0),
    SCALE_AUTO(1),
    SCALE_15X(2),
    SCALE_20X(3),
    SCALE_11X(4),
    SCALE_12X(5),
    SCALE_13X(6),
    SCALE_14X(7);

    private int value;

    VideoSuperResolutionMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (this.value) {
            case 0:
                return "kVideoSuperResolutionModeOff";
            case 1:
                return "kVideoSuperResolutionModeScaleAuto";
            case 2:
                return "kVideoSuperResolutionModeScale15X";
            case 3:
                return "kVideoSuperResolutionModeScale20X";
            case 4:
                return "kVideoSuperResolutionModeScale11X";
            case 5:
                return "kVideoSuperResolutionModeScale12X";
            case 6:
                return "kVideoSuperResolutionModeScale13X";
            case 7:
                return "kVideoSuperResolutionModeScale14X";
            default:
                return "";
        }
    }

    public static VideoSuperResolutionMode fromId(int id) {
        for (VideoSuperResolutionMode videoSuperResolutionMode : values()) {
            if (videoSuperResolutionMode.value() == id) {
                return videoSuperResolutionMode;
            }
        }
        return null;
    }
}
