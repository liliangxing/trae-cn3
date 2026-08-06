package com.bytedance.ies.web.jsbridge2;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class XBridgeSupport implements XBridgeHook {
    private JsBridge2 jsBridge2;
    private final BDXBridgeInvocationListener listener = new BDXBridgeInvocationListener();

    public void setJsBridge2(JsBridge2 jsBridge2) {
        this.jsBridge2 = jsBridge2;
        jsBridge2.getEnvironment().addMethodInvocationListener(this.listener);
    }

    public void setCallbackHook(CallbackHook callbackHook) {
        this.listener.setCallbackHook(callbackHook);
    }

    @Override // com.bytedance.ies.web.jsbridge2.XBridgeHook
    public void invoke(String str) {
        this.jsBridge2.getBridge().invokeMethod(str);
    }

    @Override // com.bytedance.ies.web.jsbridge2.XBridgeHook
    public void invoke(Js2JavaCall js2JavaCall) {
        this.jsBridge2.getBridge().invokeMethod(js2JavaCall);
    }
}
