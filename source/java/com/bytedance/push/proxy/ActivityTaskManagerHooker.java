package com.bytedance.push.proxy;

import com.bytedance.push.utils.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class ActivityTaskManagerHooker extends BaseHooker {
    public static final String METHOD_START_ACTIVITIES = "startActivities";
    public static final String METHOD_START_ACTIVITY = "startActivity";
    public static final String METHOD_START_ACTIVITY_AS_USER = "startActivityAsUser";
    private static volatile ActivityTaskManagerHooker activityTaskManagerHandler;

    @Override // com.bytedance.push.proxy.BaseHooker
    protected String getLogTag() {
        return "ActivityTaskManagerHooker";
    }

    public static ActivityTaskManagerHooker getInstance() {
        if (activityTaskManagerHandler == null) {
            synchronized (ActivityTaskManagerHooker.class) {
                if (activityTaskManagerHandler == null) {
                    activityTaskManagerHandler = new ActivityTaskManagerHooker();
                }
            }
        }
        return activityTaskManagerHandler;
    }

    @Override // com.bytedance.push.proxy.BaseHooker
    protected synchronized boolean doHook() {
        try {
            if (this.hookSuccess) {
                return true;
            }
            Class<?> cls = Class.forName("android.app.ActivityTaskManager");
            Field declaredField = cls.getDeclaredField("IActivityTaskManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Class<?> cls2 = Class.forName("android.util.Singleton");
            try {
                cls.getDeclaredMethod("getService", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable th) {
                Logger.e(this.TAG, "error when invoke ActivityTaskManager#getService:" + th.getLocalizedMessage() + " use IActivityTaskManagerSingleton.get backup");
                Method declaredMethod = cls2.getDeclaredMethod("get", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj, new Object[0]);
            }
            Field declaredField2 = cls2.getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                Logger.w(this.TAG, "hook field because rawIActivityManager is null");
                return false;
            }
            Class<?> cls3 = Class.forName("android.app.IActivityTaskManager");
            if (obj2 instanceof ActivityTaskManagerHooker) {
                Logger.w(this.TAG, "not duplicate hook field because rawIActivityManager is ActivityTaskManagerHooker");
                return true;
            }
            this.mBase = obj2;
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls3}, this));
            Logger.d(this.TAG, "success hook ActivityTaskManager");
            return true;
        } catch (Throwable th2) {
            Logger.e(this.TAG, "error when hook IActivityTaskManager ", th2);
            return false;
        }
    }
}
