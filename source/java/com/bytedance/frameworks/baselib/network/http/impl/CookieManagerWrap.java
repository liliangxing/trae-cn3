package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import java.io.IOException;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class CookieManagerWrap extends CookieManager {
    private static final String VERSION_ONE_HEADER = "Set-cookie2";
    private static final String VERSION_ZERO_HEADER = "Set-cookie";
    private CookiePolicy policy;
    private final CookieStore store;

    public CookieManagerWrap() {
        this(null, null);
    }

    public CookieManagerWrap(Context context, CookiePolicy cookiePolicy) {
        this.store = new PersistentCookieStore(context);
        this.policy = cookiePolicy == null ? CookiePolicy.ACCEPT_ORIGINAL_SERVER : cookiePolicy;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        if (uri == null || map == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        for (HttpCookie httpCookie : this.store.get(uri)) {
            if (HttpCookie.pathMatches(httpCookie, uri) && HttpCookie.secureMatches(httpCookie, uri) && HttpCookie.portMatches(httpCookie, uri)) {
                arrayList.add(httpCookie);
            }
        }
        return cookiesToHeaders(arrayList);
    }

    private static Map<String, List<String>> cookiesToHeaders(List<HttpCookie> list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<HttpCookie> it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            i = Math.min(i, it.next().getVersion());
        }
        if (i == 1) {
            sb.append("$Version=\"1\"; ");
        }
        sb.append(list.get(0).toString());
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append("; ").append(list.get(i2).toString());
        }
        return Collections.singletonMap(SSCookieHandler.COOKIE, Collections.singletonList(sb.toString()));
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        if (uri == null || map == null) {
            throw new IllegalArgumentException();
        }
        putInternal(uri, parseCookie(map));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void put(URI uri, List<String> list) throws IOException {
        if (uri == null || list == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!StringUtils.isEmpty(str)) {
                try {
                    arrayList.addAll(HttpCookie.parse(str));
                } catch (IllegalArgumentException unused) {
                }
            }
            while (r5.hasNext()) {
            }
        }
        putInternal(uri, arrayList);
    }

    private void putInternal(URI uri, List<HttpCookie> list) {
        if (Lists.isEmpty(list)) {
            return;
        }
        for (HttpCookie httpCookie : list) {
            if (TextUtils.isEmpty(httpCookie.getDomain())) {
                httpCookie.setDomain(uri.getHost());
            }
            if (TextUtils.isEmpty(httpCookie.getPath())) {
                httpCookie.setPath(pathToCookiePath(uri.getPath()));
            }
            if ("".equals(httpCookie.getPortlist())) {
                httpCookie.setPortlist(Integer.toString(SerializableHttpCookie.getEffectivePort(uri.getScheme(), uri.getPort())));
            } else if (httpCookie.getPortlist() != null && !HttpCookie.portMatches(httpCookie, uri)) {
            }
            if (this.policy.shouldAccept(uri, httpCookie)) {
                this.store.add(uri, httpCookie);
            }
        }
    }

    public void setCookie(URI uri, String str) throws IOException {
        List<HttpCookie> list;
        if (uri == null || StringUtils.isEmpty(str)) {
            return;
        }
        try {
            list = HttpCookie.parse(str);
        } catch (IllegalArgumentException unused) {
            list = null;
        }
        putInternal(uri, list);
    }

    public static String pathToCookiePath(String str) {
        return TextUtils.isEmpty(str) ? "/" : str.substring(0, str.lastIndexOf(47) + 1);
    }

    private static List<HttpCookie> parseCookie(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null && (key.equalsIgnoreCase(VERSION_ZERO_HEADER) || key.equalsIgnoreCase(VERSION_ONE_HEADER))) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    try {
                        Iterator<HttpCookie> it2 = HttpCookie.parse(it.next()).iterator();
                        while (it2.hasNext()) {
                            arrayList.add(it2.next());
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                }
            }
        }
        return arrayList;
    }

    public void setCookiePolicy(CookiePolicy cookiePolicy) {
        if (cookiePolicy != null) {
            this.policy = cookiePolicy;
        }
    }
}
