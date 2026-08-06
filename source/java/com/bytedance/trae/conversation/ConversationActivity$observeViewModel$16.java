package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.widget.InputFragment;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.track.AgentMonitor;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$16", f = "ConversationActivity.kt", i = {}, l = {1052}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeViewModel$16 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeViewModel$16(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeViewModel$16> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$observeViewModel$16(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "<destruct>", "Lkotlin/Pair;", "Lcom/bytedance/trae/im/model/ParsedChatMessage;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$16$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$16$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06071 extends SuspendLambda implements Function2<Pair<? extends ParsedChatMessage, ? extends ParsedChatMessage>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06071(ConversationActivity conversationActivity, Continuation<? super C06071> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06071 = new C06071(this.this$0, continuation);
            c06071.L$0 = obj;
            return c06071;
        }

        public final Object invoke(Pair<ParsedChatMessage, ParsedChatMessage> pair, Continuation<? super Unit> continuation) {
            return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            InputFragment inputFragment;
            InputFragment inputFragment2;
            InputFragment inputFragment3;
            TraeActivityConversationBinding traeActivityConversationBinding;
            TraeActivityConversationBinding traeActivityConversationBinding2;
            TraeActivityConversationBinding traeActivityConversationBinding3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                ParsedChatMessage parsedChatMessage = (ParsedChatMessage) pair.component1();
                this.this$0.hideWelcomeScreen();
                inputFragment = this.this$0.getInputFragment();
                inputFragment.clearInput();
                inputFragment2 = this.this$0.getInputFragment();
                inputFragment2.setBottomContextualBarVisible(false);
                inputFragment3 = this.this$0.getInputFragment();
                inputFragment3.setDeviceFolderBarVisible(false);
                traeActivityConversationBinding = this.this$0.binding;
                TraeActivityConversationBinding traeActivityConversationBinding4 = null;
                if (traeActivityConversationBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding = null;
                }
                traeActivityConversationBinding.titleBar.showConversationDetailHeader();
                traeActivityConversationBinding2 = this.this$0.binding;
                if (traeActivityConversationBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding2 = null;
                }
                if (traeActivityConversationBinding2.titleBar.getTitleText().length() == 0) {
                    traeActivityConversationBinding3 = this.this$0.binding;
                    if (traeActivityConversationBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        traeActivityConversationBinding4 = traeActivityConversationBinding3;
                    }
                    traeActivityConversationBinding4.titleBar.setConversationDetailTitle(this.this$0.getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_new_task));
                }
                AgentMonitor agentMonitor = AgentMonitor.INSTANCE;
                String taskIdUser = parsedChatMessage.getTaskIdUser();
                if (taskIdUser == null) {
                    taskIdUser = "";
                }
                agentMonitor.onUserMessageSuccess(taskIdUser, parsedChatMessage.getSessionId());
                this.this$0.flushPendingTriggerTracker(parsedChatMessage.getSessionId(), parsedChatMessage.getMessageId());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
            if (FlowKt.collectLatest(conversationViewModel.getSendMessageSuccess(), new C06071(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
