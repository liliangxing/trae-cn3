package com.bytedance.sysoptimizer.javahook;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.BitmapRecycleOpt;
import com.bytedance.sysoptimizer.FindCatchBlockOpt;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes5.dex */
public class AHook {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "AHook";
    private static Field artMethodField;
    private static Method dummyInvokeMethod;
    private static Method invokeMethod;
    private static Method invokeMethodFast;
    private static final AtomicBoolean sInit = new AtomicBoolean(false);
    public static ConcurrentHashMap<String, HookItem> sOriginMethod = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Constructor> sOriginConstructor = new ConcurrentHashMap<>();
    private static volatile ICallback sCallback = null;

    /* loaded from: classes5.dex */
    public interface ICallback {
        int d(String str, String str2);

        int e(String str, String str2);

        int e(String str, String str2, Throwable th);
    }

    private static native Object invoke(long j, String str, Object obj, Object obj2, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    private static native int nClearTLSIgnoreFlag(long j, Class cls, boolean z);

    public static native void nDumpClz(Class cls);

    private static native void nDumpObj(Object obj);

    private static native void nEnsureFastNative(long j);

    private static native int nSetTLSIgnoreFlag(long j, Class cls, boolean z);

    private static native int nStart(long j, long j2, long[] jArr);

    private static native void reservedForJniOffset();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class HookItem {
        Method origin;
        Constructor originConst;
        Method proxy;
        Constructor proxyConst;
        boolean unHookVTableWhenInvokeOrigin;

        private HookItem() {
        }
    }

    public static synchronized ICallback getCallback() {
        ICallback iCallback;
        synchronized (AHook.class) {
            iCallback = sCallback;
            if (iCallback == null) {
                iCallback = new ICallback() { // from class: com.bytedance.sysoptimizer.javahook.AHook.1
                    @Override // com.bytedance.sysoptimizer.javahook.AHook.ICallback
                    public int d(String str, String str2) {
                        System.out.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.javahook.AHook.ICallback
                    public int e(String str, String str2) {
                        System.err.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.javahook.AHook.ICallback
                    public int e(String str, String str2, Throwable th) {
                        System.err.println(str + ", " + str2 + ", " + th);
                        return 0;
                    }
                };
                updateCallback(iCallback);
            }
        }
        return iCallback;
    }

    private static synchronized void updateCallback(ICallback iCallback) {
        synchronized (AHook.class) {
            sCallback = iCallback;
        }
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

    public static void init(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ICallback iCallback) throws NoSuchMethodException, IllegalAccessException {
        throw new RuntimeException("AHook not support In Doubao");
    }

    public static void mockMessageQueueCrash(boolean z) {
        if (z) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sysoptimizer.javahook.AHook.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AHook.callOrigin(OriginMethodKey.KEY_REMOVE_SYNC_BARRIER, Looper.myQueue(), 0);
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                }
            }, 2000L);
        }
    }

    public static void assertHookMessageQueue(boolean z) {
        if (z) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sysoptimizer.javahook.AHook.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AHook.assertHookMessageQueue();
                    } catch (Throwable th) {
                        throw new IllegalStateException(th);
                    }
                }
            }, 1000L);
        }
    }

    public static void addHook(Method method, Method method2, boolean z, Method... methodArr) throws IllegalAccessException {
        if (!sInit.get()) {
            getCallback().e(TAG, "addHook() not init");
            return;
        }
        if (method == null || method2 == null) {
            getCallback().e(TAG, "addHook() origin=[" + method + "], proxy=[" + method2 + "]");
            return;
        }
        String key = getKey(method);
        getCallback().d(TAG, "addHook() key=[" + key + "]");
        HookItem hookItem = new HookItem();
        hookItem.origin = method;
        hookItem.proxy = method2;
        hookItem.unHookVTableWhenInvokeOrigin = z;
        sOriginMethod.put(key, hookItem);
        hook1(method, method2, methodArr);
        getCallback().d(TAG, "addHook() end");
    }

    public static void addHookConstructor(Constructor constructor, Executable executable) throws IllegalAccessException {
        if (!sInit.get()) {
            getCallback().e(TAG, "addHookConstructor() not init");
            return;
        }
        if (constructor == null || executable == null) {
            getCallback().e(TAG, "addHookConstructor() origin=[" + constructor + "], proxy=[" + executable + "]");
            return;
        }
        String key = getKey(constructor);
        getCallback().d(TAG, "addHookConstructor() key=[" + key + "]");
        sOriginConstructor.put(key, constructor);
        hookConstructor(constructor, executable, new Method[0]);
        getCallback().d(TAG, "addHookConstructor() end");
    }

    private static String getKey(Method method) {
        return method.getDeclaringClass().getName() + LibrarianImpl.Constants.DOT + method.getName() + FindCatchBlockOpt.Util.getMethodSignature(method.getParameterTypes(), method.getReturnType());
    }

    private static String getKey(Constructor constructor) {
        return constructor.getName() + FindCatchBlockOpt.Util.getMethodSignature(constructor.getParameterTypes(), Void.TYPE);
    }

    private static void beforeHook() {
        new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.javahook.AHook.4
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888).recycle();
                        SystemClock.sleep(1L);
                    } catch (Throwable th) {
                        throw new IllegalStateException(th);
                    }
                }
            }
        }).start();
        SystemClock.sleep(100L);
    }

    public static void assertHookBitmapRecycle() {
        Bitmap createBitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
        try {
            FindCatchBlockOpt.Util.printMethods("android.graphics.Bitmap", createBitmap);
            BitmapRecycleOpt.start(null, false);
            createBitmap.recycle();
            if (createBitmap.isRecycled()) {
                throw new IllegalStateException();
            }
        } catch (Throwable th) {
            throw new IllegalStateException(th);
        }
    }

    public static void assertHookMessageQueue() {
        try {
            MessageQueue myQueue = Looper.myQueue();
            FindCatchBlockOpt.Util.printMethods("java.lang.Class", myQueue.getClass());
            FindCatchBlockOpt.Util.printMethods("android.os.MessageQueue", myQueue);
            callOrigin(OriginMethodKey.KEY_REMOVE_SYNC_BARRIER, myQueue, 0);
        } catch (Throwable unused) {
        }
    }

    private static void hook1(Method method, Method method2, Method... methodArr) throws IllegalAccessException {
        getCallback().d(TAG, "hook1() called with: origin = [" + method + "], proxy = [" + method2 + "]");
        if (SysOptimizer.loadOptimizerLibrary(null)) {
            ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
            if (getArtMethodField() == null) {
                getCallback().e(TAG, "getArtMethodField() == null");
                return;
            }
            long artMethodOf = artMethodOf(method);
            long artMethodOf2 = artMethodOf(method2);
            getCallback().d(TAG, "hook1() called with: originArtMethod = [" + Long.toHexString(artMethodOf) + "], proxyArtMethod = [" + Long.toHexString(artMethodOf2) + "]");
            reservedForJniOffset();
            nStart(artMethodOf, artMethodOf2, getArtMethods(methodArr));
        }
    }

    private static void hookConstructor(Constructor constructor, Executable executable, Method... methodArr) throws IllegalAccessException {
        getCallback().d(TAG, "hookConstructor() called with: origin = [" + constructor + "], proxy = [" + executable + "]");
        if (SysOptimizer.loadOptimizerLibrary(null)) {
            ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
            if (getArtMethodField() == null) {
                getCallback().e(TAG, "getArtMethodField() == null");
                return;
            }
            long artMethodOf = artMethodOf(constructor);
            long artMethodOf2 = artMethodOf(executable);
            getCallback().d(TAG, "hookConstructor() called with: originArtMethod = [" + Long.toHexString(artMethodOf) + "], proxyArtMethod = [" + Long.toHexString(artMethodOf2) + "]");
            reservedForJniOffset();
            nStart(artMethodOf, artMethodOf2, getArtMethods(methodArr));
        }
    }

    private static long[] getArtMethods(Method[] methodArr) {
        if (methodArr == null || methodArr.length == 0) {
            return new long[0];
        }
        int length = methodArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = artMethodOf(methodArr[i]);
        }
        return jArr;
    }

    private static long artMethodOf(Executable executable) {
        Field artMethodField2 = getArtMethodField();
        artMethodField2.setAccessible(true);
        try {
            return ((Long) artMethodField2.get(executable)).longValue();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private static Field getArtMethodField() {
        Field field = artMethodField;
        if (field != null) {
            return field;
        }
        Field field2 = DoubleReflectUtils.getField(Executable.class, "artMethod");
        artMethodField = field2;
        return field2;
    }

    private static Method getMethodInvoke() {
        Method method = invokeMethod;
        if (method != null) {
            return method;
        }
        try {
            invokeMethod = DoubleReflectUtils.getMethodInner(Method.class, "invoke", Object.class, Object[].class);
        } catch (Throwable th) {
            getCallback().e(TAG, "getMethodInvoke", th);
        }
        return invokeMethod;
    }

    private static Method getDummyInvokeMethod() {
        Method method = dummyInvokeMethod;
        if (method != null) {
            return method;
        }
        try {
            dummyInvokeMethod = DoubleReflectUtils.getMethodInner(AHook.class, "dummyInvoke", new Class[0]);
        } catch (Throwable th) {
            getCallback().e(TAG, "getDummyInvokeMethod", th);
        }
        return dummyInvokeMethod;
    }

    private static Method getMethodInvokeFast() {
        Method method = invokeMethodFast;
        if (method != null) {
            return method;
        }
        try {
            invokeMethodFast = DoubleReflectUtils.getMethodInner(AHook.class, "invoke", Long.TYPE, String.class, Object.class, Object.class, Object[].class);
        } catch (Throwable th) {
            getCallback().e(TAG, "getMethodInvokeFast", th);
        }
        return invokeMethodFast;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object callOrigin(String str, Object obj, Object... objArr) throws Throwable {
        HookItem hookItem = sOriginMethod.get(str);
        Method method = hookItem != null ? hookItem.origin : null;
        Constructor constructor = method == null ? sOriginConstructor.get(str) : 0;
        Class<?> declaringClass = method != null ? method.getDeclaringClass() : constructor.getDeclaringClass();
        long artMethodOf = artMethodOf(method != null ? method : constructor);
        boolean z = hookItem != null && hookItem.unHookVTableWhenInvokeOrigin;
        try {
            nSetTLSIgnoreFlag(artMethodOf, declaringClass, z);
            if (method == null) {
                constructor.setAccessible(true);
                getCallback().e(TAG, "callOrigin c=" + constructor + ", args=" + Arrays.toString(objArr));
                return getDummyInvokeMethod().invoke(new Object[]{constructor, obj}, objArr);
            }
            method.setAccessible(true);
            char[] shorty = getShorty(method);
            getCallback().e(TAG, "callOrigin method=" + method + ", obj=" + obj + ", args=" + Arrays.toString(objArr) + ", shorty=" + Arrays.toString(shorty));
            if (!Modifier.isStatic(method.getModifiers()) && !Modifier.isFinal(method.getDeclaringClass().getModifiers())) {
                return getDummyInvokeMethod().invoke(new Object[]{method, obj, new String(shorty)}, objArr);
            }
            getCallback().e(TAG, "callOrigin by reflect " + method);
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            try {
                getCallback().e(TAG, "callOrigin e", th);
                Throwable cause = th.getCause();
                getCallback().e(TAG, "callOrigin t", cause);
                if (cause == null) {
                    return null;
                }
                throw cause;
            } finally {
                nClearTLSIgnoreFlag(artMethodOf, declaringClass, z);
            }
        }
    }

    private static char getShorty(Class cls) {
        if (!cls.isPrimitive()) {
            return Matrix.MATRIX_TYPE_RANDOM_LT;
        }
        if (cls == Integer.TYPE) {
            return 'I';
        }
        if (cls == Byte.TYPE) {
            return 'B';
        }
        if (cls == Long.TYPE) {
            return 'J';
        }
        if (cls == Float.TYPE) {
            return 'F';
        }
        if (cls == Double.TYPE) {
            return 'D';
        }
        if (cls == Short.TYPE) {
            return 'S';
        }
        if (cls == Character.TYPE) {
            return 'C';
        }
        if (cls == Boolean.TYPE) {
            return Matrix.MATRIX_TYPE_ZERO;
        }
        if (cls == Void.TYPE) {
            return 'V';
        }
        throw new InternalError();
    }

    private static char[] getShorty(Executable executable) {
        Class<?>[] parameterTypes = executable.getParameterTypes();
        char[] cArr = new char[parameterTypes.length + 1];
        int i = 0;
        if (executable instanceof Method) {
            cArr[0] = getShorty(((Method) executable).getReturnType());
        } else {
            cArr[0] = 'V';
        }
        while (i < parameterTypes.length) {
            Class<?> cls = parameterTypes[i];
            i++;
            cArr[i] = getShorty(cls);
        }
        return cArr;
    }

    public final void dummyInvoke() {
        try {
            Object.class.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
