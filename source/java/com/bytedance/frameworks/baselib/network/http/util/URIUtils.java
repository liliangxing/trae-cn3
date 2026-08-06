package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class URIUtils {
    public static URI createURI(String str, String str2, int i, String str3, String str4, String str5) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return new URI(sb.toString());
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost, boolean z) throws URISyntaxException {
        if (uri == null) {
            throw new IllegalArgumentException("URI may nor be null");
        }
        if (httpHost != null) {
            return createURI(httpHost.getSchemeName(), httpHost.getHostName(), httpHost.getPort(), uri.getRawPath(), uri.getRawQuery(), z ? null : uri.getRawFragment());
        }
        return createURI(null, null, -1, uri.getRawPath(), uri.getRawQuery(), z ? null : uri.getRawFragment());
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost) throws URISyntaxException {
        return rewriteURI(uri, httpHost, false);
    }

    public static URI resolve(URI uri, String str) {
        return resolve(uri, URI.create(str));
    }

    public static URI resolve(URI uri, URI uri2) {
        if (uri == null) {
            throw new IllegalArgumentException("Base URI may nor be null");
        }
        if (uri2 == null) {
            throw new IllegalArgumentException("Reference URI may nor be null");
        }
        boolean z = uri2.toString().length() == 0;
        if (z) {
            uri2 = URI.create("#");
        }
        URI resolve = uri.resolve(uri2);
        if (!z) {
            return resolve;
        }
        String uri3 = resolve.toString();
        return URI.create(uri3.substring(0, uri3.indexOf(35)));
    }

    private URIUtils() {
    }

    public static URI safeCreateUri(String str) throws RuntimeException {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            try {
                return new URI(str);
            } catch (Exception unused) {
                return createUriWithOutQuery(str);
            }
        } catch (URISyntaxException unused2) {
            return URI.create(str.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        }
    }

    public static URI createUriWithOutQuery(String str) throws RuntimeException {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
            }
            return URI.create(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
