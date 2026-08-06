package com.bytedance.webx.core.webview.inner;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewStructure;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.bytedance.webx.IExtension;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.base.logger.WLog;
import com.bytedance.webx.context.ExtendableContext;
import com.bytedance.webx.context.IContextItem;
import com.bytedance.webx.core.ExtendableControlDelegate;
import com.bytedance.webx.core.IExtendableControl;
import com.bytedance.webx.core.webview.IWebViewContainer;
import com.bytedance.webx.core.webview.WebViewExtendableSwitch;
import com.bytedance.webx.core.webview.client.WebChromeContainerClient;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebViewContainerInner extends WebView implements IExtendableControl, IWebViewContainer, IContextItem {
    private ExtendableControlDelegate mContainerControlDelegate;
    private WebXEnv mEnv;
    private WebChromeContainerClient mWebChromeClient;
    private WebViewContainerClient mWebViewClient;

    @Override // com.bytedance.webx.core.IExtendableControl
    public void init(WebXEnv webXEnv) {
        if (WebXEnv.isEnableTrace()) {
            WLog.m44e("WebX", hashCode() + " newInstance: " + getClass().getCanonicalName(), new Throwable());
        }
        if (WebViewExtendableSwitch.isEnable()) {
            this.mEnv = webXEnv;
            this.mContainerControlDelegate.setExtendableContext(new ExtendableContext(this.mEnv, this));
        }
    }

    @Override // com.bytedance.webx.core.IExtendableControl
    public ExtendableContext getExtendableContext() {
        ExtendableControlDelegate extendableControlDelegate = this.mContainerControlDelegate;
        if (extendableControlDelegate == null) {
            return null;
        }
        return extendableControlDelegate.getExtendableContext();
    }

    public WebViewContainerInner(Context context) {
        super(context);
        this.mContainerControlDelegate = new ExtendableControlDelegate();
    }

    public WebViewContainerInner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContainerControlDelegate = new ExtendableControlDelegate();
    }

    public WebViewContainerInner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContainerControlDelegate = new ExtendableControlDelegate();
    }

    public WebViewContainerClient getExtendableWebViewClient() {
        return this.mWebViewClient;
    }

    public WebChromeContainerClient getExtendableWebChromeClient() {
        return this.mWebChromeClient;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExtendableWebViewClient(WebViewContainerClient webViewContainerClient) {
        this.mWebViewClient = webViewContainerClient;
        super.setWebViewClient(webViewContainerClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExtendableWebViewClient(WebChromeContainerClient webChromeContainerClient) {
        this.mWebChromeClient = webChromeContainerClient;
        super.setWebChromeClient(webChromeContainerClient);
    }

    public WebViewClient getWebViewClientCompat() {
        return this.mWebViewClient.getWebViewClientDelegate();
    }

    public WebChromeClient getWebChromeClientCompat() {
        return this.mWebChromeClient.getWebChromeClientDelegate();
    }

    @Override // com.bytedance.webx.IContainer
    public <T extends IExtension.IContainerExtension> T castContainer(Class<T> cls) {
        return (T) this.mContainerControlDelegate.castExtendable(cls);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setWebViewClient(WebViewClient webViewClient) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setWebViewClient(webViewClient);
        } else if (this.mEnv == null) {
            super.setWebViewClient(webViewClient);
        } else {
            this.mWebViewClient.setWebViewClientDelegate(webViewClient);
        }
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebViewClient getWebViewClient() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getWebViewClient();
        }
        if (this.mEnv == null) {
            return super.getWebViewClient();
        }
        return this.mWebViewClient;
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (!WebViewExtendableSwitch.isEnable()) {
            super.setWebChromeClient(webChromeClient);
        } else if (this.mEnv == null) {
            super.setWebChromeClient(webChromeClient);
        } else {
            this.mWebChromeClient.setWebChromeClientDelegate(webChromeClient);
        }
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebChromeClient getWebChromeClient() {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.getWebChromeClient();
        }
        if (this.mEnv == null) {
            return super.getWebChromeClient();
        }
        return this.mWebChromeClient;
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebViewRenderProcess getWebViewRenderProcess() {
        return super.getWebViewRenderProcess();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        super.setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void setWebViewRenderProcessClient(WebViewRenderProcessClient webViewRenderProcessClient) {
        super.setWebViewRenderProcessClient(webViewRenderProcessClient);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return super.getWebViewRenderProcessClient();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public WebMessagePort[] createWebMessageChannel() {
        return super.createWebMessageChannel();
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void postWebMessage(WebMessage webMessage, Uri uri) {
        super.postWebMessage(webMessage, uri);
    }

    @Override // android.webkit.WebView, com.bytedance.webx.core.webview.IWebViewContainer
    public void zoomBy(float f) {
        super.zoomBy(f);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public void onProvideVirtualStructure(ViewStructure viewStructure) {
        super.onProvideVirtualStructure(viewStructure);
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.webx.core.webview.IWebViewContainer
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
    }
}
