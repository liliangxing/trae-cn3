package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;

/* compiled from: MouseWheelScrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$busyReceive$2", f = "MouseWheelScrollable.kt", i = {0}, l = {170}, m = "invokeSuspend", n = {"job"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class MouseWheelScrollingLogic$busyReceive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MouseWheelScrollingLogic.MouseWheelScrollDelta>, Object> {
    final /* synthetic */ Channel<MouseWheelScrollingLogic.MouseWheelScrollDelta> $this_busyReceive;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollingLogic$busyReceive$2(Channel<MouseWheelScrollingLogic.MouseWheelScrollDelta> channel, Continuation<? super MouseWheelScrollingLogic$busyReceive$2> continuation) {
        super(2, continuation);
        this.$this_busyReceive = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> mouseWheelScrollingLogic$busyReceive$2 = new MouseWheelScrollingLogic$busyReceive$2(this.$this_busyReceive, continuation);
        mouseWheelScrollingLogic$busyReceive$2.L$0 = obj;
        return mouseWheelScrollingLogic$busyReceive$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MouseWheelScrollingLogic.MouseWheelScrollDelta> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Job job;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job launch$default = BuildersKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new MouseWheelScrollingLogic$busyReceive$2$job$1(null), 3, (Object) null);
            try {
                this.L$0 = launch$default;
                this.label = 1;
                Object receive = this.$this_busyReceive.receive((Continuation) this);
                if (receive == coroutine_suspended) {
                    return coroutine_suspended;
                }
                job = launch$default;
                obj = receive;
            } catch (Throwable th2) {
                job = launch$default;
                th = th2;
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                throw th;
            }
        }
        MouseWheelScrollingLogic.MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollingLogic.MouseWheelScrollDelta) obj;
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        return mouseWheelScrollDelta;
    }
}
