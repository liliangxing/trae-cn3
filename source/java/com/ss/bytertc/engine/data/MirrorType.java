package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum MirrorType {
    MIRROR_TYPE_NONE(0),
    MIRROR_TYPE_RENDER(1),
    MIRROR_TYPE_RENDER_AND_ENCODER(3);

    private int value;

    MirrorType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == MIRROR_TYPE_NONE ? "kMirrorTypeNone" : this == MIRROR_TYPE_RENDER ? "kMirrorTypeRender" : this == MIRROR_TYPE_RENDER_AND_ENCODER ? "kMirrorTypeRenderAndEncoder" : "";
    }

    public static MirrorType fromId(int id) {
        for (MirrorType mirrorType : values()) {
            if (mirrorType.value() == id) {
                return mirrorType;
            }
        }
        return null;
    }
}
