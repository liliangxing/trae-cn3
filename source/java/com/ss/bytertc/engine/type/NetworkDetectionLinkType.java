package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum NetworkDetectionLinkType {
    UP(0),
    DOWN(1);

    int value;

    NetworkDetectionLinkType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static NetworkDetectionLinkType fromId(int type) {
        for (NetworkDetectionLinkType networkDetectionLinkType : values()) {
            if (networkDetectionLinkType.value() == type) {
                return networkDetectionLinkType;
            }
        }
        return UP;
    }
}
