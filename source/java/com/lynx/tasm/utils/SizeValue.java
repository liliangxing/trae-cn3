package com.lynx.tasm.utils;

import io.noties.markwon.image.CustomImageSizeResolverDef;

/* loaded from: classes7.dex */
public class SizeValue {
    public Type type;
    public float value;

    /* loaded from: classes7.dex */
    public enum Type {
        UNKNOWN,
        PERCENTAGE,
        DEVICE_PX
    }

    public SizeValue(Type type, float f) {
        this.type = type;
        this.value = f;
    }

    public SizeValue() {
        this.type = Type.UNKNOWN;
        this.value = 0.0f;
    }

    public static SizeValue fromCSSString(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 1 && str.endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
            return new SizeValue(Type.PERCENTAGE, UnitUtils.toPx(str, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        }
        if (length <= 2 || !str.endsWith("px")) {
            return null;
        }
        return new SizeValue(Type.DEVICE_PX, UnitUtils.toPx(str, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
    }

    public float convertToDevicePx(float f) {
        if (this.type == Type.PERCENTAGE) {
            return this.value * f;
        }
        if (this.type == Type.DEVICE_PX) {
            return this.value;
        }
        return 0.0f;
    }
}
