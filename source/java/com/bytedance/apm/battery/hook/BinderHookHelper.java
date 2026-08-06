package com.bytedance.apm.battery.hook;

import android.os.IBinder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BinderHookHelper {
    private Map<String, IHookService> hookServiceMap = new HashMap();

    public void hookService() throws Exception {
        if (this.hookServiceMap.size() == 0) {
            return;
        }
        Class<?> cls = Class.forName("android.os.ServiceManager");
        Method declaredMethod = cls.getDeclaredMethod("getService", String.class);
        Field declaredField = cls.getDeclaredField("sCache");
        declaredField.setAccessible(true);
        Map map = (Map) declaredField.get(null);
        for (Map.Entry<String, IHookService> entry : this.hookServiceMap.entrySet()) {
            String key = entry.getKey();
            IHookService value = entry.getValue();
            BinderProxyHookHandler binderProxyHookHandler = new BinderProxyHookHandler((IBinder) declaredMethod.invoke(null, key), value);
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{IBinder.class}, binderProxyHookHandler);
            binderProxyHookHandler.setHook(iBinder);
            map.put(key, iBinder);
        }
    }

    public void hookSystemServiceRegistry() throws Throwable {
        if (this.hookServiceMap.size() == 0) {
            return;
        }
        Class<?> cls = Class.forName("android.app.SystemServiceRegistry");
        Field declaredField = cls.getDeclaredField("SYSTEM_SERVICE_FETCHERS");
        declaredField.setAccessible(true);
        Map map = (Map) declaredField.get(null);
        for (Map.Entry<String, IHookService> entry : this.hookServiceMap.entrySet()) {
            String key = entry.getKey();
            IHookService value = entry.getValue();
            map.put(key, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{Class.forName("android.app.SystemServiceRegistry$ServiceFetcher")}, new ServiceFetcherProxyHandler(map.get(key), value)));
        }
    }

    public void addHook(String str, IHookService iHookService) {
        this.hookServiceMap.put(str, iHookService);
    }
}
