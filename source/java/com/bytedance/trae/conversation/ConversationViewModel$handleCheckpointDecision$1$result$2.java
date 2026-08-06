package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ConfirmTaskRequest;
import com.bytedance.trae.im.service.ConfirmTaskResponse;
import com.bytedance.trae.im.service.IConfirmTaskApi;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ConfirmTaskResponse;", "Lcom/bytedance/trae/im/service/IConfirmTaskApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$handleCheckpointDecision$1$result$2", f = "ConversationViewModel.kt", i = {}, l = {3299}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ConversationViewModel$handleCheckpointDecision$1$result$2 extends SuspendLambda implements Function2<IConfirmTaskApi, Continuation<? super BizResponse<ConfirmTaskResponse>>, Object> {
    final /* synthetic */ String $convId;
    final /* synthetic */ CheckpointDecision $decision;
    final /* synthetic */ String $decisionStr;
    final /* synthetic */ Ref.ObjectRef<String> $params;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$handleCheckpointDecision$1$result$2(String str, CheckpointDecision checkpointDecision, String str2, Ref.ObjectRef<String> objectRef, Continuation<? super ConversationViewModel$handleCheckpointDecision$1$result$2> continuation) {
        super(2, continuation);
        this.$convId = str;
        this.$decision = checkpointDecision;
        this.$decisionStr = str2;
        this.$params = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> conversationViewModel$handleCheckpointDecision$1$result$2 = new ConversationViewModel$handleCheckpointDecision$1$result$2(this.$convId, this.$decision, this.$decisionStr, this.$params, continuation);
        conversationViewModel$handleCheckpointDecision$1$result$2.L$0 = obj;
        return conversationViewModel$handleCheckpointDecision$1$result$2;
    }

    public final Object invoke(IConfirmTaskApi iConfirmTaskApi, Continuation<? super BizResponse<ConfirmTaskResponse>> continuation) {
        return create(iConfirmTaskApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IConfirmTaskApi) this.L$0).confirmTask(new ConfirmTaskRequest(this.$convId, this.$decision.getTaskId(), null, this.$decision.getPlanItemId(), this.$decision.getToolName(), this.$decisionStr, (String) this.$params.element, 4, null), (Continuation) this);
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
