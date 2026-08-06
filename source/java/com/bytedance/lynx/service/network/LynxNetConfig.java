package com.bytedance.lynx.service.network;

import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpResponse;
import com.lynx.tasm.base.LLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxNetConfig {
    private static final String TAG = "LynxNetConfig";
    private static LynxIRetrofitFactory mIRetrofitFactory;
    private static LynxHttpInterceptor mInterceptor = new DefaultLynxHttpInterceptor();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class DefaultLynxHttpInterceptor implements LynxHttpInterceptor {
        @Override // com.bytedance.lynx.service.network.LynxHttpInterceptor
        public HttpResponse interceptRequest(HttpRequest httpRequest) {
            return null;
        }

        @Override // com.bytedance.lynx.service.network.LynxHttpInterceptor
        public void onRequest(HttpRequest httpRequest) {
        }

        @Override // com.bytedance.lynx.service.network.LynxHttpInterceptor
        public void onResponse(HttpRequest httpRequest, HttpResponse httpResponse) {
        }

        private DefaultLynxHttpInterceptor() {
        }
    }

    public static void InitLynxNet(LynxIRetrofitFactory lynxIRetrofitFactory) {
        mIRetrofitFactory = lynxIRetrofitFactory;
    }

    public static boolean setLynxHttpInterceptor(LynxHttpInterceptor lynxHttpInterceptor) {
        if (lynxHttpInterceptor == null) {
            LLog.e(TAG, "setLynxHttpInterceptor with a null interceptor, ignored");
            return false;
        }
        if (!(mInterceptor instanceof DefaultLynxHttpInterceptor)) {
            LLog.e(TAG, "LynxHttpService interceptor already set, setHttpInterceptor ignored");
            return false;
        }
        mInterceptor = lynxHttpInterceptor;
        return true;
    }

    public static LynxHttpInterceptor getLynxHttpInterceptor() {
        return mInterceptor;
    }

    public static LynxIRetrofitFactory getRetrofitFactory() {
        return mIRetrofitFactory;
    }
}
