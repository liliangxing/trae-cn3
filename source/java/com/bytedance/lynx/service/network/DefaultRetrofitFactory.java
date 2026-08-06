package com.bytedance.lynx.service.network;

import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultRetrofitFactory implements LynxIRetrofitFactory {
    @Override // com.bytedance.lynx.service.network.LynxIRetrofitFactory
    public LynxIRetrofit createRetrofit(String str) {
        return new DefaultRetrofit(new Retrofit.Builder().setEndpoint(str).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor()).client(new Client.Provider() { // from class: com.bytedance.lynx.service.network.DefaultRetrofitFactory.1
            @Override // com.bytedance.retrofit2.client.Client.Provider
            public Client get() {
                return new SsRetrofitClient();
            }
        }).build());
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class DefaultRetrofit implements LynxIRetrofit {
        private final Retrofit mRetrofit;

        public DefaultRetrofit(Retrofit retrofit) {
            this.mRetrofit = retrofit;
        }

        @Override // com.bytedance.lynx.service.network.LynxIRetrofit
        public <T> T create(Class<T> cls) {
            return (T) this.mRetrofit.create(cls);
        }
    }
}
