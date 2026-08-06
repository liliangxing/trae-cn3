package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.IReportMessageApi;
import com.bytedance.trae.im.service.ReportMessageRequest;
import com.bytedance.trae.im.service.ReportMessageResponse;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ReportMessageResponse;", "Lcom/bytedance/trae/im/service/IReportMessageApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$submitReport$1$result$1", f = "ConversationActivity.kt", i = {}, l = {2533}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ConversationActivity$submitReport$1$result$1 extends SuspendLambda implements Function2<IReportMessageApi, Continuation<? super BizResponse<ReportMessageResponse>>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$submitReport$1$result$1(String str, String str2, String str3, Continuation<? super ConversationActivity$submitReport$1$result$1> continuation) {
        super(2, continuation);
        this.$conversationId = str;
        this.$messageId = str2;
        this.$content = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> conversationActivity$submitReport$1$result$1 = new ConversationActivity$submitReport$1$result$1(this.$conversationId, this.$messageId, this.$content, continuation);
        conversationActivity$submitReport$1$result$1.L$0 = obj;
        return conversationActivity$submitReport$1$result$1;
    }

    public final Object invoke(IReportMessageApi iReportMessageApi, Continuation<? super BizResponse<ReportMessageResponse>> continuation) {
        return create(iReportMessageApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IReportMessageApi) this.L$0).reportMessage(new ReportMessageRequest(this.$conversationId, this.$messageId, this.$content), (Continuation) this);
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
