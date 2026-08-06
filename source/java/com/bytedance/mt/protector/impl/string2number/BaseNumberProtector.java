package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.impl.BaseProtector;

/* loaded from: classes4.dex */
public class BaseNumberProtector<T> extends BaseProtector {
    private static ProtectorType protectorType = ProtectorType.CAST_NUMBER;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> T tryProtect(Throwable th, Class<?> cls) {
        return (T) tryProtect(protectorType, th, cls);
    }
}
