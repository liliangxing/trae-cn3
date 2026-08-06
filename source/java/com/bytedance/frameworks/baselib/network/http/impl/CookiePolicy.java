package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;

/* loaded from: classes2.dex */
public interface CookiePolicy {
    public static final CookiePolicy ACCEPT_ALL = new CookiePolicy() { // from class: com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy.1
        @Override // com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie httpCookie) {
            return true;
        }
    };
    public static final CookiePolicy ACCEPT_NONE = new CookiePolicy() { // from class: com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy.2
        @Override // com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie httpCookie) {
            return false;
        }
    };
    public static final CookiePolicy ACCEPT_ORIGINAL_SERVER = new CookiePolicy() { // from class: com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy.3
        @Override // com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie httpCookie) {
            return HttpCookie.domainMatches(httpCookie.getDomain(), uri.getHost());
        }
    };

    boolean shouldAccept(URI uri, HttpCookie httpCookie);
}
