package com.bytedance.trae.conversation.brainstorm.fragment;

import com.bytedance.trae.conversation.brainstorm.BrainstormViewModel;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiscussingFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$observeState$1", f = "DiscussingFragment.kt", i = {}, l = {975}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DiscussingFragment$observeState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiscussingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscussingFragment$observeState$1(DiscussingFragment discussingFragment, Continuation<? super DiscussingFragment$observeState$1> continuation) {
        super(2, continuation);
        this.this$0 = discussingFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiscussingFragment$observeState$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiscussingFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "state", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$observeState$1$1", f = "DiscussingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$observeState$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06721 extends SuspendLambda implements Function2<BrainstormUiState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DiscussingFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06721(DiscussingFragment discussingFragment, Continuation<? super C06721> continuation) {
            super(2, continuation);
            this.this$0 = discussingFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06721 = new C06721(this.this$0, continuation);
            c06721.L$0 = obj;
            return c06721;
        }

        public final Object invoke(BrainstormUiState brainstormUiState, Continuation<? super Unit> continuation) {
            return create(brainstormUiState, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BrainstormUiState brainstormUiState = (BrainstormUiState) this.L$0;
                this.this$0.updateTimer(brainstormUiState);
                this.this$0.updateTimeoutState(brainstormUiState.getTimeoutState(), brainstormUiState.getTimeoutRemainingSeconds());
                this.this$0.updateMicUi(brainstormUiState.isMicMuted());
                this.this$0.updateParticipantStates(brainstormUiState);
                this.this$0.updateAiDisplay(brainstormUiState);
                this.this$0.updateContentMode(brainstormUiState.isSubtitleMode());
                this.this$0.updateSubtitleListIfNeeded(brainstormUiState);
                this.this$0.updateWaveformAnimating(brainstormUiState.isRtcJoined());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
            if (FlowKt.collectLatest(brainstormViewModel.getUiState(), new C06721(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
