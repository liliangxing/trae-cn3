package com.bytedance.android.monitor.webview.base;

import android.webkit.WebView;
import com.bytedance.android.monitor.entity.FallBackInfo;
import com.bytedance.android.monitor.webview.cache.base.WebBaseReportData;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IBusinessCustom {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class DefaultDataCallback implements IDataCallback {
        @Override // com.bytedance.android.monitor.webview.base.IBusinessCustom.IDataCallback
        public void onPerfReported(WebBaseReportData webBaseReportData) {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IDataCallback {
        void onPerfReported(WebBaseReportData webBaseReportData);
    }

    void addContext(WebView webView, String str, Object obj);

    void registerDataCallback(WebView webView, IDataCallback iDataCallback);

    void reportFallbackPage(WebView webView, FallBackInfo fallBackInfo);

    void reportGeckoInfo(WebView webView, String str, String str2, String str3);

    void reportGeckoInfo(WebView webView, String str, String str2, String str3, String str4);
}
