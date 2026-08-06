package com.bytedance.webx.core.webview.client;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;

/* loaded from: classes6.dex */
public interface IWebChromeContainerClient {
    Bitmap getDefaultVideoPoster();

    View getVideoLoadingProgressView();

    void getVisitedHistory(ValueCallback<String[]> valueCallback);

    void onCloseWindow(WebView webView);

    @Deprecated
    void onConsoleMessage(String str, int i, String str2);

    boolean onConsoleMessage(ConsoleMessage consoleMessage);

    boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message);

    @Deprecated
    void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater);

    void onGeolocationPermissionsHidePrompt();

    void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback);

    void onHideCustomView();

    boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult);

    boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult);

    boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult);

    boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);

    @Deprecated
    boolean onJsTimeout();

    void onPermissionRequest(PermissionRequest permissionRequest);

    void onPermissionRequestCanceled(PermissionRequest permissionRequest);

    void onProgressChanged(WebView webView, int i);

    @Deprecated
    void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater);

    void onReceivedIcon(WebView webView, Bitmap bitmap);

    void onReceivedTitle(WebView webView, String str);

    void onReceivedTouchIconUrl(WebView webView, String str, boolean z);

    void onRequestFocus(WebView webView);

    @Deprecated
    void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback);

    void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback);

    boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);
}
