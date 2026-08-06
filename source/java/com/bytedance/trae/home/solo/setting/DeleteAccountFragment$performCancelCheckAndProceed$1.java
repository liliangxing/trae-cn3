package com.bytedance.trae.home.solo.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeleteAccountFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.DeleteAccountFragment", f = "DeleteAccountFragment.kt", i = {0}, l = {426}, m = "performCancelCheckAndProceed", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteAccountFragment$performCancelCheckAndProceed$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeleteAccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteAccountFragment$performCancelCheckAndProceed$1(DeleteAccountFragment deleteAccountFragment, Continuation<? super DeleteAccountFragment$performCancelCheckAndProceed$1> continuation) {
        super(continuation);
        this.this$0 = deleteAccountFragment;
    }

    public final Object invokeSuspend(Object obj) {
        Object performCancelCheckAndProceed;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        performCancelCheckAndProceed = this.this$0.performCancelCheckAndProceed((Continuation) this);
        return performCancelCheckAndProceed;
    }
}
