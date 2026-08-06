package com.lynx.tasm.utils;

import com.lynx.tasm.base.LLog;
import io.noties.markwon.image.CustomImageSizeResolverDef;

/* loaded from: classes7.dex */
public class FloatUtils {
    private static final float EPSILON = 1.0E-5f;

    public static boolean floatsEqual(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) && Float.isNaN(f2) : Math.abs(f2 - f) < EPSILON;
    }

    public static boolean isContainOnlyZero(float[] fArr) {
        if (fArr == null) {
            return true;
        }
        for (float f : fArr) {
            if (f != 0.0f) {
                return false;
            }
        }
        return true;
    }

    public static float sanitizeFloatPropertyValue(float f) {
        if (f >= -3.4028235E38f && f <= Float.MAX_VALUE) {
            return f;
        }
        if (f < -3.4028235E38f || f == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        if (f > Float.MAX_VALUE || f == Float.POSITIVE_INFINITY) {
            return Float.MAX_VALUE;
        }
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        LLog.w("lynx", "Invalid float property value: " + f);
        return 0.0f;
    }

    public static float getValue(String str) {
        if (str == null) {
            return Float.NaN;
        }
        String trim = str.trim();
        if (trim.endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
            if (trim.length() < 2) {
                return Float.NaN;
            }
            try {
                return Float.parseFloat(trim.substring(0, trim.length() - 1)) / 100.0f;
            } catch (Exception unused) {
                return Float.NaN;
            }
        }
        try {
            return Float.parseFloat(trim);
        } catch (Exception unused2) {
            return Float.NaN;
        }
    }
}
