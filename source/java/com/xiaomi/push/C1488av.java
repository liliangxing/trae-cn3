package com.xiaomi.push;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.av */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1488av {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f1021a;

    /* renamed from: com.xiaomi.push.av$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a<T> {

        /* renamed from: a */
        public final Class<? extends T> f1022a;

        /* renamed from: a */
        public final T f1023a;
    }

    static {
        HashMap hashMap = new HashMap();
        f1021a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        hashMap.put(Integer.class, Integer.TYPE);
        hashMap.put(Float.class, Float.TYPE);
        hashMap.put(Long.class, Long.TYPE);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(Boolean.TYPE, Boolean.TYPE);
        hashMap.put(Byte.TYPE, Byte.TYPE);
        hashMap.put(Character.TYPE, Character.TYPE);
        hashMap.put(Short.TYPE, Short.TYPE);
        hashMap.put(Integer.TYPE, Integer.TYPE);
        hashMap.put(Float.TYPE, Float.TYPE);
        hashMap.put(Long.TYPE, Long.TYPE);
        hashMap.put(Double.TYPE, Double.TYPE);
    }

    /* renamed from: a */
    public static <T> T m1567a(Object obj, String str) {
        try {
            return (T) m1564a((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call getField '" + str + "' in " + obj + ", " + e);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m1565a(Class<? extends Object> cls, String str) {
        try {
            return (T) m1564a(cls, (Object) null, str);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call getStaticField '" + str + "' in " + (cls != null ? cls.getSimpleName() : "") + ", " + e);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m1569a(String str, String str2) {
        try {
            return (T) m1564a((Class<? extends Object>) C1702q.m3463a(null, str), (Object) null, str2);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call getStaticField '" + str2 + "' in " + str + ", " + e);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m1564a(Class<? extends Object> cls, Object obj, String str) {
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    /* renamed from: a */
    public static void m1573a(Object obj, String str, Object obj2) {
        try {
            m1578b(obj, str, obj2);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call setField '" + str + "' in " + obj + ", " + e);
        }
    }

    /* renamed from: b */
    public static void m1578b(Object obj, String str, Object obj2) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    /* renamed from: a */
    public static <T> T m1568a(Object obj, String str, Object... objArr) {
        try {
            return (T) m1577b(obj, str, objArr);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str + "' in " + obj + ", " + e);
            return null;
        }
    }

    /* renamed from: b */
    public static <T> T m1577b(Object obj, String str, Object... objArr) {
        return (T) m1571a(obj.getClass(), str, m1575a(objArr)).invoke(obj, m1576a(objArr));
    }

    /* renamed from: a */
    public static <T> T m1570a(String str, String str2, Object... objArr) {
        try {
            return (T) m1566a(C1702q.m3463a(null, str), str2, objArr);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str + ", " + e);
            return null;
        }
    }

    /* renamed from: a */
    private static Method m1571a(Class<?> cls, String str, Class<?>... clsArr) {
        Method m1572a = m1572a(cls.getDeclaredMethods(), str, clsArr);
        if (m1572a == null) {
            if (cls.getSuperclass() != null) {
                return m1571a((Class<?>) cls.getSuperclass(), str, clsArr);
            }
            throw new NoSuchMethodException();
        }
        m1572a.setAccessible(true);
        return m1572a;
    }

    /* renamed from: a */
    private static Method m1572a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && m1574a(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m1574a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            Class<?> cls = clsArr2[i];
            if (cls != null && !clsArr[i].isAssignableFrom(cls)) {
                Map<Class<?>, Class<?>> map = f1021a;
                if (!map.containsKey(clsArr[i]) || !map.get(clsArr[i]).equals(map.get(clsArr2[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static <T> T m1566a(Class<?> cls, String str, Object... objArr) {
        return (T) m1571a(cls, str, m1575a(objArr)).invoke(null, m1576a(objArr));
    }

    /* renamed from: a */
    private static Class<?>[] m1575a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof a)) {
                clsArr[i] = ((a) obj).f1022a;
            } else {
                clsArr[i] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    /* renamed from: a */
    private static Object[] m1576a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof a)) {
                objArr2[i] = ((a) obj).f1023a;
            } else {
                objArr2[i] = obj;
            }
        }
        return objArr2;
    }
}
