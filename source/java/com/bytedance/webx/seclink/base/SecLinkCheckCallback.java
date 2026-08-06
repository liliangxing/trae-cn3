package com.bytedance.webx.seclink.base;

import android.webkit.WebView;
import com.bytedance.webx.seclink.request.CheckUrlResponse;

/* loaded from: classes6.dex */
public interface SecLinkCheckCallback {
    void onGetSecLinkCheckResult(WebView webView, CheckUrlResponse checkUrlResponse);
}
