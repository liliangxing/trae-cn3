package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DecorViewRemoveOpt {
    private static final int MAX_COUNT = 8;
    private static final String TAG = "DecorViewRemoveOpt";
    private static Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    private static boolean sInit;
    private static final ArrayDeque<RemoveInfo> infos = new ArrayDeque<>(8);
    private static volatile ICallback sCallback = null;
    private static final AtomicBoolean needRegisterHook = new AtomicBoolean(true);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface ICallback {
        /* renamed from: d */
        int mo192d(String str, String str2);

        /* renamed from: e */
        int mo193e(String str, String str2);

        /* renamed from: e */
        int mo194e(String str, String str2, Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$onCrash$1(HashMap hashMap, CrashType crashType) {
        return hashMap;
    }

    public static synchronized ICallback getCallback() {
        ICallback iCallback;
        synchronized (DecorViewRemoveOpt.class) {
            iCallback = sCallback;
            if (iCallback == null) {
                iCallback = new ICallback() { // from class: com.bytedance.sysoptimizer.DecorViewRemoveOpt.1
                    @Override // com.bytedance.sysoptimizer.DecorViewRemoveOpt.ICallback
                    /* renamed from: d */
                    public int mo192d(String str, String str2) {
                        System.out.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.DecorViewRemoveOpt.ICallback
                    /* renamed from: e */
                    public int mo193e(String str, String str2) {
                        System.err.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.DecorViewRemoveOpt.ICallback
                    /* renamed from: e */
                    public int mo194e(String str, String str2, Throwable th) {
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
        synchronized (DecorViewRemoveOpt.class) {
            sCallback = iCallback;
        }
    }

    public static void start(Application application, boolean z, boolean z2, ICallback iCallback) {
        if (sInit) {
            return;
        }
        sInit = true;
        if (z2) {
            Flipped.invokeHiddenApiRestrictions();
        }
        hookWindowSession();
        updateCallback(iCallback);
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sysoptimizer.DecorViewRemoveOpt.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }
        });
        initRegisterCrashCallback();
    }

    private static void hookWindowSession() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            getCallback().mo192d(TAG, "hookWindowSession() called windowManagerGlobalClass = " + cls);
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            getCallback().mo192d(TAG, "hookWindowSession() called sInstance = " + invoke);
            if (invoke == null) {
                return;
            }
            Field declaredField = cls.getDeclaredField("sWindowSession");
            getCallback().mo192d(TAG, "hookWindowSession() called sWindowSessionField = " + declaredField);
            declaredField.setAccessible(true);
            Method declaredMethod2 = cls.getDeclaredMethod("getWindowSession", new Class[0]);
            declaredMethod2.setAccessible(true);
            final Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            getCallback().mo192d(TAG, "hookWindowSession() called originWS = " + invoke2);
            Class<?> cls2 = Class.forName("android.view.IWindowSession");
            Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.bytedance.sysoptimizer.DecorViewRemoveOpt.3
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    DecorViewRemoveOpt.addToDisplayInvoke(method, objArr);
                    return method.invoke(invoke2, objArr);
                }
            });
            declaredField.set(invoke, newProxyInstance);
            getCallback().mo192d(TAG, "hookWindowSession() called proxyInstance = " + newProxyInstance);
        } catch (Throwable th) {
            getCallback().mo194e(TAG, "hookWindowSession", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addToDisplayInvoke(Method method, Object[] objArr) {
        Field declaredField;
        Object obj;
        try {
            getCallback().mo192d(TAG, "invoke() called with: method = [" + method + "], args = [" + Arrays.toString(objArr) + "]");
            String name = method.getName();
            if ((name.equals("addToDisplayAsUser") || name.equals("addToDisplay")) && objArr.length > 0) {
                Object obj2 = objArr[0];
                Class<?> cls = Class.forName("android.view.ViewRootImpl$W");
                if (cls.isInstance(obj2) && (declaredField = cls.getDeclaredField("mViewAncestor")) != null) {
                    declaredField.setAccessible(true);
                    Object obj3 = declaredField.get(obj2);
                    if ((obj3 instanceof WeakReference) && (obj = ((WeakReference) obj3).get()) != null) {
                        getCallback().mo192d(TAG, "invoke() called with: method = [" + method + "], viewRootImpl = [" + obj + "]");
                        Method declaredMethod = obj.getClass().getDeclaredMethod("getView", new Class[0]);
                        if (declaredMethod == null) {
                            return;
                        }
                        declaredMethod.setAccessible(true);
                        Object invoke = declaredMethod.invoke(obj, new Object[0]);
                        getCallback().mo192d(TAG, "invoke() called with: method = [" + method + "], decorView = [" + invoke + "]");
                        if (invoke instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) invoke;
                            setListenerForDecorView(viewGroup);
                            setListenerForContentView((ViewGroup) viewGroup.findViewById(android.R.id.content));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            getCallback().mo194e(TAG, "invoke", th);
        }
    }

    public static void setListenerForDecorView(ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            childFrameLayout(viewGroup);
        }
    }

    public static void setListenerForContentView(ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            childFrameLayout(viewGroup);
        }
    }

    public static void setListenerForL2Child(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof LinearLayout) {
                childLinearLayout((ViewGroup) childAt);
            }
        }
    }

    private static void childLinearLayout(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof FrameLayout) {
                childFrameLayout((ViewGroup) childAt);
            }
        }
    }

    private static void childFrameLayout(ViewGroup viewGroup) {
        getCallback().mo192d(TAG, "childFrameLayout() called with: vg = [" + viewGroup + "]");
        viewGroup.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.bytedance.sysoptimizer.DecorViewRemoveOpt.4
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                RemoveInfo removeInfo = new RemoveInfo("parent=" + view + ", child=" + view2);
                DecorViewRemoveOpt.getCallback().mo192d(DecorViewRemoveOpt.TAG, "onChildViewRemoved() called with: parent = [" + view + "], child = [" + view2 + "]");
                DecorViewRemoveOpt.traceInfo(removeInfo);
            }
        });
    }

    private static void initRegisterCrashCallback() {
        if (needRegisterHook.getAndSet(false)) {
            ICrashCallback iCrashCallback = new ICrashCallback() { // from class: com.bytedance.sysoptimizer.DecorViewRemoveOpt$$ExternalSyntheticLambda1
                public final void onCrash(CrashType crashType, String str, Thread thread) {
                    DecorViewRemoveOpt.onCrash(str);
                }
            };
            Npth.registerCrashCallback(iCrashCallback, CrashType.JAVA);
            Npth.registerCrashCallback(iCrashCallback, CrashType.LAUNCH);
            HashMap hashMap = new HashMap();
            hashMap.put(TAG, "1");
            Npth.addTags(hashMap);
            getCallback().mo193e(TAG, "initRegisterCrashCallback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onCrash(String str) {
        getCallback().mo192d(TAG, "onCrash() called with: stack = [" + str + "]");
        if (str == null || !str.contains("Attempt to invoke virtual method 'int android.view.View.getVisibility()' on a null object reference")) {
            return;
        }
        final HashMap hashMap = new HashMap();
        String info = getInfo();
        getCallback().mo193e(TAG, "onCrash info = " + info);
        hashMap.put(TAG, info);
        AttachUserData attachUserData = new AttachUserData() { // from class: com.bytedance.sysoptimizer.DecorViewRemoveOpt$$ExternalSyntheticLambda0
            public final Map getUserData(CrashType crashType) {
                return DecorViewRemoveOpt.lambda$onCrash$1(hashMap, crashType);
            }
        };
        Npth.addAttachLongUserData(attachUserData, CrashType.JAVA);
        Npth.addAttachLongUserData(attachUserData, CrashType.LAUNCH);
    }

    private static String getInfo() {
        StringBuilder sb = new StringBuilder();
        synchronized (infos) {
            while (true) {
                RemoveInfo pollLast = infos.pollLast();
                if (pollLast != null) {
                    sb.append(pollLast).append("\n\n");
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void traceInfo(RemoveInfo removeInfo) {
        ArrayDeque<RemoveInfo> arrayDeque = infos;
        synchronized (arrayDeque) {
            if (arrayDeque.size() >= 8) {
                arrayDeque.pollFirst();
            }
            arrayDeque.addLast(removeInfo);
        }
    }

    public static void testDecorViewRemoveNPE(ViewGroup viewGroup) {
        getCallback().mo192d(TAG, "testDecorViewRemoveNPE() called decorView id = " + viewGroup.getId() + ", " + viewGroup);
        ViewParent parent = viewGroup.getParent();
        if (parent != null) {
            getCallback().mo192d(TAG, "testDecorViewRemoveNPE() called parent " + parent);
        }
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext()) { // from class: com.bytedance.sysoptimizer.DecorViewRemoveOpt.5
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                DecorViewRemoveOpt.getCallback().mo192d(DecorViewRemoveOpt.TAG, "onLayout() called FrameLayout " + this);
                View view = this;
                while (true) {
                    DecorViewRemoveOpt.getCallback().mo192d(DecorViewRemoveOpt.TAG, "onLayout() called p " + view);
                    Object parent2 = view.getParent();
                    if (!(parent2 instanceof View)) {
                        break;
                    } else {
                        view = (View) parent2;
                    }
                }
                ViewParent parent3 = getParent();
                if (parent3 instanceof ViewGroup) {
                    DecorViewRemoveOpt.getCallback().mo192d(DecorViewRemoveOpt.TAG, "onLayout() called viewParent " + parent3 + " remove " + this);
                    ((ViewGroup) parent3).removeView(this);
                }
            }
        };
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        viewGroup.addView(frameLayout, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class RemoveInfo {
        private final String desc;
        private final long time = System.currentTimeMillis();
        private final int tid = Process.myTid();
        private final String threadName = Thread.currentThread().getName();
        private final Throwable stack = new Throwable();

        RemoveInfo(String str) {
            this.desc = str;
        }

        public String toString() {
            return "time: " + format(this.time) + ", tid: " + this.tid + ", thread: " + this.threadName + "\ndesc: " + this.desc + "\nstack: " + Log.getStackTraceString(this.stack);
        }

        private static String format(long j) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Long.valueOf(j));
        }
    }
}
