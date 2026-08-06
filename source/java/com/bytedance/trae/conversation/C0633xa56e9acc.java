package com.bytedance.trae.conversation;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.IListMessagesService;
import com.bytedance.trae.im.service.ListMessagesResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ListMessagesResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$2", f = "ConversationViewModel.kt", i = {}, l = {1081}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0633xa56e9acc extends SuspendLambda implements Function2<ConversationViewModel.ListMessagesByAnchorRequest, Continuation<? super HttpDataResult<? extends ListMessagesResponse>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0633xa56e9acc(Continuation<? super C0633xa56e9acc> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0633xa56e9acc = new C0633xa56e9acc(continuation);
        c0633xa56e9acc.L$0 = obj;
        return c0633xa56e9acc;
    }

    public final Object invoke(ConversationViewModel.ListMessagesByAnchorRequest listMessagesByAnchorRequest, Continuation<? super HttpDataResult<ListMessagesResponse>> continuation) {
        return create(listMessagesByAnchorRequest, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ConversationViewModel.ListMessagesByAnchorRequest listMessagesByAnchorRequest = (ConversationViewModel.ListMessagesByAnchorRequest) this.L$0;
            this.label = 1;
            obj = IListMessagesService.INSTANCE.listMessagesByAnchorRawCall(listMessagesByAnchorRequest.getConversationId(), listMessagesByAnchorRequest.getAnchorCreatedAtMs(), listMessagesByAnchorRequest.getBeforeLimit(), listMessagesByAnchorRequest.getAfterLimit(), listMessagesByAnchorRequest.getIncludeAnchor(), (Continuation) this);
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
