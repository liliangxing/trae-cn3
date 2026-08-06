package com.example.interopdemo;

import com.example.interopdemo.request.NativeRequest;
import com.example.interopdemo.request.NativeRequestBody;
import com.example.interopdemo.request.Request;
import com.example.interopdemo.response.NativeResponse;
import com.example.interopdemo.response.NativeResponseCallback;
import com.example.interopdemo.response.Response;
import com.example.interopdemo.response.ResponseCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: SsHttpCall.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/example/interopdemo/SsHttpCall;", "", "<init>", "()V", "call", "Lcom/example/interopdemo/SsCall;", "buildInternalRequest", "Lcom/example/interopdemo/request/Request;", "nativeRequest", "Lcom/example/interopdemo/request/NativeRequest;", "convertResponse", "Lcom/example/interopdemo/response/NativeResponse;", "response", "Lcom/example/interopdemo/response/Response;", "execute", "(Lcom/example/interopdemo/request/NativeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "", "nativeResponseCallback", "Lcom/example/interopdemo/response/NativeResponseCallback;", "(Lcom/example/interopdemo/request/NativeRequest;Lcom/example/interopdemo/response/NativeResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class SsHttpCall {
    private final SsCall call = SsCall_androidKt.newSsCall();

    private final Request buildInternalRequest(NativeRequest nativeRequest) {
        byte[] bArr;
        NativeRequestBody body = nativeRequest.getBody();
        if (body == null || (bArr = body.getBytes()) == null) {
            bArr = new byte[0];
        }
        return new Request(nativeRequest.getUrl(), nativeRequest.getMethod(), nativeRequest.getHeaders(), "BYTEARRAY", "", bArr, nativeRequest.getRequestTimeout(), nativeRequest.getConnectTimeout(), nativeRequest.getReadTimeout(), nativeRequest.getWriteTimeout());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NativeResponse convertResponse(Response response) {
        return new NativeResponse(response.getUrl(), response.getResponseCode(), response.getResponseHeaders(), response.getBodyByteArray(), response.getLogId(), response.getRequestLog(), response.getErrorCode(), response.getErrorMessage());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(NativeRequest nativeRequest, Continuation<? super NativeResponse> continuation) {
        SsHttpCall$execute$1 ssHttpCall$execute$1;
        int i;
        SsHttpCall ssHttpCall;
        if (continuation instanceof SsHttpCall$execute$1) {
            ssHttpCall$execute$1 = (SsHttpCall$execute$1) continuation;
            if ((ssHttpCall$execute$1.label & Integer.MIN_VALUE) != 0) {
                ssHttpCall$execute$1.label -= Integer.MIN_VALUE;
                Object obj = ssHttpCall$execute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = ssHttpCall$execute$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Request buildInternalRequest = buildInternalRequest(nativeRequest);
                    SsCall ssCall = this.call;
                    ssHttpCall$execute$1.L$0 = this;
                    ssHttpCall$execute$1.label = 1;
                    obj = ssCall.execute(buildInternalRequest, ssHttpCall$execute$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ssHttpCall = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ssHttpCall = (SsHttpCall) ssHttpCall$execute$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return ssHttpCall.convertResponse((Response) obj);
            }
        }
        ssHttpCall$execute$1 = new SsHttpCall$execute$1(this, continuation);
        Object obj2 = ssHttpCall$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = ssHttpCall$execute$1.label;
        if (i != 0) {
        }
        return ssHttpCall.convertResponse((Response) obj2);
    }

    public final Object executeStream(NativeRequest nativeRequest, final NativeResponseCallback nativeResponseCallback, Continuation<? super Unit> continuation) {
        Object executeStream = this.call.executeStream(buildInternalRequest(nativeRequest), new ResponseCallback() { // from class: com.example.interopdemo.SsHttpCall$executeStream$callback$1
            @Override // com.example.interopdemo.response.ResponseCallback
            public Object onResponseStart(Response response, Continuation<? super Unit> continuation2) {
                NativeResponse convertResponse;
                NativeResponseCallback nativeResponseCallback2 = NativeResponseCallback.this;
                convertResponse = this.convertResponse(response);
                Object onResponseStart = nativeResponseCallback2.onResponseStart(convertResponse, continuation2);
                return onResponseStart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onResponseStart : Unit.INSTANCE;
            }

            @Override // com.example.interopdemo.response.ResponseCallback
            public Object onDataComplete(byte[] bArr, Continuation<? super Unit> continuation2) {
                Object onDataComplete = NativeResponseCallback.this.onDataComplete(bArr, continuation2);
                return onDataComplete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onDataComplete : Unit.INSTANCE;
            }

            @Override // com.example.interopdemo.response.ResponseCallback
            public Object onSucceed(Response response, Continuation<? super Unit> continuation2) {
                NativeResponse convertResponse;
                NativeResponseCallback nativeResponseCallback2 = NativeResponseCallback.this;
                convertResponse = this.convertResponse(response);
                Object onSucceed = nativeResponseCallback2.onSucceed(convertResponse, continuation2);
                return onSucceed == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onSucceed : Unit.INSTANCE;
            }

            @Override // com.example.interopdemo.response.ResponseCallback
            public Object onError(Response response, Continuation<? super Unit> continuation2) {
                NativeResponse convertResponse;
                NativeResponseCallback nativeResponseCallback2 = NativeResponseCallback.this;
                convertResponse = this.convertResponse(response);
                Object onError = nativeResponseCallback2.onError(convertResponse, continuation2);
                return onError == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onError : Unit.INSTANCE;
            }
        }, continuation);
        return executeStream == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? executeStream : Unit.INSTANCE;
    }

    public final void cancel() {
        this.call.cancel();
    }
}
