package com.bytedance.kmp.network.cinterop;

import com.bytedance.kmp.network.NetError;
import com.bytedance.kmp.network.NetRequestMetrics;
import com.bytedance.kmp.network.Protocol;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseCallback;
import com.example.interopdemo.response.NativeResponse;
import com.example.interopdemo.response.NativeResponseCallback;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: KmpNativeNetworkService.kt */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u0011"}, d2 = {"com/bytedance/kmp/network/cinterop/KmpNativeNetworkService$executeStream$3", "Lcom/example/interopdemo/response/NativeResponseCallback;", "buildStreamResponse", "Lcom/bytedance/kmp/network/response/Response;", "nativeResponse", "Lcom/example/interopdemo/response/NativeResponse;", "error", "Lcom/bytedance/kmp/network/NetError;", "onDataComplete", "", "buffer", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onError", "(Lcom/example/interopdemo/response/NativeResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onResponseStart", "onSucceed", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNativeNetworkService$executeStream$3 implements NativeResponseCallback {
    final /* synthetic */ ResponseCallback $callback;
    final /* synthetic */ Request $request;
    final /* synthetic */ int $requestId;
    final /* synthetic */ KmpNativeNetworkService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KmpNativeNetworkService$executeStream$3(KmpNativeNetworkService kmpNativeNetworkService, Request request, ResponseCallback responseCallback, int i) {
        this.this$0 = kmpNativeNetworkService;
        this.$request = request;
        this.$callback = responseCallback;
        this.$requestId = i;
    }

    static /* synthetic */ Response buildStreamResponse$default(KmpNativeNetworkService$executeStream$3 kmpNativeNetworkService$executeStream$3, NativeResponse nativeResponse, NetError netError, int i, Object obj) {
        if ((i & 2) != 0) {
            netError = null;
        }
        return kmpNativeNetworkService$executeStream$3.buildStreamResponse(nativeResponse, netError);
    }

    private final Response buildStreamResponse(NativeResponse nativeResponse, NetError error) {
        List buildHeaders;
        buildHeaders = this.this$0.buildHeaders(nativeResponse);
        return new Response(this.$request, Protocol.UNKNOWN, nativeResponse.getRequestLog(), nativeResponse.getHttpStatusCode(), buildHeaders, null, error, new NetRequestMetrics());
    }

    public Object onResponseStart(NativeResponse nativeResponse, Continuation<? super Unit> continuation) {
        Object onResponseStart = this.$callback.onResponseStart(buildStreamResponse$default(this, nativeResponse, null, 2, null), continuation);
        return onResponseStart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onResponseStart : Unit.INSTANCE;
    }

    public Object onDataComplete(byte[] bArr, Continuation<? super Unit> continuation) {
        Object onDataComplete = this.$callback.onDataComplete(bArr, continuation);
        return onDataComplete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onDataComplete : Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(1:(1:(5:12|13|(1:15)(1:20)|16|17)(2:24|25))(5:26|27|(1:29)(1:33)|30|31))(1:37))(3:43|44|(1:46))|38|(1:40)(5:41|27|(0)(0)|30|31)))|52|6|7|(0)(0)|38|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0062, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
    
        r9 = r7.this$0.requestMapMutex;
        r2 = r7.$requestId;
        r4 = r7.this$0;
        r5 = r7.$request;
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.L$2 = r4;
        r0.L$3 = r5;
        r0.I$0 = r2;
        r0.label = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00de, code lost:
    
        if (r9.lock((java.lang.Object) null, (kotlin.coroutines.Continuation) r0) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e0, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e1, code lost:
    
        r0 = r8;
        r3 = r9;
        r8 = r2;
        r2 = r4;
        r1 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e A[Catch: all -> 0x00bd, TRY_ENTER, TryCatch #2 {all -> 0x00bd, blocks: (B:29:0x009e, B:33:0x00ad), top: B:27:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad A[Catch: all -> 0x00bd, TRY_LEAVE, TryCatch #2 {all -> 0x00bd, blocks: (B:29:0x009e, B:33:0x00ad), top: B:27:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, com.bytedance.kmp.network.cinterop.KmpNativeNetworkService$executeStream$3$onError$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.coroutines.Continuation, com.bytedance.kmp.network.cinterop.KmpNativeNetworkService$executeStream$3$onError$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, com.bytedance.kmp.network.requet.Request] */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.bytedance.kmp.network.response.ResponseCallback] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onError(NativeResponse nativeResponse, Continuation<? super Unit> continuation) {
        ?? r0;
        Object coroutine_suspended;
        int i;
        Map map;
        Map map2;
        NetError buildNetError;
        Mutex mutex;
        KmpNativeNetworkService kmpNativeNetworkService;
        Mutex mutex2;
        int i2;
        Request request;
        Map map3;
        Map map4;
        if (continuation instanceof KmpNativeNetworkService$executeStream$3$onError$1) {
            KmpNativeNetworkService$executeStream$3$onError$1 kmpNativeNetworkService$executeStream$3$onError$1 = (KmpNativeNetworkService$executeStream$3$onError$1) continuation;
            if ((kmpNativeNetworkService$executeStream$3$onError$1.label & Integer.MIN_VALUE) != 0) {
                kmpNativeNetworkService$executeStream$3$onError$1.label -= Integer.MIN_VALUE;
                r0 = kmpNativeNetworkService$executeStream$3$onError$1;
                Object obj = r0.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                ?? r3 = 3;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ?? r9 = this.$callback;
                    buildNetError = this.this$0.buildNetError(nativeResponse);
                    Response buildStreamResponse = buildStreamResponse(nativeResponse, buildNetError);
                    r0.label = 1;
                    if (r9.onError(buildStreamResponse, r0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            i2 = r0.I$0;
                            request = (Request) r0.L$2;
                            kmpNativeNetworkService = (KmpNativeNetworkService) r0.L$1;
                            mutex2 = (Mutex) r0.L$0;
                            ResultKt.throwOnFailure(obj);
                            try {
                                if (i2 <= 0) {
                                    map4 = kmpNativeNetworkService.callMapByRequestUuid;
                                } else {
                                    map3 = kmpNativeNetworkService.kmpRequestMap;
                                }
                                mutex2.unlock((Object) null);
                                return Unit.INSTANCE;
                            } finally {
                            }
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i3 = r0.I$0;
                        Request request2 = (Request) r0.L$3;
                        KmpNativeNetworkService kmpNativeNetworkService2 = (KmpNativeNetworkService) r0.L$2;
                        Mutex mutex3 = (Mutex) r0.L$1;
                        Throwable th = (Throwable) r0.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            if (i3 > 0) {
                                map2 = kmpNativeNetworkService2.callMapByRequestUuid;
                            } else {
                                map = kmpNativeNetworkService2.kmpRequestMap;
                            }
                            throw th;
                        } finally {
                        }
                    }
                    ResultKt.throwOnFailure(obj);
                }
                mutex = this.this$0.requestMapMutex;
                int i4 = this.$requestId;
                kmpNativeNetworkService = this.this$0;
                r3 = this.$request;
                r0.L$0 = mutex;
                r0.L$1 = kmpNativeNetworkService;
                r0.L$2 = r3;
                r0.I$0 = i4;
                r0.label = 2;
                r0 = mutex.lock((Object) null, (Continuation) r0);
                if (r0 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                i2 = i4;
                request = r3;
                if (i2 <= 0) {
                }
                mutex2.unlock((Object) null);
                return Unit.INSTANCE;
            }
        }
        r0 = new KmpNativeNetworkService$executeStream$3$onError$1(this, continuation);
        Object obj2 = r0.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        ?? r32 = 3;
        if (i != 0) {
        }
        mutex = this.this$0.requestMapMutex;
        int i42 = this.$requestId;
        kmpNativeNetworkService = this.this$0;
        r32 = this.$request;
        r0.L$0 = mutex;
        r0.L$1 = kmpNativeNetworkService;
        r0.L$2 = r32;
        r0.I$0 = i42;
        r0.label = 2;
        r0 = mutex.lock((Object) null, (Continuation) r0);
        if (r0 != coroutine_suspended) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(1:(1:(5:12|13|(1:15)(1:20)|16|17)(2:24|25))(5:26|27|(1:29)(1:33)|30|31))(1:37))(3:43|44|(1:46))|38|(1:40)(5:41|27|(0)(0)|30|31)))|52|6|7|(0)(0)|38|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0062, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bc, code lost:
    
        r9 = r7.this$0.requestMapMutex;
        r2 = r7.$requestId;
        r4 = r7.this$0;
        r5 = r7.$request;
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.L$2 = r4;
        r0.L$3 = r5;
        r0.I$0 = r2;
        r0.label = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d8, code lost:
    
        if (r9.lock((java.lang.Object) null, (kotlin.coroutines.Continuation) r0) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00da, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00db, code lost:
    
        r0 = r8;
        r3 = r9;
        r8 = r2;
        r2 = r4;
        r1 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098 A[Catch: all -> 0x00b7, TRY_ENTER, TryCatch #1 {all -> 0x00b7, blocks: (B:29:0x0098, B:33:0x00a7), top: B:27:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #1 {all -> 0x00b7, blocks: (B:29:0x0098, B:33:0x00a7), top: B:27:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, com.bytedance.kmp.network.cinterop.KmpNativeNetworkService$executeStream$3$onSucceed$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.coroutines.Continuation, com.bytedance.kmp.network.cinterop.KmpNativeNetworkService$executeStream$3$onSucceed$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, com.bytedance.kmp.network.requet.Request] */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.bytedance.kmp.network.response.ResponseCallback] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onSucceed(NativeResponse nativeResponse, Continuation<? super Unit> continuation) {
        ?? r0;
        Object coroutine_suspended;
        int i;
        Map map;
        Map map2;
        Mutex mutex;
        KmpNativeNetworkService kmpNativeNetworkService;
        Mutex mutex2;
        int i2;
        Request request;
        Map map3;
        Map map4;
        if (continuation instanceof KmpNativeNetworkService$executeStream$3$onSucceed$1) {
            KmpNativeNetworkService$executeStream$3$onSucceed$1 kmpNativeNetworkService$executeStream$3$onSucceed$1 = (KmpNativeNetworkService$executeStream$3$onSucceed$1) continuation;
            if ((kmpNativeNetworkService$executeStream$3$onSucceed$1.label & Integer.MIN_VALUE) != 0) {
                kmpNativeNetworkService$executeStream$3$onSucceed$1.label -= Integer.MIN_VALUE;
                r0 = kmpNativeNetworkService$executeStream$3$onSucceed$1;
                Object obj = r0.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                ?? r3 = 3;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ?? r9 = this.$callback;
                    Response buildStreamResponse$default = buildStreamResponse$default(this, nativeResponse, null, 2, null);
                    r0.label = 1;
                    if (r9.onSucceed(buildStreamResponse$default, r0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            i2 = r0.I$0;
                            request = (Request) r0.L$2;
                            kmpNativeNetworkService = (KmpNativeNetworkService) r0.L$1;
                            mutex2 = (Mutex) r0.L$0;
                            ResultKt.throwOnFailure(obj);
                            try {
                                if (i2 <= 0) {
                                    map4 = kmpNativeNetworkService.callMapByRequestUuid;
                                } else {
                                    map3 = kmpNativeNetworkService.kmpRequestMap;
                                }
                                mutex2.unlock((Object) null);
                                return Unit.INSTANCE;
                            } finally {
                            }
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i3 = r0.I$0;
                        Request request2 = (Request) r0.L$3;
                        KmpNativeNetworkService kmpNativeNetworkService2 = (KmpNativeNetworkService) r0.L$2;
                        Mutex mutex3 = (Mutex) r0.L$1;
                        Throwable th = (Throwable) r0.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            if (i3 > 0) {
                                map2 = kmpNativeNetworkService2.callMapByRequestUuid;
                            } else {
                                map = kmpNativeNetworkService2.kmpRequestMap;
                            }
                            throw th;
                        } finally {
                        }
                    }
                    ResultKt.throwOnFailure(obj);
                }
                mutex = this.this$0.requestMapMutex;
                int i4 = this.$requestId;
                kmpNativeNetworkService = this.this$0;
                r3 = this.$request;
                r0.L$0 = mutex;
                r0.L$1 = kmpNativeNetworkService;
                r0.L$2 = r3;
                r0.I$0 = i4;
                r0.label = 2;
                r0 = mutex.lock((Object) null, (Continuation) r0);
                if (r0 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                i2 = i4;
                request = r3;
                if (i2 <= 0) {
                }
                mutex2.unlock((Object) null);
                return Unit.INSTANCE;
            }
        }
        r0 = new KmpNativeNetworkService$executeStream$3$onSucceed$1(this, continuation);
        Object obj2 = r0.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        ?? r32 = 3;
        if (i != 0) {
        }
        mutex = this.this$0.requestMapMutex;
        int i42 = this.$requestId;
        kmpNativeNetworkService = this.this$0;
        r32 = this.$request;
        r0.L$0 = mutex;
        r0.L$1 = kmpNativeNetworkService;
        r0.L$2 = r32;
        r0.I$0 = i42;
        r0.label = 2;
        r0 = mutex.lock((Object) null, (Continuation) r0);
        if (r0 != coroutine_suspended) {
        }
    }
}
