package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.impl.ProtectorMethod;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CastFloatProtector extends BaseNumberProtector<Float> {
    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Float valueOf(String str) {
        if (Protector.enable()) {
            try {
                return Float.valueOf(str);
            } catch (Throwable th) {
                Float f = (Float) tryProtect(th, Float.class);
                if (f != null) {
                    return f;
                }
                throw th;
            }
        }
        return Float.valueOf(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static float parseFloat(String str) {
        if (Protector.enable()) {
            try {
                return Float.parseFloat(str);
            } catch (Throwable th) {
                Float f = (Float) tryProtect(th, Float.class);
                if (f == null) {
                    throw th;
                }
                return f.floatValue();
            }
        }
        return Float.parseFloat(str);
    }
}
