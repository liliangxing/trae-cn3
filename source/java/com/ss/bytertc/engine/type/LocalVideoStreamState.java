package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum LocalVideoStreamState {
    LOCAL_VIDEO_STREAM_STATE_STOPPED(0),
    LOCAL_VIDEO_STREAM_STATE_RECORDING(1),
    LOCAL_VIDEO_STREAM_STATE_ENCODING(2),
    LOCAL_VIDEO_STREAM_STATE_FAILED(3);

    private int value;

    LocalVideoStreamState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static LocalVideoStreamState fromId(int id) {
        for (LocalVideoStreamState localVideoStreamState : values()) {
            if (localVideoStreamState.value() == id) {
                return localVideoStreamState;
            }
        }
        return null;
    }
}
