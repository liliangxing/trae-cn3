package com.bytedance.sysoptimizer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes5.dex */
public class FindCatchBlockOpt {
    private static final String TAG = "FindCatchBlockOpt";
    private static volatile ICallback sCallback;
    private static volatile boolean sInit;

    /* loaded from: classes5.dex */
    public interface ICallback {
        int d(String str, String str2);

        int e(String str, String str2);

        int e(String str, String str2, Throwable th);
    }

    private static native int nStart(boolean z, boolean z2, CatchException[] catchExceptionArr, String str);

    private static native void reservedForJniOffset();

    static /* synthetic */ ICallback access$000() {
        return getCallback();
    }

    private static ICallback getCallback() {
        ICallback iCallback;
        synchronized (FindCatchBlockOpt.class) {
            iCallback = sCallback;
            if (iCallback == null) {
                iCallback = new ICallback() { // from class: com.bytedance.sysoptimizer.FindCatchBlockOpt.1
                    @Override // com.bytedance.sysoptimizer.FindCatchBlockOpt.ICallback
                    public int d(String str, String str2) {
                        System.out.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.FindCatchBlockOpt.ICallback
                    public int e(String str, String str2) {
                        System.err.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.FindCatchBlockOpt.ICallback
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

    private static void updateCallback(ICallback iCallback) {
        synchronized (FindCatchBlockOpt.class) {
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

    public static int start(Context context, boolean z, boolean z2, boolean z3, CatchException[] catchExceptionArr, ICallback iCallback, String str) {
        if (!isEnable()) {
            return -1;
        }
        if (sInit) {
            iCallback.e(TAG, "Already sInit." + Log.getStackTraceString(new Throwable()));
            return 1;
        }
        if (!SysOptimizer.loadOptimizerLibrary(context) || sInit) {
            return -1;
        }
        if (z2) {
            Flipped.invokeHiddenApiRestrictions();
        }
        reservedForJniOffset();
        replaceClassName(catchExceptionArr);
        updateCallback(iCallback);
        int nStart = nStart(z, z3, catchExceptionArr, str);
        sInit = true;
        return nStart;
    }

    private static void replaceClassName(CatchException[] catchExceptionArr) {
        for (CatchException catchException : catchExceptionArr) {
            catchException.declaringClass = catchException.declaringClass.replace('.', '/');
            for (CatchStackTrace catchStackTrace : catchException.stackTrace) {
                catchStackTrace.declaringClass = catchStackTrace.declaringClass.replace('.', '/');
            }
            getCallback().e(TAG, catchException.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static class Util {
        private static final String TAG = "Util";

        public static void printMethods(String str, Object obj) {
            Log.d(TAG, "printMethods() called with: clazz = [" + str + "], o = [" + obj + "]");
            try {
                printMethods(Class.forName(str, false, FindCatchBlockOpt.class.getClassLoader()), obj);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public static void printMethods(Class cls, Object obj) {
            Log.d(TAG, "printMethods() called with: clz = [" + cls + "], o = [" + obj + "]");
            try {
                for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                    Log.d(TAG, "printMethods() c = [" + constructor + "], sig=[" + getMethodSignature(constructor.getParameterTypes(), Void.TYPE) + "]");
                }
                for (Method method : cls.getDeclaredMethods()) {
                    Log.d(TAG, "printMethods() getDeclaredMethods m = [" + method + "], sig=[" + getMethodSignature(method.getParameterTypes(), method.getReturnType()) + "]");
                }
                for (Method method2 : cls.getMethods()) {
                    Log.d(TAG, "printMethods() getMethods m = [" + method2 + "], sig=[" + getMethodSignature(method2.getParameterTypes(), method2.getReturnType()) + "]");
                }
                for (Field field : cls.getDeclaredFields()) {
                    Log.d(TAG, "printMethods() f = [" + field + "], offset = [" + DoubleReflectUtils.readField(field, "offset") + "], val = [" + (obj != null ? DoubleReflectUtils.readField(obj, field.getName()) : null) + "]");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public static List<String> getMethodSig(String str, String str2) {
            ArrayList arrayList = new ArrayList();
            try {
                Class<?> cls = Class.forName(str, false, FindCatchBlockOpt.class.getClassLoader());
                for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                    String methodSignature = getMethodSignature(constructor.getParameterTypes(), Void.TYPE);
                    Log.d(TAG, "getMethodSig() c = [" + constructor + "], sig = [" + methodSignature + "]");
                    if (constructor.getName().equals(str2)) {
                        arrayList.add(methodSignature);
                    }
                }
                for (Method method : cls.getDeclaredMethods()) {
                    String methodSignature2 = getMethodSignature(method.getParameterTypes(), method.getReturnType());
                    Log.d(TAG, "getMethodSig() m = [" + method + "], sig = [" + methodSignature2 + "]");
                    if (method.getName().equals(str2)) {
                        arrayList.add(methodSignature2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return arrayList;
        }

        public static String getClassSignature(Class<?> cls) {
            StringBuilder sb = new StringBuilder();
            while (cls.isArray()) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                cls = cls.getComponentType();
            }
            if (cls.isPrimitive()) {
                if (cls == Integer.TYPE) {
                    sb.append('I');
                } else if (cls == Byte.TYPE) {
                    sb.append('B');
                } else if (cls == Long.TYPE) {
                    sb.append('J');
                } else if (cls == Float.TYPE) {
                    sb.append('F');
                } else if (cls == Double.TYPE) {
                    sb.append('D');
                } else if (cls == Short.TYPE) {
                    sb.append('S');
                } else if (cls == Character.TYPE) {
                    sb.append('C');
                } else if (cls == Boolean.TYPE) {
                    sb.append(Matrix.MATRIX_TYPE_ZERO);
                } else if (cls == Void.TYPE) {
                    sb.append('V');
                } else {
                    throw new InternalError();
                }
            } else {
                sb.append("L" + cls.getName().replace('.', '/') + ';');
            }
            return sb.toString();
        }

        public static String getMethodSignature(Class<?>[] clsArr, Class<?> cls) {
            StringBuilder sb = new StringBuilder("(");
            for (Class<?> cls2 : clsArr) {
                sb.append(getClassSignature(cls2));
            }
            sb.append(')');
            sb.append(getClassSignature(cls));
            return sb.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static class Tester {
        private static final String TAG = "Tester";
        private static long sMethodB4Called;

        static {
            FindCatchBlockOpt.access$000().e(TAG, " <clinit> called.");
        }

        public Tester() {
        }

        public Tester(int i) {
        }

        public Tester(long j) {
        }

        public static void start(final Context context, final boolean z, final int i) {
            if (FindCatchBlockOpt.isEnable()) {
                new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.FindCatchBlockOpt.Tester.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z2;
                        SystemClock.sleep(i);
                        for (int i2 = 0; i2 < 100; i2++) {
                            try {
                                Tester.methodA(context);
                            } finally {
                                if (!z2) {
                                }
                            }
                        }
                    }
                }).start();
            }
        }

        public static void methodA(Context context) {
            methodB5();
            methodB4();
            methodB2(methodB0(context), methodB1());
            methodB3();
        }

        public static ConnectivityManager.NetworkCallback methodB1() {
            return new ConnectivityManager.NetworkCallback();
        }

        public static void methodB3() {
            try {
                Log.d(TAG, "methodB3() called");
            } catch (Throwable unused) {
            }
        }

        public static void methodB4() {
            Log.d(TAG, "methodB4() called");
            sMethodB4Called++;
            Object o = getO();
            if (o == null) {
                o.hashCode();
            }
        }

        public static void methodB5() {
            Log.d(TAG, "methodB5() called");
            Object o = getO();
            if (o == null) {
                throw new UninitializedPropertyAccessException("lateinit property description has not been initialized");
            }
            o.hashCode();
        }

        public static Object getO() {
            Log.d(TAG, "getO() called");
            return null;
        }

        public static void methodB2(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
            for (int i = 0; i < 100; i++) {
                methodC0(connectivityManager, networkCallback);
            }
        }

        public static void methodC0(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }

        public static ConnectivityManager methodB0(Context context) {
            return (ConnectivityManager) context.getSystemService("connectivity");
        }

        /* loaded from: classes5.dex */
        public static class UninitializedPropertyAccessException extends RuntimeException {
            public UninitializedPropertyAccessException(String str) {
                super(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class ForReadInstrumentation {
        private ForReadInstrumentation() {
        }

        static {
            FindCatchBlockOpt.access$000().e(FindCatchBlockOpt.TAG, "called ForReadInstrumentation <clinit>");
        }

        private static void A() {
            FindCatchBlockOpt.access$000().e(FindCatchBlockOpt.TAG, "called ForReadInstrumentation A");
        }

        private static void gc() {
            FindCatchBlockOpt.access$000().e(FindCatchBlockOpt.TAG, "called ForReadInstrumentation gc");
            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
        }
    }

    /* loaded from: classes5.dex */
    public static class CatchStackTrace {
        public String declaringClass;
        public boolean isStatic;
        public String methodName;
        public String methodSig;

        public String toString() {
            return "CatchStackTrace{declaringClass='" + this.declaringClass + "', methodName='" + this.methodName + "', methodSig='" + this.methodSig + "', isStatic=" + this.isStatic + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* loaded from: classes5.dex */
    public static class CatchException {
        public String declaringClass;
        public String detailMessage;
        public CatchStackTrace[] stackTrace;

        public String toString() {
            return "CatchException{declaringClass='" + this.declaringClass + "', detailMessage='" + this.detailMessage + "', stackTrace=" + Arrays.toString(this.stackTrace) + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
