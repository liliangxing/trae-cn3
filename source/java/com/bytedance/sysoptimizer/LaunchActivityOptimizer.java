package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.DeadSystemException;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class LaunchActivityOptimizer {
    private static boolean initialized;
    private static Activity mActivity;
    private static CopyOnWriteArrayList<ExceptionCatcher> sExceptionCatchers = new CopyOnWriteArrayList<>();

    public static Field getDeclaredField(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                Field field = HackHelper.getField(cls, str);
                if (field != null) {
                    return field;
                }
            }
        }
        return null;
    }

    public static void setStartedActivity(Activity activity) {
        Field declaredField = getDeclaredField(activity, "mStartedActivity");
        if (declaredField != null) {
            try {
                declaredField.setAccessible(true);
                declaredField.set(activity, true);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class LaunchActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            Activity unused = LaunchActivityOptimizer.mActivity = activity;
            LaunchActivityOptimizer.hookAMS(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            Activity unused = LaunchActivityOptimizer.mActivity = activity;
            LaunchActivityOptimizer.setStartedActivity(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            Activity unused = LaunchActivityOptimizer.mActivity = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            Activity unused = LaunchActivityOptimizer.mActivity = null;
        }
    }

    public static void hookAMS(boolean z) {
        Field declaredField;
        if (initialized) {
            return;
        }
        initialized = true;
        HackHelper.init();
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            final Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            if (z) {
                Class<?> cls = Class.forName("android.app.IActivityManager");
                if (cls == null) {
                    return;
                }
                declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.bytedance.sysoptimizer.LaunchActivityOptimizer.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj3, Method method, Object[] objArr) throws Throwable {
                        if (method.getName().contains("reportSizeConfigurations")) {
                            try {
                                return method.invoke(obj2, objArr);
                            } catch (InvocationTargetException e) {
                                if (e.getTargetException() instanceof IllegalArgumentException) {
                                    return null;
                                }
                            }
                        }
                        if (method.getName().contains("isTopOfTask")) {
                            try {
                                return method.invoke(obj2, objArr);
                            } catch (InvocationTargetException e2) {
                                if (e2.getTargetException() instanceof IllegalArgumentException) {
                                    return false;
                                }
                            }
                        }
                        if (method.getName().contains("willActivityBeVisible")) {
                            try {
                                LaunchActivityOptimizer.mActivity.isImmersive();
                            } catch (IllegalArgumentException unused) {
                                if (LaunchActivityOptimizer.mActivity != null) {
                                    LaunchActivityOptimizer.mActivity.finish();
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                        try {
                            return method.invoke(obj2, objArr);
                        } catch (Throwable th) {
                            Iterator it = LaunchActivityOptimizer.sExceptionCatchers.iterator();
                            while (it.hasNext()) {
                                if (((ExceptionCatcher) it.next()).analysis(th)) {
                                    return null;
                                }
                            }
                            throw LaunchActivityOptimizer.getSafeThrowable(th);
                        }
                    }
                }));
                return;
            }
            declaredField2.set(obj, obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    public static void registerExceptionCatcher(ExceptionCatcher exceptionCatcher) {
        if (exceptionCatcher == null || !exceptionCatcher.registerCondition() || sExceptionCatchers.contains(exceptionCatcher)) {
            return;
        }
        sExceptionCatchers.add(exceptionCatcher);
    }

    public static void unRegisterExceptionCatcher(ExceptionCatcher exceptionCatcher) {
        if (exceptionCatcher == null) {
            return;
        }
        sExceptionCatchers.remove(exceptionCatcher);
    }

    /* loaded from: classes5.dex */
    public static class DeadException implements ExceptionCatcher {
        @Override // com.bytedance.sysoptimizer.ExceptionCatcher
        public boolean registerCondition() {
            return true;
        }

        @Override // com.bytedance.sysoptimizer.ExceptionCatcher
        public boolean analysis(Throwable th) {
            if (!(th instanceof InvocationTargetException)) {
                return false;
            }
            InvocationTargetException invocationTargetException = (InvocationTargetException) th;
            return (invocationTargetException.getTargetException() instanceof DeadObjectException) || (invocationTargetException.getTargetException() instanceof DeadSystemException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0046 A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x0011, B:7:0x003c, B:8:0x0043, B:10:0x0046, B:14:0x0079, B:15:0x004b, B:17:0x0055, B:19:0x005d, B:21:0x0069, B:27:0x0076, B:30:0x007c, B:34:0x0083, B:36:0x008b, B:38:0x0096, B:41:0x001a, B:43:0x0020, B:45:0x0024, B:47:0x002d, B:48:0x0036), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x0011, B:7:0x003c, B:8:0x0043, B:10:0x0046, B:14:0x0079, B:15:0x004b, B:17:0x0055, B:19:0x005d, B:21:0x0069, B:27:0x0076, B:30:0x007c, B:34:0x0083, B:36:0x008b, B:38:0x0096, B:41:0x001a, B:43:0x0020, B:45:0x0024, B:47:0x002d, B:48:0x0036), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Throwable getSafeThrowable(Throwable th) {
        StackTraceElement[] stackTrace;
        RuntimeException runtimeException;
        ArrayList arrayList;
        try {
            stackTrace = th.getStackTrace();
        } catch (Throwable unused) {
        }
        if (th instanceof InvocationTargetException) {
            InvocationTargetException invocationTargetException = (InvocationTargetException) th;
            if (invocationTargetException.getTargetException() != null) {
                th = invocationTargetException.getTargetException();
                stackTrace = th.getStackTrace();
                arrayList = new ArrayList();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        String className = stackTraceElement.getClassName();
                        if (TextUtils.isEmpty(className) || (!className.contains("com.ss.android.ugc.aweme.utils.PreventServerSideCrashes") && !className.equals(Proxy.class.getName()) && !className.equals(Method.class.getName()))) {
                            arrayList.add(stackTraceElement);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return th;
                }
                int size = arrayList.size();
                StackTraceElement[] stackTraceElementArr = new StackTraceElement[size];
                for (int i = 0; i < size; i++) {
                    stackTraceElementArr[i] = (StackTraceElement) arrayList.get(i);
                }
                th.setStackTrace(stackTraceElementArr);
                return th;
            }
            runtimeException = new RuntimeException();
            th = runtimeException;
            arrayList = new ArrayList();
            while (r3 < stackTrace.length) {
            }
            if (arrayList.isEmpty()) {
            }
        } else {
            if (th instanceof UndeclaredThrowableException) {
                UndeclaredThrowableException undeclaredThrowableException = (UndeclaredThrowableException) th;
                if (undeclaredThrowableException.getUndeclaredThrowable() != null) {
                    th = undeclaredThrowableException.getUndeclaredThrowable();
                    stackTrace = th.getStackTrace();
                } else {
                    runtimeException = new RuntimeException();
                    th = runtimeException;
                }
            }
            arrayList = new ArrayList();
            while (r3 < stackTrace.length) {
            }
            if (arrayList.isEmpty()) {
            }
        }
    }
}
