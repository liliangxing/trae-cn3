package com.bytedance.pia.core.api;

import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class PiaCoreApi {
    private static final String ApiProvider = "com.bytedance.pia.core.ServiceProvider";
    private static final String TAG = "PiaCoreApi";
    private Method getMethod;
    private Object provider;

    /* loaded from: classes4.dex */
    private static final class InstanceHolder {
        static final PiaCoreApi instance = new PiaCoreApi();

        private InstanceHolder() {
        }
    }

    private PiaCoreApi() {
        this.provider = null;
        this.getMethod = null;
        if (MinSdkVersion.support()) {
            try {
                Class<?> cls = Class.forName(ApiProvider);
                this.provider = cls.newInstance();
                this.getMethod = cls.getMethod("get", Class.class);
            } catch (Throwable th) {
                Log.e(TAG, "Initialize Pia-Core API failed:", th);
            }
        }
    }

    private <T> T getAPI(Class<T> cls) {
        Method method;
        Object obj = this.provider;
        if (obj != null && (method = this.getMethod) != null) {
            try {
                return (T) method.invoke(obj, cls);
            } catch (Throwable th) {
                Log.e(TAG, "Get api failed:", th);
            }
        }
        return null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) InstanceHolder.instance.getAPI(cls);
    }
}
