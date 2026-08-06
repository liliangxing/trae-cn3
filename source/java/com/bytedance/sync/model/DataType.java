package com.bytedance.sync.model;

/* loaded from: classes5.dex */
public enum DataType {
    ORIGIN(0),
    FILE_PATH(1);

    private final int type;

    DataType(int i) {
        this.type = i;
    }

    public static DataType fromValue(int i) {
        DataType dataType = ORIGIN;
        if (i == dataType.getValue()) {
            return dataType;
        }
        DataType dataType2 = FILE_PATH;
        if (i == dataType2.getValue()) {
            return dataType2;
        }
        return null;
    }

    public int getValue() {
        return this.type;
    }
}
