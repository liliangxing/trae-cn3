package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CastIntegerProtector extends BaseNumberProtector<Integer> {
    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Integer valueOf(String str) {
        if (Protector.enable()) {
            try {
                return Integer.valueOf(str);
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num != null) {
                    return num;
                }
                throw th;
            }
        }
        return Integer.valueOf(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Integer valueOf(String str, int i) {
        if (Protector.enable()) {
            try {
                return Integer.valueOf(str, i);
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num != null) {
                    return num;
                }
                throw th;
            }
        }
        return Integer.valueOf(str, i);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseInt(String str) {
        if (Protector.enable()) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num == null) {
                    throw th;
                }
                return num.intValue();
            }
        }
        return Integer.parseInt(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseInt(String str, int i) {
        if (Protector.enable()) {
            try {
                return Integer.parseInt(str, i);
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num == null) {
                    throw th;
                }
                return num.intValue();
            }
        }
        return Integer.parseInt(str, i);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseUnsignedInt(String str) {
        if (Protector.enable()) {
            try {
                return UByte$.ExternalSyntheticBackport0.m(str);
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num == null) {
                    throw th;
                }
                return num.intValue();
            }
        }
        return UByte$.ExternalSyntheticBackport0.m(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseUnsignedInt(String str, int i) {
        if (Protector.enable()) {
            try {
                return UByte$.ExternalSyntheticBackport0.m(str, i);
            } catch (Throwable th) {
                Integer num = (Integer) tryProtect(th, Integer.class);
                if (num == null) {
                    throw th;
                }
                return num.intValue();
            }
        }
        return UByte$.ExternalSyntheticBackport0.m(str, i);
    }
}
