package com.bytedance.push.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public abstract class AbsMethodInvokeProxy {
    public void afterMethodInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
    }

    public MethodProxyResult proxyMethodInvoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        return new MethodProxyResult();
    }
}
