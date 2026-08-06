package com.bytedance.reparo.core.utils;

import android.os.Build;
import com.bytedance.reparo.core.PatchLogger;
import com.bytedance.reparo.core.PatchUtils;
import com.bytedance.reparo.core.exception.ReturnMayWithError;
import com.bytedance.reparo.core.log.TLog;
import com.bytedance.reparo.core.utils.reflect.GetDeclaredFields;
import com.bytedance.reparo.core.utils.reflect.GetDeclaredMethods;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ReflectUtils {
    private static GetDeclaredFields sGetDeclaredFieldsUnchecked;
    private static GetDeclaredMethods sGetDeclaredMethodsUnchecked;
    private static final Method[] EMPTY_METHODS = new Method[0];
    private static final Field[] EMPTY_FIELDS = new Field[0];

    private static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeField(field, null, obj);
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        return findField((Class) obj.getClass(), str);
    }

    public static Field findField(Class cls, String str) throws NoSuchFieldException {
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + cls);
    }

    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return findMethod((Class) obj.getClass(), str, clsArr);
    }

    public static Method findMethod(Class cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method findMethodWithPeer(Class cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class[] clsArr2 = new Class[clsArr.length + 1];
        System.arraycopy(clsArr, 0, clsArr2, 1, clsArr.length);
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            Class peerPatchClass = PatchUtils.getPeerPatchClass(cls2.getName());
            if (peerPatchClass != 0) {
                PatchLogger.m305i("Reparo", "findPeerPatchClass " + peerPatchClass.getName());
                try {
                    clsArr2[0] = cls2;
                    Method declaredMethod = peerPatchClass.getDeclaredMethod(PatchUtils.getReplacePatchName(cls2.getName(), str), clsArr2);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    return declaredMethod;
                } catch (NoSuchMethodException unused) {
                }
            }
            try {
                Method declaredMethod2 = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod2.isAccessible()) {
                    declaredMethod2.setAccessible(true);
                }
                return declaredMethod2;
            } catch (NoSuchMethodException unused2) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + cls);
    }

    public static ReturnMayWithError<Method[], NoClassDefFoundError> getDeclaredMethods(Class cls) {
        Method[] methodArr = EMPTY_METHODS;
        try {
            methodArr = cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            try {
                Method[] declaredMethodsUnchecked = getDeclaredMethodsUnchecked(cls);
                ArrayList arrayList = new ArrayList(declaredMethodsUnchecked.length);
                for (Method method : declaredMethodsUnchecked) {
                    try {
                        method.getReturnType();
                        method.getParameterTypes();
                        arrayList.add(method);
                    } catch (Throwable th) {
                        TLog.m324w("Error when getDeclaredMethods for " + cls, th);
                        e.addSuppressed(th);
                    }
                }
                Method[] methodArr2 = new Method[arrayList.size()];
                arrayList.toArray(methodArr2);
                if (Build.VERSION.SDK_INT != 26 && Build.VERSION.SDK_INT != 27) {
                    return new ReturnMayWithError<>(methodArr2, null);
                }
                return new ReturnMayWithError<>(methodArr2, e);
            } catch (NoSuchMethodException unused) {
            } catch (Throwable th2) {
                TLog.m321e("Err when getDeclaredMethods for cls " + cls, th2);
            }
        } catch (Throwable th3) {
            TLog.m321e("Err when getDeclaredMethods for cls " + cls, th3);
        }
        return new ReturnMayWithError<>(methodArr, null);
    }

    private static Method[] getDeclaredMethodsUnchecked(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (sGetDeclaredMethodsUnchecked == null) {
            sGetDeclaredMethodsUnchecked = new GetDeclaredMethods();
        }
        return sGetDeclaredMethodsUnchecked.invoke(cls, new Object[0]);
    }

    public static Field[] getDeclaredFields(Class cls) {
        Field[] fieldArr = EMPTY_FIELDS;
        try {
            try {
                return cls.getDeclaredFields();
            } catch (NoSuchMethodException unused) {
                return fieldArr;
            } catch (Throwable th) {
                TLog.m321e("Err when getDeclaredFields for cls " + cls, th);
                return fieldArr;
            }
        } catch (NoClassDefFoundError unused2) {
            Field[] declaredFieldsUnchecked = getDeclaredFieldsUnchecked(cls);
            ArrayList arrayList = new ArrayList(declaredFieldsUnchecked.length);
            for (Field field : declaredFieldsUnchecked) {
                try {
                    field.getType();
                    arrayList.add(field);
                } catch (Throwable th2) {
                    TLog.m324w("Error when getDeclaredFields for " + cls, th2);
                }
            }
            fieldArr = new Field[arrayList.size()];
            return (Field[]) arrayList.toArray(fieldArr);
        } catch (Throwable unused3) {
            return EMPTY_FIELDS;
        }
    }

    private static Field[] getDeclaredFieldsUnchecked(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (sGetDeclaredFieldsUnchecked == null) {
            sGetDeclaredFieldsUnchecked = new GetDeclaredFields();
        }
        return sGetDeclaredFieldsUnchecked.invoke(cls, new Object[0]);
    }
}
