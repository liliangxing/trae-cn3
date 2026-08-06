package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum SubtitleMode {
    SUBTITLE_MODE_RECOGINTE(0),
    SUBTITLE_MODE_TRANSLATION(1);

    private int value;

    SubtitleMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static SubtitleMode fromId(int mode) {
        for (SubtitleMode subtitleMode : values()) {
            if (subtitleMode.value() == mode) {
                return subtitleMode;
            }
        }
        return SUBTITLE_MODE_RECOGINTE;
    }
}
