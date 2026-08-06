package com.bytedance.ies.bullet.service.base.web;

import android.content.Context;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IWebKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000eH&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "", "createWebView", "context", "Landroid/content/Context;", "preCreateType", "", "destroy", "", "getGlobalPropsHandler", "Lcom/bytedance/ies/bullet/service/base/web/IGlobalPropsHandler;", "getWebChromeClientDispatcher", "Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDispatcher;", "getWebView", "Landroid/webkit/WebView;", "getWebViewClientDispatcher", "Lcom/bytedance/ies/bullet/service/base/web/WebViewClientDispatcher;", "provideWebView", "setWebView", "webView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IWebViewDelegate {
    IWebViewDelegate createWebView(Context context, String preCreateType);

    void destroy();

    /* renamed from: getGlobalPropsHandler */
    IGlobalPropsHandler mo589getGlobalPropsHandler();

    WebChromeClientDispatcher getWebChromeClientDispatcher();

    WebView getWebView();

    WebViewClientDispatcher getWebViewClientDispatcher();

    WebView provideWebView(Context context, String preCreateType);

    IWebViewDelegate setWebView(WebView webView);

    /* compiled from: IWebKitService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static WebView provideWebView(IWebViewDelegate iWebViewDelegate, Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        public static /* synthetic */ IWebViewDelegate createWebView$default(IWebViewDelegate iWebViewDelegate, Context context, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createWebView");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return iWebViewDelegate.createWebView(context, str);
        }

        public static /* synthetic */ WebView provideWebView$default(IWebViewDelegate iWebViewDelegate, Context context, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provideWebView");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return iWebViewDelegate.provideWebView(context, str);
        }
    }
}
