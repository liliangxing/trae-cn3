package com.bytedance.notification.handler;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class NotificationManagerHandler implements InvocationHandler {
    private Object mBase;

    public NotificationManagerHandler(Object obj) {
        this.mBase = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Log.d("xuefanggang", "invoke: " + method.getName());
        return method.invoke(this.mBase, objArr);
    }
}
