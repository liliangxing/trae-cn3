package com.bytedance.mt.protector.impl.color;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.impl.BaseProtector;

/* loaded from: classes4.dex */
public class BaseColorProtector<T> extends BaseProtector {
    private static ProtectorType protectorType = ProtectorType.CAST_COLOR;

    public static <T> T tryProtect(Throwable th, Class<?> cls) {
        return (T) tryProtect(protectorType, th, cls);
    }
}
