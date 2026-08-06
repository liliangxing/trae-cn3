package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.common.process.cross.CrossProcessDatabaseHelper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTWebChromeClientDelegateHandler implements InvocationHandler {
    private static final String TAG = "TTWebChromeClientDelegateHandler";
    private Object webChromeClientDelegate;
    private Class<?> webChromeClientDelegateCls;

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String str;
        Integer num;
        HashMap hashMap;
        Object[] objArr2;
        try {
            str = (String) objArr[0];
            num = (Integer) objArr[1];
            hashMap = (HashMap) objArr[2];
            objArr2 = (Object[]) hashMap.get(CrossProcessDatabaseHelper.COL_ARGS);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
        if (!((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).isTTWebEnable()) {
            return null;
        }
        if (("ttwebviewdelegate".equals(str) || 1 == num.intValue()) && "onProgressChanged".equals(hashMap.get("name")) && objArr2.length == 2) {
            MonitorLog.m29i(TAG, "onProgressChanged: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]) + ", newProgress: " + objArr2[1]);
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).onProgressChangedInner((WebView) objArr2[0], ((Integer) objArr2[1]).intValue());
        }
        return null;
    }

    public Object getInstance() throws Exception {
        this.webChromeClientDelegateCls = Class.forName("com.bytedance.lynx.webview.monitors.IWebChromeClientDelegate");
        this.webChromeClientDelegate = Class.forName("com.bytedance.lynx.webview.monitors.WebChromeClientDelegate").newInstance();
        return Proxy.newProxyInstance(this.webChromeClientDelegateCls.getClassLoader(), new Class[]{this.webChromeClientDelegateCls}, this);
    }
}
