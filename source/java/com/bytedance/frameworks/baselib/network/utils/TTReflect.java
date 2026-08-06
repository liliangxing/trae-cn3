package com.bytedance.frameworks.baselib.network.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class TTReflect {
    private static final String LOG_TAG = "ReflectUtil";
    private final boolean isClassTarget = true;
    private final Object target;
    private static final Map<String, Field> FIELD_CACHE = new ConcurrentHashMap();
    private static final Map<String, Method> METHOD_CACHE = new ConcurrentHashMap();
    private static final Map<String, Constructor<?>> CONSTRUCTOR_CACHE = new ConcurrentHashMap();

    public static TTReflect on(String str) throws TTReflectException {
        return on(forName(str));
    }

    public static TTReflect on(Class<?> cls) {
        if (cls == null) {
            throw new TTReflectException("Class object cannot be null");
        }
        return new TTReflect(cls);
    }

    public static TTReflect on(Object obj) {
        if (obj == null) {
            throw new TTReflectException("Instance object cannot be null");
        }
        return new TTReflect(obj);
    }

    public static <T extends AccessibleObject> T accessible(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        try {
            if (!t.isAccessible()) {
                t.setAccessible(true);
            }
            return t;
        } catch (SecurityException e) {
            throw new TTReflectException("Failed to set accessible for " + t, e, t.getClass().getSimpleName());
        }
    }

    private TTReflect(Class<?> cls) {
        this.target = cls;
    }

    private TTReflect(Object obj) {
        this.target = obj;
    }

    public <T> T get() {
        return (T) this.target;
    }

    public TTReflect set(String str, Object obj) throws TTReflectException {
        return set(str, null, obj);
    }

    public TTReflect set(String str, Class<?> cls, Object obj) throws TTReflectException {
        try {
            findField(str, cls).set(this.target, unwrap(obj));
            return this;
        } catch (TTReflectException e) {
            throw e;
        } catch (Exception e2) {
            throw new TTReflectException("Failed to set field: " + str, e2, getTargetClassName(), str);
        }
    }

    public <T> T get(String str) throws TTReflectException {
        return (T) get(str, null);
    }

    public <T> T get(String str, Class<?> cls) throws TTReflectException {
        return (T) field(str, cls).get();
    }

    public TTReflect field(String str) throws TTReflectException {
        return field(str, null);
    }

    public TTReflect field(String str, Class<?> cls) throws TTReflectException {
        try {
            return on(findField(str, cls).get(this.target));
        } catch (TTReflectException e) {
            throw e;
        } catch (Exception e2) {
            throw new TTReflectException("Failed to reflect field: " + str, e2, getTargetClassName(), str);
        }
    }

    public Field exactField(String str, Class<?> cls) throws TTReflectException {
        return findField(str, cls);
    }

    public TTReflect call(String str) throws TTReflectException {
        return call(str, new Object[0]);
    }

    public TTReflect call(String str, Object... objArr) throws TTReflectException {
        return call(str, types(objArr), objArr);
    }

    public TTReflect call(String str, Class<?>[] clsArr, Object... objArr) throws TTReflectException {
        try {
            try {
                return invokeMethod(findExactMethod(str, clsArr), objArr);
            } catch (NoSuchMethodException unused) {
                return invokeMethod(findSimilarMethod(str, clsArr), objArr);
            }
        } catch (NoSuchMethodException e) {
            throw new TTReflectException("No method found: " + str, e, getTargetClassName(), str, Arrays.toString(clsArr));
        }
    }

    public TTReflect create() throws TTReflectException {
        return create(new Object[0]);
    }

    public TTReflect create(Object... objArr) throws TTReflectException {
        Class<?>[] types = types(objArr);
        try {
            return on(((Constructor) accessible(findConstructor(types))).newInstance(objArr));
        } catch (Exception e) {
            throw new TTReflectException("Failed to create instance", e, getTargetClassName(), "constructor", Arrays.toString(types));
        }
    }

    private Field findField(String str, Class<?> cls) throws TTReflectException {
        if (str == null || str.isEmpty()) {
            throw new TTReflectException("Field name cannot be empty");
        }
        String buildCacheKey = buildCacheKey(getTargetClassName(), str, cls);
        Field field = FIELD_CACHE.get(buildCacheKey);
        if (field != null) {
            return field;
        }
        Class<?> type = type();
        Field field2 = null;
        while (type != null && field2 == null) {
            if (cls != null) {
                try {
                    field2 = findFieldByType(type, str, cls);
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                }
            } else {
                try {
                    field2 = type.getField(str);
                } catch (NoSuchFieldException unused2) {
                    field2 = type.getDeclaredField(str);
                }
            }
            type = type.getSuperclass();
        }
        if (field2 == null) {
            String str2 = "Field not found: " + str;
            String[] strArr = new String[3];
            strArr[0] = getTargetClassName();
            strArr[1] = str;
            strArr[2] = cls != null ? cls.getName() : "unknown";
            throw new TTReflectException(str2, null, strArr);
        }
        accessible(field2);
        FIELD_CACHE.put(buildCacheKey, field2);
        return field2;
    }

    private Field findFieldByType(Class<?> cls, String str, Class<?> cls2) throws NoSuchFieldException {
        for (Field field : cls.getDeclaredFields()) {
            if (field.getName().equals(str) && field.getType().getName().equals(cls2.getName())) {
                return field;
            }
        }
        throw new NoSuchFieldException();
    }

    private Method findExactMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        String buildCacheKey = buildCacheKey(getTargetClassName(), str, clsArr);
        Method method = METHOD_CACHE.get(buildCacheKey);
        if (method != null) {
            return method;
        }
        Class<?> type = type();
        Method method2 = null;
        while (type != null && method2 == null) {
            try {
                try {
                    method2 = type.getMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    method2 = type.getDeclaredMethod(str, clsArr);
                }
            } catch (NoSuchMethodException unused2) {
                type = type.getSuperclass();
            }
        }
        if (method2 == null) {
            throw new NoSuchMethodException();
        }
        accessible(method2);
        METHOD_CACHE.put(buildCacheKey, method2);
        return method2;
    }

    private Method findSimilarMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> type = type();
        Method method = null;
        while (type != null && method == null) {
            Method[] declaredMethods = type.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method2 = declaredMethods[i];
                if (method2.getName().equals(str) && method2.getParameterTypes().length == clsArr.length && matchParamTypes(method2.getParameterTypes(), clsArr)) {
                    method = method2;
                    break;
                }
                i++;
            }
            if (method == null) {
                type = type.getSuperclass();
            }
        }
        if (method == null) {
            throw new NoSuchMethodException();
        }
        accessible(method);
        METHOD_CACHE.put(buildCacheKey(getTargetClassName(), str, clsArr), method);
        return method;
    }

    private Constructor<?> findConstructor(Class<?>[] clsArr) throws NoSuchMethodException {
        Constructor<?> constructor;
        String buildCacheKey = buildCacheKey(getTargetClassName(), "constructor", clsArr);
        Constructor<?> constructor2 = CONSTRUCTOR_CACHE.get(buildCacheKey);
        if (constructor2 != null) {
            return constructor2;
        }
        try {
            constructor = type().getDeclaredConstructor(clsArr);
        } catch (NoSuchMethodException unused) {
            Constructor<?>[] declaredConstructors = type().getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    constructor = null;
                    break;
                }
                Constructor<?> constructor3 = declaredConstructors[i];
                if (matchParamTypes(constructor3.getParameterTypes(), clsArr)) {
                    constructor = constructor3;
                    break;
                }
                i++;
            }
        }
        if (constructor == null) {
            throw new NoSuchMethodException();
        }
        accessible(constructor);
        CONSTRUCTOR_CACHE.put(buildCacheKey, constructor);
        return constructor;
    }

    private TTReflect invokeMethod(Method method, Object... objArr) throws TTReflectException {
        try {
            accessible(method);
            return method.getReturnType() == Void.TYPE ? this : on(method.invoke(this.target, objArr));
        } catch (Exception e) {
            throw new TTReflectException("Failed to invoke method: " + method.getName(), e, getTargetClassName(), method.getName(), Arrays.toString(method.getParameterTypes()));
        }
    }

    private String buildCacheKey(String str, String str2, Class<?>... clsArr) {
        StringBuilder append = new StringBuilder(str).append("#").append(str2);
        if (clsArr != null && clsArr.length > 0) {
            append.append("[");
            for (int i = 0; i < clsArr.length; i++) {
                Class<?> cls = clsArr[i];
                append.append(cls != null ? cls.getName() : "null");
                if (i != clsArr.length - 1) {
                    append.append(",");
                }
            }
            append.append("]");
        }
        return append.toString();
    }

    private Object unwrap(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof TTReflect) {
            return ((TTReflect) obj).get();
        }
        if (obj.getClass().isArray() && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = unwrap(objArr[i]);
            }
        }
        return obj;
    }

    private boolean matchParamTypes(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            Class<?> wrapper = wrapper(clsArr[i]);
            Class<?> cls = clsArr2[i];
            Class<?> wrapper2 = cls == NULL.class ? null : wrapper(cls);
            if (wrapper2 != null && !wrapper.isAssignableFrom(wrapper2)) {
                return false;
            }
        }
        return true;
    }

    private Class<?>[] types(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? NULL.class : obj.getClass();
        }
        return clsArr;
    }

    private static Class<?> forName(String str) throws TTReflectException {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new TTReflectException("Class not found: " + str, e, str);
        } catch (Exception e2) {
            throw new TTReflectException("Failed to load class: " + str, e2, str);
        }
    }

    public Class<?> type() {
        return this.isClassTarget ? (Class) this.target : this.target.getClass();
    }

    private String getTargetClassName() {
        return type().getName();
    }

    public static Class<?> wrapper(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.target.equals(((TTReflect) obj).target);
    }

    public String toString() {
        return "TTReflect{target=" + this.target + ", isClassTarget=" + this.isClassTarget + ", targetClass=" + getTargetClassName() + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class NULL {
        private NULL() {
        }
    }
}
