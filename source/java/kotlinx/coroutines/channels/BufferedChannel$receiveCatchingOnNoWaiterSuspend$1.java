package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import me.ele.lancet.base.annotations.ClassOf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BufferedChannel.kt */
@Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
@DebugMetadata(m41c = "kotlinx.coroutines.channels.BufferedChannel", m42f = "BufferedChannel.kt", m43i = {0, 0, 0, 0}, m44l = {3087}, m45m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m46n = {"this", "segment", ClassOf.INDEX, "r"}, m47s = {"L$0", "L$1", "I$0", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1883receiveCatchingOnNoWaiterSuspendGKJJFZk;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m1883receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m1883receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return m1883receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1883receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m1891boximpl(m1883receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
