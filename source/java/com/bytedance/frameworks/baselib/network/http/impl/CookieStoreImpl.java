package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes2.dex */
public class CookieStoreImpl implements CookieStore {
    private final Map<URI, List<HttpCookie>> map = new HashMap();

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized void add(URI uri, HttpCookie httpCookie) {
        if (httpCookie == null) {
            throw new NullPointerException("cookie == null");
        }
        URI cookiesUri = cookiesUri(uri);
        List<HttpCookie> list = this.map.get(cookiesUri);
        if (list == null) {
            list = new ArrayList<>();
            this.map.put(cookiesUri, list);
        } else {
            list.remove(httpCookie);
        }
        list.add(httpCookie);
    }

    private URI cookiesUri(URI uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URI("http", uri.getHost(), null, null);
        } catch (URISyntaxException unused) {
            return uri;
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> get(URI uri) {
        ArrayList arrayList;
        if (uri == null) {
            throw new NullPointerException("uri == null");
        }
        arrayList = new ArrayList();
        List<HttpCookie> list = this.map.get(uri);
        if (list != null) {
            Iterator<HttpCookie> it = list.iterator();
            while (it.hasNext()) {
                HttpCookie next = it.next();
                if (next.hasExpired()) {
                    it.remove();
                } else {
                    arrayList.add(next);
                }
            }
        }
        for (Map.Entry<URI, List<HttpCookie>> entry : this.map.entrySet()) {
            if (!uri.equals(entry.getKey())) {
                Iterator<HttpCookie> it2 = entry.getValue().iterator();
                while (it2.hasNext()) {
                    HttpCookie next2 = it2.next();
                    if (HttpCookie.domainMatches(next2.getDomain(), uri.getHost())) {
                        if (next2.hasExpired()) {
                            it2.remove();
                        } else if (!arrayList.contains(next2)) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> getCookies() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<List<HttpCookie>> it = this.map.values().iterator();
        while (it.hasNext()) {
            Iterator<HttpCookie> it2 = it.next().iterator();
            while (it2.hasNext()) {
                HttpCookie next = it2.next();
                if (next.hasExpired()) {
                    it2.remove();
                } else if (!arrayList.contains(next)) {
                    arrayList.add(next);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<URI> getURIs() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.map.keySet());
        arrayList.remove((Object) null);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean remove(URI uri, HttpCookie httpCookie) {
        if (httpCookie == null) {
            throw new NullPointerException("cookie == null");
        }
        List<HttpCookie> list = this.map.get(cookiesUri(uri));
        if (list == null) {
            return false;
        }
        return list.remove(httpCookie);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean removeAll() {
        boolean z;
        z = !this.map.isEmpty();
        this.map.clear();
        return z;
    }
}
