package com.bytedance.trae.conversation;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.settings.ConversationListSettingsService;
import com.bytedance.trae.im.model.ChatMessage;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.repository.ConversationDetailCacheRepository;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.IListConversationsService;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.im.service.ListConversationsResponse;
import com.bytedance.trae.im.service.ListMessagesResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.time.OffsetDateTime;
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
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$loadMessages$1", f = "ConversationViewModel.kt", i = {3, 3, 3}, l = {1252, 1262, 1280, 1342, 1409, 1421, 1432}, m = "invokeSuspend", n = {"retryResult", "rawMessages", "chatMessages"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$loadMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$loadMessages$1(ConversationViewModel conversationViewModel, String str, Continuation<? super ConversationViewModel$loadMessages$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationViewModel;
        this.$conversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$loadMessages$1(this.this$0, this.$conversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0615 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x03c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object withContext;
        List list;
        Object m813x5a29967;
        ConversationViewModel.ListMessagesByAnchorRetryResult listMessagesByAnchorRetryResult;
        HttpDataResult.Success result;
        MutableStateFlow mutableStateFlow;
        MutableSharedFlow mutableSharedFlow;
        MutableStateFlow mutableStateFlow2;
        MutableSharedFlow mutableSharedFlow2;
        MutableStateFlow mutableStateFlow3;
        List filterDisplayableMessages;
        List<ParsedChatMessage> parsedHistoryMessages;
        boolean z;
        long j;
        MutableStateFlow mutableStateFlow4;
        MutableStateFlow mutableStateFlow5;
        MutableStateFlow mutableStateFlow6;
        MutableStateFlow mutableStateFlow7;
        String latestTaskId;
        Object listConversationsRawCall;
        Iterator it;
        List<ParsedChatMessage> list2;
        ParsedChatMessage parsedChatMessage;
        Object obj2;
        ConversationViewModel conversationViewModel;
        Iterator it2;
        MutableStateFlow mutableStateFlow8;
        MutableSharedFlow mutableSharedFlow3;
        MutableStateFlow mutableStateFlow9;
        MutableStateFlow mutableStateFlow10;
        MutableStateFlow mutableStateFlow11;
        MutableStateFlow mutableStateFlow12;
        List<ParsedPlanItemMessage> messages;
        HttpDataResult.Success success;
        Conversation conversation;
        List<Conversation> conversations;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new ConversationViewModel$loadMessages$1$cachedMessages$1(this.this$0, this.$conversationId, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = (List) withContext;
                if (!list.isEmpty()) {
                    TraeLogUtil.INSTANCE.d("ConversationViewModel", "loadMessages: cache hit, count=" + list.size());
                    this.this$0.handleModelUnavailableLoadedMessagesIfNeeded(list, "cache");
                    this.this$0.replaceMessagesPreservingRuntime(list);
                }
                this.label = 2;
                m813x5a29967 = ConversationViewModel.m813x5a29967(this.this$0, this.$conversationId, null, 10, 0, false, null, (Continuation) this, 32, null);
                if (m813x5a29967 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                listMessagesByAnchorRetryResult = (ConversationViewModel.ListMessagesByAnchorRetryResult) m813x5a29967;
                result = listMessagesByAnchorRetryResult.getResult();
                if (result instanceof HttpDataResult.Success) {
                    HttpDataResult.Success success2 = result;
                    if (success2.getBizResp().isSuccess()) {
                        mutableStateFlow3 = this.this$0._loadError;
                        mutableStateFlow3.setValue(Boxing.boxBoolean(false));
                        ListMessagesResponse listMessagesResponse = (ListMessagesResponse) success2.getBizResp().getData();
                        ConversationViewModel conversationViewModel2 = this.this$0;
                        List<ChatMessage> messages2 = listMessagesResponse != null ? listMessagesResponse.getMessages() : null;
                        if (messages2 == null) {
                            messages2 = CollectionsKt.emptyList();
                        }
                        filterDisplayableMessages = conversationViewModel2.filterDisplayableMessages(messages2);
                        if (AppHost.INSTANCE.isDebug()) {
                            TraeLogUtil.INSTANCE.d("ConversationViewModel", "loadMessages: API success, raw messages count=" + filterDisplayableMessages.size());
                            TraeLogUtil.INSTANCE.d("ConversationViewModel", "loadMessages: rawMessages json=" + this.this$0.getGson().toJson(filterDisplayableMessages));
                        }
                        parsedHistoryMessages = this.this$0.toParsedHistoryMessages(filterDisplayableMessages);
                        List<ParsedChatMessage> list3 = parsedHistoryMessages;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj4 : list3) {
                            if (((ParsedChatMessage) obj4).isAssistantMessage()) {
                                arrayList.add(obj4);
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        ConversationViewModel conversationViewModel3 = this.this$0;
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            ParsedChatMessage parsedChatMessage2 = (ParsedChatMessage) it3.next();
                            Conversation conversation2 = (Conversation) conversationViewModel3.getConversation().getValue();
                            String id = conversation2 != null ? conversation2.getId() : null;
                            if (id != null) {
                                conversationViewModel = conversationViewModel3;
                                it2 = it3;
                                FLogger.INSTANCE.d("AgentClean", "assistant_message:" + parsedChatMessage2.getMessageId());
                                IMService.INSTANCE.cancelThoughtByMessageId(id, parsedChatMessage2.getMessageId());
                            } else {
                                conversationViewModel = conversationViewModel3;
                                it2 = it3;
                            }
                            it3 = it2;
                            conversationViewModel3 = conversationViewModel;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj5 : arrayList2) {
                            ParsedTaskContent taskContent = ((ParsedChatMessage) obj5).getTaskContent();
                            String taskId = taskContent != null ? taskContent.getTaskId() : null;
                            if (taskId == null || taskId.length() == 0) {
                                arrayList3.add(obj5);
                            }
                        }
                        ArrayList arrayList4 = new ArrayList();
                        Iterator it4 = arrayList3.iterator();
                        while (it4.hasNext()) {
                            String replyToMessageId = ((ParsedChatMessage) it4.next()).getReplyToMessageId();
                            if (replyToMessageId != null) {
                                Iterator<T> it5 = list3.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        obj2 = it5.next();
                                        list2 = list3;
                                        if (!Intrinsics.areEqual(((ParsedChatMessage) obj2).getMessageId(), replyToMessageId)) {
                                            list3 = list2;
                                        }
                                    } else {
                                        list2 = list3;
                                        obj2 = null;
                                    }
                                }
                                parsedChatMessage = (ParsedChatMessage) obj2;
                            } else {
                                list2 = list3;
                                parsedChatMessage = null;
                            }
                            if (parsedChatMessage != null) {
                                arrayList4.add(parsedChatMessage);
                            }
                            list3 = list2;
                        }
                        List distinct = CollectionsKt.distinct(arrayList4);
                        ConversationViewModel conversationViewModel4 = this.this$0;
                        Iterator it6 = distinct.iterator();
                        while (it6.hasNext()) {
                            ParsedChatMessage parsedChatMessage3 = (ParsedChatMessage) it6.next();
                            if (parsedChatMessage3.isUserMessage()) {
                                Conversation conversation3 = (Conversation) conversationViewModel4.getConversation().getValue();
                                String id2 = conversation3 != null ? conversation3.getId() : null;
                                if (!Intrinsics.areEqual(parsedChatMessage3.getStatus(), "in_progress") && id2 != null) {
                                    it = it6;
                                    FLogger.INSTANCE.d("AgentClean", "cancelThoughtByMessageId:" + parsedChatMessage3.getMessageId());
                                    IMService.INSTANCE.cancelThoughtByMessageId(id2, parsedChatMessage3.getMessageId());
                                    it6 = it;
                                }
                            }
                            it = it6;
                            it6 = it;
                        }
                        z = this.this$0.isInited;
                        if (!z) {
                            this.this$0.isInited = true;
                            ParsedChatMessage latestUnpairedUserMessage = this.this$0.getLatestUnpairedUserMessage(parsedHistoryMessages);
                            if (Intrinsics.areEqual(latestUnpairedUserMessage != null ? latestUnpairedUserMessage.getRole() : null, ParsedChatMessage.ROLE_USER)) {
                                Conversation conversation4 = (Conversation) this.this$0.getConversation().getValue();
                                if ((conversation4 != null ? conversation4.getLatestTaskId() : null) != null) {
                                    long createdAt = latestUnpairedUserMessage.getCreatedAt();
                                    try {
                                        Conversation conversation5 = (Conversation) this.this$0.getConversation().getValue();
                                        j = OffsetDateTime.parse(conversation5 != null ? conversation5.getLatestTaskUpdateTime() : null).toInstant().toEpochMilli();
                                    } catch (Throwable unused) {
                                        j = 0;
                                    }
                                    if (createdAt > j) {
                                        IListConversationsService.Companion companion = IListConversationsService.INSTANCE;
                                        int pageSize = ConversationListSettingsService.INSTANCE.getPageSize();
                                        this.L$0 = listMessagesByAnchorRetryResult;
                                        this.L$1 = filterDisplayableMessages;
                                        this.L$2 = parsedHistoryMessages;
                                        this.label = 4;
                                        listConversationsRawCall = companion.listConversationsRawCall((r24 & 1) != 0 ? 300 : pageSize, (r24 & 2) != 0 ? 0 : 0, (r24 & 4) != 0 ? "updated_at" : null, (r24 & 8) != 0 ? "desc" : null, (r24 & 16) != 0, (r24 & 32) != 0 ? 1 : null, (r24 & 64) != 0 ? 1 : null, (r24 & 128) != 0 ? "" : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (Continuation) this);
                                        if (listConversationsRawCall == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        success = (HttpDataResult) listConversationsRawCall;
                                        if (success instanceof HttpDataResult.Success) {
                                            HttpDataResult.Success success3 = success;
                                            if (success3.getBizResp().isSuccess()) {
                                                ListConversationsResponse listConversationsResponse = (ListConversationsResponse) success3.getBizResp().getData();
                                                if (listConversationsResponse == null || (conversations = listConversationsResponse.getConversations()) == null) {
                                                    conversation = null;
                                                } else {
                                                    String str = this.$conversationId;
                                                    Iterator<T> it7 = conversations.iterator();
                                                    while (true) {
                                                        if (it7.hasNext()) {
                                                            obj3 = it7.next();
                                                            if (Intrinsics.areEqual(((Conversation) obj3).getId(), str)) {
                                                            }
                                                        } else {
                                                            obj3 = null;
                                                        }
                                                    }
                                                    conversation = (Conversation) obj3;
                                                }
                                                if (conversation != null && conversation.getLatestTaskId() != null && !Intrinsics.areEqual(conversation.getLatestTaskStatus(), "interrupted") && !Intrinsics.areEqual(conversation.getLatestTaskStatus(), "completed")) {
                                                    try {
                                                        ConversationViewModel conversationViewModel5 = this.this$0;
                                                        String str2 = this.$conversationId;
                                                        String latestTaskId2 = conversation.getLatestTaskId();
                                                        Intrinsics.checkNotNull(latestTaskId2);
                                                        conversationViewModel5.fetchEventsIfNeeded(str2, latestTaskId2);
                                                    } catch (Exception e) {
                                                        TraeLogUtil.INSTANCE.e("ConversationViewModel", "loadMessages: fetchEventsIfNeeded error, conversationId=" + this.$conversationId + ", taskId=" + conversation.getLatestTaskId(), e);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        try {
                                            mutableStateFlow5 = this.this$0._conversation;
                                            Conversation conversation6 = (Conversation) mutableStateFlow5.getValue();
                                            if (!Intrinsics.areEqual(conversation6 != null ? conversation6.getLatestTaskStatus() : null, "interrupted")) {
                                                mutableStateFlow6 = this.this$0._conversation;
                                                Conversation conversation7 = (Conversation) mutableStateFlow6.getValue();
                                                if (!Intrinsics.areEqual(conversation7 != null ? conversation7.getLatestTaskStatus() : null, "completed")) {
                                                    ConversationViewModel conversationViewModel6 = this.this$0;
                                                    String str3 = this.$conversationId;
                                                    mutableStateFlow7 = conversationViewModel6._conversation;
                                                    Conversation conversation8 = (Conversation) mutableStateFlow7.getValue();
                                                    if (conversation8 == null || (latestTaskId = conversation8.getLatestTaskId()) == null) {
                                                        Conversation conversation9 = (Conversation) this.this$0.getConversation().getValue();
                                                        latestTaskId = conversation9 != null ? conversation9.getLatestTaskId() : null;
                                                        Intrinsics.checkNotNull(latestTaskId);
                                                    }
                                                    conversationViewModel6.fetchEventsIfNeeded(str3, latestTaskId);
                                                }
                                            }
                                        } catch (Exception e2) {
                                            TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                                            StringBuilder append = new StringBuilder("loadMessages: fetchEventsIfNeeded error, conversationId=").append(this.$conversationId).append(",taskId=");
                                            mutableStateFlow4 = this.this$0._conversation;
                                            Conversation conversation10 = (Conversation) mutableStateFlow4.getValue();
                                            traeLogUtil.e("ConversationViewModel", append.append(conversation10 != null ? conversation10.getLatestTaskId() : null).toString(), e2);
                                        }
                                    }
                                }
                            }
                        }
                        TraeLogUtil.INSTANCE.d("ConversationViewModel", "loadMessages: parsed messages count=" + parsedHistoryMessages.size());
                        TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node3] loadMessages: rawCount=" + filterDisplayableMessages.size() + ", parsedCount=" + parsedHistoryMessages.size());
                        for (ParsedChatMessage parsedChatMessage4 : parsedHistoryMessages) {
                            if (parsedChatMessage4.isAssistantMessage()) {
                                ParsedTaskContent taskContent2 = parsedChatMessage4.getTaskContent();
                                TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node3] loadMessages agent: msgId=" + parsedChatMessage4.getMessageId() + ", status=" + parsedChatMessage4.getStatus() + ", planItemCount=" + ((taskContent2 == null || (messages = taskContent2.getMessages()) == null) ? 0 : messages.size()) + ", agentType=" + parsedChatMessage4.getAgentType());
                            }
                        }
                        this.this$0.replaceMessagesPreservingRuntime(parsedHistoryMessages);
                        ConversationViewModel conversationViewModel7 = this.this$0;
                        mutableStateFlow10 = conversationViewModel7._messages;
                        conversationViewModel7.updateUpgradeReminder((List) mutableStateFlow10.getValue());
                        this.this$0.handleModelUnavailableLoadedMessagesIfNeeded(parsedHistoryMessages, "network");
                        if (!filterDisplayableMessages.isEmpty()) {
                            mutableStateFlow11 = this.this$0._hasMoreMessages;
                            mutableStateFlow11.setValue(Boxing.boxBoolean(false));
                        } else {
                            mutableStateFlow12 = this.this$0._hasMoreMessages;
                            mutableStateFlow12.setValue(Boxing.boxBoolean(this.this$0.hasMoreHistoryPage$conversation_mainlandRelease(filterDisplayableMessages.size(), listMessagesByAnchorRetryResult.getRequest().getBeforeLimit())));
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new C06316(this.this$0, this.$conversationId, filterDisplayableMessages, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        TraeLogUtil.INSTANCE.e("ConversationViewModel", "loadMessages biz error: code=" + success2.getBizResp().getCode() + ", msg=" + success2.getBizResp().getMsg());
                        mutableStateFlow8 = this.this$0._messages;
                        if (((List) mutableStateFlow8.getValue()).isEmpty()) {
                            mutableStateFlow9 = this.this$0._loadError;
                            mutableStateFlow9.setValue(Boxing.boxBoolean(true));
                        }
                        mutableSharedFlow3 = this.this$0._toastText;
                        String string = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_network_retry);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        this.label = 3;
                        if (mutableSharedFlow3.emit(string, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (!(result instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    HttpDataResult.Error error = (HttpDataResult.Error) result;
                    if (error.getCode() == 401) {
                        TraeLogUtil.INSTANCE.e("ConversationViewModel", "loadMessages: logout");
                        mutableSharedFlow2 = this.this$0._forceLogout;
                        this.label = 6;
                        if (mutableSharedFlow2.emit(Unit.INSTANCE, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        TraeLogUtil.INSTANCE.e("ConversationViewModel", "loadMessages: API error, code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
                        mutableStateFlow = this.this$0._messages;
                        if (((List) mutableStateFlow.getValue()).isEmpty()) {
                            mutableStateFlow2 = this.this$0._loadError;
                            mutableStateFlow2.setValue(Boxing.boxBoolean(true));
                        }
                        mutableSharedFlow = this.this$0._toastText;
                        String string2 = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_network_retry);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        this.label = 7;
                        if (mutableSharedFlow.emit(string2, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                this.this$0.recoverStreamingMessages();
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                withContext = obj;
                list = (List) withContext;
                if (!list.isEmpty()) {
                }
                this.label = 2;
                m813x5a29967 = ConversationViewModel.m813x5a29967(this.this$0, this.$conversationId, null, 10, 0, false, null, (Continuation) this, 32, null);
                if (m813x5a29967 == coroutine_suspended) {
                }
                listMessagesByAnchorRetryResult = (ConversationViewModel.ListMessagesByAnchorRetryResult) m813x5a29967;
                result = listMessagesByAnchorRetryResult.getResult();
                if (result instanceof HttpDataResult.Success) {
                }
                this.this$0.recoverStreamingMessages();
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure(obj);
                m813x5a29967 = obj;
                listMessagesByAnchorRetryResult = (ConversationViewModel.ListMessagesByAnchorRetryResult) m813x5a29967;
                result = listMessagesByAnchorRetryResult.getResult();
                if (result instanceof HttpDataResult.Success) {
                }
                this.this$0.recoverStreamingMessages();
                return Unit.INSTANCE;
            case 3:
            case 5:
            case 6:
            case 7:
                ResultKt.throwOnFailure(obj);
                this.this$0.recoverStreamingMessages();
                return Unit.INSTANCE;
            case 4:
                List<ParsedChatMessage> list4 = (List) this.L$2;
                filterDisplayableMessages = (List) this.L$1;
                listMessagesByAnchorRetryResult = (ConversationViewModel.ListMessagesByAnchorRetryResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                parsedHistoryMessages = list4;
                listConversationsRawCall = obj;
                success = (HttpDataResult) listConversationsRawCall;
                if (success instanceof HttpDataResult.Success) {
                }
                TraeLogUtil.INSTANCE.d("ConversationViewModel", "loadMessages: parsed messages count=" + parsedHistoryMessages.size());
                TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node3] loadMessages: rawCount=" + filterDisplayableMessages.size() + ", parsedCount=" + parsedHistoryMessages.size());
                while (r0.hasNext()) {
                }
                this.this$0.replaceMessagesPreservingRuntime(parsedHistoryMessages);
                ConversationViewModel conversationViewModel72 = this.this$0;
                mutableStateFlow10 = conversationViewModel72._messages;
                conversationViewModel72.updateUpgradeReminder((List) mutableStateFlow10.getValue());
                this.this$0.handleModelUnavailableLoadedMessagesIfNeeded(parsedHistoryMessages, "network");
                if (!filterDisplayableMessages.isEmpty()) {
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 5;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C06316(this.this$0, this.$conversationId, filterDisplayableMessages, null), (Continuation) this) == coroutine_suspended) {
                }
                this.this$0.recoverStreamingMessages();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$loadMessages$1$6", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationViewModel$loadMessages$1$6 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06316 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        final /* synthetic */ List<ChatMessage> $rawMessages;
        int label;
        final /* synthetic */ ConversationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06316(ConversationViewModel conversationViewModel, String str, List<ChatMessage> list, Continuation<? super C06316> continuation) {
            super(2, continuation);
            this.this$0 = conversationViewModel;
            this.$conversationId = str;
            this.$rawMessages = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06316(this.this$0, this.$conversationId, this.$rawMessages, continuation);
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
