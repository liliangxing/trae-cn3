package com.bytedance.trae.network;

import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.trae.utils.logger.FLogger;
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
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection$startHttpFallback$1", f = "HubNetConnection.kt", i = {0, 0, 1, 1, 2, 2}, l = {1267, 1268, 1280}, m = "invokeSuspend", n = {"$this$launch", "consecutiveFailures", "$this$launch", "consecutiveFailures", "$this$launch", "consecutiveFailures"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnection$startHttpFallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HubNetConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$startHttpFallback$1(HubNetConnection hubNetConnection, Continuation<? super HubNetConnection$startHttpFallback$1> continuation) {
        super(2, continuation);
        this.this$0 = hubNetConnection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hubNetConnection$startHttpFallback$1 = new HubNetConnection$startHttpFallback$1(this.this$0, continuation);
        hubNetConnection$startHttpFallback$1.L$0 = obj;
        return hubNetConnection$startHttpFallback$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0089 -> B:8:0x0047). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00df -> B:8:0x0047). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        int i;
        HubNetConnection$startHttpFallback$1 hubNetConnection$startHttpFallback$1;
        Object flushPendingViaHttp;
        TransportMode transportMode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            i = 0;
        } else if (i2 == 1) {
            i = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            hubNetConnection$startHttpFallback$1 = this;
            hubNetConnection$startHttpFallback$1.L$0 = coroutineScope;
            hubNetConnection$startHttpFallback$1.I$0 = i;
            hubNetConnection$startHttpFallback$1.label = 2;
            flushPendingViaHttp = hubNetConnection$startHttpFallback$1.this$0.flushPendingViaHttp((Continuation) hubNetConnection$startHttpFallback$1);
            if (flushPendingViaHttp != coroutine_suspended) {
            }
        } else {
            if (i2 == 2) {
                int i3 = this.I$0;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = coroutineScope2;
                int i4 = i3;
                Object obj2 = coroutine_suspended;
                HubNetConnection$startHttpFallback$1 hubNetConnection$startHttpFallback$12 = this;
                if (((Boolean) obj).booleanValue()) {
                    int i5 = i4 + 1;
                    long coerceAtMost = RangesKt.coerceAtMost((1 << RangesKt.coerceAtMost(i5 - 1, 30)) * 3, 180L);
                    FLogger.INSTANCE.mo430w("HubNetConnection", "HTTP flush backoff: " + coerceAtMost + "s after " + i5 + " consecutive failures");
                    hubNetConnection$startHttpFallback$12.L$0 = coroutineScope3;
                    hubNetConnection$startHttpFallback$12.I$0 = i5;
                    hubNetConnection$startHttpFallback$12.label = 3;
                    if (DelayKt.delay(coerceAtMost * BytePatchException.ErrorCode.paramsError, (Continuation) hubNetConnection$startHttpFallback$12) == obj2) {
                        return obj2;
                    }
                    coroutineScope = coroutineScope3;
                    Object obj3 = obj2;
                    i = i5;
                    hubNetConnection$startHttpFallback$1 = hubNetConnection$startHttpFallback$12;
                    coroutine_suspended = obj3;
                } else {
                    hubNetConnection$startHttpFallback$1 = hubNetConnection$startHttpFallback$12;
                    coroutine_suspended = obj2;
                    i = 0;
                    coroutineScope = coroutineScope3;
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    transportMode = hubNetConnection$startHttpFallback$1.this$0.transportMode;
                    if (transportMode == TransportMode.HTTP_FALLBACK) {
                        hubNetConnection$startHttpFallback$1.L$0 = coroutineScope;
                        hubNetConnection$startHttpFallback$1.I$0 = i;
                        hubNetConnection$startHttpFallback$1.label = 1;
                        if (DelayKt.delay(1000L, (Continuation) hubNetConnection$startHttpFallback$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        hubNetConnection$startHttpFallback$1.L$0 = coroutineScope;
                        hubNetConnection$startHttpFallback$1.I$0 = i;
                        hubNetConnection$startHttpFallback$1.label = 2;
                        flushPendingViaHttp = hubNetConnection$startHttpFallback$1.this$0.flushPendingViaHttp((Continuation) hubNetConnection$startHttpFallback$1);
                        if (flushPendingViaHttp != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj4 = coroutine_suspended;
                        hubNetConnection$startHttpFallback$12 = hubNetConnection$startHttpFallback$1;
                        obj = flushPendingViaHttp;
                        coroutineScope3 = coroutineScope;
                        i4 = i;
                        obj2 = obj4;
                        if (((Boolean) obj).booleanValue()) {
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
            i = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        hubNetConnection$startHttpFallback$1 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
        return Unit.INSTANCE;
    }
}
