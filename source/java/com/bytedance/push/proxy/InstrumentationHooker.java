package com.bytedance.push.proxy;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.interfaze.IInstrumentationListener;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.crash.Ensure;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class InstrumentationHooker extends BaseHooker implements IInstrumentationListener {
    private static volatile InstrumentationHooker instrumentationHooker;
    private boolean mAddedInstrumentationListener;
    private InstrumentationProxy mInstrumentationProxy = new InstrumentationProxy(this);
    private IPushCommonConfiguration mPushCommonConfiguration;
    private Object sActivityThread;

    @Override // com.bytedance.push.proxy.BaseHooker
    protected String getLogTag() {
        return "InstrumentationHooker";
    }

    public static InstrumentationHooker getInstance() {
        if (instrumentationHooker == null) {
            synchronized (InstrumentationHooker.class) {
                if (instrumentationHooker == null) {
                    instrumentationHooker = new InstrumentationHooker();
                }
            }
        }
        return instrumentationHooker;
    }

    private InstrumentationHooker() {
    }

    public void compensationOnPause(Activity activity) {
        try {
            Logger.m268d(this.TAG, "[compensationOnPause]mAddedInstrumentationListener:" + this.mAddedInstrumentationListener + " activity:" + activity);
            if (this.mAddedInstrumentationListener) {
                this.mPushCommonConfiguration.invokeActivityLifeCycleMethod(this.mInstrumentationProxy.getCallActivityOnPause(), activity);
            } else {
                this.mInstrumentationProxy.getCallActivityOnPause().invoke(this.mBase, activity);
            }
        } catch (IllegalAccessException e) {
            Logger.m272e(this.TAG, "error when compensationOnPause ", e);
            onCompensationError(e, activity);
        } catch (InvocationTargetException e2) {
            Logger.m272e(this.TAG, "error when compensationOnPause ", e2);
            e2.printStackTrace();
            onCompensationError(e2, activity);
        }
    }

    private void onCompensationError(final Throwable th, final Activity activity) {
        Logger.m272e(this.TAG, "error when compensationOnPause ", th);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.proxy.InstrumentationHooker.1
            @Override // java.lang.Runnable
            public void run() {
                Ensure.ensureNotReachHere(th, String.format("error when compensation on pause for %s", activity));
            }
        });
    }

    @Override // com.bytedance.push.proxy.BaseHooker
    protected synchronized boolean doHook() {
        try {
        } catch (Throwable th) {
            Logger.m272e(this.TAG, "error when hook IActivityManager ", th);
        }
        if (this.hookSuccess) {
            return true;
        }
        IPushCommonConfiguration iPushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration;
        this.mPushCommonConfiguration = iPushCommonConfiguration;
        if (iPushCommonConfiguration != null) {
            this.mAddedInstrumentationListener = iPushCommonConfiguration.addInstrumentationListener(this);
            Logger.m268d(this.TAG, "[doHook]host addInstrumentationListener result:" + this.mAddedInstrumentationListener);
            if (this.mAddedInstrumentationListener) {
                return true;
            }
        }
        Object currentActivityThread = currentActivityThread();
        this.sActivityThread = currentActivityThread;
        if (currentActivityThread != null) {
            try {
                Field field = DoubleReflectUtils.getField(currentActivityThread.getClass(), "mInstrumentation");
                field.setAccessible(true);
                field.get(this.sActivityThread);
                Object obj = field.get(this.sActivityThread);
                Logger.m268d(this.TAG, "[doHook]originInstrumentation:" + obj);
                if (obj instanceof InstrumentationProxy) {
                    Logger.m278w(this.TAG, "[doHook]not duplicate hook field because originInstrumentation is InstrumentationHooker");
                    return true;
                }
                if (obj != null) {
                    this.mInstrumentationProxy.setOriginInstrumentation((Instrumentation) obj);
                    this.mBase = obj;
                }
                field.set(this.sActivityThread, this.mInstrumentationProxy);
                Logger.m268d(this.TAG, "[doHook]finished hook activity thread Instrumentation,mBase:" + this.mBase);
                Activity topActivity = ActivityLifecycleObserver.getIns().getTopActivity();
                if (topActivity != null) {
                    Field field2 = DoubleReflectUtils.getField(Activity.class, "mInstrumentation");
                    field2.setAccessible(true);
                    field2.set(topActivity, this.mInstrumentationProxy);
                }
                Logger.m268d(this.TAG, "success replace instrumentation");
                return true;
            } catch (Throwable th2) {
                Logger.m272e(this.TAG, "error when replace instrumentation ", th2);
            }
        } else {
            Logger.m271e(this.TAG, "sActivityThread is null!");
        }
        return false;
    }

    private void hookSysInstrumentation(Object obj, Field field, Object obj2) throws IllegalAccessException {
        Logger.m274i(this.TAG, "[hookSysInstrumentation]originInstrumentation:" + obj + " curField:" + field.getName() + " object:" + obj2);
        if (obj instanceof InstrumentationProxy) {
            Logger.m274i(this.TAG, "[hookSysInstrumentation]do nothing because originInstrumentation is InstrumentationHooker");
            return;
        }
        if (obj == null) {
            field.set(obj2, this.mInstrumentationProxy);
            return;
        }
        if (obj.getClass() == Instrumentation.class) {
            field.set(obj2, this.mInstrumentationProxy);
            this.mInstrumentationProxy.setOriginInstrumentation((Instrumentation) obj);
            this.mBase = obj;
            return;
        }
        for (Field field2 : obj.getClass().getDeclaredFields()) {
            if (Instrumentation.class.isAssignableFrom(field2.getType())) {
                Logger.m274i(this.TAG, "[hookSysInstrumentation]find " + obj + "'s " + field2.getName() + " is instrumentation");
                field2.setAccessible(true);
                hookSysInstrumentation(field2.get(obj), field2, obj);
                return;
            }
        }
        Logger.m278w(this.TAG, "[hookSysInstrumentation]backup replace not sys Instrumentation:" + obj.getClass());
        field.set(obj2, this.mInstrumentationProxy);
        this.mInstrumentationProxy.setOriginInstrumentation((Instrumentation) obj);
        this.mBase = obj;
    }

    private synchronized Object currentActivityThread() {
        if (this.sActivityThread == null) {
            try {
                final Method method = DoubleReflectUtils.getMethod(Class.forName("android.app.ActivityThread"), "currentActivityThread", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(null, new Object[0]);
                this.sActivityThread = invoke;
                if (invoke == null && Looper.myLooper() != Looper.getMainLooper()) {
                    final Object obj = new Object();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.push.proxy.InstrumentationHooker.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                InstrumentationHooker.this.sActivityThread = method.invoke(null, new Object[0]);
                                synchronized (obj) {
                                    obj.notify();
                                }
                            } finally {
                                Object obj2 = obj;
                            }
                        }
                    });
                    if (this.sActivityThread == null) {
                        synchronized (obj) {
                            try {
                                obj.wait();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.sActivityThread;
    }

    public boolean callActivityOnPause(Activity activity) {
        Object[] array;
        synchronized (this.mAbsMethodInvokeProxySet) {
            array = this.mAbsMethodInvokeProxySet.toArray();
        }
        Logger.m268d(this.TAG, "[callActivityOnPause]mAbsMethodInvokeProxySet size:" + this.mAbsMethodInvokeProxySet.size());
        for (Object obj : array) {
            if ((obj instanceof IInstrumentationListener) && ((IInstrumentationListener) obj).callActivityOnPause(activity)) {
                Logger.m268d(this.TAG, "[callActivityOnPause]return true to intercept");
                return true;
            }
        }
        return false;
    }

    public boolean callActivityOnResume(Activity activity) {
        Object[] array;
        synchronized (this.mAbsMethodInvokeProxySet) {
            array = this.mAbsMethodInvokeProxySet.toArray();
        }
        Logger.m268d(this.TAG, "[callActivityOnResume]mAbsMethodInvokeProxySet size:" + this.mAbsMethodInvokeProxySet.size());
        for (Object obj : array) {
            if ((obj instanceof IInstrumentationListener) && ((IInstrumentationListener) obj).callActivityOnResume(activity)) {
                Logger.m268d(this.TAG, "[callActivityOnResume]return true to intercept");
                return true;
            }
        }
        return false;
    }

    public boolean callActivityOnStop(Activity activity) {
        Object[] array;
        synchronized (this.mAbsMethodInvokeProxySet) {
            array = this.mAbsMethodInvokeProxySet.toArray();
        }
        Logger.m268d(this.TAG, "[callActivityOnStop]mAbsMethodInvokeProxySet size:" + this.mAbsMethodInvokeProxySet.size());
        for (Object obj : array) {
            if ((obj instanceof IInstrumentationListener) && ((IInstrumentationListener) obj).callActivityOnStop(activity)) {
                Logger.m268d(this.TAG, "[callActivityOnStop]return true to intercept");
                return true;
            }
        }
        return false;
    }
}
