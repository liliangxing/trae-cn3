package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mutex.kt */
@Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 176)
@DebugMetadata(m41c = "kotlinx.coroutines.sync.MutexKt", m42f = "Mutex.kt", m43i = {0, 0, 0}, m44l = {120}, m45m = "withLock", m46n = {"$this$withLock", "owner", "action"}, m47s = {"L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class MutexKt$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MutexKt.withLock(null, null, null, this);
    }
}
