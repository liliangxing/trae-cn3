package com.bytedance.sysoptimizer.java;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes5.dex */
public final class BinderServiceWrapperProtector {
    public static final AdminResult VOID_ADMIN_RESULT = new VoidAdminResult();
    private static boolean sDebug;

    /* loaded from: classes5.dex */
    public interface AdminResult {
        Object getDefaultResult(Object obj, Method method, Object[] objArr);
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    /* loaded from: classes5.dex */
    public static final class VoidAdminResult implements AdminResult {
        @Override // com.bytedance.sysoptimizer.java.BinderServiceWrapperProtector.AdminResult
        public Object getDefaultResult(Object obj, Method method, Object[] objArr) {
            return 1;
        }
    }

    public static boolean install(Context context, String str, final List<String> list, final String str2, final AdminResult adminResult) {
        try {
            Object systemService = context.getSystemService(str);
            if (systemService == null) {
                return false;
            }
            Field declaredField = systemService.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(systemService);
            if (obj == null) {
                return false;
            }
            Log.d(str2, "before " + obj);
            setProxy(Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() { // from class: com.bytedance.sysoptimizer.java.BinderServiceWrapperProtector.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj2, Method method, Object[] objArr) throws Throwable {
                    String name = method.getName();
                    if (list.contains(name)) {
                        try {
                            if (BinderServiceWrapperProtector.sDebug) {
                                Log.d(str2, "protect " + name);
                            }
                            return method.invoke(obj, objArr);
                        } catch (Throwable th) {
                            Log.e(str2, "get result failed: " + Log.getStackTraceString(th));
                            AdminResult adminResult2 = adminResult;
                            if (adminResult2 != null) {
                                return adminResult2.getDefaultResult(obj2, method, objArr);
                            }
                        }
                    }
                    return method.invoke(obj, objArr);
                }
            }), systemService, declaredField, str2);
            Log.d(str2, "install done " + declaredField.get(systemService));
            return true;
        } catch (Throwable th) {
            Log.e(str2, "install error: " + Log.getStackTraceString(th));
            return false;
        }
    }

    private static void setProxy(Object obj, Object obj2, Field field, String str) {
        try {
            field.set(obj2, obj);
        } catch (Throwable th) {
            Log.e(str, "setProxy error: " + Log.getStackTraceString(th));
        }
    }
}
