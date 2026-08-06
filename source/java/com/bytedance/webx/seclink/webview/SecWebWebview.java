package com.bytedance.webx.seclink.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.webx.seclink.base.ISecLinkStrategy;

/* loaded from: classes6.dex */
public class SecWebWebview extends WebView {
    private ISecLinkStrategy secLinkStategy;
    private boolean syncHandleOverrideUrlLoading;

    public SecWebWebview(Context context) {
        super(context);
        init();
    }

    public SecWebWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SecWebWebview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SecWebWebview(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    public SecWebWebview(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void setSecLinkStategy(ISecLinkStrategy iSecLinkStrategy) {
        this.secLinkStategy = iSecLinkStrategy;
    }

    private void init() {
        setWebViewClient(new WebViewClient() { // from class: com.bytedance.webx.seclink.webview.SecWebWebview.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (SecWebWebview.this.secLinkStategy == null) {
                    return false;
                }
                if (SecWebWebview.this.syncHandleOverrideUrlLoading) {
                    SecWebWebview.this.secLinkStategy.syncHandleOverrideUrlLoading(str);
                    return false;
                }
                SecWebWebview.this.secLinkStategy.handleOverrideUrlLoading(str);
                return false;
            }
        });
    }

    public void syncHandleOverrideUrlLoading(boolean z) {
        this.syncHandleOverrideUrlLoading = z;
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        return super.canGoBack() && this.secLinkStategy.canGoBack();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (this.secLinkStategy.handleGoBack()) {
            return;
        }
        super.goBack();
    }
}
