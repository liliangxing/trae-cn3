package androidx.compose.p001ui.platform;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: InfiniteAnimationPolicy.kt */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, d2 = {"<anonymous>", "R"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2", f = "InfiniteAnimationPolicy.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2<R> extends SuspendLambda implements Function1<Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Long, R> $onFrame;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2(Function1<? super Long, ? extends R> function1, Continuation<? super InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2> continuation) {
        super(1, continuation);
        this.$onFrame = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2<>(this.$onFrame, continuation);
    }

    public final Object invoke(Continuation<? super R> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = MonotonicFrameClockKt.withFrameNanos(this.$onFrame, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
