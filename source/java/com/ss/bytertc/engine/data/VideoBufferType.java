package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoBufferType {
    RAW_MEMORY(0),
    GL_TEXTURE(2);

    private int value;

    VideoBufferType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == RAW_MEMORY ? "kVideoBufferTypeRawMemory" : "kVideoBufferTypeGLTexture";
    }

    public static VideoBufferType fromId(int id) {
        for (VideoBufferType videoBufferType : values()) {
            if (videoBufferType.value() == id) {
                return videoBufferType;
            }
        }
        return null;
    }
}
