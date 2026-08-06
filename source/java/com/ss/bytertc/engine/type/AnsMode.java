package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AnsMode {
    ANS_MODE_DISABLE(0),
    ANS_MODE_LOW(1),
    ANS_MODE_MEDIUM(2),
    ANS_MODE_HIGH(3),
    ANS_MODE_AUTOMATIC(4);

    private final int value;

    public static AnsMode fromId(int ansMode) {
        for (AnsMode ansMode2 : values()) {
            if (ansMode2.value() == ansMode) {
                return ansMode2;
            }
        }
        return ANS_MODE_AUTOMATIC;
    }

    public int value() {
        return this.value;
    }

    AnsMode(int value) {
        this.value = value;
    }
}
