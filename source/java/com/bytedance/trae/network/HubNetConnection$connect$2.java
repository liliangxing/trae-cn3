package com.bytedance.trae.network;

import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection$connect$2", f = "HubNetConnection.kt", i = {}, l = {485}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnection$connect$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FrontierConfig $cfg;
    final /* synthetic */ HubConnectionListener $listener;
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ HubNetConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$connect$2(HubNetConnection hubNetConnection, String str, FrontierConfig frontierConfig, HubConnectionListener hubConnectionListener, Continuation<? super HubNetConnection$connect$2> continuation) {
        super(2, continuation);
        this.this$0 = hubNetConnection;
        this.$reason = str;
        this.$cfg = frontierConfig;
        this.$listener = hubConnectionListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HubNetConnection$connect$2(this.this$0, this.$reason, this.$cfg, this.$listener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final HubNetConnection hubNetConnection = this.this$0;
            final String str = this.$reason;
            Function0 function0 = new Function0() { // from class: com.bytedance.trae.network.HubNetConnection$connect$2$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = HubNetConnection$connect$2.invokeSuspend$lambda$0(HubNetConnection.this, str);
                    return invokeSuspend$lambda$0;
                }
            };
            C08842 c08842 = new C08842(this.this$0, this.$cfg, null);
            final HubConnectionListener hubConnectionListener = this.$listener;
            Function0 function02 = new Function0() { // from class: com.bytedance.trae.network.HubNetConnection$connect$2$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = HubNetConnection$connect$2.invokeSuspend$lambda$1(HubConnectionListener.this);
                    return invokeSuspend$lambda$1;
                }
            };
            final HubNetConnection hubNetConnection2 = this.this$0;
            final FrontierConfig frontierConfig = this.$cfg;
            final HubConnectionListener hubConnectionListener2 = this.$listener;
            this.label = 1;
            if (HubNetConnectionKt.startTransportThenRegister(function0, c08842, function02, new Function0() { // from class: com.bytedance.trae.network.HubNetConnection$connect$2$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = HubNetConnection$connect$2.invokeSuspend$lambda$2(HubNetConnection.this, frontierConfig, hubConnectionListener2);
                    return invokeSuspend$lambda$2;
                }
            }, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HubNetConnection.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection$connect$2$2", f = "HubNetConnection.kt", i = {}, l = {487}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.network.HubNetConnection$connect$2$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08842 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ FrontierConfig $cfg;
        int label;
        final /* synthetic */ HubNetConnection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08842(HubNetConnection hubNetConnection, FrontierConfig frontierConfig, Continuation<? super C08842> continuation) {
            super(1, continuation);
            this.this$0 = hubNetConnection;
            this.$cfg = frontierConfig;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C08842(this.this$0, this.$cfg, continuation);
        }

        public final Object invoke(Continuation<? super Boolean> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.this$0.registerApp(this.$cfg, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(HubNetConnection hubNetConnection, String str) {
        hubNetConnection.startConnectedTransport(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(HubConnectionListener hubConnectionListener) {
        if (hubConnectionListener != null) {
            hubConnectionListener.onRegisterSuccess();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(HubNetConnection hubNetConnection, FrontierConfig frontierConfig, HubConnectionListener hubConnectionListener) {
        try {
            NetworkMonitor.INSTANCE.init(AppHost.Companion.getApplication());
            FLogger.INSTANCE.mo430w("HubNetConnection", "connect: registerApp failed, keeping transport and scheduling registration retry");
            hubNetConnection.awaitNetworkRecoveryAndRetry(frontierConfig, hubConnectionListener);
        } catch (Throwable unused) {
            EnsureManager.ensureNotReachHere();
        }
        return Unit.INSTANCE;
    }
}
