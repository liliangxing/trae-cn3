package com.bytedance.ies.bullet.kit.web;

import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.web.IWebResourceRequest;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IWebSecureDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;", "", "()V", "buildSecureLink", "", "webView", "Landroid/webkit/WebView;", "url", WebViewContainer.EVENT_canGoBack, "", "handleGoBack", WebViewContainerClient.EVENT_shouldOverrideUrlLoading, OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/ies/bullet/service/base/web/IWebResourceRequest;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class IWebSecureDelegate {
    public String buildSecureLink(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return null;
    }

    public boolean canGoBack(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return true;
    }

    public boolean handleGoBack(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, IWebResourceRequest request) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return false;
    }
}
