package com.bytedance.platform.godzilla.crash.deadsystemexception;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IDisplayManagerProxy extends MethodProxy {
    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        try {
            Class<?> cls = Class.forName("android.hardware.display.DisplayManagerGlobal");
            Object obj = FieldUtils.getField(cls, "sInstance").get(null);
            Field field = FieldUtils.getField(cls, "mDm");
            Object obj2 = field.get(obj);
            setTarget(obj2);
            field.set(obj, ProxyHelper.createProxy(obj2, this));
            Logger.m197e("IDisplayManagerProxy", "mDm is " + field.get(obj).getClass().getName());
        } catch (Exception unused) {
        }
    }

    static {
        addMethodDelegate("getDisplayInfo", new IpcProtectInterface());
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class IpcProtectInterface extends MethodDelegate {
        private IpcProtectInterface() {
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            Logger.m197e("IDisplayManagerProxy", method.getName() + " is called!");
            return super.beforeInvoke(obj, method, objArr);
        }
    }
}
