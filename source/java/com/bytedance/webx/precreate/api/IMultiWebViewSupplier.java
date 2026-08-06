package com.bytedance.webx.precreate.api;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.webx.precreate.model.PreCreateInfo;

/* loaded from: classes6.dex */
public interface IMultiWebViewSupplier {
    WebView fetchCachedWebView(String str, int i);

    WebView get(Context context, String str);

    void preCreate(String str);

    IMultiWebViewSupplier registerMonitorCallback(IPreCreateMonitor iPreCreateMonitor);

    IMultiWebViewSupplier registerWebView(String str, PreCreateInfo preCreateInfo);

    boolean remove(String str, WebView webView, boolean z);

    void resize(String str, int i);

    void setPreCreatActive(boolean z);
}
