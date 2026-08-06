package com.bytedance.platform.godzilla.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class ActivityThreadUtils {
    private static Class activityThreadClass;
    private static Class activityThreadHClass;
    private static Object mAppThread;
    private static Field mAppThreadField;
    private static Field mHField;
    private static Object mInstrumentation;
    private static Field mInstrumentationField;
    private static Object mResourcesManager;
    private static Object sActivityThread;
    private static Object smHInActivityThread;

    private ActivityThreadUtils() {
    }

    public static synchronized Class getActivityThreadHClass() {
        Class cls;
        synchronized (ActivityThreadUtils.class) {
            if (activityThreadHClass == null) {
                try {
                    activityThreadHClass = Class.forName("android.app.ActivityThread$H");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            cls = activityThreadHClass;
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

    public static synchronized Object getResourcesManagerInActivityThread() {
        Object obj;
        synchronized (ActivityThreadUtils.class) {
            if (mResourcesManager == null) {
                try {
                    mResourcesManager = FieldUtils.getField(getActivityThreadClass(), "mResourcesManager").get(getsActivityThread());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            obj = mResourcesManager;
        }
        return obj;
    }
}
