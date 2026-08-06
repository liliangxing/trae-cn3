package com.bytedance.kmp.network.cinterop;

import com.bytedance.kmp.network.requet.Request;
import com.example.interopdemo.SsHttpCall;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: KmpNativeNetworkService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.KmpNativeNetworkService$cancel$1", f = "KmpNativeNetworkService.kt", i = {0, 0}, l = {301}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "requestId"}, s = {"L$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class KmpNativeNetworkService$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Request $request;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ KmpNativeNetworkService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNativeNetworkService$cancel$1(KmpNativeNetworkService kmpNativeNetworkService, Request request, Continuation<? super KmpNativeNetworkService$cancel$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpNativeNetworkService;
        this.$request = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpNativeNetworkService$cancel$1(this.this$0, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int requestTrackingId;
        Mutex mutex;
        int i;
        KmpNativeNetworkService kmpNativeNetworkService;
        Request request;
        Map map;
        SsHttpCall ssHttpCall;
        Map map2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            requestTrackingId = this.this$0.requestTrackingId(this.$request);
            mutex = this.this$0.requestMapMutex;
            KmpNativeNetworkService kmpNativeNetworkService2 = this.this$0;
            Request request2 = this.$request;
            this.L$0 = mutex;
            this.L$1 = kmpNativeNetworkService2;
            this.L$2 = request2;
            this.I$0 = requestTrackingId;
            this.label = 1;
            if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = requestTrackingId;
            kmpNativeNetworkService = kmpNativeNetworkService2;
            request = request2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            request = (Request) this.L$2;
            kmpNativeNetworkService = (KmpNativeNetworkService) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (i > 0) {
                map2 = kmpNativeNetworkService.callMapByRequestUuid;
                ssHttpCall = (SsHttpCall) map2.get(Boxing.boxInt(i));
            } else {
                map = kmpNativeNetworkService.kmpRequestMap;
                ssHttpCall = (SsHttpCall) map.get(request);
            }
            if (ssHttpCall != null) {
                ssHttpCall.cancel();
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock((Object) null);
        }
    }
}
