package com.bytedance.trae.conversation.chat.viewholder;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.IRevertTaskApi;
import com.bytedance.trae.im.service.RevertTaskRequest;
import com.bytedance.trae.im.service.RevertTaskResponse;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/RevertTaskResponse;", "Lcom/bytedance/trae/im/service/IRevertTaskApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1$result$1", f = "UserMessageViewHolder.kt", i = {}, l = {548}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1$result$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0708x553e265c extends SuspendLambda implements Function2<IRevertTaskApi, Continuation<? super BizResponse<RevertTaskResponse>>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ ParsedChatMessage $message;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0708x553e265c(String str, ParsedChatMessage parsedChatMessage, Continuation<? super C0708x553e265c> continuation) {
        super(2, continuation);
        this.$conversationId = str;
        this.$message = parsedChatMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0708x553e265c = new C0708x553e265c(this.$conversationId, this.$message, continuation);
        c0708x553e265c.L$0 = obj;
        return c0708x553e265c;
    }

    public final Object invoke(IRevertTaskApi iRevertTaskApi, Continuation<? super BizResponse<RevertTaskResponse>> continuation) {
        return create(iRevertTaskApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IRevertTaskApi) this.L$0).revertTask(new RevertTaskRequest(this.$conversationId, this.$message.getMessageId()), (Continuation) this);
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
