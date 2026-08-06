package com.bytedance.trae.conversation;

import android.view.View;
import com.bytedance.trae.conversation.chat.ConversationDetailFragment;
import com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.widget.InputFragment;
import com.bytedance.trae.im.service.Conversation;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$18", f = "ConversationActivity.kt", i = {}, l = {1082}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeViewModel$18 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeViewModel$18(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeViewModel$18> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$observeViewModel$18(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "conversation", "Lcom/bytedance/trae/im/service/Conversation;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$18$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$18$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06091 extends SuspendLambda implements Function2<Conversation, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06091(ConversationActivity conversationActivity, Continuation<? super C06091> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06091 = new C06091(this.this$0, continuation);
            c06091.L$0 = obj;
            return c06091;
        }

        public final Object invoke(Conversation conversation, Continuation<? super Unit> continuation) {
            return create(conversation, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            InputFragment inputFragment;
            InputFragment inputFragment2;
            TraeActivityConversationBinding traeActivityConversationBinding;
            TraeActivityConversationBinding traeActivityConversationBinding2;
            ConversationDetailFragment detailFragment;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Conversation conversation = (Conversation) this.L$0;
                this.this$0.hideWelcomeScreen();
                inputFragment = this.this$0.getInputFragment();
                inputFragment.setConversationId(conversation.getId());
                inputFragment2 = this.this$0.getInputFragment();
                inputFragment2.switchInputState(InputFragment.InputState.Sended);
                traeActivityConversationBinding = this.this$0.binding;
                if (traeActivityConversationBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding = null;
                }
                traeActivityConversationBinding.btnOperationIcon.setVisibility(8);
                traeActivityConversationBinding2 = this.this$0.binding;
                if (traeActivityConversationBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding2 = null;
                }
                traeActivityConversationBinding2.btnOperationIcon.setOnClickListener((View.OnClickListener) null);
                this.this$0.updateConversationTitleInfo(conversation);
                detailFragment = this.this$0.getDetailFragment();
                if (detailFragment != null) {
                    detailFragment.setTask();
                }
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
            if (FlowKt.collectLatest(conversationViewModel.getCreateTask(), new C06091(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
