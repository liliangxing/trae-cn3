package com.bytedance.sdk.xbridge.cn.runtime.network;

import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson.GsonConverterFactory;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetrofitFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/network/RetrofitFactory;", "", "()V", "createRetrofit", "Lcom/bytedance/retrofit2/Retrofit;", "baseUrl", "", "isUseOkHttp", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RetrofitFactory {
    public static final RetrofitFactory INSTANCE = new RetrofitFactory();

    private RetrofitFactory() {
    }

    public static /* synthetic */ Retrofit createRetrofit$default(RetrofitFactory retrofitFactory, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return retrofitFactory.createRetrofit(str, z);
    }

    public final Retrofit createRetrofit(String baseUrl, boolean isUseOkHttp) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Retrofit build = new Retrofit.Builder().setEndpoint(baseUrl).addConverterFactory(GsonConverterFactory.create()).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor()).client(isUseOkHttp ? new OkClient() : new TTNetClient()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        return build;
    }
}
