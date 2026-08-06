package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.network.INetworkDepend;
import com.bytedance.trae.network.HubNetConnection;
import com.bytedance.trae.network.HubNetMessageListener;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1", f = "HtmlArtifactRemoteArchiveUrlResolver.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1 extends SuspendLambda implements Function2<ProducerScope<? super RealtimeSandboxStatusUpdate>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1(Continuation<? super DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultHtmlArtifactRemoteSandboxStatusSource$updates$1 = new DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1(continuation);
        defaultHtmlArtifactRemoteSandboxStatusSource$updates$1.L$0 = obj;
        return defaultHtmlArtifactRemoteSandboxStatusSource$updates$1;
    }

    public final Object invoke(ProducerScope<? super RealtimeSandboxStatusUpdate> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final HubNetConnection hubNet = INetworkDepend.INSTANCE.getInstance().getHubNet();
            final HubNetMessageListener hubNetMessageListener = new HubNetMessageListener() { // from class: com.bytedance.trae.conversation.products.DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda0
                public final void onMessage(int i2, String str, boolean z) {
                    DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1.invokeSuspend$lambda$4(producerScope, i2, str, z);
                }
            };
            if (hubNet != null) {
                hubNet.registerMessageListener(hubNetMessageListener);
            }
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: com.bytedance.trae.conversation.products.DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit invokeSuspend$lambda$5;
                    invokeSuspend$lambda$5 = DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1.invokeSuspend$lambda$5(hubNet, hubNetMessageListener);
                    return invokeSuspend$lambda$5;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4(ProducerScope producerScope, int i, String str, boolean z) {
        Object obj;
        if (i != 9) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            FLogger.INSTANCE.d("HtmlArtifactRemoteArchiveUrlResolver", "ws proto=9 raw sandbox status: data=" + str);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.Companion;
            obj = Result.constructor-impl((RealtimeSandboxStatusUpdate) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, RealtimeSandboxStatusUpdate.class));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            try {
                Result.Companion companion5 = Result.Companion;
                FLogger.INSTANCE.e("HtmlArtifactRemoteArchiveUrlResolver", "ws proto=9 parse sandbox status failed: data=" + str, th3);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion6 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th4));
            }
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        RealtimeSandboxStatusUpdate realtimeSandboxStatusUpdate = (RealtimeSandboxStatusUpdate) obj;
        if (realtimeSandboxStatusUpdate == null) {
            return;
        }
        producerScope.trySend-JP2dKIU(realtimeSandboxStatusUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$5(HubNetConnection hubNetConnection, HubNetMessageListener hubNetMessageListener) {
        if (hubNetConnection != null) {
            hubNetConnection.unregisterMessageListener(hubNetMessageListener);
        }
        return Unit.INSTANCE;
    }
}
