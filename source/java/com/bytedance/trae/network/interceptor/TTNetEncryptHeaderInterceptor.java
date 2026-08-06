package com.bytedance.trae.network.interceptor;

import com.bytedance.applog.AppLog;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.trae.common.security.api.SecurityService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTNetEncryptHeaderInterceptor.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "<init>", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TTNetEncryptHeaderInterceptor implements Interceptor {
    private static final String X_TT_ENCRYPT_BODY = "x-tt-e-b";
    private static final String X_TT_ENCRYPT_SCENE = "x-tt-e-k";
    private static final String X_TT_GET_SVC = "get-svc";
    private static final String X_TT_RETRY_MOCK = "x-tt-mock-retry";

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain chain) {
        Request request;
        if (chain == null || (request = chain.request()) == null) {
            return null;
        }
        SecurityService securityService = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (securityService == null) {
            return chain.proceed(request);
        }
        if (securityService.shouldAddTTNetEncryptHeader(request.getUrl())) {
            String userUniqueID = AppLog.getUserUniqueID();
            String str = userUniqueID;
            if (str == null || str.length() == 0) {
                userUniqueID = AppLog.getDid();
            }
            String tTNetEncryptScene = securityService.getTTNetEncryptScene(request.getUrl());
            Request.Builder newBuilder = request.newBuilder();
            List<Header> headers = request.getHeaders();
            Intrinsics.checkNotNullExpressionValue(headers, "getHeaders(...)");
            List<Header> mutableList = CollectionsKt.toMutableList(headers);
            mutableList.add(new Header(X_TT_ENCRYPT_BODY, "1"));
            mutableList.add(new Header(X_TT_ENCRYPT_SCENE, userUniqueID + '+' + tTNetEncryptScene));
            if (securityService.forceTTNetRetry()) {
                mutableList.add(new Header(X_TT_GET_SVC, "1"));
                mutableList.add(new Header(X_TT_RETRY_MOCK, "1"));
            }
            Unit unit = Unit.INSTANCE;
            SsResponse<?> proceed = chain.proceed(newBuilder.headers(mutableList).build());
            String url = request.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            List<Header> headers2 = proceed.headers();
            Intrinsics.checkNotNullExpressionValue(headers2, "headers(...)");
            securityService.tryMobTTNetEncryptResult(url, tTNetEncryptScene, headers2);
            return proceed;
        }
        return chain.proceed(chain.request());
    }
}
