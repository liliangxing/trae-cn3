package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CancelTaskRequest;
import com.bytedance.trae.im.service.CancelTaskResponse;
import com.bytedance.trae.im.service.ICancelTaskApi;
import com.bytedance.trae.network.response.BizResponse;
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

/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$cancelActiveTask$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {2012}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class VoiceSubTaskCoordinator$cancelActiveTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localTaskId;
    final /* synthetic */ String $proxyConvId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$cancelActiveTask$1(String str, String str2, Continuation<? super VoiceSubTaskCoordinator$cancelActiveTask$1> continuation) {
        super(2, continuation);
        this.$proxyConvId = str;
        this.$localTaskId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VoiceSubTaskCoordinator$cancelActiveTask$1(this.$proxyConvId, this.$localTaskId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ICancelTaskApi.INSTANCE.safeCall(new C07841(this.$proxyConvId, this.$localTaskId, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th) {
            FLogger.INSTANCE.w("VoiceSubTaskCoord", "cancelActiveTask: cancel api failed", th);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VoiceSubTaskCoordinator.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/CancelTaskResponse;", "Lcom/bytedance/trae/im/service/ICancelTaskApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$cancelActiveTask$1$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {2013}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$cancelActiveTask$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07841 extends SuspendLambda implements Function2<ICancelTaskApi, Continuation<? super BizResponse<CancelTaskResponse>>, Object> {
        final /* synthetic */ String $localTaskId;
        final /* synthetic */ String $proxyConvId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07841(String str, String str2, Continuation<? super C07841> continuation) {
            super(2, continuation);
            this.$proxyConvId = str;
            this.$localTaskId = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c07841 = new C07841(this.$proxyConvId, this.$localTaskId, continuation);
            c07841.L$0 = obj;
            return c07841;
        }

        public final Object invoke(ICancelTaskApi iCancelTaskApi, Continuation<? super BizResponse<CancelTaskResponse>> continuation) {
            return create(iCancelTaskApi, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ((ICancelTaskApi) this.L$0).cancelTask(new CancelTaskRequest(this.$proxyConvId, this.$localTaskId), (Continuation) this);
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
}
