package com.bytedance.trae.network;

import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection$startSseBackgroundRetry$1", f = "HubNetConnection.kt", i = {0, 1}, l = {708, 712}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnection$startSseBackgroundRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HubNetConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$startSseBackgroundRetry$1(HubNetConnection hubNetConnection, Continuation<? super HubNetConnection$startSseBackgroundRetry$1> continuation) {
        super(2, continuation);
        this.this$0 = hubNetConnection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hubNetConnection$startSseBackgroundRetry$1 = new HubNetConnection$startSseBackgroundRetry$1(this.this$0, continuation);
        hubNetConnection$startSseBackgroundRetry$1.L$0 = obj;
        return hubNetConnection$startSseBackgroundRetry$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0079 -> B:6:0x007c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        HubNetConnection$startSseBackgroundRetry$1 hubNetConnection$startSseBackgroundRetry$1;
        TransportMode transportMode;
        boolean z;
        SseConnection sseConnection;
        TransportMode transportMode2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(60000L, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                hubNetConnection$startSseBackgroundRetry$1 = this;
                transportMode2 = hubNetConnection$startSseBackgroundRetry$1.this$0.transportMode;
                if (transportMode2 == TransportMode.SSE) {
                    FLogger.INSTANCE.mo428i("HubNetConnection", "sseBackgroundRetry: SSE restored, stopping");
                    return Unit.INSTANCE;
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    transportMode = hubNetConnection$startSseBackgroundRetry$1.this$0.transportMode;
                    if (transportMode == TransportMode.HTTP_FALLBACK) {
                        z = hubNetConnection$startSseBackgroundRetry$1.this$0.isToB;
                        if (z) {
                            FLogger.INSTANCE.mo428i("HubNetConnection", "sseBackgroundRetry: attempting SSE reconnect");
                            sseConnection = hubNetConnection$startSseBackgroundRetry$1.this$0.sseConnection;
                            if (sseConnection != null) {
                                sseConnection.connect();
                            }
                            hubNetConnection$startSseBackgroundRetry$1.L$0 = coroutineScope;
                            hubNetConnection$startSseBackgroundRetry$1.label = 2;
                            if (DelayKt.delay(60000L, (Continuation) hubNetConnection$startSseBackgroundRetry$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            transportMode2 = hubNetConnection$startSseBackgroundRetry$1.this$0.transportMode;
                            if (transportMode2 == TransportMode.SSE) {
                            }
                            if (CoroutineScopeKt.isActive(coroutineScope)) {
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        hubNetConnection$startSseBackgroundRetry$1 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
        return Unit.INSTANCE;
    }
}
