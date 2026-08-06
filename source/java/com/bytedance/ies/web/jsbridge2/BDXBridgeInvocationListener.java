package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
public class BDXBridgeInvocationListener implements IMethodInvocationListener {
    private CallbackHook callbackHook;

    @Override // com.bytedance.ies.web.jsbridge2.IMethodInvocationListener
    public void onInvoked(String str, String str2) {
    }

    @Override // com.bytedance.ies.web.jsbridge2.IMethodInvocationListener
    public void onRejected(String str, String str2, int i) {
    }

    @Override // com.bytedance.ies.web.jsbridge2.IMethodInvocationListener
    public void onRejected(Js2JavaCall js2JavaCall, int i, Object obj) {
        CallbackHook callbackHook = this.callbackHook;
        if (callbackHook != null) {
            callbackHook.onBridgeReject(js2JavaCall, i);
        }
    }

    public void setCallbackHook(CallbackHook callbackHook) {
        this.callbackHook = callbackHook;
    }
}
