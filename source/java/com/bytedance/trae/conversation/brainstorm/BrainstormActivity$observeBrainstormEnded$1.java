package com.bytedance.trae.conversation.brainstorm;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormEndData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
/* compiled from: BrainstormActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observeBrainstormEnded$1", f = "BrainstormActivity.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormActivity$observeBrainstormEnded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrainstormActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormActivity$observeBrainstormEnded$1(BrainstormActivity brainstormActivity, Continuation<? super BrainstormActivity$observeBrainstormEnded$1> continuation) {
        super(2, continuation);
        this.this$0 = brainstormActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormActivity$observeBrainstormEnded$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BrainstormActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "endData", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observeBrainstormEnded$1$1", f = "BrainstormActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observeBrainstormEnded$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06431 extends SuspendLambda implements Function2<BrainstormEndData, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BrainstormActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06431(BrainstormActivity brainstormActivity, Continuation<? super C06431> continuation) {
            super(2, continuation);
            this.this$0 = brainstormActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06431 = new C06431(this.this$0, continuation);
            c06431.L$0 = obj;
            return c06431;
        }

        public final Object invoke(BrainstormEndData brainstormEndData, Continuation<? super Unit> continuation) {
            return create(brainstormEndData, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            BrainstormViewModel brainstormViewModel;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrainstormEndData brainstormEndData = (BrainstormEndData) this.L$0;
            if (brainstormEndData.getSummarySkippedBecauseNoContent()) {
                Toast.makeText((Context) this.this$0, C0637R.string.trae_brainstorm_empty_summary_toast, 0).show();
            }
            if (brainstormEndData.isAbort()) {
                this.this$0.setResult(0);
            } else {
                BrainstormActivity brainstormActivity = this.this$0;
                Intent intent = new Intent();
                BrainstormActivity brainstormActivity2 = this.this$0;
                intent.putExtra(BrainstormActivity.EXTRA_MESSAGES_TEXT, brainstormEndData.getMessages());
                brainstormViewModel = brainstormActivity2.viewModel;
                if (brainstormViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    brainstormViewModel = null;
                }
                intent.putExtra(BrainstormActivity.EXTRA_CLI_CONVERSATION_ID, brainstormViewModel.get_cliConversationId());
                String parentConversationId = brainstormEndData.getParentConversationId();
                if (parentConversationId != null) {
                    String str = StringsKt.isBlank(parentConversationId) ^ true ? parentConversationId : null;
                    if (str != null) {
                        intent.putExtra(BrainstormActivity.EXTRA_PARENT_CONVERSATION_ID, str);
                    }
                }
                Unit unit = Unit.INSTANCE;
                brainstormActivity.setResult(-1, intent);
            }
            this.this$0.finish();
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        BrainstormViewModel brainstormViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            brainstormViewModel = this.this$0.viewModel;
            if (brainstormViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                brainstormViewModel = null;
            }
            this.label = 1;
            if (FlowKt.collectLatest(brainstormViewModel.getBrainstormEnded(), new C06431(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
