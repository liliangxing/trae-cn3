package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.DeleteConversationRequest;
import com.bytedance.trae.im.service.DeleteConversationResponse;
import com.bytedance.trae.im.service.IDeleteConversationService;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$deleteHubConversationAsync$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {2116}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class VoiceSubTaskCoordinator$deleteHubConversationAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $parentChatSessionId;
    final /* synthetic */ String $parentConversationId;
    final /* synthetic */ String $reason;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$deleteHubConversationAsync$1(String str, String str2, String str3, Continuation<? super VoiceSubTaskCoordinator$deleteHubConversationAsync$1> continuation) {
        super(2, continuation);
        this.$parentConversationId = str;
        this.$parentChatSessionId = str2;
        this.$reason = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VoiceSubTaskCoordinator$deleteHubConversationAsync$1(this.$parentConversationId, this.$parentChatSessionId, this.$reason, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IDeleteConversationService.INSTANCE.deleteConversationRawCall(new DeleteConversationRequest(this.$parentConversationId), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        if (success instanceof HttpDataResult.Success) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("delete empty parent ok: parentConversationId=").append(this.$parentConversationId).append(", parentChatSessionId=").append(this.$parentChatSessionId).append(", reason=").append(this.$reason).append(", deleted=");
            DeleteConversationResponse deleteConversationResponse = (DeleteConversationResponse) success.getBizResp().getData();
            fLogger.d("VoiceSubTaskCoord", append.append(deleteConversationResponse != null ? deleteConversationResponse.getDeleted() : null).toString());
        } else {
            if (!(success instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            FLogger.INSTANCE.w("VoiceSubTaskCoord", "delete empty parent failed: parentConversationId=" + this.$parentConversationId + ", parentChatSessionId=" + this.$parentChatSessionId + ", reason=" + this.$reason + ", code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
        }
        return Unit.INSTANCE;
    }
}
