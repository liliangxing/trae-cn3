package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ChatMessage;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.repository.ConversationDetailCacheRepository;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.im.service.ListMessagesResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$refreshMessagesOnResume$1", f = "ConversationViewModel.kt", i = {1}, l = {1516, 1555, 1559}, m = "invokeSuspend", n = {"rawMessages"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$refreshMessagesOnResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    Object L$0;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$refreshMessagesOnResume$1(ConversationViewModel conversationViewModel, String str, Continuation<? super ConversationViewModel$refreshMessagesOnResume$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationViewModel;
        this.$conversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$refreshMessagesOnResume$1(this.this$0, this.$conversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0189 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m813x5a29967;
        List filterDisplayableMessages;
        List parsedHistoryMessages;
        MutableStateFlow mutableStateFlow;
        List mergeMessagesIntoState;
        MutableStateFlow mutableStateFlow2;
        MutableSharedFlow mutableSharedFlow;
        MutableStateFlow mutableStateFlow3;
        ConversationViewModel.SessionTurnStatus sessionTurnStatus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            m813x5a29967 = ConversationViewModel.m813x5a29967(this.this$0, this.$conversationId, null, 10, 0, false, null, (Continuation) this, 32, null);
            if (m813x5a29967 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                filterDisplayableMessages = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C06353(this.this$0, this.$conversationId, filterDisplayableMessages, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            m813x5a29967 = obj;
        }
        HttpDataResult.Success result = ((ConversationViewModel.ListMessagesByAnchorRetryResult) m813x5a29967).getResult();
        if (result instanceof HttpDataResult.Success) {
            ListMessagesResponse listMessagesResponse = (ListMessagesResponse) result.getBizResp().getData();
            ConversationViewModel conversationViewModel = this.this$0;
            List<ChatMessage> messages = listMessagesResponse != null ? listMessagesResponse.getMessages() : null;
            if (messages == null) {
                messages = CollectionsKt.emptyList();
            }
            filterDisplayableMessages = conversationViewModel.filterDisplayableMessages(messages);
            TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node3] refreshMessagesOnResume: API success, count=" + filterDisplayableMessages.size());
            if (filterDisplayableMessages.isEmpty()) {
                return Unit.INSTANCE;
            }
            parsedHistoryMessages = this.this$0.toParsedHistoryMessages(filterDisplayableMessages);
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : parsedHistoryMessages) {
                if (((ParsedChatMessage) obj2).isAssistantMessage()) {
                    arrayList.add(obj2);
                }
            }
            String str = this.$conversationId;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IMService.INSTANCE.cancelThoughtByMessageId(str, ((ParsedChatMessage) it.next()).getMessageId());
            }
            ConversationViewModel conversationViewModel2 = this.this$0;
            mutableStateFlow = conversationViewModel2._messages;
            mergeMessagesIntoState = conversationViewModel2.mergeMessagesIntoState((List) mutableStateFlow.getValue(), parsedHistoryMessages);
            this.this$0.setMessages(mergeMessagesIntoState);
            ParsedChatMessage parsedChatMessage = (ParsedChatMessage) CollectionsKt.lastOrNull(mergeMessagesIntoState);
            if (parsedChatMessage != null && parsedChatMessage.isAssistantMessage() && CollectionsKt.contains(CollectionsKt.listOf(new String[]{"completed", "failed", ConfirmInfo.STATUS_CANCELED}), parsedChatMessage.getStatus())) {
                this.this$0.setTaskRunning(false);
                mutableStateFlow2 = this.this$0._sessionTurnStatus;
                if (mutableStateFlow2.getValue() == ConversationViewModel.SessionTurnStatus.STREAMING) {
                    mutableStateFlow3 = this.this$0._sessionTurnStatus;
                    String status = parsedChatMessage.getStatus();
                    if (Intrinsics.areEqual(status, "failed") || Intrinsics.areEqual(status, ConfirmInfo.STATUS_CANCELED)) {
                        sessionTurnStatus = ConversationViewModel.SessionTurnStatus.STOPPED;
                    } else {
                        sessionTurnStatus = ConversationViewModel.SessionTurnStatus.FINISHED;
                    }
                    mutableStateFlow3.setValue(sessionTurnStatus);
                }
                mutableSharedFlow = this.this$0._taskDone;
                this.L$0 = filterDisplayableMessages;
                this.label = 2;
                if (mutableSharedFlow.emit(Unit.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.L$0 = null;
            this.label = 3;
            if (BuildersKt.withContext(Dispatchers.getIO(), new C06353(this.this$0, this.$conversationId, filterDisplayableMessages, null), (Continuation) this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
        if (!(result instanceof HttpDataResult.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        HttpDataResult.Error error = (HttpDataResult.Error) result;
        TraeLogUtil.INSTANCE.e("ConversationViewModel", "refreshMessagesOnResume: API error, code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$refreshMessagesOnResume$1$3", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationViewModel$refreshMessagesOnResume$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06353 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        final /* synthetic */ List<ChatMessage> $rawMessages;
        int label;
        final /* synthetic */ ConversationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06353(ConversationViewModel conversationViewModel, String str, List<ChatMessage> list, Continuation<? super C06353> continuation) {
            super(2, continuation);
            this.this$0 = conversationViewModel;
            this.$conversationId = str;
            this.$rawMessages = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06353(this.this$0, this.$conversationId, this.$rawMessages, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ConversationDetailCacheRepository cacheRepository;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                cacheRepository = this.this$0.getCacheRepository();
                cacheRepository.cacheNetworkMessages(this.$conversationId, this.$rawMessages);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
