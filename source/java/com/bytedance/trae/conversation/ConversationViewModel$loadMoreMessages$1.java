package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ChatMessage;
import com.bytedance.trae.im.service.ListMessagesResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$loadMoreMessages$1", f = "ConversationViewModel.kt", i = {}, l = {1611, 1655}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$loadMoreMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $anchorCreatedAtMs;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Function0<Unit> $onComplete;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$loadMoreMessages$1(ConversationViewModel conversationViewModel, String str, Long l, Function0<Unit> function0, Continuation<? super ConversationViewModel$loadMoreMessages$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationViewModel;
        this.$conversationId = str;
        this.$anchorCreatedAtMs = l;
        this.$onComplete = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$loadMoreMessages$1(this.this$0, this.$conversationId, this.$anchorCreatedAtMs, this.$onComplete, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object m813x5a29967;
        MutableSharedFlow mutableSharedFlow;
        List filterDisplayableMessages;
        List parsedHistoryMessages;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        List mergeMessages;
        MutableStateFlow mutableStateFlow5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                m813x5a29967 = ConversationViewModel.m813x5a29967(this.this$0, this.$conversationId, this.$anchorCreatedAtMs.toString(), 10, 0, false, null, (Continuation) this, 32, null);
                if (m813x5a29967 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow5 = this.this$0._isLoadingMore;
                    mutableStateFlow5.setValue(Boxing.boxBoolean(false));
                    this.$onComplete.invoke();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                m813x5a29967 = obj;
            }
            ConversationViewModel.ListMessagesByAnchorRetryResult listMessagesByAnchorRetryResult = (ConversationViewModel.ListMessagesByAnchorRetryResult) m813x5a29967;
            HttpDataResult.Success result = listMessagesByAnchorRetryResult.getResult();
            if (result instanceof HttpDataResult.Success) {
                if (!result.getBizResp().isSuccess()) {
                    TraeLogUtil.INSTANCE.e("ConversationViewModel", "loadMoreMessages biz error: code=" + result.getBizResp().getCode() + ", msg=" + result.getBizResp().getMsg());
                } else {
                    ListMessagesResponse listMessagesResponse = (ListMessagesResponse) result.getBizResp().getData();
                    ConversationViewModel conversationViewModel = this.this$0;
                    List<ChatMessage> messages = listMessagesResponse != null ? listMessagesResponse.getMessages() : null;
                    if (messages == null) {
                        messages = CollectionsKt.emptyList();
                    }
                    filterDisplayableMessages = conversationViewModel.filterDisplayableMessages(messages);
                    TraeLogUtil.INSTANCE.d("ConversationViewModel", "loadMoreMessages: API success, raw messages count=" + filterDisplayableMessages.size());
                    parsedHistoryMessages = this.this$0.toParsedHistoryMessages(filterDisplayableMessages);
                    if (!parsedHistoryMessages.isEmpty()) {
                        ConversationViewModel conversationViewModel2 = this.this$0;
                        mutableStateFlow4 = conversationViewModel2._messages;
                        mergeMessages = conversationViewModel2.mergeMessages((List) mutableStateFlow4.getValue(), parsedHistoryMessages);
                        conversationViewModel2.setMessages(mergeMessages);
                    }
                    if (!filterDisplayableMessages.isEmpty()) {
                        mutableStateFlow3 = this.this$0._hasMoreMessages;
                        mutableStateFlow3.setValue(Boxing.boxBoolean(this.this$0.hasMoreHistoryPage$conversation_mainlandRelease(filterDisplayableMessages.size(), listMessagesByAnchorRetryResult.getRequest().getBeforeLimit())));
                    } else {
                        mutableStateFlow2 = this.this$0._hasMoreMessages;
                        mutableStateFlow2.setValue(Boxing.boxBoolean(false));
                    }
                }
            } else {
                if (!(result instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                TraeLogUtil.INSTANCE.e("ConversationViewModel", "loadMoreMessages: API error, code=" + ((HttpDataResult.Error) result).getCode() + ", msg=" + ((HttpDataResult.Error) result).getMsg(), ((HttpDataResult.Error) result).getThrowable());
                if (((HttpDataResult.Error) result).getCode() == 401) {
                    mutableSharedFlow = this.this$0._forceLogout;
                    this.label = 2;
                    if (mutableSharedFlow.emit(Unit.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            mutableStateFlow5 = this.this$0._isLoadingMore;
            mutableStateFlow5.setValue(Boxing.boxBoolean(false));
            this.$onComplete.invoke();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutableStateFlow = this.this$0._isLoadingMore;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
            this.$onComplete.invoke();
            throw th;
        }
    }
}
