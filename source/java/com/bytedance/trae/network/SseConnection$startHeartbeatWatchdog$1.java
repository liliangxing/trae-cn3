package com.bytedance.trae.network;

import com.bytedance.platform.thread.Constants;
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
/* compiled from: SseConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.SseConnection$startHeartbeatWatchdog$1", f = "SseConnection.kt", i = {0}, l = {469}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SseConnection$startHeartbeatWatchdog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SseConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SseConnection$startHeartbeatWatchdog$1(SseConnection sseConnection, Continuation<? super SseConnection$startHeartbeatWatchdog$1> continuation) {
        super(2, continuation);
        this.this$0 = sseConnection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sseConnection$startHeartbeatWatchdog$1 = new SseConnection$startHeartbeatWatchdog$1(this.this$0, continuation);
        sseConnection$startHeartbeatWatchdog$1.L$0 = obj;
        return sseConnection$startHeartbeatWatchdog$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0038 -> B:5:0x003b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        SseConnection$startHeartbeatWatchdog$1 sseConnection$startHeartbeatWatchdog$1;
        long j;
        SseConfig sseConfig;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            sseConnection$startHeartbeatWatchdog$1 = this;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        coroutineScope = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        sseConnection$startHeartbeatWatchdog$1 = this;
        long currentTimeMillis = System.currentTimeMillis();
        j = sseConnection$startHeartbeatWatchdog$1.this$0.lastDataReceivedTime;
        long j2 = currentTimeMillis - j;
        sseConfig = sseConnection$startHeartbeatWatchdog$1.this$0.config;
        if (j2 >= sseConfig.getHeartbeatTimeoutMs()) {
            FLogger.INSTANCE.mo430w("SseConnection", "heartbeat timeout: " + j2 + "ms, cancelling call");
            sseConnection$startHeartbeatWatchdog$1.this$0.cancelActiveCall();
            return Unit.INSTANCE;
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            sseConnection$startHeartbeatWatchdog$1.L$0 = coroutineScope;
            sseConnection$startHeartbeatWatchdog$1.label = 1;
            if (DelayKt.delay(Constants.TASK_RUN_THRESHOLD, (Continuation) sseConnection$startHeartbeatWatchdog$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            j = sseConnection$startHeartbeatWatchdog$1.this$0.lastDataReceivedTime;
            long j22 = currentTimeMillis2 - j;
            sseConfig = sseConnection$startHeartbeatWatchdog$1.this$0.config;
            if (j22 >= sseConfig.getHeartbeatTimeoutMs()) {
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        }
        return Unit.INSTANCE;
    }
}
