package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class d {
    private static Map<Class<?>, Service> a = new HashMap();
    private static Map<Class<?>, Object> b = new HashMap();
    private Map<Class<?>, Service> c = new HashMap();
    private Map<Class<?>, Object> d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<Service> list, Context context) {
        a(list, context);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb;
        String localizedMessage;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a2 = a(type, Context.class, AGConnectInstance.class);
            if (a2 != null) {
                return a2.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor a3 = a(type, Context.class);
            return a3 != null ? a3.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (IllegalAccessException e) {
            sb = new StringBuilder("Instantiate service exception ");
            localizedMessage = e.getLocalizedMessage();
            Log.e("AGC_ServiceRepository", sb.append(localizedMessage).toString());
            return null;
        } catch (InstantiationException e2) {
            sb = new StringBuilder("Instantiate service exception ");
            localizedMessage = e2.getLocalizedMessage();
            Log.e("AGC_ServiceRepository", sb.append(localizedMessage).toString());
            return null;
        } catch (InvocationTargetException e3) {
            sb = new StringBuilder("Instantiate service exception ");
            localizedMessage = e3.getLocalizedMessage();
            Log.e("AGC_ServiceRepository", sb.append(localizedMessage).toString());
            return null;
        }
    }

    private static Constructor a(Class cls, Class... clsArr) {
        boolean z = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    z = parameterTypes[i] == clsArr[i];
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private void a(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        Log.e("AGC_ServiceRepository", "cause message:" + (exc.getCause() != null ? exc.getCause().getMessage() : ""));
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service = this.c.get(cls);
        if (service == null && (service = a.get(cls)) != null) {
            return (T) b.get(cls);
        }
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t = (T) this.d.get(cls)) != null) {
            return t;
        }
        T t2 = (T) a(aGConnectInstance, service);
        if (t2 != null && service.isSingleton()) {
            this.d.put(cls, t2);
        }
        return t2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[Catch: InvocationTargetException -> 0x007d, InstantiationException -> 0x0081, IllegalAccessException -> 0x0085, TryCatch #2 {IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d, blocks: (B:23:0x0050, B:27:0x0062, B:28:0x0073, B:31:0x006b), top: B:22:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b A[Catch: InvocationTargetException -> 0x007d, InstantiationException -> 0x0081, IllegalAccessException -> 0x0085, TryCatch #2 {IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d, blocks: (B:23:0x0050, B:27:0x0062, B:28:0x0073, B:31:0x006b), top: B:22:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(List<Service> list, Context context) {
        Map<Class<?>, Service> map;
        String str;
        Log.d("AGC_ServiceRepository", "addService start");
        if (list == null) {
            return;
        }
        for (Service service : list) {
            if (service.isSharedInstance()) {
                if (!a.containsKey(service.getInterface())) {
                    map = a;
                }
                if (service.isAutoCreated() && service.getType() != null && !b.containsKey(service.getInterface())) {
                    try {
                        Constructor a2 = a(service.getType(), Context.class);
                        b.put(service.getInterface(), a2 == null ? a2.newInstance(context) : service.getType().newInstance());
                    } catch (IllegalAccessException e) {
                        e = e;
                        str = "AccessException";
                        a(str, e);
                    } catch (InstantiationException e2) {
                        e = e2;
                        str = "InstantiationException";
                        a(str, e);
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        str = "TargetException";
                        a(str, e);
                    }
                }
            } else {
                map = this.c;
            }
            map.put(service.getInterface(), service);
            if (service.isAutoCreated()) {
                Constructor a22 = a(service.getType(), Context.class);
                b.put(service.getInterface(), a22 == null ? a22.newInstance(context) : service.getType().newInstance());
            }
        }
        Log.d("AGC_ServiceRepository", "addService end");
    }
}
