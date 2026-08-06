package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoDenoiseModeChangedReason {
    VIDEO_DENOISE_MODE_CHANGED_REASON_NULL(-1),
    VIDEO_DENOISE_MODE_CHANGED_REASON_API_OFF(0),
    VIDEO_DENOISE_MODE_CHANGED_REASON_API_ON(1),
    VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_DISABLED(2),
    VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_ENABLED(3),
    VIDEO_DENOISE_MODE_CHANGED_REASON_INTERNAL_EXCEPTION(4),
    VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_CLOSE(5),
    VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_OPEN(6),
    VIDEO_DENOISE_MODE_CHANGED_REASON_RESOLUTION(7);

    private int value;

    VideoDenoiseModeChangedReason(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (this.value) {
            case -1:
                return "kVideoDenoiseModeChangedReasonNull";
            case 0:
                return "kVideoDenoiseModeChangedReasonApiOff";
            case 1:
                return "kVideoDenoiseModeChangedReasonApiOn";
            case 2:
                return "kVideoDenoiseModeChangedReasonConfigDisabled";
            case 3:
                return "kVideoDenoiseModeChangedReasonConfigEnabled";
            case 4:
                return "kVideoDenoiseModeChangedReasonInternalException";
            case 5:
                return "kVideoDenoiseModeChangedReasonDynamicClose";
            case 6:
                return "kVideoDenoiseModeChangedReasonDynamicOpen";
            case 7:
                return "kVideoDenoiseModeChangedReasonResolution";
            default:
                return "";
        }
    }

    public static VideoDenoiseModeChangedReason fromId(int id) {
        for (VideoDenoiseModeChangedReason videoDenoiseModeChangedReason : values()) {
            if (videoDenoiseModeChangedReason.value() == id) {
                return videoDenoiseModeChangedReason;
            }
        }
        return null;
    }
}
