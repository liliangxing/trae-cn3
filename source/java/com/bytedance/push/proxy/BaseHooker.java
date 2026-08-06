package com.bytedance.push.proxy;

import com.bytedance.push.utils.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class BaseHooker implements InvocationHandler {
    protected boolean hookSuccess;
    protected Object mBase;
    protected String TAG = getLogTag();
    protected final Set<AbsMethodInvokeProxy> mAbsMethodInvokeProxySet = new HashSet();

    protected abstract boolean doHook();

    protected abstract String getLogTag();

    public synchronized boolean addMethodInvokeProxy(AbsMethodInvokeProxy absMethodInvokeProxy) {
        if (absMethodInvokeProxy == null) {
            return false;
        }
        Logger.d(this.TAG, "add MethodInvokeProxy to mMethodInvokeProxySet:" + absMethodInvokeProxy);
        if (!this.hookSuccess) {
            Logger.d(this.TAG, "not hook success,star hook");
            this.hookSuccess = doHook();
        } else {
            Logger.d(this.TAG, "has hook success,needn't hook");
        }
        if (this.hookSuccess) {
            synchronized (this.mAbsMethodInvokeProxySet) {
                this.mAbsMethodInvokeProxySet.add(absMethodInvokeProxy);
            }
        }
        return this.hookSuccess;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Object[] array;
        synchronized (this.mAbsMethodInvokeProxySet) {
            array = this.mAbsMethodInvokeProxySet.toArray();
        }
        for (Object obj2 : array) {
            AbsMethodInvokeProxy absMethodInvokeProxy = (AbsMethodInvokeProxy) obj2;
            if (absMethodInvokeProxy != null) {
                MethodProxyResult proxyMethodInvoke = absMethodInvokeProxy.proxyMethodInvoke(this.mBase, method, objArr);
                if (proxyMethodInvoke.intercept) {
                    Logger.d(this.TAG, "intercept " + method.getName() + " method");
                    return proxyMethodInvoke.result;
                }
            }
        }
        Object obj3 = this.mBase;
        if (obj3 == null) {
            return null;
        }
        Object invoke = method.invoke(obj3, objArr);
        for (Object obj4 : array) {
            ((AbsMethodInvokeProxy) obj4).afterMethodInvoke(this.mBase, method, objArr, invoke);
        }
        return invoke;
    }
}
