package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RemoteVideoState {
    REMOTE_VIDEO_STATE_STOPPED(0),
    REMOTE_VIDEO_STATE_STARTING(1),
    REMOTE_VIDEO_STATE_DECODING(2),
    REMOTE_VIDEO_STATE_FROZEN(3),
    REMOTE_VIDEO_STATE_FAILED(4);

    private int value;

    RemoteVideoState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RemoteVideoState fromId(int id) {
        for (RemoteVideoState remoteVideoState : values()) {
            if (remoteVideoState.value() == id) {
                return remoteVideoState;
            }
        }
        return null;
    }
}
