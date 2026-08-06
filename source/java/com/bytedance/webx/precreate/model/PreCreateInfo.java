package com.bytedance.webx.precreate.model;

import android.webkit.WebView;
import com.bytedance.webx.precreate.api.IWebViewFactory;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class PreCreateInfo {
    public boolean preCreateWebViewWhenRegister;
    public int size;
    public String type;
    public IWebViewFactory webViewFactory;
    public final List<SoftReference<WebView>> webViews;

    private PreCreateInfo(Builder builder) {
        this.webViews = new ArrayList();
        this.webViewFactory = builder.webViewFactory;
        this.size = builder.size;
        this.preCreateWebViewWhenRegister = builder.preCreateWebViewWhenRegister;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        boolean preCreateWebViewWhenRegister;
        int size;
        IWebViewFactory webViewFactory;

        public Builder setWebViewFactory(IWebViewFactory iWebViewFactory) {
            this.webViewFactory = iWebViewFactory;
            return this;
        }

        public Builder setSize(int i) {
            this.size = i;
            return this;
        }

        public Builder preCreateWebViewWhenRegister(boolean z) {
            this.preCreateWebViewWhenRegister = z;
            return this;
        }

        public PreCreateInfo build() {
            return new PreCreateInfo(this);
        }
    }
}
