package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.service.IMMessageKt;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$8", f = "ConversationActivity.kt", i = {}, l = {908}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeViewModel$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeViewModel$8(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeViewModel$8> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$observeViewModel$8(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$8$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$8$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06221 extends SuspendLambda implements Function2<ParsedChatMessage, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06221(ConversationActivity conversationActivity, Continuation<? super C06221> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06221 = new C06221(this.this$0, continuation);
            c06221.L$0 = obj;
            return c06221;
        }

        public final Object invoke(ParsedChatMessage parsedChatMessage, Continuation<? super Unit> continuation) {
            return create(parsedChatMessage, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z;
            TraeActivityConversationBinding traeActivityConversationBinding;
            List<ParsedPlanItemMessage> messages;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ParsedChatMessage parsedChatMessage = (ParsedChatMessage) this.L$0;
            boolean z2 = true;
            if (parsedChatMessage.getMessageId().length() > 0) {
                this.this$0.streamingMessageId = parsedChatMessage.getMessageId();
            }
            String streamingChatModel = parsedChatMessage.getStreamingChatModel();
            if (streamingChatModel != null) {
                this.this$0.streamingChatModel = streamingChatModel;
            }
            ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
            TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node4] Activity.streaming: planItemCount=" + ((taskContent == null || (messages = taskContent.getMessages()) == null) ? 0 : messages.size()) + ", status=" + parsedChatMessage.getStatus() + ", isHistory=" + parsedChatMessage.isHistory());
            String taskId = IMMessageKt.getTaskId(parsedChatMessage);
            if (taskId != null && taskId.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                try {
                    ConversationActivity conversationActivity = this.this$0;
                    String taskId2 = IMMessageKt.getTaskId(parsedChatMessage);
                    Intrinsics.checkNotNull(taskId2);
                    conversationActivity.checkConfirmRequired(parsedChatMessage, taskId2, parsedChatMessage.getSessionId());
                } catch (Exception e) {
                    FLogger.INSTANCE.e("CheckPointDialog", "streamingMessage: checkConfirmRequired error: " + e);
                    z = this.this$0.isCheckpointDialogVisible;
                    if (!z) {
                        try {
                            traeActivityConversationBinding = this.this$0.binding;
                            if (traeActivityConversationBinding == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                traeActivityConversationBinding = null;
                            }
                            traeActivityConversationBinding.inputFragmentContainer.setVisibility(0);
                        } catch (Exception unused) {
                        }
                    }
                }
            } else {
                FLogger.INSTANCE.w("CheckPointDialog", "streamingMessage: taskId is null");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        ConversationViewModel conversationViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            conversationViewModel = this.this$0.viewModel;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            this.label = 1;
            if (FlowKt.collectLatest(conversationViewModel.getStreamingMessage(), new C06221(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
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
