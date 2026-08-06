package com.bytedance.ies.bullet.service.base.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.webx.core.webview.client.WebChromeContainerClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebCompatDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J0\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J0\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J0\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J:\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001eH\u0016J2\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0014\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J2\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0014\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010&H\u0016J\u0016\u0010'\u001a\u00020\b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0!H\u0016J\u001e\u0010'\u001a\u00020\b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0!2\u0006\u0010)\u001a\u00020\u000bH\u0016J&\u0010'\u001a\u00020\b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0!2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0016¨\u0006+"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDelegate;", "Landroid/webkit/WebChromeClient;", "()V", WebChromeContainerClient.EVENT_getDefaultVideoPoster, "Landroid/graphics/Bitmap;", WebChromeContainerClient.EVENT_getVideoLoadingProgressView, "Landroid/view/View;", WebChromeContainerClient.EVENT_onGeolocationPermissionsHidePrompt, "", WebChromeContainerClient.EVENT_onGeolocationPermissionsShowPrompt, "origin", "", JsCallParser.VALUE_CALLBACK, "Landroid/webkit/GeolocationPermissions$Callback;", WebChromeContainerClient.EVENT_onJsAlert, "", "view", "Landroid/webkit/WebView;", "url", "message", "result", "Landroid/webkit/JsResult;", WebChromeContainerClient.EVENT_onJsBeforeUnload, WebChromeContainerClient.EVENT_onJsConfirm, WebChromeContainerClient.EVENT_onJsPrompt, "defaultValue", "Landroid/webkit/JsPromptResult;", WebChromeContainerClient.EVENT_onPermissionRequest, OauthTokenTriggerScene.REQUEST, "Landroid/webkit/PermissionRequest;", "Lcom/bytedance/ies/bullet/service/base/web/IPermissionRequest;", WebChromeContainerClient.EVENT_onShowFileChooser, "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "Lcom/bytedance/ies/bullet/service/base/web/IFileChooserParams;", "openFileChooser", "uploadMsg", "acceptType", StrategyConstants.CAPTURE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class WebChromeClientDelegate extends WebChromeClient {
    public void openFileChooser(ValueCallback<Uri> uploadMsg) {
        Intrinsics.checkNotNullParameter(uploadMsg, "uploadMsg");
    }

    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
        Intrinsics.checkNotNullParameter(uploadMsg, "uploadMsg");
        Intrinsics.checkNotNullParameter(acceptType, "acceptType");
    }

    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
        Intrinsics.checkNotNullParameter(uploadMsg, "uploadMsg");
        Intrinsics.checkNotNullParameter(acceptType, "acceptType");
        Intrinsics.checkNotNullParameter(capture, "capture");
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest request) {
        onPermissionRequest(request != null ? WebCompatDelegateKt.transform(request) : null);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView view, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return onShowFileChooser(view, filePathCallback, fileChooserParams != null ? WebCompatDelegateKt.transform(fileChooserParams) : null);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        throw new YieldError("An operation is not implemented");
    }

    public void onPermissionRequest(IPermissionRequest request) {
        throw new YieldError("An operation is not implemented");
    }

    public boolean onShowFileChooser(WebView view, ValueCallback<Uri[]> filePathCallback, IFileChooserParams fileChooserParams) {
        throw new YieldError("An operation is not implemented");
    }
}
