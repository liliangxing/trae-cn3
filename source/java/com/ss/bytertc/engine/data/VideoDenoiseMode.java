package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoDenoiseMode {
    VIDEO_DENOISE_MODE_OFF(0),
    VIDEO_DENOISE_MODE_AUTO(1);

    private int value;

    VideoDenoiseMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = this.value;
        return i != 0 ? i != 1 ? "" : "kVideoDenoiseModeAuto" : "kVideoDenoiseModeOff";
    }

    public static VideoDenoiseMode fromId(int id) {
        for (VideoDenoiseMode videoDenoiseMode : values()) {
            if (videoDenoiseMode.value() == id) {
                return videoDenoiseMode;
            }
        }
        return null;
    }
}
