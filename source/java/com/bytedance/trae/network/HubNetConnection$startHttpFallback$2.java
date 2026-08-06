package com.bytedance.trae.network;

import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection$startHttpFallback$2", f = "HubNetConnection.kt", i = {0, 0, 1, 1, 2, 2}, l = {1288, 1289, 1304}, m = "invokeSuspend", n = {"$this$launch", "consecutiveFailures", "$this$launch", "consecutiveFailures", "$this$launch", "consecutiveFailures"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnection$startHttpFallback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HubNetConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$startHttpFallback$2(HubNetConnection hubNetConnection, Continuation<? super HubNetConnection$startHttpFallback$2> continuation) {
        super(2, continuation);
        this.this$0 = hubNetConnection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hubNetConnection$startHttpFallback$2 = new HubNetConnection$startHttpFallback$2(this.this$0, continuation);
        hubNetConnection$startHttpFallback$2.L$0 = obj;
        return hubNetConnection$startHttpFallback$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        r2 = r9;
        r9 = r10;
        r10 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f2 -> B:8:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        int i;
        Object obj2;
        HubNetConnection$startHttpFallback$2 hubNetConnection$startHttpFallback$2;
        long j;
        TransportMode transportMode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            i = 0;
        } else if (i2 == 1) {
            int i3 = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i3;
            hubNetConnection$startHttpFallback$2 = this;
            HubNetConnection hubNetConnection = hubNetConnection$startHttpFallback$2.this$0;
            j = hubNetConnection.nextExpectedDownSeq;
            hubNetConnection$startHttpFallback$2.L$0 = coroutineScope;
            hubNetConnection$startHttpFallback$2.I$0 = i;
            hubNetConnection$startHttpFallback$2.label = 2;
            obj2 = hubNetConnection.pollViaHttp(j - 1, (Continuation) hubNetConnection$startHttpFallback$2);
            if (obj2 != coroutine_suspended) {
            }
        } else {
            if (i2 == 2) {
                int i4 = this.I$0;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                CoroutineScope coroutineScope3 = coroutineScope2;
                HubNetConnection$startHttpFallback$2 hubNetConnection$startHttpFallback$22 = this;
                List list = (List) obj2;
                if (list != null) {
                    if (!list.isEmpty()) {
                        hubNetConnection$startHttpFallback$22.this$0.dispatch(list, true);
                    }
                    hubNetConnection$startHttpFallback$2 = hubNetConnection$startHttpFallback$22;
                    coroutineScope = coroutineScope3;
                    i = 0;
                } else {
                    int i5 = i4 + 1;
                    long coerceAtMost = RangesKt.coerceAtMost((1 << RangesKt.coerceAtMost(i5 - 1, 30)) * 3, 180L);
                    FLogger.INSTANCE.mo430w("HubNetConnection", "HTTP poll backoff: " + coerceAtMost + "s after " + i5 + " consecutive failures");
                    hubNetConnection$startHttpFallback$22.L$0 = coroutineScope3;
                    hubNetConnection$startHttpFallback$22.I$0 = i5;
                    hubNetConnection$startHttpFallback$22.label = 3;
                    if (DelayKt.delay(coerceAtMost * BytePatchException.ErrorCode.paramsError, (Continuation) hubNetConnection$startHttpFallback$22) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    CoroutineScope coroutineScope4 = coroutineScope3;
                    i = i5;
                    hubNetConnection$startHttpFallback$2 = hubNetConnection$startHttpFallback$22;
                    coroutineScope = coroutineScope4;
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    transportMode = hubNetConnection$startHttpFallback$2.this$0.transportMode;
                    if (transportMode == TransportMode.HTTP_FALLBACK) {
                        hubNetConnection$startHttpFallback$2.L$0 = coroutineScope;
                        hubNetConnection$startHttpFallback$2.I$0 = i;
                        hubNetConnection$startHttpFallback$2.label = 1;
                        if (DelayKt.delay(OnlineTracing.DATA_TIMEOUT, (Continuation) hubNetConnection$startHttpFallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        HubNetConnection hubNetConnection2 = hubNetConnection$startHttpFallback$2.this$0;
                        j = hubNetConnection2.nextExpectedDownSeq;
                        hubNetConnection$startHttpFallback$2.L$0 = coroutineScope;
                        hubNetConnection$startHttpFallback$2.I$0 = i;
                        hubNetConnection$startHttpFallback$2.label = 2;
                        obj2 = hubNetConnection2.pollViaHttp(j - 1, (Continuation) hubNetConnection$startHttpFallback$2);
                        if (obj2 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        CoroutineScope coroutineScope5 = coroutineScope;
                        hubNetConnection$startHttpFallback$22 = hubNetConnection$startHttpFallback$2;
                        i4 = i;
                        coroutineScope3 = coroutineScope5;
                        List list2 = (List) obj2;
                        if (list2 != null) {
                        }
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i6;
        }
        hubNetConnection$startHttpFallback$2 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
        return Unit.INSTANCE;
    }
}
