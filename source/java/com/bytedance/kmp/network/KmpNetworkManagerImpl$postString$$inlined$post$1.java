package com.bytedance.kmp.network;

import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.requet.RequestBody;
import com.bytedance.kmp.network.requet.RequestContext;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseBodyConvertor;
import com.bytedance.kmp.network.response.ResponseBodyConvertorFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/bytedance/kmp/network/KmpNetworkManagerImpl$post$2"}, k = 3, mv = {1, 7, 0}, xi = 176)
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl$post$2", f = "KmpNetworkManagerImpl.kt", i = {1, 2, 2, 3}, l = {133, 409, 418, 421}, m = "invokeSuspend", n = {"request", "request", "response$iv", "body$iv"}, s = {"L$0", "L$0", "L$1", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkManagerImpl$postString$$inlined$post$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Map $header;
    final /* synthetic */ Map $queries;
    final /* synthetic */ RequestBody $requestBody;
    final /* synthetic */ RequestContext $requestContext;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ KmpNetworkManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNetworkManagerImpl$postString$$inlined$post$1(String str, Map map, Map map2, RequestBody requestBody, RequestContext requestContext, KmpNetworkManagerImpl kmpNetworkManagerImpl, Continuation continuation) {
        super(2, continuation);
        this.$url = str;
        this.$queries = map;
        this.$header = map2;
        this.$requestBody = requestBody;
        this.$requestContext = requestContext;
        this.this$0 = kmpNetworkManagerImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpNetworkManagerImpl$postString$$inlined$post$1<>(this.$url, this.$queries, this.$header, this.$requestBody, this.$requestContext, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Request request;
        Object execute;
        Object execute$default;
        Response response;
        ResponseBodyConvertor<?> responseBodyConvertor;
        Object obj2;
        Request request2;
        Response response2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KmpRequestMetrics kmpRequestMetrics = new KmpRequestMetrics();
            kmpRequestMetrics.recordRequestStartTime();
            String appendUnEncodedQueryToUrl = UrlEncoderUtil.INSTANCE.appendUnEncodedQueryToUrl(this.$url, this.$queries);
            Map map = this.$header;
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            Map map2 = map;
            RequestBody requestBody = this.$requestBody;
            RequestContext requestContext = this.$requestContext;
            if (requestContext == null) {
                requestContext = new RequestContext();
            }
            request = new Request(appendUnEncodedQueryToUrl, "POST", map2, requestBody, requestContext, kmpRequestMetrics);
            Intrinsics.reifiedOperationMarker(4, "T?");
            if (Object.class == Response.class) {
                this.label = 1;
                execute$default = KmpNetworkManagerImpl.execute$default(this.this$0, request, false, (Continuation) this, 2, null);
                if (execute$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Intrinsics.reifiedOperationMarker(1, "T?");
                return execute$default;
            }
            KmpNetworkManagerImpl kmpNetworkManagerImpl = this.this$0;
            request.getKmpRequestMetrics().recordRequestStartTime();
            this.L$0 = request;
            this.label = 2;
            execute = kmpNetworkManagerImpl.execute(request, false, (Continuation) this);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            response = (Response) execute;
            request.getKmpRequestMetrics().recordResponseDecodeStartTime();
            responseBodyConvertor = request.getReqContext().getResponseBodyConvertor();
            if (responseBodyConvertor == null) {
            }
            if (response.getBody() == null) {
            }
        } else {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                execute$default = obj;
                Intrinsics.reifiedOperationMarker(1, "T?");
                return execute$default;
            }
            if (i == 2) {
                request = (Request) this.L$0;
                ResultKt.throwOnFailure(obj);
                execute = obj;
                response = (Response) execute;
                request.getKmpRequestMetrics().recordResponseDecodeStartTime();
                responseBodyConvertor = request.getReqContext().getResponseBodyConvertor();
                if (responseBodyConvertor == null) {
                    ResponseBodyConvertorFactory responseBodyConvertorFactory = ResponseBodyConvertorFactory.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "T?");
                    responseBodyConvertor = responseBodyConvertorFactory.create(null);
                }
                if (response.getBody() == null) {
                    this.L$0 = request;
                    this.L$1 = response;
                    this.label = 3;
                    obj2 = responseBodyConvertor.convert(response.getBody(), (Continuation) this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    response2 = response;
                    Intrinsics.reifiedOperationMarker(1, "T?");
                    Request request3 = request2;
                    response = response2;
                    request = request3;
                    request.getKmpRequestMetrics().recordResponseDecodeEndTime();
                    this.L$0 = obj2;
                    this.L$1 = null;
                    this.label = 4;
                    if (request.getKmpRequestMetrics().recordRequestEndTimeAndReport(request, response, (Continuation) this) == coroutine_suspended) {
                    }
                } else {
                    obj2 = null;
                    request.getKmpRequestMetrics().recordResponseDecodeEndTime();
                    this.L$0 = obj2;
                    this.L$1 = null;
                    this.label = 4;
                    if (request.getKmpRequestMetrics().recordRequestEndTimeAndReport(request, response, (Continuation) this) == coroutine_suspended) {
                    }
                }
            } else if (i == 3) {
                response2 = (Response) this.L$1;
                Request request4 = (Request) this.L$0;
                ResultKt.throwOnFailure(obj);
                request2 = request4;
                obj2 = obj;
                Intrinsics.reifiedOperationMarker(1, "T?");
                Request request32 = request2;
                response = response2;
                request = request32;
                request.getKmpRequestMetrics().recordResponseDecodeEndTime();
                this.L$0 = obj2;
                this.L$1 = null;
                this.label = 4;
                if (request.getKmpRequestMetrics().recordRequestEndTimeAndReport(request, response, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj3 = obj2;
            } else {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj3 = this.L$0;
                ResultKt.throwOnFailure(obj);
            }
        }
        return obj3;
    }
}
