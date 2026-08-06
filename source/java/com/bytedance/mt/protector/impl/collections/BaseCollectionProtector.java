package com.bytedance.mt.protector.impl.collections;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.impl.BaseProtector;

/* loaded from: classes4.dex */
public class BaseCollectionProtector<T> extends BaseProtector {
    private static ProtectorType protectorType = ProtectorType.COLLECTIONS;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> T tryProtect(Throwable th, Class<?> cls) {
        return (T) tryProtect(protectorType, th, cls);
    }
}
