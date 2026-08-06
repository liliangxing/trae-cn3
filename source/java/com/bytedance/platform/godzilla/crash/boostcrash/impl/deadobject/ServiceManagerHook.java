package com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject;

import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.Hook;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.util.Map;

/* loaded from: classes4.dex */
public class ServiceManagerHook extends Hook {
    private MethodProxy mBinderProxy;
    private String mService;

    public ServiceManagerHook(String str, MethodProxy methodProxy) {
        this.mService = str;
        this.mBinderProxy = methodProxy;
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.Hook
    public void onHook() {
        Object readStaticField;
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            Object invokeStaticMethod = MethodUtils.invokeStaticMethod(cls, "getService", this.mService);
            if (invokeStaticMethod == null || (readStaticField = FieldUtils.readStaticField(cls, "sCache")) == null || !(readStaticField instanceof Map)) {
                return;
            }
            this.mBinderProxy.setTarget(invokeStaticMethod);
            ((Map) readStaticField).put(this.mService, ProxyHelper.createProxy(invokeStaticMethod, this.mBinderProxy));
        } catch (Exception unused) {
        }
    }
}
