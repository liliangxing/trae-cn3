package com.bytedance.mt.protector.impl.color;

import android.graphics.Color;
import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ColorUtilsLancet extends BaseColorProtector {
    @TargetClass("androidx.core.graphics.ColorUtils")
    @Insert("calculateMinimumAlpha")
    public static int calculateMinimumAlpha(int i, int i2, float f) {
        if (Protector.enable()) {
            try {
                return ((Integer) Origin.call()).intValue();
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num == null) {
                    throw th;
                }
                return num.intValue();
            }
        }
        return ((Integer) Origin.call()).intValue();
    }

    @TargetClass("androidx.core.graphics.ColorUtils")
    @Insert("calculateContrast")
    public static double calculateContrast(int i, int i2) {
        if (Protector.enable()) {
            try {
                return ((Double) Origin.call()).doubleValue();
            } catch (Throwable th) {
                Double d = (Double) tryProtect(th, Double.class);
                if (d == null) {
                    throw th;
                }
                return d.doubleValue();
            }
        }
        return ((Double) Origin.call()).doubleValue();
    }

    @TargetClass("androidx.core.graphics.ColorUtils")
    @Insert("compositeColors")
    public static Color compositeColors(Color color, Color color2) {
        if (Protector.enable()) {
            try {
                return (Color) Origin.call();
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num == null) {
                    throw th;
                }
                return Color.valueOf(num.intValue());
            }
        }
        return (Color) Origin.call();
    }

    @TargetClass("androidx.core.graphics.ColorUtils")
    @Insert("RGBToXYZ")
    public static void RGBToXYZ(int i, int i2, int i3, double[] dArr) {
        if (Protector.enable()) {
            try {
                Origin.callVoid();
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.CAST_COLOR, th) == null) {
                    throw th;
                }
                return;
            }
        }
        Origin.callVoid();
    }

    @TargetClass("androidx.core.graphics.ColorUtils")
    @Insert("XYZToLAB")
    public static void XYZToLAB(double d, double d2, double d3, double[] dArr) {
        if (Protector.enable()) {
            try {
                Origin.callVoid();
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.CAST_COLOR, th) == null) {
                    throw th;
                }
                return;
            }
        }
        Origin.callVoid();
    }

    @TargetClass("androidx.core.graphics.ColorUtils")
    @Insert("blendHSL")
    public static void blendHSL(float[] fArr, float[] fArr2, float f, float[] fArr3) {
        if (Protector.enable()) {
            try {
                Origin.callVoid();
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.CAST_COLOR, th) == null) {
                    throw th;
                }
                return;
            }
        }
        Origin.callVoid();
    }

    @TargetClass("androidx.core.graphics.ColorUtils")
    @Insert("blendLAB")
    public static void blendLAB(double[] dArr, double[] dArr2, double d, double[] dArr3) {
        if (Protector.enable()) {
            try {
                Origin.callVoid();
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.CAST_COLOR, th) == null) {
                    throw th;
                }
                return;
            }
        }
        Origin.callVoid();
    }
}
