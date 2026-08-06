package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTWebViewDelegateHandler implements InvocationHandler {
    private Object webViewDelegate;
    private Class<?> webViewDelegateCls;

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).isTTWebEnable()) {
            return method.invoke(this.webViewDelegate, objArr);
        }
        if ("init".equals(method.getName())) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).handleViewCreateInner((WebView) objArr[0]);
            return method.invoke(this.webViewDelegate, objArr);
        }
        if ("loadUrl".equals(method.getName())) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).onLoadUrlInner((WebView) objArr[0], (String) objArr[1]);
            return method.invoke(this.webViewDelegate, objArr);
        }
        if ("goBack".equals(method.getName())) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).goBackInner((WebView) objArr[0]);
            return method.invoke(this.webViewDelegate, objArr);
        }
        if ("reload".equals(method.getName())) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).reloadInner((WebView) objArr[0]);
            return method.invoke(this.webViewDelegate, objArr);
        }
        if ("destroy".equals(method.getName())) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).destroyInner((WebView) objArr[0]);
            return method.invoke(this.webViewDelegate, objArr);
        }
        if ("onAttachedToWindow".equals(method.getName())) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).onAttachedToWindowInner((WebView) objArr[0]);
            return method.invoke(this.webViewDelegate, objArr);
        }
        return method.invoke(this.webViewDelegate, objArr);
    }

    public Object getInstance() throws Exception {
        this.webViewDelegateCls = Class.forName("com.bytedance.lynx.webview.monitors.IWebViewDelegate");
        this.webViewDelegate = Class.forName("com.bytedance.lynx.webview.monitors.WebViewDelegate").newInstance();
        return Proxy.newProxyInstance(this.webViewDelegateCls.getClassLoader(), new Class[]{this.webViewDelegateCls}, this);
    }
}
