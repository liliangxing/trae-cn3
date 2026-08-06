package com.bytedance.ies.web.jsbridge2;

import android.view.View;

/* loaded from: classes4.dex */
public interface IGlobalBridgeInterceptor {

    /* loaded from: classes4.dex */
    public interface GlobalBridgeInterceptorCallback {
        void invokeJsCallback(String str, Js2JavaCall js2JavaCall);

        void invokeOrigin(Js2JavaCall js2JavaCall);

        <T> void sendJsEvent(String str, T t);
    }

    void intercept(View view, String str, Js2JavaCall js2JavaCall, GlobalBridgeInterceptorCallback globalBridgeInterceptorCallback);

    boolean shouldIntercept(View view, String str, Js2JavaCall js2JavaCall);
}
