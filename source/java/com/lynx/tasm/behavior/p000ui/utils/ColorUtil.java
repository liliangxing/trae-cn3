package com.lynx.tasm.behavior.p000ui.utils;

import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ColorUtil {
    public static int getOpacityFromColor(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        return i2 == 0 ? -2 : -3;
    }

    public static int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & TypedValue.COMPLEX_MANTISSA_MASK;
        }
        return (i & TypedValue.COMPLEX_MANTISSA_MASK) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }
}
