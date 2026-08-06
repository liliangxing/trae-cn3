package com.bytedance.apm.battery.hook;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class BinderHookHandler implements InvocationHandler {
    private static final String TAG = "BinderHookHandler";
    private Object base;
    private IHookService hookService;
    private IBinder mHooked;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderHookHandler(IBinder iBinder, Class<?> cls, IHookService iHookService, IBinder iBinder2) {
        this.mHooked = null;
        try {
            this.base = cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            this.hookService = iHookService;
            this.mHooked = iBinder2;
        } catch (Exception unused) {
        }
    }

    public void setHooked(IBinder iBinder) {
        this.mHooked = iBinder;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (this.mHooked != null && method.getName().equals("asBinder")) {
            return this.mHooked;
        }
        this.hookService.invoke(obj, method, objArr);
        return method.invoke(this.base, objArr);
    }
}
