package com.ttnet.org.chromium.base;

/* loaded from: classes7.dex */
public class MathUtils {
    public static final float EPSILON = 0.001f;

    public static float clamp(float f, float f2, float f3) {
        float f4 = f2 > f3 ? f3 : f2;
        if (f2 <= f3) {
            f2 = f3;
        }
        return f < f4 ? f4 : f > f2 ? f2 : f;
    }

    public static int clamp(int i, int i2, int i3) {
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        return i < i4 ? i4 : i > i2 ? i2 : i;
    }

    public static long clamp(long j, long j2, long j3) {
        long j4 = j2 > j3 ? j3 : j2;
        if (j2 <= j3) {
            j2 = j3;
        }
        return j < j4 ? j4 : j > j2 ? j2 : j;
    }

    public static int compareLongs(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static float flipSignIf(float f, boolean z) {
        return z ? -f : f;
    }

    public static int flipSignIf(int i, boolean z) {
        return z ? -i : i;
    }

    public static float interpolate(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public static float map(float f, float f2, float f3, float f4, float f5) {
        return f4 + ((f5 - f4) * ((f - f2) / (f3 - f2)));
    }

    public static float smoothstep(float f) {
        return f * f * (3.0f - (f * 2.0f));
    }

    private MathUtils() {
    }

    public static int positiveModulo(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static float scaleToFitTargetSize(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        if (iArr.length < 2 || (i3 = iArr[0]) <= 0 || (i4 = iArr[1]) <= 0) {
            throw new IllegalArgumentException("Expected dimensions to have length >= 2 && dimensions[0] > 0 && dimensions[1] > 0");
        }
        float max = Math.max(i / i3, i2 / i4);
        iArr[0] = (int) (iArr[0] * max);
        iArr[1] = (int) (iArr[1] * max);
        return max;
    }

    public static boolean areFloatsEqual(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public static float distance(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public static double roundTwoDecimalPlaces(double d) {
        return Math.round(d * 100.0d) / 100.0d;
    }
}
