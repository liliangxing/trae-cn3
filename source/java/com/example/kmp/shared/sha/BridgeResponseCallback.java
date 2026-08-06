package com.example.kmp.shared.sha;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: TTHttpRequestBridge.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/example/kmp/shared/sha/BridgeResponseCallback;", "", "onResponseStart", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/example/kmp/shared/sha/BridgeResponse;", "(Lcom/example/kmp/shared/sha/BridgeResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDataComplete", "buffer", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSuccess", "onError", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface BridgeResponseCallback {
    Object onDataComplete(byte[] bArr, Continuation<? super Unit> continuation);

    Object onError(BridgeResponse bridgeResponse, Continuation<? super Unit> continuation);

    Object onResponseStart(BridgeResponse bridgeResponse, Continuation<? super Unit> continuation);

    Object onSuccess(BridgeResponse bridgeResponse, Continuation<? super Unit> continuation);
}
