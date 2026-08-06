package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum MessageConfig {
    RELIABLE_ORDERED(0),
    UNRELIABLE_ORDERED(1),
    UNRELIABLE_UNORDERED(2);

    int value;

    MessageConfig(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static MessageConfig fromId(int type) {
        for (MessageConfig messageConfig : values()) {
            if (messageConfig.value() == type) {
                return messageConfig;
            }
        }
        return RELIABLE_ORDERED;
    }
}
