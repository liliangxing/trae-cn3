package com.bytedance.platform.godzilla.crash.deadsystemexception;

import android.os.IBinder;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject.IBinderProxy;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IConnectivityManagerProxy extends MethodProxy {
    private static final String TAG = "IConnectivityManagerProxy";

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        try {
            IBinderProxy iBinderProxy = new IBinderProxy("connectivity", this);
            iBinderProxy.onInstall();
            setTarget(MethodUtils.getAccessibleMethod(Class.forName("android.net.IConnectivityManager$Stub"), "asInterface", IBinder.class).invoke(null, iBinderProxy.getTarget()));
            Logger.m197e(TAG, "Hook proxy success!");
        } catch (Exception e) {
            Logger.m197e(TAG, "Hook proxy connectivity Failed!!!");
            e.printStackTrace();
        }
    }

    static {
        addMethodDelegate("getNetworkCapabilities", new IpcProtectInterface());
        addMethodDelegate("getAllNetworks", new IpcProtectInterface());
        addMethodDelegate("getLinkProperties", new IpcProtectInterface());
        addMethodDelegate("getActiveNetworkInfo", new IpcProtectInterface());
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class IpcProtectInterface extends MethodDelegate {
        private IpcProtectInterface() {
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            return super.beforeInvoke(obj, method, objArr);
        }
    }
}
