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
import com.bytedance.webx.core.ThreadSession;
import com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner;
import com.bytedance.webx.event.AbsListenerStub;
import com.bytedance.webx.event.EventManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebChromeContainerClient extends WebChromeContainerClientInner {
    public static final String EVENT_getDefaultVideoPoster = "getDefaultVideoPoster";
    public static final String EVENT_getVideoLoadingProgressView = "getVideoLoadingProgressView";
    public static final String EVENT_getVisitedHistory = "getVisitedHistory";
    public static final String EVENT_onCloseWindow = "onCloseWindow";
    public static final String EVENT_onConsoleMessage = "onConsoleMessage";
    public static final String EVENT_onCreateWindow = "onCreateWindow";
    public static final String EVENT_onExceededDatabaseQuota = "onExceededDatabaseQuota";
    public static final String EVENT_onGeolocationPermissionsHidePrompt = "onGeolocationPermissionsHidePrompt";
    public static final String EVENT_onGeolocationPermissionsShowPrompt = "onGeolocationPermissionsShowPrompt";
    public static final String EVENT_onHideCustomView = "onHideCustomView";
    public static final String EVENT_onJsAlert = "onJsAlert";
    public static final String EVENT_onJsBeforeUnload = "onJsBeforeUnload";
    public static final String EVENT_onJsConfirm = "onJsConfirm";
    public static final String EVENT_onJsPrompt = "onJsPrompt";
    public static final String EVENT_onJsTimeout = "onJsTimeout";
    public static final String EVENT_onPermissionRequest = "onPermissionRequest";
    public static final String EVENT_onPermissionRequestCanceled = "onPermissionRequestCanceled";
    public static final String EVENT_onProgressChanged = "onProgressChanged";
    public static final String EVENT_onReachedMaxAppCacheSize = "onReachedMaxAppCacheSize";
    public static final String EVENT_onReceivedIcon = "onReceivedIcon";
    public static final String EVENT_onReceivedTitle = "onReceivedTitle";
    public static final String EVENT_onReceivedTouchIconUrl = "onReceivedTouchIconUrl";
    public static final String EVENT_onRequestFocus = "onRequestFocus";
    public static final String EVENT_onShowCustomView = "onShowCustomView";
    public static final String EVENT_onShowFileChooser = "onShowFileChooser";

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onProgressChanged(WebView webView, int i) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onProgressChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onProgressChanged(webView, i);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onProgressChanged(webView, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onReceivedTitle(WebView webView, String str) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedTitle);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedTitle(webView, str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedTitle(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedIcon);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedIcon(webView, bitmap);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedIcon(webView, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedTouchIconUrl);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedTouchIconUrl(webView, str, z);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onShowCustomView);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onShowCustomView(view, customViewCallback);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onShowCustomView(view, customViewCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onShowCustomView);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onShowCustomView(view, i, customViewCallback);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onShowCustomView(view, i, customViewCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, i, customViewCallback);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onHideCustomView() {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onHideCustomView);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onHideCustomView();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onHideCustomView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onHideCustomView() {
        super.onHideCustomView();
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onCreateWindow);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onCreateWindow = ((ListenerStub) topListener).onCreateWindow(webView, z, z2, message);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onCreateWindow;
        }
        return super.onCreateWindow(webView, z, z2, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return super.onCreateWindow(webView, z, z2, message);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onRequestFocus(WebView webView) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onRequestFocus);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onRequestFocus(webView);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onRequestFocus(webView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onRequestFocus(WebView webView) {
        super.onRequestFocus(webView);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onCloseWindow(WebView webView) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onCloseWindow);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onCloseWindow(webView);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onCloseWindow(webView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onCloseWindow(WebView webView) {
        super.onCloseWindow(webView);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onJsAlert);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onJsAlert = ((ListenerStub) topListener).onJsAlert(webView, str, str2, jsResult);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onJsAlert;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onJsConfirm);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onJsConfirm = ((ListenerStub) topListener).onJsConfirm(webView, str, str2, jsResult);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onJsConfirm;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onJsPrompt);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onJsPrompt = ((ListenerStub) topListener).onJsPrompt(webView, str, str2, str3, jsPromptResult);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onJsPrompt;
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onJsBeforeUnload);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onJsBeforeUnload = ((ListenerStub) topListener).onJsBeforeUnload(webView, str, str2, jsResult);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onJsBeforeUnload;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onExceededDatabaseQuota);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReachedMaxAppCacheSize);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onGeolocationPermissionsShowPrompt);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onGeolocationPermissionsShowPrompt(str, callback);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onGeolocationPermissionsHidePrompt() {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onGeolocationPermissionsHidePrompt);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onGeolocationPermissionsHidePrompt();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onGeolocationPermissionsHidePrompt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onPermissionRequest);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onPermissionRequest(permissionRequest);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onPermissionRequest(permissionRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onPermissionRequest(PermissionRequest permissionRequest) {
        super.onPermissionRequest(permissionRequest);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onPermissionRequestCanceled);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onPermissionRequestCanceled(permissionRequest);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onPermissionRequestCanceled(permissionRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        super.onPermissionRequestCanceled(permissionRequest);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsTimeout() {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onJsTimeout);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onJsTimeout = ((ListenerStub) topListener).onJsTimeout();
            ThreadSession.sExtensionExtendStack.get().pop();
            return onJsTimeout;
        }
        return super.onJsTimeout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onJsTimeout() {
        return super.onJsTimeout();
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onConsoleMessage(String str, int i, String str2) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onConsoleMessage);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onConsoleMessage(str, i, str2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onConsoleMessage(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onConsoleMessage(String str, int i, String str2) {
        super.onConsoleMessage(str, i, str2);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onConsoleMessage);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onConsoleMessage = ((ListenerStub) topListener).onConsoleMessage(consoleMessage);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onConsoleMessage;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public Bitmap getDefaultVideoPoster() {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getDefaultVideoPoster);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            Bitmap defaultVideoPoster = ((ListenerStub) topListener).getDefaultVideoPoster();
            ThreadSession.sExtensionExtendStack.get().pop();
            return defaultVideoPoster;
        }
        return super.getDefaultVideoPoster();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap __super_getDefaultVideoPoster() {
        return super.getDefaultVideoPoster();
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public View getVideoLoadingProgressView() {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getVideoLoadingProgressView);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            View videoLoadingProgressView = ((ListenerStub) topListener).getVideoLoadingProgressView();
            ThreadSession.sExtensionExtendStack.get().pop();
            return videoLoadingProgressView;
        }
        return super.getVideoLoadingProgressView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View __super_getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getVisitedHistory);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).getVisitedHistory(valueCallback);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.getVisitedHistory(valueCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_getVisitedHistory(ValueCallback<String[]> valueCallback) {
        super.getVisitedHistory(valueCallback);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebChromeContainerClientInner, android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onShowFileChooser);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onShowFileChooser = ((ListenerStub) topListener).onShowFileChooser(webView, valueCallback, fileChooserParams);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onShowFileChooser;
        }
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static abstract class ListenerStub extends AbsListenerStub<WebChromeContainerClient> implements IWebChromeContainerClient {
        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onProgressChanged(WebView webView, int i) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onProgressChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onProgressChanged(webView, i);
            } else {
                ((ListenerStub) findNextListener).onProgressChanged(webView, i);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onReceivedTitle(WebView webView, String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onReceivedTitle);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedTitle(webView, str);
            } else {
                ((ListenerStub) findNextListener).onReceivedTitle(webView, str);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onReceivedIcon);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedIcon(webView, bitmap);
            } else {
                ((ListenerStub) findNextListener).onReceivedIcon(webView, bitmap);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onReceivedTouchIconUrl);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedTouchIconUrl(webView, str, z);
            } else {
                ((ListenerStub) findNextListener).onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onShowCustomView);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onShowCustomView(view, customViewCallback);
            } else {
                ((ListenerStub) findNextListener).onShowCustomView(view, customViewCallback);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onShowCustomView);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onShowCustomView(view, i, customViewCallback);
            } else {
                ((ListenerStub) findNextListener).onShowCustomView(view, i, customViewCallback);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onHideCustomView() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onHideCustomView);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onHideCustomView();
            } else {
                ((ListenerStub) findNextListener).onHideCustomView();
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onCreateWindow);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onCreateWindow(webView, z, z2, message);
            }
            return ((ListenerStub) findNextListener).onCreateWindow(webView, z, z2, message);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onRequestFocus(WebView webView) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onRequestFocus);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onRequestFocus(webView);
            } else {
                ((ListenerStub) findNextListener).onRequestFocus(webView);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onCloseWindow(WebView webView) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onCloseWindow);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onCloseWindow(webView);
            } else {
                ((ListenerStub) findNextListener).onCloseWindow(webView);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onJsAlert);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onJsAlert(webView, str, str2, jsResult);
            }
            return ((ListenerStub) findNextListener).onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onJsConfirm);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onJsConfirm(webView, str, str2, jsResult);
            }
            return ((ListenerStub) findNextListener).onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onJsPrompt);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return ((ListenerStub) findNextListener).onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onJsBeforeUnload);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return ((ListenerStub) findNextListener).onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onExceededDatabaseQuota);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            } else {
                ((ListenerStub) findNextListener).onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onReachedMaxAppCacheSize);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            } else {
                ((ListenerStub) findNextListener).onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onGeolocationPermissionsShowPrompt);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onGeolocationPermissionsShowPrompt(str, callback);
            } else {
                ((ListenerStub) findNextListener).onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onGeolocationPermissionsHidePrompt() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onGeolocationPermissionsHidePrompt);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onGeolocationPermissionsHidePrompt();
            } else {
                ((ListenerStub) findNextListener).onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onPermissionRequest);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onPermissionRequest(permissionRequest);
            } else {
                ((ListenerStub) findNextListener).onPermissionRequest(permissionRequest);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onPermissionRequestCanceled);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onPermissionRequestCanceled(permissionRequest);
            } else {
                ((ListenerStub) findNextListener).onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public boolean onJsTimeout() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onJsTimeout);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onJsTimeout();
            }
            return ((ListenerStub) findNextListener).onJsTimeout();
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void onConsoleMessage(String str, int i, String str2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onConsoleMessage);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onConsoleMessage(str, i, str2);
            } else {
                ((ListenerStub) findNextListener).onConsoleMessage(str, i, str2);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onConsoleMessage);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onConsoleMessage(consoleMessage);
            }
            return ((ListenerStub) findNextListener).onConsoleMessage(consoleMessage);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public Bitmap getDefaultVideoPoster() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_getDefaultVideoPoster);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getDefaultVideoPoster();
            }
            return ((ListenerStub) findNextListener).getDefaultVideoPoster();
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public View getVideoLoadingProgressView() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_getVideoLoadingProgressView);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getVideoLoadingProgressView();
            }
            return ((ListenerStub) findNextListener).getVideoLoadingProgressView();
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_getVisitedHistory);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_getVisitedHistory(valueCallback);
            } else {
                ((ListenerStub) findNextListener).getVisitedHistory(valueCallback);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebChromeContainerClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebChromeContainerClient.EVENT_onShowFileChooser);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return ((ListenerStub) findNextListener).onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
    }
}
