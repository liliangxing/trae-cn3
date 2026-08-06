package com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject;

import android.os.Build;
import android.os.IBinder;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class IMountServiceProxy extends MethodProxy {
    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        Class<?> cls;
        IBinderProxy iBinderProxy = new IBinderProxy("mount", this);
        iBinderProxy.onInstall();
        try {
            if (Build.VERSION.SDK_INT > 25) {
                cls = Class.forName("android.os.storage.IStorageManager$Stub");
            } else {
                cls = Class.forName("android.os.storage.IMountService$Stub");
            }
            setTarget(MethodUtils.getAccessibleMethod(cls, "asInterface", IBinder.class).invoke(null, iBinderProxy.getTarget()));
        } catch (Exception e) {
            Logger.e("IMountServiceProxy", "Hook proxy MountService Failed!!!");
            e.printStackTrace();
        }
    }

    static {
        addMethodDelegate("isUserKeyUnlocked", new IsUserKeyUnlocked());
    }

    /* loaded from: classes4.dex */
    static final class IsUserKeyUnlocked extends MethodDelegate {
        IsUserKeyUnlocked() {
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            Logger.d("IMountServiceProxy", "IsUserKeyUnlocked method is called.");
            return null;
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getMethodName().contains("getSharedPreferences")) {
                    Logger.d("IMountServiceProxy", "IsUserKeyUnlocked method is called，hint getSharedPreferences，return true。");
                    return true;
                }
            }
            return super.afterInvoke(obj, method, objArr, obj2);
        }
    }
}
