package com.bytedance.apm.block;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class LooperObserverMonitor {
    public static final char END = '<';
    public static final char START = '>';
    public static Method dispatchingThrewException = null;
    private static volatile boolean isInited = false;
    public static volatile boolean isUsePrinter = false;
    public static Method messageDispatchStarting = null;
    public static Method messageDispatched = null;
    public static final String sEnd = "<<<<< Finished to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee";
    public static final Thread sMainThread = Looper.getMainLooper().getThread();
    public static BaseObserver sObserverWrapper = null;
    public static Object sOriginObserver = null;
    public static final String sStart = ">>>>> Dispatching to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee: 0";

    private LooperObserverMonitor() {
    }

    public static synchronized boolean init(Printer printer) {
        synchronized (LooperObserverMonitor.class) {
            if (isInited) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    Object reflectHideObject = reflectHideObject(Looper.class, null, "sObserver");
                    sOriginObserver = reflectHideObject;
                    if (reflectHideObject != null) {
                        messageDispatchStarting = reflectHideMethod(reflectHideObject.getClass(), "messageDispatchStarting", new Class[0]);
                        messageDispatched = reflectHideMethod(sOriginObserver.getClass(), "messageDispatched", Object.class, Message.class);
                        dispatchingThrewException = reflectHideMethod(sOriginObserver.getClass(), "dispatchingThrewException", Object.class, Message.class, Exception.class);
                    }
                    if (messageDispatchStarting == null || messageDispatched == null || dispatchingThrewException == null) {
                        sOriginObserver = null;
                    }
                    sObserverWrapper = (BaseObserver) Class.forName("com.bytedance.observer.ObserverWrapper").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (sOriginObserver != null) {
                        System.out.println("LooperObserverMonitor.init: " + sOriginObserver);
                        sObserverWrapper.setup(sOriginObserver);
                    }
                    reflectHideMethod(Looper.class, "setObserver", Class.forName("android.os.Looper$Observer")).invoke(null, sObserverWrapper);
                    isInited = true;
                    return isInited;
                } catch (Throwable unused) {
                    sOriginObserver = null;
                }
            }
            sObserverWrapper = new BaseObserver();
            sOriginObserver = null;
            isUsePrinter = true;
            isInited = true;
            return isInited;
        }
    }

    public static void messageDispatchStarting(String str) {
        BaseObserver baseObserver = sObserverWrapper;
        if (baseObserver == null) {
            return;
        }
        baseObserver.messageDispatchStarting(str);
    }

    public static void messageDispatched(String str, Message message) {
        BaseObserver baseObserver = sObserverWrapper;
        if (baseObserver == null) {
            return;
        }
        baseObserver.messageDispatched(str, message);
    }

    public static void addMessageObserver(ILooperObserver iLooperObserver) {
        BaseObserver baseObserver = sObserverWrapper;
        if (baseObserver != null) {
            baseObserver.addMessageObserver(iLooperObserver);
        }
    }

    public static void removeMessageObserverWrapper() {
        if (!isInited || sObserverWrapper == null) {
            return;
        }
        try {
            Method reflectHideMethod = reflectHideMethod(Looper.class, "setObserver", Class.forName("android.os.Looper$Observer"));
            Object obj = sOriginObserver;
            if (obj == null) {
                reflectHideMethod.invoke(null, null);
            } else {
                reflectHideMethod.invoke(null, obj);
            }
        } catch (Throwable unused) {
        }
    }

    public static void addMessageObserverWrapper() {
        if (!isInited || sObserverWrapper == null) {
            return;
        }
        try {
            reflectHideMethod(Looper.class, "setObserver", Class.forName("android.os.Looper$Observer")).invoke(null, sObserverWrapper);
        } catch (Throwable unused) {
        }
    }

    public static void removeMessageObserver(ILooperObserver iLooperObserver) {
        BaseObserver baseObserver = sObserverWrapper;
        if (baseObserver != null) {
            baseObserver.removeMessageObserver(iLooperObserver);
        }
    }

    public static Method reflectHideMethod(Class cls, String str, Class<?>... clsArr) {
        try {
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(cls, str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (Exception unused) {
            return null;
        }
    }

    private static <T> T reflectHideObject(Class cls, Object obj, String str) {
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(cls, str);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<ILooperObserver> getObservers() {
        BaseObserver baseObserver = sObserverWrapper;
        if (baseObserver != null) {
            return baseObserver.mObservers;
        }
        return null;
    }

    /* loaded from: classes3.dex */
    public static class BaseObserver {
        final List<ILooperObserver> mObservers = new ArrayList();
        List<ILooperObserver> mRemoveObservers = new ArrayList();
        List<ILooperObserver> mAddObservers = new ArrayList();
        volatile boolean haveRemove = false;
        volatile boolean haveAdd = false;

        protected void setup(Object obj) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void messageDispatchStarting(String str) {
            if (this.haveAdd) {
                synchronized (this.mObservers) {
                    for (ILooperObserver iLooperObserver : this.mAddObservers) {
                        if (!this.mObservers.contains(iLooperObserver)) {
                            this.mObservers.add(iLooperObserver);
                        }
                    }
                    this.mAddObservers.clear();
                    this.haveAdd = false;
                }
            }
            for (ILooperObserver iLooperObserver2 : this.mObservers) {
                if (iLooperObserver2 != null) {
                    iLooperObserver2.messageDispatchStarting(str);
                }
            }
        }

        public void messageDispatched(String str, Message message) {
            for (ILooperObserver iLooperObserver : this.mObservers) {
                if (iLooperObserver != null) {
                    iLooperObserver.messageDispatched(str, message);
                }
            }
            if (this.haveRemove) {
                synchronized (this.mObservers) {
                    for (ILooperObserver iLooperObserver2 : this.mRemoveObservers) {
                        this.mObservers.remove(iLooperObserver2);
                        this.mAddObservers.remove(iLooperObserver2);
                    }
                    this.mRemoveObservers.clear();
                    this.haveRemove = false;
                }
            }
        }

        public void addMessageObserver(ILooperObserver iLooperObserver) {
            synchronized (this.mObservers) {
                if (iLooperObserver != null) {
                    if (!this.mAddObservers.contains(iLooperObserver)) {
                        this.mAddObservers.add(iLooperObserver);
                        this.haveAdd = true;
                    }
                }
            }
        }

        public void removeMessageObserver(ILooperObserver iLooperObserver) {
            synchronized (this.mObservers) {
                if (iLooperObserver != null) {
                    if (!this.mRemoveObservers.contains(iLooperObserver)) {
                        this.mRemoveObservers.add(iLooperObserver);
                        this.haveRemove = true;
                    }
                }
            }
        }
    }
}
