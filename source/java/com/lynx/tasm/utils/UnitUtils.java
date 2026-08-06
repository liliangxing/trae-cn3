package com.lynx.tasm.utils;

import android.util.DisplayMetrics;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.utils.Value;
import io.noties.markwon.image.CustomImageSizeResolverDef;

/* loaded from: classes7.dex */
public class UnitUtils {
    public static boolean isPercentage(String str) {
        return str.endsWith(CustomImageSizeResolverDef.UNIT_PERCENT);
    }

    @Deprecated
    public static float toPx(String str) {
        return toPx(str, 0.0f);
    }

    @Deprecated
    public static float toPx(String str, float f) {
        return toPx(str, 0.0f, 0.0f, 0.0f, 0.0f, f);
    }

    public static float toPx(String str, float f, float f2, float f3, float f4) {
        return toPxWithDisplayMetrics(str, f, f2, f3, f4, 0.0f, DisplayMetricsHolder.getScreenDisplayMetrics());
    }

    public static float toPxWithDisplayMetrics(String str, float f, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        return toPxWithDisplayMetrics(str, f, f2, f3, f4, 0.0f, displayMetrics);
    }

    public static float toPx(String str, float f, float f2, float f3, float f4, float f5) {
        return toPxWithDisplayMetrics(str, f, f2, f3, f4, f5, DisplayMetricsHolder.getScreenDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [float] */
    /* JADX WARN: Type inference failed for: r6v11, types: [float] */
    /* JADX WARN: Type inference failed for: r6v12, types: [float] */
    /* JADX WARN: Type inference failed for: r6v13, types: [float] */
    /* JADX WARN: Type inference failed for: r6v3, types: [float] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [float] */
    public static float toPxWithDisplayMetrics(String str, float f, float f2, float f3, float f4, float f5, DisplayMetrics displayMetrics) {
        int length = android.text.TextUtils.isEmpty(str) ? 0 : str.length();
        if (length > 3) {
            try {
            } catch (Throwable unused) {
                LLog.w("lynx", "Number parse error from value = " + str + " to px!");
            }
            if (str.endsWith("rpx")) {
                str = displayMetrics.widthPixels * Float.parseFloat(str.substring(0, length - 3));
                f5 = str / 750.0f;
                return f5;
            }
        }
        if (length > 3 && str.endsWith("ppx")) {
            f5 = Float.parseFloat(str.substring(0, length - 3));
        } else if (length > 2 && str.endsWith("px")) {
            f5 = PixelUtils.dipToPx(Float.parseFloat(str.substring(0, length - 2)));
        } else if (length > 1 && str.endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
            str = Float.parseFloat(str.substring(0, length - 1));
            f5 = str / 100.0f;
        } else if (length > 3 && str.endsWith("rem")) {
            str = Float.parseFloat(str.substring(0, length - 3));
            f5 = f * str;
        } else if (length > 2 && str.endsWith(CustomImageSizeResolverDef.UNIT_EM)) {
            str = Float.parseFloat(str.substring(0, length - 2));
            f5 = f2 * str;
        } else if (length > 2 && str.endsWith("vw")) {
            str = Float.parseFloat(str.substring(0, length - 2));
            f5 = (f3 * str) / 100.0f;
        } else if (length > 2 && str.endsWith("vh")) {
            str = Float.parseFloat(str.substring(0, length - 2));
            f5 = (f4 * str) / 100.0f;
        } else if (length > 0) {
            f5 = Float.parseFloat(str);
        }
        return f5;
    }

    public static float toPx(String str, float f, float f2, float f3, float f4, float f5, float f6) {
        return toPxWithDisplayMetrics(str, f, f2, f3, f4, f5, f6, DisplayMetricsHolder.getScreenDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static float toPxWithDisplayMetrics(String str, float f, float f2, float f3, float f4, float f5, float f6, DisplayMetrics displayMetrics) {
        int length = android.text.TextUtils.isEmpty(str) ? 0 : str.length();
        if (length > 1) {
            try {
                if (str.endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
                    str = (Float.parseFloat(str.substring(0, length - 1)) * f5) / 100.0f;
                    f6 = str;
                    return f6;
                }
            } catch (Throwable unused) {
                LLog.w("lynx", "Number parse error from value = " + str + " to px!");
                return f6;
            }
        }
        str = toPxWithDisplayMetrics(str, f, f2, f3, f4, f6, displayMetrics);
        f6 = str;
        return f6;
    }

    public static float toPx(String str, float f, float f2) {
        return toPxWithDisplayMetrics(str, f, f2, DisplayMetricsHolder.getScreenDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static float toPxWithDisplayMetrics(String str, float f, float f2, DisplayMetrics displayMetrics) {
        int length = android.text.TextUtils.isEmpty(str) ? 0 : str.length();
        if (length > 1) {
            try {
                if (str.endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
                    str = (Float.parseFloat(str.substring(0, length - 1)) * f) / 100.0f;
                    f2 = str;
                    return f2;
                }
            } catch (Throwable unused) {
                LLog.w("lynx", "Number parse error from value = " + str + " to px!");
                return f2;
            }
        }
        str = toPxWithDisplayMetrics(str, 0.0f, 0.0f, 0.0f, 0.0f, f2, displayMetrics);
        f2 = str;
        return f2;
    }

    public static Value parserValue(String str, LynxBaseUI lynxBaseUI) {
        if (android.text.TextUtils.isEmpty(str) || lynxBaseUI == null) {
            return null;
        }
        float pxWithDisplayMetrics = toPxWithDisplayMetrics(str, lynxBaseUI.getLynxContext().getUIBody().getFontSize(), lynxBaseUI.getFontSize(), r0.getWidth(), r0.getHeight(), 1.0E21f, lynxBaseUI.getLynxContext().getScreenMetrics());
        if (MeasureUtils.isUndefined(pxWithDisplayMetrics)) {
            return null;
        }
        if (str.endsWith(CustomImageSizeResolverDef.UNIT_PERCENT)) {
            return new Value(pxWithDisplayMetrics, Value.Unit.PERCENTAGE);
        }
        return new Value(pxWithDisplayMetrics, Value.Unit.PX);
    }

    public static <T extends Comparable<T>> T clamp(T t, T t2, T t3) {
        return t.compareTo(t2) < 0 ? t2 : t.compareTo(t3) > 0 ? t3 : t;
    }
}
