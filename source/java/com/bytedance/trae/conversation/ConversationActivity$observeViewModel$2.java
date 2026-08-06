package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.chat.ConversationDetailFragment;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.conversation.widget.InputFragment;
import com.bytedance.trae.conversation.widget.MenuPopupWindow;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$2", f = "ConversationActivity.kt", i = {}, l = {829}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeViewModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeViewModel$2(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeViewModel$2> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$observeViewModel$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "conversation", "Lcom/bytedance/trae/im/service/Conversation;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$2$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06111 extends SuspendLambda implements Function2<Conversation, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06111(ConversationActivity conversationActivity, Continuation<? super C06111> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06111 = new C06111(this.this$0, continuation);
            c06111.L$0 = obj;
            return c06111;
        }

        public final Object invoke(Conversation conversation, Continuation<? super Unit> continuation) {
            return create(conversation, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            InputFragment inputFragment;
            ConversationDetailFragment detailFragment;
            MenuPopupWindow menuPopupWindow;
            ConversationViewModel conversationViewModel;
            InputFragment inputFragment2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Conversation conversation = (Conversation) this.L$0;
            if (conversation != null) {
                if (Intrinsics.areEqual(conversation.getEnvironment(), CliType.IDE.getValue())) {
                    inputFragment2 = this.this$0.getInputFragment();
                    inputFragment2.setMode(ChatMode.CODE);
                } else {
                    inputFragment = this.this$0.getInputFragment();
                    inputFragment.setMode(Intrinsics.areEqual(conversation.getMode(), "code") ? ChatMode.CODE : ChatMode.MTC);
                }
                this.this$0.updateConversationTitleInfo(conversation);
                detailFragment = this.this$0.getDetailFragment();
                if (detailFragment != null) {
                    detailFragment.setConversation(conversation);
                }
                menuPopupWindow = this.this$0.menuPopupWindow;
                if (menuPopupWindow != null) {
                    conversationViewModel = this.this$0.viewModel;
                    if (conversationViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        conversationViewModel = null;
                    }
                    menuPopupWindow.updatePinState(conversationViewModel.supportsPin() && FeatureCapability.INSTANCE.isEnabled(Feature.TASK_LIST_PIN), Intrinsics.areEqual(conversation.isPinned(), Boxing.boxBoolean(true)));
                }
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
            if (FlowKt.collectLatest(conversationViewModel.getConversation(), new C06111(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
