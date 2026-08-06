package com.bytedance.bdturing.ttnet;

import android.text.TextUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BdTuringInterceptor implements Interceptor {
    private static final String VERSION_KEY = "x-vc-bdturing-sdk-version";
    private static volatile BdTuringInterceptor sInstance;
    private Map<String, String> mHeaderMap;

    public static BdTuringInterceptor getInstance() {
        if (sInstance == null) {
            synchronized (BdTuringInterceptor.class) {
                if (sInstance == null) {
                    sInstance = new BdTuringInterceptor();
                }
            }
        }
        return sInstance;
    }

    private BdTuringInterceptor() {
    }

    public SsResponse intercept(Interceptor.Chain chain) throws Exception {
        Request request = chain.request();
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(request.getHeaders());
        Map<String, String> headerMap = getHeaderMap();
        if (headerMap != null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                linkedList.add(new Header(entry.getKey(), entry.getValue()));
            }
        }
        return chain.proceed(request.newBuilder().headers(linkedList).build());
    }

    private Map<String, String> getHeaderMap() {
        if (this.mHeaderMap == null) {
            this.mHeaderMap = new HashMap();
        }
        if (TextUtils.isEmpty(this.mHeaderMap.get(VERSION_KEY))) {
            this.mHeaderMap.put(VERSION_KEY, "4.1.1.cn");
        }
        return this.mHeaderMap;
    }
}
