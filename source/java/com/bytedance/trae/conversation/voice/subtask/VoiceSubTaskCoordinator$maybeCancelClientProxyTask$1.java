package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ICancelTaskApi;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {1927}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localTaskId;
    final /* synthetic */ String $proxyConvId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1(String str, String str2, Continuation<? super VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1> continuation) {
        super(2, continuation);
        this.$proxyConvId = str;
        this.$localTaskId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> voiceSubTaskCoordinator$maybeCancelClientProxyTask$1 = new VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1(this.$proxyConvId, this.$localTaskId, continuation);
        voiceSubTaskCoordinator$maybeCancelClientProxyTask$1.L$0 = obj;
        return voiceSubTaskCoordinator$maybeCancelClientProxyTask$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.$proxyConvId;
                String str2 = this.$localTaskId;
                Result.Companion companion = Result.Companion;
                ICancelTaskApi.Companion companion2 = ICancelTaskApi.INSTANCE;
                VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1$1$1 voiceSubTaskCoordinator$maybeCancelClientProxyTask$1$1$1 = new VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1$1$1(str, str2, null);
                this.label = 1;
                obj = companion2.safeCall(voiceSubTaskCoordinator$maybeCancelClientProxyTask$1$1$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            obj2 = Result.constructor-impl((HttpDataResult) obj);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
            FLogger.INSTANCE.w("VoiceSubTaskCoord", "maybeCancelClientProxyTask: bg cancel failed", th2);
        }
        return Unit.INSTANCE;
    }
}
