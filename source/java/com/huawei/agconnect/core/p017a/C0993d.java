package com.huawei.agconnect.core.p017a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.agconnect.core.a.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C0993d {

    /* renamed from: a */
    private static Map<Class<?>, Service> f878a = new HashMap();

    /* renamed from: b */
    private static Map<Class<?>, Object> f879b = new HashMap();

    /* renamed from: c */
    private Map<Class<?>, Service> f880c = new HashMap();

    /* renamed from: d */
    private Map<Class<?>, Object> f881d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0993d(List<Service> list, Context context) {
        m850a(list, context);
    }

    /* renamed from: a */
    private Object m846a(AGConnectInstance aGConnectInstance, Service service) {
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
            Constructor m847a = m847a(type, Context.class, AGConnectInstance.class);
            if (m847a != null) {
                return m847a.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor m847a2 = m847a(type, Context.class);
            return m847a2 != null ? m847a2.newInstance(aGConnectInstance.getContext()) : type.newInstance();
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

    /* renamed from: a */
    private static Constructor m847a(Class cls, Class... clsArr) {
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

    /* renamed from: a */
    private void m848a(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        Log.e("AGC_ServiceRepository", "cause message:" + (exc.getCause() != null ? exc.getCause().getMessage() : ""));
    }

    /* renamed from: a */
    public <T> T m849a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service = this.f880c.get(cls);
        if (service == null && (service = f878a.get(cls)) != null) {
            return (T) f879b.get(cls);
        }
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t = (T) this.f881d.get(cls)) != null) {
            return t;
        }
        T t2 = (T) m846a(aGConnectInstance, service);
        if (t2 != null && service.isSingleton()) {
            this.f881d.put(cls, t2);
        }
        return t2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[Catch: InvocationTargetException -> 0x007d, InstantiationException -> 0x0081, IllegalAccessException -> 0x0085, TryCatch #2 {IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d, blocks: (B:23:0x0050, B:27:0x0062, B:28:0x0073, B:31:0x006b), top: B:22:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b A[Catch: InvocationTargetException -> 0x007d, InstantiationException -> 0x0081, IllegalAccessException -> 0x0085, TryCatch #2 {IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d, blocks: (B:23:0x0050, B:27:0x0062, B:28:0x0073, B:31:0x006b), top: B:22:0x0050 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m850a(List<Service> list, Context context) {
        Map<Class<?>, Service> map;
        String str;
        Log.d("AGC_ServiceRepository", "addService start");
        if (list == null) {
            return;
        }
        for (Service service : list) {
            if (service.isSharedInstance()) {
                if (!f878a.containsKey(service.getInterface())) {
                    map = f878a;
                }
                if (service.isAutoCreated() && service.getType() != null && !f879b.containsKey(service.getInterface())) {
                    try {
                        Constructor m847a = m847a(service.getType(), Context.class);
                        f879b.put(service.getInterface(), m847a == null ? m847a.newInstance(context) : service.getType().newInstance());
                    } catch (IllegalAccessException e) {
                        e = e;
                        str = "AccessException";
                        m848a(str, e);
                    } catch (InstantiationException e2) {
                        e = e2;
                        str = "InstantiationException";
                        m848a(str, e);
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        str = "TargetException";
                        m848a(str, e);
                    }
                }
            } else {
                map = this.f880c;
            }
            map.put(service.getInterface(), service);
            if (service.isAutoCreated()) {
                Constructor m847a2 = m847a(service.getType(), Context.class);
                f879b.put(service.getInterface(), m847a2 == null ? m847a2.newInstance(context) : service.getType().newInstance());
            }
        }
        Log.d("AGC_ServiceRepository", "addService end");
    }
}
