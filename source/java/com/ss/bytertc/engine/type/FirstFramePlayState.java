package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum FirstFramePlayState {
    FIRST_FRAME_PLAY_STATE_PLAYING(0),
    FIRST_FRAME_PLAY_STATE_PLAYED(1),
    FIRST_FRAME_PLAY_STATE_END(2);

    private int state;

    FirstFramePlayState(int state) {
        this.state = state;
    }

    public int value() {
        return this.state;
    }

    public static FirstFramePlayState fromId(int type) {
        for (FirstFramePlayState firstFramePlayState : values()) {
            if (firstFramePlayState.value() == type) {
                return firstFramePlayState;
            }
        }
        return null;
    }
}
