package com.bytedance.trae.conversation.billing;

import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: BillingUpgradePromptCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class BillingUpgradePromptCoordinator$engine$3 extends FunctionReferenceImpl implements Function2<BillingUpgradePreparationMode, Continuation<? super BillingUpgradePreparationResult>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingUpgradePromptCoordinator$engine$3(Object obj) {
        super(2, obj, UserPayIdentityService.class, "fetchBillingUpgradePreparation", "fetchBillingUpgradePreparation(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation<? super BillingUpgradePreparationResult> continuation) {
        return UserPayIdentityService.fetchBillingUpgradePreparation(billingUpgradePreparationMode, continuation);
    }
}
