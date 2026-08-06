package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.ConversationActivity$observeViewModel$4;
import com.bytedance.trae.conversation.chat.ConversationDetailFragment;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$4", f = "ConversationActivity.kt", i = {}, l = {852}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeViewModel$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeViewModel$4(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeViewModel$4> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$observeViewModel$4(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "messages", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$4$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$4$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06181 extends SuspendLambda implements Function2<List<? extends ParsedChatMessage>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06181(ConversationActivity conversationActivity, Continuation<? super C06181> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06181 = new C06181(this.this$0, continuation);
            c06181.L$0 = obj;
            return c06181;
        }

        public final Object invoke(List<ParsedChatMessage> list, Continuation<? super Unit> continuation) {
            return create(list, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
        
            r0 = r7.this$0.getDetailFragment();
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
        
            if ((!r3) != false) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            final String str;
            boolean z;
            ConversationDetailFragment detailFragment;
            String str2;
            ConversationDetailFragment detailFragment2;
            boolean z2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<ParsedChatMessage> list = (List) this.L$0;
                str = this.this$0.anchorCreatedAtMs;
                boolean z3 = true;
                if (str != null) {
                    z2 = this.this$0.hasScrolledToAnchorCreatedAt;
                }
                str = null;
                z = this.this$0.snapToBottomAfterLatestPageSubmit;
                int i = 0;
                final boolean z4 = z && (list.isEmpty() ^ true);
                detailFragment = this.this$0.getDetailFragment();
                if (detailFragment != null) {
                    final ConversationActivity conversationActivity = this.this$0;
                    detailFragment.submitMessages(list, z4, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = ConversationActivity$observeViewModel$4.C06181.invokeSuspend$lambda$2(ConversationActivity.this, z4, str);
                            return invokeSuspend$lambda$2;
                        }
                    });
                }
                if (!list.isEmpty()) {
                    str2 = this.this$0.anchorCreatedAtMs;
                    String str3 = str2;
                    if (str3 != null && !StringsKt.isBlank(str3)) {
                        z3 = false;
                    }
                    if (!z3 && detailFragment2 != null) {
                        detailFragment2.setAnchorLoading(false);
                    }
                    List<ParsedChatMessage> list2 = list;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            if (((ParsedChatMessage) it.next()).isAssistantMessage() && (i = i + 1) < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                    }
                    TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node4] Activity.messages: total=" + list.size() + ", agentCount=" + i);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(ConversationActivity conversationActivity, boolean z, String str) {
            ConversationViewModel conversationViewModel;
            ConversationDetailFragment detailFragment;
            conversationViewModel = conversationActivity.viewModel;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            conversationViewModel.onMessageListCommitComplete();
            boolean z2 = false;
            if (z) {
                conversationActivity.snapToBottomAfterLatestPageSubmit = false;
            } else if (str != null) {
                detailFragment = conversationActivity.getDetailFragment();
                if (detailFragment != null && detailFragment.scrollToCreatedAt(str)) {
                    z2 = true;
                }
                if (z2) {
                    conversationActivity.hasScrolledToAnchorCreatedAt = true;
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
            if (FlowKt.collectLatest(conversationViewModel.getMessages(), new C06181(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
