package com.bytedance.kmp.network;

import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/kmp/network/response/Response;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl$execute$3", f = "KmpNetworkManagerImpl.kt", i = {3}, l = {192, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_PRIMITIVE_ARRAY_NODATA_DUMP, 199, 203}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkManagerImpl$execute$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response>, Object> {
    final /* synthetic */ boolean $needReport;
    final /* synthetic */ Request $request;
    Object L$0;
    int label;
    final /* synthetic */ KmpNetworkManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNetworkManagerImpl$execute$3(Request request, KmpNetworkManagerImpl kmpNetworkManagerImpl, boolean z, Continuation<? super KmpNetworkManagerImpl$execute$3> continuation) {
        super(2, continuation);
        this.$request = request;
        this.this$0 = kmpNetworkManagerImpl;
        this.$needReport = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpNetworkManagerImpl$execute$3(this.$request, this.this$0, this.$needReport, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IKmpNetworkService iKmpNetworkService;
        Response response;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$request.getKmpRequestMetrics().recordRequestStartTime();
            this.$request.getKmpRequestMetrics().recordRequestInterceptorStartTime();
            this.label = 1;
            obj = this.this$0.preprocessRequest(this.$request, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    response = (Response) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return response;
                }
                ResultKt.throwOnFailure(obj);
                Response response2 = (Response) obj;
                this.$request.getKmpRequestMetrics().recordResponseInterceptorEndTime();
                if (!this.$needReport) {
                    return response2;
                }
                this.L$0 = response2;
                this.label = 4;
                if (this.$request.getKmpRequestMetrics().recordRequestEndTimeAndReport(this.$request, response2, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                response = response2;
                return response;
            }
            ResultKt.throwOnFailure(obj);
            this.$request.getKmpRequestMetrics().recordResponseHeaderTime();
            this.$request.getKmpRequestMetrics().recordResponseInterceptorStartTime();
            KmpNetworkManagerImpl kmpNetworkManagerImpl = this.this$0;
            this.label = 3;
            obj = kmpNetworkManagerImpl.postProcessResponse((Response) obj, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            Response response22 = (Response) obj;
            this.$request.getKmpRequestMetrics().recordResponseInterceptorEndTime();
            if (!this.$needReport) {
            }
        }
        this.$request.getKmpRequestMetrics().recordRequestInterceptorEndTime();
        iKmpNetworkService = this.this$0.service;
        this.label = 2;
        obj = iKmpNetworkService.execute((Request) obj, (Continuation) this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$request.getKmpRequestMetrics().recordResponseHeaderTime();
        this.$request.getKmpRequestMetrics().recordResponseInterceptorStartTime();
        KmpNetworkManagerImpl kmpNetworkManagerImpl2 = this.this$0;
        this.label = 3;
        obj = kmpNetworkManagerImpl2.postProcessResponse((Response) obj, (Continuation) this);
        if (obj == coroutine_suspended) {
        }
        Response response222 = (Response) obj;
        this.$request.getKmpRequestMetrics().recordResponseInterceptorEndTime();
        if (!this.$needReport) {
        }
    }
}
