package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum SubtitleState {
    SUBTITLE_STATE_STARTED(0),
    SUBTITLE_STATE_STOPED(1),
    SUBTITLE_STATE_ERROR(2);

    private int value;

    SubtitleState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static SubtitleState fromId(int type) {
        for (SubtitleState subtitleState : values()) {
            if (subtitleState.value() == type) {
                return subtitleState;
            }
        }
        return SUBTITLE_STATE_ERROR;
    }
}
