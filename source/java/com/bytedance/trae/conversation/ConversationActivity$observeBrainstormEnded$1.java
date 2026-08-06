package com.bytedance.trae.conversation;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder;
import com.bytedance.trae.conversation.brainstorm.EndReason;
import com.bytedance.trae.conversation.brainstorm.HolderEndData;
import com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeBrainstormEnded$1", f = "ConversationActivity.kt", i = {}, l = {2795}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeBrainstormEnded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeBrainstormEnded$1(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeBrainstormEnded$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$observeBrainstormEnded$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "endData", "Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeBrainstormEnded$1$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeBrainstormEnded$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C05971 extends SuspendLambda implements Function2<HolderEndData, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05971(ConversationActivity conversationActivity, Continuation<? super C05971> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c05971 = new C05971(this.this$0, continuation);
            c05971.L$0 = obj;
            return c05971;
        }

        public final Object invoke(HolderEndData holderEndData, Continuation<? super Unit> continuation) {
            return create(holderEndData, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
        public final Object invokeSuspend(Object obj) {
            boolean z;
            Mode mode;
            Mode mode2;
            ConversationViewModel conversationViewModel;
            ConversationViewModel conversationViewModel2;
            TraeActivityConversationBinding traeActivityConversationBinding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            HolderEndData holderEndData = (HolderEndData) this.L$0;
            FLogger.INSTANCE.d("ConversationActivity", "holder.ended received: reason=" + holderEndData.getReason() + ", isAbort=" + holderEndData.isAbort());
            if (holderEndData.getSummarySkippedBecauseNoContent()) {
                Toast.makeText((Context) this.this$0, C0637R.string.trae_brainstorm_empty_summary_toast, 0).show();
            }
            if (!holderEndData.isAbort()) {
                z = this.this$0.isNewConversation;
                ConversationViewModel conversationViewModel3 = null;
                if (z) {
                    traeActivityConversationBinding = this.this$0.binding;
                    if (traeActivityConversationBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        traeActivityConversationBinding = null;
                    }
                    mode2 = traeActivityConversationBinding.titleBar.getSegmentedSelectedIndex() == 0 ? Mode.WORK : Mode.CODE;
                } else {
                    Iterable entries = Mode.getEntries();
                    ConversationActivity conversationActivity = this.this$0;
                    Iterator it = entries.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            mode = 0;
                            break;
                        }
                        mode = it.next();
                        String value = ((Mode) mode).getValue();
                        conversationViewModel = conversationActivity.viewModel;
                        if (conversationViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            conversationViewModel = null;
                        }
                        Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
                        if (Intrinsics.areEqual(value, conversation != null ? conversation.getMode() : null)) {
                            break;
                        }
                    }
                    mode2 = mode;
                    if (mode2 == null) {
                        mode2 = Mode.WORK;
                    }
                }
                String cliConversationId = holderEndData.getCliConversationId();
                String messages = holderEndData.getMessages();
                if (!(messages == null || StringsKt.isBlank(messages))) {
                    String str = cliConversationId;
                    if (!(str == null || StringsKt.isBlank(str))) {
                        conversationViewModel2 = this.this$0.viewModel;
                        if (conversationViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            conversationViewModel3 = conversationViewModel2;
                        }
                        conversationViewModel3.handleBrainstormResult(holderEndData.getMessages(), mode2, cliConversationId, holderEndData.getParentConversationId());
                    }
                }
                FLogger.INSTANCE.w("ConversationActivity", "holder.ended: skip handle due to blank messages/cliCnvId");
            }
            if (holderEndData.getReason() != EndReason.UserBackInConversation) {
                this.this$0.finish();
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.collectLatest(BrainstormSessionHolder.INSTANCE.getEnded(), new C05971(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
