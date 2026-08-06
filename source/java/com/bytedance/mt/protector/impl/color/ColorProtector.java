package com.bytedance.mt.protector.impl.color;

import android.graphics.Color;
import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.impl.ProtectorMethod;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ColorProtector extends BaseColorProtector {
    @ProtectorMethod(exceptions = {IllegalArgumentException.class})
    public static int parseColor(String str) {
        if (Protector.enable()) {
            try {
                return Color.parseColor(str);
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num == null) {
                    throw th;
                }
                return num.intValue();
            }
        }
        return Color.parseColor(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void RGBToHSV(int i, int i2, int i3, float[] fArr) {
        if (Protector.enable()) {
            try {
                Color.RGBToHSV(i, i2, i3, fArr);
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.CAST_COLOR, th) == null) {
                    throw th;
                }
                return;
            }
        }
        Color.RGBToHSV(i, i2, i3, fArr);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static int HSVToColor(int i, float[] fArr) {
        if (Protector.enable()) {
            try {
                return Color.HSVToColor(i, fArr);
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num == null) {
                    throw th;
                }
                return num.intValue();
            }
        }
        return Color.HSVToColor(i, fArr);
    }
}
