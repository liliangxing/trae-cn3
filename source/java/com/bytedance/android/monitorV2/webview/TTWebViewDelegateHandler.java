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
public class TTWebViewDelegateHandler implements InvocationHandler {
    private static final String TAG = "TTWebViewDelegateHandler";
    private Object webViewDelegate;
    private Class<?> webViewDelegateCls;

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
        if (!"ttwebviewdelegate".equals(str) && 1 != num.intValue()) {
            return null;
        }
        if ("init".equals(hashMap.get("name"))) {
            MonitorLog.m29i(TAG, "handleViewCreate: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]));
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).handleViewCreateInner((WebView) objArr2[0]);
            return null;
        }
        if ("loadUrl".equals(hashMap.get("name"))) {
            MonitorLog.m29i(TAG, "onLoadUrl: " + objArr2[1]);
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).onLoadUrlInner((WebView) objArr2[0], (String) objArr2[1]);
            return null;
        }
        if ("goBack".equals(hashMap.get("name"))) {
            MonitorLog.m29i(TAG, "goBack: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]));
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).goBackInner((WebView) objArr2[0]);
            return null;
        }
        if ("reload".equals(hashMap.get("name"))) {
            MonitorLog.m29i(TAG, "reload: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]));
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).reloadInner((WebView) objArr2[0]);
            return null;
        }
        if ("destroy".equals(hashMap.get("name"))) {
            MonitorLog.m29i(TAG, "destroy: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]));
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).destroyInner((WebView) objArr2[0]);
            return null;
        }
        return null;
    }

    public Object getInstance() throws Exception {
        this.webViewDelegateCls = Class.forName("com.bytedance.lynx.webview.monitors.IWebViewDelegate");
        this.webViewDelegate = Class.forName("com.bytedance.lynx.webview.monitors.WebViewDelegate").newInstance();
        return Proxy.newProxyInstance(this.webViewDelegateCls.getClassLoader(), new Class[]{this.webViewDelegateCls}, this);
    }
}
