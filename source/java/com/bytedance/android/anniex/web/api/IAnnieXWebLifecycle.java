package com.bytedance.android.anniex.web.api;

import android.webkit.WebView;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* compiled from: IAnnieXWebLifecycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J&\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\tH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/web/api/IAnnieXWebLifecycle;", "", "onLoadFail", "", "url", "", "webView", "Landroid/webkit/WebView;", "e", "", "onLoadStart", "onLoadUriSuccess", "onRuntimeReady", "onViewDestroy", LynxError.LYNX_THROWABLE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXWebLifecycle {
    void onLoadFail(String url, WebView webView, Throwable e);

    void onLoadStart(String url, WebView webView);

    void onLoadUriSuccess(String url, WebView webView);

    void onRuntimeReady(String url, WebView webView);

    void onViewDestroy(String url, WebView webView, Throwable throwable);
}
