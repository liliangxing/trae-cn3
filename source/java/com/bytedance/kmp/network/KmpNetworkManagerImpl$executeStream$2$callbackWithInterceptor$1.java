package com.bytedance.kmp.network;

import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\r"}, d2 = {"com/bytedance/kmp/network/KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1", "Lcom/bytedance/kmp/network/response/ResponseCallback;", "onDataComplete", "", "buffer", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onError", "response", "Lcom/bytedance/kmp/network/response/Response;", "(Lcom/bytedance/kmp/network/response/Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onResponseStart", "onSucceed", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 implements ResponseCallback {
    final /* synthetic */ ResponseCallback $callback;
    final /* synthetic */ KmpNetworkManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1(ResponseCallback responseCallback, KmpNetworkManagerImpl kmpNetworkManagerImpl) {
        this.$callback = responseCallback;
        this.this$0 = kmpNetworkManagerImpl;
    }

    @Override // com.bytedance.kmp.network.response.ResponseCallback
    public Object onDataComplete(byte[] bArr, Continuation<? super Unit> continuation) {
        Object onDataComplete = this.$callback.onDataComplete(bArr, continuation);
        return onDataComplete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onDataComplete : Unit.INSTANCE;
    }

    @Override // com.bytedance.kmp.network.response.ResponseCallback
    public Object onSucceed(Response response, Continuation<? super Unit> continuation) {
        Object onSucceed = this.$callback.onSucceed(response, continuation);
        return onSucceed == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onSucceed : Unit.INSTANCE;
    }

    @Override // com.bytedance.kmp.network.response.ResponseCallback
    public Object onError(Response response, Continuation<? super Unit> continuation) {
        Object onError = this.$callback.onError(response, continuation);
        return onError == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onError : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.kmp.network.response.ResponseCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onResponseStart(Response response, Continuation<? super Unit> continuation) {
        C0189xb249a5ba c0189xb249a5ba;
        Object obj;
        Object coroutine_suspended;
        int i;
        ResponseCallback responseCallback;
        if (continuation instanceof C0189xb249a5ba) {
            c0189xb249a5ba = (C0189xb249a5ba) continuation;
            if ((c0189xb249a5ba.label & Integer.MIN_VALUE) != 0) {
                c0189xb249a5ba.label -= Integer.MIN_VALUE;
                obj = c0189xb249a5ba.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0189xb249a5ba.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    KmpNetworkManagerImpl kmpNetworkManagerImpl = this.this$0;
                    c0189xb249a5ba.label = 1;
                    obj = kmpNetworkManagerImpl.postProcessResponse(response, c0189xb249a5ba);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                responseCallback = this.$callback;
                c0189xb249a5ba.label = 2;
                if (responseCallback.onResponseStart((Response) obj, c0189xb249a5ba) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        c0189xb249a5ba = new C0189xb249a5ba(this, continuation);
        obj = c0189xb249a5ba.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0189xb249a5ba.label;
        if (i != 0) {
        }
        responseCallback = this.$callback;
        c0189xb249a5ba.label = 2;
        if (responseCallback.onResponseStart((Response) obj, c0189xb249a5ba) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
