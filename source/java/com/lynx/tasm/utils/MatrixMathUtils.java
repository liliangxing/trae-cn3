package com.lynx.tasm.utils;

import com.lynx.tasm.base.LLog;
import java.lang.reflect.Array;

/* loaded from: classes7.dex */
public class MatrixMathUtils {
    private static final double EPSILON = 1.0E-5d;
    private static double[][] reusableMatrix = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 4, 4);
    private static double[] reusablePerspectiveMatrix = new double[16];
    private static double[][] reusableRow = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 3, 3);

    public static double degreesToRadians(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    /* loaded from: classes7.dex */
    public static class MatrixDecompositionContext {
        public double[] perspective = new double[4];
        public double[] scale = new double[3];
        public double[] skew = new double[3];
        public double[] translation = new double[3];
        public double[] rotationDegrees = new double[3];

        private static void resetArray(double[] dArr) {
            for (int i = 0; i < dArr.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        public void reset() {
            resetArray(this.perspective);
            resetArray(this.scale);
            resetArray(this.skew);
            resetArray(this.translation);
            resetArray(this.rotationDegrees);
        }

        public float getTranslationX() {
            return (float) this.translation[0];
        }

        public float getTranslationY() {
            return (float) this.translation[1];
        }

        public float getTranslationZ() {
            return (float) this.translation[2];
        }

        public float getRotationX() {
            return (float) this.rotationDegrees[0];
        }

        public float getRotationY() {
            return (float) this.rotationDegrees[1];
        }

        public float getRotation() {
            return (float) this.rotationDegrees[2];
        }

        public float getScaleX() {
            return (float) this.scale[0];
        }

        public float getScaleY() {
            return (float) this.scale[1];
        }

        public float getSkewX() {
            return (float) this.skew[0];
        }

        public float getSkewY() {
            return (float) this.skew[1];
        }
    }

    private static boolean isZero(double d) {
        return !Double.isNaN(d) && Math.abs(d) < 1.0E-5d;
    }

    private static boolean isMatrix3D(double[] dArr) {
        return dArr.length >= 16;
    }

    private static double determinant(double[] dArr) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double d5 = dArr[4];
        double d6 = dArr[5];
        double d7 = dArr[6];
        double d8 = dArr[7];
        double d9 = dArr[8];
        double d10 = dArr[9];
        double d11 = dArr[10];
        double d12 = dArr[11];
        double d13 = dArr[12];
        double d14 = dArr[13];
        double d15 = dArr[14];
        double d16 = dArr[15];
        double d17 = d4 * d7;
        double d18 = d3 * d8;
        double d19 = d4 * d6;
        double d20 = d2 * d8;
        double d21 = d3 * d6;
        double d22 = d2 * d7;
        double d23 = d4 * d5;
        double d24 = d8 * d;
        double d25 = d3 * d5;
        double d26 = d7 * d;
        double d27 = d2 * d5;
        double d28 = d * d6;
        return ((((((((((((((((((((((((d17 * d10) * d13) - ((d18 * d10) * d13)) - ((d19 * d11) * d13)) + ((d20 * d11) * d13)) + ((d21 * d12) * d13)) - ((d22 * d12) * d13)) - ((d17 * d9) * d14)) + ((d18 * d9) * d14)) + ((d23 * d11) * d14)) - ((d24 * d11) * d14)) - ((d25 * d12) * d14)) + ((d26 * d12) * d14)) + ((d19 * d9) * d15)) - ((d20 * d9) * d15)) - ((d23 * d10) * d15)) + ((d24 * d10) * d15)) + ((d27 * d12) * d15)) - ((d12 * d28) * d15)) - ((d21 * d9) * d16)) + ((d22 * d9) * d16)) + ((d25 * d10) * d16)) - ((d26 * d10) * d16)) - ((d27 * d11) * d16)) + (d28 * d11 * d16);
    }

    private static double[] inverse(double[] dArr) {
        double determinant = determinant(dArr);
        if (isZero(determinant)) {
            return dArr;
        }
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double d5 = dArr[4];
        double d6 = dArr[5];
        double d7 = dArr[6];
        double d8 = dArr[7];
        double d9 = dArr[8];
        double d10 = dArr[9];
        double d11 = dArr[10];
        double d12 = dArr[11];
        double d13 = dArr[12];
        double d14 = dArr[13];
        double d15 = dArr[14];
        double d16 = dArr[15];
        double d17 = d7 * d12;
        double d18 = d8 * d11;
        double d19 = d8 * d10;
        double d20 = d6 * d12;
        double d21 = d7 * d10;
        double d22 = ((((d17 * d14) - (d18 * d14)) + (d19 * d15)) - (d20 * d15)) - (d21 * d16);
        double d23 = d6 * d11;
        double d24 = d4 * d11;
        double d25 = d3 * d12;
        double d26 = d4 * d10;
        double d27 = d2 * d12;
        double d28 = d3 * d10;
        double d29 = (((d24 * d14) - (d25 * d14)) - (d26 * d15)) + (d27 * d15) + (d28 * d16);
        double d30 = d2 * d11;
        double d31 = d3 * d8;
        double d32 = d4 * d7;
        double d33 = d4 * d6;
        double d34 = d2 * d8;
        double d35 = d3 * d6;
        double d36 = d2 * d7;
        double d37 = (d18 * d13) - (d17 * d13);
        double d38 = d8 * d9;
        double d39 = d5 * d12;
        double d40 = d7 * d9;
        double d41 = (d37 - (d38 * d15)) + (d39 * d15) + (d40 * d16);
        double d42 = d5 * d11;
        double d43 = (d25 * d13) - (d24 * d13);
        double d44 = d4 * d9;
        double d45 = d * d12;
        double d46 = d3 * d9;
        double d47 = d * d11;
        double d48 = d4 * d5;
        double d49 = d8 * d;
        double d50 = d3 * d5;
        double d51 = d7 * d;
        double d52 = d6 * d9;
        double d53 = ((((d20 * d13) - (d19 * d13)) + (d38 * d14)) - (d39 * d14)) - (d52 * d16);
        double d54 = d5 * d10;
        double d55 = d2 * d9;
        double d56 = d * d10;
        double d57 = d2 * d5;
        double d58 = d * d6;
        return new double[]{(d22 + (d23 * d16)) / determinant, (d29 - (d30 * d16)) / determinant, ((((((d31 * d14) - (d32 * d14)) + (d33 * d15)) - (d34 * d15)) - (d35 * d16)) + (d36 * d16)) / determinant, ((((((d32 * d10) - (d31 * d10)) - (d33 * d11)) + (d34 * d11)) + (d35 * d12)) - (d36 * d12)) / determinant, (d41 - (d42 * d16)) / determinant, ((((d43 + (d44 * d15)) - (d45 * d15)) - (d46 * d16)) + (d47 * d16)) / determinant, ((((((d32 * d13) - (d31 * d13)) - (d48 * d15)) + (d49 * d15)) + (d50 * d16)) - (d51 * d16)) / determinant, ((((((d31 * d9) - (d32 * d9)) + (d48 * d11)) - (d49 * d11)) - (d50 * d12)) + (d51 * d12)) / determinant, (d53 + (d54 * d16)) / determinant, ((((((d26 * d13) - (d27 * d13)) - (d44 * d14)) + (d45 * d14)) + (d55 * d16)) - (d56 * d16)) / determinant, ((((((d34 * d13) - (d33 * d13)) + (d48 * d14)) - (d49 * d14)) - (d57 * d16)) + (d16 * d58)) / determinant, ((((((d33 * d9) - (d34 * d9)) - (d48 * d10)) + (d49 * d10)) + (d57 * d12)) - (d12 * d58)) / determinant, ((((((d21 * d13) - (d23 * d13)) - (d40 * d14)) + (d42 * d14)) + (d52 * d15)) - (d54 * d15)) / determinant, ((((((d30 * d13) - (d28 * d13)) + (d46 * d14)) - (d47 * d14)) - (d55 * d15)) + (d56 * d15)) / determinant, ((((((d35 * d13) - (d13 * d36)) - (d50 * d14)) + (d14 * d51)) + (d57 * d15)) - (d15 * d58)) / determinant, ((((((d36 * d9) - (d35 * d9)) + (d50 * d10)) - (d51 * d10)) - (d57 * d11)) + (d58 * d11)) / determinant};
    }

    private static double[] transpose(double[] dArr) {
        return new double[]{dArr[0], dArr[4], dArr[8], dArr[12], dArr[1], dArr[5], dArr[9], dArr[13], dArr[2], dArr[6], dArr[10], dArr[14], dArr[3], dArr[7], dArr[11], dArr[15]};
    }

    private static void multiplyVectorByMatrix(double[] dArr, double[] dArr2, double[] dArr3) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        dArr3[0] = (dArr2[0] * d) + (dArr2[4] * d2) + (dArr2[8] * d3) + (dArr2[12] * d4);
        dArr3[1] = (dArr2[1] * d) + (dArr2[5] * d2) + (dArr2[9] * d3) + (dArr2[13] * d4);
        dArr3[2] = (dArr2[2] * d) + (dArr2[6] * d2) + (dArr2[10] * d3) + (dArr2[14] * d4);
        dArr3[3] = (d * dArr2[3]) + (d2 * dArr2[7]) + (d3 * dArr2[11]) + (d4 * dArr2[15]);
    }

    private static double v3Length(double[] dArr) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = (d * d) + (d2 * d2);
        double d4 = dArr[2];
        return Math.sqrt(d3 + (d4 * d4));
    }

    private static double[] v3Normalize(double[] dArr, double d) {
        if (isZero(d)) {
            d = v3Length(dArr);
        }
        double d2 = 1.0d / d;
        return new double[]{dArr[0] * d2, dArr[1] * d2, dArr[2] * d2};
    }

    private static double v3Dot(double[] dArr, double[] dArr2) {
        return (dArr[0] * dArr2[0]) + (dArr[1] * dArr2[1]) + (dArr[2] * dArr2[2]);
    }

    private static double[] v3Combine(double[] dArr, double[] dArr2, double d, double d2) {
        return new double[]{(dArr[0] * d) + (dArr2[0] * d2), (dArr[1] * d) + (dArr2[1] * d2), (d * dArr[2]) + (d2 * dArr2[2])};
    }

    private static double[] v3Cross(double[] dArr, double[] dArr2) {
        double d = dArr[1];
        double d2 = dArr2[2];
        double d3 = dArr[2];
        double d4 = dArr2[0];
        double d5 = dArr[0];
        return new double[]{(d * d2) - (dArr2[1] * d3), (d3 * d4) - (d2 * d5), (d5 * dArr2[1]) - (dArr[1] * d4)};
    }

    private static double roundTo3Places(double d) {
        return Math.round(d * 1000.0d) * 0.001d;
    }

    public static void decomposeMatrix(double[] dArr, MatrixDecompositionContext matrixDecompositionContext) {
        if (!isMatrix3D(dArr)) {
            LLog.e("lynx", "Decompose transform matrix error! transformMatrix's length less than 16!");
            return;
        }
        double[] dArr2 = matrixDecompositionContext.perspective;
        double[] dArr3 = matrixDecompositionContext.scale;
        double[] dArr4 = matrixDecompositionContext.skew;
        double[] dArr5 = matrixDecompositionContext.translation;
        double[] dArr6 = matrixDecompositionContext.rotationDegrees;
        if (isZero(dArr[15])) {
            return;
        }
        double[][] dArr7 = reusableMatrix;
        double[] dArr8 = reusablePerspectiveMatrix;
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = (i * 4) + i2;
                double d = dArr[i3] / dArr[15];
                dArr7[i][i2] = d;
                if (i2 == 3) {
                    d = 0.0d;
                }
                dArr8[i3] = d;
            }
        }
        dArr8[15] = 1.0d;
        if (isZero(determinant(dArr8))) {
            return;
        }
        if (!isZero(dArr7[0][3]) || !isZero(dArr7[1][3]) || !isZero(dArr7[2][3])) {
            multiplyVectorByMatrix(new double[]{dArr7[0][3], dArr7[1][3], dArr7[2][3], dArr7[3][3]}, transpose(inverse(dArr8)), dArr2);
        } else {
            dArr2[2] = 0.0d;
            dArr2[1] = 0.0d;
            dArr2[0] = 0.0d;
            dArr2[3] = 1.0d;
        }
        for (int i4 = 0; i4 < 3; i4++) {
            dArr5[i4] = dArr7[3][i4];
        }
        double[][] dArr9 = reusableRow;
        for (int i5 = 0; i5 < 3; i5++) {
            double[] dArr10 = dArr9[i5];
            double[] dArr11 = dArr7[i5];
            dArr10[0] = dArr11[0];
            dArr10[1] = dArr11[1];
            dArr10[2] = dArr11[2];
        }
        double v3Length = v3Length(dArr9[0]);
        dArr3[0] = v3Length;
        double[] v3Normalize = v3Normalize(dArr9[0], v3Length);
        dArr9[0] = v3Normalize;
        double v3Dot = v3Dot(v3Normalize, dArr9[1]);
        dArr4[0] = v3Dot;
        double[] v3Combine = v3Combine(dArr9[1], dArr9[0], 1.0d, -v3Dot);
        dArr9[1] = v3Combine;
        double v3Length2 = v3Length(v3Combine);
        dArr3[1] = v3Length2;
        dArr9[1] = v3Normalize(dArr9[1], v3Length2);
        dArr4[0] = dArr4[0] / dArr3[1];
        double v3Dot2 = v3Dot(dArr9[0], dArr9[2]);
        dArr4[1] = v3Dot2;
        double[] v3Combine2 = v3Combine(dArr9[2], dArr9[0], 1.0d, -v3Dot2);
        dArr9[2] = v3Combine2;
        double v3Dot3 = v3Dot(dArr9[1], v3Combine2);
        dArr4[2] = v3Dot3;
        double[] v3Combine3 = v3Combine(dArr9[2], dArr9[1], 1.0d, -v3Dot3);
        dArr9[2] = v3Combine3;
        double v3Length3 = v3Length(v3Combine3);
        dArr3[2] = v3Length3;
        double[] v3Normalize2 = v3Normalize(dArr9[2], v3Length3);
        dArr9[2] = v3Normalize2;
        double d2 = dArr4[1];
        double d3 = dArr3[2];
        dArr4[1] = d2 / d3;
        dArr4[2] = dArr4[2] / d3;
        if (v3Dot(dArr9[0], v3Cross(dArr9[1], v3Normalize2)) < 0.0d) {
            for (int i6 = 0; i6 < 3; i6++) {
                dArr3[i6] = dArr3[i6] * (-1.0d);
                double[] dArr12 = dArr9[i6];
                dArr12[0] = dArr12[0] * (-1.0d);
                dArr12[1] = dArr12[1] * (-1.0d);
                dArr12[2] = dArr12[2] * (-1.0d);
            }
        }
        double[] dArr13 = dArr9[2];
        dArr6[0] = roundTo3Places((-Math.atan2(dArr13[1], dArr13[2])) * 57.29577951308232d);
        double[] dArr14 = dArr9[2];
        double d4 = -dArr14[0];
        double d5 = dArr14[1];
        double d6 = dArr14[2];
        dArr6[1] = roundTo3Places((-Math.atan2(d4, Math.sqrt((d5 * d5) + (d6 * d6)))) * 57.29577951308232d);
        dArr6[2] = roundTo3Places((-Math.atan2(dArr9[1][0], dArr9[0][0])) * 57.29577951308232d);
    }
}
