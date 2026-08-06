package com.bytedance.kmp.network.requet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IRequestInterceptor.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/network/requet/IRequestInterceptor;", "", "intercept", "Lcom/bytedance/kmp/network/requet/RequestBuilder;", "requestBuilder", "(Lcom/bytedance/kmp/network/requet/RequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IRequestInterceptor {
    Object intercept(RequestBuilder requestBuilder, Continuation<? super RequestBuilder> continuation);
}
