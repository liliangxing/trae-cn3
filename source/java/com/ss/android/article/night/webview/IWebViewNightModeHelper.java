package com.ss.android.article.night.webview;

import android.webkit.WebView;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* compiled from: IWebViewNightModeHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/article/night/webview/IWebViewNightModeHelper;", "", "injectNightModeJS", "", "webView", "Landroid/webkit/WebView;", "url", "", "reBindLifecycle", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface IWebViewNightModeHelper {
    void injectNightModeJS(WebView webView, String url);

    void reBindLifecycle(LifecycleOwner lifecycleOwner);
}
