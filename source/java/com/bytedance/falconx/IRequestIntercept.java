package com.bytedance.falconx;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public interface IRequestIntercept {
    WebResourceResponse shouldInterceptRequest(WebView webView, String str);
}
