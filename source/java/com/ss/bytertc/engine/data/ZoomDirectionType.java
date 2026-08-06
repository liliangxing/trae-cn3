package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum ZoomDirectionType {
    CAMERA_MOVE_LEFT(0),
    CAMERA_MOVE_RIGHT(1),
    CAMERA_MOVE_UP(2),
    CAMERA_MOVE_DOWN(3),
    CAMERA_ZOOM_OUT(4),
    CAMERA_ZOOM_IN(5),
    CAMERA_RESET(6);

    private int value;

    ZoomDirectionType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static ZoomDirectionType fromId(int id) {
        for (ZoomDirectionType zoomDirectionType : values()) {
            if (zoomDirectionType.value() == id) {
                return zoomDirectionType;
            }
        }
        return null;
    }
}
