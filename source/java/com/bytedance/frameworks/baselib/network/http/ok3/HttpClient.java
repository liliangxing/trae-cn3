package com.bytedance.frameworks.baselib.network.http.ok3;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HttpClient {
    static final BaseImpl IMPL = new BaseImpl();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class BaseImpl {
        private BaseImpl() {
        }

        public IHttpClient getHttpClient(Context context) {
            return SsOkHttp3Client.inst(context);
        }
    }

    public static IHttpClient getHttpClient(Context context, String str) {
        return IMPL.getHttpClient(context);
    }
}
