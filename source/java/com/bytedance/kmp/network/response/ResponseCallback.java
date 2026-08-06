package com.bytedance.kmp.network.response;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: ResponseCallback.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/network/response/ResponseCallback;", "", "onDataComplete", "", "buffer", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onError", "response", "Lcom/bytedance/kmp/network/response/Response;", "(Lcom/bytedance/kmp/network/response/Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onResponseStart", "onSucceed", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ResponseCallback {
    Object onDataComplete(byte[] bArr, Continuation<? super Unit> continuation);

    Object onError(Response response, Continuation<? super Unit> continuation);

    Object onResponseStart(Response response, Continuation<? super Unit> continuation);

    Object onSucceed(Response response, Continuation<? super Unit> continuation);
}
