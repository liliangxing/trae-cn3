package net.openid.appauth.browser;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class BrowserWhitelist implements BrowserMatcher {
    private List<BrowserMatcher> mBrowserMatchers;

    public BrowserWhitelist(BrowserMatcher... browserMatcherArr) {
        this.mBrowserMatchers = Arrays.asList(browserMatcherArr);
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        Iterator<BrowserMatcher> it = this.mBrowserMatchers.iterator();
        while (it.hasNext()) {
            if (it.next().matches(browserDescriptor)) {
                return true;
            }
        }
        return false;
    }
}
