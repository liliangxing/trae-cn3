package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.FLogger;
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
/* compiled from: BrainstormActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observeMinimizeRequested$1", f = "BrainstormActivity.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormActivity$observeMinimizeRequested$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrainstormActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormActivity$observeMinimizeRequested$1(BrainstormActivity brainstormActivity, Continuation<? super BrainstormActivity$observeMinimizeRequested$1> continuation) {
        super(2, continuation);
        this.this$0 = brainstormActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormActivity$observeMinimizeRequested$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BrainstormActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observeMinimizeRequested$1$1", f = "BrainstormActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observeMinimizeRequested$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06441 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BrainstormActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06441(BrainstormActivity brainstormActivity, Continuation<? super C06441> continuation) {
            super(2, continuation);
            this.this$0 = brainstormActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06441(this.this$0, continuation);
        }

        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return create(unit, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FLogger.INSTANCE.d("BrainstormActivity", "minimizeRequested: finish without releasing session");
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
            if (FlowKt.collectLatest(brainstormViewModel.getMinimizeRequested(), new C06441(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
