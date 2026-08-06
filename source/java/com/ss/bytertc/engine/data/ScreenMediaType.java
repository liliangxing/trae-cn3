package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum ScreenMediaType {
    SCREEN_MEDIA_TYPE_VIDEO_ONLY(0),
    SCREEN_MEDIA_TYPE_AUDIO_ONLY(1),
    SCREEN_MEDIA_TYPE_VIDEO_AND_AUDIO(2);

    private int value;

    ScreenMediaType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static ScreenMediaType fromId(int id) {
        for (ScreenMediaType screenMediaType : values()) {
            if (screenMediaType.value() == id) {
                return screenMediaType;
            }
        }
        return null;
    }
}
