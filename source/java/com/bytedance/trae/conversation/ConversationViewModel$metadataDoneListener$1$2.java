package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.repository.ConversationDetailCacheRepository;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$metadataDoneListener$1$2", f = "ConversationViewModel.kt", i = {}, l = {656, 657}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$metadataDoneListener$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $replyToMessageId;
    final /* synthetic */ ParsedChatMessage $userMessage;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$metadataDoneListener$1$2(ConversationViewModel conversationViewModel, String str, ParsedChatMessage parsedChatMessage, String str2, Continuation<? super ConversationViewModel$metadataDoneListener$1$2> continuation) {
        super(2, continuation);
        this.this$0 = conversationViewModel;
        this.$replyToMessageId = str;
        this.$userMessage = parsedChatMessage;
        this.$conversationId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$metadataDoneListener$1$2(this.this$0, this.$replyToMessageId, this.$userMessage, this.$conversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Set set;
        MutableStateFlow mutableStateFlow;
        Set set2;
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            set = this.this$0.remoteUserMessageIds;
            if (set.contains(this.$replyToMessageId)) {
                return Unit.INSTANCE;
            }
            mutableStateFlow = this.this$0._messages;
            Iterable iterable = (Iterable) mutableStateFlow.getValue();
            String str = this.$replyToMessageId;
            boolean z = false;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.areEqual(((ParsedChatMessage) it.next()).getMessageId(), str)) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                return Unit.INSTANCE;
            }
            set2 = this.this$0.remoteUserMessageIds;
            set2.add(this.$replyToMessageId);
            this.this$0.upsertMessages(CollectionsKt.listOf(this.$userMessage));
            mutableSharedFlow = this.this$0._remoteUserMessage;
            this.label = 1;
            if (mutableSharedFlow.emit(this.$userMessage, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getIO(), new C06342(this.this$0, this.$conversationId, this.$userMessage, null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$metadataDoneListener$1$2$2", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationViewModel$metadataDoneListener$1$2$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        final /* synthetic */ ParsedChatMessage $userMessage;
        int label;
        final /* synthetic */ ConversationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06342(ConversationViewModel conversationViewModel, String str, ParsedChatMessage parsedChatMessage, Continuation<? super C06342> continuation) {
            super(2, continuation);
            this.this$0 = conversationViewModel;
            this.$conversationId = str;
            this.$userMessage = parsedChatMessage;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06342(this.this$0, this.$conversationId, this.$userMessage, continuation);
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
                cacheRepository.cacheParsedMessage(this.$conversationId, this.$userMessage);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
