package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$streamingMessageListener$1$1", f = "ConversationViewModel.kt", i = {}, l = {523}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$streamingMessageListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ParsedChatMessage $message;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$streamingMessageListener$1$1(ConversationViewModel conversationViewModel, ParsedChatMessage parsedChatMessage, Continuation<? super ConversationViewModel$streamingMessageListener$1$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationViewModel;
        this.$message = parsedChatMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$streamingMessageListener$1$1(this.this$0, this.$message, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object emitStreamingThrottled;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            z = this.this$0.isUserMessagePending;
            if (!z) {
                this.label = 1;
                emitStreamingThrottled = this.this$0.emitStreamingThrottled(this.$message, (Continuation) this);
                if (emitStreamingThrottled == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.this$0.bufferedAgentMessage = this.$message;
                TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node3] streamingListener: BUFFERED (user msg pending)");
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
