package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTWebChromeClientDelegateHandler implements InvocationHandler {
    private Object webChromeClientDelegate;
    private Class<?> webChromeClientDelegateCls;

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).isTTWebEnable()) {
            return method.invoke(this.webChromeClientDelegate, objArr);
        }
        if ("onProgressChanged".equals(method.getName()) && objArr.length == 2) {
            ((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).onProgressChangedInner((WebView) objArr[0], ((Integer) objArr[1]).intValue());
        }
        return method.invoke(this.webChromeClientDelegate, objArr);
    }

    public Object getInstance() throws Exception {
        this.webChromeClientDelegateCls = Class.forName("com.bytedance.lynx.webview.monitors.IWebChromeClientDelegate");
        this.webChromeClientDelegate = Class.forName("com.bytedance.lynx.webview.monitors.WebChromeClientDelegate").newInstance();
        return Proxy.newProxyInstance(this.webChromeClientDelegateCls.getClassLoader(), new Class[]{this.webChromeClientDelegateCls}, this);
    }
}
