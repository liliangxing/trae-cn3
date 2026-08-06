package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import coil3.disk.DiskLruCache;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3CookieInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        URI createUriWithOutQuery;
        Set<String> names;
        boolean z;
        Map<String, List<String>> map;
        Set<String> names2;
        Request request = chain.request();
        if (request != null && request.headers() != null && "0".equals(request.header("x-ttnet-bypass-cookie"))) {
            Request.Builder newBuilder = request.newBuilder();
            newBuilder.removeHeader("x-ttnet-bypass-cookie");
            return chain.proceed(newBuilder.build());
        }
        try {
            createUriWithOutQuery = request.url().uri();
        } catch (Exception unused) {
            createUriWithOutQuery = URIUtils.createUriWithOutQuery(request.url().toString());
        }
        Request.Builder newBuilder2 = request.newBuilder();
        CookieHandler cookieHandler = CookieHandler.getDefault();
        Headers headers = request.headers();
        Map<String, List<String>> map2 = null;
        String replaceUrlWithoutBoeHttpSuffix = createUriWithOutQuery != null ? BoeUtils.replaceUrlWithoutBoeHttpSuffix(createUriWithOutQuery.toString()) : null;
        try {
            HashMap hashMap = new HashMap();
            if (headers != null && (names2 = headers.names()) != null && !names2.isEmpty()) {
                for (String str : names2) {
                    hashMap.put(str, headers.values(str));
                }
            }
            if (request == null || request.headers() == null) {
                z = false;
            } else {
                z = DiskLruCache.VERSION.equals(request.header("x-metasec-bypass-okhttp-cookie"));
                if (DiskLruCache.VERSION.equals(request.header("x-metasec-ok-bypass-downgrade-cookie"))) {
                    z = true;
                }
            }
            if (cookieHandler != null && !z) {
                try {
                    if (replaceUrlWithoutBoeHttpSuffix != null) {
                        map = cookieHandler.get(new URI(replaceUrlWithoutBoeHttpSuffix), hashMap);
                    } else {
                        map = cookieHandler.get(createUriWithOutQuery, hashMap);
                    }
                    map2 = map;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (map2 != null && map2.size() > 0) {
                for (Map.Entry<String, List<String>> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    StringBuilder sb = new StringBuilder();
                    if (SSCookieHandler.SS_COOKIE.equalsIgnoreCase(key) || SSCookieHandler.COOKIE.equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                        if (!entry.getValue().isEmpty()) {
                            int i = 0;
                            for (String str2 : entry.getValue()) {
                                if (i > 0) {
                                    sb.append("; ");
                                }
                                sb.append(str2);
                                i++;
                            }
                            newBuilder2.addHeader(key, sb.toString());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            request = newBuilder2.build();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Response proceed = chain.proceed(request);
        HashMap hashMap2 = new HashMap();
        Headers headers2 = proceed.headers();
        if (headers2 != null && (names = headers2.names()) != null && !names.isEmpty()) {
            for (String str3 : names) {
                hashMap2.put(str3, headers2.values(str3));
            }
        }
        if (cookieHandler != null) {
            try {
                if (replaceUrlWithoutBoeHttpSuffix != null) {
                    cookieHandler.put(new URI(replaceUrlWithoutBoeHttpSuffix), hashMap2);
                } else {
                    cookieHandler.put(createUriWithOutQuery, hashMap2);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        return proceed;
    }
}
