package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
public abstract class BaseStatelessMethod<P, R> extends BaseMethod<P, R> {
    private IXBridgeStatelessProxy proxy = null;

    public abstract R invoke(P p, CallContext callContext) throws Exception;

    @Override // com.bytedance.ies.web.jsbridge2.BaseMethod
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.bytedance.ies.web.jsbridge2.BaseMethod
    public /* bridge */ /* synthetic */ PermissionGroup getPermission() {
        return super.getPermission();
    }

    public void setProxy(IXBridgeStatelessProxy iXBridgeStatelessProxy) {
        this.proxy = iXBridgeStatelessProxy;
    }

    protected void terminate() throws JsBridgeException {
        IXBridgeStatelessProxy iXBridgeStatelessProxy = this.proxy;
        if (iXBridgeStatelessProxy != null) {
            iXBridgeStatelessProxy.terminate(null);
            return;
        }
        throw new JsBridgeException(0);
    }

    protected void terminate(String str) throws JsBridgeException {
        IXBridgeStatelessProxy iXBridgeStatelessProxy = this.proxy;
        if (iXBridgeStatelessProxy != null) {
            iXBridgeStatelessProxy.terminate(str);
            return;
        }
        throw new JsBridgeException(0, str);
    }
}
