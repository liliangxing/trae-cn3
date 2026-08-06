package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum ZoomConfigType {
    ZOOM_FOCUS_OFFSET(0),
    ZOOM_MOVE_OFFSET(1);

    private int value;

    ZoomConfigType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static ZoomConfigType fromId(int id) {
        for (ZoomConfigType zoomConfigType : values()) {
            if (zoomConfigType.value() == id) {
                return zoomConfigType;
            }
        }
        return null;
    }
}
