package com.bytedance.webx.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.bytedance.webx.ExtensionParam;
import com.bytedance.webx.IExtension;
import com.bytedance.webx.core.ThreadSession;
import com.bytedance.webx.core.webview.inner.WebViewContainerInner;
import com.bytedance.webx.event.AbsListenerStub;
import com.bytedance.webx.event.EventManager;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebViewContainer extends WebViewContainerInner {
    public static final String EVENT_addJavascriptInterface = "addJavascriptInterface";
    public static final String EVENT_canGoBack = "canGoBack";
    public static final String EVENT_canGoBackOrForward = "canGoBackOrForward";
    public static final String EVENT_canGoForward = "canGoForward";
    public static final String EVENT_createWebMessageChannel = "createWebMessageChannel";
    public static final String EVENT_destroy = "destroy";
    public static final String EVENT_dispatchDraw = "dispatchDraw";
    public static final String EVENT_dispatchKeyEvent = "dispatchKeyEvent";
    public static final String EVENT_dispatchTouchEvent = "dispatchTouchEvent";
    public static final String EVENT_documentHasImages = "documentHasImages";
    public static final String EVENT_draw = "draw";
    public static final String EVENT_evaluateJavascript = "evaluateJavascript";
    public static final String EVENT_flingScroll = "flingScroll";
    public static final String EVENT_getCertificate = "getCertificate";
    public static final String EVENT_getHttpAuthUsernamePassword = "getHttpAuthUsernamePassword";
    public static final String EVENT_getSettings = "getSettings";
    public static final String EVENT_getWebChromeClient = "getWebChromeClient";
    public static final String EVENT_getWebViewClient = "getWebViewClient";
    public static final String EVENT_getWebViewRenderProcess = "getWebViewRenderProcess";
    public static final String EVENT_getWebViewRenderProcessClient = "getWebViewRenderProcessClient";
    public static final String EVENT_goBack = "goBack";
    public static final String EVENT_goBackOrForward = "goBackOrForward";
    public static final String EVENT_goForward = "goForward";
    public static final String EVENT_loadData = "loadData";
    public static final String EVENT_loadDataWithBaseURL = "loadDataWithBaseURL";
    public static final String EVENT_loadUrl = "loadUrl";
    public static final String EVENT_onAttachedToWindow = "onAttachedToWindow";
    public static final String EVENT_onCheckIsTextEditor = "onCheckIsTextEditor";
    public static final String EVENT_onConfigurationChanged = "onConfigurationChanged";
    public static final String EVENT_onCreateInputConnection = "onCreateInputConnection";
    public static final String EVENT_onDragEvent = "onDragEvent";
    public static final String EVENT_onDraw = "onDraw";
    public static final String EVENT_onFinishTemporaryDetach = "onFinishTemporaryDetach";
    public static final String EVENT_onFocusChanged = "onFocusChanged";
    public static final String EVENT_onGenericMotionEvent = "onGenericMotionEvent";
    public static final String EVENT_onHoverEvent = "onHoverEvent";
    public static final String EVENT_onInterceptTouchEvent = "onInterceptTouchEvent";
    public static final String EVENT_onKeyDown = "onKeyDown";
    public static final String EVENT_onKeyMultiple = "onKeyMultiple";
    public static final String EVENT_onKeyUp = "onKeyUp";
    public static final String EVENT_onMeasure = "onMeasure";
    public static final String EVENT_onOverScrolled = "onOverScrolled";
    public static final String EVENT_onPause = "onPause";
    public static final String EVENT_onProvideAutofillVirtualStructure = "onProvideAutofillVirtualStructure";
    public static final String EVENT_onProvideVirtualStructure = "onProvideVirtualStructure";
    public static final String EVENT_onResume = "onResume";
    public static final String EVENT_onScrollChanged = "onScrollChanged";
    public static final String EVENT_onSizeChanged = "onSizeChanged";
    public static final String EVENT_onStartTemporaryDetach = "onStartTemporaryDetach";
    public static final String EVENT_onTouchEvent = "onTouchEvent";
    public static final String EVENT_onTrackballEvent = "onTrackballEvent";
    public static final String EVENT_onVisibilityChanged = "onVisibilityChanged";
    public static final String EVENT_onWindowFocusChanged = "onWindowFocusChanged";
    public static final String EVENT_onWindowVisibilityChanged = "onWindowVisibilityChanged";
    public static final String EVENT_overScrollBy = "overScrollBy";
    public static final String EVENT_pageDown = "pageDown";
    public static final String EVENT_pageUp = "pageUp";
    public static final String EVENT_postUrl = "postUrl";
    public static final String EVENT_postWebMessage = "postWebMessage";
    public static final String EVENT_reload = "reload";
    public static final String EVENT_removeJavascriptInterface = "removeJavascriptInterface";
    public static final String EVENT_requestFocus = "requestFocus";
    public static final String EVENT_restoreState = "restoreState";
    public static final String EVENT_savePassword = "savePassword";
    public static final String EVENT_saveState = "saveState";
    public static final String EVENT_saveWebArchive = "saveWebArchive";
    public static final String EVENT_setCertificate = "setCertificate";
    public static final String EVENT_setDownloadListener = "setDownloadListener";
    public static final String EVENT_setFindListener = "setFindListener";
    public static final String EVENT_setHttpAuthUsernamePassword = "setHttpAuthUsernamePassword";
    public static final String EVENT_setWebChromeClient = "setWebChromeClient";
    public static final String EVENT_setWebViewClient = "setWebViewClient";
    public static final String EVENT_setWebViewRenderProcessClient = "setWebViewRenderProcessClient";
    public static final String EVENT_stopLoading = "stopLoading";
    public static final String EVENT_zoomBy = "zoomBy";
    public static final String EVENT_zoomIn = "zoomIn";
    public static final String EVENT_zoomOut = "zoomOut";

    public WebViewContainer(Context context) {
        super(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public SslCertificate getCertificate() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getCertificate();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getCertificate);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            SslCertificate certificate = ((ListenerStub) topListener).getCertificate();
            ThreadSession.sExtensionExtendStack.get().pop();
            return certificate;
        }
        return super.getCertificate();
    }

    public SslCertificate getCertificate(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        SslCertificate certificate = getCertificate();
        ThreadSession.sExtensionParamStack.get().pop();
        return certificate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SslCertificate __super_getCertificate() {
        return super.getCertificate();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setCertificate(SslCertificate sslCertificate) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setCertificate(sslCertificate);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_setCertificate);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).setCertificate(sslCertificate);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.setCertificate(sslCertificate);
    }

    public void setCertificate(SslCertificate sslCertificate, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        setCertificate(sslCertificate);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_setCertificate(SslCertificate sslCertificate) {
        super.setCertificate(sslCertificate);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void savePassword(String str, String str2, String str3) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.savePassword(str, str2, str3);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_savePassword);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).savePassword(str, str2, str3);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.savePassword(str, str2, str3);
    }

    public void savePassword(String str, String str2, String str3, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        savePassword(str, str2, str3);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_savePassword(String str, String str2, String str3) {
        super.savePassword(str, str2, str3);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setHttpAuthUsernamePassword(str, str2, str3, str4);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_setHttpAuthUsernamePassword);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).setHttpAuthUsernamePassword(str, str2, str3, str4);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        setHttpAuthUsernamePassword(str, str2, str3, str4);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        super.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getHttpAuthUsernamePassword(str, str2);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getHttpAuthUsernamePassword);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            String[] httpAuthUsernamePassword = ((ListenerStub) topListener).getHttpAuthUsernamePassword(str, str2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return httpAuthUsernamePassword;
        }
        return super.getHttpAuthUsernamePassword(str, str2);
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        String[] httpAuthUsernamePassword = getHttpAuthUsernamePassword(str, str2);
        ThreadSession.sExtensionParamStack.get().pop();
        return httpAuthUsernamePassword;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] __super_getHttpAuthUsernamePassword(String str, String str2) {
        return super.getHttpAuthUsernamePassword(str, str2);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void destroy() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.destroy();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_destroy);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).destroy();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.destroy();
    }

    public void destroy(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        destroy();
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_destroy() {
        super.destroy();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebBackForwardList saveState(Bundle bundle) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.saveState(bundle);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_saveState);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebBackForwardList saveState = ((ListenerStub) topListener).saveState(bundle);
            ThreadSession.sExtensionExtendStack.get().pop();
            return saveState;
        }
        return super.saveState(bundle);
    }

    public WebBackForwardList saveState(Bundle bundle, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebBackForwardList saveState = saveState(bundle);
        ThreadSession.sExtensionParamStack.get().pop();
        return saveState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebBackForwardList __super_saveState(Bundle bundle) {
        return super.saveState(bundle);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebBackForwardList restoreState(Bundle bundle) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.restoreState(bundle);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_restoreState);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebBackForwardList restoreState = ((ListenerStub) topListener).restoreState(bundle);
            ThreadSession.sExtensionExtendStack.get().pop();
            return restoreState;
        }
        return super.restoreState(bundle);
    }

    public WebBackForwardList restoreState(Bundle bundle, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebBackForwardList restoreState = restoreState(bundle);
        ThreadSession.sExtensionParamStack.get().pop();
        return restoreState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebBackForwardList __super_restoreState(Bundle bundle) {
        return super.restoreState(bundle);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void loadUrl(String str, Map<String, String> map) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.loadUrl(str, map);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_loadUrl);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).loadUrl(str, map);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.loadUrl(str, map);
    }

    public void loadUrl(String str, Map<String, String> map, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        loadUrl(str, map);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str, map);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void loadUrl(String str) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.loadUrl(str);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_loadUrl);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).loadUrl(str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.loadUrl(str);
    }

    public void loadUrl(String str, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        loadUrl(str);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void postUrl(String str, byte[] bArr) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.postUrl(str, bArr);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_postUrl);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).postUrl(str, bArr);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.postUrl(str, bArr);
    }

    public void postUrl(String str, byte[] bArr, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        postUrl(str, bArr);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_postUrl(String str, byte[] bArr) {
        super.postUrl(str, bArr);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void loadData(String str, String str2, String str3) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.loadData(str, str2, str3);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_loadData);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).loadData(str, str2, str3);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.loadData(str, str2, str3);
    }

    public void loadData(String str, String str2, String str3, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        loadData(str, str2, str3);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_loadData(String str, String str2, String str3) {
        super.loadData(str, str2, str3);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_loadDataWithBaseURL);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).loadDataWithBaseURL(str, str2, str3, str4, str5);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        loadDataWithBaseURL(str, str2, str3, str4, str5);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.evaluateJavascript(str, valueCallback);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_evaluateJavascript);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).evaluateJavascript(str, valueCallback);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        evaluateJavascript(str, valueCallback);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void saveWebArchive(String str) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.saveWebArchive(str);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_saveWebArchive);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).saveWebArchive(str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.saveWebArchive(str);
    }

    public void saveWebArchive(String str, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        saveWebArchive(str);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_saveWebArchive(String str) {
        super.saveWebArchive(str);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.saveWebArchive(str, z, valueCallback);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_saveWebArchive);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).saveWebArchive(str, z, valueCallback);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.saveWebArchive(str, z, valueCallback);
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        saveWebArchive(str, z, valueCallback);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        super.saveWebArchive(str, z, valueCallback);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void stopLoading() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.stopLoading();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_stopLoading);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).stopLoading();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.stopLoading();
    }

    public void stopLoading(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        stopLoading();
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_stopLoading() {
        super.stopLoading();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void reload() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.reload();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_reload);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).reload();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.reload();
    }

    public void reload(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        reload();
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_reload() {
        super.reload();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean canGoBack() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.canGoBack();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_canGoBack);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean canGoBack = ((ListenerStub) topListener).canGoBack();
            ThreadSession.sExtensionExtendStack.get().pop();
            return canGoBack;
        }
        return super.canGoBack();
    }

    public boolean canGoBack(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean canGoBack = canGoBack();
        ThreadSession.sExtensionParamStack.get().pop();
        return canGoBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_canGoBack() {
        return super.canGoBack();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void goBack() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.goBack();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_goBack);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).goBack();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.goBack();
    }

    public void goBack(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        goBack();
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_goBack() {
        super.goBack();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean canGoForward() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.canGoForward();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_canGoForward);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean canGoForward = ((ListenerStub) topListener).canGoForward();
            ThreadSession.sExtensionExtendStack.get().pop();
            return canGoForward;
        }
        return super.canGoForward();
    }

    public boolean canGoForward(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean canGoForward = canGoForward();
        ThreadSession.sExtensionParamStack.get().pop();
        return canGoForward;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_canGoForward() {
        return super.canGoForward();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void goForward() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.goForward();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_goForward);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).goForward();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.goForward();
    }

    public void goForward(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        goForward();
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_goForward() {
        super.goForward();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean canGoBackOrForward(int i) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.canGoBackOrForward(i);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_canGoBackOrForward);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean canGoBackOrForward = ((ListenerStub) topListener).canGoBackOrForward(i);
            ThreadSession.sExtensionExtendStack.get().pop();
            return canGoBackOrForward;
        }
        return super.canGoBackOrForward(i);
    }

    public boolean canGoBackOrForward(int i, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean canGoBackOrForward = canGoBackOrForward(i);
        ThreadSession.sExtensionParamStack.get().pop();
        return canGoBackOrForward;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_canGoBackOrForward(int i) {
        return super.canGoBackOrForward(i);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void goBackOrForward(int i) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.goBackOrForward(i);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_goBackOrForward);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).goBackOrForward(i);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.goBackOrForward(i);
    }

    public void goBackOrForward(int i, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        goBackOrForward(i);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_goBackOrForward(int i) {
        super.goBackOrForward(i);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean pageUp(boolean z) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.pageUp(z);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_pageUp);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean pageUp = ((ListenerStub) topListener).pageUp(z);
            ThreadSession.sExtensionExtendStack.get().pop();
            return pageUp;
        }
        return super.pageUp(z);
    }

    public boolean pageUp(boolean z, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean pageUp = pageUp(z);
        ThreadSession.sExtensionParamStack.get().pop();
        return pageUp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_pageUp(boolean z) {
        return super.pageUp(z);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean pageDown(boolean z) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.pageDown(z);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_pageDown);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean pageDown = ((ListenerStub) topListener).pageDown(z);
            ThreadSession.sExtensionExtendStack.get().pop();
            return pageDown;
        }
        return super.pageDown(z);
    }

    public boolean pageDown(boolean z, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean pageDown = pageDown(z);
        ThreadSession.sExtensionParamStack.get().pop();
        return pageDown;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_pageDown(boolean z) {
        return super.pageDown(z);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void onPause() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onPause();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onPause);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onPause();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onPause() {
        super.onPause();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void onResume() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onResume();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onResume);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onResume();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onResume() {
        super.onResume();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setFindListener(WebView.FindListener findListener) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setFindListener(findListener);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_setFindListener);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).setFindListener(findListener);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.setFindListener(findListener);
    }

    public void setFindListener(WebView.FindListener findListener, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        setFindListener(findListener);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_setFindListener(WebView.FindListener findListener) {
        super.setFindListener(findListener);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void documentHasImages(Message message) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.documentHasImages(message);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_documentHasImages);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).documentHasImages(message);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.documentHasImages(message);
    }

    public void documentHasImages(Message message, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        documentHasImages(message);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_documentHasImages(Message message) {
        super.documentHasImages(message);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setWebViewClient(WebViewClient webViewClient) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setWebViewClient(webViewClient);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_setWebViewClient);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).setWebViewClient(webViewClient);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.setWebViewClient(webViewClient);
    }

    public void setWebViewClient(WebViewClient webViewClient, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        setWebViewClient(webViewClient);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebViewClient getWebViewClient() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getWebViewClient();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getWebViewClient);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebViewClient webViewClient = ((ListenerStub) topListener).getWebViewClient();
            ThreadSession.sExtensionExtendStack.get().pop();
            return webViewClient;
        }
        return super.getWebViewClient();
    }

    public WebViewClient getWebViewClient(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebViewClient webViewClient = getWebViewClient();
        ThreadSession.sExtensionParamStack.get().pop();
        return webViewClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewClient __super_getWebViewClient() {
        return super.getWebViewClient();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebViewRenderProcess getWebViewRenderProcess() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getWebViewRenderProcess();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getWebViewRenderProcess);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebViewRenderProcess webViewRenderProcess = ((ListenerStub) topListener).getWebViewRenderProcess();
            ThreadSession.sExtensionExtendStack.get().pop();
            return webViewRenderProcess;
        }
        return super.getWebViewRenderProcess();
    }

    public WebViewRenderProcess getWebViewRenderProcess(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebViewRenderProcess webViewRenderProcess = getWebViewRenderProcess();
        ThreadSession.sExtensionParamStack.get().pop();
        return webViewRenderProcess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewRenderProcess __super_getWebViewRenderProcess() {
        return super.getWebViewRenderProcess();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_setWebViewRenderProcessClient);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
    }

    public void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        super.setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setWebViewRenderProcessClient(WebViewRenderProcessClient webViewRenderProcessClient) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setWebViewRenderProcessClient(webViewRenderProcessClient);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_setWebViewRenderProcessClient);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).setWebViewRenderProcessClient(webViewRenderProcessClient);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.setWebViewRenderProcessClient(webViewRenderProcessClient);
    }

    public void setWebViewRenderProcessClient(WebViewRenderProcessClient webViewRenderProcessClient, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        setWebViewRenderProcessClient(webViewRenderProcessClient);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_setWebViewRenderProcessClient(WebViewRenderProcessClient webViewRenderProcessClient) {
        super.setWebViewRenderProcessClient(webViewRenderProcessClient);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getWebViewRenderProcessClient();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getWebViewRenderProcessClient);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebViewRenderProcessClient webViewRenderProcessClient = ((ListenerStub) topListener).getWebViewRenderProcessClient();
            ThreadSession.sExtensionExtendStack.get().pop();
            return webViewRenderProcessClient;
        }
        return super.getWebViewRenderProcessClient();
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebViewRenderProcessClient webViewRenderProcessClient = getWebViewRenderProcessClient();
        ThreadSession.sExtensionParamStack.get().pop();
        return webViewRenderProcessClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewRenderProcessClient __super_getWebViewRenderProcessClient() {
        return super.getWebViewRenderProcessClient();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setDownloadListener(DownloadListener downloadListener) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setDownloadListener(downloadListener);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_setDownloadListener);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).setDownloadListener(downloadListener);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.setDownloadListener(downloadListener);
    }

    public void setDownloadListener(DownloadListener downloadListener, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        setDownloadListener(downloadListener);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_setDownloadListener(DownloadListener downloadListener) {
        super.setDownloadListener(downloadListener);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setWebChromeClient(webChromeClient);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_setWebChromeClient);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).setWebChromeClient(webChromeClient);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.setWebChromeClient(webChromeClient);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        setWebChromeClient(webChromeClient);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_setWebChromeClient(WebChromeClient webChromeClient) {
        super.setWebChromeClient(webChromeClient);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebChromeClient getWebChromeClient() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getWebChromeClient();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getWebChromeClient);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebChromeClient webChromeClient = ((ListenerStub) topListener).getWebChromeClient();
            ThreadSession.sExtensionExtendStack.get().pop();
            return webChromeClient;
        }
        return super.getWebChromeClient();
    }

    public WebChromeClient getWebChromeClient(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebChromeClient webChromeClient = getWebChromeClient();
        ThreadSession.sExtensionParamStack.get().pop();
        return webChromeClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebChromeClient __super_getWebChromeClient() {
        return super.getWebChromeClient();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void addJavascriptInterface(Object obj, String str) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.addJavascriptInterface(obj, str);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_addJavascriptInterface);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).addJavascriptInterface(obj, str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.addJavascriptInterface(obj, str);
    }

    public void addJavascriptInterface(Object obj, String str, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        addJavascriptInterface(obj, str);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void removeJavascriptInterface(String str) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.removeJavascriptInterface(str);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_removeJavascriptInterface);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).removeJavascriptInterface(str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.removeJavascriptInterface(str);
    }

    public void removeJavascriptInterface(String str, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        removeJavascriptInterface(str);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_removeJavascriptInterface(String str) {
        super.removeJavascriptInterface(str);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebMessagePort[] createWebMessageChannel() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.createWebMessageChannel();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_createWebMessageChannel);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebMessagePort[] createWebMessageChannel = ((ListenerStub) topListener).createWebMessageChannel();
            ThreadSession.sExtensionExtendStack.get().pop();
            return createWebMessageChannel;
        }
        return super.createWebMessageChannel();
    }

    public WebMessagePort[] createWebMessageChannel(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebMessagePort[] createWebMessageChannel = createWebMessageChannel();
        ThreadSession.sExtensionParamStack.get().pop();
        return createWebMessageChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebMessagePort[] __super_createWebMessageChannel() {
        return super.createWebMessageChannel();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void postWebMessage(WebMessage webMessage, Uri uri) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.postWebMessage(webMessage, uri);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_postWebMessage);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).postWebMessage(webMessage, uri);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.postWebMessage(webMessage, uri);
    }

    public void postWebMessage(WebMessage webMessage, Uri uri, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        postWebMessage(webMessage, uri);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_postWebMessage(WebMessage webMessage, Uri uri) {
        super.postWebMessage(webMessage, uri);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebSettings getSettings() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getSettings();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_getSettings);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebSettings settings = ((ListenerStub) topListener).getSettings();
            ThreadSession.sExtensionExtendStack.get().pop();
            return settings;
        }
        return super.getSettings();
    }

    public WebSettings getSettings(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebSettings settings = getSettings();
        ThreadSession.sExtensionParamStack.get().pop();
        return settings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebSettings __super_getSettings() {
        return super.getSettings();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void flingScroll(int i, int i2) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.flingScroll(i, i2);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_flingScroll);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).flingScroll(i, i2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.flingScroll(i, i2);
    }

    public void flingScroll(int i, int i2, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        flingScroll(i, i2);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_flingScroll(int i, int i2) {
        super.flingScroll(i, i2);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void zoomBy(float f) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.zoomBy(f);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_zoomBy);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).zoomBy(f);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.zoomBy(f);
    }

    public void zoomBy(float f, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        zoomBy(f);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_zoomBy(float f) {
        super.zoomBy(f);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean zoomIn() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.zoomIn();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_zoomIn);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean zoomIn = ((ListenerStub) topListener).zoomIn();
            ThreadSession.sExtensionExtendStack.get().pop();
            return zoomIn;
        }
        return super.zoomIn();
    }

    public boolean zoomIn(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean zoomIn = zoomIn();
        ThreadSession.sExtensionParamStack.get().pop();
        return zoomIn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_zoomIn() {
        return super.zoomIn();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean zoomOut() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.zoomOut();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_zoomOut);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean zoomOut = ((ListenerStub) topListener).zoomOut();
            ThreadSession.sExtensionExtendStack.get().pop();
            return zoomOut;
        }
        return super.zoomOut();
    }

    public boolean zoomOut(ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean zoomOut = zoomOut();
        ThreadSession.sExtensionParamStack.get().pop();
        return zoomOut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_zoomOut() {
        return super.zoomOut();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onAttachedToWindow();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onAttachedToWindow);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onAttachedToWindow();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onHoverEvent(motionEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onHoverEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onHoverEvent = ((ListenerStub) topListener).onHoverEvent(motionEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onHoverEvent;
        }
        return super.onHoverEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onTouchEvent(motionEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onTouchEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onTouchEvent = ((ListenerStub) topListener).onTouchEvent(motionEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onTouchEvent;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onGenericMotionEvent(motionEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onGenericMotionEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onGenericMotionEvent = ((ListenerStub) topListener).onGenericMotionEvent(motionEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onGenericMotionEvent;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onTrackballEvent(motionEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onTrackballEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onTrackballEvent = ((ListenerStub) topListener).onTrackballEvent(motionEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onTrackballEvent;
        }
        return super.onTrackballEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onKeyDown(i, keyEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onKeyDown);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onKeyDown = ((ListenerStub) topListener).onKeyDown(i, keyEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onKeyDown;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onKeyUp(i, keyEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onKeyUp);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onKeyUp = ((ListenerStub) topListener).onKeyUp(i, keyEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onKeyUp;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onKeyMultiple(i, i2, keyEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onKeyMultiple);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onKeyMultiple = ((ListenerStub) topListener).onKeyMultiple(i, i2, keyEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onKeyMultiple;
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public void onProvideVirtualStructure(ViewStructure viewStructure) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onProvideVirtualStructure(viewStructure);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onProvideVirtualStructure);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onProvideVirtualStructure(viewStructure);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onProvideVirtualStructure(viewStructure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onProvideVirtualStructure(ViewStructure viewStructure) {
        super.onProvideVirtualStructure(viewStructure);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onProvideAutofillVirtualStructure(viewStructure, i);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onProvideAutofillVirtualStructure);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onProvideAutofillVirtualStructure(viewStructure, i);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onOverScrolled(i, i2, z, z2);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onOverScrolled);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onOverScrolled(i, i2, z, z2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onWindowVisibilityChanged(i);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onWindowVisibilityChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onWindowVisibilityChanged(i);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onWindowVisibilityChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onDraw(canvas);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onDraw);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onDraw(canvas);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onConfigurationChanged(configuration);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onConfigurationChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onConfigurationChanged(configuration);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onCreateInputConnection(editorInfo);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onCreateInputConnection);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            InputConnection onCreateInputConnection = ((ListenerStub) topListener).onCreateInputConnection(editorInfo);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onCreateInputConnection;
        }
        return super.onCreateInputConnection(editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputConnection __super_onCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onDragEvent(DragEvent dragEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onDragEvent(dragEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onDragEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onDragEvent = ((ListenerStub) topListener).onDragEvent(dragEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onDragEvent;
        }
        return super.onDragEvent(dragEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onDragEvent(DragEvent dragEvent) {
        return super.onDragEvent(dragEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onVisibilityChanged(view, i);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onVisibilityChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onVisibilityChanged(view, i);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onVisibilityChanged(view, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public void onWindowFocusChanged(boolean z) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onWindowFocusChanged(z);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onWindowFocusChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onWindowFocusChanged(z);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onWindowFocusChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onFocusChanged(z, i, rect);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onFocusChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onFocusChanged(z, i, rect);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onFocusChanged(z, i, rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onSizeChanged(i, i2, i3, i4);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onSizeChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onSizeChanged(i, i2, i3, i4);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onScrollChanged(i, i2, i3, i4);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onScrollChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onScrollChanged(i, i2, i3, i4);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_dispatchKeyEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean dispatchKeyEvent = ((ListenerStub) topListener).dispatchKeyEvent(keyEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return dispatchKeyEvent;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean dispatchKeyEvent = dispatchKeyEvent(keyEvent);
        ThreadSession.sExtensionParamStack.get().pop();
        return dispatchKeyEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean requestFocus(int i, Rect rect) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.requestFocus(i, rect);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_requestFocus);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean requestFocus = ((ListenerStub) topListener).requestFocus(i, rect);
            ThreadSession.sExtensionExtendStack.get().pop();
            return requestFocus;
        }
        return super.requestFocus(i, rect);
    }

    public boolean requestFocus(int i, Rect rect, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean requestFocus = requestFocus(i, rect);
        ThreadSession.sExtensionParamStack.get().pop();
        return requestFocus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_requestFocus(int i, Rect rect) {
        return super.requestFocus(i, rect);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onMeasure(i, i2);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onMeasure);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onMeasure(i, i2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.dispatchDraw(canvas);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_dispatchDraw);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).dispatchDraw(canvas);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public void onStartTemporaryDetach() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onStartTemporaryDetach();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onStartTemporaryDetach);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onStartTemporaryDetach();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onStartTemporaryDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public void onFinishTemporaryDetach() {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.onFinishTemporaryDetach();
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onFinishTemporaryDetach);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onFinishTemporaryDetach();
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onFinishTemporaryDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onCheckIsTextEditor() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onCheckIsTextEditor();
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onCheckIsTextEditor);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onCheckIsTextEditor = ((ListenerStub) topListener).onCheckIsTextEditor();
            ThreadSession.sExtensionExtendStack.get().pop();
            return onCheckIsTextEditor;
        }
        return super.onCheckIsTextEditor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onCheckIsTextEditor() {
        return super.onCheckIsTextEditor();
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_overScrollBy);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean overScrollBy = ((ListenerStub) topListener).overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            ThreadSession.sExtensionExtendStack.get().pop();
            return overScrollBy;
        }
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public void draw(Canvas canvas) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.draw(canvas);
            return;
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_draw);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).draw(canvas);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.draw(canvas);
    }

    public void draw(Canvas canvas, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        draw(canvas);
        ThreadSession.sExtensionParamStack.get().pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_dispatchTouchEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean dispatchTouchEvent = ((ListenerStub) topListener).dispatchTouchEvent(motionEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return dispatchTouchEvent;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        boolean dispatchTouchEvent = dispatchTouchEvent(motionEvent);
        ThreadSession.sExtensionParamStack.get().pop();
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, com.bytedance.webx.core.webview.IWebViewContainer
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onInterceptTouchEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onInterceptTouchEvent = ((ListenerStub) topListener).onInterceptTouchEvent(motionEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onInterceptTouchEvent;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static abstract class ListenerStub extends AbsListenerStub<WebViewContainer> implements IWebViewContainer {
        @Override // com.bytedance.webx.IContainer
        public <T extends IExtension.IContainerExtension> T castContainer(Class<T> cls) {
            return (T) getExtendable().castContainer(cls);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public SslCertificate getCertificate() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_getCertificate);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getCertificate();
            }
            return ((ListenerStub) findNextListener).getCertificate();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void setCertificate(SslCertificate sslCertificate) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_setCertificate);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_setCertificate(sslCertificate);
            } else {
                ((ListenerStub) findNextListener).setCertificate(sslCertificate);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void savePassword(String str, String str2, String str3) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_savePassword);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_savePassword(str, str2, str3);
            } else {
                ((ListenerStub) findNextListener).savePassword(str, str2, str3);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_setHttpAuthUsernamePassword);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_setHttpAuthUsernamePassword(str, str2, str3, str4);
            } else {
                ((ListenerStub) findNextListener).setHttpAuthUsernamePassword(str, str2, str3, str4);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public String[] getHttpAuthUsernamePassword(String str, String str2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_getHttpAuthUsernamePassword);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getHttpAuthUsernamePassword(str, str2);
            }
            return ((ListenerStub) findNextListener).getHttpAuthUsernamePassword(str, str2);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void destroy() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_destroy);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_destroy();
            } else {
                ((ListenerStub) findNextListener).destroy();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public WebBackForwardList saveState(Bundle bundle) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_saveState);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_saveState(bundle);
            }
            return ((ListenerStub) findNextListener).saveState(bundle);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public WebBackForwardList restoreState(Bundle bundle) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_restoreState);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_restoreState(bundle);
            }
            return ((ListenerStub) findNextListener).restoreState(bundle);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void loadUrl(String str, Map<String, String> map) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_loadUrl);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_loadUrl(str, map);
            } else {
                ((ListenerStub) findNextListener).loadUrl(str, map);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void loadUrl(String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_loadUrl);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_loadUrl(str);
            } else {
                ((ListenerStub) findNextListener).loadUrl(str);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void postUrl(String str, byte[] bArr) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_postUrl);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_postUrl(str, bArr);
            } else {
                ((ListenerStub) findNextListener).postUrl(str, bArr);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void loadData(String str, String str2, String str3) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_loadData);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_loadData(str, str2, str3);
            } else {
                ((ListenerStub) findNextListener).loadData(str, str2, str3);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_loadDataWithBaseURL);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_loadDataWithBaseURL(str, str2, str3, str4, str5);
            } else {
                ((ListenerStub) findNextListener).loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_evaluateJavascript);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_evaluateJavascript(str, valueCallback);
            } else {
                ((ListenerStub) findNextListener).evaluateJavascript(str, valueCallback);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void saveWebArchive(String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_saveWebArchive);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_saveWebArchive(str);
            } else {
                ((ListenerStub) findNextListener).saveWebArchive(str);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_saveWebArchive);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_saveWebArchive(str, z, valueCallback);
            } else {
                ((ListenerStub) findNextListener).saveWebArchive(str, z, valueCallback);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void stopLoading() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_stopLoading);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_stopLoading();
            } else {
                ((ListenerStub) findNextListener).stopLoading();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void reload() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_reload);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_reload();
            } else {
                ((ListenerStub) findNextListener).reload();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public boolean canGoBack() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_canGoBack);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_canGoBack();
            }
            return ((ListenerStub) findNextListener).canGoBack();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void goBack() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_goBack);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_goBack();
            } else {
                ((ListenerStub) findNextListener).goBack();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public boolean canGoForward() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_canGoForward);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_canGoForward();
            }
            return ((ListenerStub) findNextListener).canGoForward();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void goForward() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_goForward);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_goForward();
            } else {
                ((ListenerStub) findNextListener).goForward();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public boolean canGoBackOrForward(int i) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_canGoBackOrForward);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_canGoBackOrForward(i);
            }
            return ((ListenerStub) findNextListener).canGoBackOrForward(i);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void goBackOrForward(int i) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_goBackOrForward);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_goBackOrForward(i);
            } else {
                ((ListenerStub) findNextListener).goBackOrForward(i);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public boolean pageUp(boolean z) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_pageUp);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_pageUp(z);
            }
            return ((ListenerStub) findNextListener).pageUp(z);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public boolean pageDown(boolean z) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_pageDown);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_pageDown(z);
            }
            return ((ListenerStub) findNextListener).pageDown(z);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void onPause() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onPause);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onPause();
            } else {
                ((ListenerStub) findNextListener).onPause();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void onResume() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onResume);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onResume();
            } else {
                ((ListenerStub) findNextListener).onResume();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void setFindListener(WebView.FindListener findListener) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_setFindListener);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_setFindListener(findListener);
            } else {
                ((ListenerStub) findNextListener).setFindListener(findListener);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void documentHasImages(Message message) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_documentHasImages);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_documentHasImages(message);
            } else {
                ((ListenerStub) findNextListener).documentHasImages(message);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void setWebViewClient(WebViewClient webViewClient) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_setWebViewClient);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_setWebViewClient(webViewClient);
            } else {
                ((ListenerStub) findNextListener).setWebViewClient(webViewClient);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public WebViewClient getWebViewClient() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_getWebViewClient);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getWebViewClient();
            }
            return ((ListenerStub) findNextListener).getWebViewClient();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public WebViewRenderProcess getWebViewRenderProcess() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_getWebViewRenderProcess);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getWebViewRenderProcess();
            }
            return ((ListenerStub) findNextListener).getWebViewRenderProcess();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_setWebViewRenderProcessClient);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
            } else {
                ((ListenerStub) findNextListener).setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void setWebViewRenderProcessClient(WebViewRenderProcessClient webViewRenderProcessClient) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_setWebViewRenderProcessClient);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_setWebViewRenderProcessClient(webViewRenderProcessClient);
            } else {
                ((ListenerStub) findNextListener).setWebViewRenderProcessClient(webViewRenderProcessClient);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public WebViewRenderProcessClient getWebViewRenderProcessClient() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_getWebViewRenderProcessClient);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getWebViewRenderProcessClient();
            }
            return ((ListenerStub) findNextListener).getWebViewRenderProcessClient();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void setDownloadListener(DownloadListener downloadListener) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_setDownloadListener);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_setDownloadListener(downloadListener);
            } else {
                ((ListenerStub) findNextListener).setDownloadListener(downloadListener);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void setWebChromeClient(WebChromeClient webChromeClient) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_setWebChromeClient);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_setWebChromeClient(webChromeClient);
            } else {
                ((ListenerStub) findNextListener).setWebChromeClient(webChromeClient);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public WebChromeClient getWebChromeClient() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_getWebChromeClient);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getWebChromeClient();
            }
            return ((ListenerStub) findNextListener).getWebChromeClient();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void addJavascriptInterface(Object obj, String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_addJavascriptInterface);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_addJavascriptInterface(obj, str);
            } else {
                ((ListenerStub) findNextListener).addJavascriptInterface(obj, str);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void removeJavascriptInterface(String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_removeJavascriptInterface);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_removeJavascriptInterface(str);
            } else {
                ((ListenerStub) findNextListener).removeJavascriptInterface(str);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public WebMessagePort[] createWebMessageChannel() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_createWebMessageChannel);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_createWebMessageChannel();
            }
            return ((ListenerStub) findNextListener).createWebMessageChannel();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void postWebMessage(WebMessage webMessage, Uri uri) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_postWebMessage);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_postWebMessage(webMessage, uri);
            } else {
                ((ListenerStub) findNextListener).postWebMessage(webMessage, uri);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public WebSettings getSettings() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_getSettings);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_getSettings();
            }
            return ((ListenerStub) findNextListener).getSettings();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void flingScroll(int i, int i2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_flingScroll);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_flingScroll(i, i2);
            } else {
                ((ListenerStub) findNextListener).flingScroll(i, i2);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void zoomBy(float f) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_zoomBy);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_zoomBy(f);
            } else {
                ((ListenerStub) findNextListener).zoomBy(f);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public boolean zoomIn() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_zoomIn);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_zoomIn();
            }
            return ((ListenerStub) findNextListener).zoomIn();
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public boolean zoomOut() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_zoomOut);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_zoomOut();
            }
            return ((ListenerStub) findNextListener).zoomOut();
        }

        protected void onAttachedToWindow() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onAttachedToWindow);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onAttachedToWindow();
            } else {
                ((ListenerStub) findNextListener).onAttachedToWindow();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onHoverEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onHoverEvent(motionEvent);
            }
            return ((ListenerStub) findNextListener).onHoverEvent(motionEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onTouchEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onTouchEvent(motionEvent);
            }
            return ((ListenerStub) findNextListener).onTouchEvent(motionEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onGenericMotionEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onGenericMotionEvent(motionEvent);
            }
            return ((ListenerStub) findNextListener).onGenericMotionEvent(motionEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public boolean onTrackballEvent(MotionEvent motionEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onTrackballEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onTrackballEvent(motionEvent);
            }
            return ((ListenerStub) findNextListener).onTrackballEvent(motionEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onKeyDown);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onKeyDown(i, keyEvent);
            }
            return ((ListenerStub) findNextListener).onKeyDown(i, keyEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyUp(int i, KeyEvent keyEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onKeyUp);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onKeyUp(i, keyEvent);
            }
            return ((ListenerStub) findNextListener).onKeyUp(i, keyEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onKeyMultiple);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onKeyMultiple(i, i2, keyEvent);
            }
            return ((ListenerStub) findNextListener).onKeyMultiple(i, i2, keyEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public void onProvideVirtualStructure(ViewStructure viewStructure) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onProvideVirtualStructure);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onProvideVirtualStructure(viewStructure);
            } else {
                ((ListenerStub) findNextListener).onProvideVirtualStructure(viewStructure);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onProvideAutofillVirtualStructure);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onProvideAutofillVirtualStructure(viewStructure, i);
            } else {
                ((ListenerStub) findNextListener).onProvideAutofillVirtualStructure(viewStructure, i);
            }
        }

        protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onOverScrolled);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onOverScrolled(i, i2, z, z2);
            } else {
                ((ListenerStub) findNextListener).onOverScrolled(i, i2, z, z2);
            }
        }

        protected void onWindowVisibilityChanged(int i) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onWindowVisibilityChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onWindowVisibilityChanged(i);
            } else {
                ((ListenerStub) findNextListener).onWindowVisibilityChanged(i);
            }
        }

        protected void onDraw(Canvas canvas) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onDraw);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onDraw(canvas);
            } else {
                ((ListenerStub) findNextListener).onDraw(canvas);
            }
        }

        protected void onConfigurationChanged(Configuration configuration) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onConfigurationChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onConfigurationChanged(configuration);
            } else {
                ((ListenerStub) findNextListener).onConfigurationChanged(configuration);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onCreateInputConnection);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onCreateInputConnection(editorInfo);
            }
            return ((ListenerStub) findNextListener).onCreateInputConnection(editorInfo);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public boolean onDragEvent(DragEvent dragEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onDragEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onDragEvent(dragEvent);
            }
            return ((ListenerStub) findNextListener).onDragEvent(dragEvent);
        }

        protected void onVisibilityChanged(View view, int i) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onVisibilityChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onVisibilityChanged(view, i);
            } else {
                ((ListenerStub) findNextListener).onVisibilityChanged(view, i);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public void onWindowFocusChanged(boolean z) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onWindowFocusChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onWindowFocusChanged(z);
            } else {
                ((ListenerStub) findNextListener).onWindowFocusChanged(z);
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onFocusChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onFocusChanged(z, i, rect);
            } else {
                ((ListenerStub) findNextListener).onFocusChanged(z, i, rect);
            }
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onSizeChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onSizeChanged(i, i2, i3, i4);
            } else {
                ((ListenerStub) findNextListener).onSizeChanged(i, i2, i3, i4);
            }
        }

        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onScrollChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onScrollChanged(i, i2, i3, i4);
            } else {
                ((ListenerStub) findNextListener).onScrollChanged(i, i2, i3, i4);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_dispatchKeyEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_dispatchKeyEvent(keyEvent);
            }
            return ((ListenerStub) findNextListener).dispatchKeyEvent(keyEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.ViewGroup, android.view.View
        public boolean requestFocus(int i, Rect rect) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_requestFocus);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_requestFocus(i, rect);
            }
            return ((ListenerStub) findNextListener).requestFocus(i, rect);
        }

        protected void onMeasure(int i, int i2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onMeasure);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onMeasure(i, i2);
            } else {
                ((ListenerStub) findNextListener).onMeasure(i, i2);
            }
        }

        protected void dispatchDraw(Canvas canvas) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_dispatchDraw);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_dispatchDraw(canvas);
            } else {
                ((ListenerStub) findNextListener).dispatchDraw(canvas);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public void onStartTemporaryDetach() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onStartTemporaryDetach);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onStartTemporaryDetach();
            } else {
                ((ListenerStub) findNextListener).onStartTemporaryDetach();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public void onFinishTemporaryDetach() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onFinishTemporaryDetach);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onFinishTemporaryDetach();
            } else {
                ((ListenerStub) findNextListener).onFinishTemporaryDetach();
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public boolean onCheckIsTextEditor() {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onCheckIsTextEditor);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onCheckIsTextEditor();
            }
            return ((ListenerStub) findNextListener).onCheckIsTextEditor();
        }

        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_overScrollBy);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return ((ListenerStub) findNextListener).overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public void draw(Canvas canvas) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_draw);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_draw(canvas);
            } else {
                ((ListenerStub) findNextListener).draw(canvas);
            }
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_dispatchTouchEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_dispatchTouchEvent(motionEvent);
            }
            return ((ListenerStub) findNextListener).dispatchTouchEvent(motionEvent);
        }

        @Override // com.bytedance.webx.core.webview.IWebViewContainer
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainer.EVENT_onInterceptTouchEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onInterceptTouchEvent(motionEvent);
            }
            return ((ListenerStub) findNextListener).onInterceptTouchEvent(motionEvent);
        }
    }
}
