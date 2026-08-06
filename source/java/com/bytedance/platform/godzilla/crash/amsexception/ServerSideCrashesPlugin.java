package com.bytedance.platform.godzilla.crash.amsexception;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ServerSideCrashesPlugin extends BasePlugin {
    private static boolean initialized;
    private static Activity mActivity;
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private Application mApplication;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "ServerSideCrashesPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application application) {
        super.init(application);
        this.mApplication = application;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        CrashCatchLifecycleCallback crashCatchLifecycleCallback = new CrashCatchLifecycleCallback();
        this.mActivityLifecycleCallbacks = crashCatchLifecycleCallback;
        Application application = this.mApplication;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(crashCatchLifecycleCallback);
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        Application application;
        super.stop();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.mActivityLifecycleCallbacks;
        if (activityLifecycleCallbacks == null || (application = this.mApplication) == null) {
            return;
        }
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
        this.mApplication = null;
        this.mActivityLifecycleCallbacks = null;
    }

    public static Field getDeclaredField(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                Field field = DoubleReflectHelper.getField(cls, str);
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
            } catch (Exception e) {
                Logger.d("ServerBugFixer", "setStartedActivity fail " + e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class CrashCatchLifecycleCallback implements Application.ActivityLifecycleCallbacks {
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
            Activity unused = ServerSideCrashesPlugin.mActivity = activity;
            ServerSideCrashesPlugin.hookAMS(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            Activity unused = ServerSideCrashesPlugin.mActivity = activity;
            ServerSideCrashesPlugin.setStartedActivity(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            Activity unused = ServerSideCrashesPlugin.mActivity = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            Activity unused = ServerSideCrashesPlugin.mActivity = null;
        }
    }

    public static void hookAMS(boolean z) {
        Field declaredField;
        if (initialized) {
            return;
        }
        initialized = true;
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
                declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.bytedance.platform.godzilla.crash.amsexception.ServerSideCrashesPlugin.1
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
                                ServerSideCrashesPlugin.mActivity.isImmersive();
                            } catch (IllegalArgumentException unused) {
                                if (ServerSideCrashesPlugin.mActivity != null) {
                                    ServerSideCrashesPlugin.mActivity.finish();
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                        try {
                            return method.invoke(obj2, objArr);
                        } catch (Throwable th) {
                            throw ServerSideCrashesPlugin.getSafeThrowable(th);
                        }
                    }
                }));
                return;
            }
            declaredField2.set(obj, obj);
        } catch (ClassNotFoundException e) {
            Logger.d("ServerBugFixer", "Fix fail " + e);
        } catch (IllegalAccessException e2) {
            Logger.d("ServerBugFixer", "Fix fail " + e2);
        } catch (NoSuchFieldException e3) {
            Logger.d("ServerBugFixer", "Fix fail " + e3);
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
                        if (TextUtils.isEmpty(className) || (!className.contains("com.bytedance.platform.godzilla.crash.amsexception.ServerSideCrashesPlugin") && !className.equals(Proxy.class.getName()) && !className.equals(Method.class.getName()))) {
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
