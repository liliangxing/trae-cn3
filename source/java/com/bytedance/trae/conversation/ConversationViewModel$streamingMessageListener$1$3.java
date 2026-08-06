package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.repository.ConversationDetailCacheRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$streamingMessageListener$1$3", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$streamingMessageListener$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ParsedChatMessage $message;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$streamingMessageListener$1$3(ConversationViewModel conversationViewModel, ParsedChatMessage parsedChatMessage, Continuation<? super ConversationViewModel$streamingMessageListener$1$3> continuation) {
        super(2, continuation);
        this.this$0 = conversationViewModel;
        this.$message = parsedChatMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$streamingMessageListener$1$3(this.this$0, this.$message, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        ConversationDetailCacheRepository cacheRepository;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._conversationId;
            String str = (String) mutableStateFlow.getValue();
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                cacheRepository = this.this$0.getCacheRepository();
                cacheRepository.cacheParsedMessage(str, this.$message);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
