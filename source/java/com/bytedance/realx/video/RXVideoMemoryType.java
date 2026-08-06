package com.bytedance.realx.video;

/* loaded from: classes4.dex */
public enum RXVideoMemoryType {
    kUNKNOWN(0),
    kBYTE_MEMORY(1),
    kOPENGL_TEXTURE(3);

    private int value;

    RXVideoMemoryType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RXVideoMemoryType fromId(int id) {
        for (RXVideoMemoryType rXVideoMemoryType : values()) {
            if (rXVideoMemoryType.value() == id) {
                return rXVideoMemoryType;
            }
        }
        return null;
    }
}
