package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum LocalLogLevel {
    INFO(0),
    WARNING(1),
    ERROR(2),
    NONE(3);

    private int value;

    LocalLogLevel(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

    public static LocalLogLevel fromId(int id) {
        for (LocalLogLevel localLogLevel : values()) {
            if (localLogLevel.getValue() == id) {
                return localLogLevel;
            }
        }
        return WARNING;
    }
}
