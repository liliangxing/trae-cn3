package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.ThrowableDisposerResult;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class EnumProtector {
    @ProtectorMethod(exceptions = {IllegalArgumentException.class})
    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str) {
        if (Protector.enable()) {
            try {
                return (T) Enum.valueOf(cls, str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.ENUM, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof String) {
                    return (T) Enum.valueOf(cls, (String) result);
                }
                return null;
            }
        }
        return (T) Enum.valueOf(cls, str);
    }
}
