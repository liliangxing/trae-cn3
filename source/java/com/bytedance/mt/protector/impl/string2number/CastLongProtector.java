package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CastLongProtector extends BaseNumberProtector<Long> {
    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Long valueOf(String str) {
        if (Protector.enable()) {
            try {
                return Long.valueOf(str);
            } catch (Throwable th) {
                Long l = (Long) tryProtect(th, Long.class);
                if (l != null) {
                    return l;
                }
                throw th;
            }
        }
        return Long.valueOf(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Long valueOf(String str, int i) {
        if (Protector.enable()) {
            try {
                return Long.valueOf(str, i);
            } catch (Throwable th) {
                Long l = (Long) tryProtect(th, Long.class);
                if (l != null) {
                    return l;
                }
                throw th;
            }
        }
        return Long.valueOf(str, i);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseLong(String str) {
        if (Protector.enable()) {
            try {
                return Long.parseLong(str);
            } catch (Throwable th) {
                Long l = (Long) tryProtect(th, Long.class);
                if (l == null) {
                    throw th;
                }
                return l.longValue();
            }
        }
        return Long.parseLong(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseLong(String str, int i) {
        if (Protector.enable()) {
            try {
                return Long.parseLong(str, i);
            } catch (Throwable th) {
                Long l = (Long) tryProtect(th, Long.class);
                if (l == null) {
                    throw th;
                }
                return l.longValue();
            }
        }
        return Long.parseLong(str, i);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseUnsignedLong(String str) {
        if (Protector.enable()) {
            try {
                return UByte$.ExternalSyntheticBackport0.m(str);
            } catch (Throwable th) {
                Long l = (Long) tryProtect(th, Long.class);
                if (l == null) {
                    throw th;
                }
                return l.longValue();
            }
        }
        return UByte$.ExternalSyntheticBackport0.m$1(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseUnsignedLong(String str, int i) {
        if (Protector.enable()) {
            try {
                return UByte$.ExternalSyntheticBackport0.m$2(str, i);
            } catch (Throwable th) {
                Long l = (Long) tryProtect(th, Long.class);
                if (l == null) {
                    throw th;
                }
                return l.longValue();
            }
        }
        return UByte$.ExternalSyntheticBackport0.m$3(str, i);
    }
}
