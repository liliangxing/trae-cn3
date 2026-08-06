package com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject;

import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class IBinderProxy extends MethodProxy {
    private String mService;

    public IBinderProxy(String str, MethodProxy methodProxy) {
        this.mService = str;
        this.mDelegateMethods.put("queryLocalInterface", new QueryLocalInterface(methodProxy));
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        new ServiceManagerHook(this.mService, this).onHook();
    }

    /* loaded from: classes4.dex */
    static class QueryLocalInterface extends MethodDelegate {
        private MethodProxy mProxy;

        QueryLocalInterface(MethodProxy methodProxy) {
            this.mProxy = methodProxy;
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            return super.beforeInvoke(obj, method, objArr);
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
            return ProxyHelper.createProxy(this.mProxy.getTarget(), this.mProxy);
        }
    }
}
