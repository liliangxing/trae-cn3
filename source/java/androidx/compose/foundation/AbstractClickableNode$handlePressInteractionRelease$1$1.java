package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteractionRelease$1$1", f = "Clickable.kt", i = {1}, l = {1676, 1681, 1682}, m = "invokeSuspend", n = {"release"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AbstractClickableNode$handlePressInteractionRelease$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    Object L$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickableNode$handlePressInteractionRelease$1$1(AbstractClickableNode abstractClickableNode, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super AbstractClickableNode$handlePressInteractionRelease$1$1> continuation) {
        super(2, continuation);
        this.this$0 = abstractClickableNode;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbstractClickableNode$handlePressInteractionRelease$1$1(this.this$0, this.$offset, this.$interactionSource, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0070 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job job;
        PressInteraction.Release release;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            job = this.this$0.delayJob;
            if (job != null) {
                this.label = 1;
                if (JobKt.cancelAndJoin(job, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                release = (PressInteraction.Release) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = 3;
                if (this.$interactionSource.emit(release, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        PressInteraction.Press press = new PressInteraction.Press(this.$offset, null);
        release = new PressInteraction.Release(press);
        this.L$0 = release;
        this.label = 2;
        if (this.$interactionSource.emit(press, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.L$0 = null;
        this.label = 3;
        if (this.$interactionSource.emit(release, (Continuation) this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
