package com.example.interopdemo;

import com.example.interopdemo.request.Request;
import com.example.interopdemo.response.Response;
import com.example.interopdemo.response.ResponseCallback;
import com.example.kmp.shared.sha.BridgeResponse;
import com.example.kmp.shared.sha.BridgeResponseCallback;
import com.example.kmp.shared.sha.TTHttpRequestBridge;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseSsCall.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0084@¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0084@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/example/interopdemo/BaseSsCall;", "Lcom/example/interopdemo/SsCall;", "<init>", "()V", "executeInner", "Lcom/example/interopdemo/response/Response;", "httpRequest", "Lcom/example/kmp/shared/sha/TTHttpRequestBridge;", "request", "Lcom/example/interopdemo/request/Request;", "(Lcom/example/kmp/shared/sha/TTHttpRequestBridge;Lcom/example/interopdemo/request/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStreamInner", "", "callback", "Lcom/example/interopdemo/response/ResponseCallback;", "(Lcom/example/kmp/shared/sha/TTHttpRequestBridge;Lcom/example/interopdemo/request/Request;Lcom/example/interopdemo/response/ResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class BaseSsCall implements SsCall {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeInner(TTHttpRequestBridge tTHttpRequestBridge, Request request, Continuation<? super Response> continuation) {
        BaseSsCall$executeInner$1 baseSsCall$executeInner$1;
        int i;
        BridgeResponse bridgeResponse;
        if (continuation instanceof BaseSsCall$executeInner$1) {
            baseSsCall$executeInner$1 = (BaseSsCall$executeInner$1) continuation;
            if ((baseSsCall$executeInner$1.label & Integer.MIN_VALUE) != 0) {
                baseSsCall$executeInner$1.label -= Integer.MIN_VALUE;
                Object obj = baseSsCall$executeInner$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = baseSsCall$executeInner$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    tTHttpRequestBridge.setUrl(request.getUrl());
                    tTHttpRequestBridge.setMethod(request.getMethod());
                    tTHttpRequestBridge.setHeaders(request.getHeaders());
                    if (Intrinsics.areEqual(request.getMethod(), "POST")) {
                        tTHttpRequestBridge.setBodyType(request.getBodyType());
                        if (Intrinsics.areEqual(tTHttpRequestBridge.getBodyType(), "STRING")) {
                            tTHttpRequestBridge.setStrBody(request.getStrBody());
                        } else {
                            tTHttpRequestBridge.setBytesBody(request.getBytesBody());
                        }
                    }
                    tTHttpRequestBridge.setConnectTimeout(request.getConnectTimeout());
                    tTHttpRequestBridge.setReadTimeout(request.getReadTimeout());
                    tTHttpRequestBridge.setWriteTimeout(request.getWriteTimeout());
                    tTHttpRequestBridge.setRequestTimeout(request.getRequestTimeout());
                    String url = request.getUrl();
                    baseSsCall$executeInner$1.label = 1;
                    obj = tTHttpRequestBridge.execute(url, baseSsCall$executeInner$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                bridgeResponse = (BridgeResponse) obj;
                Response response = new Response();
                if (bridgeResponse != null) {
                    response.setUrl(bridgeResponse.getUrl());
                    response.setResponseCode(bridgeResponse.getResponseCode());
                    response.setProtocol(bridgeResponse.getProtocol());
                    response.setResponseHeaders(bridgeResponse.getResponseHeaders());
                    response.setBodyByteArray(bridgeResponse.getBodyByteArray());
                    response.setRequestLog(bridgeResponse.getRequestLog());
                    response.setLogId(bridgeResponse.getLogId());
                    if (bridgeResponse.getErrorCode() != 0) {
                        response.setErrorCode(bridgeResponse.getErrorCode());
                        response.setErrorMessage(bridgeResponse.getErrorMessage());
                    }
                }
                return response;
            }
        }
        baseSsCall$executeInner$1 = new BaseSsCall$executeInner$1(this, continuation);
        Object obj2 = baseSsCall$executeInner$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = baseSsCall$executeInner$1.label;
        if (i != 0) {
        }
        bridgeResponse = (BridgeResponse) obj2;
        Response response2 = new Response();
        if (bridgeResponse != null) {
        }
        return response2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(2:17|18))(3:21|22|(1:24))|19|12|13))|29|6|7|(0)(0)|19|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0091, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        r9 = new com.example.interopdemo.response.Response();
        r9.setUrl(r7.getUrl());
        r9.setErrorCode(-99);
        r9.setErrorMessage("Stream execution failed unexpectedly: " + r6.getMessage());
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c4, code lost:
    
        if (r8.onError(r9, r0) == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c6, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeStreamInner(TTHttpRequestBridge tTHttpRequestBridge, Request request, final ResponseCallback responseCallback, Continuation<? super Unit> continuation) {
        BaseSsCall$executeStreamInner$1 baseSsCall$executeStreamInner$1;
        int i;
        if (continuation instanceof BaseSsCall$executeStreamInner$1) {
            baseSsCall$executeStreamInner$1 = (BaseSsCall$executeStreamInner$1) continuation;
            if ((baseSsCall$executeStreamInner$1.label & Integer.MIN_VALUE) != 0) {
                baseSsCall$executeStreamInner$1.label -= Integer.MIN_VALUE;
                Object obj = baseSsCall$executeStreamInner$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = baseSsCall$executeStreamInner$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    tTHttpRequestBridge.setUrl(request.getUrl());
                    tTHttpRequestBridge.setMethod(request.getMethod());
                    tTHttpRequestBridge.setHeaders(request.getHeaders());
                    tTHttpRequestBridge.setConnectTimeout(request.getConnectTimeout());
                    tTHttpRequestBridge.setReadTimeout(request.getReadTimeout());
                    tTHttpRequestBridge.setWriteTimeout(request.getWriteTimeout());
                    tTHttpRequestBridge.setRequestTimeout(request.getRequestTimeout());
                    BridgeResponseCallback bridgeResponseCallback = new BridgeResponseCallback() { // from class: com.example.interopdemo.BaseSsCall$executeStreamInner$bridgeCallbackAdapter$1
                        private final Response convertResponse(BridgeResponse bridgeResponse) {
                            Response response = new Response();
                            response.setUrl(bridgeResponse.getUrl());
                            response.setResponseCode(bridgeResponse.getResponseCode());
                            response.setProtocol(bridgeResponse.getProtocol());
                            response.setResponseHeaders(bridgeResponse.getResponseHeaders());
                            response.setBodyByteArray(bridgeResponse.getBodyByteArray());
                            response.setRequestLog(bridgeResponse.getRequestLog());
                            response.setLogId(bridgeResponse.getLogId());
                            if (bridgeResponse.getErrorCode() != 0) {
                                response.setErrorCode(bridgeResponse.getErrorCode());
                                response.setErrorMessage(bridgeResponse.getErrorMessage());
                            }
                            return response;
                        }

                        @Override // com.example.kmp.shared.sha.BridgeResponseCallback
                        public Object onResponseStart(BridgeResponse bridgeResponse, Continuation<? super Unit> continuation2) {
                            Object onResponseStart = ResponseCallback.this.onResponseStart(convertResponse(bridgeResponse), continuation2);
                            return onResponseStart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onResponseStart : Unit.INSTANCE;
                        }

                        @Override // com.example.kmp.shared.sha.BridgeResponseCallback
                        public Object onDataComplete(byte[] bArr, Continuation<? super Unit> continuation2) {
                            Object onDataComplete = ResponseCallback.this.onDataComplete(bArr, continuation2);
                            return onDataComplete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onDataComplete : Unit.INSTANCE;
                        }

                        @Override // com.example.kmp.shared.sha.BridgeResponseCallback
                        public Object onSuccess(BridgeResponse bridgeResponse, Continuation<? super Unit> continuation2) {
                            Object onSucceed = ResponseCallback.this.onSucceed(convertResponse(bridgeResponse), continuation2);
                            return onSucceed == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onSucceed : Unit.INSTANCE;
                        }

                        @Override // com.example.kmp.shared.sha.BridgeResponseCallback
                        public Object onError(BridgeResponse bridgeResponse, Continuation<? super Unit> continuation2) {
                            Object onError = ResponseCallback.this.onError(convertResponse(bridgeResponse), continuation2);
                            return onError == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onError : Unit.INSTANCE;
                        }
                    };
                    baseSsCall$executeStreamInner$1.L$0 = request;
                    baseSsCall$executeStreamInner$1.L$1 = responseCallback;
                    baseSsCall$executeStreamInner$1.label = 1;
                    if (tTHttpRequestBridge.executeStream(request.getUrl(), bridgeResponseCallback, baseSsCall$executeStreamInner$1) == coroutine_suspended) {
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
                    responseCallback = (ResponseCallback) baseSsCall$executeStreamInner$1.L$1;
                    request = (Request) baseSsCall$executeStreamInner$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        baseSsCall$executeStreamInner$1 = new BaseSsCall$executeStreamInner$1(this, continuation);
        Object obj2 = baseSsCall$executeStreamInner$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = baseSsCall$executeStreamInner$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }
}
