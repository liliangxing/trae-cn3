package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.impl.ProtectorMethod;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CastShortProtector extends BaseNumberProtector<Short> {
    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Short valueOf(String str) {
        if (Protector.enable()) {
            try {
                return Short.valueOf(str);
            } catch (Throwable th) {
                Short sh = (Short) tryProtect(th, Short.class);
                if (sh != null) {
                    return sh;
                }
                throw th;
            }
        }
        return Short.valueOf(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Short valueOf(String str, int i) {
        if (Protector.enable()) {
            try {
                return Short.valueOf(str, i);
            } catch (Throwable th) {
                Short sh = (Short) tryProtect(th, Short.class);
                if (sh != null) {
                    return sh;
                }
                throw th;
            }
        }
        return Short.valueOf(str, i);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static short parseShort(String str) {
        if (Protector.enable()) {
            try {
                return Short.parseShort(str);
            } catch (Throwable th) {
                Short sh = (Short) tryProtect(th, Short.class);
                if (sh == null) {
                    throw th;
                }
                return sh.shortValue();
            }
        }
        return Short.parseShort(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static short parseShort(String str, int i) {
        if (Protector.enable()) {
            try {
                return Short.parseShort(str, i);
            } catch (Throwable th) {
                Short sh = (Short) tryProtect(th, Short.class);
                if (sh == null) {
                    throw th;
                }
                return sh.shortValue();
            }
        }
        return Short.parseShort(str, i);
    }
}
