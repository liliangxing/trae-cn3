package com.bytedance.kmp.network.p010public;

import com.bytedance.kmp.network.UrlEncoderUtil;
import com.bytedance.kmp.network.requet.IRequestInterceptor;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.requet.RequestBuilder;
import com.bytedance.kmp.network.requet.RequestContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BizInterceptorManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/network/public/BizInterceptorManager;", "", "()V", "headerProviders", "", "Lcom/bytedance/kmp/network/public/ICommonHeaderProvider;", "queryProviderForCinteropRequest", "Lcom/bytedance/kmp/network/public/ICommonQueryProvider;", "queryProviders", "requestInterceptors", "Lcom/bytedance/kmp/network/requet/IRequestInterceptor;", "addHeaderProvider", "", "provider", "addQueryProvider", "addQueryProviderForCinteropRequest", "addRequestInterceptor", "interceptor", "intercept", "Lcom/bytedance/kmp/network/requet/Request;", "request", "(Lcom/bytedance/kmp/network/requet/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BizInterceptorManager {
    public static final BizInterceptorManager INSTANCE = new BizInterceptorManager();
    private static final List<ICommonQueryProvider> queryProviders = new ArrayList();
    private static final List<ICommonQueryProvider> queryProviderForCinteropRequest = new ArrayList();
    private static final List<ICommonHeaderProvider> headerProviders = new ArrayList();
    private static final List<IRequestInterceptor> requestInterceptors = new ArrayList();

    private BizInterceptorManager() {
    }

    public final void addQueryProvider(ICommonQueryProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        queryProviders.add(provider);
    }

    public final void addQueryProviderForCinteropRequest(ICommonQueryProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        queryProviderForCinteropRequest.add(provider);
    }

    public final void addHeaderProvider(ICommonHeaderProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        headerProviders.add(provider);
    }

    public final void addRequestInterceptor(IRequestInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        requestInterceptors.add(interceptor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x010d -> B:10:0x0110). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object intercept(Request request, Continuation<? super Request> continuation) {
        BizInterceptorManager$intercept$1 bizInterceptorManager$intercept$1;
        int i;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        RequestBuilder newBuilder;
        RequestContext reqContext;
        Iterator<IRequestInterceptor> it;
        LinkedHashMap linkedHashMap3;
        Map<? extends String, ? extends String> map;
        RequestContext requestContext;
        if (continuation instanceof BizInterceptorManager$intercept$1) {
            bizInterceptorManager$intercept$1 = (BizInterceptorManager$intercept$1) continuation;
            if ((bizInterceptorManager$intercept$1.label & Integer.MIN_VALUE) != 0) {
                bizInterceptorManager$intercept$1.label -= Integer.MIN_VALUE;
                Object obj = bizInterceptorManager$intercept$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bizInterceptorManager$intercept$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    linkedHashMap = new LinkedHashMap();
                    linkedHashMap2 = new LinkedHashMap();
                    newBuilder = request.newBuilder();
                    reqContext = request.getReqContext();
                    if (reqContext.getNeedCommonParams()) {
                        for (ICommonQueryProvider iCommonQueryProvider : queryProviders) {
                            linkedHashMap.putAll(iCommonQueryProvider.getCommonParams(request));
                            linkedHashMap.putAll(iCommonQueryProvider.getCommonParams(request.getUrl()));
                        }
                        if (reqContext.getIsCinteropRequest()) {
                            Iterator it2 = queryProviderForCinteropRequest.iterator();
                            while (it2.hasNext()) {
                                linkedHashMap.putAll(((ICommonQueryProvider) it2.next()).getCommonParams(request.getUrl()));
                            }
                        }
                    }
                    if (!reqContext.getBypassKmpBizInterceptor()) {
                        for (ICommonHeaderProvider iCommonHeaderProvider : headerProviders) {
                            linkedHashMap2.putAll(iCommonHeaderProvider.getCommonHeaders(request));
                            linkedHashMap2.putAll(iCommonHeaderProvider.getCommonHeaders(request.getUrl()));
                        }
                        List<IRequestInterceptor> list = requestInterceptors;
                        if (!(!list.isEmpty())) {
                            it = list.iterator();
                            linkedHashMap3 = linkedHashMap;
                            map = linkedHashMap2;
                            requestContext = reqContext;
                            if (it.hasNext()) {
                            }
                        }
                    }
                    if (reqContext.getBypassCronetCookie()) {
                    }
                    newBuilder.url(UrlEncoderUtil.INSTANCE.appendUnEncodedQueryToUrl(newBuilder.getUrl(), linkedHashMap));
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    linkedHashMap4.putAll(newBuilder.getHeaders());
                    linkedHashMap4.putAll(linkedHashMap2);
                    newBuilder.headers(linkedHashMap4);
                    return newBuilder.build();
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) bizInterceptorManager$intercept$1.L$3;
                requestContext = (RequestContext) bizInterceptorManager$intercept$1.L$2;
                Map<? extends String, ? extends String> map2 = (Map) bizInterceptorManager$intercept$1.L$1;
                ?? r5 = (Map) bizInterceptorManager$intercept$1.L$0;
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap5 = r5;
                Map<? extends String, ? extends String> map3 = map2;
                newBuilder = (RequestBuilder) obj;
                map = map3;
                linkedHashMap3 = linkedHashMap5;
                if (it.hasNext()) {
                    IRequestInterceptor next = it.next();
                    bizInterceptorManager$intercept$1.L$0 = linkedHashMap3;
                    bizInterceptorManager$intercept$1.L$1 = map;
                    bizInterceptorManager$intercept$1.L$2 = requestContext;
                    bizInterceptorManager$intercept$1.L$3 = it;
                    bizInterceptorManager$intercept$1.label = 1;
                    Object intercept = next.intercept(newBuilder, bizInterceptorManager$intercept$1);
                    if (intercept == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    map2 = map;
                    obj = intercept;
                    linkedHashMap5 = linkedHashMap3;
                    Map<? extends String, ? extends String> map32 = map2;
                    newBuilder = (RequestBuilder) obj;
                    map = map32;
                    linkedHashMap3 = linkedHashMap5;
                    if (it.hasNext()) {
                        RequestContext requestContext2 = requestContext;
                        linkedHashMap2 = map;
                        linkedHashMap = linkedHashMap3;
                        reqContext = requestContext2;
                        if (reqContext.getBypassCronetCookie()) {
                            linkedHashMap2.put(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER, "1");
                        }
                        newBuilder.url(UrlEncoderUtil.INSTANCE.appendUnEncodedQueryToUrl(newBuilder.getUrl(), linkedHashMap));
                        LinkedHashMap linkedHashMap42 = new LinkedHashMap();
                        linkedHashMap42.putAll(newBuilder.getHeaders());
                        linkedHashMap42.putAll(linkedHashMap2);
                        newBuilder.headers(linkedHashMap42);
                        return newBuilder.build();
                    }
                }
            }
        }
        bizInterceptorManager$intercept$1 = new BizInterceptorManager$intercept$1(this, continuation);
        Object obj2 = bizInterceptorManager$intercept$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bizInterceptorManager$intercept$1.label;
        if (i != 0) {
        }
    }
}
