package com.bytedance.webx.core.webview.client.inner;

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
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.context.ExtendableContext;
import com.bytedance.webx.context.IContextItem;
import com.bytedance.webx.core.ExtendableControlDelegate;
import com.bytedance.webx.core.IExtendableControl;
import com.bytedance.webx.core.webview.client.IWebChromeContainerClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebChromeContainerClientInner extends WebChromeClient implements IExtendableControl, IWebChromeContainerClient, IContextItem {
    private ExtendableControlDelegate mContainerControlDelegate = new ExtendableControlDelegate();
    private WebXEnv mEnv;
    private WebChromeClient mWebChromeClientDelegate;

    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
    }

    @Override // com.bytedance.webx.core.IExtendableControl
    public void init(WebXEnv webXEnv) {
        this.mEnv = webXEnv;
        this.mContainerControlDelegate.setExtendableContext(new ExtendableContext(this.mEnv, this));
    }

    @Override // com.bytedance.webx.core.IExtendableControl
    public ExtendableContext getExtendableContext() {
        ExtendableControlDelegate extendableControlDelegate = this.mContainerControlDelegate;
        if (extendableControlDelegate == null) {
            return null;
        }
        return extendableControlDelegate.getExtendableContext();
    }

    public void setWebChromeClientDelegate(WebChromeClient webChromeClient) {
        this.mWebChromeClientDelegate = webChromeClient;
    }

    public WebChromeClient getWebChromeClientDelegate() {
        return this.mWebChromeClientDelegate;
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onProgressChanged(WebView webView, int i) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onReceivedTitle(WebView webView, String str) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onHideCustomView() {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onCreateWindow(webView, z, z2, message);
        }
        return super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onRequestFocus(WebView webView) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onCloseWindow(WebView webView) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsAlert(webView, str, str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsConfirm(webView, str, str2, jsResult);
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onGeolocationPermissionsHidePrompt() {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (this.mWebChromeClientDelegate != null) {
            this.mWebChromeClientDelegate.onPermissionRequest(permissionRequest);
        } else {
            super.onPermissionRequest(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        if (this.mWebChromeClientDelegate != null) {
            this.mWebChromeClientDelegate.onPermissionRequestCanceled(permissionRequest);
        } else {
            super.onPermissionRequestCanceled(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onJsTimeout() {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsTimeout();
        }
        return super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void onConsoleMessage(String str, int i, String str2) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.onConsoleMessage(str, i, str2);
        } else {
            super.onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public Bitmap getDefaultVideoPoster() {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.getDefaultVideoPoster();
        }
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public View getVideoLoadingProgressView() {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            return webChromeClient.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        WebChromeClient webChromeClient = this.mWebChromeClientDelegate;
        if (webChromeClient != null) {
            webChromeClient.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    @Override // android.webkit.WebChromeClient, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (this.mWebChromeClientDelegate != null) {
            return this.mWebChromeClientDelegate.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }
}
