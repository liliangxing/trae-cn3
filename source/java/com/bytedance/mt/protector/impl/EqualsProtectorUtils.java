package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.IProtectorCallback;
import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.utils.StackTraceUtils;

/* loaded from: classes4.dex */
public class EqualsProtectorUtils {
    @ProtectorMethod(exceptions = {NullPointerException.class})
    public static boolean equals(Object obj, Object obj2) {
        if (Protector.enable() && obj == null) {
            IProtectorCallback callback = Protector.getCallback();
            if (callback == null) {
                return false;
            }
            callback.onProtected(ProtectorType.EQUALS, StackTraceUtils.removeStackTrace(new NullPointerException("equals NPE"), EqualsProtectorUtils.class));
            return false;
        }
        return obj.equals(obj2);
    }
}
