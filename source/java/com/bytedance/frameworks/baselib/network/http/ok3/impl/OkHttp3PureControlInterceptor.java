package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import coil3.disk.DiskLruCache;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3PureControlInterceptor implements Interceptor {
    public static final String KEY_METASEC_PREFIX = "x-metasec";
    public static final String TAG = "OkHttp3PureControlInterceptor";
    private static volatile ICheckPureRequestForUT sHook;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ICheckPureRequestForUT {
        void checkRequest(String str, String str2, Map<String, List<String>> map, String str3);
    }

    public static void setCheckRequestHook(ICheckPureRequestForUT iCheckPureRequestForUT) {
        sHook = iCheckPureRequestForUT;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        boolean equals = (request == null || request.headers() == null || request.headers().get("x-metasec-bypass-ttnet-features") == null) ? false : DiskLruCache.VERSION.equals(request.headers().get("x-metasec-bypass-ttnet-features"));
        ArrayList arrayList = new ArrayList();
        Iterator it = request.headers().toMultimap().entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            if ((str.equals("x-tt-bypass-dp") && equals) || str.startsWith(KEY_METASEC_PREFIX)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            Request.Builder newBuilder = request.newBuilder();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                newBuilder.removeHeader((String) it2.next());
            }
            request = newBuilder.build();
        }
        if (sHook != null) {
            sHook.checkRequest(request.method(), request.url().toString(), request.headers().toMultimap(), "");
        }
        return chain.proceed(request);
    }
}
