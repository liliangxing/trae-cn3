package com.bytedance.apm.battery.hook;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public class BinderProxyHookHandler implements InvocationHandler {
    private static final String TAG = "BinderProxyHookHandler";
    IBinder base;
    IBinder hook;
    IHookService hookService;
    Class<?> iInterface;
    Class<?> stub;

    public BinderProxyHookHandler(IBinder iBinder, IHookService iHookService) {
        this.base = iBinder;
        this.hookService = iHookService;
        try {
            String interfaceName = iHookService.getInterfaceName();
            this.stub = Class.forName(interfaceName + "$Stub");
            this.iInterface = Class.forName(interfaceName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BinderProxyHookHandler setHook(IBinder iBinder) {
        this.hook = iBinder;
        return this;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        return "queryLocalInterface".equals(method.getName()) ? Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{this.iInterface}, new BinderHookHandler(this.base, this.stub, this.hookService, this.hook)) : method.invoke(this.base, objArr);
    }
}
