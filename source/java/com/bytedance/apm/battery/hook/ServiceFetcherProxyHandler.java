package com.bytedance.apm.battery.hook;

import android.text.TextUtils;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.logging.ApmAlogHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public class ServiceFetcherProxyHandler implements InvocationHandler {
    private Object cachedServiceFetcher;
    private IHookService hookServiceImpl;

    public ServiceFetcherProxyHandler(Object obj, IHookService iHookService) {
        this.cachedServiceFetcher = obj;
        this.hookServiceImpl = iHookService;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            if ("getService".equals(method.getName())) {
                Object invoke = method.invoke(this.cachedServiceFetcher, objArr);
                Field declaredField = invoke.getClass().getDeclaredField("mService");
                declaredField.setAccessible(true);
                final Object obj2 = declaredField.get(invoke);
                String name = obj2.getClass().getName();
                if (!TextUtils.isEmpty(name) && name.startsWith(this.hookServiceImpl.getInterfaceName())) {
                    declaredField.set(invoke, Proxy.newProxyInstance(obj2.getClass().getClassLoader(), new Class[]{Class.forName(this.hookServiceImpl.getInterfaceName())}, new InvocationHandler() { // from class: com.bytedance.apm.battery.hook.ServiceFetcherProxyHandler.1
                        @Override // java.lang.reflect.InvocationHandler
                        public Object invoke(Object obj3, Method method2, Object[] objArr2) throws Throwable {
                            try {
                                ServiceFetcherProxyHandler.this.hookServiceImpl.invoke(obj3, method2, objArr2);
                            } catch (Throwable th) {
                                ApmAlogHelper.e(Constants.TAG_BATTERY, "hookServiceImpl invoke failed: " + th.getMessage());
                            }
                            return method2.invoke(obj2, objArr2);
                        }
                    }));
                }
                return invoke;
            }
        } catch (Throwable th) {
            ApmAlogHelper.e(Constants.TAG_BATTERY, "ServiceFetcher getService hook failed: " + th.getMessage());
        }
        return method.invoke(this.cachedServiceFetcher, objArr);
    }
}
