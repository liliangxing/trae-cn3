package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum RemoteMirrorType {
    NONE(0),
    RENDER(1);

    private int value;

    RemoteMirrorType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == NONE ? "NONE" : this == RENDER ? "RENDER" : "";
    }

    public static RemoteMirrorType fromId(int id) {
        for (RemoteMirrorType remoteMirrorType : values()) {
            if (remoteMirrorType.value() == id) {
                return remoteMirrorType;
            }
        }
        return null;
    }
}
