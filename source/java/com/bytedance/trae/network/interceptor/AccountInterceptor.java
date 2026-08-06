package com.bytedance.trae.network.interceptor;

import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/network/interceptor/AccountInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "<init>", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AccountInterceptor implements Interceptor {
    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain chain) {
        Request request;
        if (chain == null || (request = chain.request()) == null) {
            return null;
        }
        Request.Builder newBuilder = request.newBuilder();
        UrlBuilder urlBuilder = new UrlBuilder(request.getUrl());
        List<Header> headers = request.getHeaders();
        Intrinsics.checkNotNullExpressionValue(headers, "getHeaders(...)");
        List<Header> mutableList = CollectionsKt.toMutableList(headers);
        newBuilder.url(urlBuilder.build());
        newBuilder.headers(mutableList);
        return chain.proceed(newBuilder.build());
    }
}
