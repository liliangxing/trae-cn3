package com.bytedance.kmp.network.nqe;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NQEListenerManager.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.nqe.NQEListenerManager", f = "NQEListenerManager.kt", i = {0, 0}, l = {185}, m = "registerListener", n = {"listener", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NQEListenerManager$registerListener$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NQEListenerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NQEListenerManager$registerListener$1(NQEListenerManager nQEListenerManager, Continuation<? super NQEListenerManager$registerListener$1> continuation) {
        super(continuation);
        this.this$0 = nQEListenerManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerListener(null, (Continuation) this);
    }
}
