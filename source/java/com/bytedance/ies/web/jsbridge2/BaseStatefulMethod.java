package com.bytedance.ies.web.jsbridge2;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class BaseStatefulMethod<P, R> extends BaseMethod<P, R> {
    private CallContext callContext;
    private Callback callback;
    private boolean isValid = true;
    private IXBridgeStatefulProxy<R> proxy = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface Callback {
        void onFailed(Throwable th);

        void onRawResult(JSONObject jSONObject);

        void onSucceed(Object obj);
    }

    /* loaded from: classes4.dex */
    public interface Provider {
        BaseStatefulMethod provideMethod();
    }

    protected abstract void invoke(P p, CallContext callContext) throws Exception;

    protected abstract void onTerminate();

    @Override // com.bytedance.ies.web.jsbridge2.BaseMethod
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.bytedance.ies.web.jsbridge2.BaseMethod
    public /* bridge */ /* synthetic */ PermissionGroup getPermission() {
        return super.getPermission();
    }

    public void setProxy(IXBridgeStatefulProxy<R> iXBridgeStatefulProxy) {
        this.proxy = iXBridgeStatefulProxy;
    }

    protected final CallContext getCallContext() {
        IXBridgeStatefulProxy<R> iXBridgeStatefulProxy = this.proxy;
        if (iXBridgeStatefulProxy != null) {
            return iXBridgeStatefulProxy.getCallContext();
        }
        return this.callContext;
    }

    public void terminateActualProxy() {
        terminateActual();
    }

    public void invokeProxy(P p, CallContext callContext) throws Exception {
        invoke(p, this.proxy.getCallContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void finishWithResult(R r) {
        if (checkInvalid()) {
            IXBridgeStatefulProxy<R> iXBridgeStatefulProxy = this.proxy;
            if (iXBridgeStatefulProxy != null) {
                iXBridgeStatefulProxy.getCallBack().onSucceed(r);
            } else {
                this.callback.onSucceed(r);
            }
            onDestroy();
        }
    }

    protected final void finishWithRawResult(JSONObject jSONObject) {
        if (checkInvalid()) {
            IXBridgeStatefulProxy<R> iXBridgeStatefulProxy = this.proxy;
            if (iXBridgeStatefulProxy != null) {
                iXBridgeStatefulProxy.getCallBack().onRawResult(jSONObject);
            } else {
                this.callback.onRawResult(jSONObject);
            }
            onDestroy();
        }
    }

    protected final void finishWithSuccess() {
        finishWithResult(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void finishWithFailure(Throwable th) {
        if (checkInvalid()) {
            IXBridgeStatefulProxy<R> iXBridgeStatefulProxy = this.proxy;
            if (iXBridgeStatefulProxy != null) {
                iXBridgeStatefulProxy.getCallBack().onFailed(th);
            } else {
                this.callback.onFailed(th);
            }
            onDestroy();
        }
    }

    protected final void finishWithFailure() {
        finishWithFailure(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.isValid = false;
        this.callContext = null;
        this.proxy = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeActual(P p, CallContext callContext, Callback callback) throws Exception {
        this.callContext = callContext;
        this.callback = callback;
        invoke(p, callContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void terminateActual() {
        onTerminate();
        onDestroy();
    }

    private boolean checkInvalid() {
        return this.isValid;
    }
}
