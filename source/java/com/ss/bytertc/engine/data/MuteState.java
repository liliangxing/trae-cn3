package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum MuteState {
    MUTE_STATE_OFF(0),
    MUTE_STATE_ON(1);

    private int value;

    MuteState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == MUTE_STATE_ON ? "kMuteStateOn" : "kMuteStateOff";
    }

    public static MuteState fromId(int id) {
        for (MuteState muteState : values()) {
            if (muteState.value() == id) {
                return muteState;
            }
        }
        return null;
    }
}
