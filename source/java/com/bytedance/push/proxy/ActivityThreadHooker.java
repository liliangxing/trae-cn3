package com.bytedance.push.proxy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.bytedance.push.utils.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ActivityThreadHooker extends BaseHooker implements Handler.Callback {
    private static volatile ActivityThreadHooker activityThreadHooker;
    private Method mHandleMessageMethod;
    private Object sActivityThread;

    @Override // com.bytedance.push.proxy.BaseHooker
    protected String getLogTag() {
        return "ActivityThreadHooker";
    }

    public static ActivityThreadHooker getInstance() {
        if (activityThreadHooker == null) {
            synchronized (ActivityThreadHooker.class) {
                if (activityThreadHooker == null) {
                    activityThreadHooker = new ActivityThreadHooker();
                }
            }
        }
        return activityThreadHooker;
    }

    private ActivityThreadHooker() {
    }

    @Override // com.bytedance.push.proxy.BaseHooker
    protected synchronized boolean doHook() {
        try {
        } finally {
        }
        if (this.hookSuccess) {
            return true;
        }
        Object currentActivityThread = currentActivityThread();
        this.sActivityThread = currentActivityThread;
        if (currentActivityThread != null) {
            try {
                Field field = DoubleReflectUtils.getField(currentActivityThread.getClass(), "mH");
                field.setAccessible(true);
                Handler handler = (Handler) field.get(this.sActivityThread);
                Field field2 = DoubleReflectUtils.getField(Handler.class, "mCallback");
                field2.setAccessible(true);
                Object obj = field2.get(handler);
                if (obj instanceof ActivityThreadHooker) {
                    Logger.m278w(this.TAG, "not duplicate hook field because originCallback is ActivityThreadHooker");
                    return true;
                }
                this.mBase = obj;
                this.mHandleMessageMethod = DoubleReflectUtils.getMethod(Handler.Callback.class, "handleMessage", Message.class);
                field2.set(handler, this);
                Logger.m268d(this.TAG, "success replace ActivityThread#H#mCallback");
                return true;
            } catch (Throwable th) {
                Logger.m272e(this.TAG, "error when replace ActivityThread#H#mCallback ", th);
            }
        } else {
            Logger.m271e(this.TAG, "sActivityThread is null!");
        }
        return false;
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
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.push.proxy.ActivityThreadHooker.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ActivityThreadHooker.this.sActivityThread = method.invoke(null, new Object[0]);
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

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Logger.m268d(this.TAG, "handleMessage:" + message.what);
        try {
            Object invoke = invoke(this.mBase, this.mHandleMessageMethod, new Object[]{message});
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
