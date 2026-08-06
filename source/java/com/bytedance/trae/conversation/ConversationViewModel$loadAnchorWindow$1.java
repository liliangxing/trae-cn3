package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$loadAnchorWindow$1", f = "ConversationViewModel.kt", i = {}, l = {1014}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$loadAnchorWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $anchorCreatedAtMs;
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$loadAnchorWindow$1(ConversationViewModel conversationViewModel, String str, String str2, Continuation<? super ConversationViewModel$loadAnchorWindow$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationViewModel;
        this.$conversationId = str;
        this.$anchorCreatedAtMs = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$loadAnchorWindow$1(this.this$0, this.$conversationId, this.$anchorCreatedAtMs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        List parsedHistoryMessages;
        List mergeMessages;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        boolean hasLoadedOlderSide;
        MutableStateFlow mutableStateFlow4;
        boolean hasLoadedNewerSide;
        MutableStateFlow mutableStateFlow5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.this$0.loadAnchorMessagesByCreatedAt(this.$conversationId, this.$anchorCreatedAtMs, 5, 5, true, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            if (list != null) {
                parsedHistoryMessages = this.this$0.toParsedHistoryMessages(list);
                ConversationViewModel conversationViewModel = this.this$0;
                mergeMessages = conversationViewModel.mergeMessages(CollectionsKt.emptyList(), parsedHistoryMessages);
                conversationViewModel.setMessages(mergeMessages);
                mutableStateFlow2 = this.this$0._hasMoreMessages;
                ConversationViewModel conversationViewModel2 = this.this$0;
                mutableStateFlow3 = conversationViewModel2._messages;
                hasLoadedOlderSide = conversationViewModel2.hasLoadedOlderSide((List) mutableStateFlow3.getValue(), this.$anchorCreatedAtMs, 4);
                mutableStateFlow2.setValue(Boxing.boxBoolean(hasLoadedOlderSide));
                ConversationViewModel conversationViewModel3 = this.this$0;
                mutableStateFlow4 = conversationViewModel3._messages;
                hasLoadedNewerSide = conversationViewModel3.hasLoadedNewerSide((List) mutableStateFlow4.getValue(), this.$anchorCreatedAtMs, 4);
                conversationViewModel3.hasMoreNewerAnchorMessages = hasLoadedNewerSide;
                mutableStateFlow5 = this.this$0._isAnchorWindowLoading;
                mutableStateFlow5.setValue(Boxing.boxBoolean(false));
                this.this$0.prefetchLatestMessages(this.$conversationId);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } finally {
            mutableStateFlow = this.this$0._isAnchorWindowLoading;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
        }
    }
}
