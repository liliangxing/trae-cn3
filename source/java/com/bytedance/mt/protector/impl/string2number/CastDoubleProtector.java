package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.impl.ProtectorMethod;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CastDoubleProtector extends BaseNumberProtector<Double> {
    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Double valueOf(String str) {
        if (Protector.enable()) {
            try {
                return Double.valueOf(str);
            } catch (Throwable th) {
                Double d = (Double) tryProtect(th, Double.class);
                if (d != null) {
                    return d;
                }
                throw th;
            }
        }
        return Double.valueOf(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static double parseDouble(String str) {
        if (Protector.enable()) {
            try {
                return Double.parseDouble(str);
            } catch (Throwable th) {
                Double d = (Double) tryProtect(th, Double.class);
                if (d == null) {
                    throw th;
                }
                return d.doubleValue();
            }
        }
        return Double.parseDouble(str);
    }
}
