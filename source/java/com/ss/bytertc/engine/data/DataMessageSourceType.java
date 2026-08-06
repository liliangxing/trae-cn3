package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum DataMessageSourceType {
    DATA_MESSAGE_SOURCE_TYPE_DEFAULT(0),
    DATA_MESSAGE_SOURCE_TYPE_SYSTEM(1);

    private int value;

    DataMessageSourceType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static DataMessageSourceType fromId(int id) {
        for (DataMessageSourceType dataMessageSourceType : values()) {
            if (dataMessageSourceType.value() == id) {
                return dataMessageSourceType;
            }
        }
        return null;
    }
}
