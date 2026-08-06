package com.bytedance.android.monitorV2.util;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    private ReflectUtils() {
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable th) {
            MonitorLog.e(TAG, "exception in getMethod, pkg : " + cls.getName() + ", function : " + str + ", " + th.toString());
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static Object invokeMethod(Method method, Object[] objArr, Object... objArr2) {
        try {
            method.setAccessible(true);
            if (objArr2 != null && objArr2.length > 0) {
                return method.invoke(objArr2[0], objArr);
            }
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            MonitorLog.e(TAG, "exception in invokeMethod, function : " + method + ", " + th.toString());
            return null;
        }
    }

    public static Object invokeMethod(Class<?> cls, String str, Object... objArr) {
        return invokeMethod(cls, str, null, null, objArr);
    }

    public static Object invokeMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr, Object... objArr2) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            if (clsArr == null) {
                clsArr = new Class[0];
            }
            if (objArr == null) {
                objArr = new Object[0];
            }
            try {
                Method method = getMethod(cls, str, clsArr);
                if (method == null) {
                    return null;
                }
                method.setAccessible(true);
                if (objArr2 != null && objArr2.length > 0) {
                    return method.invoke(objArr2[0], objArr);
                }
                return method.invoke(null, objArr);
            } catch (Throwable th) {
                MonitorLog.e(TAG, "exception in invokeMethod, pkg : " + cls.getName() + ", function : " + str + ", " + th.toString());
            }
        }
        return null;
    }

    public static Object getFiledValue(Object obj, Class<?> cls) {
        if (obj != null && cls != null) {
            try {
                Field[] declaredFields = obj.getClass().getDeclaredFields();
                for (int i = 0; i < declaredFields.length; i++) {
                    declaredFields[i].setAccessible(true);
                    if (declaredFields[i].getType().getName().equals(cls.getName())) {
                        return declaredFields[i].get(obj);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Object getStaticFieldValue(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
