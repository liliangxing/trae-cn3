package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum EffectBeautyMode {
    WHITE(0),
    SMOOTH(1),
    SHARPEN(2),
    CLEAR(3);

    private int value;

    EffectBeautyMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == WHITE ? "kEffectBeautyWhiteMode" : this == SMOOTH ? "kEffectBeautySmoothMode" : this == SHARPEN ? "kEffectBeautySharpenMode" : this == CLEAR ? "kEffectBeautyClearMode" : "";
    }

    public static EffectBeautyMode fromId(int id) {
        for (EffectBeautyMode effectBeautyMode : values()) {
            if (effectBeautyMode.value() == id) {
                return effectBeautyMode;
            }
        }
        return null;
    }
}
