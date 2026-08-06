package com.facebook.imagepipeline.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import com.ss.ttm.player.MediaPlayer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes6.dex */
public final class BlurHashDecoder {
    private static final Map charMap;
    private static List<Character> testList;
    private final SparseArray<double[]> cacheCosinesX = new SparseArray<>();
    private final SparseArray<double[]> cacheCosinesY = new SparseArray<>();

    private float coerceIn(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    static {
        List<Character> asList = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_LT), 'M', 'N', 'O', 'P', 'Q', Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_REGULAR), 'S', 'T', Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_UT), 'V', 'W', 'X', 'Y', Character.valueOf(Matrix.MATRIX_TYPE_ZERO), 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), 'v', 'w', 'x', 'y', 'z', '#', Character.valueOf(Typography.dollar), '%', '*', '+', ',', '-', '.', Character.valueOf(AbstractJsonLexerKt.COLON), ';', '=', '?', '@', Character.valueOf(AbstractJsonLexerKt.BEGIN_LIST), Character.valueOf(AbstractJsonLexerKt.END_LIST), '^', '_', Character.valueOf(AbstractJsonLexerKt.BEGIN_OBJ), '|', Character.valueOf(AbstractJsonLexerKt.END_OBJ), '~');
        testList = asList;
        charMap = convertListBeforeJava8(asList);
    }

    public static Map<Character, Integer> convertListBeforeJava8(List<Character> list) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i), Integer.valueOf(i));
        }
        return hashMap;
    }

    public void clearCache() {
        this.cacheCosinesX.clear();
        this.cacheCosinesY.clear();
    }

    public Bitmap decode(String str, int i, int i2, float f, boolean z) {
        if (str == null || str.length() < 6) {
            return null;
        }
        int decode83 = decode83(str, 0, 1);
        int i3 = (decode83 % 9) + 1;
        int i4 = (decode83 / 9) + 1;
        if (str.length() != (i3 * 2 * i4) + 4) {
            return null;
        }
        float decode832 = (decode83(str, 1, 2) + 1) / 166.0f;
        int i5 = i3 * i4;
        float[][] fArr = new float[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 == 0) {
                fArr[i6] = decodeDc(decode83(str, 2, 6));
            } else {
                int i7 = (i6 * 2) + 4;
                fArr[i6] = decodeAc(decode83(str, i7, i7 + 2), decode832 * f);
            }
        }
        return composeBitmap(i, i2, i3, i4, fArr, z);
    }

    private int decode83(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            Integer num = (Integer) charMap.get(Character.valueOf(str.charAt(i)));
            int intValue = num != null ? num.intValue() : -1;
            if (intValue != -1) {
                i3 = (i3 * 83) + intValue;
            }
            i++;
        }
        return i3;
    }

    private float[] decodeDc(int i) {
        return new float[]{srgbToLinear(i >> 16), srgbToLinear((i >> 8) & 255), srgbToLinear(i & 255)};
    }

    private float srgbToLinear(int i) {
        float f = i / 255.0f;
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private float[] decodeAc(int i, float f) {
        return new float[]{signedPow2(((i / MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL) - 9) / 9.0f) * f, signedPow2((((i / 19) % 19) - 9) / 9.0f) * f, signedPow2(((i % 19) - 9) / 9.0f) * f};
    }

    private static float signedPow2(float f) {
        return Math.copySign((float) Math.pow(f, 2.0d), f);
    }

    private Bitmap composeBitmap(int i, int i2, int i3, int i4, float[][] fArr, boolean z) {
        int[] iArr = new int[i * i2];
        boolean z2 = !z || this.cacheCosinesX.get(i2 * i4) == null;
        double[] arrayForCosinesX = getArrayForCosinesX(z2, i, i3);
        boolean z3 = !z || this.cacheCosinesY.get(i2 * i4) == null;
        double[] arrayForCosinesY = getArrayForCosinesY(z3, i2, i4);
        if (arrayForCosinesX == null || arrayForCosinesY == null) {
            return null;
        }
        int i5 = 0;
        while (i5 < i2) {
            int i6 = 0;
            while (i6 < i) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                int i7 = 0;
                while (i7 < i4) {
                    float f4 = f;
                    float f5 = f2;
                    float f6 = f3;
                    int i8 = 0;
                    while (i8 < i3) {
                        int i9 = i8;
                        int i10 = i7;
                        int i11 = i6;
                        boolean z4 = z3;
                        i5 = i5;
                        float cos = (float) (getCos(arrayForCosinesY, z4, i10, i4, i5, i2) * getCos(arrayForCosinesX, z2, i9, i3, i11, i));
                        float[] fArr2 = fArr[(i10 * i3) + i9];
                        f4 += fArr2[0] * cos;
                        f5 += fArr2[1] * cos;
                        f6 += fArr2[2] * cos;
                        i8 = i9 + 1;
                        i7 = i10;
                        i6 = i11;
                        z3 = z4;
                    }
                    i7++;
                    f = f4;
                    f2 = f5;
                    f3 = f6;
                }
                int i12 = i6;
                iArr[i12 + (i * i5)] = Color.rgb(linearToSrgb(f), linearToSrgb(f2), linearToSrgb(f3));
                i6 = i12 + 1;
            }
            i5++;
        }
        return Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
    }

    private double[] getArrayForCosinesY(boolean z, int i, int i2) {
        if (z) {
            int i3 = i * i2;
            double[] dArr = new double[i3];
            this.cacheCosinesY.put(i3, dArr);
            return dArr;
        }
        double[] dArr2 = this.cacheCosinesY.get(i * i2);
        if (dArr2 != null) {
            return dArr2;
        }
        return null;
    }

    private double[] getArrayForCosinesX(boolean z, int i, int i2) {
        if (z) {
            int i3 = i * i2;
            double[] dArr = new double[i3];
            this.cacheCosinesX.put(i3, dArr);
            return dArr;
        }
        double[] dArr2 = this.cacheCosinesX.get(i * i2);
        if (dArr2 != null) {
            return dArr2;
        }
        return null;
    }

    private double getCos(double[] dArr, boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            dArr[(i2 * i3) + i] = Math.cos(((i3 * 3.141592653589793d) * i) / i4);
        }
        return dArr[i + (i2 * i3)];
    }

    private int linearToSrgb(float f) {
        float coerceIn = coerceIn(f, 0.0f, 1.0f);
        return coerceIn <= 0.0031308f ? (int) ((coerceIn * 12.92f * 255.0f) + 0.5f) : (int) ((((Math.pow(coerceIn, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d) * 255.0d) + 0.5d);
    }
}
