package com.bytedance.push.proxy;

import com.bytedance.push.utils.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class ActivityManagerHooker extends BaseHooker {
    private static volatile ActivityManagerHooker activityTaskManagerHandler;

    @Override // com.bytedance.push.proxy.BaseHooker
    protected String getLogTag() {
        return "ActivityManagerHooker";
    }

    public static ActivityManagerHooker getInstance() {
        if (activityTaskManagerHandler == null) {
            synchronized (ActivityManagerHooker.class) {
                if (activityTaskManagerHandler == null) {
                    activityTaskManagerHandler = new ActivityManagerHooker();
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
            Field declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                Logger.w(this.TAG, "hook field because rawIActivityManager is null");
                return false;
            }
            if (obj2 instanceof ActivityManagerHooker) {
                Logger.w(this.TAG, "not duplicate hook field because rawIActivityManager is ActivityTaskManagerHooker");
                return true;
            }
            this.mBase = obj2;
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, this));
            Logger.d(this.TAG, "success hook IActivityManager");
            return true;
        } catch (Throwable th) {
            Logger.e(this.TAG, "error when hook IActivityManager ", th);
            return false;
        }
    }
}
