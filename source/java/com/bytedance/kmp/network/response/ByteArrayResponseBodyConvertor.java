package com.bytedance.kmp.network.response;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ResponseBodyConvertor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/kmp/network/response/ByteArrayResponseBodyConvertor;", "Lcom/bytedance/kmp/network/response/ResponseBodyConvertor;", "", "()V", "convert", "responseBody", "Lcom/bytedance/kmp/network/response/ResponseBody;", "(Lcom/bytedance/kmp/network/response/ResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteArrayResponseBodyConvertor implements ResponseBodyConvertor<byte[]> {
    @Override // com.bytedance.kmp.network.response.ResponseBodyConvertor
    public Object convert(ResponseBody responseBody, Continuation<? super byte[]> continuation) {
        if (responseBody != null) {
            return responseBody.bytes();
        }
        return null;
    }
}
