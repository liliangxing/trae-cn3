package com.bytedance.push.notification;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public interface MethodInvokeProxy {
    Object proxyMethodInvoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException;
}
