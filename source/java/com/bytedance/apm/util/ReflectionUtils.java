package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes3.dex */
public class ReflectionUtils {
    private final Class<?> clazz;
    private final boolean isClass;
    private final Object object;

    private ReflectionUtils(Class<?> cls) {
        this.object = cls;
        this.clazz = cls;
        this.isClass = true;
    }

    private ReflectionUtils(Object obj) {
        this.object = obj;
        this.clazz = obj != null ? obj.getClass() : null;
        this.isClass = false;
    }

    private ReflectionUtils(Object obj, Class<?> cls) {
        this.object = obj;
        this.clazz = cls;
        this.isClass = false;
    }

    public static <T> T getFieldValue(Object obj, String str) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        return (T) getFieldValue(obj, str, true);
    }

    public static <T> T getFieldValue(Object obj, String str, boolean z) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        Object[] field = getField(obj, str, z);
        if (field == null) {
            throw new NoSuchFieldException("field:" + str);
        }
        return (T) ((Field) field[0]).get(field[1]);
    }

    public static void setFieldValue(Object obj, String str, Object obj2) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        setFieldValue(obj, str, obj2, true);
    }

    public static void setFieldValue(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        Object[] field = getField(obj, str, z);
        if (field == null) {
            throw new NoSuchFieldException("field:" + str);
        }
        ((Field) field[0]).set(field[1], obj2);
    }

    private static Object[] getField(Object obj, String str, boolean z) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        if (obj == null) {
            return null;
        }
        String[] split = str.split("[.]");
        Class<?> cls = obj.getClass();
        Object[] objArr = new Object[2];
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = split[i];
            i2++;
            Field field_ = getField_(cls, str2, z);
            if (field_ != null) {
                field_.setAccessible(true);
                objArr[0] = field_;
                objArr[1] = obj;
                obj = field_.get(obj);
                if (obj == null) {
                    if (i2 < split.length) {
                        throw new IllegalAccessException("can not getFieldValue as field '" + str2 + "' value is null in '" + cls.getName() + "'");
                    }
                } else {
                    cls = obj.getClass();
                }
            }
            i++;
        }
        return objArr;
    }

    public static Field getField_(Class<?> cls, String str, boolean z) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        Field field;
        NoSuchFieldException e = null;
        try {
            field = cls.getDeclaredField(str);
            if (!z) {
                try {
                    field.setAccessible(true);
                    return field;
                } catch (NoSuchFieldException e2) {
                    e = e2;
                }
            }
        } catch (NoSuchFieldException e3) {
            field = null;
            e = e3;
        }
        if (e != null) {
            if (!z) {
                throw e;
            }
            do {
                cls = cls.getSuperclass();
                if (cls != null) {
                    try {
                        Field declaredField = cls.getDeclaredField(str);
                        declaredField.setAccessible(true);
                        return declaredField;
                    } catch (NoSuchFieldException e4) {
                    }
                }
            } while (cls.getSuperclass() != null);
            throw e4;
        }
        return field;
    }

    public static ReflectionUtils on(String str) throws ReflectException {
        return on(forName(str));
    }

    public static ReflectionUtils on(Class<?> cls) {
        return new ReflectionUtils(cls);
    }

    public static ReflectionUtils on(Object obj) {
        return new ReflectionUtils(obj);
    }

    public static ReflectionUtils on(Object obj, Class<?> cls) {
        return new ReflectionUtils(obj, cls);
    }

    private static <T extends AccessibleObject> T accessible(T t) {
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers())) {
                Modifier.isPublic(member.getDeclaringClass().getModifiers());
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String property(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    private static ReflectionUtils on(Constructor<?> constructor, Object... objArr) throws ReflectException {
        try {
            return on(((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static ReflectionUtils on(Method method, Object obj, Object... objArr) throws ReflectException {
        try {
            accessible(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return on(obj);
            }
            return on(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Object unwrap(Object obj) {
        return obj instanceof ReflectionUtils ? ((ReflectionUtils) obj).get() : obj;
    }

    private static Class<?>[] types(Object... objArr) {
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

    private static Class<?> forName(String str) throws ReflectException {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Class<?> wrapper(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public ReflectionUtils set(String str, Object obj) throws ReflectException {
        try {
            Field field0 = field0(str);
            if (field0 != null) {
                field0.set(this.object, unwrap(obj));
            }
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public ReflectionUtils setNoException(String str, Object obj) {
        try {
            set(str, obj);
        } catch (ReflectException e) {
            e.printStackTrace();
        }
        return this;
    }

    public <T> T get(String str) throws ReflectException {
        return (T) field(str).get();
    }

    public <T> T getNoException(String str) {
        try {
            return (T) get(str);
        } catch (ReflectException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ReflectionUtils field(String str) throws ReflectException {
        try {
            return on(field0(str).get(this.object));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field field0(String str) throws ReflectException {
        Class<?> type = type();
        try {
            return (Field) accessible(type.getField(str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) accessible(type.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new ReflectException(e);
                    }
                }
            } while (type == null);
            throw new ReflectException(e);
        }
    }

    public Map<String, ReflectionUtils> fields() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> type = type();
        do {
            for (Field field : type.getDeclaredFields()) {
                if ((!this.isClass) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        return linkedHashMap;
    }

    public ReflectionUtils call(String str) throws ReflectException {
        return call(str, new Object[0]);
    }

    public ReflectionUtils call(String str, Object... objArr) throws ReflectException {
        return call(str, null, null, objArr);
    }

    public ReflectionUtils call(String str, Map<String, Vector<Method>> map, Class<?>[] clsArr, Object... objArr) throws ReflectException {
        Method exactMethod;
        Class<?>[] types = types(objArr);
        if (map != null) {
            try {
                try {
                    ReflectionUtils callInner = callInner(str, map, types, objArr);
                    if (callInner != null) {
                        return callInner;
                    }
                } catch (NoSuchMethodException unused) {
                    Method similarMethod = similarMethod(str, types);
                    if (map != null && similarMethod != null) {
                        Vector<Method> vector = map.get(str);
                        if (vector == null) {
                            vector = new Vector<>(4);
                            map.put(str, vector);
                        }
                        vector.add(similarMethod);
                    }
                    return on(similarMethod, this.object, objArr);
                }
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }
        if (clsArr != null) {
            try {
                exactMethod = exactMethod(str, clsArr);
            } catch (NoSuchMethodException unused2) {
                exactMethod = exactMethod(str, types);
            }
        } else {
            exactMethod = exactMethod(str, types);
        }
        if (map != null && exactMethod != null) {
            Vector<Method> vector2 = map.get(str);
            if (vector2 == null) {
                vector2 = new Vector<>(4);
                map.put(str, vector2);
            }
            vector2.add(exactMethod);
        }
        return on(exactMethod, this.object, objArr);
    }

    private ReflectionUtils callInner(String str, Map<String, Vector<Method>> map, Class<?>[] clsArr, Object... objArr) throws ReflectException {
        Vector<Method> vector = map.get(str);
        if (vector == null) {
            return null;
        }
        Iterator<Method> it = vector.iterator();
        while (it.hasNext()) {
            Method next = it.next();
            if (next != null && next.getDeclaringClass().isAssignableFrom(type()) && isSimilarSignature(next, str, clsArr)) {
                return on(next, this.object, objArr);
            }
        }
        return null;
    }

    private Method exactMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> type = type();
        try {
            return (Method) accessible(type.getMethod(str, clsArr));
        } catch (NoSuchMethodException e) {
            do {
                try {
                    return (Method) accessible(type.getDeclaredMethod(str, clsArr));
                } catch (NoSuchMethodException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new NoSuchMethodException(e.getMessage());
                    }
                }
            } while (type == null);
            throw new NoSuchMethodException(e.getMessage());
        }
    }

    private Method similarMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> type = type();
        try {
            for (Method method : type.getMethods()) {
                if (isSimilarSignature(method, str, clsArr)) {
                    return (Method) accessible(method);
                }
            }
        } catch (NoClassDefFoundError unused) {
        }
        do {
            try {
                for (Method method2 : type.getDeclaredMethods()) {
                    if (isSimilarSignature(method2, str, clsArr)) {
                        return (Method) accessible(method2);
                    }
                }
            } catch (NoClassDefFoundError unused2) {
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + LibrarianImpl.Constants.DOT);
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    public ReflectionUtils create() throws ReflectException {
        return create(new Object[0]);
    }

    public ReflectionUtils create(Object... objArr) throws ReflectException {
        Class<?>[] types = types(objArr);
        try {
            return on(type().getDeclaredConstructor(types), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                if (match(constructor.getParameterTypes(), types)) {
                    return on(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public <P> P as(Class<P> cls) {
        final boolean z = this.object instanceof Map;
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.bytedance.apm.util.ReflectionUtils.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String name = method.getName();
                try {
                    return ReflectionUtils.on(ReflectionUtils.this.object).call(name, objArr).get();
                } catch (ReflectException e) {
                    if (z) {
                        Map map = (Map) ReflectionUtils.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(ReflectionUtils.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(ReflectionUtils.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(ReflectionUtils.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        });
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != NULL.class && !wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    private boolean same(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != NULL.class && !TextUtils.equals(wrapper(clsArr[i]).getName(), wrapper(clsArr2[i]).getName())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ReflectionUtils) {
            return this.object.equals(((ReflectionUtils) obj).get());
        }
        return false;
    }

    public String toString() {
        return this.object.toString();
    }

    private Class<?> type() {
        Class<?> cls = this.clazz;
        if (cls != null) {
            return cls;
        }
        if (this.isClass) {
            return (Class) this.object;
        }
        return this.object.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class NULL {
        private NULL() {
        }
    }
}
