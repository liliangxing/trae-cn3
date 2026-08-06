package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import androidx.core.view.InputDeviceCompat;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import io.noties.markwon.image.CustomImageSizeResolverDef;

/* loaded from: classes7.dex */
public class TypedValue {
    public static final int COMPLEX_MANTISSA_MASK = 16777215;
    public static final int COMPLEX_MANTISSA_SHIFT = 8;
    public static final int COMPLEX_RADIX_0p23 = 3;
    public static final int COMPLEX_RADIX_16p7 = 1;
    public static final int COMPLEX_RADIX_23p0 = 0;
    public static final int COMPLEX_RADIX_8p15 = 2;
    public static final int COMPLEX_RADIX_MASK = 3;
    public static final int COMPLEX_RADIX_SHIFT = 4;
    public static final int COMPLEX_UNIT_DIP = 1;
    public static final int COMPLEX_UNIT_FRACTION = 0;
    public static final int COMPLEX_UNIT_FRACTION_PARENT = 1;
    public static final int COMPLEX_UNIT_IN = 4;
    public static final int COMPLEX_UNIT_MASK = 15;
    public static final int COMPLEX_UNIT_MM = 5;
    public static final int COMPLEX_UNIT_PT = 3;
    public static final int COMPLEX_UNIT_PX = 0;
    public static final int COMPLEX_UNIT_SHIFT = 0;
    public static final int COMPLEX_UNIT_SP = 2;
    public static final int DATA_NULL_EMPTY = 1;
    public static final int DATA_NULL_UNDEFINED = 0;
    public static final int DENSITY_DEFAULT = 0;
    public static final int DENSITY_NONE = 65535;
    private static final float MANTISSA_MULT = 0.00390625f;
    public static final int TYPE_ATTRIBUTE = 2;
    public static final int TYPE_DIMENSION = 5;
    public static final int TYPE_DYNAMIC_ATTRIBUTE = 8;
    public static final int TYPE_DYNAMIC_REFERENCE = 7;
    public static final int TYPE_FIRST_COLOR_INT = 28;
    public static final int TYPE_FIRST_INT = 16;
    public static final int TYPE_FLOAT = 4;
    public static final int TYPE_FRACTION = 6;
    public static final int TYPE_INT_BOOLEAN = 18;
    public static final int TYPE_INT_COLOR_ARGB4 = 30;
    public static final int TYPE_INT_COLOR_ARGB8 = 28;
    public static final int TYPE_INT_COLOR_RGB4 = 31;
    public static final int TYPE_INT_COLOR_RGB8 = 29;
    public static final int TYPE_INT_DEC = 16;
    public static final int TYPE_INT_HEX = 17;
    public static final int TYPE_LAST_COLOR_INT = 31;
    public static final int TYPE_LAST_INT = 31;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_REFERENCE = 1;
    public static final int TYPE_STRING = 3;
    public int type;
    private static final float[] RADIX_MULTS = {0.00390625f, 3.0517578E-5f, 1.1920929E-7f, 4.656613E-10f};
    private static final String[] DIMENSION_UNIT_STRS = {"px", "dip", CloudControlInf.SP, "pt", "in", "mm"};
    private static final String[] FRACTION_UNIT_STRS = {CustomImageSizeResolverDef.UNIT_PERCENT, "%p"};

    public static float complexToFloat(int i) {
        return (i & InputDeviceCompat.SOURCE_ANY) * RADIX_MULTS[(i >> 4) & 3];
    }

    public static String coerceToString(int i, int i2) {
        if (i == 0) {
            return null;
        }
        if (i == 1) {
            return "@" + i2;
        }
        if (i == 2) {
            return "?" + i2;
        }
        if (i == 4) {
            return Float.toString(Float.intBitsToFloat(i2));
        }
        if (i == 5) {
            return complexToFloat(i2) + DIMENSION_UNIT_STRS[(i2 >> 0) & 15];
        }
        if (i == 6) {
            return (complexToFloat(i2) * 100.0f) + FRACTION_UNIT_STRS[(i2 >> 0) & 15];
        }
        if (i == 17) {
            return String.format("0x%08X", Integer.valueOf(i2));
        }
        if (i == 18) {
            return i2 != 0 ? RouterConstants.TRUE : "false";
        }
        if (i < 28 || i > 31) {
            if (i < 16 || i > 31 || i != 16) {
                return null;
            }
            return Integer.toString(i2);
        }
        String format = String.format("%08x", Integer.valueOf(i2));
        char[] charArray = format.toCharArray();
        switch (i) {
            case 29:
                format = format.substring(2);
                break;
            case 30:
                format = String.valueOf(charArray[0]) + charArray[2] + charArray[4] + charArray[6];
                break;
            case 31:
                format = String.valueOf(charArray[2]) + charArray[4] + charArray[6];
                break;
        }
        return "#" + format;
    }
}
