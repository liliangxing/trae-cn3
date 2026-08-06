package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;
import java.util.List;

/* loaded from: classes2.dex */
public interface CookieStore {
    void add(URI uri, HttpCookie httpCookie);

    List<HttpCookie> get(URI uri);

    List<HttpCookie> getCookies();

    List<URI> getURIs();

    boolean remove(URI uri, HttpCookie httpCookie);

    boolean removeAll();
}
