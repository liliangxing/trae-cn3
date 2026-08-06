package coil3.intercept;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SignalRegistry.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.SignalRegistry", f = "SignalRegistry.kt", i = {0, 0, 0, 0}, l = {63}, m = "complete", n = {"key", StrategyConstants.VALUE, "segment", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SignalRegistry$complete$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SignalRegistry<K, V> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignalRegistry$complete$1(SignalRegistry<K, V> signalRegistry, Continuation<? super SignalRegistry$complete$1> continuation) {
        super(continuation);
        this.this$0 = signalRegistry;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.complete(null, null, (Continuation) this);
    }
}
