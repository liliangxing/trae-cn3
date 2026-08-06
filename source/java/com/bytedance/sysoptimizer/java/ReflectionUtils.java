package com.bytedance.sysoptimizer.java;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.sysoptimizer.SysOptimizer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";
    private static HashMap<String, Field> sCacheFiled = new HashMap<>();
    private static HashMap<String, Method> sCacheMethod = new HashMap<>();
    private static Method sGetDeclaredField;
    private static Method sGetDeclaredMethod;
    private static boolean sIsInit;

    private static native boolean changeTargetSuperClassToSpecificClassOnDalvik(Class<?> cls, Class<?> cls2, String str);

    private static native boolean setModifiersForDalvik(Class<?> cls, int i, int i2, int i3, String str);

    static {
        sGetDeclaredField = null;
        sGetDeclaredMethod = null;
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            sGetDeclaredMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            sGetDeclaredField = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (Throwable unused2) {
        }
    }

    private ReflectionUtils() {
    }

    public static Object invokeStaticMethod(String str, String str2) {
        try {
            return invokeStaticMethod(Class.forName(str), str2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeStaticMethod(Class<?> cls, String str) {
        return invokeStaticMethod(cls, str, null, null);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            if (clsArr == null) {
                clsArr = new Class[0];
            }
            if (objArr == null) {
                objArr = new Object[0];
            }
            try {
                Method classMethod = getClassMethod(cls, str, clsArr);
                if (classMethod == null) {
                    return null;
                }
                classMethod.setAccessible(true);
                return classMethod.invoke(null, objArr);
            } catch (Throwable th) {
                Log.e(TAG, "exception in invokeMethod, pkg : " + cls.getName() + ", function : " + str + ", " + th.toString());
            }
        }
        return null;
    }

    public static Object invokeVoidMethod(Class<?> cls, String str, Object obj) {
        return invokeMethod(cls, str, null, null, obj);
    }

    public static Object invokeMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr, Object obj) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            if (clsArr == null) {
                clsArr = new Class[0];
            }
            if (objArr == null) {
                objArr = new Object[0];
            }
            try {
                Method classMethod = getClassMethod(cls, str, clsArr);
                if (classMethod == null) {
                    return null;
                }
                classMethod.setAccessible(true);
                return classMethod.invoke(obj, objArr);
            } catch (Throwable th) {
                Log.e(TAG, "invokeMethod failed, class : " + cls.getName() + ", function : " + str + ", " + th.toString());
            }
        }
        return null;
    }

    public static Method getClassMethod(Class cls, String str) {
        return getClassMethod(cls, str, null);
    }

    public static Method getClassMethod(Class cls, String str, Class<?>... clsArr) {
        if (cls != null && str != null) {
            String str2 = cls.getName() + LibrarianImpl.Constants.DOT + str;
            if (sCacheMethod.containsKey(str2)) {
                return sCacheMethod.get(str2);
            }
            Method method = null;
            while (cls != null && cls != Object.class) {
                try {
                    Method method2 = sGetDeclaredMethod;
                    if (method2 != null) {
                        method = (Method) method2.invoke(cls, str, clsArr);
                    } else {
                        method = cls.getDeclaredMethod(str, clsArr);
                    }
                    method.setAccessible(true);
                } catch (Throwable unused) {
                }
                if (method != null) {
                    sCacheMethod.put(str2, method);
                    return method;
                }
                cls = cls.getSuperclass();
            }
            sCacheMethod.put(str2, null);
        }
        return null;
    }

    public static void setFieldObject(Object obj, String str, Object obj2) {
        Field classField = getClassField(obj.getClass(), str);
        if (classField != null) {
            try {
                classField.set(obj, obj2);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setFieldObject(Class cls, String str, Object obj, Object obj2) {
        Field classField = getClassField(cls, str);
        if (classField != null) {
            try {
                classField.set(obj, obj2);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object getStaticFieldObject(String str, Class cls) {
        Field classField = getClassField(cls, str);
        if (classField != null) {
            try {
                return classField.get(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Object getFieldObject(String str, Object obj) {
        Field classField = getClassField(obj.getClass(), str);
        if (classField == null) {
            return null;
        }
        try {
            return classField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getFieldObject(String str, String str2, Object obj) {
        try {
            Field classField = getClassField(Class.forName(str), str2);
            if (classField == null) {
                return null;
            }
            try {
                return classField.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Object getFieldObject(Class cls, String str, Object obj) {
        Field classField = getClassField(cls, str);
        if (classField == null) {
            return null;
        }
        try {
            return classField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field getClassField(Class cls, String str) {
        String str2 = cls.getName() + LibrarianImpl.Constants.DOT + str;
        if (sCacheFiled.containsKey(str2)) {
            return sCacheFiled.get(str2);
        }
        Field field = null;
        while (cls != null && cls != Object.class) {
            try {
                Method method = sGetDeclaredField;
                if (method != null) {
                    field = (Field) method.invoke(cls, str);
                } else {
                    field = cls.getDeclaredField(str);
                }
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
            if (field != null) {
                sCacheFiled.put(str2, field);
                return field;
            }
            cls = cls.getSuperclass();
        }
        sCacheFiled.put(str2, null);
        return null;
    }

    public static void removeFinal(Field field) {
        if (field == null) {
            return;
        }
        changeAccessFlagsAboveL(field, field.getModifiers() & (-17));
    }

    public static void changeIfTableFrom(Object obj, Object obj2) {
        if (obj2 == null || obj == null) {
            return;
        }
        try {
            Class<?> cls = obj2.getClass();
            Class<?> cls2 = obj.getClass();
            Field declaredField = Class.class.getDeclaredField("ifTable");
            declaredField.setAccessible(true);
            Object[] objArr = (Object[]) declaredField.get(cls);
            if (Arrays.equals(objArr, (Object[]) declaredField.get(cls2))) {
                return;
            }
            declaredField.set(cls2, objArr);
            Log.d(TAG, "change ifTable succ");
        } catch (Throwable th) {
            Log.e(TAG, "changeIfTable", th);
        }
    }

    public static void changeField2Target(Object obj, Field field, Object obj2, Object obj3) {
        if (field == null || obj == null || obj2 == null || obj3 == null) {
            return;
        }
        try {
            Class<?> cls = obj3.getClass();
            Class<?> cls2 = obj2.getClass();
            if (!cls2.equals(cls)) {
                changeSuperClass(cls, cls2);
            }
            field.set(obj, obj3);
            Log.d(TAG, "changeField2Target succ");
        } catch (Throwable th) {
            Log.e(TAG, "changeField2Target", th);
        }
    }

    private static void changeSuperClass(Class<?> cls, Class<?> cls2) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = Class.class.getDeclaredField("superClass");
        declaredField.setAccessible(true);
        declaredField.set(cls, cls2);
    }

    private static String getSuperClassNameInDescriptor(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null) {
            return "";
        }
        return "L" + superclass.getName().replaceAll("[.]", "/") + ";";
    }

    private static void changeAccessFlagsBelowLForDalvik(Field field, int i) {
        if (!sIsInit) {
            sIsInit = SysOptimizer.loadOptimizerLibrary(null);
        }
        if (sIsInit) {
            try {
                Field declaredField = Field.class.getDeclaredField("slot");
                declaredField.setAccessible(true);
                int i2 = declaredField.getInt(field);
                Field declaredField2 = Field.class.getDeclaredField("declaringClass");
                declaredField2.setAccessible(true);
                Class cls = (Class) declaredField2.get(field);
                Log.d(TAG, "slot = " + i2 + ", accessFlags = " + i + ", modifiers = " + field.getModifiers());
                Log.d(TAG, "setModifiers succ = " + setModifiersForDalvik(cls, i2, i, field.getModifiers(), cls.getName()));
            } catch (Throwable th) {
                Log.e(TAG, "slotField", th);
            }
        }
    }

    private static void changeAccessFlagsBelowLForArt(Field field, int i) {
        try {
            Field declaredField = Field.class.getDeclaredField("artField");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(field);
            Field declaredField2 = obj.getClass().getDeclaredField("accessFlags");
            declaredField2.setAccessible(true);
            declaredField2.setInt(obj, i);
            Log.d(TAG, "changeAccessFlagsOnL succ");
        } catch (Throwable th) {
            Log.e(TAG, "changeAccessFlagBelowL error", th);
        }
    }

    private static void changeAccessFlagsAboveL(Field field, int i) {
        try {
            Field declaredField = Field.class.getDeclaredField("accessFlags");
            declaredField.setAccessible(true);
            declaredField.setInt(field, i);
            Log.d(TAG, "changeAccessFlagsAboveL succ");
        } catch (Throwable th) {
            Log.e(TAG, "changeAccessFlagsAboveL", th);
        }
    }

    public static boolean isArt() {
        String property = System.getProperty("java.vm.version");
        return property != null && property.startsWith("2");
    }
}
