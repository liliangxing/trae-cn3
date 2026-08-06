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
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebChromeClientDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\tJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001c\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J0\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J0\u0010$\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J0\u0010%\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J:\u0010&\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010'\u001a\u0004\u0018\u00010\u00142\b\u0010\"\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J\u001a\u0010,\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010-\u001a\u00020\fH\u0016J\u001c\u0010.\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u00100\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u000101H\u0016J$\u00100\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u00102\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u000101H\u0016J2\u00103\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u00104\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020706\u0018\u0001052\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0016\u0010:\u001a\u00020\t2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020705H\u0007J\u001e\u0010:\u001a\u00020\t2\f\u0010;\u001a\b\u0012\u0004\u0012\u000207052\u0006\u0010<\u001a\u00020\u0014H\u0007J&\u0010:\u001a\u00020\t2\f\u0010;\u001a\b\u0012\u0004\u0012\u000207052\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006>"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDispatcher;", "Landroid/webkit/WebChromeClient;", "()V", "webChromeClientDelegates", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDelegate;", "getWebChromeClientDelegates", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "addWebChromeClient", "", "webChromeClient", "index", "", "clear", WebChromeContainerClient.EVENT_getDefaultVideoPoster, "Landroid/graphics/Bitmap;", WebChromeContainerClient.EVENT_getVideoLoadingProgressView, "Landroid/view/View;", WebChromeContainerClient.EVENT_onConsoleMessage, "message", "", "lineNumber", "sourceID", WebChromeContainerClient.EVENT_onGeolocationPermissionsHidePrompt, WebChromeContainerClient.EVENT_onGeolocationPermissionsShowPrompt, "origin", JsCallParser.VALUE_CALLBACK, "Landroid/webkit/GeolocationPermissions$Callback;", WebChromeContainerClient.EVENT_onHideCustomView, WebChromeContainerClient.EVENT_onJsAlert, "", "view", "Landroid/webkit/WebView;", "url", "result", "Landroid/webkit/JsResult;", WebChromeContainerClient.EVENT_onJsBeforeUnload, WebChromeContainerClient.EVENT_onJsConfirm, WebChromeContainerClient.EVENT_onJsPrompt, "defaultValue", "Landroid/webkit/JsPromptResult;", WebChromeContainerClient.EVENT_onPermissionRequest, OauthTokenTriggerScene.REQUEST, "Landroid/webkit/PermissionRequest;", WebChromeContainerClient.EVENT_onProgressChanged, "newProgress", WebChromeContainerClient.EVENT_onReceivedTitle, "title", WebChromeContainerClient.EVENT_onShowCustomView, "Landroid/webkit/WebChromeClient$CustomViewCallback;", "requestedOrientation", WebChromeContainerClient.EVENT_onShowFileChooser, "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "openFileChooser", "uploadMsg", "acceptType", StrategyConstants.CAPTURE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class WebChromeClientDispatcher extends WebChromeClient {
    private final CopyOnWriteArrayList<WebChromeClientDelegate> webChromeClientDelegates = new CopyOnWriteArrayList<>();

    public final CopyOnWriteArrayList<WebChromeClientDelegate> getWebChromeClientDelegates() {
        return this.webChromeClientDelegates;
    }

    public final void addWebChromeClient(WebChromeClientDelegate webChromeClient) {
        Intrinsics.checkNotNullParameter(webChromeClient, "webChromeClient");
        this.webChromeClientDelegates.add(webChromeClient);
    }

    public final void addWebChromeClient(int index, WebChromeClientDelegate webChromeClient) {
        Intrinsics.checkNotNullParameter(webChromeClient, "webChromeClient");
        this.webChromeClientDelegates.add(index, webChromeClient);
    }

    public final void clear() {
        this.webChromeClientDelegates.clear();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebChromeClientDelegate) it.next()).onJsAlert(view, url, message, result);
            } catch (YieldError unused) {
            }
        }
        return super.onJsAlert(view, url, message, result);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebChromeClientDelegate) it.next()).onJsPrompt(view, url, message, defaultValue, result);
            } catch (YieldError unused) {
            }
        }
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        super.onShowCustomView(view, callback);
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onShowCustomView(view, callback);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        super.onHideCustomView();
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onHideCustomView();
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
        super.onShowCustomView(view, requestedOrientation, callback);
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onShowCustomView(view, requestedOrientation, callback);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(origin, callback);
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onGeolocationPermissionsShowPrompt(origin, callback);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest request) {
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onPermissionRequest(request);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        super.onConsoleMessage(message, lineNumber, sourceID);
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onConsoleMessage(message, lineNumber, sourceID);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView view, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebChromeClientDelegate) it.next()).onShowFileChooser(view, filePathCallback, fileChooserParams);
            } catch (YieldError unused) {
            }
        }
        return super.onShowFileChooser(view, filePathCallback, fileChooserParams);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onReceivedTitle(view, title);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onProgressChanged(view, newProgress);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebChromeClientDelegate) it.next()).onJsConfirm(view, url, message, result);
            } catch (YieldError unused) {
            }
        }
        return super.onJsConfirm(view, url, message, result);
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebChromeClientDelegate) it.next()).getVideoLoadingProgressView();
            } catch (YieldError unused) {
            }
        }
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).onGeolocationPermissionsHidePrompt();
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebChromeClientDelegate) it.next()).onJsBeforeUnload(view, url, message, result);
            } catch (YieldError unused) {
            }
        }
        return super.onJsBeforeUnload(view, url, message, result);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebChromeClientDelegate) it.next()).getDefaultVideoPoster();
            } catch (YieldError unused) {
            }
        }
        return super.getDefaultVideoPoster();
    }

    public final void openFileChooser(ValueCallback<Uri> uploadMsg) {
        Intrinsics.checkNotNullParameter(uploadMsg, "uploadMsg");
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).openFileChooser(uploadMsg);
            } catch (YieldError unused) {
            }
        }
    }

    public final void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
        Intrinsics.checkNotNullParameter(uploadMsg, "uploadMsg");
        Intrinsics.checkNotNullParameter(acceptType, "acceptType");
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).openFileChooser(uploadMsg, acceptType);
            } catch (YieldError unused) {
            }
        }
    }

    public final void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
        Intrinsics.checkNotNullParameter(uploadMsg, "uploadMsg");
        Intrinsics.checkNotNullParameter(acceptType, "acceptType");
        Intrinsics.checkNotNullParameter(capture, "capture");
        Iterator<T> it = this.webChromeClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebChromeClientDelegate) it.next()).openFileChooser(uploadMsg, acceptType, capture);
            } catch (YieldError unused) {
            }
        }
    }
}
