package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioScenarioType {
    DEFAULT(0),
    CHATROOM(1),
    GAMESTREAMING(2),
    CHORUS(3);

    private final int value;

    public static AudioScenarioType fromId(int type) {
        for (AudioScenarioType audioScenarioType : values()) {
            if (audioScenarioType.value() == type) {
                return audioScenarioType;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }

    AudioScenarioType(int value) {
        this.value = value;
    }
}
