package com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public abstract class MethodDelegate {
    public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
        return obj2;
    }

    public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
        return null;
    }
}
