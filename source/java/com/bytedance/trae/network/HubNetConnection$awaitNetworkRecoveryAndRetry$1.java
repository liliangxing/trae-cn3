package com.bytedance.trae.network;

import com.bytedance.ies.bullet.prefetchv2.PrefetchConfigKt;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection$awaitNetworkRecoveryAndRetry$1", f = "HubNetConnection.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {760, 1549, 788}, m = "invokeSuspend", n = {"$this$launch", "startTime", "maxTotalMs", "intervalMs", "$this$launch", "startTime", "maxTotalMs", "intervalMs", "$this$launch", "startTime", "maxTotalMs", "intervalMs"}, s = {"L$0", "J$0", "J$1", "J$2", "L$0", "J$0", "J$1", "J$2", "L$0", "J$0", "J$1", "J$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnection$awaitNetworkRecoveryAndRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FrontierConfig $cfg;
    final /* synthetic */ HubConnectionListener $listener;
    long J$0;
    long J$1;
    long J$2;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HubNetConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$awaitNetworkRecoveryAndRetry$1(HubNetConnection hubNetConnection, FrontierConfig frontierConfig, HubConnectionListener hubConnectionListener, Continuation<? super HubNetConnection$awaitNetworkRecoveryAndRetry$1> continuation) {
        super(2, continuation);
        this.this$0 = hubNetConnection;
        this.$cfg = frontierConfig;
        this.$listener = hubConnectionListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hubNetConnection$awaitNetworkRecoveryAndRetry$1 = new HubNetConnection$awaitNetworkRecoveryAndRetry$1(this.this$0, this.$cfg, this.$listener, continuation);
        hubNetConnection$awaitNetworkRecoveryAndRetry$1.L$0 = obj;
        return hubNetConnection$awaitNetworkRecoveryAndRetry$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01a5 A[Catch: all -> 0x01ce, TryCatch #0 {all -> 0x01ce, blocks: (B:8:0x001f, B:11:0x019d, B:13:0x01a5, B:15:0x01b1, B:17:0x01c7, B:22:0x01b5, B:23:0x006d, B:25:0x0073, B:27:0x007d, B:31:0x008e, B:36:0x017a, B:38:0x0184, B:41:0x00df, B:51:0x0041, B:54:0x0053, B:57:0x0060), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01b5 A[Catch: all -> 0x01ce, TryCatch #0 {all -> 0x01ce, blocks: (B:8:0x001f, B:11:0x019d, B:13:0x01a5, B:15:0x01b1, B:17:0x01c7, B:22:0x01b5, B:23:0x006d, B:25:0x0073, B:27:0x007d, B:31:0x008e, B:36:0x017a, B:38:0x0184, B:41:0x00df, B:51:0x0041, B:54:0x0053, B:57:0x0060), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073 A[Catch: all -> 0x01ce, TryCatch #0 {all -> 0x01ce, blocks: (B:8:0x001f, B:11:0x019d, B:13:0x01a5, B:15:0x01b1, B:17:0x01c7, B:22:0x01b5, B:23:0x006d, B:25:0x0073, B:27:0x007d, B:31:0x008e, B:36:0x017a, B:38:0x0184, B:41:0x00df, B:51:0x0041, B:54:0x0053, B:57:0x0060), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0184 A[Catch: all -> 0x01ce, TryCatch #0 {all -> 0x01ce, blocks: (B:8:0x001f, B:11:0x019d, B:13:0x01a5, B:15:0x01b1, B:17:0x01c7, B:22:0x01b5, B:23:0x006d, B:25:0x0073, B:27:0x007d, B:31:0x008e, B:36:0x017a, B:38:0x0184, B:41:0x00df, B:51:0x0041, B:54:0x0053, B:57:0x0060), top: B:2:0x000d }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x019a -> B:10:0x0028). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        long j;
        long j2;
        long currentTimeMillis;
        HubNetConnection$awaitNetworkRecoveryAndRetry$1 hubNetConnection$awaitNetworkRecoveryAndRetry$1;
        long j3;
        long j4;
        char c;
        HubNetConnection$awaitNetworkRecoveryAndRetry$1 hubNetConnection$awaitNetworkRecoveryAndRetry$12;
        HubNetConnection$awaitNetworkRecoveryAndRetry$1 hubNetConnection$awaitNetworkRecoveryAndRetry$13;
        TransportMode transportMode;
        long j5;
        HubNetConnection$awaitNetworkRecoveryAndRetry$1 hubNetConnection$awaitNetworkRecoveryAndRetry$14;
        TransportMode transportMode2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
        } catch (Throwable unused) {
            EnsureManager.ensureNotReachHere();
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            j = 2000;
            j2 = 180000;
            currentTimeMillis = System.currentTimeMillis();
            hubNetConnection$awaitNetworkRecoveryAndRetry$1 = this;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
            hubNetConnection$awaitNetworkRecoveryAndRetry$14 = hubNetConnection$awaitNetworkRecoveryAndRetry$1;
            hubNetConnection$awaitNetworkRecoveryAndRetry$14.this$0.networkRecoveryJob = null;
            return Unit.INSTANCE;
        }
        if (i == 1) {
            j5 = this.J$2;
            j4 = this.J$1;
            j3 = this.J$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            hubNetConnection$awaitNetworkRecoveryAndRetry$13 = this;
            j = j5;
            c = 2;
            transportMode = hubNetConnection$awaitNetworkRecoveryAndRetry$13.this$0.transportMode;
            if (transportMode != TransportMode.SHUTDOWN) {
            }
            hubNetConnection$awaitNetworkRecoveryAndRetry$14 = hubNetConnection$awaitNetworkRecoveryAndRetry$13;
            hubNetConnection$awaitNetworkRecoveryAndRetry$14.this$0.networkRecoveryJob = null;
            return Unit.INSTANCE;
        }
        if (i == 2) {
            long j6 = this.J$2;
            j4 = this.J$1;
            j3 = this.J$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            hubNetConnection$awaitNetworkRecoveryAndRetry$12 = this;
            j = j6;
            c = 2;
            hubNetConnection$awaitNetworkRecoveryAndRetry$13 = hubNetConnection$awaitNetworkRecoveryAndRetry$12;
            transportMode = hubNetConnection$awaitNetworkRecoveryAndRetry$13.this$0.transportMode;
            if (transportMode != TransportMode.SHUTDOWN) {
            }
            hubNetConnection$awaitNetworkRecoveryAndRetry$14 = hubNetConnection$awaitNetworkRecoveryAndRetry$13;
            hubNetConnection$awaitNetworkRecoveryAndRetry$14.this$0.networkRecoveryJob = null;
            return Unit.INSTANCE;
        }
        if (i != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j7 = this.J$2;
        j4 = this.J$1;
        j3 = this.J$0;
        coroutineScope = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        char c2 = 3;
        j = j7;
        hubNetConnection$awaitNetworkRecoveryAndRetry$13 = this;
        c = 2;
        Object registerApp = obj;
        long j8 = j4;
        currentTimeMillis = j3;
        j2 = j8;
        if (!((Boolean) registerApp).booleanValue()) {
            FLogger.INSTANCE.mo428i("HubNetConnection", "retryRegisterApp: registerApp success");
            HubConnectionListener hubConnectionListener = hubNetConnection$awaitNetworkRecoveryAndRetry$13.$listener;
            if (hubConnectionListener != null) {
                hubConnectionListener.onRegisterSuccess();
            }
            hubNetConnection$awaitNetworkRecoveryAndRetry$14 = hubNetConnection$awaitNetworkRecoveryAndRetry$13;
            hubNetConnection$awaitNetworkRecoveryAndRetry$14.this$0.networkRecoveryJob = null;
            return Unit.INSTANCE;
        }
        FLogger.INSTANCE.mo430w("HubNetConnection", "retryRegisterApp: registerApp still failed, will retry");
        hubNetConnection$awaitNetworkRecoveryAndRetry$1 = hubNetConnection$awaitNetworkRecoveryAndRetry$13;
        z = true;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            transportMode2 = hubNetConnection$awaitNetworkRecoveryAndRetry$1.this$0.transportMode;
            if (transportMode2 != TransportMode.SHUTDOWN) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 >= j2 ? z : false) {
                    FLogger.INSTANCE.mo428i("HubNetConnection", "retryRegisterApp: polling expired after " + currentTimeMillis2 + "ms, waiting for network recovery or " + PrefetchConfigKt.DEFAULT_EXPIRE_MS + "ms backoff");
                    hubNetConnection$awaitNetworkRecoveryAndRetry$1.L$0 = coroutineScope;
                    hubNetConnection$awaitNetworkRecoveryAndRetry$1.J$0 = currentTimeMillis;
                    hubNetConnection$awaitNetworkRecoveryAndRetry$1.J$1 = j2;
                    hubNetConnection$awaitNetworkRecoveryAndRetry$1.J$2 = j;
                    hubNetConnection$awaitNetworkRecoveryAndRetry$1.label = 1;
                    if (HubNetConnectionKt.awaitNetworkRecoveryOrRetryDelay(NetworkMonitor.INSTANCE.isConnected(), PrefetchConfigKt.DEFAULT_EXPIRE_MS, (Continuation) hubNetConnection$awaitNetworkRecoveryAndRetry$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hubNetConnection$awaitNetworkRecoveryAndRetry$13 = hubNetConnection$awaitNetworkRecoveryAndRetry$1;
                    j5 = j;
                    long j9 = currentTimeMillis;
                    j4 = j2;
                    j3 = j9;
                    j = j5;
                    c = 2;
                    transportMode = hubNetConnection$awaitNetworkRecoveryAndRetry$13.this$0.transportMode;
                    if (transportMode != TransportMode.SHUTDOWN) {
                        hubNetConnection$awaitNetworkRecoveryAndRetry$13.L$0 = coroutineScope;
                        hubNetConnection$awaitNetworkRecoveryAndRetry$13.J$0 = j3;
                        hubNetConnection$awaitNetworkRecoveryAndRetry$13.J$1 = j4;
                        hubNetConnection$awaitNetworkRecoveryAndRetry$13.J$2 = j;
                        c2 = 3;
                        hubNetConnection$awaitNetworkRecoveryAndRetry$13.label = 3;
                        registerApp = hubNetConnection$awaitNetworkRecoveryAndRetry$13.this$0.registerApp(hubNetConnection$awaitNetworkRecoveryAndRetry$13.$cfg, (Continuation) hubNetConnection$awaitNetworkRecoveryAndRetry$13);
                        if (registerApp == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        long j82 = j4;
                        currentTimeMillis = j3;
                        j2 = j82;
                        if (!((Boolean) registerApp).booleanValue()) {
                        }
                    }
                    hubNetConnection$awaitNetworkRecoveryAndRetry$14 = hubNetConnection$awaitNetworkRecoveryAndRetry$13;
                    hubNetConnection$awaitNetworkRecoveryAndRetry$14.this$0.networkRecoveryJob = null;
                    return Unit.INSTANCE;
                }
                FLogger.INSTANCE.mo428i("HubNetConnection", "retryRegisterApp: elapsed=" + currentTimeMillis2 + "ms, waiting for " + j + "ms timer or network recovery");
                HubNetConnection$awaitNetworkRecoveryAndRetry$1 hubNetConnection$awaitNetworkRecoveryAndRetry$15 = hubNetConnection$awaitNetworkRecoveryAndRetry$1;
                long j10 = currentTimeMillis;
                Deferred async$default = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HubNetConnection$awaitNetworkRecoveryAndRetry$1$timerDeferred$1(j, null), 3, (Object) null);
                Deferred async$default2 = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0883x12ffb5f(null), 3, (Object) null);
                SelectBuilder selectImplementation = new SelectImplementation(hubNetConnection$awaitNetworkRecoveryAndRetry$15.getContext());
                SelectBuilder selectBuilder = selectImplementation;
                selectBuilder.invoke(async$default.getOnAwait(), new HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$1(async$default2, null));
                selectBuilder.invoke(async$default2.getOnAwait(), new HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$2(async$default, null));
                hubNetConnection$awaitNetworkRecoveryAndRetry$12 = hubNetConnection$awaitNetworkRecoveryAndRetry$15;
                hubNetConnection$awaitNetworkRecoveryAndRetry$12.L$0 = coroutineScope;
                hubNetConnection$awaitNetworkRecoveryAndRetry$12.J$0 = j10;
                j4 = j2;
                hubNetConnection$awaitNetworkRecoveryAndRetry$12.J$1 = j4;
                hubNetConnection$awaitNetworkRecoveryAndRetry$12.J$2 = j;
                c = 2;
                hubNetConnection$awaitNetworkRecoveryAndRetry$12.label = 2;
                if (selectImplementation.doSelect(hubNetConnection$awaitNetworkRecoveryAndRetry$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = j10;
                hubNetConnection$awaitNetworkRecoveryAndRetry$13 = hubNetConnection$awaitNetworkRecoveryAndRetry$12;
                transportMode = hubNetConnection$awaitNetworkRecoveryAndRetry$13.this$0.transportMode;
                if (transportMode != TransportMode.SHUTDOWN) {
                }
                hubNetConnection$awaitNetworkRecoveryAndRetry$14 = hubNetConnection$awaitNetworkRecoveryAndRetry$13;
                hubNetConnection$awaitNetworkRecoveryAndRetry$14.this$0.networkRecoveryJob = null;
                return Unit.INSTANCE;
            }
        }
        hubNetConnection$awaitNetworkRecoveryAndRetry$14 = hubNetConnection$awaitNetworkRecoveryAndRetry$1;
        hubNetConnection$awaitNetworkRecoveryAndRetry$14.this$0.networkRecoveryJob = null;
        return Unit.INSTANCE;
    }
}
