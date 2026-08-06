package com.bytedance.android.monitorV2.webview;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.common.process.cross.CrossProcessDatabaseHelper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTWebViewClientDelegateHandler implements InvocationHandler {
    private static final String TAG = "TTWebViewClientDelegateHandler";
    private Object webViewClientDelegate;
    private Class<?> webViewClientDelegateCls;

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
        if ("onPageStarted".equals(hashMap.get("name"))) {
            MonitorLog.m29i(TAG, "onPageStarted:" + objArr2[1]);
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).onPageStartedInner((WebView) objArr2[0], (String) objArr2[1]);
            return null;
        }
        if ("onPageFinished".equals(hashMap.get("name"))) {
            MonitorLog.m29i(TAG, "onPageFinished: " + objArr2[1]);
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).onPageFinishedInner((WebView) objArr2[0], (String) objArr2[1]);
            return null;
        }
        if ("onReceivedError".equals(hashMap.get("name")) && objArr2.length == 3) {
            MonitorLog.m29i(TAG, "handleRequestError: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]) + ", error: " + objArr2[2]);
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).handleRequestErrorInner((WebView) objArr2[0], (WebResourceRequest) objArr2[1], (WebResourceError) objArr2[2]);
            return null;
        }
        if ("onReceivedError".equals(hashMap.get("name")) && objArr2.length == 4) {
            MonitorLog.m29i(TAG, "handleRequestError: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]) + ", errorCode: " + objArr2[1]);
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).handleRequestErrorInner((WebView) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (String) objArr2[3]);
            return null;
        }
        if ("onReceivedHttpError".equals(hashMap.get("name")) && objArr2.length == 3) {
            MonitorLog.m29i(TAG, "handleRequestHttpError: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]) + ", request: " + objArr2[1]);
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).handleRequestHttpErrorInner((WebView) objArr2[0], (WebResourceRequest) objArr2[1], (WebResourceResponse) objArr2[2]);
            return null;
        }
        if ("onRenderProcessGone".equals(hashMap.get("name")) && objArr2.length == 2) {
            MonitorLog.m29i(TAG, "handleRenderProcessGone: " + MonitorLog.getSafeWebViewString((WebView) objArr2[0]) + ", detail: " + objArr2[1]);
            ((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).handleRenderProcessGoneInner((WebView) objArr2[0], (RenderProcessGoneDetail) objArr2[1]);
            return null;
        }
        return null;
    }

    public Object getInstance() throws Exception {
        this.webViewClientDelegateCls = Class.forName("com.bytedance.lynx.webview.monitors.IWebViewClientDelegate");
        this.webViewClientDelegate = Class.forName("com.bytedance.lynx.webview.monitors.WebViewClientDelegate").newInstance();
        return Proxy.newProxyInstance(this.webViewClientDelegateCls.getClassLoader(), new Class[]{this.webViewClientDelegateCls}, this);
    }
}
