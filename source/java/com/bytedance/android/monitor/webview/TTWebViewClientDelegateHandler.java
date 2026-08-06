package com.bytedance.android.monitor.webview;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTWebViewClientDelegateHandler implements InvocationHandler {
    private Object webViewClientDelegate;
    private Class<?> webViewClientDelegateCls;

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).isTTWebEnable()) {
            return method.invoke(this.webViewClientDelegate, objArr);
        }
        if ("onPageStarted".equals(method.getName())) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).onPageStartedInner((WebView) objArr[0], (String) objArr[1]);
            return method.invoke(this.webViewClientDelegate, objArr);
        }
        if ("onPageFinished".equals(method.getName())) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).onPageFinishedInner((WebView) objArr[0], (String) objArr[1]);
            return method.invoke(this.webViewClientDelegate, objArr);
        }
        if ("onReceivedError".equals(method.getName()) && objArr.length == 3) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).handleRequestErrorInner((WebView) objArr[0], (WebResourceRequest) objArr[1], (WebResourceError) objArr[2]);
            return method.invoke(this.webViewClientDelegate, objArr);
        }
        if ("onReceivedError".equals(method.getName()) && objArr.length == 4) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).handleRequestErrorInner((WebView) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2], (String) objArr[3]);
            return method.invoke(this.webViewClientDelegate, objArr);
        }
        if ("onReceivedHttpError".equals(method.getName()) && objArr.length == 3) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).handleRequestHttpErrorInner((WebView) objArr[0], (WebResourceRequest) objArr[1], (WebResourceResponse) objArr[2]);
            return method.invoke(this.webViewClientDelegate, objArr);
        }
        return method.invoke(this.webViewClientDelegate, objArr);
    }

    public Object getInstance() throws Exception {
        this.webViewClientDelegateCls = Class.forName("com.bytedance.lynx.webview.monitors.IWebViewClientDelegate");
        this.webViewClientDelegate = Class.forName("com.bytedance.lynx.webview.monitors.WebViewClientDelegate").newInstance();
        return Proxy.newProxyInstance(this.webViewClientDelegateCls.getClassLoader(), new Class[]{this.webViewClientDelegateCls}, this);
    }
}
