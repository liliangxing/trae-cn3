package com.bytedance.webx.core.webview.extension;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.IExtension;
import com.bytedance.webx.addr.AddressProcessor;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.core.webview.client.WebChromeContainerClient;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PageCtrlExtension extends AbsExtension<WebViewContainer> implements IExtension.IContainerExtension {
    private AddressProcessor mAddressProcessor;
    private boolean mLoadUrlProcess1 = false;
    private boolean mLoadUrlProcess2 = false;
    private boolean mShouldOverrideUrlLoadingProcess1 = false;
    private boolean mShouldOverrideUrlLoadingProcess2 = false;
    private WebViewContainer.ListenerStub mWebViewContainerListenerStub = new WebViewContainer.ListenerStub() { // from class: com.bytedance.webx.core.webview.extension.PageCtrlExtension.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.webx.event.AbsListenerStub
        public AbsExtension getExtension() {
            return PageCtrlExtension.this;
        }

        @Override // com.bytedance.webx.core.webview.WebViewContainer.ListenerStub, com.bytedance.webx.core.webview.IWebViewContainer
        public void loadUrl(String str) {
            boolean z = (PageCtrlExtension.this.mLoadUrlProcess1 || PageCtrlExtension.this.mLoadUrlProcess2) ? false : true;
            PageCtrlExtension.this.mLoadUrlProcess1 = true;
            if (z) {
                try {
                    PageCtrlExtension.this.onLoadUrl(str);
                } finally {
                    PageCtrlExtension.this.mLoadUrlProcess1 = false;
                }
            }
            super.loadUrl(str);
            if (z) {
                PageCtrlExtension.this.tryInjectJsScript();
            }
        }

        @Override // com.bytedance.webx.core.webview.WebViewContainer.ListenerStub, com.bytedance.webx.core.webview.IWebViewContainer
        public void loadUrl(String str, Map<String, String> map) {
            boolean z = (PageCtrlExtension.this.mLoadUrlProcess1 || PageCtrlExtension.this.mLoadUrlProcess2) ? false : true;
            PageCtrlExtension.this.mLoadUrlProcess2 = true;
            if (z) {
                try {
                    PageCtrlExtension.this.onLoadUrl(str);
                } finally {
                    PageCtrlExtension.this.mLoadUrlProcess2 = false;
                }
            }
            super.loadUrl(str, map);
            if (z) {
                PageCtrlExtension.this.tryInjectJsScript();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tryInjectJsScript() {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class WebViewContainerClientExtension extends AbsExtension {
        private WebViewContainerClient.ListenerStub mWebViewContainerClientListenerStub = new WebViewContainerClient.ListenerStub() { // from class: com.bytedance.webx.core.webview.extension.PageCtrlExtension.WebViewContainerClientExtension.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.webx.event.AbsListenerStub
            public AbsExtension getExtension() {
                return WebViewContainerClientExtension.this;
            }

            @Override // com.bytedance.webx.core.webview.client.WebViewContainerClient.ListenerStub, com.bytedance.webx.core.webview.client.IWebViewContainerClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                boolean z = (PageCtrlExtension.this.mShouldOverrideUrlLoadingProcess1 || PageCtrlExtension.this.mShouldOverrideUrlLoadingProcess2) ? false : true;
                PageCtrlExtension.this.mShouldOverrideUrlLoadingProcess1 = true;
                try {
                    boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
                    if (z) {
                        if (!shouldOverrideUrlLoading) {
                            PageCtrlExtension.this.onChangeUrl(str);
                        }
                        PageCtrlExtension.this.tryInjectJsScript();
                    }
                    return shouldOverrideUrlLoading;
                } finally {
                    PageCtrlExtension.this.mShouldOverrideUrlLoadingProcess1 = false;
                }
            }

            @Override // com.bytedance.webx.core.webview.client.WebViewContainerClient.ListenerStub, com.bytedance.webx.core.webview.client.IWebViewContainerClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                boolean z = (PageCtrlExtension.this.mShouldOverrideUrlLoadingProcess1 || PageCtrlExtension.this.mShouldOverrideUrlLoadingProcess2) ? false : true;
                PageCtrlExtension.this.mShouldOverrideUrlLoadingProcess2 = true;
                try {
                    boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
                    if (z) {
                        if (!shouldOverrideUrlLoading) {
                            PageCtrlExtension.this.onChangeUrl(webResourceRequest.getUrl().toString());
                        }
                        PageCtrlExtension.this.tryInjectJsScript();
                    }
                    return shouldOverrideUrlLoading;
                } finally {
                    PageCtrlExtension.this.mShouldOverrideUrlLoadingProcess2 = false;
                }
            }

            @Override // com.bytedance.webx.core.webview.client.WebViewContainerClient.ListenerStub, com.bytedance.webx.core.webview.client.IWebViewContainerClient
            public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
                PageCtrlExtension.this.onChangeUrl(str);
                PageCtrlExtension.this.tryInjectJsScript();
                super.doUpdateVisitedHistory(webView, str, z);
            }
        };

        public WebViewContainerClientExtension() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.webx.AbsExtension
        public void onCreateExtendable(AbsExtension.CreateHelper createHelper) {
            register(WebViewContainerClient.EVENT_shouldOverrideUrlLoading, this.mWebViewContainerClientListenerStub, 500);
            register(WebViewContainerClient.EVENT_doUpdateVisitedHistory, this.mWebViewContainerClientListenerStub, 500);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class WebChromeContainerClientExtension extends AbsExtension {
        private WebChromeContainerClient.ListenerStub mWebChromeContainerClientListenerStub = new WebChromeContainerClient.ListenerStub() { // from class: com.bytedance.webx.core.webview.extension.PageCtrlExtension.WebChromeContainerClientExtension.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.webx.event.AbsListenerStub
            public AbsExtension getExtension() {
                return WebChromeContainerClientExtension.this;
            }

            @Override // com.bytedance.webx.core.webview.client.WebChromeContainerClient.ListenerStub, com.bytedance.webx.core.webview.client.IWebChromeContainerClient
            public void onProgressChanged(WebView webView, int i) {
                PageCtrlExtension.this.tryInjectJsScript();
                super.onProgressChanged(webView, i);
            }
        };

        public WebChromeContainerClientExtension() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.webx.AbsExtension
        public void onCreateExtendable(AbsExtension.CreateHelper createHelper) {
            register(WebChromeContainerClient.EVENT_onProgressChanged, this.mWebChromeContainerClientListenerStub, 500);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.webx.AbsExtension
    public void onCreateExtendable(AbsExtension.CreateHelper createHelper) {
        createHelper.bindExtension(getExtendable().getExtendableWebViewClient(), new WebViewContainerClientExtension());
        createHelper.bindExtension(getExtendable().getExtendableWebChromeClient(), new WebChromeContainerClientExtension());
        register(WebViewContainer.EVENT_loadUrl, this.mWebViewContainerListenerStub, 500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadUrl(String str) {
        AddressProcessor addressProcessor = this.mAddressProcessor;
        if (addressProcessor == null) {
            AddressProcessor addressProcessor2 = new AddressProcessor(getContext());
            this.mAddressProcessor = addressProcessor2;
            addressProcessor2.onCreateContainer(str);
            return;
        }
        addressProcessor.onChangePage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeUrl(String str) {
        AddressProcessor addressProcessor = this.mAddressProcessor;
        if (addressProcessor != null) {
            addressProcessor.onChangePage(str);
        }
    }
}
