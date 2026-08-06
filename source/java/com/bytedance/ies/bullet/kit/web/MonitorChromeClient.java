package com.bytedance.ies.bullet.kit.web;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDelegate;
import kotlin.Metadata;

/* compiled from: MonitorChromeClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/MonitorChromeClient;", "Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDelegate;", "()V", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MonitorChromeClient extends WebChromeClientDelegate {
    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        WebViewMonitorHelper.getInstance().onProgressChanged(view, newProgress);
    }
}
