package com.bytedance.trae.network;

import com.bytedance.platform.thread.Constants;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection$checkAliveAndReconnect$1", f = "HubNetConnection.kt", i = {}, l = {541, 548, 550}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class HubNetConnection$checkAliveAndReconnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HubNetConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$checkAliveAndReconnect$1(HubNetConnection hubNetConnection, Continuation<? super HubNetConnection$checkAliveAndReconnect$1> continuation) {
        super(2, continuation);
        this.this$0 = hubNetConnection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HubNetConnection$checkAliveAndReconnect$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x009a, code lost:
    
        if (r0.isReallyAlive() == true) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0161 A[Catch: all -> 0x0182, TryCatch #0 {all -> 0x0182, blocks: (B:18:0x0159, B:20:0x0161, B:22:0x0169, B:24:0x0177, B:25:0x017a), top: B:17:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0129 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReentrantLock reentrantLock;
        TransportMode transportMode;
        TransportMode transportMode2;
        TransportMode transportMode3;
        TransportMode transportMode4;
        TransportMode transportMode5;
        boolean z;
        FrontierConnection frontierConnection;
        boolean z2;
        boolean z3;
        FrontierConnection frontierConnection2;
        SseConnection sseConnection;
        SseConnection sseConnection2;
        SseConnection sseConnection3;
        SseConnection sseConnection4;
        FrontierConnection frontierConnection3;
        ReentrantLock reentrantLock2;
        HubNetConnection hubNetConnection;
        TransportMode transportMode6;
        TransportMode transportMode7;
        boolean z4;
        FrontierConnection frontierConnection4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z5 = false;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                sseConnection4 = this.this$0.sseConnection;
                if (sseConnection4 != null && sseConnection4.isReallyAlive()) {
                    z5 = true;
                }
                if (z5) {
                    FLogger.INSTANCE.mo428i("HubNetConnection", "checkAlive: SSE reconnected successfully");
                    return Unit.INSTANCE;
                }
                FLogger.INSTANCE.mo430w("HubNetConnection", "checkAlive: reconnect failed, falling back to HTTP poll");
                reentrantLock2 = this.this$0.modeLock;
                ReentrantLock reentrantLock3 = reentrantLock2;
                hubNetConnection = this.this$0;
                reentrantLock3.lock();
                transportMode6 = hubNetConnection.transportMode;
                if (transportMode6 != TransportMode.HTTP_FALLBACK) {
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock3.unlock();
                return Unit.INSTANCE;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                frontierConnection3 = this.this$0.frontier;
                if (frontierConnection3 != null) {
                    frontierConnection3.connect("checkAlive_reconnect");
                }
                this.label = 3;
                if (DelayKt.delay(Constants.TASK_RUN_THRESHOLD, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                frontierConnection4 = this.this$0.frontier;
                if (frontierConnection4 != null) {
                    z5 = true;
                }
                if (z5) {
                }
                FLogger.INSTANCE.mo430w("HubNetConnection", "checkAlive: reconnect failed, falling back to HTTP poll");
                reentrantLock2 = this.this$0.modeLock;
                ReentrantLock reentrantLock32 = reentrantLock2;
                hubNetConnection = this.this$0;
                reentrantLock32.lock();
                transportMode6 = hubNetConnection.transportMode;
                if (transportMode6 != TransportMode.HTTP_FALLBACK) {
                }
                Unit unit2 = Unit.INSTANCE;
                reentrantLock32.unlock();
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            frontierConnection4 = this.this$0.frontier;
            if (frontierConnection4 != null && frontierConnection4.isReallyAlive()) {
                z5 = true;
            }
            if (z5) {
                FLogger.INSTANCE.mo428i("HubNetConnection", "checkAlive: Frontier reconnected successfully");
                return Unit.INSTANCE;
            }
            FLogger.INSTANCE.mo430w("HubNetConnection", "checkAlive: reconnect failed, falling back to HTTP poll");
            reentrantLock2 = this.this$0.modeLock;
            ReentrantLock reentrantLock322 = reentrantLock2;
            hubNetConnection = this.this$0;
            reentrantLock322.lock();
            try {
                transportMode6 = hubNetConnection.transportMode;
                if (transportMode6 != TransportMode.HTTP_FALLBACK) {
                    transportMode7 = hubNetConnection.transportMode;
                    if (transportMode7 != TransportMode.SHUTDOWN) {
                        hubNetConnection.transportMode = TransportMode.HTTP_FALLBACK;
                        hubNetConnection.startHttpFallback();
                        z4 = hubNetConnection.isToB;
                        if (z4) {
                            hubNetConnection.startSseBackgroundRetry();
                        }
                    }
                }
                Unit unit22 = Unit.INSTANCE;
                reentrantLock322.unlock();
                return Unit.INSTANCE;
            } finally {
            }
        }
        ResultKt.throwOnFailure(obj);
        reentrantLock = this.this$0.modeLock;
        HubNetConnection hubNetConnection2 = this.this$0;
        reentrantLock.lock();
        try {
            transportMode = hubNetConnection2.transportMode;
            if (transportMode != TransportMode.SHUTDOWN) {
                transportMode3 = hubNetConnection2.transportMode;
                if (transportMode3 != TransportMode.IDLE) {
                    transportMode4 = hubNetConnection2.transportMode;
                    if (transportMode4 != TransportMode.CONNECTING) {
                        transportMode5 = hubNetConnection2.transportMode;
                        if (transportMode5 != TransportMode.HTTP_FALLBACK) {
                            z = hubNetConnection2.isToB;
                            if (z) {
                                sseConnection3 = hubNetConnection2.sseConnection;
                                if (sseConnection3 != null && sseConnection3.isReallyAlive()) {
                                    z2 = true;
                                }
                                z2 = false;
                            } else {
                                frontierConnection = hubNetConnection2.frontier;
                                if (frontierConnection != null) {
                                }
                                z2 = false;
                            }
                            if (z2) {
                                FLogger.INSTANCE.mo425d("HubNetConnection", "checkAlive: transport alive, skip");
                                return Unit.INSTANCE;
                            }
                            FLogger.INSTANCE.mo430w("HubNetConnection", "checkAlive: transport NOT alive, attempting reconnect");
                            z3 = this.this$0.isToB;
                            if (z3) {
                                sseConnection = this.this$0.sseConnection;
                                if (sseConnection != null) {
                                    sseConnection.disconnect();
                                }
                                sseConnection2 = this.this$0.sseConnection;
                                if (sseConnection2 != null) {
                                    sseConnection2.connect();
                                }
                                this.label = 1;
                                if (DelayKt.delay(Constants.TASK_RUN_THRESHOLD, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                sseConnection4 = this.this$0.sseConnection;
                                if (sseConnection4 != null) {
                                    z5 = true;
                                }
                                if (z5) {
                                }
                                FLogger.INSTANCE.mo430w("HubNetConnection", "checkAlive: reconnect failed, falling back to HTTP poll");
                                reentrantLock2 = this.this$0.modeLock;
                                ReentrantLock reentrantLock3222 = reentrantLock2;
                                hubNetConnection = this.this$0;
                                reentrantLock3222.lock();
                                transportMode6 = hubNetConnection.transportMode;
                                if (transportMode6 != TransportMode.HTTP_FALLBACK) {
                                }
                                Unit unit222 = Unit.INSTANCE;
                                reentrantLock3222.unlock();
                                return Unit.INSTANCE;
                            }
                            frontierConnection2 = this.this$0.frontier;
                            if (frontierConnection2 != null) {
                                frontierConnection2.disconnect("checkAlive_reconnect");
                            }
                            this.label = 2;
                            if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            frontierConnection3 = this.this$0.frontier;
                            if (frontierConnection3 != null) {
                            }
                            this.label = 3;
                            if (DelayKt.delay(Constants.TASK_RUN_THRESHOLD, (Continuation) this) == coroutine_suspended) {
                            }
                            frontierConnection4 = this.this$0.frontier;
                            if (frontierConnection4 != null) {
                            }
                            if (z5) {
                            }
                            FLogger.INSTANCE.mo430w("HubNetConnection", "checkAlive: reconnect failed, falling back to HTTP poll");
                            reentrantLock2 = this.this$0.modeLock;
                            ReentrantLock reentrantLock32222 = reentrantLock2;
                            hubNetConnection = this.this$0;
                            reentrantLock32222.lock();
                            transportMode6 = hubNetConnection.transportMode;
                            if (transportMode6 != TransportMode.HTTP_FALLBACK) {
                            }
                            Unit unit2222 = Unit.INSTANCE;
                            reentrantLock32222.unlock();
                            return Unit.INSTANCE;
                        }
                        FLogger.INSTANCE.mo425d("HubNetConnection", "checkAlive: already HTTP_FALLBACK, skip");
                        return Unit.INSTANCE;
                    }
                    FLogger.INSTANCE.mo425d("HubNetConnection", "checkAlive: initial connection guarded by timeout job, skip");
                    return Unit.INSTANCE;
                }
            }
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("checkAlive: mode=");
            transportMode2 = hubNetConnection2.transportMode;
            fLogger.mo425d("HubNetConnection", sb.append(transportMode2).append(", skip").toString());
            return Unit.INSTANCE;
        } finally {
        }
    }
}
