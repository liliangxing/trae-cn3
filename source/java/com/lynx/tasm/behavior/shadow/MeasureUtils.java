package com.lynx.tasm.behavior.shadow;

/* loaded from: classes7.dex */
public class MeasureUtils {
    public static final float UNDEFINED = 1.0E21f;

    public static boolean isUndefined(float f) {
        return Float.compare(f, 1.0E9f) >= 0 || Float.compare(f, -1.0E9f) <= 0;
    }
}
