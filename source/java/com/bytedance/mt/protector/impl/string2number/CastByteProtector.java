package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.impl.ProtectorMethod;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CastByteProtector extends BaseNumberProtector<Byte> {
    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Byte valueOf(String str) {
        if (Protector.enable()) {
            try {
                return Byte.valueOf(str);
            } catch (Throwable th) {
                Byte b = (Byte) tryProtect(th, Byte.class);
                if (b != null) {
                    return b;
                }
                throw th;
            }
        }
        return Byte.valueOf(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Byte valueOf(String str, int i) {
        if (Protector.enable()) {
            try {
                return Byte.valueOf(str, i);
            } catch (Throwable th) {
                Byte b = (Byte) tryProtect(th, Byte.class);
                if (b != null) {
                    return b;
                }
                throw th;
            }
        }
        return Byte.valueOf(str, i);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static byte parseByte(String str) {
        if (Protector.enable()) {
            try {
                return Byte.parseByte(str);
            } catch (Throwable th) {
                Byte b = (Byte) tryProtect(th, Byte.class);
                if (b == null) {
                    throw th;
                }
                return b.byteValue();
            }
        }
        return Byte.parseByte(str);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static byte parseByte(String str, int i) {
        if (Protector.enable()) {
            try {
                return Byte.parseByte(str, i);
            } catch (Throwable th) {
                Byte b = (Byte) tryProtect(th, Byte.class);
                if (b == null) {
                    throw th;
                }
                return b.byteValue();
            }
        }
        return Byte.parseByte(str, i);
    }
}
