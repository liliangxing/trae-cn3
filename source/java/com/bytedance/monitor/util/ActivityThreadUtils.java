package com.bytedance.monitor.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class ActivityThreadUtils {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int DUMP_SERVICE = 123;
    public static final int EXECUTE_TRANSACTION = 159;
    public static final int LAUNCH_ACTIVITY = 100;
    public static final int PAUSE_ACTIVITY = 101;
    public static final int RECEIVER = 113;
    public static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int UNBIND_SERVICE = 122;
    private static final long WAIT_TIME = 5000;
    private static Class activityThread$HClass;
    private static Class activityThreadClass;
    private static Object mAppThread;
    private static Field mAppThreadField;
    private static Field mHField;
    private static Object mInstrumentation;
    private static Field mInstrumentationField;
    private static Set<Integer> mMessageIds;
    private static Object sActivityThread;
    private static Class sClassForActivityThread;
    private static Object smHInActivityThread;

    static {
        HashSet hashSet = new HashSet();
        mMessageIds = hashSet;
        hashSet.add(113);
        mMessageIds.add(114);
        mMessageIds.add(115);
        mMessageIds.add(116);
        mMessageIds.add(121);
        mMessageIds.add(122);
        mMessageIds.add(100);
        mMessageIds.add(159);
        mMessageIds.add(123);
    }

    public static boolean isMessageNeedInterrupt(Message message) {
        return message != null && mMessageIds.contains(Integer.valueOf(message.what));
    }

    public static synchronized Class getActivityThread$HClass() {
        Class cls;
        synchronized (ActivityThreadUtils.class) {
            if (activityThread$HClass == null) {
                try {
                    activityThread$HClass = Class.forName("android.app.ActivityThread$H");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            cls = activityThread$HClass;
        }
        return cls;
    }

    public static synchronized Class getActivityThreadClass() {
        Class cls;
        synchronized (ActivityThreadUtils.class) {
            if (activityThreadClass == null) {
                try {
                    activityThreadClass = Class.forName("android.app.ActivityThread");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            cls = activityThreadClass;
        }
        return cls;
    }

    public static synchronized Field getHField() {
        Field field;
        synchronized (ActivityThreadUtils.class) {
            if (mHField == null) {
                mHField = FieldUtils.getField(getActivityThreadClass(), "mH");
            }
            field = mHField;
        }
        return field;
    }

    public static synchronized Field getInstrumentationField() {
        Field field;
        synchronized (ActivityThreadUtils.class) {
            if (mInstrumentationField == null) {
                mInstrumentationField = FieldUtils.getField(getActivityThreadClass(), "mInstrumentation");
            }
            field = mInstrumentationField;
        }
        return field;
    }

    public static synchronized Field getAppThreadField() {
        Field field;
        synchronized (ActivityThreadUtils.class) {
            if (mAppThreadField == null) {
                mAppThreadField = FieldUtils.getField(getActivityThreadClass(), "mAppThread");
            }
            field = mAppThreadField;
        }
        return field;
    }

    public static synchronized Object getsActivityThread() {
        Object obj;
        synchronized (ActivityThreadUtils.class) {
            try {
                if (sActivityThread == null) {
                    sActivityThread = MethodUtils.invokeStaticMethod(getActivityThreadClass(), "currentActivityThread", new Object[0]);
                }
                obj = sActivityThread;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
        return obj;
    }

    public static synchronized Object getHInActivityThread() {
        Object obj;
        synchronized (ActivityThreadUtils.class) {
            if (smHInActivityThread == null) {
                try {
                    smHInActivityThread = getHField().get(getsActivityThread());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            obj = smHInActivityThread;
        }
        return obj;
    }

    public static synchronized Object getInstrumentation() {
        Object obj;
        synchronized (ActivityThreadUtils.class) {
            if (mInstrumentation == null) {
                try {
                    mInstrumentation = getInstrumentationField().get(getsActivityThread());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            obj = mInstrumentation;
        }
        return obj;
    }

    public static synchronized Object getAppThread() {
        Object obj;
        synchronized (ActivityThreadUtils.class) {
            if (mAppThread == null) {
                try {
                    mAppThread = getAppThreadField().get(getsActivityThread());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            obj = mAppThread;
        }
        return obj;
    }

    public static Object currentActivityThread() {
        if (sActivityThread == null) {
            try {
                synchronized (ActivityThreadUtils.class) {
                    if (sActivityThread == null) {
                        if (sClassForActivityThread == null) {
                            sClassForActivityThread = Class.forName("android.app.ActivityThread");
                        }
                        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);
                    }
                    if (sActivityThread == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.monitor.util.ActivityThreadUtils.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    Object unused = ActivityThreadUtils.sActivityThread = MethodUtils.invokeStaticMethod(ActivityThreadUtils.sClassForActivityThread, "currentActivityThread", new Object[0]);
                                    synchronized (obj) {
                                        obj.notify();
                                    }
                                } catch (Exception unused2) {
                                    synchronized (obj) {
                                        obj.notify();
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (sActivityThread == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sActivityThread;
    }
}
