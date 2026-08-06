package net.openid.appauth.browser;

/* loaded from: classes8.dex */
public class ExactBrowserMatcher implements BrowserMatcher {
    private BrowserDescriptor mBrowser;

    public ExactBrowserMatcher(BrowserDescriptor browserDescriptor) {
        this.mBrowser = browserDescriptor;
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        return this.mBrowser.equals(browserDescriptor);
    }
}
