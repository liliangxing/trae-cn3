package com.bytedance.sysoptimizer.proxyinstance;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.FindCatchBlockOpt;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes5.dex */
public class ProxyInstance {
    private static final String TAG = "ProxyInstance";
    private static volatile ICallback sCallback;

    /* loaded from: classes5.dex */
    public interface ICallback {
        int d(String str, String str2);

        int e(String str, String str2);

        int e(String str, String str2, Throwable th);
    }

    private static native void nAdd(String str, String str2, Class cls, Class cls2);

    private static native void nRemoveFinal(Method method);

    public static native void nSetSynchronized(Method method);

    public static synchronized ICallback getCallback() {
        ICallback iCallback;
        synchronized (ProxyInstance.class) {
            iCallback = sCallback;
            if (iCallback == null) {
                iCallback = new ICallback() { // from class: com.bytedance.sysoptimizer.proxyinstance.ProxyInstance.1
                    @Override // com.bytedance.sysoptimizer.proxyinstance.ProxyInstance.ICallback
                    public int d(String str, String str2) {
                        System.out.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.proxyinstance.ProxyInstance.ICallback
                    public int e(String str, String str2) {
                        System.err.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.proxyinstance.ProxyInstance.ICallback
                    public int e(String str, String str2, Throwable th) {
                        System.err.println(str + ", " + str2 + ", " + Log.getStackTraceString(th));
                        return 0;
                    }
                };
                updateCallback(iCallback);
            }
        }
        return iCallback;
    }

    public static synchronized void updateCallback(ICallback iCallback) {
        synchronized (ProxyInstance.class) {
            sCallback = iCallback;
        }
    }

    public static void logStackTrace() {
        getCallback().e(TAG, "logStackTrace", new Throwable());
    }

    public static boolean isEnable() {
        ICallback callback = getCallback();
        if (Build.VERSION.SDK_INT < 27 || Build.VERSION.SDK_INT > 34) {
            callback.e(TAG, "NOT SUPPORT API LEVEL " + Build.VERSION.SDK_INT);
            return false;
        }
        if (!Process.is64Bit()) {
            callback.e(TAG, "NOT SUPPORT 32Bit");
            return false;
        }
        for (String str : Build.SUPPORTED_ABIS) {
            if (!TextUtils.isEmpty(str) && str.startsWith("x86")) {
                callback.e(TAG, "ONLY SUPPORT arm64-v8a.But current are " + TextUtils.join(",", Build.SUPPORTED_ABIS));
                return false;
            }
        }
        return true;
    }

    private static void add(Class cls, Class cls2) {
        getCallback().d(TAG, "add() called with: originClass = [" + cls + "], proxyClass = [" + cls2 + "]");
        try {
            Class.forName(cls2.getName(), true, cls2.getClassLoader());
            String classSignature = FindCatchBlockOpt.Util.getClassSignature(cls);
            String replace = cls2.getName().replace('.', '/');
            getCallback().d(TAG, "add() called with: originClass = [" + classSignature + "], proxyClass = [" + replace + "]");
            nAdd(classSignature, replace, cls, cls2);
        } catch (Throwable th) {
            getCallback().e(TAG, "add() called", th);
        }
    }

    private static void updateAccessFlag(Class cls) {
        try {
            Field field = DoubleReflectUtils.getField(Class.class, "objectSizeAllocFastPath");
            field.setAccessible(true);
            field.set(cls, 2147483632);
            Field field2 = DoubleReflectUtils.getField(Class.class, "accessFlags");
            field2.setAccessible(true);
            int intValue = ((Integer) field2.get(cls)).intValue();
            if ((intValue & Integer.MIN_VALUE) != 0) {
                getCallback().e(TAG, "isFinalizable Class 1 " + cls);
            }
            field2.set(cls, Integer.valueOf((intValue | Integer.MIN_VALUE | 1) & (-17)));
            for (Method method : cls.getDeclaredMethods()) {
                method.setAccessible(true);
                getCallback().d(TAG, "add() called method = [" + method + "]");
                if (Modifier.isFinal(method.getModifiers())) {
                    method.setAccessible(true);
                    getCallback().d(TAG, "add() called RemoveFinal method = [" + method + "]");
                    nRemoveFinal(method);
                }
            }
        } catch (Throwable th) {
            getCallback().e(TAG, "updateAccessFlag() called", th);
        }
    }

    public static void add(String str, String str2) {
        add(str, true, ProxyInstance.class.getClassLoader(), str2, true, ProxyInstance.class.getClassLoader());
    }

    public static void add(String str, boolean z, ClassLoader classLoader, String str2, boolean z2, ClassLoader classLoader2) {
        if (isEnable()) {
            try {
                getCallback().d(TAG, "add() called with: originClass = [" + str + "], proxyClass = [" + str2 + "]");
                if (SysOptimizer.loadOptimizerLibrary(null)) {
                    ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                    Class<?> cls = Class.forName(str, z, classLoader);
                    updateAccessFlag(cls);
                    add(cls, Class.forName(str2, z2, classLoader2));
                }
            } catch (Throwable th) {
                getCallback().e(TAG, "add() called", th);
            }
        }
    }
}
