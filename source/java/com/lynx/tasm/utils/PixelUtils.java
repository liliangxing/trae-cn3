package com.lynx.tasm.utils;

/* loaded from: classes7.dex */
public class PixelUtils {
    public static float dipToPx(float f, float f2) {
        if (f2 <= 0.0f) {
            f2 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
        }
        return f * f2;
    }

    public static float dipToPx(float f) {
        return dipToPx(f, 0.0f);
    }

    public static float dipToPx(double d, float f) {
        return dipToPx((float) d, f);
    }

    public static float dipToPx(double d) {
        return dipToPx(d, 0.0f);
    }

    public static float pxToDip(float f) {
        return f / DisplayMetricsHolder.getScreenDisplayMetrics().density;
    }
}
