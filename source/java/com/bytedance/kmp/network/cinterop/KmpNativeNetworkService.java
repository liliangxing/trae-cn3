package com.bytedance.kmp.network.cinterop;

import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.kmp.network.Header;
import com.bytedance.kmp.network.IKmpNetworkService;
import com.bytedance.kmp.network.NetError;
import com.bytedance.kmp.network.NetRequestMetrics;
import com.bytedance.kmp.network.Protocol;
import com.bytedance.kmp.network.nqe.EffectiveConnectionType;
import com.bytedance.kmp.network.nqe.NQEListener;
import com.bytedance.kmp.network.nqe.NetworkQualityState;
import com.bytedance.kmp.network.nqe.PacketLoss;
import com.bytedance.kmp.network.nqe.RttAndThroughput;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.requet.RequestBody;
import com.bytedance.kmp.network.requet.RequestContext;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseCallback;
import com.example.interopdemo.NativeTTNetworkClient;
import com.example.interopdemo.SsHttpCall;
import com.example.interopdemo.nqe.NativeNQEListener;
import com.example.interopdemo.nqe.NativePacketLostStats;
import com.example.interopdemo.nqe.NativeRTTAndThroughput;
import com.example.interopdemo.request.NativeRequest;
import com.example.interopdemo.request.NativeRequestBuilder;
import com.example.interopdemo.response.NativeResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: KmpNativeNetworkService.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\bH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/kmp/network/cinterop/KmpNativeNetworkService;", "Lcom/bytedance/kmp/network/IKmpNetworkService;", "()V", "callMapByRequestUuid", "", "", "Lcom/example/interopdemo/SsHttpCall;", "kmpRequestMap", "Lcom/bytedance/kmp/network/requet/Request;", "requestMapMutex", "Lkotlinx/coroutines/sync/Mutex;", "buildHeaders", "", "Lcom/bytedance/kmp/network/Header;", "nativeResponse", "Lcom/example/interopdemo/response/NativeResponse;", "buildNativeRequest", "Lcom/example/interopdemo/request/NativeRequest;", "request", "buildNetError", "Lcom/bytedance/kmp/network/NetError;", "cancel", "", "convertToApiResponse", "Lcom/bytedance/kmp/network/response/Response;", "execute", "(Lcom/bytedance/kmp/network/requet/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "callback", "Lcom/bytedance/kmp/network/response/ResponseCallback;", "(Lcom/bytedance/kmp/network/requet/Request;Lcom/bytedance/kmp/network/response/ResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetworkQualityState", "Lcom/bytedance/kmp/network/nqe/NetworkQualityState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNativeError", "", "preConnect", "url", "", "registerNQEListener", "listener", "Lcom/bytedance/kmp/network/nqe/NQEListener;", "requestTrackingId", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNativeNetworkService implements IKmpNetworkService {
    private final Mutex requestMapMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private final Map<Request, SsHttpCall> kmpRequestMap = new LinkedHashMap();
    private final Map<Integer, SsHttpCall> callMapByRequestUuid = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public final int requestTrackingId(Request request) {
        return request.getReqContext().getRequestUuid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Header> buildHeaders(NativeResponse nativeResponse) {
        List<Pair> headers = nativeResponse.getHeaders();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(headers, 10));
        for (Pair pair : headers) {
            Header header = new Header();
            header.setName((String) pair.getFirst());
            header.setValue((String) pair.getSecond());
            arrayList.add(header);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NetError buildNetError(NativeResponse nativeResponse) {
        NetError netError = new NetError();
        netError.setCronetInternalError(nativeResponse.getErrorCode());
        netError.setTtnetStatusCode(nativeResponse.getHttpStatusCode());
        netError.setCronetRequestLog(nativeResponse.getRequestLog());
        netError.setErrorMessage(nativeResponse.getErrorMessage());
        netError.setErrorRespHeader(buildHeaders(nativeResponse));
        netError.setErrorRespBody(nativeResponse.getBody());
        return netError;
    }

    private final boolean hasNativeError(NativeResponse nativeResponse) {
        if (nativeResponse.getErrorCode() == 0) {
            return nativeResponse.getErrorMessage().length() > 0;
        }
        return true;
    }

    private final NativeRequest buildNativeRequest(Request request) {
        NativeRequestBuilder method = new NativeRequestBuilder().url(request.getUrl()).method(request.getMethod());
        RequestBody body = request.getBody();
        if (body != null) {
            String contentType = body.getContentType();
            Buffer buffer = new Buffer();
            body.writeTo((BufferedSink) buffer);
            method.body(buffer.readByteArray(), contentType);
        }
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            method.addHeader(entry.getKey(), entry.getValue());
        }
        RequestContext reqContext = request.getReqContext();
        method.requestTimeout((int) reqContext.getRequestTimeout()).connectTimeout((int) reqContext.getConnectTimeout()).readTimeout((int) reqContext.getReadTimeout()).writeTimeout((int) reqContext.getWriteTimeout());
        return method.build();
    }

    private final Response convertToApiResponse(NativeResponse nativeResponse, Request request) {
        return new Response(request, Protocol.UNKNOWN, nativeResponse.getRequestLog(), nativeResponse.getHttpStatusCode(), buildHeaders(nativeResponse), new ByteArrayResponseBody(nativeResponse.getBody(), nativeResponse.getHeader(XBridgeAPIRequestUtils.CONTENT_TYPE)), hasNativeError(nativeResponse) ? buildNetError(nativeResponse) : null, new NetRequestMetrics());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(2:3|(10:5|6|(1:(1:(1:(1:(5:12|13|(1:15)(1:20)|16|17)(2:24|25))(5:26|27|(1:29)(1:33)|30|31))(6:37|38|39|40|41|(1:43)(5:44|27|(0)(0)|30|31)))(1:53))(2:71|(1:73)(1:74))|54|(1:56)(1:67)|57|58|59|60|(1:62)(4:63|40|41|(0)(0))))|54|(0)(0)|57|58|59|60|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012c, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012d, code lost:
    
        r1 = r14;
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0115, code lost:
    
        r14 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0131 A[Catch: all -> 0x014a, TRY_ENTER, TryCatch #3 {all -> 0x014a, blocks: (B:15:0x0131, B:20:0x013e), top: B:13:0x012f }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x013e A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #3 {all -> 0x014a, blocks: (B:15:0x0131, B:20:0x013e), top: B:13:0x012f }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f7 A[Catch: all -> 0x0110, TRY_ENTER, TryCatch #0 {all -> 0x0110, blocks: (B:29:0x00f7, B:33:0x0104), top: B:27:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0104 A[Catch: all -> 0x0110, TRY_LEAVE, TryCatch #0 {all -> 0x0110, blocks: (B:29:0x00f7, B:33:0x0104), top: B:27:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b1 A[Catch: all -> 0x014f, TRY_ENTER, TryCatch #4 {all -> 0x014f, blocks: (B:56:0x00b1, B:57:0x00c0, B:67:0x00bb), top: B:54:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb A[Catch: all -> 0x014f, TryCatch #4 {all -> 0x014f, blocks: (B:56:0x00b1, B:57:0x00c0, B:67:0x00bb), top: B:54:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.bytedance.kmp.network.IKmpNetworkService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(Request request, Continuation<? super Response> continuation) {
        KmpNativeNetworkService$execute$1 kmpNativeNetworkService$execute$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        NativeRequest buildNativeRequest;
        SsHttpCall ssHttpCall;
        Request request2;
        int i2;
        Mutex mutex;
        Mutex mutex2;
        Request request3;
        Throwable th;
        Mutex mutex3;
        Request request4;
        Response response;
        try {
            if (continuation instanceof KmpNativeNetworkService$execute$1) {
                kmpNativeNetworkService$execute$1 = (KmpNativeNetworkService$execute$1) continuation;
                if ((kmpNativeNetworkService$execute$1.label & Integer.MIN_VALUE) != 0) {
                    kmpNativeNetworkService$execute$1.label -= Integer.MIN_VALUE;
                    obj = kmpNativeNetworkService$execute$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = kmpNativeNetworkService$execute$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        buildNativeRequest = buildNativeRequest(request);
                        SsHttpCall call = NativeTTNetworkClient.INSTANCE.getCall();
                        int requestTrackingId = requestTrackingId(request);
                        Mutex mutex4 = this.requestMapMutex;
                        kmpNativeNetworkService$execute$1.L$0 = request;
                        kmpNativeNetworkService$execute$1.L$1 = buildNativeRequest;
                        kmpNativeNetworkService$execute$1.L$2 = call;
                        kmpNativeNetworkService$execute$1.L$3 = mutex4;
                        kmpNativeNetworkService$execute$1.I$0 = requestTrackingId;
                        kmpNativeNetworkService$execute$1.label = 1;
                        if (mutex4.lock((Object) null, kmpNativeNetworkService$execute$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ssHttpCall = call;
                        request2 = request;
                        i2 = requestTrackingId;
                        mutex = mutex4;
                    } else if (i == 1) {
                        i2 = kmpNativeNetworkService$execute$1.I$0;
                        mutex = (Mutex) kmpNativeNetworkService$execute$1.L$3;
                        ssHttpCall = (SsHttpCall) kmpNativeNetworkService$execute$1.L$2;
                        buildNativeRequest = (NativeRequest) kmpNativeNetworkService$execute$1.L$1;
                        request2 = (Request) kmpNativeNetworkService$execute$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            if (i == 3) {
                                i2 = kmpNativeNetworkService$execute$1.I$0;
                                mutex2 = (Mutex) kmpNativeNetworkService$execute$1.L$2;
                                response = (Response) kmpNativeNetworkService$execute$1.L$1;
                                request4 = (Request) kmpNativeNetworkService$execute$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                try {
                                    if (i2 <= 0) {
                                        this.callMapByRequestUuid.remove(Boxing.boxInt(i2));
                                    } else {
                                        this.kmpRequestMap.remove(request4);
                                    }
                                    return response;
                                } finally {
                                }
                            }
                            if (i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            i2 = kmpNativeNetworkService$execute$1.I$0;
                            Mutex mutex5 = (Mutex) kmpNativeNetworkService$execute$1.L$2;
                            th = (Throwable) kmpNativeNetworkService$execute$1.L$1;
                            Request request5 = (Request) kmpNativeNetworkService$execute$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            try {
                                if (i2 <= 0) {
                                    this.callMapByRequestUuid.remove(Boxing.boxInt(i2));
                                } else {
                                    this.kmpRequestMap.remove(request5);
                                }
                                throw th;
                            } finally {
                            }
                        }
                        i2 = kmpNativeNetworkService$execute$1.I$0;
                        request3 = (Request) kmpNativeNetworkService$execute$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Response convertToApiResponse = convertToApiResponse((NativeResponse) obj, request3);
                            mutex3 = this.requestMapMutex;
                            kmpNativeNetworkService$execute$1.L$0 = request3;
                            kmpNativeNetworkService$execute$1.L$1 = convertToApiResponse;
                            kmpNativeNetworkService$execute$1.L$2 = mutex3;
                            kmpNativeNetworkService$execute$1.I$0 = i2;
                            kmpNativeNetworkService$execute$1.label = 3;
                            if (mutex3.lock((Object) null, kmpNativeNetworkService$execute$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            request4 = request3;
                            mutex2 = mutex3;
                            response = convertToApiResponse;
                            if (i2 <= 0) {
                            }
                            return response;
                        } catch (Throwable th2) {
                            th = th2;
                            request2 = request3;
                            th = th;
                            Mutex mutex6 = this.requestMapMutex;
                            kmpNativeNetworkService$execute$1.L$0 = request2;
                            kmpNativeNetworkService$execute$1.L$1 = th;
                            kmpNativeNetworkService$execute$1.L$2 = mutex6;
                            kmpNativeNetworkService$execute$1.L$3 = null;
                            kmpNativeNetworkService$execute$1.I$0 = i2;
                            kmpNativeNetworkService$execute$1.label = 4;
                            if (mutex6.lock((Object) null, kmpNativeNetworkService$execute$1) != coroutine_suspended) {
                            }
                        }
                    }
                    if (i2 <= 0) {
                        this.callMapByRequestUuid.put(Boxing.boxInt(i2), ssHttpCall);
                    } else {
                        this.kmpRequestMap.put(request2, ssHttpCall);
                    }
                    Unit unit = Unit.INSTANCE;
                    kmpNativeNetworkService$execute$1.L$0 = request2;
                    kmpNativeNetworkService$execute$1.L$1 = null;
                    kmpNativeNetworkService$execute$1.L$2 = null;
                    kmpNativeNetworkService$execute$1.L$3 = null;
                    kmpNativeNetworkService$execute$1.I$0 = i2;
                    kmpNativeNetworkService$execute$1.label = 2;
                    obj = ssHttpCall.execute(buildNativeRequest, kmpNativeNetworkService$execute$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request3 = request2;
                    Response convertToApiResponse2 = convertToApiResponse((NativeResponse) obj, request3);
                    mutex3 = this.requestMapMutex;
                    kmpNativeNetworkService$execute$1.L$0 = request3;
                    kmpNativeNetworkService$execute$1.L$1 = convertToApiResponse2;
                    kmpNativeNetworkService$execute$1.L$2 = mutex3;
                    kmpNativeNetworkService$execute$1.I$0 = i2;
                    kmpNativeNetworkService$execute$1.label = 3;
                    if (mutex3.lock((Object) null, kmpNativeNetworkService$execute$1) != coroutine_suspended) {
                    }
                }
            }
            if (i2 <= 0) {
            }
            Unit unit2 = Unit.INSTANCE;
            kmpNativeNetworkService$execute$1.L$0 = request2;
            kmpNativeNetworkService$execute$1.L$1 = null;
            kmpNativeNetworkService$execute$1.L$2 = null;
            kmpNativeNetworkService$execute$1.L$3 = null;
            kmpNativeNetworkService$execute$1.I$0 = i2;
            kmpNativeNetworkService$execute$1.label = 2;
            obj = ssHttpCall.execute(buildNativeRequest, kmpNativeNetworkService$execute$1);
            if (obj != coroutine_suspended) {
            }
        } finally {
        }
        kmpNativeNetworkService$execute$1 = new KmpNativeNetworkService$execute$1(this, continuation);
        obj = kmpNativeNetworkService$execute$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kmpNativeNetworkService$execute$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[Catch: all -> 0x00b2, TRY_ENTER, TryCatch #0 {all -> 0x00b2, blocks: (B:19:0x0081, B:20:0x0090, B:25:0x008b), top: B:17:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:19:0x0081, B:20:0x0090, B:25:0x008b), top: B:17:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.bytedance.kmp.network.IKmpNetworkService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object executeStream(Request request, ResponseCallback responseCallback, Continuation<? super Unit> continuation) {
        KmpNativeNetworkService$executeStream$1 kmpNativeNetworkService$executeStream$1;
        Object coroutine_suspended;
        int i;
        SsHttpCall call;
        NativeRequest nativeRequest;
        Request request2;
        int i2;
        ResponseCallback responseCallback2;
        Mutex mutex;
        KmpNativeNetworkService$executeStream$3 kmpNativeNetworkService$executeStream$3;
        try {
            if (continuation instanceof KmpNativeNetworkService$executeStream$1) {
                kmpNativeNetworkService$executeStream$1 = (KmpNativeNetworkService$executeStream$1) continuation;
                if ((kmpNativeNetworkService$executeStream$1.label & Integer.MIN_VALUE) != 0) {
                    kmpNativeNetworkService$executeStream$1.label -= Integer.MIN_VALUE;
                    Object obj = kmpNativeNetworkService$executeStream$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = kmpNativeNetworkService$executeStream$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        NativeRequest buildNativeRequest = buildNativeRequest(request);
                        call = NativeTTNetworkClient.INSTANCE.getCall();
                        int requestTrackingId = requestTrackingId(request);
                        Mutex mutex2 = this.requestMapMutex;
                        kmpNativeNetworkService$executeStream$1.L$0 = request;
                        kmpNativeNetworkService$executeStream$1.L$1 = responseCallback;
                        kmpNativeNetworkService$executeStream$1.L$2 = buildNativeRequest;
                        kmpNativeNetworkService$executeStream$1.L$3 = call;
                        kmpNativeNetworkService$executeStream$1.L$4 = mutex2;
                        kmpNativeNetworkService$executeStream$1.I$0 = requestTrackingId;
                        kmpNativeNetworkService$executeStream$1.label = 1;
                        if (mutex2.lock((Object) null, kmpNativeNetworkService$executeStream$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        nativeRequest = buildNativeRequest;
                        request2 = request;
                        i2 = requestTrackingId;
                        responseCallback2 = responseCallback;
                        mutex = mutex2;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        i2 = kmpNativeNetworkService$executeStream$1.I$0;
                        mutex = (Mutex) kmpNativeNetworkService$executeStream$1.L$4;
                        call = (SsHttpCall) kmpNativeNetworkService$executeStream$1.L$3;
                        nativeRequest = (NativeRequest) kmpNativeNetworkService$executeStream$1.L$2;
                        responseCallback2 = (ResponseCallback) kmpNativeNetworkService$executeStream$1.L$1;
                        request2 = (Request) kmpNativeNetworkService$executeStream$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (i2 <= 0) {
                        this.callMapByRequestUuid.put(Boxing.boxInt(i2), call);
                    } else {
                        this.kmpRequestMap.put(request2, call);
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    kmpNativeNetworkService$executeStream$3 = new KmpNativeNetworkService$executeStream$3(this, request2, responseCallback2, i2);
                    kmpNativeNetworkService$executeStream$1.L$0 = null;
                    kmpNativeNetworkService$executeStream$1.L$1 = null;
                    kmpNativeNetworkService$executeStream$1.L$2 = null;
                    kmpNativeNetworkService$executeStream$1.L$3 = null;
                    kmpNativeNetworkService$executeStream$1.L$4 = null;
                    kmpNativeNetworkService$executeStream$1.label = 2;
                    if (call.executeStream(nativeRequest, kmpNativeNetworkService$executeStream$3, kmpNativeNetworkService$executeStream$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i2 <= 0) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock((Object) null);
            kmpNativeNetworkService$executeStream$3 = new KmpNativeNetworkService$executeStream$3(this, request2, responseCallback2, i2);
            kmpNativeNetworkService$executeStream$1.L$0 = null;
            kmpNativeNetworkService$executeStream$1.L$1 = null;
            kmpNativeNetworkService$executeStream$1.L$2 = null;
            kmpNativeNetworkService$executeStream$1.L$3 = null;
            kmpNativeNetworkService$executeStream$1.L$4 = null;
            kmpNativeNetworkService$executeStream$1.label = 2;
            if (call.executeStream(nativeRequest, kmpNativeNetworkService$executeStream$3, kmpNativeNetworkService$executeStream$1) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        kmpNativeNetworkService$executeStream$1 = new KmpNativeNetworkService$executeStream$1(this, continuation);
        Object obj2 = kmpNativeNetworkService$executeStream$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kmpNativeNetworkService$executeStream$1.label;
        if (i != 0) {
        }
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public void cancel(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new KmpNativeNetworkService$cancel$1(this, request, null), 3, (Object) null);
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public void preConnect(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        NativeTTNetworkClient.INSTANCE.preConnect(url);
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public void registerNQEListener(final NQEListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        NativeTTNetworkClient.INSTANCE.registerNQEListener(new NativeNQEListener() { // from class: com.bytedance.kmp.network.cinterop.KmpNativeNetworkService$registerNQEListener$1
            public void onRTTOrThroughputEstimatesComputed(int httpRttMs, int transportRttMs, int downstreamThroughputKbps) {
                NQEListener.this.onRTTOrThroughputEstimatesComputed(httpRttMs, transportRttMs, downstreamThroughputKbps);
            }

            public void onEffectiveConnectionTypeChanged(int type) {
                NQEListener.this.onEffectiveConnectionTypeChanged(EffectiveConnectionType.INSTANCE.fromInt(type));
            }

            public void onPacketLossComputed(int protocol, double upstreamLossRate, double upstreamLossRateVariance, double downstreamLossRate, double downstreamLossRateVariance) {
                NQEListener.this.onPacketLossComputed(protocol, upstreamLossRate, upstreamLossRateVariance, downstreamLossRate, downstreamLossRateVariance);
            }
        });
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public Object getNetworkQualityState(Continuation<? super NetworkQualityState> continuation) {
        int effectiveConnectionType = NativeTTNetworkClient.INSTANCE.getEffectiveConnectionType();
        NativeRTTAndThroughput rTTAndThroughput = NativeTTNetworkClient.INSTANCE.getRTTAndThroughput();
        NativePacketLostStats packetLostStats = NativeTTNetworkClient.INSTANCE.getPacketLostStats();
        return new NetworkQualityState(EffectiveConnectionType.INSTANCE.fromInt(effectiveConnectionType), new RttAndThroughput(rTTAndThroughput != null ? rTTAndThroughput.getHttpRttMs() : -1, rTTAndThroughput != null ? rTTAndThroughput.getTransportRttMs() : -1, rTTAndThroughput != null ? rTTAndThroughput.getDownstreamThroughputKbps() : -1), null, new PacketLoss(packetLostStats != null ? packetLostStats.getProtocol() : -1, packetLostStats != null ? packetLostStats.getUpstreamLossRate() : -1.0d, packetLostStats != null ? packetLostStats.getUpstreamLossRateVariance() : -1.0d, packetLostStats != null ? packetLostStats.getDownstreamLossRate() : -1.0d, packetLostStats != null ? packetLostStats.getDownstreamLossRateVariance() : -1.0d), 4, null);
    }
}
