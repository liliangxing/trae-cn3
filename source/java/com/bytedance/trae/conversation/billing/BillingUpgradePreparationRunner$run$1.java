package com.bytedance.trae.conversation.billing;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingUpgradePreparation.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.billing.BillingUpgradePreparationRunner", f = "BillingUpgradePreparation.kt", i = {0, 0, 1, 2, 3, 3}, l = {83, 95, 109, 118}, m = "run", n = {"this", "mode", "this", "this", "this", "userState"}, s = {"L$0", "L$1", "L$0", "L$0", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BillingUpgradePreparationRunner$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BillingUpgradePreparationRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingUpgradePreparationRunner$run$1(BillingUpgradePreparationRunner billingUpgradePreparationRunner, Continuation<? super BillingUpgradePreparationRunner$run$1> continuation) {
        super(continuation);
        this.this$0 = billingUpgradePreparationRunner;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run(null, (Continuation) this);
    }
}
