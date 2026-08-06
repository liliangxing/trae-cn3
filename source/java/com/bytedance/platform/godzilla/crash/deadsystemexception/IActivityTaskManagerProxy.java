package com.bytedance.platform.godzilla.crash.deadsystemexception;

import android.os.Build;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IActivityTaskManagerProxy extends MethodProxy {
    private static final String TAG = "IActivityTaskManagerProxy";

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        if (Build.VERSION.SDK_INT < 29) {
            Logger.m197e(TAG, "Below android Q,return.");
            return;
        }
        try {
            Object readStaticField = FieldUtils.readStaticField(Class.forName("android.app.ActivityTaskManager"), "IActivityTaskManagerSingleton");
            if (Class.forName("android.util.Singleton").isInstance(readStaticField)) {
                Object readField = FieldUtils.readField(readStaticField, "mInstance");
                if (readField == null) {
                    readField = MethodUtils.getAccessibleMethod(readStaticField.getClass(), PrefetchRequestConfig.METHOD_GET, new Class[0]).invoke(readStaticField, new Object[0]);
                }
                if (readField == null || Proxy.isProxyClass(readField.getClass())) {
                    return;
                }
                setTarget(readField);
                FieldUtils.writeField(readStaticField, "mInstance", ProxyHelper.createProxy(readField, this));
                Logger.m197e(TAG, "Hook proxy ActivityTaskManager success!!!");
            }
        } catch (Throwable th) {
            Logger.m197e(TAG, "Hook proxy ActivityTaskManager Failed!!!");
            th.printStackTrace();
        }
    }

    static {
        addMethodDelegate("activityDestroyed", new IpcProtectInterface());
        addMethodDelegate("activitySlept", new IpcProtectInterface());
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class IpcProtectInterface extends MethodDelegate {
        private IpcProtectInterface() {
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            Logger.m197e(IActivityTaskManagerProxy.TAG, method.getName() + " is called!");
            return super.beforeInvoke(obj, method, objArr);
        }
    }
}
