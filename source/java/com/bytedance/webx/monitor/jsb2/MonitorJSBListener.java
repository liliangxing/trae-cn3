package com.bytedance.webx.monitor.jsb2;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.JSBError;
import com.bytedance.android.monitorV2.entity.JSBInfo;
import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.ies.web.jsbridge2.IMethodInvocationListener;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.TimeLineEventSummary;
import java.lang.ref.SoftReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MonitorJSBListener implements IMethodInvocationListener {
    private SoftReference<WebView> webViewSoftReference;

    /* JADX INFO: Access modifiers changed from: private */
    public int getErrorCode(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 3;
            }
        }
        return i2;
    }

    public MonitorJSBListener(WebView webView) {
        this.webViewSoftReference = new SoftReference<>(webView);
    }

    public void onInvoked(String str, final String str2) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        HybridMonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.webx.monitor.jsb2.MonitorJSBListener.1
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = (WebView) MonitorJSBListener.this.webViewSoftReference.get();
                if (webView == null || TextUtils.isEmpty(str2)) {
                    return;
                }
                JSBInfo jSBInfo = new JSBInfo();
                jSBInfo.bridgeName = str2;
                jSBInfo.statusCode = 0;
                jSBInfo.invokeTime = 0L;
                if (jSBInfo.invokeTime != 0) {
                    jSBInfo.callbackTime = elapsedRealtime;
                    jSBInfo.costTime = jSBInfo.callbackTime - jSBInfo.invokeTime;
                }
                WebViewMonitorHelper.getInstance().handleJSBInfo(webView, jSBInfo);
            }
        });
    }

    public void onInvoked(String str, final String str2, final TimeLineEventSummary timeLineEventSummary) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        HybridMonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.webx.monitor.jsb2.MonitorJSBListener.2
            @Override // java.lang.Runnable
            public void run() {
                long j;
                WebView webView = (WebView) MonitorJSBListener.this.webViewSoftReference.get();
                if (webView == null || TextUtils.isEmpty(str2)) {
                    return;
                }
                TimeLineEventSummary timeLineEventSummary2 = timeLineEventSummary;
                if (timeLineEventSummary2 != null && timeLineEventSummary2.jsbCallTimeLineEvents != null) {
                    for (TimeLineEvent timeLineEvent : timeLineEventSummary.jsbCallTimeLineEvents) {
                        if (timeLineEvent != null && TimeLineEvent.Constants.LABEL_CREATE_JAVA_CALL.equals(timeLineEvent.getLabel())) {
                            j = timeLineEvent.getElapsedTimestamp();
                            break;
                        }
                    }
                }
                j = 0;
                JSBInfo jSBInfo = new JSBInfo();
                jSBInfo.bridgeName = str2;
                jSBInfo.statusCode = 0;
                jSBInfo.invokeTime = j;
                if (jSBInfo.invokeTime != 0) {
                    jSBInfo.callbackTime = elapsedRealtime;
                    jSBInfo.costTime = jSBInfo.callbackTime - jSBInfo.invokeTime;
                }
                WebViewMonitorHelper.getInstance().handleJSBInfo(webView, jSBInfo);
            }
        });
    }

    public void onRejected(String str, final String str2, final int i) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        HybridMonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.webx.monitor.jsb2.MonitorJSBListener.3
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = (WebView) MonitorJSBListener.this.webViewSoftReference.get();
                if (webView == null || TextUtils.isEmpty(str2)) {
                    return;
                }
                JSBInfo jSBInfo = new JSBInfo();
                jSBInfo.bridgeName = str2;
                jSBInfo.statusCode = MonitorJSBListener.this.getErrorCode(i);
                jSBInfo.invokeTime = 0L;
                if (jSBInfo.invokeTime != 0) {
                    jSBInfo.callbackTime = elapsedRealtime;
                    jSBInfo.costTime = jSBInfo.callbackTime - jSBInfo.invokeTime;
                }
                WebViewMonitorHelper.getInstance().handleJSBInfo(webView, jSBInfo);
                JSBError jSBError = new JSBError();
                jSBError.bridgeName = str2;
                jSBError.errorCode = MonitorJSBListener.this.getErrorCode(i);
                WebViewMonitorHelper.getInstance().handleJSBError(webView, jSBError);
            }
        });
    }

    public void onRejected(String str, String str2, int i, String str3) {
        onRejected(str, str2, i);
    }

    public void onRejected(String str, final String str2, final int i, final String str3, final TimeLineEventSummary timeLineEventSummary) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        HybridMonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.webx.monitor.jsb2.MonitorJSBListener.4
            @Override // java.lang.Runnable
            public void run() {
                long j;
                WebView webView = (WebView) MonitorJSBListener.this.webViewSoftReference.get();
                if (webView == null || TextUtils.isEmpty(str2)) {
                    return;
                }
                TimeLineEventSummary timeLineEventSummary2 = timeLineEventSummary;
                if (timeLineEventSummary2 != null && timeLineEventSummary2.jsbCallTimeLineEvents != null) {
                    for (TimeLineEvent timeLineEvent : timeLineEventSummary.jsbCallTimeLineEvents) {
                        if (timeLineEvent != null && TimeLineEvent.Constants.LABEL_CREATE_JAVA_CALL.equals(timeLineEvent.getLabel())) {
                            j = timeLineEvent.getElapsedTimestamp();
                            break;
                        }
                    }
                }
                j = 0;
                JSBInfo jSBInfo = new JSBInfo();
                jSBInfo.bridgeName = str2;
                jSBInfo.statusCode = MonitorJSBListener.this.getErrorCode(i);
                jSBInfo.statusDescription = str3;
                jSBInfo.invokeTime = j;
                if (jSBInfo.invokeTime != 0) {
                    jSBInfo.callbackTime = elapsedRealtime;
                    jSBInfo.costTime = jSBInfo.callbackTime - jSBInfo.invokeTime;
                }
                WebViewMonitorHelper.getInstance().handleJSBInfo(webView, jSBInfo);
                JSBError jSBError = new JSBError();
                jSBError.bridgeName = str2;
                jSBError.errorCode = MonitorJSBListener.this.getErrorCode(i);
                jSBError.errorMessage = str3;
                WebViewMonitorHelper.getInstance().handleJSBError(webView, jSBError);
            }
        });
    }
}
